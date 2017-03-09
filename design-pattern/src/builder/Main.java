package builder;

import builder.Person.PersonBuilder;

public class Main {

	public static void main(String[] args) {
		
		Person person = new PersonBuilder()
							.setName("ryum")
							.setAge(27)
							.setFavoriteColor("black")
							.build();
		
		System.out.println(person.getName() + " (" + person.getAge() + ") ");
		
	}
	
}
