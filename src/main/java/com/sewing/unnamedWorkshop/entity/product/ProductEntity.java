package com.sewing.unnamedWorkshop.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Вироби")
public class ProductEntity {
    private static final String SEQ_NAME = "product_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(nullable = false, name = "Назва товару")
    private String title;

    @Column(nullable = false, name = "Фото")
    private String photoURL;

    @Column(nullable = false, length = 1000, name = "Опис")
    private String description;

    @Column(nullable = false, name = "Ціна виробу")
    private BigDecimal price;

    @Column(name = "Необхідні матеріали")
    private String materials;
    @Column(name = "Артикль_матеріалу")
    private String articleOfMaterials;

    @Column(name = "Кількість матеріалу")
    private double fabricQuantity;

    @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;
}
