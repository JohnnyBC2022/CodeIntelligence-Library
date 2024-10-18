package com.example.biblioteca.models;


import jakarta.persistence.*;



@Entity
@Table(name = "MEMBER")
public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMember;

    private String dni;

    private String address;

    private String phone;

    public Integer getIdMember() {
        return idMember;
    }

    public void setIdMember(Integer idMember) {
        this.idMember = idMember;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public MemberModel() {
    }

    public MemberModel(Integer idMember, String dni, String address, String phone) {
        this.idMember = idMember;
        this.dni = dni;
        this.address = address;
        this.phone = phone;
    }
}
