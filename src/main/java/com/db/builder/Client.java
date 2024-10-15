package com.db.builder;
import java.time.LocalDate;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=Client.createUser();
		UserDTOBuilder builder= new UserWebDTOBuilder();
		UserDTO userDTO=Client.createUserDTO(builder, user);
		System.out.println(userDTO);
	}

	private static UserDTO createUserDTO(UserDTOBuilder builder,User user) {
		return builder.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withAddress(user.getAddress())
				.withBirthday(user.getBirthday())
				.build();
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
