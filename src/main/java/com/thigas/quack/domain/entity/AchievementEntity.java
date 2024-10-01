package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementEntity implements BaseEntity {

    private int id;
    private String name;
    private String description;
    private String imagePath;

    @Override
    public int getId() {
        return this.id; // Retorna o ID
    }

    @Override
    public void setId(int id) {
        this.id = id; // Define o ID
    }
}