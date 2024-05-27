package com.example.backend.models;

public class User {
    private String username = "";
    private String password = "";
    private String question = "";
    private String answer = "";
    private String name = "";
    private String lastname = "";
    private String gender = "";
    private String address = "";
    private String phone = "";
    private String mail = "";
    private String image = "";
    private String cCard = "";
    private String type = "";

    public User(String username, String password, String question, String answer, String name, String lastname,
            String gender, String address, String phone, String mail, String image, String cCard, String type) {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.image = image;
        this.cCard = cCard;
        this.type = type;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCCard() {
        return cCard;
    }

    public void setCCard(String cCard) {
        this.cCard = cCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
