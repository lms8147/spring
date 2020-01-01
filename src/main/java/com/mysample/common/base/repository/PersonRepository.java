package com.mysample.common.base.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.mysample.common.base.vo.Person;

@Repository
public class PersonRepository {

  @Inject
  private SqlMapClientTemplate sqlMapClientTemplate;

  public List<Person> getPersonList() {
    return sqlMapClientTemplate.queryForList("getPersonList");
  }

  public void insertPerson(Person person) {
    sqlMapClientTemplate.insert("insertPerson", person);
  }
}
