package az.developia.springrest.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Size(min=2,message = "min 2 olar")
	@Size(max=20,message = "max 20 olar")
	private String name;
	@Size(min=2,message = "min 2 olar")
	@Size(max=20,message = "max 20 olar")
	private String surname;
	private String phone;
	private String address;
	@Pattern(regexp="[a-z]+@[a-z]+\\.[a-z]{2,4}",message = "emaili duz yaz")
	private String email;
	private Date birthday;
	private String sector;
}
