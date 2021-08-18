package com.equitas.userservice.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equitas.userservice.dto.ResponseDTO;
import com.equitas.userservice.dto.UserDTO;
import com.equitas.userservice.dto.UserLoginDTO;
import com.equitas.userservice.entity.User;
import com.equitas.userservice.repository.UserRepository;
import com.equitas.userservice.service.UserServiceImpl;


@RequestMapping("/user")
@RestController
public class UserController {
	
		
		@Autowired
		private UserServiceImpl userServiceImpl;
		
		@Autowired
		private UserRepository userRepository;
		
		@RequestMapping("/search/{userName}")
		public ResponseEntity<ResponseDTO> searchUserByUserName(@PathVariable("userName") String userName) {
			User userData = userServiceImpl.searchUserByUserName(userName);
			ResponseDTO resDTO = new ResponseDTO("Get call for search Successfull",userData);
			return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
		}
		@RequestMapping(method = RequestMethod.POST, value = "/create", produces = "application/json")
		public ResponseEntity<ResponseDTO> createNewUser( @Valid @RequestBody UserDTO userDto)  {
			User user = userServiceImpl.createNewUser(userDto);
			System.out.println("created new user successfully"+user);
			ResponseDTO respdto = new ResponseDTO("Created New User Successfully", user);
			return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
		}
		@GetMapping("/getUserData")
		public List<User> getUserData() {
			return userRepository.findAll();
		}

		
		@GetMapping("/{userId}")
		public ResponseEntity<ResponseDTO> getUserByUserId(@PathVariable("userId") String userId) {
			User userdata = userServiceImpl.getRecordsByUserIdAndAppId(userId);
			System.out.println("Get user Successfully"+userdata);
			ResponseDTO respdto = new ResponseDTO("get User Successfully", userdata);
			return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
		}
		
		@PutMapping("/updateUserData/{userId}")
		public ResponseEntity<ResponseDTO> updateuserById(@PathVariable("userId") String userId, @Valid @RequestBody UserDTO userDto) {
			User userdata = userServiceImpl.updateUserById(userId, userDto);
			System.out.println("updated user Successfully"+userdata);
			ResponseDTO respdto = new ResponseDTO("updated User Successfully", userdata);
			return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{userId}")
		public ResponseEntity<ResponseDTO> deleteUserData(@PathVariable("userId") String userId) {
			 userServiceImpl.deleteUserData(userId);
			ResponseDTO resDTO = new ResponseDTO("deleted  Successfully","Deleted Id:" +userId );
			return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@GetMapping("/verify/{userId}")
		public ResponseEntity verifyEmail(@PathVariable String userId) {
			userServiceImpl.verifyUser(userId);
			ResponseDTO resDTO = new ResponseDTO("verified  Successfully","verified" +userId );
			return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
		}
		@PostMapping("/login")
		public ResponseEntity<ResponseDTO> userlogin(@Valid @RequestBody UserLoginDTO userLoginDTO) {
			String userLogin = userServiceImpl.userLogin(userLoginDTO);
			User userData=userServiceImpl.getUserById(userLogin);
			ResponseDTO response = new ResponseDTO( userLogin, userData);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		}

		
	}


