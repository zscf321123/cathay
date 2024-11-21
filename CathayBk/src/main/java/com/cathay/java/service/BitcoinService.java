package com.cathay.java.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cathay.java.data.BitcoinData;
import com.cathay.java.model.CoindeskModel;
import com.cathay.java.repository.CoindeskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BitcoinService {

  @Autowired
  private CoindeskRepository coindeskRepository;

  public BitcoinData getBitcoin() {
    return callThirdPartyApi();
  }

  public void transferBitcoin() {
    var data = callThirdPartyApi();
    var coindesk = new ArrayList<CoindeskModel>();
    data.getBpi().values().stream().forEach(v -> {
      v.setUpdated(new Date());
      coindesk.add(new CoindeskModel(v));
    });
    coindeskRepository.saveAll(coindesk);
  }

  public BitcoinData callThirdPartyApi() {
    try {
      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coindesk.com/v1/bpi/currentprice.json")).build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      ObjectMapper objectMapper = new ObjectMapper();

      BitcoinData data = objectMapper.readValue(response.body().toString(), BitcoinData.class);

      return data;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
