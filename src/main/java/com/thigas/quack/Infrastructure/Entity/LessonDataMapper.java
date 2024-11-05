package com.thigas.quack.Infrastructure.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "lesson")
public class LessonDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = true)
    private String language;
    @Column(name = "image_path", nullable = false)
    private String imagePath;
    @Column(name = "completed", nullable = false)
    private boolean completed = false;
    @Column(name = "link", nullable = true)
    private String link;
    @ManyToMany(mappedBy = "lessons", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<StepDataMapper> steps = new HashSet<>();

    public LessonDataMapper(Integer id, String title, String description, String language, String imagePath, boolean completed, String link, Set<StepDataMapper> steps) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.language = language;
        this.imagePath = imagePath;
        this.completed = completed;
        this.link = link;
        this.steps = steps;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        LessonDataMapper that = (LessonDataMapper) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
