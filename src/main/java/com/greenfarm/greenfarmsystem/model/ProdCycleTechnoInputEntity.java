package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jt_productcycle_technoinput")
public class ProdCycleTechnoInputEntity {

  @Id
  @Column(name = "jt_prte_id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tein_id",
      foreignKey = @ForeignKey(name = "jt_prte_tity_id_fk"))
  private TechnoInputEntity technoInputEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prcy_id",
      foreignKey = @ForeignKey(name = "jt_prte_prcy_id_fk"))
  private ProductiveCycleEntity productiveCycleEntity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TechnoInputEntity getTechnoInputEntity() {
    return technoInputEntity;
  }

  public void setTechnoInputEntity(TechnoInputEntity technoInputEntity) {
    this.technoInputEntity = technoInputEntity;
  }

  public ProductiveCycleEntity getProductiveCycleEntity() {
    return productiveCycleEntity;
  }

  public void setProductiveCycleEntity(
      ProductiveCycleEntity productiveCycleEntity) {
    this.productiveCycleEntity = productiveCycleEntity;
  }
}
