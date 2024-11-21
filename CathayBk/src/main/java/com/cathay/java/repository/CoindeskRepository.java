package com.cathay.java.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cathay.java.model.CoindeskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CoindeskRepository extends JpaRepository<CoindeskModel, String> {

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM coin_desk cd WHERE cd.code = :code", nativeQuery = true)
  int deleteCoindeskByCode(@Param("code") String code);
}
