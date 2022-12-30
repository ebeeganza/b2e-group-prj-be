package net.yorksolutions.optumfsjavadukesofyork2.models;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public Long productId;
    public Long quantity;
    public Double cost;

    public LocalDate date;
}
