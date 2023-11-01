package com.sewing.unnamedWorkshop.entity.order;

import com.sewing.unnamedWorkshop.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Замовлення")
public class OrderEntity {
    private static final String SEQ_NAME = "order_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private BigDecimal sum;
    private String address;
    @Enumerated(EnumType.STRING)
    private DeliveryService deliveryService;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> details;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
