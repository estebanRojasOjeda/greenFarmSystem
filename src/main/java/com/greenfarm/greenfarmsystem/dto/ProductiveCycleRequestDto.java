package com.greenfarm.greenfarmsystem.dto;

import com.greenfarm.greenfarmsystem.model.InputEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import java.util.List;
import lombok.Data;


@Data
public class ProductiveCycleRequestDto {

  private ProductiveCycleEntity productiveCycleEntity;
  private List<Long> inputIds;
}
