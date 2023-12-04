package com.sewing.unnamedWorkshop.entity.compositionOfMaterials;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="MaterialsCategory")
public class MaterialsCategoryEntity {
    private static final String SEQ_NAME = "materials_category_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "titleOfCategoryOfMaterials")
    private MaterialCategory title;
}
