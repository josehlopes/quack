package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonAddress implements Address {

    private Integer id;
    private Integer userId;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String number;
    private Boolean isActive;

    @Override
    public Boolean isValid() {
        return street != null && !street.isEmpty() &&
                city != null && !city.isEmpty() &&
                state != null && !state.isEmpty() &&
                country != null && !country.isEmpty() &&
                zipCode != null && !zipCode.isEmpty() &&
                number != null && !number.isEmpty();
    }

    @Override
    public Boolean isCepValid() {
        return zipCode != null && zipCode.matches("\\d{5}-\\d{3}");
    }
}
