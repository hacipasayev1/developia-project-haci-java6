package az.developia.MarketShopHaji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.MarketShopHaji.model.AuthorityModel;
import az.developia.MarketShopHaji.model.UserModel;
import az.developia.MarketShopHaji.repository.AuthRepo;
import az.developia.MarketShopHaji.repository.UserRepo;

@Service
public class AdminService {
@Autowired
private UserRepo userRepo;
@Autowired
private AuthRepo authRepo;


public void save(UserModel user) {
	userRepo.save(user);
}

public void saveAll(List<AuthorityModel> authorityModels) {
	authRepo.saveAll(authorityModels);
}

public UserModel findByUsername(String username) {
	return userRepo.findByUsername(username);
}
}
