package com.thigas.quack.Domain.Entity.Interface;

import java.util.Set;

public interface Lesson {

    Integer getId();
    String getTitle();
    String getDescription();
    String getLanguage();
    String getImagePath();
    String getLink();
    Set<Step> getSteps();

}
