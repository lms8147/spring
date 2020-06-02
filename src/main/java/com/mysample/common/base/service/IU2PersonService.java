package com.mysample.common.base.service;

import com.mysample.common.base.vo.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IU2PersonService {


    List<Person> getU2PersonList();

    @Transactional(rollbackFor = Exception.class)
    void insertU2Person(Person person);
}
