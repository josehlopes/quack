package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;


public interface Address {

    int getId();

    User getUser();

    String getStreet();

    String getCity();

    String getState();

    String getCountry();

    String getZipCode();

    String getNumber();

    Status getStatus();


}