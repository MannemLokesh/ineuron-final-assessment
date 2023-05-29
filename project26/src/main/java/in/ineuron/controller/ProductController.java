package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Products;
import in.ineuron.service.ProductsService;

@RestController
public class ProductController
{
	@Autowired
	private ProductsService productsService;
	
	@PostMapping("/createProduct")
	public ResponseEntity<String> createProduct(Products products)
	{
		String createProduct = productsService.createProduct(products);
		
		if(createProduct.equals("ProductCreated"))
		{
			return new ResponseEntity<>("ProductCreated", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("SomeThingWentWront", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(Products products)
	{
		
		String updateProduct = productsService.updateProduct(products);
		
		if(updateProduct.equals("ProductUpdated"))
		{
			return new ResponseEntity<>("ProductUpdated", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("ProductNotExistWithId", HttpStatus.OK);
		}
	}
	
	@PostMapping("/deleteProduct")
	public ResponseEntity<String> deleteProduct(Products products)
	{
		String deleteProduct = productsService.deleteProduct(products);
		
		if(deleteProduct.equals("ProductDeleted"))
		{
			return new ResponseEntity<>("ProductDeleted", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("ProductNotExistWithEnteredID", HttpStatus.OK);
		}
	}
	
	@GetMapping("/retriveProduct/{productId}")
	public ResponseEntity<Products> retriveProduct(@PathVariable int productId)
	{
		System.out.println(productId);
		Products products = new Products();
		products.setProductId(productId);
		Products retriveProduct = productsService.retriveProduct(products);
		
		if(retriveProduct!=null)
		{
			return new ResponseEntity<>(retriveProduct, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
