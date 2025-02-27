package vcare.vcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vcare.vcare.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
