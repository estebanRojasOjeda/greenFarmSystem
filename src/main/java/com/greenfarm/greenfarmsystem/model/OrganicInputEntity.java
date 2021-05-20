package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "organic_input")
public class OrganicInputEntity {

  @Id
  @Column(name = "orin_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "orin_oity_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_input_type"))
  private OrganicInputTypeEntity organicInputTypeEntity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public OrganicInputTypeEntity getOrganicInputTypeEntity() {
    return organicInputTypeEntity;
  }

  public void setOrganicInputTypeEntity(
      OrganicInputTypeEntity organicInputTypeEntity) {
    this.organicInputTypeEntity = organicInputTypeEntity;
  }
}
