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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productive_cycle")
public class ProductiveCycleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodcycle_seq")
  @SequenceGenerator(name = "prodcycle_seq", sequenceName = "prodcycle_seq", initialValue = 1)
  @Column(name = "prcy_id")
  private Long id;

  @NotNull
  @Column(name = "prcy_start_date", nullable = true)
  private LocalDateTime startDate;

  @NotNull
  @Column(name = "prcy_end_date", nullable = true)
  private LocalDateTime endDate;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }
}
