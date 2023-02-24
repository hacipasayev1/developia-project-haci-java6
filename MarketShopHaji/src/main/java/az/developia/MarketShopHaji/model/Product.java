package az.developia.MarketShopHaji.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	private String name;
	private String barcode;
	private Double price;
	private Double cost;
	private String description;
	private Date registerDate;
	private Date updateDate;
	private Double quantity;
	private Double percent;
}
