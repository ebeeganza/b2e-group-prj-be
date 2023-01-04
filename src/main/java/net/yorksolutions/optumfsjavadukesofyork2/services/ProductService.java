package net.yorksolutions.optumfsjavadukesofyork2.services;

import net.yorksolutions.optumfsjavadukesofyork2.models.Price;
import net.yorksolutions.optumfsjavadukesofyork2.models.Product;
import net.yorksolutions.optumfsjavadukesofyork2.repositories.PriceRepository;
import net.yorksolutions.optumfsjavadukesofyork2.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductService(ProductRepository productRepository, PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void createProduct(Product requestProduct) throws Exception {
        // add logic to check if it exists already
        final var newProduct = new Product();
        copy(requestProduct, newProduct);
        productRepository.save(newProduct);
    }

    public void updateProduct(Long id, Product requestProduct) {
        final var updateProduct = productRepository.findById(id).orElseThrow();
        copy(requestProduct, updateProduct);
        productRepository.save(updateProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow();
        productRepository.deleteById(id);
    }

    // copies fields in arg 1 to fields in arg 2
    private void copy(Product requestProduct, Product updateProduct) {
        final var allPrices = new ArrayList<Price>();
        allPrices.addAll(requestProduct.scheduledPrices);
        allPrices.addAll(requestProduct.scheduledMaps);
        // all prices must be positive
        for (Price p : allPrices) {
            if (p.price <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
        updateProduct.name = requestProduct.name;
        updateProduct.category = requestProduct.category;
        updateProduct.availability = requestProduct.availability;
        updateProduct.description = requestProduct.description;
        updateProduct.discontinued = requestProduct.discontinued;
        updateProduct.image = requestProduct.image;
        updateProduct.scheduledMaps = requestProduct.scheduledMaps;
        updateProduct.scheduledPrices = requestProduct.scheduledPrices;
        updateProduct.scheduledSales = requestProduct.scheduledSales;
        updateProduct.shipments = requestProduct.shipments;
    }
}
