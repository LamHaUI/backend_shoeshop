package com.tnshoes.api.entity.composite_key;

import com.tnshoes.api.entity.Color;
import com.tnshoes.api.entity.Product;
import com.tnshoes.api.entity.Size;

import lombok.Data;

@Data
public class ProductItemId {

	private Product product;

	private Size size;

	private Color color;

}
