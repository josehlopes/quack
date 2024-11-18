package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;


public interface Address {

    Integer getId();

    User getUser();

    String getStreet();

    String getCity();

    String getState();

    String getCountry();

    String getZipCode();

    String getNumber();

    Integer getIsActive();

    Boolean isValid();

    Boolean isCepValid();


}