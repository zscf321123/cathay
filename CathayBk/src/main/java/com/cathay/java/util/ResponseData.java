package com.cathay.java.util;

import com.cathay.java.enums.ResponseStatus;
import lombok.Data;

@Data
public class ResponseData {

  private Integer code;

  private Object msg;

  public ResponseData(int code, Object msg) {
    this.code = code;
    this.msg = msg;
  }
  
  public ResponseData(Object msg) {
    this.code = ResponseStatus.SUCCESS.getCode();
    this.msg = msg;
  }
}
