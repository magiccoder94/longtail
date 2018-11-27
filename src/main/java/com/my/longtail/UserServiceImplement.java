package com.my.longtail;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.my.longtail.logger.Logger;
import com.my.longtail.model.AccountType;
import com.my.longtail.model.Users;
import com.my.longtail.property.Property;
import com.my.longtail.repositories.RoleRepository;
import com.my.longtail.repositories.UsersRepository;

public class UserServiceImplement implements UserService{
	
	@Autowired
	UserService userService;
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();

	@Override
	public Users registerUser(Map userAttribute) {
		Users user = new Users();
		//google user info 
		user.setFirstName(userAttribute.get("given_name").toString());
		user.setLastName(userAttribute.get("family_name").toString());
		user.setEmail(userAttribute.get("email").toString());
		user.setAccountType(AccountType.INVESTOR);
		//facebook user info NOT SAVE
		
		user = userRepository.save(user);
		if(user == null)
			Logger.writeActivity("Fail to save user", foldername);
		
		return user;
	}
	
}
