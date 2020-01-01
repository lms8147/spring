package com.mysample.common.firewallmgmt.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.mysample.common.firewallmgmt.repository.FirewallRepository;
import com.mysample.common.firewallmgmt.service.IFirewallService;
import com.mysample.common.firewallmgmt.vo.Firewall;

@Service
public class FirewallServiceImpl implements IFirewallService {

  @Inject
  FirewallRepository firewallRepository;


  @Override
  public boolean isExistSameFirewall(Firewall firewall) {
    return firewallRepository.isExistSameFirewall(firewall);
  }

  @Override
  public List<Firewall> getFirewallList(Firewall firewall) {
    return firewallRepository.getFirewallList(firewall);
  }

  @Override
  public Firewall getFirewall(Firewall firewall) {
    return firewallRepository.getFirewall(firewall);
  }

  @Override
  public void insertFirewall(Firewall firewall) {
    firewallRepository.insertFirewall(firewall);
  }

  @Override
  public void updateFirewall(Firewall firewall) {
    firewallRepository.updateFirewall(firewall);
  }

  @Override
  public void deleteFirewall(Firewall firewall) {
    firewallRepository.deleteFirewall(firewall);
  }

  @Override
  public void deleteFirewallAll() {
    firewallRepository.deleteFirewallAll();
  }

}
