package com.thigas.quack.Domain.Entity.Interface;


import com.thigas.quack.Domain.Utils.Status;

import java.util.Set;

public interface Roadmap {

    int getId();

    String getTitle();

    String getDescription();

    String getImagePath();

    Status getStatus();

    Set<Step> getSteps();


}