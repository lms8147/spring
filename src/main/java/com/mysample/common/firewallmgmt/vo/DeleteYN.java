package com.mysample.common.firewallmgmt.vo;

import com.ibatis.sqlmap.engine.type.EnumTypeHandler;

public enum DeleteYN {

  Y, N;

  public static class DeleteYNEnumTypeHandler extends EnumTypeHandler {

    public DeleteYNEnumTypeHandler() {
      super(DeleteYN.class);
    }

  }
}
