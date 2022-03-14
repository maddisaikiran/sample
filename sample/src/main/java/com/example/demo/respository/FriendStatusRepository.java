package com.example.demo.respository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Friend;
import com.example.demo.model.FriendStatus;

@Repository
public interface FriendStatusRepository extends JpaRepository<FriendStatus, Integer>{

	@Query("select fs from FriendStatus fs where fs.code=(:statusCode)")
	FriendStatus findByCode(String statusCode);

	
	//List<Friend> getUserByFriendByOrderStatusById(int id);

}
