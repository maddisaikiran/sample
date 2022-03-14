package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Friend;
import com.example.demo.model.User;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
	
	@Query("select f from Friend f where f.user.id=(:userId) or f.friend.id = (:userId)")
	List<Friend> findFriendsByUserId(int userId);

}
