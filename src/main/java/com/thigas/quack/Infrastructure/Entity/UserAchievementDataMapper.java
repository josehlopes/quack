package com.thigas.quack.Infrastructure.Entity;

import com.thigas.quack.Domain.Utils.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_achievement")
public class UserAchievementDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDataMapper user;
    @ManyToOne
    @JoinColumn(name = "achievement_id", nullable = false)
    @ToString.Exclude
    private AchievementDataMapper achievement;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "obtained_on")
    private OffsetDateTime obtainedOn;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.ACTIVE;

    public UserAchievementDataMapper(Integer id, UserDataMapper user, AchievementDataMapper achievement, String imagePath, OffsetDateTime obtainedDate, Status status) {
        this.id = id;
        this.user = user;
        this.achievement = achievement;
        this.imagePath = imagePath;
        this.obtainedOn = obtainedOn;
        this.status = status;
    }

}
