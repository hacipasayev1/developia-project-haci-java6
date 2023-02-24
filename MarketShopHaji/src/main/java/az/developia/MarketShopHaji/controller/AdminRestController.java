package az.developia.MarketShopHaji.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopHaji.dto.UserDTO;
import az.developia.MarketShopHaji.exc.UsernameAlreadyDefinedException;
import az.developia.MarketShopHaji.model.AuthorityModel;
import az.developia.MarketShopHaji.model.UserModel;
import az.developia.MarketShopHaji.service.AdminService;

@RestController
@RequestMapping(path = "/admins")
@CrossOrigin(origins = "*")
public class AdminRestController {

	@Autowired
	private AdminService adminService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@PostMapping
	@PreAuthorize(value = "hasAuthority('add:cashier')")
	public void addCashier(@RequestBody UserDTO user) {
		
		boolean usernameFound=false;
		UserModel findedUser=adminService.findByUsername(user.getUsername());
		if(findedUser!=null) {
			usernameFound=true;
		}
		if(usernameFound) {
			throw new UsernameAlreadyDefinedException("istifadeci adi artiq istifade olunub, "+user.getUsername());
		}
		UserModel userModel = new UserModel();
		userModel.setUsername(user.getUsername());
		userModel.setPassword("{bcrypt}" + encoder.encode(user.getPassword()));
		userModel.setEnabled(1);
		adminService.save(userModel);
		ArrayList<AuthorityModel> authorityModels = new ArrayList<>();
		for (String a : user.getAuths()) {
			AuthorityModel authorityModel = new AuthorityModel();
			authorityModel.setUsername(user.getUsername());
			authorityModel.setAuthority(a);
			authorityModels.add(authorityModel);
		}
		adminService.saveAll(authorityModels);

	}
}
