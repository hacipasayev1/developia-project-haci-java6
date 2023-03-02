package az.developia.MarketShopHaji.service;

import java.time.LocalDate;
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
		LocalDate indi=LocalDate.now();
		product.setRegisterDate(indi);
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

	public List<Product> searchProduct(String date,String name,String price,String cost,String percent,String quantity) {
		
		return productRepo.searchProduct(date,name,price,cost,percent,quantity);
	}

	public List<Product> productAllInfo(String barcode) {
		
		return productRepo.findAllByBarcode(barcode);
	}



}
