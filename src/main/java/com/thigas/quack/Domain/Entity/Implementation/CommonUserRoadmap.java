package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.UserRoadmap;
import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUserRoadmap implements UserRoadmap {

    private Integer id;
    private Integer userId;
    private Integer roadmapId;
    private Double progress;
    private LocalDate startedIn;
    private LocalDate finishedIn;
    private Status status;

    @Override
    public void addProgress(Double progress) {
        this.progress += progress;
        if (this.progress >= 100.0) {
            updateStatus(Status.FINISHED);
        }
    }

    @Override
    public void updateStatus(Status status) {
        this.status = status;
    }

    @Override
    public void updateFinishedIn(LocalDate finishedIn) {
        this.finishedIn = finishedIn;
    }
}
