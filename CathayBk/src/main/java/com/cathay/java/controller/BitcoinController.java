package com.cathay.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cathay.java.enums.ResponseStatus;
import com.cathay.java.service.BitcoinService;
import com.cathay.java.util.ResponseData;

@Controller
@RequestMapping("/bitcoin")
public class BitcoinController {

  @Autowired
  private BitcoinService bitcoinService;

  @PostMapping("/get")
  @ResponseBody
  public ResponseData callBitcoin() {

    return new ResponseData(ResponseStatus.SUCCESS.getCode(), bitcoinService.getBitcoin());
  }

  @PostMapping("/transfer")
  @ResponseBody
  public ResponseData transferBitcoin() {
    bitcoinService.transferBitcoin();

    return new ResponseData(ResponseStatus.SUCCESS.getCode(), "");
  }

}
