package com.tnshoes.api.entity.composite_key;

import com.tnshoes.api.entity.Color;
import com.tnshoes.api.entity.Product;
import com.tnshoes.api.entity.Size;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Embeddable
@AttributeOverrides({
	  @AttributeOverride( name = "product", column = @Column(name = "product_id", nullable = false)),
	  @AttributeOverride( name = "size", column = @Column(name = "size_id", nullable = false)),
	  @AttributeOverride( name = "color", column = @Column(name = "color_id", nullable = false))
})
public class ProductItemId {

	private Product product;

	private Size size;

	private Color color;

}
