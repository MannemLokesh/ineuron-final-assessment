package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>
{

}
