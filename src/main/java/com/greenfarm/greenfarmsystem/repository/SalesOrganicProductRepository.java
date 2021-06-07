package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.SalesOrganicProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrganicProductRepository extends JpaRepository<SalesOrganicProductEntity, Long> {

  @Modifying
  @Query(value =
      "INSERT INTO jt_sales_organicproduct(jt_sapr_id, sale_id, org_product_id, jt_sapr_price) "
          + "VALUES (nextval('jt_sale_orgproduct_seq'), :salesProductId, :organicProductId, :price)", nativeQuery = true)
  Integer registrar(@Param("salesProductId") Long salesProductId,
      @Param("organicProductId") Long organicProductId,
      @Param("price") Float price);

}
