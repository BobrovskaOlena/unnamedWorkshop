package com.sewing.unnamedWorkshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    @Column(name = "Створено")
    private Timestamp createdAt;

    @Column(name = "Оновлено")
    private Timestamp updatedAt;

    @Column(nullable = false, name = "Логін")
    @Length(min = 2, max = 100)
    private String username;

    @Column(name = "Email")
    @Length(min = 5, max = 50)
    private String email;

    @Column(nullable = false, name = "Пароль")
    @Length(min = 5, max = 100)
    private String password;

    @Length(max = 50)
    @Column(name = "Прізвище")
    private String lastName;

    @Length(max = 50)
    @Column(name = "Ім'я")
    private String firstName;

    @Length(max = 50)
    @Column(name = "По-батькові")
    private String middleName;

    @Column(name = "Дата народження")
    private Date dateOfBirth;

    @Column(name = "Телефон")
    @Pattern(regexp = "\\+38\\d{10}", message = "Неправильний формат номеру телефону")
    private String telefon;

    @Column(name = "Місто")
    private String city;

    @Column(name = "Поштовий індекс")
    private String post;

    @Column(name = "Служба доставки")
    @Enumerated(EnumType.STRING)
    private DeliveryService deliveryService;

    @Column(name = "Відділення")
    private String department;
    }
