package com.mysample.common.firewallmgmt.repository;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mysample.common.firewallmgmt.vo.Firewall;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/context-*.xml"})
public class FirewallRepositoryTest {

  @Inject
  FirewallRepository firewallRepository;

  @Before
  public void beforeEachTest() {
    firewallRepository.deleteFirewallAll();
  }

  @Test
  public void is_deleted_y_when_update_to_delete()
      throws Exception {
    // --- arrange ---
    // 1개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForUpdateToDeleteTest();
    Firewall originFirewallInfo = firewalls.get(0);

    firewallRepository.insertFirewall(originFirewallInfo);

    Firewall expectResult = firewalls.get(1);

    // --- act ---
    firewallRepository.updateFirewallToDelete(originFirewallInfo);
    Firewall searchResult = firewallRepository.getFirewall(originFirewallInfo);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  @Test
  public void get_firewall_info_when_update()
      throws Exception {
    // --- arrange ---
    // 1개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForUpdateTest();
    Firewall originFirewallInfo = firewalls.get(0);
    Firewall updateFirewallInfo = firewalls.get(1);

    firewallRepository.insertFirewall(originFirewallInfo);

    Firewall expectResult = updateFirewallInfo;

    // --- act ---
    firewallRepository.updateFirewall(updateFirewallInfo);
    Firewall searchResult = firewallRepository.getFirewall(originFirewallInfo);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  @Test
  public void get_firewall_info_when_insert()
      throws Exception {
    // --- arrange ---
    // 1개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForInsertTest();
    insertFirewallListToDB(firewalls);

    Firewall searchFirewall = FirewallRepositoryTestUtil.copyOf(firewalls.get(0));
    Firewall expectResult = searchFirewall;

    // --- act ---
    Firewall searchResult = firewallRepository.getFirewall(searchFirewall);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  @Test
  public void get_firewalls_when_insert_3_times_then_get_first_3_numbers_firewalls()
      throws Exception {
    // --- arrange ---
    // 3개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForInsertTest();
    insertFirewallListToDB(firewalls);

    Firewall searchFirewall = createSearchConditionOfSrcIP("");
    List<Firewall> expectResult = firewalls;
    expectResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- act ---
    List<Firewall> searchResult = firewallRepository.getFirewallList(searchFirewall);
    searchResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  @Test
  public void paging_when_total_20_unit_page_count_is_10_and_page_index_is_0_firewall_then_get_first_10_numbers_firewall_list()
      throws Exception {
    // --- arrange ---
    // 20개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForPagingTest();
    insertFirewallListToDB(firewalls);

    int skip = 0;
    int max = 10;
    Firewall searchFirewall = createSearchConditionOfSrcIP("");
    List<Firewall> expectResult =
        getFirewallListSkipOf(firewallRepository.getFirewallList(searchFirewall), skip, max);
    expectResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- act ---
    List<Firewall> searchResult = firewallRepository.getFirewallList(searchFirewall, skip, max);
    searchResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  @Test
  public void paging_when_total_20_unit_page_count_is_10_and_page_index_is_1_firewall_then_get_second_10_numbers_firewall_list()
      throws Exception {
    // --- arrange ---
    // 20개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForPagingTest();
    insertFirewallListToDB(firewalls);

    int skip = 1;
    int max = 10;
    Firewall searchFirewall = createSearchConditionOfSrcIP("");
    List<Firewall> expectResult =
        getFirewallListSkipOf(firewallRepository.getFirewallList(searchFirewall), skip, max);
    expectResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- act ---
    List<Firewall> searchResult = firewallRepository.getFirewallList(searchFirewall, skip, max);
    searchResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  private List<Firewall> getFirewallListSkipOf(List<Firewall> firewallList, int skip, int max) {
    List<Firewall> skipResult = new ArrayList<Firewall>();
    int last = skip + max < firewallList.size() ? skip + max : firewallList.size();
    for (int i = skip; i < last; i++) {
      skipResult.add(firewallList.get(i));
    }
    return skipResult;
  }

  @Test
  public void search_when_source_ip_condition_is_blank_then_get_whole_firewall_list()
      throws Exception {
    // --- arrange ---
    // 20개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForSearchTest();
    insertFirewallListToDB(firewalls);

    Firewall searchFirewall = createSearchConditionOfSrcIP("");

    List<Firewall> expectResult = firewalls;
    expectResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- act ---
    List<Firewall> searchResult = firewallRepository.getFirewallList(searchFirewall);
    searchResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  @Test
  public void search_when_source_ip_condition_is_1_0_0_1_then_get_filtered_firewall_list()
      throws Exception {
    // --- arrange ---
    // 20개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForSearchTest();
    insertFirewallListToDB(firewalls);

    String sourceIP = "1.0.0.1";
    Firewall searchFirewall = createSearchConditionOfSrcIP(sourceIP);

    List<Firewall> expectResult = filterdBySourceIP(firewalls, sourceIP);
    expectResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- act ---
    List<Firewall> searchResult = firewallRepository.getFirewallList(searchFirewall);
    searchResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }



  @Test
  public void search_when_destination_ip_condition_is_blank_then_get_whole_firewall_list()
      throws Exception {
    // --- arrange ---
    // 20개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForSearchTest();
    insertFirewallListToDB(firewalls);

    Firewall searchFirewall = createSearchConditionOfDestIP("");

    List<Firewall> expectResult = firewalls;
    expectResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- act ---
    List<Firewall> searchResult = firewallRepository.getFirewallList(searchFirewall);
    searchResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  @Test
  public void search_when_destination_ip_condition_is_2_0_0_1_then_get_filtered_firewall_list()
      throws Exception {
    // --- arrange ---
    // 20개의 방화벽 저장
    List<Firewall> firewalls = FirewallRepositoryTestUtil.createDummyDataForSearchTest();
    insertFirewallListToDB(firewalls);

    String destinationIP = "2.0.0.1";
    Firewall searchFirewall = createSearchConditionOfDestIP(destinationIP);

    List<Firewall> expectResult = filterdByDestinationIP(firewalls, destinationIP);
    expectResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- act ---
    List<Firewall> searchResult = firewallRepository.getFirewallList(searchFirewall);
    searchResult.sort(FirewallRepositoryTestUtil.FIREWALL_TO_STRING_COMPARATOR);

    // --- test ---
    assertEquals(expectResult.toString(), searchResult.toString());
  }

  private List<Firewall> filterdBySourceIP(List<Firewall> firewalls, String sourceIP) {
    List<Firewall> filteredResult = new ArrayList<Firewall>();
    for (Firewall firewall : firewalls) {
      if (firewall.getSourceIP().equals(sourceIP)) {
        filteredResult.add(firewall);
      }
    }
    return filteredResult;
  }

  private List<Firewall> filterdByDestinationIP(List<Firewall> firewalls, String destinationIP) {
    List<Firewall> filteredResult = new ArrayList<Firewall>();
    for (Firewall firewall : firewalls) {
      if (firewall.getDestinationIP().equals(destinationIP)) {
        filteredResult.add(firewall);
      }
    }
    return filteredResult;
  }

  private Firewall createSearchConditionOfSrcIP(String sourceIP) {
    Firewall searchFirewall = Firewall.builder()
        .sourceIP(sourceIP)
        .build();
    return searchFirewall;
  }

  private Firewall createSearchConditionOfDestIP(String destinationIP) {
    Firewall searchFirewall = Firewall.builder()
        .destinationIP(destinationIP)
        .build();
    return searchFirewall;
  }

  private void insertFirewallListToDB(List<Firewall> firewalls) {
    for (Firewall firewall : firewalls) {
      firewallRepository.insertFirewall(firewall);
    }
  }

}
