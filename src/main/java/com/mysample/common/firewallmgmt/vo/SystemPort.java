package com.mysample.common.firewallmgmt.vo;

import com.ibatis.sqlmap.engine.type.EnumTypeHandler;

public enum SystemPort {

  TCP, UDP;

  public static class SystemPortEnumTypeHandler extends EnumTypeHandler {

    public SystemPortEnumTypeHandler() {
      super(SystemPort.class);
    }

  }
}
