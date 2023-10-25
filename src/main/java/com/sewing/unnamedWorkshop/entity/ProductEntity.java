package com.sewing.unnamedWorkshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Products")
public class ProductEntity {
    @Id
    @Column(name = "Артикль")
    private Long id;

    @Column(nullable = false, name = "Назва товару")
    private String name;

    @Column(nullable = false, name = "Фото")
    private String photoURL;

    @Column(nullable = false, length = 1000, name = "Опис")
    private String description;

    @Column(nullable = false, name = "Ціна виробу")
    private double price;

    @Column(name = "Матеріали")
    private String materials;

    @Column(name = "Кількість матеріалу")
    private double fabricQuantity;
}
