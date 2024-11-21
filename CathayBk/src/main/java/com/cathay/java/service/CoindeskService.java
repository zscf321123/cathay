package com.cathay.java.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cathay.java.data.CoindeskData;
import com.cathay.java.model.CoindeskModel;
import com.cathay.java.repository.CoindeskRepository;

@Service
public class CoindeskService {

  @Autowired
  private CoindeskRepository coindeskRepository;

  public List<CoindeskModel> queryCoinList() {
    var coinList = coindeskRepository.findAll();

    return coinList;
  }

  public boolean deleteCoindesk(CoindeskData data) {
    var rows = coindeskRepository.deleteCoindeskByCode(data.getCode());

    return rows > 0;
  }

  public boolean addCoindesk(CoindeskData data) {
    if (coindeskRepository.existsById(data.getCode())) {
      return false;
    }
    data.setUpdated(new Date());
    var model = new CoindeskModel(data);
    coindeskRepository.save(model);

    return true;
  }

  public boolean updateCoindesk(CoindeskData data) {
    if (!coindeskRepository.existsById(data.getCode())) {
      return false;
    }
    data.setUpdated(new Date());
    var model = new CoindeskModel(data);
    coindeskRepository.save(model);
    return true;
  }

}
