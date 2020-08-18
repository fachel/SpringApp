package com.tacos.springapp.repo;

import com.tacos.springapp.models.Taco;
import org.springframework.data.repository.CrudRepository;

//CrudRepository содержит ф-ии для добавления,уд,обновления данных в таблице бд
//<Taco, Long> Taco потому что нахвание таблицы(класса) Long потому что в Taco id иммеет тип Long
public interface TakoRepository extends CrudRepository<Taco, Long> {
}
