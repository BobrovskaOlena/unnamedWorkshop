package com.sewing.unnamedWorkshop.entity.order;

import com.sewing.unnamedWorkshop.entity.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Деталі_замовлення")
public class OrderDetailsEntity {
    private static final String SEQ_NAME = "деталі_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_замовлення")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "id_продукта")
    private ProductEntity product;
    @Column(name = "Кількість")
    private BigDecimal amount;
    @Column(name = "Ціна")
    private BigDecimal price;
}
