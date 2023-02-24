package az.developia.MarketShopHaji.dto;

import java.util.List;

import lombok.Data;
@Data
public class UserDTO {
private String username;
private String password;
private List<String> auths;
}
