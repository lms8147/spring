package com.mysample.common.firewallmgmt.repository;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.mysample.common.firewallmgmt.vo.DeleteYN;
import com.mysample.common.firewallmgmt.vo.Firewall;
import com.mysample.common.firewallmgmt.vo.FirewallBound;
import com.mysample.common.firewallmgmt.vo.SystemPort;

public class FirewallRepositoryTestUtil {

  public static final String IP_1_0_0_1 = "1.0.0.1";
  public static final String IP_1_0_0_2 = "1.0.0.2";
  public static final String IP_1_0_0_3 = "1.0.0.3";
  public static final String IP_1_0_0_4 = "1.0.0.4";
  public static final String IP_1_0_0_5 = "1.0.0.5";
  public static final String IP_1_0_0_6 = "1.0.0.6";
  public static final String IP_1_0_0_7 = "1.0.0.7";
  public static final String IP_1_0_0_8 = "1.0.0.8";
  public static final String IP_1_0_0_9 = "1.0.0.9";
  public static final String IP_1_0_0_10 = "1.0.0.10";
  public static final String IP_2_0_0_1 = "2.0.0.1";
  public static final String IP_2_0_0_2 = "2.0.0.2";

  public static final String PURPOSE_A = "PURPOSE_A";
  public static final String PURPOSE_B = "PURPOSE_B";

  public static final String CHANGER_ID_J = "J";
  public static final String CHANGER_ID_K = "K";

  public static final String USED_SYSTEM_A = "SYSTEM_A";
  public static final String USED_SYSTEM_B = "SYSTEM_B";

  public static final String DATE_2020_01_01 = "2020-01-01";
  public static final String DATE_2020_01_02 = "2020-01-02";

  public static final int PAGE_INDEX_0 = 0;
  public static final int PAGE_INDEX_1 = 1;

  public static final int UNIT_PAGE_COUNT = 10;

  public static final Comparator<Firewall> FIREWALL_TO_STRING_COMPARATOR =
      new Comparator<Firewall>() {

        @Override
        public int compare(Firewall o1, Firewall o2) {
          // TODO Auto-generated method stub
          return o1.toString().compareTo(o1.toString());
        }
      };

  public static final Firewall originFirewall = Firewall.builder()
      .firewallID(createFirewallID())
      .sourceIP(IP_1_0_0_1)
      .destinationIP(IP_2_0_0_1)
      .bound(FirewallBound.INBOUND)
      .usedSystem(USED_SYSTEM_A)
      .port(SystemPort.TCP)
      .purpose(PURPOSE_A)
      .changerID(CHANGER_ID_J)
      .changeDate(sysDate())
      .deleteYN(DeleteYN.N)
      .build();

