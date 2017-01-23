# 함수

## 함수 정의
함수를 정의하는 방법에는 두 가지 방법이 존재한다.

### 함수 선언식
함수 선언식이란 `function` 키워드를 사용해서 직접 함수를 선언하는 것을 말한다.  
그리고 함수의 이름과 괄호를 이용하여 선언하는 매개 변수 목록 그리고 함수 내용으로 구성된다.

```js
function square(number) {
	return number * number;
}
```

### 함수 표현식
함수 표현식이란 함수 자체는 익명으로 선언하고, 해당 함수를 기존 변수에게 할당하는 것을 말한다.  
따라서 함수명 자체는 `var` 나, `let` 같은 변수 키워드를 이용하여 나타낸다.

```js
var square = function(number) {
	return number * number;
}
```

이러한 함수 표현식은 다른 함수에게 매개 변수로 전달할 때 편리하다.

```js
function main(callback) {
	callback();
}

var callback = function() {
	...
}

main(callback);
```

이렇게 함수를 선언하는 곳은 global하게 선언도 가능하며,  
함수 내에서 다른 함수를 선언하는 것도 가능하다.
```js
function add(x, y) {
	function out(a) {
		console.log(a);
	}
	
	out(x);
	out(y);
	console.log(x + y);
}
```

## 함수 호출
함수 호출시에는 함수 표현식과, 함수 선언식에 따라 호출 범위가 다르다.  
일단 함수 자체도 호이스팅이 이루어진다.

그러나 함수 선언식은 함수 선언 자체가 호이스팅이 이루어진다.  
따라서 함수 선언식으로 함수를 선언하면 global 하게 모든 프로그램 내에서 호출이 가능하다.  
함수 표현식은 일단 변수의 호이스팅 처럼 변수의 선언만 호이스팅이 이루어지고,  
변수에 함수 할당은 해당 부분에서 이루어지기 때문에  
표현식으로 선언된 함수보다 위에서는 해당 함수를 호출할 수 없다.

함수의 `return`이 존재하면 호출 후 결과는 반환 값이 반환되며,  
함수의 반환이 존재하지 않으면 `undefined` 가 반환된다.

## 즉시 실행 함수
함수를 선언과 동시에 즉시 실행하고 싶은 경우도 존재한다.  
그 경우에 사용하는 방식을 **즉시 실행 함수** 라고 한다.  
즉시 실행 함수는 함수의 이름 없이 익명 함수로 선언하고,  
함수 전체를 괄호로 묶은 후 맨 마지막에는 다시한 번 괄호를 적는다.

```js
(function() {
	// 즉시 실행 함수...
})();
```

이러한 방식은 기존에 변수의 scope를 제어하기 위해 많이 사용해왔다.  
따로 별도의 block 단위 scope도 없고, 모든지 global한 JavaScript에서  
이렇게 즉시 실행 함수 안에다가 코드를 작성하면 다른 global 영역과 분리되기 때문이다.

그러나 ES6에서는 let 이나, const 같은 여러 제어 방식이 등장함으로  
이전보다는 사용량이 줄어들 것으로 예상한다.

## arguments 객체
함수 내에서는 특별한 객체인 **arguments** 라는 객체를 사용할 수 있다.  
이는 함수의 매개 변수와 관련된 객체이다.  
자세한 사항은 [여기서](./etc/function-in-arguments.ko-KR.md) 설명하겠다.

## this
함수 내에서는 arguments와 비슷하게 특별한 객체가 하나 더 있다.  
바로 `this` 라는 객체인데 `this` 는 함수 호출시 암묵적으로 같이 넘어오는 인자값 이라고 생각하면 된다.  
자세한 사항은 다음장에서 설명하겠다.

## 함수의 Scope
JavaScript 에서는 함수 또한 객체로 표현되므로 일종의 Scope가 존재한다.  
결론 먼저 말하자면 **함수의 Scope는 해당 함수를 선언한 상위에서만 유효하다.**  
다시말해 global에서 선언된 함수는 global 전체에서 유효하고,  
특정 함수 내부에서 선언된 함수는 해당 함수 내부에서만 유효하다는 뜻이다.

```js
function add(x, y) {
	function out(a) {
		console.log(a);
	}
	
	out(x);
	out(y);
	console.log(x + y);
}

add(3, 4);		// 3, 4, 7 출력
out(6);			// out is not defined
```

## 함수의 Closure (클로저)
바로 위에서 언급한 함수의 Scope 규칙이 제외대는 것도 존재한다.  
부모 함수에서 반환 할 때 내부 함수 자체를 반환하는 것이다.  
그렇게 되면 실제 외부 함수 바깥에서도 내부 함수를 호출하는 것과 동일한 기능을 할 수 있다.
```js
function add(x, y) {
	function out(a) {
		console.log(a);
	}
	
	out(x);
	out(y);
	console.log(x + y);
	
	return out;				// out 함수 자체를 반환하였다.
}

var result = add(3, 4);		// 3, 4, 7 출력
result(6);					// 6 출력
```

여기서 `add(3, 4);` 의 실행 결과를 result 라는 변수에 할당하였다.  
그 결과 add 함수의 내부 함수인 `out` 이 반환되어  
result에 할당 되었기 때문에 접근이 가능한 상태로 변경 된 것이다.

이러한 result 변수에 할당된 함수 자체를 **클로저** 라고 말한다.

좀 더 자세한 내용은 추후에 다시 설명하겠다.

---
|[prev](./07-operator.ko-KR.md)|[content](./00-contents.ko-KR.md)|[next](./09-object.ko-KR.md)|
|:--:|:--:|:--:|
