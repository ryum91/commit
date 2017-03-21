package decorator;

public class MilkTopping extends Topping {

	public MilkTopping(Cookie cookie) {
		super(cookie);
	}

	@Override
	public String getName() {
		return "우유 + " + cookie.getName();
	}

}
