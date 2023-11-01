package com.sewing.unnamedWorkshop.entity.compositionOfMaterials;

import com.sewing.unnamedWorkshop.entity.compositionOfMaterials.MaterialsCategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Матеріали для виробів")
public class MaterialsEntity {
    private static final String SEQ_NAME = "materials_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @Column(name = "Назва матеріалу", nullable = false)
    private String title;
    @Column(name = "Кількість матеріалу")
    private String amountOfMaterial;
    @JoinTable(name = "materials_categories", joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<MaterialsCategoryEntity> categoriesMaterial;

    @Column(name = "Чи є в наявності")
    private boolean status;


}
