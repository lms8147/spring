package com.mysample.common.firewallmgmt.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.mysample.common.base.vo.Person;
import com.mysample.common.firewallmgmt.vo.Firewall;

@Repository
public class FirewallRepository {

  private static final String NAMESPACE = "com.mysample.common.firewallmgmt.";

  private String getQueryName(String queryName) {
    return NAMESPACE + queryName;
  }

  @Inject
  private SqlMapClientTemplate sqlMapClientTemplate;

  public Firewall getDuplicateFirewall(Firewall firewall) {
    return (Firewall) sqlMapClientTemplate.queryForObject(getQueryName("getDuplicateFirewall"),
        firewall);
  }

  public List<Firewall> getFirewallList(Firewall searchFirewall) {
    return sqlMapClientTemplate.queryForList(getQueryName("getFirewallList"), searchFirewall);
  }

  public List<Firewall> getFirewallList(Firewall searchFirewall, int pageIndex, int unitPageCount) {
    return sqlMapClientTemplate.queryForList(getQueryName("getFirewallList"), searchFirewall,
        pageIndex,
        unitPageCount);
  }

  public Firewall getFirewall(Firewall firewallPK) {
    return (Firewall) sqlMapClientTemplate.queryForObject(getQueryName("getFirewall"), firewallPK);
  }

  public void insertFirewall(Firewall firewall) {
    sqlMapClientTemplate.insert(getQueryName("insertFirewall"), firewall);
  }

  public void updateFirewall(Firewall firewall) {
    sqlMapClientTemplate.update(getQueryName("updateFirewall"), firewall);
  }
  
  public void updateFirewallToDelete(Firewall firewall) {
    sqlMapClientTemplate.update(getQueryName("updateFirewallToDelete"), firewall);
  }

  public void deleteFirewall(Firewall firewallPK) {
    sqlMapClientTemplate.delete(getQueryName("deleteFirewall"), firewallPK);
  }
  
  public void deleteFirewallAll() {
    sqlMapClientTemplate.delete(getQueryName("deleteFirewallAll"));
  }
}
