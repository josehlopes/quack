package com.thigas.quack.Infrastructure.Model;

import com.thigas.quack.Adapter.Mapper.TaskTextConverter;
import com.thigas.quack.UseCase.Model.Request.TaskTextDsRequestModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "task")
public class TaskDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<StepDataMapper> steps;
    @Column(columnDefinition = "jsonb")
    @Convert(converter = TaskTextConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    private TaskTextDsRequestModel tasktext;
    @Column(nullable = true)
    private String imagePath;

    public TaskDataMapper(Integer id, Set<StepDataMapper> steps, TaskTextDsRequestModel tasktext, String imagePath) {
        this.id = id;
        this.steps = steps;
        this.tasktext = tasktext;
        this.imagePath = imagePath;
    }

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
