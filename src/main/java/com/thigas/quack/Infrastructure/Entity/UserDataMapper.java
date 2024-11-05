package com.thigas.quack.Infrastructure.Entity;

import com.thigas.quack.Domain.Utils.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user")
public class UserDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(name = "born_at", columnDefinition = "DATE", nullable = false)
    private LocalDate bornDate;
    @Column(name = "register_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime registerOn;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;
    @Column(name = "image_path")
    private String imagePath;

    public UserDataMapper(Integer id, String name, String username, String phone, String email, String password, String cpf, LocalDate bornDate, OffsetDateTime registerOn, Status status, String imagePath) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.bornDate = bornDate;
        this.registerOn = registerOn;
        this.status = status;
        this.imagePath = imagePath;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UserDataMapper userDataMapper = (UserDataMapper) o;
        return false;
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
