package com.greenfarm.greenfarmsystem.model;

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
import lombok.Data;

@Entity
@Table(name = "user_gfs")
@Data
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1)
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "user_name")
  private String username;

  @Column(name = "user_pass")
  private String password;

  @Column(name = "user_state")
  private boolean userState;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "jt_user_rol",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"))
  private List<RolEntity> rolEntityList;

}
