package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "technological_input")
public class TechnoInput {

  @Id
  @Column(name = "tein_id")
  private Integer id;

  @Column(name = "tein_start_date")
  private LocalDateTime start_date;

  @Column(name = "tein_end_date")
  private LocalDateTime end_date;


}
