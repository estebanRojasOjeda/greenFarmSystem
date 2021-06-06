package com.greenfarm.greenfarmsystem.dto;

import com.greenfarm.greenfarmsystem.model.InputCategoryEntity;
import com.greenfarm.greenfarmsystem.model.InputTypeEntity;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class InputDto extends ResourceSupport {
  private Long inputId;
  private String name;
  private String manufacturer;
  private String model;
  private Integer price;
  private String comments;
  private InputTypeEntity inputTypeEntity;
  private InputCategoryEntity inputCategoryEntity;
}
