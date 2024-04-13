package com.tnshoes.api.entity.composite_key;

import com.tnshoes.api.entity.ProductItem;
import com.tnshoes.api.entity.Receipt;

import lombok.Data;

@Data
public class ReceiptDetailId {

	private Receipt receipt;

	private ProductItem product;

}
