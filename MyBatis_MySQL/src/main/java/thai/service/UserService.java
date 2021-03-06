package thai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thai.entity.User;
import thai.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	public User getOneByName(String name) {
		
		return userRepository.getOneByName(name);
	}
	
	public boolean checkLogin(User user) {
		User u = userRepository.getOneByName(user.getName());
		if (u != null && user.getPassword().equals(u.getPassword()) ) {
			return true;
		}
		return false;
	}
	
	public boolean register(User user) {
		
		return userRepository.insertUser(user);
	}
}
