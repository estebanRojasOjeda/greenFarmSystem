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
@Table(name = "jt_productcycle_organicinput")
public class ProdCycleOrganicInputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jt_prcy_orginput_seq")
  @SequenceGenerator(name = "jt_prcy_orginput_seq", sequenceName = "jt_prcy_orginput_seq", initialValue=1)
  @Column(name = "jt_pror_id")
  private Long id;

  @NotNull
  @Column(name = "jt_pror_amount", nullable = true)
  private Integer amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orin_id",
      foreignKey = @ForeignKey(name = "jt_pror_orin_id_fk"))
  private OrganicInputEntity organicInputEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prcy_id",
      foreignKey = @ForeignKey(name = "jt_pror_prcy_id_fk"))
  private ProductiveCycleEntity productiveCycleEntity;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }
}
