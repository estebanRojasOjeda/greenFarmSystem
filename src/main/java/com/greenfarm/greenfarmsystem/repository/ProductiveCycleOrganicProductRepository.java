package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.ProductiveCycleInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductiveCycleOrganicProductRepository extends
    JpaRepository<ProductiveCycleInputEntity, Long> {

  @Modifying
  @Query(value =
      "INSERT INTO jt_productcycle_organicproduct(jt_pcop_id, productive_cycle_id, org_product_id, prcy_production_amount) "
          + "VALUES (nextval('jt_prcy_orgproduct_seq'), :productiveCycleId, :organicProductId, :amount)", nativeQuery = true)
  Integer registrar(@Param("productiveCycleId") Long productiveCycleId,
      @Param("organicProductId") Long organicProductId,
      @Param("amount") Long amount);

}
