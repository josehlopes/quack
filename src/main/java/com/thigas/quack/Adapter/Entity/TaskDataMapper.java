package com.thigas.quack.Adapter.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.thigas.quack.UseCase.Mapper.TaskTextConverter;
import com.thigas.quack.UseCase.Model.Request.TaskTextRequestModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class TaskDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Set<StepDataMapper> steps = new HashSet<>();
    @Column(columnDefinition = "jsonb")
    @Convert(converter = TaskTextConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    @JsonManagedReference
    private TaskTextRequestModel tasktext;
    @Column(nullable = true)
    private String imagePath;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TaskDataMapper taskDataMapper = (TaskDataMapper) o;
        return getId() != null && Objects.equals(getId(), taskDataMapper.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
