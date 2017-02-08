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
두 개의 매개변수는 `resolve`, `reject`로 둘 다 함수이다.  
이는 executor 함수 내에서 연산이 성공하였을 때는 `resolve` 를 호출,  
연산이 실패하였을 때는 `reject` 를 호출하는 방식으로 사용한다.
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

또한 `resolve` 함수와 `reject` 함수를 호출 시 매개변수 한 개를 넘겨 보낼 수 있다.  
이 매개변수는 이후에 나오는 Promise 상태에 따라 수행되는 작업에서 넘겨 받을 수 있다.

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

## Chaining
Promise 객체의 프로토타입에 존재하는 메소드들의 반환 타입은 모두 Promise 객체이다.  
따라서 Chaining(체이닝)을 할 수가 있다.
  
그러나 Promise 객체가 생성되는 시점에서 수행되는 조건과,  
한 번 상태가 결정된 이후 수행되는 조건이 조금 다르다.

먼저 앞서 말했듯이 Promise 객체가 생성되는 시점에서는 Promise의 상태에 따라서 수행되는 메소드가 달라진다.  
resolved 상태인 경우에는 then 메소드를,
rejected 상태인 경우에는 catch 메소드를 수행한다.

그러나 그 이후로 then이나, catch안에서는 약간 다르다.  
만약 메소드 내에서 정상 동작하여 정상적인 반환(return)이 되었으면 이어진 then 메소드를 수행하고,  
예외가 발생되어 Exception이 throw 되어지면 뒤에 이어진 catch문이 수행된다.

```js
var prom = new Promise(
	function(resolve, reject) {
		resolve();		// resolved 상태가 되었다.
	}
);

prom
	// 현재 prom 은 resolved 상태이기 때문에 첫번째 then이 수행된다.
	.then(
		function() {
			console.log('then1');
		}
	)
	// 첫번째 then 내에서 정상적인 반환이 이루어졌으므로, 두번째 then이 수행된다.
	.then(
		function() {
			console.log('then2');
			throw 'exception';
		}
	)
	// 두번째 then 내에서 Exception이 발생되어 던져졌으므로 세번째 then은 수행되지 않는다.
	.then(
		function() {
			console.log('then3');
		}
	)
	// 상위 Promise(두번째 then)에서 Exception이 발생되어 던져졌으므로 catch가 수행된다.
	.catch(
		function() {
			console.log('catch1');
		}
	)
	// 첫번째 catch에서 정상적인 반환이 이루어졌으므로 두번째 catch는 수행되지 않는다.
	.catch(
		function() {
			console.log('catch2');
		}
	)
	// 상위 Promise(첫번째 catch)에서 정상적인 반환이 이루어졌으므로 네번째 then이 수행된다.
	.then(
		function() {
			console.log('then4');
		}
	);
	
	// 수행 결과 : then1 - then2 - catch1 - then4
```

