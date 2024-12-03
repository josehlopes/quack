package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.Statistics;

public interface StatisticsFactory {
    Statistics create(Integer userId);
}
