package com.thigas.quack.Domain.Entity.Interface;

import java.util.Set;

public interface Lesson {

    int getId();

    String getTitle();

    String getDescription();

    String getLanguage();

    String getImagePath();

    boolean getCompleted();

    String getLLink();

    Set<Step> getSteps();

}
