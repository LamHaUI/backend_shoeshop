package com.tnshoes.api.entity.composite_key;

import com.tnshoes.api.entity.Order;
import com.tnshoes.api.entity.ProductItem;

import lombok.Data;

@Data
public class OrderDetailId {

	private Order order;

	private ProductItem product;

}
