package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAchievementEntity implements BaseEntity {

    private int id;
    private UserEntity user;
    private AchievementEntity achievement;
    private String imagePath;
    private OffsetDateTime obtainedDate;


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
