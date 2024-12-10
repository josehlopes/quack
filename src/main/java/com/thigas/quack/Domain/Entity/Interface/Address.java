package com.thigas.quack.Domain.Entity.Interface;

public interface Address {

    Integer getId();

    Integer getUserId();

    String getStreet();

    String getCity();

    String getState();

    String getCountry();

    String getZipCode();

    String getNumber();

    Boolean getIsActive();

    void setIsActive(Boolean isActive);

    Boolean isValid();

    Boolean isCepValid();

}