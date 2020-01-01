package com.mysample.common.base.service;

import java.util.List;
import com.mysample.common.base.vo.Person;

public interface IPersonService {

  public List<Person> getPersonList();

  public void insertPerson(Person person);
}
