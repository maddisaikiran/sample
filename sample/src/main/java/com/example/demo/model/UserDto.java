package com.example.demo.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


		private Integer id;
	
		private String fullName;
		
		private Long mobile;
	
		private String emailId;
	
		private String password;
		

		private Boolean userStatus;
		
		
		@ToString.Exclude
		private FriendDto friend;

		public static UserDto convert(User user) {
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setFullName(user.getFullName());
			userDto.setMobile(user.getMobile());
			userDto.setEmailId(user.getEmailId());
			userDto.setPassword(user.getPassword());
			if(!CollectionUtils.isEmpty(user.getFriend())) {
			userDto.setFriend(FriendDto.convert(user.getFriend().get(0)));
			}
			return userDto;
		}
}
