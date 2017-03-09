package builder;

public class Person {

	private String name;
	private int age;
	private String favoriteColor;
	private String favoriteAnimal;
	private int favoriteNumber;
	
	// private constructor
	private Person(PersonBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.favoriteColor = builder.favoriteColor;
		this.favoriteAnimal = builder.favoriteAnimal;
		this.favoriteNumber = builder.favoriteNumber;
	}
	
	// Getter, Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

	public String getFavoriteAnimal() {
		return favoriteAnimal;
	}

	public void setFavoriteAnimal(String favoriteAnimal) {
		this.favoriteAnimal = favoriteAnimal;
	}

	public int getFavoriteNumber() {
		return favoriteNumber;
	}

	public void setFavoriteNumber(int favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}

	// inner builder class
	public static class PersonBuilder {
		
		private String name;
		private int age;
		private String favoriteColor;
		private String favoriteAnimal;
		private int favoriteNumber;
		
		public PersonBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public PersonBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public PersonBuilder setFavoriteColor(String favoriteColor) {
			this.favoriteColor = favoriteColor;
			return this;
		}
		
		public PersonBuilder setFavoriteAnimal(String favoriteAnimal) {
			this.favoriteAnimal = favoriteAnimal;
			return this;
		}
		
		public PersonBuilder setFavoriteNumber(int favoriteNumber) {
			this.favoriteNumber = favoriteNumber;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
	}
}
