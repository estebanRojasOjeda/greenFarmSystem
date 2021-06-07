package com.greenfarm.greenfarmsystem.service;

import com.greenfarm.greenfarmsystem.dto.ProductiveCycleRequestDto;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;

public interface ProductiveCycleService extends CrudService<ProductiveCycleEntity>{

  ProductiveCycleEntity saveProdCycleDetail(ProductiveCycleRequestDto productiveCycleRequestDto);

}
