# 반복문
반복문은 하나의 동작을 여러번 반복할 때 사용되는 구문이다.  
JavaScript에서의 반복문은 크게 보면 for, while, 그리고 변형된 for문 이렇게 존재한다.

## for
`for`문은 어떤 특정한 조건이 거짓으로 판별될 때까지 반복한다.  
다른 여럿 프로그래밍 언어와 동일하게 사용한다.
```js
for( [초기문]; [조건문]; [증감문] ) {
	statements;
}
```
`for`문이 실행되는 순서는 다음과 같다.  
1. 초기문이 실행된다. 초기문에는 주로 for문에서 필요한 변수 선언을 선언한다. 꼭 하나의 변수만 선언할 수 있는 것은 아니다.  
2. 조건문의 조건을 검사한다. 만약 조건이 참이라면 반복문을 실행하고, 거짓이라면 for문이 종료된다. 만약 조건문 자체를 생략하면 참이라 판단하여 무조건 수행한다.  
3. 조건문 내부에 존재하는 문장을 수행한다.  
4. 증감문이 존재하면 실행하고 난 뒤, 2번째 단계로 돌아간다.

JavaScript에서는 [조건문] 자체에 무조건 `boolean` 값이 들어갈 필요가 없다고 언급한 적이 있었다.  
그 특징을 이용하면 좀 더 간결한 `for`문을 작성할 수 있다.  
다음 예제는 HTML문서 내에 존재하는 모든 `div` 태그를 뽑아서 순차적으로 수행하는 반복문이다.
```js
var divArray = document.getElementsByTagName('div');	// getElementsByTagName 함수는 태그 이름으로 DOM을 찾는 함수다.
for( let i = 0, div; div = divArray[i]; i ++ ) {	// [조건문] 부분에서 div 변수에 값을 할당 후 조건으로 판단된다.
	console.log(div);				// div가 순차적으로 출력된다.
}
```

## do ... while
`do...while`문은 특정한 조건이 거짓으로 판별될 때까지 반복하는 반복문이다.
```js
do {
	statements;
} while ( [조건문] );
```
`do...while`문은 조건을 확인하기 전에 문장을 무조건 한 번 실행된다.  
실행 후 조건을 판단하여, 참이면 계속해서 문장을 수행하고,  
거짓이면 반복문이 종료된다.

## while
`while`문은 어떤 조건이 참일동안 계속해서 문장을 수행하는 반복문이다.
```js
while ( [조건문] ) {
	statements;
}
```
조건문이 참이면 문장을 수행하고 난 뒤, 다시 조건을 확인한다.  
그러다가 조건이 거짓이면 반복문은 종료된다.

## for ... in
`for...in`문은 객체의 속성을 `in`절 앞에 선언된 변수에 순차적으로 매핑하여 반복한다.
```js
for( variable in object ) {
	statements;
}
```

그러나 `for...in`문 같은 경우에는 객체의 속성 뿐만 아니라, 프로토타입으로 설정된 함수 또한 같이 순환한다.  
```js
Object.prototype.objectCustom = function() {};

const obj = {
	a: '1',
    b: '2',
    c: '3',
    d: '4',
    e: '5'
}

for( const i in obj ) {
	console.log(i);			// a, b, c, d, e, objectCustom
}
``` 

## <img src="../image/es6.png" height="20" title="ECMAScript6"> for ... of
`for...of`문은 반복 가능한 객체 (iterable Object)에 대해 사용할 수 있는 반복문으로  
ES6에서 새롭게 추가되었다.  
여기서 반복 가능한 객체란 `Array`, `Map`, `Set` 등이 있다.
```js
for ( variable of object ) {
	statements;
}
```
사용하는 방법은 `for...in`문과 비슷하다.  
`of`절 앞에 선언된 변수에 반복 가능한 객체의 요소들을 순차적으로 매핑하여 반복한다.
  
그러나 `for...in`과 다른점은 `for...of`문은 반복 가능한 객체의 `iterator`를 이용하기 때문에  
프로토타입으로 설정된 함수는 순환 대상에서 제외된다.

```js
Object.prototype.objectCustom = function() { }

const arr = ['a', 'b', 'c', 'd', 'e'];

for( const i in arr ) {
	console.log(i);			// 0, 1, 2, 3, 4, objectCustom
}

for( const i of arr ) {
	console.log(i);			// a, b, c, d, e
}
```

> iterator란 ES6에 새롭게 추가된 문법으로 추후에 다시 설명하겠다.

## label
`label`이란 모든 반복문에서 사용할 수 있는 문법으로  
반복문의 시작 부분에 선언할 수 있다.  
쉽게 말하자면 반복문 자체에 이름을 정해놓는 것이다.
```js
outer:				// outer란 label을 선언했다.
for( let i = 1; i <= 10; i ++ ) {
	...
}
```

## continue
`continue`란 모든 반복문에서 사용할 수 있는 문법으로  
반복문 내의 문장에서 `continue`를 만나면 현재 진행중인 순서의 다음 순서로 바로 넘어간다.
```js
// 1 ~ 10까지 짝수만 더하는 반복문
let result = 0;
for( let i = 1; i <= 10; i ++ ) {
	if( i % 2 ) {
		continue;
	}
    result += i;
}
console.log(result);	// 30
```

`label`을 이용하면 이중 반복문일 때, 안쪽 반복문에서 바깥쪽 반복문의 순서를 넘길 수 도 있다.
```js
// 1 ~ 10까지 짝수만 더하는 반복문
let result = 0;

outer:
for( let i = 1; i <= 10; i ++ ) {
	if( i % 2 ) {
		continue outer;
	}
    result += i;
}
console.log(result);	// 30 
```

## break
`break`문 또한 모든 반복문에서 사용할 수 있는 문법으로,  
반복문을 즉시 끝내고 싶을 때 사용한다.  

마찬가지로 `label`과 함께 사용할 수 있어서  
안쪽 반복문에서 바깥쪽 반복문을 종료할 수도 있다.
```js
// 1 ~ 10 까지 더하다가 30보다 크면 종료하는 반복문
let result = 0;

outer:
for( let i = 1; i <= 10; i ++ ) {
	if( result > 30 ) {
		break outer;
	}
    result += i;
}
console.log(result);	// 36
```

---
|[prev](./05-control.ko-KR.md)|[content](./00-contents.ko-KR.md)|[next](./07-operator.ko-KR.md)|
|:--:|:--:|:--:|
