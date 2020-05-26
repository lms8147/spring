package com.mysample.common.base.repository;

import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.mysample.common.base.vo.Person;

@Repository
public class U1PersonRepository {

    @Inject
    @Named(value ="u1SqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    public List<Person> getPersonList() {
        return sqlMapClientTemplate.queryForList("com.mysample.u1.common.base.getPersonList");
    }

    public void insertPerson(Person person) {
        sqlMapClientTemplate.insert("com.mysample.u1.common.base.insertPerson", person);
    }
}
