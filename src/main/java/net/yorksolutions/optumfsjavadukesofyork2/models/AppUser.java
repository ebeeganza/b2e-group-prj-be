package net.yorksolutions.optumfsjavadukesofyork2.models;

import jakarta.persistence.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String fname;
    public String lname;
    public String username;
    public String password;
    public Integer role;


}
