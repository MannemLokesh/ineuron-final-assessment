package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Users;
import in.ineuron.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository repository;
	
	public String postUserDetails(Users users)
	{
		repository.save(users);
		return "UserSaved";
	}
	
	public String validateUser(Users users)
	{
		Optional<Users> findById = repository.findById(users.getUserName());
		if(findById.isEmpty())
		{
			return "InvalidCredentials";
		}
		else
		{
			Users users2 = findById.get();
			if(users2.getPassword().equals(users.getPassword()))
			{
				return "ValidUser";
			}
			else
			{
				return "InvalidCredentials";
			}
			
		}
	}
}
