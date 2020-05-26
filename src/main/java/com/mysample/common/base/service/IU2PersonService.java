package com.mysample.common.base.service;

import com.mysample.common.base.vo.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IU2PersonService {

    @Transactional(value = "u2TxManager", rollbackFor = Exception.class)
    List<Person> getU2PersonList();

    @Transactional(value = "u2TxManager", rollbackFor = Exception.class)
    void insertU2Person(Person person);
}
