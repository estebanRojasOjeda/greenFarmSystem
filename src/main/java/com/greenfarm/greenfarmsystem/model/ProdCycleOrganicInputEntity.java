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
@Table(name = "jt_productcycle_organicinput")
public class ProdCycleOrganicInputEntity {

  @Id
  @Column(name = "jt_pror_id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orin_id",
      foreignKey = @ForeignKey(name = "jt_pror_orin_id_fk"))
  private OrganicInputEntity organicInputEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prcy_id",
      foreignKey = @ForeignKey(name = "jt_pror_prcy_id_fk"))
  private ProductiveCycleEntity productiveCycleEntity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public OrganicInputEntity getOrganicInputEntity() {
    return organicInputEntity;
  }

  public void setOrganicInputEntity(
      OrganicInputEntity organicInputEntity) {
    this.organicInputEntity = organicInputEntity;
  }

  public ProductiveCycleEntity getProductiveCycleEntity() {
    return productiveCycleEntity;
  }

  public void setProductiveCycleEntity(
      ProductiveCycleEntity productiveCycleEntity) {
    this.productiveCycleEntity = productiveCycleEntity;
  }
}
