package com.mysample.common.base.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mysample.common.base.service.IPersonService;
import com.mysample.common.base.vo.Person;

@Controller
public class PersonController {

  @Inject
  IPersonService personService;

  @RequestMapping("/person/list.do")
  public String getPersonList() {
    List<Person> persons = personService.getPersonList();
    return persons.toString();
  }

  @RequestMapping("/addPerson.do")
  public void addPerson() {
    Person person = new Person();
    person.setName("dd");
    person.setAge(100);
    personService.insertPerson(person);
  }

  @RequestMapping("/person.do")
  public String person() {
    return "com_r_person_list";
  }
}
