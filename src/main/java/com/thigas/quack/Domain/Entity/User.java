package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public interface User {

    Integer getId();

    String getName();

    String getUsername();

    String getPhone();

    String getEmail();

    String getPassword();

    String getCpf();

    LocalDate getBornDate();

    OffsetDateTime getRegisterOn();

    String getImagePath();

    Status getStatus();

    boolean passwordIsValid();
}
