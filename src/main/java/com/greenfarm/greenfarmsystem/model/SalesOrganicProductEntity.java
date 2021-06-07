package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "jt_sales_organicproduct")
public class SalesOrganicProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jt_sale_orgproduct_seq")
  @SequenceGenerator(name = "jt_sale_orgproduct_seq", sequenceName = "jt_sale_orgproduct_seq", initialValue = 1)
  @Column(name = "jt_sapr_id")
  private Long salesProductId;

  @NotNull
  @Column(name = "jt_sapr_price", nullable = false)
  private Float price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sale_id",
      foreignKey = @ForeignKey(name = "jt_sapr_sale_id_fk"))
  private SalesEntity salesEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_product_id",
      foreignKey = @ForeignKey(name = "jt_sapr_orpr_id_fk"))
  private OrganicProductEntity organicProductEntity;


}
