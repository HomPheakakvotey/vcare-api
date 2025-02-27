package vcare.vcare.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String thumbnail;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;
}
