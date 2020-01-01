package com.mysample.common.base.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.mysample.common.base.repository.PersonRepository;
import com.mysample.common.base.service.IPersonService;
import com.mysample.common.base.vo.Person;

@Service
public class PersonServiceImpl implements IPersonService {

  @Inject
  PersonRepository personRepository;

  @Override
  public List<Person> getPersonList() {
    return personRepository.getPersonList();
  }

  @Override
  public void insertPerson(Person person) {
    personRepository.insertPerson(person);
  }

}
