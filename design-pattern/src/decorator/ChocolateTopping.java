package decorator;

public class ChocolateTopping extends Topping {

	public ChocolateTopping(Cookie cookie) {
		super(cookie);
	}

	@Override
	public String getName() {
		return "초콜렛 + " + cookie.getName();
	}

}
