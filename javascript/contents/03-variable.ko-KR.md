# 변수

## JavaScript 변수
JavaScript의 변수는 Java나, C 같은 다른 프로그래밍 언어보다 변수의 데이터 타입이 상당히 관대한 편이다.  
다른 언어들은 변수를 선언할 때 해당 변수의 데이터 타입까지 결정하는 반면,  
JavaScript의 변수는 선언시 변수의 스코프(Scope)만 설정하고,  
변수에 실제 데이터를 할당할 때 비로소 변수의 데이터 타입이 결정된다.  
따라서 JavaScript 변수에는 데이터 타입에 상관없이 아무 값을 넣을 수 있으며,  
변수의 데이터 타입은 실제 들어가있는 데이터에 따라서 매번 변경된다.

<br>
## 변수명 규칙
JavaScript 변수명의 규칙은 기본적으로 정의된 키워드를 제외하고,  
시작은 문자, 밑줄(_), 달러($)로 시작하여야 하며,  
그 이후로는 숫자(0-9)를 포함할 수 있다.

<br>
## 변수 선언
JavaScript 에서의 변수는 명시적인 타입이 없다.  
따라서 변수를 선언할때 사용하는 키워드 또한 포괄적인 의미를 가진 키워드를 사용한다.  

변수를 선언하는 방법은 총 세 가지가 있다. (ES6 기준)

### var
전역 변수, 지역 변수 같은 일반적인 변수를 선언할때 사용한다.  
선언만 하고, 초기화를 하지 않으면 'undefined' 값을 가진다.

### <img src="../image/es6.png" height="15" title="ECMAScript6"> let
블록 범위 안에서 유효한 변수를 선언한다.  
선언만 하고, 초기화를 하지 않으면 'undefined' 값을 가진다.

### <img src="../image/es6.png" height="15" title="ECMAScript6"> const
읽기 전용 상수를 선언한다. **단, 선언과 동시에 초기화가 필수이며, 한 번 설정 된 값은 변경할 수 없다.**  
만약 선언만 하고, 초기화를 하지 않으면 SyntaxError(missing = in const declaration) 라는 에러가 발생한다.

<br>
## 변수 유효 범위
### var
변수를 함수 바깥 부분에 선언하면, 해당 변수는 문서 어느곳에서든지 사용 할 수 있어서 ***전역 변수*** 라고 하며,  
변수를 함수 내부에 선언하면, 해당 변수는 오직 그 함수 내에서만 사용할 수 있어서 ***지역 변수***라고 한다.
```js
var globalVal = 0;				// 전역 변수 선언
function func() {
	var localVal = 0;			// 지역 변수 선언
};
```

전역 변수와 지역 변수의 변수명이 같다면, 지역 변수를 더 우선시하여 사용한다.
```js
var age = 24;					// 전역 변수 'age'
function func() {
	var age = 25;				// 지역 변수 'age'
	console.log(age);			// 지역 변수 'age'를 사용하기 때문에 '25'를 출력
};
```

같은 범위 안에서 var로 선언된 변수명이 같으면 변수에 값이 덮어씌워진다.
```js
var a = 1;
var a = 2;

console.log(a);					// 2
```

변수를 선언할때, var 키워드를 생략하면 자동으로 전역 변수로 선언된다.  
***하지만 이 방법은 안티 패턴으로 사용하지 않는게 좋다.***
```js
var age = 26;					// 전역 변수 'age'
function func() {
	name = 'ryum';				// 'name' 변수는 선언되지 않았기 때문에, 자동으로 전역 변수로 선언된다.
	console.log( name + age );	// 'ryum26' 출력
};
```

var로 선언한 변수는 블록 범위라는 유효 범위가 존재하지 않아,  
변수를 블록 내에서 선언한 것과 블록 바깥에서 선언한 것이 동일하게 동작한다.
```js
if( true ) {
	var a = 5;			// if문 바깥에서 선언한 것과 동일하게 동작하기 때문에, 전역 변수로 선언된다.
};
console.log(a);			// 5
```

