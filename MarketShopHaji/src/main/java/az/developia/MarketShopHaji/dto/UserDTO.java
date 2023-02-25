package az.developia.MarketShopHaji.dto;

import java.util.List;

import lombok.Data;
@Data
public class UserDTO {
	private Integer id;
private String username;
private String password;
private List<String> auths;
private String name;
private String surname;
private String email;
private String phone;
}
