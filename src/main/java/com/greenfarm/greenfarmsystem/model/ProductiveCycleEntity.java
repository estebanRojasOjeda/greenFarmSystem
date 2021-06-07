package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "productive_cycle")
@Data
public class ProductiveCycleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_cycle_seq")
  @SequenceGenerator(name = "prod_cycle_seq", sequenceName = "prod_cycle_seq", initialValue = 1)
  @Column(name = "productive_cycle_id")
  private Long productiveCycleId;

  @NotNull
  @Column(name = "prod_cycle_start_date", nullable = true)
  private LocalDateTime startDate;

  @NotNull
  @Column(name = "prod_cycle_end_date", nullable = true)
  private LocalDateTime endDate;

  @NotNull
  @Column(name = "prod_cycle_temperature", nullable = true)
  private Float temperature;

  @NotNull
  @Column(name = "prod_cycle_humudity", nullable = true)
  private Float humidity;

  @Size(min=1, max=100, message = "El comentario debe contener entre 1 y 100 caracteres")
  @Column(name = "prod_cycle_comments", length = 100, nullable = true)
  private String comments;

  @ManyToMany
  @JoinTable(
      name = "jt_productcycle_input",
      joinColumns = @JoinColumn(name = "productive_cycle_id", referencedColumnName = "productive_cycle_id"),
      inverseJoinColumns = @JoinColumn(name = "input_id", referencedColumnName = "input_id"))
  private List<InputEntity> inputEntityList;

  @ManyToMany
  @JoinTable(
      name = "jt_productcycle_organicproduct",
      joinColumns = @JoinColumn(name = "productive_cycle_id", referencedColumnName = "productive_cycle_id"),
      inverseJoinColumns = @JoinColumn(name = "org_product_id", referencedColumnName = "org_product_id"))
  private List<OrganicProductEntity> organicProductEntityList;

}
