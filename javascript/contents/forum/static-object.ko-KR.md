# 전역 객체

JavaScript 에서는 기본적으로 제공되는 전역 객체(Static Object)가 존재한다.

이는 JavaScript 런타임 환경에 따라 전역 객체가 바인딩되는데,  
기본적으로 인터넷 브라우저에서는 `window` 라는 객체가 전역 객체로 바인딩된다.  
인터넷 브라우저 말고도 대표적인 JavaScript 런타임 환경인 [Node.js](https://nodejs.org/ko/) 에서는 `global` 이라는 객체가 전역 객체로 바인딩된다.

또한 JavaScript에서 선언된 전역 변수들은 실제 전역 객체의 프로퍼티라고 생각하면 된다.

```js
var foo = 'I`m foo';		// 전역 변수 선언

console.log(foo);			// I`m foo
console.log(window.foo);	// I`m foo
```

이처럼 전역 변수로 선언된 변수들은 런타임 환경에 맞는 전역 객체를 통해서도 접근이 가능하다.