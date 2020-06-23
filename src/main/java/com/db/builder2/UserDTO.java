package com.db.builder2;

import java.time.LocalDate;
import java.time.Period;

import com.db.builder.Address;

public class UserDTO {

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	private String name;
	private String age;
	private String address;
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	
	private void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	
	
	public static UserDTOBuilder getUserDTOBuilder () {
		return new UserDTOBuilder();
	}
	
	public static class UserDTOBuilder {
		
		private String firstName;
		private String lastName;
		private String age;
		private String address;
		private UserDTO userDTO;
		
		public UserDTOBuilder withFirstName (String fName) {
			this.firstName=fName;
			return this;
		}
		
		public UserDTOBuilder withLastName (String lastName) {
			this.lastName=lastName;
			return this;
		}
		
		public UserDTOBuilder withBirthDay (LocalDate date) {
			this.age=Integer.toString(Period.between(date,LocalDate.now()).getYears());
			return this;
		}
		
		public UserDTOBuilder withAdress (Address address) {
			this.address=address.getHouseNumber() + ""+ address.getState();
			return this;
		}
		
		public UserDTO build() {
			this.userDTO = new UserDTO();
			userDTO.setAddress(address);
			userDTO.setAge(age);
			userDTO.setName(firstName + "" + lastName);
			return userDTO; 
		}
		
		public UserDTO geUserDTO() {
			return this.userDTO;
		}
	}
	
	
}
