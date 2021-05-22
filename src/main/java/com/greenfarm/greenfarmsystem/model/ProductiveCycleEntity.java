package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "productive_cycle")
public class ProductiveCycleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodcycle_seq")
  @SequenceGenerator(name = "prodcycle_seq", sequenceName = "prodcycle_seq", allocationSize = 1)
  @Column(name = "prcy_id")
  private Long id;

  @Column(name = "prcy_start_date")
  private LocalDateTime startDate;

  @Column(name = "prcy_end_date")
  private LocalDateTime endDate;


//  @ManyToOne
//  @JoinColumn(name = "prcy_orpr_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_product"))
//  private OrganicProductEntity organicProductEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getStart_date() {
    return startDate;
  }

  public void setStart_date(LocalDateTime start_date) {
    this.startDate = start_date;
  }

  public LocalDateTime getEnd_date() {
    return endDate;
  }

  public void setEnd_date(LocalDateTime end_date) {
    this.endDate = end_date;
  }

}
