package com.mysample.common.base.service.impl;

import java.util.List;
import javax.inject.Inject;

import com.mysample.common.base.repository.U2PersonRepository;
import com.mysample.common.base.service.IU2PersonService;
import org.springframework.stereotype.Service;
import com.mysample.common.base.repository.U1PersonRepository;
import com.mysample.common.base.service.IU1PersonService;
import com.mysample.common.base.vo.Person;

@Service
public class U1PersonServiceImpl implements IU1PersonService {

  @Inject
  U1PersonRepository u1PersonRepository;

  @Inject
  IU2PersonService u2PersonService;

  @Override
  public List<Person> getU1PersonList() {
    return u1PersonRepository.getPersonList();
  }

  @Override
  public void insertU1Person(Person person){
    u1PersonRepository.insertPerson(person);
    u2PersonService.insertU2Person(person);
    //throw new RuntimeException("insertU1Person");
  }


}
