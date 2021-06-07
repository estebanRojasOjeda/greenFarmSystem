package com.greenfarm.greenfarmsystem.dto;

import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.model.SalesEntity;
import java.util.List;
import lombok.Data;


@Data
public class SalesRequestDto {

  private SalesEntity salesEntity;
  private Float price;
  private List<Long> organicProduct;
}
