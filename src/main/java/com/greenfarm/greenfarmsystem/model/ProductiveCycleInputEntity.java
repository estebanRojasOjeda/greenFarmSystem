package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "jt_productcycle_input")
@Data
public class ProductiveCycleInputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_cycle_input_seq")
  @SequenceGenerator(name = "prod_cycle_input_seq", sequenceName = "prod_cycle_input_seq", initialValue = 1)
  @Column(name = "productive_cycle_input_id")
  private Long idProdCycleInput;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "productive_cycle_id", nullable = true)
  private ProductiveCycleEntity productiveCycleEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "input_id", nullable = true)
  private InputEntity inputEntity;
}
