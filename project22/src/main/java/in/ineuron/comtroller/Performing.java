package in.ineuron.comtroller;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.model.Orders;
import in.ineuron.model.User;
import in.ineuron.repository.UserRepository;

@Component
public class Performing 
{
	@Autowired
	private UserRepository repository;
	
	
	public void perform()
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("Choose What you want to do?");
			System.out.println("1. Create User and Order");
			System.out.println("2. Retrive Orders with UserName");
			switch(scanner.nextInt())
			{
			case 1: createUserAndOrder();
			break;
			case 2: retriveOrderWithUserId();
			break;
			}
		}
	}
	
	public void createUserAndOrder()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter UserName : ");
		String userName=scanner.next();
		System.out.print("Enter UserAge : ");
		int userAge=scanner.nextInt();
		System.out.print("Enter UserId : ");
		int userId = scanner.nextInt();
		
		
		System.out.print("Enter Order Number : ");
		String orderNo = scanner.next();
		System.out.print("Enter Item Number : ");
		String itemName = scanner.next();
		System.out.print("Enter Item Weight : ");
		int itemWeight = scanner.nextInt();
		
		Orders orders = new Orders();
		orders.setOrderNo(orderNo);
		orders.setItemWeight(itemWeight);
		orders.setItemName(itemName);
		
		User user = new User();
		user.setUserName(userName);
		user.setUserId(userId);
		user.setUserAge(userAge);
		user.setOrders(orders);
		
		repository.save(user);
		
		System.out.println("Saved To DB");
	}
	
	public void retriveOrderWithUserId()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter UserName : ");
		String userName = scanner.next();
		Optional<User> findById = repository.findById(userName);
		if(findById.isPresent())
		{
			User user = findById.get();
			Orders orders = user.getOrders();
			System.out.println(orders.getOrderNo()+"\t"+orders.getItemName()+"\t"+orders.getItemWeight());
			
		}
		else
		{
			System.out.println("Order not exist with that username");
		}
	}
}
