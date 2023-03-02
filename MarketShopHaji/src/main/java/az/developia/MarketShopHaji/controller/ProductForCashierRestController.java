package az.developia.MarketShopHaji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.service.ProductService;

@RequestMapping(path = "/productforcashier")
@CrossOrigin(origins = "*")
@RestController
public class ProductForCashierRestController {
	
	@Autowired
	private ProductService productService;
	
	
@GetMapping
@PreAuthorize("hasAuthority('productAllInfo:forCashier')")
public List<Product> productInfo(@RequestParam(name="barcode",required = false,defaultValue = "") String barcode){
	return productService.productAllInfo(barcode);
}

}
