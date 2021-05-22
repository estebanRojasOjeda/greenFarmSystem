package com.greenfarm.greenfarmsystem.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "technological_input_type")
public class TechnoInputTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "techno_input_type_seq")
  @SequenceGenerator(name = "techno_input_type_seq", sequenceName = "techno_input_type_seq")
  @Column(name = "tity_id")
  private Integer id;

  @Column(name = "tity_name")
  private String name;

  @Column(name = "tity_manufacturer_name")
  private String manufacturer_name;

  @Column(name = "tity_model")
  private String model;

}
