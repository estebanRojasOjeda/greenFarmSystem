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

@Entity
@Table(name = "jt_productcycle_organicproduct")
public class ProductiveCycleOrganicProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jt_prcy_orgproduct_seq")
  @SequenceGenerator(name = "jt_prcy_orgproduct_seq", sequenceName = "jt_prcy_orgproduct_seq", initialValue=1)
  @Column(name = "jt_pcop_id")
  private Long id;

  @NotNull
  @Column(name = "prcy_production_amount", nullable = true)
  private Integer production_amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prod_cycle_id",
      foreignKey = @ForeignKey(name = "jt_pcop_prcy_id_fk"))
  private ProductiveCycleEntity productiveCycleEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_product_id",
      foreignKey = @ForeignKey(name = "jt_pcop_orpr_id_fk"))
  private OrganicProductEntity organicProductEntity;


}
