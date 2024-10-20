package com.example.biblioteca.models;

import java.util.List;

public class UserDto {
    private int id;
    private String firsName;
    private String lastName;
    private String mail;
    private String username;
    private String password;
    private Role role;
    private List<Token> tokens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public UserDto() {
    }

    public UserDto(int id, String firsName, String lastName, String mail, String username, String password, Role role, List<Token> tokens) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.role = role;
        this.tokens = tokens;
    }
}
