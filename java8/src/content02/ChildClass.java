package content02;

public class ChildClass implements InterfaceTest, InterfaceTest2 {
	
	public void childMethod() {
		defaultMethod();			// InterfaceTest : Default Method
	}
	
	// InterfaceTest 인터페이스와, InterfaceTest2 인터페이스에
    // 동일한 void defaultMethod() 가 존재한다.
	@Override
	public void defaultMethod() {
		InterfaceTest.super.defaultMethod();		// InterfaceTest의 defaultMethod() 호출
		InterfaceTest2.super.defaultMethod();		// InterfaceTest2의 defaultMethod() 호출
	}
	
	public static void main(String[] args) {
		System.out.println(STATIC_VARIABLE);		// 100
		
		// staticMethod();							// Complie Error
		InterfaceTest.staticMethod();				// InterfaceTest : Static Method
	}
}
