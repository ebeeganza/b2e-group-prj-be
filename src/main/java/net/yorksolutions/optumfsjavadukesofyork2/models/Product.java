package net.yorksolutions.optumfsjavadukesofyork2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String name;
    public Double price;
    public LocalDate date;
    public String description;
    public boolean discontinued;
    public String images; // needs to be updated later
    public String ScheduledMaps; // needs to be updated later
    public String ScheduledPrices; // needs to be updated later
    public String ScheduledSales; // needs to be updated later
    public String shipmentCost; // needs to be updated later
}
