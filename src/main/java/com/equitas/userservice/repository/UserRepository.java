package com.equitas.userservice.repository;

import java.util.Optional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.equitas.userservice.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

	@Query(value="select * from  user_data where USER_ID= :userId ",nativeQuery = true)
	User findUsersByUserIdAndAppId(@Param("userId") String userId);
	
	Optional<User> findByUserId(String userId);
	
	
	@Query(value="delete from  user_data where USER_ID= :userId ",nativeQuery = true)
	User deleteUserByUserId(@Param("userId") String userId);

	User searchUserByuserName(String userName);


	Optional<User> findByUserEml1(String userEml1);

	
	
	
}
