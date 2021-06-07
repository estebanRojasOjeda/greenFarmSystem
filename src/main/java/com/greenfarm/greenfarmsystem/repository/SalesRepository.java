package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Long> {

  @Modifying
  @Query(value =
      "INSERT INTO jt_productcycle_input(productive_cycle_input_id, productive_cycle_id, input_id) "
          + "VALUES (nextval('prod_cycle_input_seq'), :productiveCycleId, :inputId)", nativeQuery = true)
  Integer registrar(@Param("productiveCycleId") Long productiveCycleId,
      @Param("inputId") Long inputId);

}
