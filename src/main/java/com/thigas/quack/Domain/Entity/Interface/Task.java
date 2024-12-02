package com.thigas.quack.Domain.Entity.Interface;

import java.util.Set;

public interface Task {

    Integer getId();
    TaskText getTaskText();
    Set<Step> getSteps();
    String getImagePath();
}