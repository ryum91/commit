# this

## 설명
JavaScript에서는 함수 호출 시 암묵적으로 전달되는 `this` 라는 객체가 존재한다.  
따라서 어떤 함수간에 함수 내부에서 `this` 객체를 사용할 수 있다.

그러나 이러한 `this` 는 함수가 호출되는 방식이나 특정 패턴에 따라서 참조하는 대상이 다르다.  
이번 장에서는 이러한 `this` 가 상황에 따라서 어떤 대상을 참조하는지 알아보겠다.

## 객체의 프로퍼티 함수에서의 this
객체의 프로퍼티가 함수일 경우 해당 함수에서의 `this`는  
**해당 함수를 호출한 객체로 바인딩** 된다.

```js
var obj = {
	func: function() {
		console.log( obj === this );
	}
}

obj.func();		// true
```

위 예제를 보면 obj 객체의 func 함수 내부에서  
`obj === this` 로 같은지 여부를 검증한다.  
그 결과, true 가 출력되었기 때문에 this 와 obj는 동일하다고 볼 수 있다.

## 함수를 호출할 때의 this
JavaScript에서 함수 호출 시 해당 함수 내에서의 `this` 는 [전역 객체](./etc/static-object.ko-KR.md)에 바인딩 된다.  
```js
var test = 'This is Test';
console.log(test);			// This is Test

function foo() {
	console.log(this.test);	// This is Test
}

foo();
```

이처럼 함수 내에서의 this는 전역 객체에 바인딩 되는걸 알 수 있다.  

## 내부 함수 호출할 때의 this
어떤 객체에 프로퍼티로 함수가 존재하고,  
해당 함수 내에서 또다른 함수가 선언되어 있다면 `this` 는 어떻게 동작할까  
먼저 결과부터 봐보자.

```js
var value = 100;

var obj = {
	value: 1,
	func1: function() {
		this.value += 1;
		console.log(this.value);		// 2
		
		var func2 = function() {
			this.value += 1;
			console.log(this.value);	// 101
		}
		
		func2();
	}
}

obj.func1();
```

결과를 보면 처음 예상했던 것과는 조금 다를 수 있을것이다.
첫번째 출력 결과의 this는 객체의 프로퍼티 함수 내에서 사용된 것이기 때문에 당연히 같은 객체가 this로 바인딩 된다.  
따라서 obj.value 에 1을 더한 2가 출력된다.  
하지만 두번째 출력 결과에서의 this 는 같은 객체로 바인딩 된 것이 아니라,  
전역 변수로 this 가 바인딩 되었다.  

그 이유는 JavaScript 에서는 **내부 함수 호출 패턴**을 정의해 놓지 않기 때문이다.  
다시말해 일반 전역 함수를 호출하는 방식과, 내부 함수를 호출하는 방식이 동일하다는 것이다.  
따라서 내부 함수 내의 this 또한 전역 객체로 바인딩 되는 것이다.

이것을 해결하는 가장 일반적인 방법은 객체의 프로퍼티 내에서 this를 다른 변수로 참조하는 것이다.  
보통 이러한 변수는 `that` 이라는 변수명으로 사용한다.
```js
var value = 100;

var obj = {
	value: 1,
	func1: function() {
		var that = this;
		this.value += 1;
		console.log(this.value);		// 2
		
		var func2 = function() {
			that.value += 1;
			console.log(that.value);	// 3
		}
		
		func2();
	}
}

obj.func1();
```

## 생성자 함수를 호출할 때의 this
생성자 함수를 호출할 때의 `this` 는 일반 함수를 호출할 때의 this와는 다르다.  
생성자 함수를 호출하면 함수 코드를 수행하기 전 빈 객체가 생성된다.

이렇게 생성된 빈 객체가 생성자 함수의 호출 결과로 반환이 되며,  
생성자 함수 내에서 `this` 로 바인딩이 되어진다.
  
하지만 엄연히 말하자면 완전한 빈 객체는 아니고  
해당 생성자 함수의 prototype 객체가 바인딩 된 객체이다.

## call과 apply 메서드를 이용한 명시적인 this 바인딩
함수 호출시 `this` 에 대해서 강제적으로 다른 객체로 바인딩을 할 수 있는 방법이 존재한다.  
이는 Function 의 prototype 인 call 과 apply 메소드를 이용해 할 수 있다.
  
`Function.prototype.apply(thisArg, argArray);`  
`Function.prototype.call(thisArg, arg...);`

apply 와 call 둘다 첫번째 매개변수에는 해당 함수 내에서 this 로 바인딩 될 값을 넘겨준다.  
그리고 apply 의 두번째 매개변수에는 해당 함수 호출시 전달될 매개변수를 **배열** 로 넘겨준다.  
call의 두번째 이상 매개변수에는 해당 함수 호출시 전달될 매개변수를 나열해서 넘겨주면 된다.
```js
function Person(name, age, gender) {
	this.name = name;
	this.age = age;
	this.gender = gender;
}

var applyTest = {};
Person.apply(applyTest, ['applyTest', 30, 'man']);

var callTest = {};
Person.call(callTest, 'callTest', 20, 'woman');
```

---
|[prev](./09-object.ko-KR.md)|[content](./00-contents.ko-KR.md)|next|
|:--:|:--:|:--:|
