package com.mysample.common.base.repository;

import com.mysample.common.base.vo.Person;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Repository
public class U2PersonRepository {

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
