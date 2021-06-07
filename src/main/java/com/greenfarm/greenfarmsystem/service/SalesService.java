package com.greenfarm.greenfarmsystem.service;

import com.greenfarm.greenfarmsystem.dto.ProductiveCycleRequestDto;
import com.greenfarm.greenfarmsystem.dto.SalesRequestDto;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.model.SalesEntity;

public interface SalesService extends CrudService<SalesEntity>{
  SalesEntity saveSales(SalesRequestDto salesRequestDto);
}
