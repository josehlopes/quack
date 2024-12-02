package com.thigas.quack.Adapter.Entity;

import com.thigas.quack.Domain.Utils.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_roadmap")
public class UserRoadmapDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDataMapper user;
    @ManyToOne
    @JoinColumn(name = "roadmap_id", nullable = false)
    private RoadmapDataMapper roadmap;
    @Column(name = "progress", nullable = false)
    private Double progress;
    @Column(name = "started_at", columnDefinition = "DATE", nullable = false)
    private LocalDate startedAt;
    @Column(name = "finished_at", columnDefinition = "DATE", nullable = true)
    private LocalDate finishedAt;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

    public UserRoadmapDataMapper(Integer id, UserDataMapper user, RoadmapDataMapper roadmap, Double progress, LocalDate startedAt, LocalDate finishedAt, Status status) {
        this.id = id;
        this.user = user;
        this.roadmap = roadmap;
        this.progress = progress;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.status = status;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UserRoadmapDataMapper that = (UserRoadmapDataMapper) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}