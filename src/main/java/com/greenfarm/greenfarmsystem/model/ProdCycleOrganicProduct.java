package com.greenfarm.greenfarmsystem.model;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.model.OrganicProductEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
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
public class ProdCycleOrganicProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jt_prcy_orgproduct_seq")
  @SequenceGenerator(name = "jt_prcy_orgproduct_seq", sequenceName = "jt_prcy_orgproduct_seq", initialValue=1)
  @Column(name = "jt_pcop_id")
  private Long id;

  @NotNull
  @Column(name = "prcy_production_amount", nullable = true)
  private Integer production_amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prcy_id",
      foreignKey = @ForeignKey(name = "jt_pcop_prcy_id_fk"))
  private ProductiveCycleEntity productiveCycleEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orpr_id",
      foreignKey = @ForeignKey(name = "jt_pcop_orpr_id_fk"))
  private OrganicProductEntity organicProductEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getProduction_amount() {
    return production_amount;
  }

  public void setProduction_amount(Integer production_amount) {
    this.production_amount = production_amount;
  }

  public ProductiveCycleEntity getProductiveCycleEntity() {
    return productiveCycleEntity;
  }

  public void setProductiveCycleEntity(
      ProductiveCycleEntity productiveCycleEntity) {
    this.productiveCycleEntity = productiveCycleEntity;
  }

  public OrganicProductEntity getOrganicProductEntity() {
    return organicProductEntity;
  }

  public void setOrganicProductEntity(
      OrganicProductEntity organicProductEntity) {
    this.organicProductEntity = organicProductEntity;
  }
}
