# <img src="../../image/es6.png" height="25" title="ECMAScript6"> Promise
Promise 객체는 JavaScript에서 비동기를 제어하기 위해서  
ES6에 추가된 내장 객체이다.

## 문법
```js
new Promise( executor );
```

### (function) executor
Promise 객체를 생성하기 위해서는 executor라 불리는 함수를 필수로 매개 변수로 전달해야 한다.  
이 함수는 Promise 객체를 생성하는 구문에서 즉시 수행되는 함수이다.

또한 두 개의 매개 변수를 기본으로 받게 되어 있어서 함수 구현 내에서 사용할 수 있다.  
```js
function executor(resolve, reject) {
	...
}
```
두 개의 매개변수는 resolve, reject로 둘 다 함수이다.  
이는 executor 함수 내에서 연산이 성공하였을 때는 resolve를 호출,  
연산이 실패하였을 때는 reject를 호출하는 방식으로 사용한다.
```js
new Promise(function(resolve, reject) {
	var result = 연산의 수행 조건;
	
	if( result ) {
		// 연산이 성공했을 땐 resolve
		resolve();
	} else {
		// 연산이 실패했을 땐 reject
		reject();
	}
});
```

## 설명
Promise는 어떤 연산을 수행한 뒤 특정 조건에 의해서 성공이나, 실패하였을 때  
함수와 함수를 연결시켜주는 Handler라고 생각하면 된다.  

이러한 Promise는 대표적으로 세 가지의 상태 중에 하나의 상태를 가지게 된다.
* pending (대기중) : Promise 객체가 생성된 직 후 초기 상태를 의미하며, 아직 성공이나 실패가 되지 않은 상태이다.
* resolved (성공) : executor 함수 내에서 resolve 를 호출한 것을 의미하며, 연산이 성공 했다는 상태이다.
* rejected (실패) : executor 함수 내에서 reject 를 호출한 것을 의미하며, 연산이 실패 했다는 상태이다.

세 가지의 상태와는 별개로 pending 상태가 아닌, resolved 상태와, rejected 상태를 합쳐서 settled (처리됨) 상태라고도 불린다.  
또한 resolved 상태는 다른 말로 fulfilled 상태라고도 한다.

Promise의 이러한 상태는 한 번 settled 되면 변경되지 않는다.  
즉 executor 함수 내에서 resolve와 reject를 둘 다 호출하게 되면, 먼저 호출된 상태로 해당 Promise의 상태가 변경된다.

```js
new Promise(function(resolve, reject) {
	resolve();		// resolve를 호출하였기 때문에 해당 Promise는 resolved 상태로 변경된다.
	reject();		// 이미 Promise가 settled 상태이기 때문에 의미가 없다.
});
```

## 속성

### (Number) length
생성자 매개 변수의 개수를 나타내며, Promise의 생성자는 하나의 함수만을 받으니까 무조건 1이다.

## 메소드

### Promise.all(iterable)
매개 변수에는 Promise 객체의 배열이 들어가게 된다.  
이 매개 변수에 전달된 Promise 객체들이 모두 성공이면 resolved 상태의 Promise 객체를 반환하고,  
하나라도 실패하면 rejected 상태의 Promise 객체를 반환한다.  
쉽게 말하자면 전달된 Promise 객체들을 AND 연산한 것이라고 생각하면 된다.

### Promise.race(iterable)
마찬가지로 매개 변수에는 Promise 객체의 배열이 들어가게 된다.  
이 매개 변수에 전달된 Promise 객체 중 가장 맨 처음 수행되는 Promise 객체를 반환한다.  
가장 맨 처음 수행된 Promise의 상태 그대로 반환하는 것이다.

### Promise.reject(reason)
무조건 reject 상태인 Promise 객체를 반환한다.  

### Promise.resolve(value)
무조건 resolved 상태인 Promise 객체를 반환한다.

## 프로토타입

### Promise.prototype.catch(onRejected)
catch 프로토 타입 함수는 Promise가 reject 상태일 때 수행 할 함수를 정의할 수 있다.  
해당 함수에는 매개 변수를 사용할 수 있는데 이 매개 변수는 해당 Promise에서  
reject 하는 순간에 전달 된 값이다.

```js
var prom = new Promise(
	function(resolve, reject) {
		reject('prom is reject!');	// 무조건 reject 하였다.
	}
);

prom.catch(
	function(reason) {
		console.log(reason);		// prom is reject!
	}
);
```

### Promise.prototype.then(onResolved, onRejected)
then 프로토 타입 함수는 Promise가 resolved 상태일 때 수행 할 함수를 정의할 수 있다.  
추가로 catch와 동일하게 reject 상태일 때 함수도 then에서 같이 정의가 가능하다.  
resolved 상태도 마찬가지로 해당 Promise에서 resolve 하는 순간 전달된 값을 사용할 수 있다.

```js
var prom = new Promise(
	function(resolve, reject) {
		resolve('prom is resolved!');
	}
);

prom.then(
	function(value) {		// onResolved
		console.log(value);	// prom is resolved!
	},
	function(reason) {		// onRejected (prom은 무조건 resolved 상태이기 때문에 호출되지 않음)
		console.log(reason);
	}
);
```

위에 언급한 then과, catch 프로토 타입은 둘다 반환 타입 자체가 Promise 객체이다.  
따라서 **체이닝**이 가능하다.
```js
var prom = new Promise(
	function(resolve, reject) {
		resolve('prom is resolved!');
	}
);

prom
	.then(
		function(value) {		// onResolved
			console.log(value);	// prom is resolved!
		},
		function(reason) {		// onRejected (prom은 무조건 resolved 상태이기 때문에 호출되지 않음)
			console.log(reason);
		}
	)
	.then(
		function(value) {
			console.log('then'); // Promise의 상태는 계속해서 resolved 상태이기 때문에 계속 호출된다.
		}
	)
	.catch(
		function(reason) {
			console.log('catch'); // Promise의 상태는 계속해서 resolved 상태이기 때문에 호출되지 않는다.
		}
	);
```

