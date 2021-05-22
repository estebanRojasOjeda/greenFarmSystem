package com.greenfarm.greenfarmsystem;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.model.OrganicProductEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jt_productcycle_organicproduct")
public class ProducCycleOrganicProduct {

  @Id
  @Column(name = "jt_pcop_id")
  private Integer id;

  @Column(name = "prcy_production_amount")
  private Integer production_amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prcy_id",
      foreignKey = @ForeignKey(name = "jt_pcop_prcy_id_fk"))
  private ProductiveCycleEntity productiveCycleEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orpr_id",
      foreignKey = @ForeignKey(name = "jt_pcop_orpr_id_fk"))
  private OrganicProductEntity organicProductEntity;

}
