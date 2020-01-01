package com.mysample.common.firewallmgmt.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.mysample.common.base.vo.Person;
import com.mysample.common.firewallmgmt.vo.Firewall;

@Repository
public class FirewallRepository {

  private static final String NAMESPACE = "com.mysample.common.firewallmgmt";

  private String getQueryName(String queryName) {
    return NAMESPACE + queryName;
  }

  @Inject
  private SqlMapClientTemplate sqlMapClientTemplate;

  public boolean isExistSameFirewall(Firewall firewall) {
    return (boolean) sqlMapClientTemplate.queryForObject(getQueryName("isExistSameFirewall"),
        firewall);
  }

  public List<Firewall> getFirewallList(Firewall firewall) {
    return sqlMapClientTemplate.queryForList(getQueryName("getFirewallList"), firewall);
  }

  public Firewall getFirewall(Firewall firewall) {
    return (Firewall) sqlMapClientTemplate.queryForObject(getQueryName("getFirewall"), firewall);
  }

  public void insertFirewall(Firewall firewall) {
    sqlMapClientTemplate.insert(getQueryName("insertFirewall"), firewall);
  }

  public void updateFirewall(Firewall firewall) {
    sqlMapClientTemplate.update(getQueryName("updateFirewall"), firewall);
  }

  public void deleteFirewall(Firewall firewall) {
    sqlMapClientTemplate.delete(getQueryName("deleteFirewall"), firewall);
  }

  public void deleteFirewallAll() {
    sqlMapClientTemplate.delete(getQueryName("deleteFirewallAll"));
  }
}
