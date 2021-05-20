package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "technological_input")
public class TechnoInputEntity {

  @Id
  @Column(name = "tein_id")
  private Integer id;

  @Column(name = "tein_start_date")
  private LocalDateTime start_date;

  @Column(name = "tein_end_date")
  private LocalDateTime end_date;

  @ManyToOne
  @JoinColumn(name = "tein_tity_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_techno_input_type"))
  private TechnoInputTypeEntity technoInputTypeEntity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getStart_date() {
    return start_date;
  }

  public void setStart_date(LocalDateTime start_date) {
    this.start_date = start_date;
  }

  public LocalDateTime getEnd_date() {
    return end_date;
  }

  public void setEnd_date(LocalDateTime end_date) {
    this.end_date = end_date;
  }

  public TechnoInputTypeEntity getTechnoInputTypeEntity() {
    return technoInputTypeEntity;
  }

  public void setTechnoInputTypeEntity(
      TechnoInputTypeEntity technoInputTypeEntity) {
    this.technoInputTypeEntity = technoInputTypeEntity;
  }
}
