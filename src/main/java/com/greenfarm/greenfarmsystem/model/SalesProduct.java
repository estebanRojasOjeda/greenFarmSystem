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

@Entity
@Table(name = "jt_sales_organicproduct")
public class SalesProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jt_sale_orgproduct_seq")
  @SequenceGenerator(name = "jt_sale_orgproduct_seq", sequenceName = "jt_sale_orgproduct_seq")
  @Column(name = "jt_sapr_id")
  private Integer id;

  @Column(name = "jt_sapr_amount")
  private Integer amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sale_id",
      foreignKey = @ForeignKey(name = "jt_sapr_sale_id_fk"))
  private SalesEntity salesEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orpr_id",
      foreignKey = @ForeignKey(name = "jt_sapr_orpr_id_fk"))
  private OrganicProductEntity organicProductEntity;

}
