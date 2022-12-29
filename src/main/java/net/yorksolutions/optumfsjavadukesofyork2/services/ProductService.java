package net.yorksolutions.optumfsjavadukesofyork2.services;

import net.yorksolutions.optumfsjavadukesofyork2.models.Product;
import net.yorksolutions.optumfsjavadukesofyork2.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product createProduct(Product requestProduct) {
        // add logic to check if it exists already
        final var newProduct = new Product();
        newProduct.id = null;
        newProduct.name = requestProduct.name;
        newProduct.category = requestProduct.category;
        newProduct.price = requestProduct.price;
        newProduct.availabilityDate = requestProduct.availabilityDate;
        newProduct.description = requestProduct.description;
        newProduct.discontinued = requestProduct.discontinued;
        newProduct.images = requestProduct.images;
        newProduct.scheduledMaps = requestProduct.scheduledMaps;
        newProduct.scheduledPrices = requestProduct.scheduledPrices;
        newProduct.scheduledSales = requestProduct.scheduledSales;
        newProduct.shipmentCost = requestProduct.shipmentCost;
        return productRepository.save(newProduct);
    }
}
