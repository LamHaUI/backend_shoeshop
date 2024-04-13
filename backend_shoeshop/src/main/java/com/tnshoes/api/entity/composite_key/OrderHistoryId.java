package com.tnshoes.api.entity.composite_key;

import com.tnshoes.api.common.OrderAction;
import com.tnshoes.api.entity.Order;

import lombok.Data;

@Data
public class OrderHistoryId {

	private Order order;

	private OrderAction action;

}
