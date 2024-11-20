package com.thigas.quack.Domain.Entity;

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

    Boolean isValid();

    Boolean isCepValid();


}