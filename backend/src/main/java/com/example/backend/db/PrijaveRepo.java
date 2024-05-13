package com.example.backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrijaveRepo implements PrijaveRepoInterface {

    @Override
    public boolean postojiPrijava(String username, int idAkt) {

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * from prijave where student = ? and aktivnost = ?");) {

            stmt.setString(1, username);
            stmt.setInt(2, idAkt);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean prijaviAktivnost(String username, int idAkt, int brSale) {
        String sala = "Sala" + brSale;
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtInsert = conn
                        .prepareStatement("insert into prijave (student, aktivnost, sala) values (?, ?, ?)");
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update aktivnosti set " + sala + " = " + sala + " - 1 where id = ?")) {

            stmtInsert.setString(1, username);
            stmtInsert.setInt(2, idAkt);
            stmtInsert.setString(3, "sala" + brSale);
            int insertRes = stmtInsert.executeUpdate();

            stmtUpdate.setInt(1, idAkt);
            int updateRes = stmtUpdate.executeUpdate();

            return insertRes > 0 && updateRes > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
