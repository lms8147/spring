package com.mysample.common.firewallmgmt.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/context-properties.xml",
    "classpath:/spring/context-transaction.xml",
    "classpath:/spring/context-ibatis.xml"})
public class FirewallRepositoryTest {


  @Test
  public void testName() throws Exception {

  }
}
