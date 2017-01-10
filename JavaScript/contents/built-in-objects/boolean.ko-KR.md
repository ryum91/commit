# Boolean
Boolean 객체는 원시형 boolean 값을 감싸고 있는 래퍼(Wrapper) 객체이다.

## 문법
```js
new Boolean([value]);
```
### 매개 변수
#### (All) value
Boolean 객체의 초기값으로, value 값이 원시형 boolean 으로 변환하여 매핑된다.  
value 값이 boolean으로 판단되는 기준은  
값이 없거나, 0, -0, null, false, NaN, undefined, 빈 문자열("") 일때는 'false' 로,  
그 외에 다른 값이면 'true' 로 판단된다.

## 설명
이러한 Boolean 객체를 원시형 타입인 boolean과 혼동하면 안된다.  
해당 값의 실제 타입을 출력해주는 'typeof' 연산자를 사용해보면 다르게 출력되는 걸 볼 수 있다.
```js
var a = new Boolean(false);
var b = false;

console.log( typeof a );		// object (실제 객체 내부에는 false를 가지고 있다.)
console.log( typeof b );		// boolean (false)
```

Boolean 객체는 typeof로 보면 object가 찍힌 것을 볼 수 있다.  
참고로 모든 객체를 원시형 boolean으로 변환하면 'true'로 인식한다.  
때문에 Boolean 객체 자체를 다시 원시형 boolean으로 판단하면 참(true)으로 판단된다.
```js
var a = new Boolean(0);
if( a ) {								// a는 object이기 때문에 true로 판단된다.
	console.log('a는 true입니다.');		// 실제 출력된다.
}
```

만약에 어떤 구문에 대한 결과를 원시형 boolean으로 변환해야한다면 Boolean의 객체를 사용하면 안된다.  
대신에 기본으로 제공하는 전역함수인 Boolean()을 사용하면 원시형 boolean으로 변환할 수 있다.
```js
var a = new Boolean(0);
var b = Boolean(0);

console.log( typeof a );		// object (실제 객체 내부에는 false를 가지고 있다.)
console.log( typeof b );		// boolean (false)
```

Boolean 객체는 실제 크게 쓰이는 일은 많이 없을것이다.  
관련해서 Boolean 객체의 목적에 대해 올라온 질문이 있어서 참고하면 좋을 것 같다. ([What is the purpose of new Boolean() in Javascript?](http://stackoverflow.com/questions/856324/what-is-the-purpose-of-new-boolean-in-javascript))

## 속성 및 메소드
Boolean 객체에는 속성 및 메소드가 존재하지 않는다.  
단, prototype으로 상속 받은 속성 및 메소드만 존재한다.

### Boolean.prototype.toString()
Boolean 객체가 가지고 있는 값을 String으로 변환하여 반환한다.  
'true' or 'false' 를 반환한다.

### Boolean.prototype.valueOf()
Boolean 객체가 가지고 있는 값을 원시형 boolean으로 변환하여 반환한다.  
true or false 를 반환한다.