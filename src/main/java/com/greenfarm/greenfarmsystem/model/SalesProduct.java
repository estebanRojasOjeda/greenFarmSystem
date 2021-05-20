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
@Table(name = "jt_sales_organicproduct")
public class SalesProduct {
  @Id
  @Column(name = "jt_sapr_id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sale_id",
      foreignKey = @ForeignKey(name = "jt_sapr_sale_id_fk"))
  private SalesEntity salesEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orpr_id",
      foreignKey = @ForeignKey(name = "jt_sapr_orpr_id_fk"))
  private OrganicProductEntity organicProductEntity;

}
