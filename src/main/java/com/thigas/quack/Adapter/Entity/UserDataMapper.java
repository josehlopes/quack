package com.thigas.quack.Adapter.Entity;

import com.thigas.quack.Domain.Utils.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class UserDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(name = "born_at", columnDefinition = "DATE", nullable = false)
    private LocalDate bornDate;
    @Column(name = "register_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime registerOn;
    @Column(name = "is_active", nullable = false, columnDefinition = "INTEGER CHECK (is_active IN (0, 1))")
    private Integer isActive = 1;
    @Column(name = "image_path")
    private String imagePath;

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
