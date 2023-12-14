package com.sewing.unnamedWorkshop.entity.compositionOfMaterials;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Матеріали_для_виробів")
public class MaterialsEntity {
    private static final String SEQ_NAME = "матеріали_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "Назва_матеріалу", nullable = false)
    private String title;

    @Column(name = "Кількість_матеріалу")
    private BigDecimal amountOfMaterial;

    @ManyToMany
    @JoinTable(name = "Матеріали_по_категоріям", joinColumns = @JoinColumn(name = "id_матеріалу"),
            inverseJoinColumns = @JoinColumn(name = "id_категорії"))
    private List<MaterialsCategoryEntity> categoriesMaterial;

    @Column(name = "Чи_є_в_наявності")
    private boolean status;
}
