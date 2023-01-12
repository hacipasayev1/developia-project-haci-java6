package az.developia.springrest.model;

import java.util.List;

import lombok.Data;

@Data
public class BookDTO {
	private String name;
	private Double price;

	private List<Integer> authorIds;
}
