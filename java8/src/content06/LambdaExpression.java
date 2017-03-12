package content06;

import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

/**
 * 람다의 기본 문법 및 사용 방법
 *
 * @class Example01.java
 * @author 박차렴(crpark@pnpsecure.com)
 * @since 2016. 3. 2.
 */
public class LambdaExpression {

	/**
	 * - Lambda를 사용하지 않은 버전
	 * -- Anonymous Class로 Comparator 객체를 생성해 compare 메소드를 override 하여 구현한다.
	 */
	@Test
	public void step1() {
		Comparator<String> scoreComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? 0 : -1;
			}
		};
		Assert.assertEquals(1, scoreComparator.compare("abc", "abcd"));
	}
	
	/**
	 * <pre>
	 * - 람다식의 기본 문법
	 * -- 아래 객체의 생성부가 람다식의 기본 문법이다.
	 * -- 람다식에서는 객체를 new로 생성하지 않는다.
	 * -- 화살표(->) 기준으로 좌측은 매개변수 부분, 우측은 구현 부분으로 사용한다.
	 * 
	 * - @FunctionalInterface
	 * -- 람다와 같이 등장한 인터페이스에 붙일 수 있는 Annotation이다.
	 * -- 해당 Annotation을 붙인 인터페이스는 함수형 인터페이스라고 알리는 것이다.
	 * -- 해당 Annotation을 붙인 인터페이스는 무조건 추상 메소드가 한 개 이어야 한다. (두 개 이상이면 컴파일에러 등장)
	 * -- 여기서 사용하는 <Comparator> 역시 @FunctionalInterface 가 붙어 있는 인터페이스이다.
	 * -- @FunctionalInterface 에 존재하는 추상 메소드의 매개변수를 람다식의 좌측인 매개변수 부분에 작성한다.
	 * -- 구현 부분은 추상 메소드의 리턴이라 생각하면 된다.
	 * -- 자바에서의 람다식은 이렇게 함수형 인터페이스의 객체를 람다식으로 표현한 것을 말한다.
	 * </pre>
	 */
	@Test
	public void step2() {
		Comparator<String> scoreComparator = (String o1, String o2) -> o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? 0 : -1;
		
		Assert.assertEquals(1, scoreComparator.compare("abc", "abcd"));
	}
	
	/**
	 * 람다식 매개변수 부분에 들어가는 변수의 데이터 타입을 생략할 수 있다.
	 */
	@Test
	public void step3() {
		Comparator<String> ageComparator = (o1, o2) -> o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? 0 : -1;
		
		Assert.assertEquals(0, ageComparator.compare("abc", "cdf"));
	}
	
	/**
	 * 만약 매개변수가 한 개라면 매개변수 부분에 들어가는 괄호를 생략할 수 있다.
	 */
	@Test
	public void step4() {
		Predicate<String> predicate = t -> t.length() > 10;
		
		Assert.assertEquals(false, predicate.test("abcdefg"));
	}
	
	/**
	 * 매개변수가 없을 경우에는 빈 괄호로 작성하고
	 * 메소드의 리턴 타입이 void일 경우에는 바로 내부 구현을 작성한다.
	 * 
	 * 또한 코드 블록을 사용하여 여러줄에 걸쳐서 작성을 할 수도 있다.
	 */
	@Test
	public void step5() {
		Runnable runnable = () -> {
			System.out.println("Runnable~!");
			return;
		};
		runnable.run();
	}
	
	/**
	 * 이러한 람다식은 언뜻보면 익명 클래스와 비슷할 수 있다.
	 * 하지만 엄연히 다른것이 있다.
	 * 먼저 눈에 띄는 차이점은 익명 클래스를 이용했을 때 보다 코드 라인이 훨씬 더 간결하게 줄었다는 것이다.
	 * 특히 반복적으로 무의미하게 작성되는 익명 클래스의 인터페이스 구현 코드가 사라졌다는 것이 큰 장점이라고 할 수 있다.
	 * 
	 * 또한 내부적으로 큰 차이점은 this 키워드가 의미하는 바이다.
	 * 익명 클래스에서 this는 익명 클래스 자신을 가리킨다.
	 * 반면, 람다식에서 this는 람다식을 감싸고 있는 클래스를 지칭하게 된다.
	 * 
	 * 또한 람다식과 익명 클래스의 다른 차이는 컴파일하는 방식의 차이가 있다.
	 * 자바 컴파일러는 람다식을 클래스 내의 private 메소드로 컴파일한다.
	 * 이때, 자바7에서 추가된 invokeDynamic을 사용하여 변환한다.
	 * 
	 * 결론적으로 성능 면에서 익명 클래스보다 유리하게 동작한다고 한다.
	 * 그 이유는 해당 메소드가 호출되기 전까지 초기화를 진행하지 않기 때문이다.
	 * 이를 통해 결국 메모리를 다소 절약하는 효과를 가져온다.
	 * 
	 * 하지만 성능 차이는 대부분의 개발 및 운영 환경에서 미미한 수준으로 나타나므로
	 * 성능보다는 개발 속도의 향상과 읽기 좋은 코드를 작성할 수 있다는 점에서 장점이 뚜렷하다.
	 */
}