package com.sewing.unnamedWorkshop.entity.user;

import com.sewing.unnamedWorkshop.entity.order.BucketEntity;
import com.sewing.unnamedWorkshop.entity.order.DeliveryService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "Користувачі")
public class UserEntity {
    private static final String SEQ_NAME = "користувач_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @CreationTimestamp
    @Column(name = "Створено")
    private Timestamp createdAt;

    @Column(name = "Оновлено")
    private Timestamp updatedAt;

    @Column(nullable = false, name = "Логін")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(nullable = false, name = "Пароль")
    private String password;

    @Column(name = "Прізвище")
    private String lastName;

    @Column(name = "Ім'я")
    private String firstName;

    @Column(name = "По-батькові")
    private String middleName;

    @Column(name = "Дата_народження")
    private Date dateOfBirth;

    @Column(name = "Телефон")
    private String telefon;

    @Column(name = "Місто")
    private String city;

    @Column(name = "Поштовий_індекс")
    private String post;

    @Enumerated(EnumType.STRING)
    @Column(name = "Служба_доставки")
    private DeliveryService deliveryService;

    @Column(name = "Відділення")
    private String department;

    @Column(name = "Архівовано")
    private boolean archive;

    @Enumerated(EnumType.STRING)
    @Column(name = "Роль")
    private Role role;

    @OneToOne(cascade = CascadeType.REMOVE)
    private BucketEntity bucket;
}
