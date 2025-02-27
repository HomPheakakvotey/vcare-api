package vcare.vcare.service;

import vcare.vcare.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(String id);
    Product updateProduct(String id, Product product);
    void deleteProduct(String id);
}
