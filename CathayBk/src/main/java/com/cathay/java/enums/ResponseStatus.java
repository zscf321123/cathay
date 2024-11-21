package com.cathay.java.enums;

public enum ResponseStatus {
  SUCCESS(200), FAILD(400);

  ResponseStatus(int code) {
    this.code = code;
  }

  private int code;

  public int getCode() {
    return code;
  }
}
