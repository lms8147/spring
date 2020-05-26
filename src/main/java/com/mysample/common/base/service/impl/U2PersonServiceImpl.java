package com.mysample.common.base.service.impl;

import com.mysample.common.base.repository.U2PersonRepository;
import com.mysample.common.base.service.IU2PersonService;
import com.mysample.common.base.vo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class U2PersonServiceImpl implements IU2PersonService {

    @Inject
    U2PersonRepository u2PersonRepository;

    @Override
    public List<Person> getU2PersonList() {
        return u2PersonRepository.getPersonList();
    }

    @Override
    public void insertU2Person(Person person){
        u2PersonRepository.insertPerson(person);
        //throw new RuntimeException("insertU2Person");
    }

}
