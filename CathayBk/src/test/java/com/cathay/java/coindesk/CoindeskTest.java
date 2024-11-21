package com.cathay.java.coindesk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cathay.java.data.CoindeskData;
import com.cathay.java.service.BitcoinService;
import com.cathay.java.service.CoindeskService;

@SpringBootTest
public class CoindeskTest {

  @Autowired
  private CoindeskService coindeskService;

  @Autowired
  private BitcoinService bitcoinService;

  // CALL BITCOIN API
  @Test
  public void testCallThirdPartyApi() {
    var data = bitcoinService.callThirdPartyApi();

    System.out.println("bitcoin data:" + data);
  }

  // Transfer Bitcoin Api
  @Test
  public void testTransfer() {
    bitcoinService.transferBitcoin();
    var data = coindeskService.queryCoinList();

    System.out.println("data list:" + data);
  }

  // Coindesk query
  @Test
  public void testQuery() {
    var data = coindeskService.queryCoinList();

    System.out.println("data list:" + data);
  }

  // Coindesk add
  @Test
  public void testAdd() {
    var data = new CoindeskData();
    data.setCode("TWD");
    data.setDescription("Taiwaness Dollar");
    data.setRate("123,456");
    data.setRateFloat(123.456F);
    data.setSymbol("@@@");

    coindeskService.addCoindesk(data);
    var coinList = coindeskService.queryCoinList();

    System.out.println("after add list:" + coinList);
  }

  // Coindesk update
  @Test
  public void testUpdate() {
    bitcoinService.transferBitcoin();
    var data = new CoindeskData();
    data.setCode("USD");
    data.setDescription("TEST UPDATE");
    data.setRate("777,777");
    data.setRateFloat(777.777F);
    data.setSymbol("*(*");

    coindeskService.updateCoindesk(data);

    var coinList = coindeskService.queryCoinList();

    System.out.println("after update list:" + coinList);
  }

  // Coindesk delete
  @Test
  public void testDelete() {
    bitcoinService.transferBitcoin();
    var data = new CoindeskData();
    data.setCode("USD");

    coindeskService.deleteCoindesk(data);

    var coinList = coindeskService.queryCoinList();

    System.out.println("after delete list:" + coinList);
  }
}
