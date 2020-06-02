package com.mysample.common.base.service;

import java.util.List;

import com.mysample.common.base.vo.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface IU1PersonService {


    List<Person> getU1PersonList();

    @Transactional(rollbackFor = Exception.class)
    void insertU1Person(Person person);

}
