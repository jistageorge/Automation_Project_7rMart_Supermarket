package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	public String getFakeFirstName() {
		Faker faker = new Faker();
		String firstName=faker.name().firstName();
		return firstName;
	}
	public String getFakelastName() {
		Faker faker = new Faker();
		String lastName=faker.name().lastName();
		return lastName;
	}
	public String getcityName() {
		Faker faker = new Faker();
		String cityName=faker.address().cityName();
		return cityName;
	}
	public String getcountry() {
		Faker faker = new Faker();
		String country=faker.address().country();
		return country;
	}
}
