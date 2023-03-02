package az.developia.MarketShopHaji.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class ProductDTO {
	private Integer id;
	private String name;
	private String barcode;
	private Double price;
	private Double cost;
	private String description;
	private LocalDate registerDate;
	private LocalDate updateDate;
	
	private Double quantity;
	private Double percent;
}
