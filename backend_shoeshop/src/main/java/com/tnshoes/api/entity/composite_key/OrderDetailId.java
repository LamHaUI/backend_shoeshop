package com.tnshoes.api.entity.composite_key;

import com.tnshoes.api.entity.Order;
import com.tnshoes.api.entity.ProductPrice;

import lombok.Data;

@Data
public class OrderDetailId {

	private Order order;

	private ProductPrice product;

}
