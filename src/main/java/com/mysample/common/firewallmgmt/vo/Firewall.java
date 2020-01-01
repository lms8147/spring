package com.mysample.common.firewallmgmt.vo;

import lombok.Data;

@Data
public class Firewall {

  private String firewallID;
  private String sourceIP;
  private String destinationIP;
  private String port;
  private String bound;
  private String usedSystem;
  private String purpose;
  private String changerID;
  private String changeDate;
}
