package com.example.backend.db;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

import com.example.backend.models.User;
import com.example.backend.models.UserLogin;

import jakarta.annotation.Resource;

public class UserRepo {
    private final Path root = Paths.get("uploads");

    public UserRepo() {
        init();
    }

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public UserLogin login(UserLogin user) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn
                        .prepareStatement("select * from users where username = ? and password = ?")) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                return new UserLogin(
                        res.getString("username"),
                        res.getString("password"),
                        res.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean register(User user) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement(
                                """
                                        INSERT INTO `users` (`username`, `password`, `question`, `answer`, `name`, `lastname`, `gender`, `address`, `phone`, `mail`, `image`, `card`, `type`)
                                        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                                            """)) {

            stmtUpdate.setString(1, user.getUsername());
            stmtUpdate.setString(1, user.getPassword());
            stmtUpdate.setString(1, user.getQuestion());
            stmtUpdate.setString(1, user.getAnswer());
            stmtUpdate.setString(1, user.getName());
            stmtUpdate.setString(1, user.getLastname());
            stmtUpdate.setString(1, user.getGender());
            stmtUpdate.setString(1, user.getAddress());
            stmtUpdate.setString(1, user.getPhone());
            stmtUpdate.setString(1, user.getMail());
            stmtUpdate.setString(1, user.getImage());
            stmtUpdate.setString(1, user.getCCard());
            stmtUpdate.setString(1, user.getType());

            return stmtUpdate.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public User getUserData(UserLogin user) {
        User userData = null;
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("question"),
                        rs.getString("answer"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("mail"),
                        rs.getString("image"),
                        rs.getString("card"),
                        rs.getString("type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean handleFileUpload(MultipartFile file) { // String username,
        System.out.println(file);
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                System.out.println("err");
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("uspesno");
        return true;
    }

    // public Resource load(String filename) {
    // try {
    // Path file = root.resolve(filename);
    // Resource resource = new UrlResource(file.toUri());

    // if (resource.exists() || resource.isReadable()) {
    // return resource;
    // } else {
    // throw new RuntimeException("Could not read the file!");
    // }
    // } catch (MalformedURLException e) {
    // throw new RuntimeException("Error: " + e.getMessage());
    // }
    // }

    // change password!
}
