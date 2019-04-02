package com.huishu.productcomplains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.huishu.productcomplains.model.ProductComplains;


public interface ProductComplainsMapper {
	
	ProductComplains getProductComplainsById(String id);

	List<ProductComplains> getProductComplainsList();

	//public int add(ProductComplains productComplains);

	int delete(String id);
	
}
