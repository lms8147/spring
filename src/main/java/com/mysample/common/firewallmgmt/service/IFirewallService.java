package com.mysample.common.firewallmgmt.service;

import java.util.List;
import com.mysample.common.firewallmgmt.vo.Firewall;

public interface IFirewallService {

  public boolean isExistSameFirewall(Firewall firewall);

  public List<Firewall> getFirewallList(Firewall firewall);

  public Firewall getFirewall(Firewall firewall);

  public void insertFirewall(Firewall firewall);

  public void updateFirewall(Firewall firewall);

  public void deleteFirewall(Firewall firewall);

  public void deleteFirewallAll();
}
