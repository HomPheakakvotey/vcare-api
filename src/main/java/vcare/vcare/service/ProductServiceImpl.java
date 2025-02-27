package vcare.vcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import vcare.vcare.model.Product;
import vcare.vcare.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        try {
            // Check if a product with the same name already exists
            Optional<Product> existingProduct = productRepository.findByName(product.getName());
            if (existingProduct.isPresent()) {
                throw new RuntimeException("Product with the name " + product.getName() + " already exists.");
            }

            // Save the product, id will be generated automatically
            return productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while creating the product: " + e.getMessage());
        }
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID: " + id + " not found."));

        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID: " + id + " not found."));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        product.setThumbnail(productDetails.getThumbnail());
        product.setCategory(productDetails.getCategory());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID: " + id + " not found."));

        productRepository.delete(product);
    }
}
