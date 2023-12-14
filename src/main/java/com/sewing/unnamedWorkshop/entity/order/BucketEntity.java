package com.sewing.unnamedWorkshop.entity.order;

import com.sewing.unnamedWorkshop.entity.product.ProductEntity;
import com.sewing.unnamedWorkshop.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Кошик")
public class BucketEntity {
    private static final String SEQ_NAME = "кошик_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_користувача")
    private UserEntity user;

    @ManyToMany
    @JoinTable(name = "Продукти_в_кошику", joinColumns = @JoinColumn(name = "id_кошика"),
            inverseJoinColumns = @JoinColumn(name = "id_продукта"))
    private List<ProductEntity> product;
}
