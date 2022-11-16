package com.boot.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity
public class AddCart {

	@Id
	private int cartIteamId;
	private String cartIteamName;
	private String cartIteamImage;
	private String cartIteamQuantity;
	private String cartIteamDescription;
	
}
