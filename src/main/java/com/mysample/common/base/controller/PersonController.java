package com.mysample.common.base.controller;

import java.util.List;
import javax.inject.Inject;

import com.mysample.common.base.service.IU2PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mysample.common.base.service.IU1PersonService;
import com.mysample.common.base.vo.Person;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

  @Inject
  IU1PersonService u1PersonService;
  @Inject
  IU2PersonService u2PersonService;

  @RequestMapping("/persons.do")
  @ResponseBody
  public String getPersonList() {
    List<Person> u1Persons = u1PersonService.getU1PersonList();
    List<Person> u2Persons = u2PersonService.getU2PersonList();

    return u1Persons.toString() + "....." + u2Persons.toString();
  }

  @RequestMapping(value = "/u1/person.do", method = RequestMethod.POST)
  @ResponseBody
  public void addU1Person() {
    Person person = new Person();
    person.setName("u1_c");
    person.setAge(100);
    u1PersonService.insertU1Person(person);
  }

  @RequestMapping(value = "/u2/person.do", method = RequestMethod.POST)
  @ResponseBody
  public void addU2Person(){
    Person person = new Person();
    person.setName("u2_c");
    person.setAge(100);
    try {
      u2PersonService.insertU2Person(person);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
