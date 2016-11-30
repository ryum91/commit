# 제어문

제어문에는 가장 단순한 Block문과,  
조건에 따라 수행하는 if문, switch문이 존재한다.  
또한 에러나 오류를 제어할 수 있는 try-catch문과,  
마지막으로 ES6에 등장한 비동기식 동작을 제어하는 Promise가 존재한다.

## Block문
Block문은 코드를 묶는 가장 기본적인 문법이다.  
일반적으로 조건문이나, 반복문과 함께 사용되며, 중괄호( {...} )를 사용한다.
```js
{
	statement_1;
	statement_2
	.
	.
	.
	statement_n;
}
```

Block문이 '제어문' 이라고 불릴 수 있게 된 것은 ES6부터 라고 할 수 있다.  
그 이유는 [변수](./03-variable.ko-KR.md)에서 말했다싶이  
기존에 변수를 선언하는 유일한 방법인 'var' 키워드에는 Block 단위 Scope가 존재하지 않았기 때문이다.

## if문
특정 조건이 참인 경우 문장을 실행할때 if문을 사용한다.  
또한 중첩으로 else if도 사용할 수 있으며, 모든 조건이 아닐때 사용하는 else도 가능하다.
```js
if ( condition_1 ) {
	statement_1;
} else if ( condition_2 ) {
	statement_2;
} else {
	statement_3;
}
```
조건에 들어가는 값에 대한 참/거짓을 판단하는 것은 전역 함수인 Boolean() 함수를 이용하는 것과 동일한 결과를 나타낸다.  
자세한 내용은 [boolean](./builtInObjects/boolean.ko-KR.md)을 참조하면 된다.

추가로 JavaScript는 매우 자유로운 언어이기 때문에 조건문 안에서 변수에 값을 할당하는 것도 가능하다.  
하지만 이 방법은 사용하지 않는 것이 좋다.  
그 이유는 코드를 자세히 보지 않으면 동등 비교 연산자로 오해할 수 있기 때문이다.
```js
if ( x = y ) {
	statement;
}
```

만약 조건문 안에서 변수에 값을 할당하는 방법이 꼭 필요한 경우에는  
값 할당 앞/뒤에 추가 괄호를 넣는것이 가장 일반적인 방법이다.  
하지만 이 방법 또한 꼭 필요한 것이 아니라면 사용 안하는 것이 좋다.
```js
if ( (x = y) ) {
	statement;
}
```

## switch문
switch문은 값에 따라 수행되는 문장이 각각 다를때 사용한다.  
또한 모든 값이 아닐때 사용하는 'default' 또한 사용 가능하다.
```js
switch (expression) {
	case label_1:
		statements_1;
		[break;]
		
	case label_2:
		statements_2;
		[break;]
		
	default:
		statement_default;
		[break;]
}
```
일치된 라벨의 수행문을 실행 후 만약 break가 생략되어 있으면 하위 라벨의 수행문도 계속해서 실행하게 된다.  
이러한 실행은 하위 라벨에서 break를 만나거나, switch문이 종료될 때 까지 계속해서 실행한다. 

또한 switch문은 switch문 자체가 Block으로 감싸져 있다는 것을 인지하고 있어야한다.  
그 이유는 case문 각각 Block이 존재하는것이 아니기 때문에  
case문 내에서 수행되는 변수의 Scope를 제대로 알고 사용해야 한다.

## 예외 처리문
예외 처리문에는 예외를 던지는 **throw**문과,  
던진 예외를 잡는 **try-catch-finally**문이 존재한다.

### throw
JavaScript에서 throw는 해당 구문을 수행한 곳에게  
정상적인 반환이 아닌, 예외적으로 다른 반환을 할 때 사용한다.  
따라서 throw로 반환될 수 있는 것은 return 타입이 꼭 정해져 있지 않는 것처럼  
아무런 값을 throw로 반환할 수 있다.

```js
throw 0;
throw 'String';
throw true;
throw {key: 'value'};
throw new Error();
```

그러나 throw가 가장 많이 사용되는 곳은 단연 에러나, 오류에 대한 처리 부분이다.  
ECMAScript 내부에서도 에러가 발생되면 해당 부분에서 [Error](./builtInObjects/error.ko-KR.md) 객체를 생성해 throw하게 된다.

> 이처럼 throw는 에러나, 오류에 대한 처리로 사용하는 것이 제일 바람직하다.  
> 그 이유는 throw를 단순히 값을 반환하는 용도로 return문 처럼 사용하게 되면  
> 해당 함수에 대한 결과가 혼동될 뿐만 아니라, 유지보수 측면에서도 아주 안좋기 때문이다.  
> 때문에 아무리 ECMAScript에서 throw의 반환 타입이 자유롭다고 해서 실질적인 return문 처럼 사용하는 것은  
> 아주 안좋은 Anti Pattern 으로 지양하는 것이 좋다.

### try-catch-finally

## Promise