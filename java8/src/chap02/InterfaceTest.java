package chap02;

public interface InterfaceTest {
	
	static int STATIC_VARIABLE = 100;
	
	static void staticMethod () {
		System.out.println("InterfaceTest2 : Static Method");
	}
	
	default void defaultMethod () {
		System.out.println("InterfaceTest : Default Method");
	}
	
}