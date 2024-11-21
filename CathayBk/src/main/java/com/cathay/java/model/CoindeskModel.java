package com.cathay.java.model;

import java.util.Date;
import com.cathay.java.data.CoindeskData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "coin_desk")
public class CoindeskModel {

  @Id
  private String code;

  @Column(name = "symbol")
  private String symbol;

  @Column(name = "rate")
  private String rate;

  @Column(name = "description")
  private String description;

  @Column(name = "rate_float")
  private Float rateFloat;

  @Column(name = "updated")
  private Date updated;

  public CoindeskModel(CoindeskData data) {
    this.code = data.getCode();
    this.symbol = data.getSymbol();
    this.rate = data.getRate();
    this.description = data.getDescription();
    this.rateFloat = data.getRateFloat();
    this.updated = data.getUpdated();
  }
}
