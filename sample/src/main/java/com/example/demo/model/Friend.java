package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@Data
@Entity
@Table(name="friend")
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "friend_id")
	@JsonBackReference
	private User friend;
	
	@OneToOne
	private FriendStatus status;
	
	@Transient
	private String StatusCode;
	
	

}
