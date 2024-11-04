package com.thigas.quack.Domain.Entity;


import java.util.Set;

public interface Task {

    int getId();

    TaskText getTasktext();

    Set<Step> getSteps();

    String getImagePath();

}