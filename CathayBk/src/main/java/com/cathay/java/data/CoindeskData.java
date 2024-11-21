package com.cathay.java.data;

import java.util.Date;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class CoindeskData {

  @NotNull
  private String code;

  private String symbol;

  private String rate;

  private String description;

  @JsonAlias({"rate_float", "rateFloat"})
  private Float rateFloat;
  
  private Date updated;
}
