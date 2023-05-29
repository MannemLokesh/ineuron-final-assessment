package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Products;
import in.ineuron.repository.ProductRepository;


@Service
public class ProductsService 
{
	@Autowired
	private ProductRepository repository;
	
	public String createProduct(Products products)
	{
		boolean flag=true;
		try
		{
			repository.save(products);
		}
		catch(Exception exception)
		{
			flag=false;
		}
		
		if(flag)
			return "ProductCreated";
		else
			return "Exception Occured";
	}
	
	
	public String updateProduct(Products products)
	{
		Optional<Products> findById = repository.findById(products.getProductId());
		if(findById.isEmpty())
		{
			return "ProductNotExistWithId";
		}
		else
		{
			Products products2 = findById.get();
			products2.setProductCost(products.getProductCost());
			products2.setProductDescription(products.getProductDescription());
			products2.setProductName(products.getProductName());
			products2.setProductRating(products.getProductRating());
			
			repository.save(products2);
			return "ProductUpdated";
		}
	}
	
	public String deleteProduct(Products products)
	{
		Optional<Products> findById = repository.findById(products.getProductId());
		if(findById.isEmpty())
		{
			return "ProductNotExistWithEnteredID";
		}
		else
		{
			repository.deleteById(products.getProductId());
			return "ProductDeleted";
		}
	}
	
	public Products retriveProduct(Products products)
	{
		Optional<Products> findById = repository.findById(products.getProductId());
		if(findById.isPresent())
		{
			return findById.get();
		}
		else
		{
			return null;
		}
	}
}
