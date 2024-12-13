package com.thigas.quack.Domain.Entity.Interface;


public interface Achievement {

    Integer getId();

    String getName();

    String getDescription();

    String getImagePath();
    
    Boolean getIsActive();

}