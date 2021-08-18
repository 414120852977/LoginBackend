package com.equitas.userservice.service;

import java.util.Optional;



import java.util.UUID;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.equitas.userservice.dto.UserDTO;
import com.equitas.userservice.dto.UserLoginDTO;
import com.equitas.userservice.entity.User;
import com.equitas.userservice.exception.UserDataException;
import com.equitas.userservice.repository.UserRepository;
import com.equitas.userservice.util.Token;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	Token jwtToken = new Token();
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
	
	
	
	
	public  User getRecordsByUserIdAndAppId(String userId) {
		return userRepository.findUsersByUserIdAndAppId(userId);
	}
	
	public User createNewUser(UserDTO userDto) {
		Optional<User> userData = userRepository.findByUserId(userDto.getUserId());
		if(userData.isPresent()) {
			throw new DataException("User already exists with " + userDto.getUserId() + " user Id", null);
		}
		else {
			String password = bCryptPasswordEncoder.encode(userDto.getPassword());	
			userDto.setPassword(password);
			User user = new User(userDto.getUserId(),
					userDto.getAppId(),
					userDto.getPin(),
					userDto.getUserName(),
					userDto.getLoginStatus(),
					userDto.getUserAdd1(),
					userDto.getUserAdd2(),
					userDto.getUserAdd3(),
					userDto.getUserAdd4(),
					userDto.getUserEml1(),
					userDto.getUserEml2(),
					userDto.getUserPhone1(),
					userDto.getUserPhone2(),
					userDto.getProfilePic(),
					userDto.isVerified(),
					password
					);
//				userDto.getUserRole());
					
			User saveUser = userRepository.save(user);
			return saveUser;
			
				
			
		}
		
		
	}

	public User updateUserById( String userId, UserDTO userData) {
		
		User user = userRepository.findUsersByUserIdAndAppId(userId);
								
		user.setAppId(userData.getAppId());
		user.setPin(userData.getPin());
		user.setUserName(userData.getUserName());
		user.setLoginStatus(userData.getLoginStatus());
		user.setUserAdd1(userData.getUserAdd1());
		user.setUserAdd2(userData.getUserAdd2());
		user.setUserAdd3(userData.getUserAdd3());
		user.setUserAdd4(userData.getUserAdd4());
		user.setUserEml1(userData.getUserEml1());
		user.setUserEml2(userData.getUserEml2());
		user.setUserPhone1(userData.getUserPhone1());
		user.setUserPhone2(userData.getUserPhone2());
		user.setProfilePic(userData.getProfilePic());
		
		
		User saveUser = userRepository.save(user);
		return saveUser;
	}

	public User deleteUserData(String userId) {
		 return userRepository.deleteUserByUserId(userId);
	}

	public User searchUserByUserName(String userName) {
			
		return userRepository.searchUserByuserName(userName);
	}
	
	public void verifyUser(String userId) {
		
		Optional<User> userId1= userRepository.findByUserId(userId);
		if(!userId1.isPresent()) {
			System.out.println("user  is not  present");	
			
			
		}
		
		userRepository.save(userId1.get());
	}
	
//	public String userLogin(UserLoginDTO userLoginDto) {
//		  Optional<User> userEmail = userRepository.findByUserEml1(userLoginDto.getUserEml1());
//		  if (!userEmail.isPresent()) {
//	            throw new com.equitas.userServices.exception.UserDataException("User with " + userLoginDto.getUserEml1() + "  is not PRESESNT");
//	      }
//		  if(userEmail.get().isVerified){
//			  String userEmail1 = userLoginDto.getUserEml1();
//	            if (userEmail1 != userLoginDto.getUserEml1()) {
//	                throw new com.equitas.userServices.exception.UserDataException("userEmail is not matched");
//	            }
//	        }
//	        throw  new com.equitas.userServices.exception.UserDataException("Invalid User");
//	}
	
	public String userLogin(UserLoginDTO userLoginDto) {
//		  Optional<User> userEmail = userRepository.findByUserEml1(userLoginDto.getUserEml1());
		Optional<User> userEmail = userRepository.findByUserEml1(userLoginDto.getUserEml1());
		  if (!userEmail.isPresent()) {
	            throw new UserDataException("User with " + userLoginDto.getUserEml1() + "  is not PRESESNT");
	      }
		  if(userEmail.get().isVerified){
	            boolean password = bCryptPasswordEncoder.matches(userLoginDto.getPassword(), userEmail.get().getPassword());
	            if (!password) {
	                throw new UserDataException("UserEmail or Password is not matched");
	            }
	            String tokenString = jwtToken.generateVerificationtoken(userEmail.get());
	            return tokenString;
	        }
	        throw  new UserDataException("Invalid User");
	}
	

	public User getUserById(String tokenId) {
		UUID token = jwtToken.decodeJWT(tokenId);
		User userData= userRepository.findById(token).orElseThrow(() -> new UserDataException("user is not present"));
		
		if(userData.isVerified=true) {
			return userData;
		}else {
			throw new UserDataException(("User is not Verified")); 
		}
		
	}

	
	

	
	
}
