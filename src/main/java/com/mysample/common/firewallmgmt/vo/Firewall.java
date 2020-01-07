package com.mysample.common.firewallmgmt.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Firewall {

  private String firewallID;
  private String sourceIP;
  private String destinationIP;
  private SystemPort port;
  private FirewallBound bound;
  private String usedSystem;
  private String purpose;
  private String changerID;
  private String changeDate;
  private DeleteYN deleteYN;
}
