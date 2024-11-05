package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Entity.StepDataMapper;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaStepRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StepDsGatewayImplementation implements StepDsGateway {

    @Autowired
    private JpaStepRepository stepModelRepository;

    @Override
    public void save(StepDataMapper stepDataMapper) {
         stepModelRepository.save(stepDataMapper);
    }

    @Override
    public Optional<StepDataMapper> findById(int id) {
        return stepModelRepository.findById(id);
    }

    @Override
    public Boolean existsById(int id) {
        return stepModelRepository.existsById(id);
    }


    @Override
    public Iterable<StepDataMapper> findAll() {
        return stepModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        stepModelRepository.deleteById(id);
    }

}