<br>
### <img src="../image/es6.png" height="15" title="ECMAScript6"> let, const
ES6에 추가된 let과 const는 var와 다르게 조금 더 명확하게 동작한다.  
let과 const로 선언한 변수는 '블록 범위' 라는 추가적인 범위가 존재한다.
```js
if( true ) {
	let a = 1;			// if문 안에서 let을 이용하여 변수를 선언했기 때문에 if문 안에서만 유효
	const B = 2;		// const로 선언한 변수도 동일
	
	console.log(a);		// 1
	console.log(B);		// 2
};
console.log(a);			// ReferenceError: a is not defined
console.log(B);			// ReferenceError: B is not defined
```
let이나, const로 선언한 변수는 var로 선언한 변수와 다르게 변수명이 중복되면 에러를 발생한다.  
다시말해, let이나, const로 선언하는 변수는 같은 범위 안에서 var, let, const 선언 방식에 상관없이 변수명이 유일해야한다.  
만약 변수명이 중복되면 'SyntaxError' 에러가 발생한다.  
추가로, JavaScript에서는 함수를 일반 변수에 똑같이 할당하기 때문에, 함수명과도 동일하면 안된다.
```js
var a = 1;
let a = 2;				// SyntaxError: redeclaration of var a
```

<br>
## 호이스팅 (Hoisting)
JavaScript 변수의 특징인 호이스팅(Hoisting)은 **변수를 최상단으로 끌어올린다** 라는 의미를 가지고 있다.

좀 더 자세하게 설명하자면 JavaScript 변수는 선언만하고, 초기화를 하지 않으면 기본적으로 'undefined' 라는 값을 가진다.  
하지만 아예 선언조차 되지 않은 변수를 사용하고자 하면 'undefined'를 출력하는게 아니라, 'ReferenceError'라는 에러가 발생된다.
```js
var a;
console.log(a);			// undefined
console.log(b);			// ReferenceError: b is not defined
```

그러나 JavaScript에서는 어떤 변수를 문서내에 어디든지 선언만하면 ***해당 변수의 선언부는 최상단***으로 끌어올려지게 된다.  
따라서 아래의 두 소스코드는 동일하다고 보면 되고, 두 소스코드 모두 'a'의 출력은 'undefined'가 출력된다.
```js
if( true ) {
	console.log(a);		// undefined
};
var a = 1;
```
```js
var a;
if( true ) {
	console.log(a);		// undefined
};
a = 1;
```

다시말해, 문서 중간에 어떤 변수를 선언 및 초기화를 하면 해당 부분에서는 초기화(값을 할당)만 하는 것이고,  
변수의 선언은 최상단에서 이루어진다.  
이는 함수내인 지역 변수에서도 동일하게 작동한다.  
함수 내에서 중간에 지역 변수를 선언 및 초기화를 하면 역시 해당 부분에서는 변수의 초기화만 하고,  
지역 변수의 선언은 함수 최상단에서 이루어진다.

그러나 let과 const는 좀 다르다, let과 const로 선언한 변수는 호이스팅이 이루어지지 않으며,  
만약 호이스팅을 예상하여 변수를 사용하면 'RefereceError' 에러가 발생된다.
```js
console.log(a);			// ReferenceError: can't access lexical declaration 'a' before initialization
console.log(B);			// ReferenceError: can't access lexical declaration 'B' before initialization
let a = 1;
const B = 2;
```

> 이러한 호이스팅이란 특징을 JavaScript에서 사용을 할 수 있지만,  
> 특정 JavaScript 서적이나, 어떤 개발자들은 호이스팅이 오히려 소스코드에 혼란을 야기할 수 있어서,  
> 소스코드 상에서도 변수의 선언을 최상단에다 미리 작성하는게 좋다고 하는 사람들이있다.  
> 필자 또한 같은 의견이다.
> 게다가 ES6 부터 let과 const는 호이스팅이 작동하지 않기 때문에  
> 변수 범위를 예측해 최상단에 변수 선언을 미리 해두는건 나쁜 습관은 아니라고 생각한다.

---
|[prev](./02-sentence.ko-KR.md)|[content](./00-contents.ko-KR.md)|[next](./04-datastructure.ko-KR.md)|
|:--:|:--:|:--:|