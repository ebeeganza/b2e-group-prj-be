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
        copy(requestProduct, newProduct);
        return productRepository.save(newProduct);
    }

    public Product updateProduct(Long id, Product requestProduct) {
        final var updateProduct = productRepository.findById(id).orElseThrow();
        copy(requestProduct, updateProduct);
        return productRepository.save(updateProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow();
        productRepository.deleteById(id);
    }

    // copies fields in arg 1 to fields in arg 2
    private void copy(Product requestProduct, Product updateProduct) {
        updateProduct.name = requestProduct.name;
        updateProduct.category = requestProduct.category;
        updateProduct.availabilityDate = requestProduct.availabilityDate;
        updateProduct.description = requestProduct.description;
        updateProduct.discontinued = requestProduct.discontinued;
        updateProduct.images = requestProduct.images;
        updateProduct.scheduledMaps = requestProduct.scheduledMaps;
        updateProduct.scheduledPrices = requestProduct.scheduledPrices;
        updateProduct.scheduledSales = requestProduct.scheduledSales;
        updateProduct.shipments = requestProduct.shipments;
    }
}
