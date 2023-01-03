package net.yorksolutions.optumfsjavadukesofyork2.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String name;
    @OneToOne
    public Category category;
    public Double price;
    public LocalDate availabilityDate;
    public String description;
    public boolean discontinued;
    public String images;
    @OneToMany
    public List<Price> scheduledMaps;
    @OneToMany
    public List<Price> scheduledPrices;
    @OneToMany
    public List<Price> scheduledSales;
    @OneToMany
    public List<Shipment> shipments;
}
