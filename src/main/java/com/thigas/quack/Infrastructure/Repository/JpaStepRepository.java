package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Model.StepDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStepRepository extends JpaRepository<StepDataMapper, Integer> {

}
