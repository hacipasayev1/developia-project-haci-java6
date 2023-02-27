package az.developia.MarketShopHaji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopHaji.exc.IdFalseException;
import az.developia.MarketShopHaji.exc.NotFindedProductException;
import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.service.GeneralService;
import az.developia.MarketShopHaji.service.ProductService;

@RestController
@RequestMapping(path = "products")
@CrossOrigin(origins = "*")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('findAll:product')")
	public List<Product> findAll(){
		return productService.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('add:product')")
	public Product addProduct(@RequestBody Product product) {
		product.setId(null);
		productService.save(product);
		return product;
	}

	@PutMapping
	@PreAuthorize("hasAuthority('update:product')")
	public Product updateProduct(@RequestBody Product product) {
		if (product.getId() == null || product.getId() == 0) {
			throw new IdFalseException("id 0 yada null ola bilmez");
		}

		Product p = productService.findById(product.getId());
		if(p==null) {
			throw new NotFindedProductException("bu id-li mehsul bazada yoxdur");
		}
		productService.save(product);
		return product;
	}
	@DeleteMapping(path="{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteById(id);
	}
}
