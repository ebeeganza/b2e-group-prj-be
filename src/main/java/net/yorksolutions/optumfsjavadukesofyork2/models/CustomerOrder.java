package net.yorksolutions.optumfsjavadukesofyork2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    // Discuss which userid will be used for guest customers
    public Long userId;
    public LocalDate date;

    // This will require a relational set-up
    public String products;
}
