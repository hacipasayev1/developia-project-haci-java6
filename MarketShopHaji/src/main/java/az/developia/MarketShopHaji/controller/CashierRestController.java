package az.developia.MarketShopHaji.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopHaji.dto.UserDTO;
import az.developia.MarketShopHaji.exc.IdFalseException;
import az.developia.MarketShopHaji.exc.NotFindedProductException;
import az.developia.MarketShopHaji.exc.UsernameAlreadyDefinedException;
import az.developia.MarketShopHaji.model.AuthorityModel;
import az.developia.MarketShopHaji.model.Cashier;
import az.developia.MarketShopHaji.model.UserModel;
import az.developia.MarketShopHaji.service.GeneralService;

@RestController
@RequestMapping(path = "/cashiers")
@CrossOrigin(origins = "*")
public class CashierRestController {

	@Autowired
	private GeneralService cashierService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@PostMapping
	@PreAuthorize(value = "hasAuthority('add:cashier')")
	public void addCashier(@RequestBody UserDTO user) {

		boolean usernameFound = false;
		UserModel findedUser = cashierService.findByUsername(user.getUsername());
		if (findedUser != null) {
			usernameFound = true;
		}
		if (usernameFound) {
			throw new UsernameAlreadyDefinedException("istifadeci adi artiq istifade olunub, " + user.getUsername());
		}
		Cashier cashier = new Cashier();
		cashier.setName(user.getName());
		cashier.setSurname(user.getSurname());
		cashier.setEmail(user.getEmail());
		cashier.setPhone(user.getPhone());
		cashier.setUsername(user.getUsername());
		UserModel userModel = new UserModel();
		userModel.setUsername(user.getUsername());
		userModel.setPassword("{bcrypt}" + encoder.encode(user.getPassword()));
		userModel.setEnabled(1);
		cashierService.save(userModel);
		ArrayList<AuthorityModel> authorityModels = new ArrayList<>();
		for (String a : user.getAuths()) {
			AuthorityModel authorityModel = new AuthorityModel();
			authorityModel.setUsername(user.getUsername());
			authorityModel.setAuthority(a);
			authorityModels.add(authorityModel);
		}
		cashierService.saveAll(authorityModels);
		cashier.setId(null);
		cashierService.save(cashier);
	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('delete:cashier')")
	public void deleteById(@PathVariable Integer id) {
		cashierService.deleteById(id);
	}

	@PutMapping
	@PreAuthorize(value = "hasAuthority('update:cashier')")
	public void updateCashier(@RequestBody UserDTO user) {
		if (user.getId() == null || user.getId() == 0) {
			throw new IdFalseException("id 0 yada null ola bilmez");
		}
		Cashier c = cashierService.findByIdCashier(user.getId());
		if (c == null) {
			throw new NotFindedProductException("bu id-li kassir bazada yoxdur");
		}
		boolean usernameFound = false;
		UserModel findedUser = cashierService.findByUsername(user.getUsername());
		if (findedUser != null) {
			usernameFound = true;
		}
		if (usernameFound) {
			throw new UsernameAlreadyDefinedException("istifadeci adi artiq istifade olunub, " + user.getUsername());
		}
		Cashier cashier = new Cashier();
		cashier.setId(user.getId());
		cashier.setName(user.getName());
		cashier.setSurname(user.getSurname());
		cashier.setEmail(user.getEmail());
		cashier.setPhone(user.getPhone());
		cashier.setUsername(user.getUsername());
		UserModel userModel = new UserModel();
		userModel.setUsername(user.getUsername());
		userModel.setPassword("{bcrypt}" + encoder.encode(user.getPassword()));
		userModel.setEnabled(1);
		cashierService.save(userModel);
		ArrayList<AuthorityModel> authorityModels = new ArrayList<>();
		for (String a : user.getAuths()) {
			AuthorityModel authorityModel = new AuthorityModel();
			authorityModel.setUsername(user.getUsername());
			authorityModel.setAuthority(a);
			authorityModels.add(authorityModel);
		}
		cashierService.saveAll(authorityModels);

		cashierService.save(cashier);
	}

}
