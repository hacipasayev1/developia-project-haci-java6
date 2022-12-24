package az.developia.springrest.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class UserModel {
	@Id
	private String username;
	
	private String password;
	
	private Integer enabled;
	
}
