package com.db.builder2;

import java.time.LocalDate;

import com.db.builder.Address;
import com.db.builder.User;
import com.db.builder2.UserDTO.UserDTOBuilder;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=Client.createUser();
		UserDTO userDTO = Client.createUserDTO(UserDTO.getUserDTOBuilder() , user);
		System.out.println(userDTO.toString());
	}
	
	public static UserDTO createUserDTO (UserDTOBuilder builder,User user) {
		
		return builder.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withAdress(user.getAddress())
				.withBirthDay(user.getBirthday()).build();
		
	}
	
	public static User createUser() {
		User user = new User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Deepak");
		user.setLastName("Prajapati");
		Address address = new Address();
		address.setHouseNumber("32");
		address.setStreet("State Street");
		address.setCity("Jaipur");
		address.setState("Raj");
		address.setZipcode("302034");
		user.setAddress(address);
		return user;
	}

}
