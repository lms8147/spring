package com.mysample.common.firewallmgmt.vo;

import com.ibatis.sqlmap.engine.type.EnumTypeHandler;

public enum FirewallBound {

  INBOUND, OUTBOUND;

  public static class FirewallBoundEnumTypeHandler extends EnumTypeHandler {

    public FirewallBoundEnumTypeHandler() {
      super(FirewallBound.class);
    }

  }
}
