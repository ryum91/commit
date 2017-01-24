# 객체

## 프로토타입
JavaScript의 모든 객체는 자신의 부모 역할을 하는 객체와 연결되어 있다.  
그리고 이것은 마치 객체 지향의 상속 개념과 같이  
부모 객체의 프로퍼티를 마치 자신의 것 처럼 쓸 수 있는 것 같은 특징이 있다.  
JavaScript 에서는 이러한 부모 객체를 **프로토타입** 이라고 부른다.  
또한 모든 JavaScript 객체의 최상위 프로토타입은 `Object` 이다.

간단한 예제를 봐보자.

```js
var func = {
	name: 'foo',
	age: 30
}

console.log(func.toString());	//[object Object]
```

func 객체에는 toString 이란 메소드가 존재하지 않는다. 그러나 정상 동작이 된다.  
그 이유는 func 객체의 프로토타입인 Object 객체가 toString 이라는 메소드가 이미 정의되어 있고,  
func 객체가 상속처럼 해당 toString 메소드를 호출했기 때문이다.

또한 프로토 타입의 메소드는 사용자 임의로 추가를 할 수도 있다.  
그때 사용하는 프로퍼티는 `prototype` 이라는 숨겨진 프로퍼티를 이용한다.

```js
// Object 객체에 숨겨진 프로퍼티인 prototype 을 이용하여 test 라는 프로토타입 메소드를 추가
Object.prototype.test = function() {
	console.log('Object Prototype Test');
}

func.test();	// Object Prototype Test
```

## 생성자
JavaScript 에서 객체를 생성하는 방법에 대해 ['리터럴'](./04-datastructure.ko-KR.md#object) 방식을 앞서 설명했었다.  
그러나 JavaScript 에서는 객체를 생성하는 방법은 그 뿐만 아니라 한 가지 더 존재한다.  
바로 **생성자 함수** 를 이용하여 객체를 생성하는 것이다.

JavaScript 에서의 생성자는 C++이나, 자바와 같은 객체지향 언어에서의 생성자와는 다르게 어떤 형식이 정해져 있지 않다.  
그냥 **기존 함수에 new 연산자를 붙여서 호출하면 해당 함수는 생성자로 동작한다.**

이는 반대로 생각하면 일반 함수에 new를 붙여 호출하면 원치 않는 생성자가 동작 할 수 있다는 점이다.  
따라서 대부분의 JavaScript 스타일 가이드에서는 특정 함수가 생성자 함수로 정의되어 있음을 알리려고  
**함수의 이름 첫 글자를 대문자로 쓰기**를 권하고 있다.

---
|[prev](./08-function.ko-KR.md)|[content](./00-contents.ko-KR.md)|[next](./10-this.ko-KR.md)|
|:--:|:--:|:--:|