package com.mysample.common.base.repository;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibatis.sqlmap.engine.transaction.jta.JtaTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.mysample.common.base.vo.Person;
import org.springframework.transaction.jta.JtaTransactionManager;

@Repository
public class U1PersonRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(U1PersonRepository.class);

    @Inject
    @Named(value ="u1SqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Inject
    @Named(value ="transactionManager")
    private JtaTransactionManager transactionManager;

    public List<Person> getPersonList() {
        return sqlMapClientTemplate.queryForList("com.mysample.u1.common.base.getPersonList");
    }

    public void insertPerson(Person person) {
        sqlMapClientTemplate.insert("com.mysample.u1.common.base.insertPerson", person);
    }
}
