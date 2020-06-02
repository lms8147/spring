package com.mysample.common.base.repository;

import com.mysample.common.base.vo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.SQLException;
import java.util.List;

@Repository
public class U2PersonRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(U2PersonRepository.class);

    @Inject
    @Named(value = "u2SqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    public List<Person> getPersonList() {
        return sqlMapClientTemplate.queryForList("com.mysample.u2.common.base.getPersonList");
    }

    public void insertPerson(Person person) {
        sqlMapClientTemplate.insert("com.mysample.u2.common.base.insertPerson", person);
    }
}
