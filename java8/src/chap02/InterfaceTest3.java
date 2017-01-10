package chap02;

public interface InterfaceTest3 {
	// 해당 인터페이스는 기존에 만든 ChildClass 에서 implements 를 할 수 없다.
	default String defaultMethod() {
		System.out.println("InterfaceTest3 : Default Method");
		return null;
	}
}