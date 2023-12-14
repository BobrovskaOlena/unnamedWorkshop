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
    private static final String SEQ_NAME = "замовлення_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @Column(name = "Створено")
    @CreationTimestamp
    private LocalDateTime created;
    @Column(name = "Оновлено")
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "id_користувача")
    private UserEntity user;
    @Column(name = "Сума")
    private BigDecimal sum;
    @Column(name = "Адреса")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "Служба_доставки")
    private DeliveryService deliveryService;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> details;
    @Column(name = "Статус_замовленння")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
