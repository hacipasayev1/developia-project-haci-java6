package az.developia.springxml;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter(value="s")
public class StudentDTO {
	private Integer id;

	private String name;

	private String surname;
	
	private String phone;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public StudentDTO(Integer id, String name, String surname) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

}
