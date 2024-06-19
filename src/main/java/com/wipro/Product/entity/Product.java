package com.wipro.Product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@Table(name="Product_Details")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;
	@NotBlank(message="name is mandatory")
	private String pname;
	@NotNull(message="price is mandatory")
	private Double price;
	@NotNull(message="Quantity is mandatory")
	private Integer qty;

}