  public static String createFirewallID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public static String sysDate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormat.format(new Date(System.currentTimeMillis()));
  }

  public static Firewall makeSameFirewallExceptOf(Firewall.FirewallBuilder config,
      Firewall originFirewall) {

    if (config == null) {
      config = Firewall.builder();
    }

    for (Field field : Firewall.FirewallBuilder.class.getDeclaredFields()) {
      try {
        field.setAccessible(true);
        if (field.get(config) == null) {
          Field originDataField = Firewall.class.getDeclaredField(field.getName());
          originDataField.setAccessible(true);
          field.set(config, originDataField.get(originFirewall));
          originDataField.setAccessible(false);
        }
        field.setAccessible(false);
      } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return config.build();
  }

  public static Firewall copyOf(Firewall originFirewall) {
    return makeSameFirewallExceptOf(null, originFirewall);
  }

  public static Firewall makeSameFirewallExceptOfIdAnd(Firewall.FirewallBuilder config,
      Firewall originFirewall) {
    return makeSameFirewallExceptOf(config.firewallID(createFirewallID()), originFirewall);
  }

  public static List<Firewall> createDummyDataForPagingTest() {
    return createDummy1DataForTest();
  }

  public static List<Firewall> createDummyDataForSearchTest() {
    return createDummy1DataForTest();
  }

  /**
   * create dummy data<br>
   * (srcIP, destIP)<br>
   * (1.0.0.1 ~ 1.0.0.10, 2.0.0.1 ~ 2.0.0.2)
   * 
   * @return dummy data list
   */
  public static List<Firewall> createDummy1DataForTest() {

    List<Firewall> firewalls = new ArrayList<Firewall>();

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_1), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_3), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_4), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_5), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_6), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_7), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_8), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_9), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_10), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_1)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_2)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_3)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_4)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_5)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_6)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_7)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_8)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_9)
        .destinationIP(IP_2_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_10)
        .destinationIP(IP_2_0_0_2), originFirewall));


    return firewalls;
  }



  /**
   * create dummy data<br>
   * (srcIP, destIP)<br>
   * (1.0.0.1 ~ 1.0.0.3, 2.0.0.1)
   * 
   * @return dummy data list
   */
  public static List<Firewall> createDummy2DataForTest() {

    List<Firewall> firewalls = new ArrayList<Firewall>();

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_1), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_2), originFirewall));

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_3), originFirewall));

    return firewalls;
  }

  public static List<Firewall> createDummyDataForInsertTest() {
    return createDummy3DataForTest();
  }

  /**
   * create dummy data<br>
   * (srcIP, destIP)<br>
   * (1.0.0.1, 2.0.0.1)
   * 
   * @return dummy data list
   */
  public static List<Firewall> createDummy3DataForTest() {

    List<Firewall> firewalls = new ArrayList<Firewall>();

    firewalls.add(makeSameFirewallExceptOfIdAnd(Firewall.builder()
        .sourceIP(IP_1_0_0_1), originFirewall));

    return firewalls;
  }
  
  public static List<Firewall> createDummyDataForUpdateTest() {
    return createDummy4DataForTest();
  }

  /**
   * create dummy data<br>
   * (srcIP, destIP)<br>
   * (1.0.0.1, 2.0.0.1)
   * 
   * @return dummy data list
   */
  public static List<Firewall> createDummy4DataForTest() {

    List<Firewall> firewalls = new ArrayList<Firewall>();

    firewalls.add(makeSameFirewallExceptOf(Firewall.builder()
        .sourceIP(IP_1_0_0_1)
        .destinationIP(IP_1_0_0_1)
        .bound(FirewallBound.INBOUND)
        .changeDate(sysDate())
        .changerID(CHANGER_ID_J)
        .port(SystemPort.TCP)
        .purpose(PURPOSE_A)
        .usedSystem(USED_SYSTEM_A), originFirewall));

    firewalls.add(makeSameFirewallExceptOf(Firewall.builder()
        .sourceIP(IP_1_0_0_2)
        .destinationIP(IP_1_0_0_2)
        .bound(FirewallBound.OUTBOUND)
        .changeDate(sysDate())
        .changerID(CHANGER_ID_K)
        .port(SystemPort.UDP)
        .purpose(PURPOSE_B)
        .usedSystem(USED_SYSTEM_B), originFirewall));

    return firewalls;
  }
  
  public static List<Firewall> createDummyDataForUpdateToDeleteTest() {
    return createDummy5DataForTest();
  }

  /**
   * create dummy data<br>
   * (srcIP, destIP)<br>
   * (1.0.0.1, 2.0.0.1)
   * 
   * @return dummy data list
   */
  public static List<Firewall> createDummy5DataForTest() {

    List<Firewall> firewalls = new ArrayList<Firewall>();

    firewalls.add(makeSameFirewallExceptOf(Firewall.builder()
        .changeDate(sysDate())
        .deleteYN(DeleteYN.N), originFirewall));

    firewalls.add(makeSameFirewallExceptOf(Firewall.builder()
        .changeDate(sysDate())
        .deleteYN(DeleteYN.Y), originFirewall));

    return firewalls;
  }

}
