package az.developia.MarketShopHaji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.repository.ProductRepo;
@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	public Product save(Product product) {
		Double percent=(product.getCost()/product.getPrice())*100;
		
		product.setPercent(100-percent);
		productRepo.save(product);
		return product;

	}

	public Product findById(Integer id) {
		Optional<Product> finded = productRepo.findById(id);
		if (finded.isPresent()) {
			return finded.get();
		} else {
			return null;
		}
	}

	public List<Product> findAll() {
		
		return productRepo.findAll();
	}

	public void deleteById(Integer id) {
productRepo.deleteById(id);		
	}

}
