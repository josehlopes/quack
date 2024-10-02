package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.adapter.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user_achievement")
public class UserAchievementModel implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "achievement_id", nullable = false)
    private AchievementModel achievement;

    @Column(name = "earned_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private LocalDate earnedAt;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAchievementModel that = (UserAchievementModel) o;
        return id == that.id;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }
}