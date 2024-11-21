package com.cathay.java.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cathay.java.data.CoindeskData;
import com.cathay.java.enums.ResponseStatus;
import com.cathay.java.service.CoindeskService;
import com.cathay.java.util.ResponseData;

@Controller
@RequestMapping("/coindesk")
public class CoindeskController {

  @Autowired
  private CoindeskService coindeskService;

  @PostMapping("/query")
  @ResponseBody
  public ResponseData queryCoindesk() {
    var data = coindeskService.queryCoinList();

    return new ResponseData(ResponseStatus.SUCCESS.getCode(), data);
  }

  @PostMapping("/delete")
  @ResponseBody
  public ResponseData deleteCoindesk(@RequestBody @Valid CoindeskData data) {
    var status = coindeskService.deleteCoindesk(data);
    var code = status ? ResponseStatus.SUCCESS : ResponseStatus.FAILD;

    return new ResponseData(code.getCode(), "");
  }

  @PostMapping("/update")
  @ResponseBody
  public ResponseData updateCoindesk(@RequestBody @Valid CoindeskData data) {
    var status = coindeskService.updateCoindesk(data);
    var code = status ? ResponseStatus.SUCCESS : ResponseStatus.FAILD;

    return new ResponseData(code.getCode(), "");
  }

  @PostMapping("/add")
  @ResponseBody
  public ResponseData addCoindesk(@RequestBody @Valid CoindeskData data) {
    var status = coindeskService.addCoindesk(data);
    var code = status ? ResponseStatus.SUCCESS : ResponseStatus.FAILD;

    return new ResponseData(code.getCode(), "");
  }

}
