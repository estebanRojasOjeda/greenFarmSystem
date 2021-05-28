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
@Table(name = "jt_sales_organicproduct")
public class SalesProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jt_sale_orgproduct_seq")
  @SequenceGenerator(name = "jt_sale_orgproduct_seq", sequenceName = "jt_sale_orgproduct_seq", initialValue = 1)
  @Column(name = "jt_sapr_id")
  private Long id;

  @NotNull
  @Column(name = "jt_sapr_amount", nullable = true)
  private Integer amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sale_id",
      foreignKey = @ForeignKey(name = "jt_sapr_sale_id_fk"))
  private SalesEntity salesEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orpr_id",
      foreignKey = @ForeignKey(name = "jt_sapr_orpr_id_fk"))
  private OrganicProductEntity organicProductEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public SalesEntity getSalesEntity() {
    return salesEntity;
  }

  public void setSalesEntity(SalesEntity salesEntity) {
    this.salesEntity = salesEntity;
  }

  public OrganicProductEntity getOrganicProductEntity() {
    return organicProductEntity;
  }

  public void setOrganicProductEntity(
      OrganicProductEntity organicProductEntity) {
    this.organicProductEntity = organicProductEntity;
  }
}
