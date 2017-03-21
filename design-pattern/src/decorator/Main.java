package decorator;

public class Main {
	public static void main(String[] args) {
		Cookie cookie = new Cookie() {
			@Override
			public String getName() {
				return "쿠키";
			}
		};
		
		System.out.println(cookie.getName());
		
		cookie = new MilkTopping(cookie);
		System.out.println(cookie.getName());
		
		cookie = new ChocolateTopping(cookie);
		System.out.println(cookie.getName());
		
	}
}
