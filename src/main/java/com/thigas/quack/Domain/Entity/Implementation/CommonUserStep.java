package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.UserStep;
import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUserStep implements UserStep {
    private Integer id;
    private Integer userId;
    private Integer stepId;
    private Status status;
}
