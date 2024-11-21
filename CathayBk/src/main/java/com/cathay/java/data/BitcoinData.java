package com.cathay.java.data;

import java.util.Map;
import lombok.Data;

@Data
public class BitcoinData {

  private TimeData time;

  private String disclaimer;

  private String chartName;

  private Map<String, CoindeskData> bpi;
}
