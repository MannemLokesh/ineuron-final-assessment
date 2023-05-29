package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, String> {

}
