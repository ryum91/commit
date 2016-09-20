# 데이터 구조

## 데이터 타입
JavaScript는 총 세 가지의 기본 형식과, 두 가지의 예외 형식, 그리고 객체(Object)로 구분된다.  
추가로 ES6에는 새롭게 심볼(Symbol) 이라는 타입도 추가되었다.
 
* 세 가지의 기본 형식
 * boolean
 * number
 * string
* 두 가지의 예외 형식
 * undefined
 * null
* object
* <img src="../image/es6.png" height="11" title="ECMAScript6"> symbol

JavaScript는 이처럼 다른 프로그래밍 언어들에 비해 정의된 데이터 타입이 적지만,  
프로그래밍에 있어서 큰 문제는 없다. 오히려 더 편하게 느낄 수 있다.

여기서 추가로 함수가 존재하는데 이는 데이터 타입과는 별개로  
어플리케이션이 수행되는 절차(procedure)라고 생각하면 된다.  

<br>
## 리터럴 (Literal)
각각의 데이터 타입에는 리터럴(Literal)이 존재하며,  
몇몇 객체에서는 해당 객체에서만 사용되는 특수 리터럴이 존재한다.

### boolean
참과 거짓을 표현하는 boolean 타입은 두가지의 리터럴 값을 가진다. true와 false
```js
var booleanLiteral1 = true;
var booleanLiteral2 = false;
```

### number
정수를 표현하는 number 타입은 크게 네 가지 방법으로 리터럴을 정의할 수 있다.  
10진수, 2진수, 8진수, 16진수

10진수의 리터럴은 맨 앞이 **'0'이 아닌 숫자**로 이루어져있다.  
2진수의 리터럴은 맨 앞이 **'0b (0B)'**로 이루어진 숫자 데이터이다.  
8진수의 리터럴은 맨 앞이 **'0o (0O)'**로 이루어진 숫자 데이터이다.  
16진수의 리터럴은 맨 앞이 **'0x (0X)'**로 이루어진 숫자 데이터이다.  
```js
var dec = 10;			// 10진수 10
var bin = 0b1010;		// 2진수 10
var oct = 0o12;			// 8진수 10
var hex = 0xA;			// 16진수 10
```

number 타입에는 특수한 값인 **'NaN(Not a Number)'** 라는 값이 존재한다.  
이는 숫자 연산을 할 때 number 타입과 다른 데이터 타입을 연산할 때 나오는 값으로  
number에 속하지만 에러 타입과 더 가깝다고 할 수 있다.  
하지만 실제 number에 속하므로 typeof 로 확인해보면 number가 출력된다.
```js
var temp = 1 - 'a';
console.log(temp);				// NaN
console.log(typeof temp);		// number
```


### string
문자를 표현하는 string 타입의 리터럴은  
큰 따옴표(") 혹은 작은 따옴표(')로 묶인 0개 이상의 문자로 표현한다.
```js
var str1 = 'abcdefg';
var str2 = "가나다라마바사";
```

추가로 ES6에는 string 리터럴이 한 가지 더 추가가 되었다.  
바로 빽쿼터(Back Quote)라고 불리는 ` 를 이용해 리터럴을 정의할 수 있다.  
이러한 빽쿼터를 이용한 리터럴 정의를 템플릿(template) 리터럴이라 부른다.

템플릿 리터럴은 여러 줄 문자열을 이스케이프를 사용하지 않고 정의할 수 있으며,  
문자열 사이에 문자열을 삽입하는 리터럴도 가능하다.
```js
// 여러 줄 문자열 표현
var multiString = `Im JavaScript
Multi String`;

// 문자열 사이에 문자열 삽입
var name = 'ryum';
var intro = `hello! my name is ${name} !!`;
console.log(intro);			// hello! my name is ryum !!
```

### undefined
undefined는 변수를 선언만 하고, 값을 할당하지 않은 상태를 말한다.  
다시말해, 실제 변수의 데이터 타입이 결정되지 않은 상태이다.  
그렇다고 변수에 undefined 라는 값이 할당되었다고 생각하면 안되고, 그냥 아무것도 없다라고 생각하면 된다.

### null
null 값을 변수에 할당하였다면, 해당 변수는 **비어있는 값**이라고 강제로 명시해놓은 것이다.  
이러한 null 값과, undefined의 차이점으로는  
undefined는 데이터 타입 자체가 아무것도 없다는 의미라고 생각하면 되고,  
null은 이론적으로 Empty Object를 가리킨다고 생각하면 된다.  
따라서 null값을 가진 변수를 typeof 연산자로 확인해보면 'object' 라는 결과가 나온다.
```js
var a = null;
console.log(typeof a);		// object
```

### object
JavaScript의 모든 객체(object)는 중괄호({})로 묶인 키(key)와 값(value)의 쌍으로 이루어져있다.  
흔히 알고있는 JSON 형식이라 생각하면 된다.  
이러한 객체의 속성값에는 문자열, 중첩된 또다른 객체, 함수까지 모든 값을 객체의 속성값으로 지정할 수 있다.
```js
var phone = {
	name:	'galaxy',
	sales:	'$500'
}
```

객체의 속성명(key)으로는 빈 문자열을 포함하여 JavaScript에 예약어로 지정되어있는 문자까지  
모든 문자열을 전부 다 속성명으로 지정할 수 있다.  
그러나 속성명 자체가 JavaScript의 유효한 식별자가 아니면 속성 선언시  
string 선언처럼 작은 따옴표(')나, 큰 따옴표(")로 묶어주어야 한다.  

이러한 객체의 속성명을 객체를 통해 접근하는 방법은 **두 가지**가 있다.  
첫번째 방법으로는 점(.)으로 접근하는 방법이다.  
점(.)을 이용하여 객체에 정의된 속성에 접근할 수 있으며, 객체에 새로운 속성을 추가할 수도 있다.
```js
var obj = {
	a: 1,
	b: 2
}
console.log(obj.a);			// 1
obj.c = 3;
console.log(obj);			// {a:1, b:2, c:3}
```

그러나 점(.)으로 이용하는 접근자는 속성명이 유효한 JavaScript 식별자일때만 가능하다.  
속성명 자체가 예약어나, 공백, 특수문자, 숫자등... 유효하지 않는 식별자일 경우 점(.) 접근자로는 사용이 불가능하다.  
이럴때 사용하는 방법이 대괄호([]) 접근자 이다.  
대괄호 접근자를 이용하면 점 접근자와 동일하게 객체에 정의된 속성에 접근할 수 있으며, 새로운 속성을 추가할 수도 있다.
```js
var obj = {
	'default': 0,
	'1': 'a',
	'2': 'b'
}
console.log(obj['default'])			// 0
obj['3'] = 'c';
console.log(obj);					// {'default':0, '1':'a', '2':'b', '3':'c'}
```

**추가로 ES6에는 새롭게 추가된 문법들이 존재한다.**
  
첫번째로는 객체 내부에서 프로토 타입을 설정할 수 있다.  
프로토 타입에 대해서는 뒤에 자세히 설명하겠다.  
```js
var obj = {
	__proto__ : {
		run() {
			console.log('running...');
		}
	}
}

obj.run();		// running...
```
두번째는 객체 지향 설계와 비슷하게  
현 객체의 부모 클래스의 함수를 직접 호출할 수도 있게 되었다.
```js
var obj = {
	toString() {
		// JavaScript 객체의 toString은 '[object Object]' 이렇게 출력된다.
		return 'obj : ' + super.toString();
	}
}

console.log(obj.toString());		// obj : [object Object]
```
세번째는 다른 외부 변수를 객체의 속성으로 지정할때 기존보다 더 간단하게 지정할 수 있다.
```js
var temp = 'value';

var obj = {
	temp: temp		// temp 변수를 obj의 속성으로 지정하였다.
}

var obj2 = {
	temp			// ES6부터는 변수 자체를 객체의 속성에 명시하면
}					// 변수명과 변수에 할당된 값이 속성으로 자동으로 지정된다.

console.log(obj.temp);			// value
console.log(obj2.temp);			// value
```
마지막으로 객체의 속성명이 무조건 문자열이 아닌 동적으로도 지정이 가능하게되었다.  
기존에는 속성 값에 대해서만 동적으로 지정할 수 있었는데 속성명까지 확장 된 것이다.  
단, 동적 속성명을 사용시엔 속성명 부분을 대괄호([])로 묶어주어야 한다.
```js
var obj = {
	[
		(function() {
			return 'key';
		})();
	] : 'value';
}

console.log(obj.key);		// value
```

### <img src="../image/es6.png" height="15" title="ECMAScript6"> symbol
ES6에 새롭게 추가된 7번째 데이터 타입인 symbol은 기존 JavaScript 개념과는 조금 다른 유형이다.

symbol은 기본 형식처럼 범위 내에 정해진 값도 아니며, object처럼 규격화 된 데이터도 아니다.  
나름대로 간단히 말하자면 **'사용자가 정의한 표시'** 라고 말할 수 있을 것 같다.  
이러한 심볼을 생성하는 방법은 두 가지가 있다.

첫번째로는 Symbol()을 호출하여 생성하는 것이다.  
이렇게 생성된 심볼은 항상 고유한 심볼을 반환한다.  
참고로 안에 전달하는 첫번째 매개변수는 주석(Comment)를 입력하는 것이다.
```js
var sym = Symbol('comment');
console.log(typeof sym);		// symbol

var sym1 = Symbol('comment');
console.log( sym === sym1 );	// false
```

두번째로는 Symbol.for()을 호출하여 생성하는 것이다.  
호출시 첫번째 매개변수로 이름을 전달할 수 있는데 이는 Symbol()의 매개변수와는 다르게  
특정 이름을 가진 심볼을 반환한다.  
따라서 같은 이름으로 호출하면 동일한 심볼이 반환된다.
```js
var sym = Symbol.for('name');
console.log(typeof sym);		// symbol

var sym1 = Symbol.for('name');
console.log( sym === sym1 );	// true
```

이렇게 생성된 심볼은 객체에 속성명으로 사용할 수 있다.  
```js
var sym = Symbol.for('name');
var obj = {};
obj[sym] = 'value';
console.log(obj[sym]);		// value
```

그러나 심볼이 객체의 속성명으로 지정해도  
실제 해당 객체에 속성으로 추가된 것은 아니다.  
그냥 해당 객체에 심볼을 이용하여 특정 값을 표시해둔 것 이다.  
따라서 객체의 속성명을 반환하는 Object.keys()를 사용해도 심볼로 정의된 속성은 반환되지 않는다.
```js
var sym = Symbol.for('name');
var obj = {
	a: 1
}
obj[sym] = 'value';
console.log(Object.keys(obj));			// 'a'
```

이러한 심볼을 사용하는 이유는  
**특정 객체에 원본 데이터는 건드리지 않고 속성을 추가할 때 사용**된다.  
만약 기존 규격화 된 객체에 심볼이 아닌 자신만의 속성을 추가하면  
속성명이 중복되거나, Object.keys()로 기존 객체를 사용하고 있는 코드가 존재하면  
해당 부분은 비정상적으로 동작 할 것이다.  
이러한 이유 때문에 Symbol을 사용한다.  

심볼에 대한 좀 더 자세한 설명은 [여기서](http://hacks.mozilla.or.kr/2015/09/es6-in-depth-symbols/ 'Mozlia Hack Blog') 참조하길 바란다.

## 래퍼 객체 (Wrapper Object) 
JavaScript에 존재하는 원시형 데이터 타입인 boolean, number, string 타입들은  
각각 래퍼 객체(Wrapper Object) 라는 객체들과 한 쌍을 이루어 존재한다.  
JavaScript 뿐만 아니라, 다른 프로그래밍 언어에서도 이와 같은 래퍼 객체가 존재하는 걸 많이 볼 수 있을 것이다.

그러나 JavaScript의 래퍼 객체는 조금 다르다.  
JavaScript에서 래퍼 객체의 데이터 타입은 'object' 이다.  
그렇기 때문에 JavaScript의 특징 중 하나인 '프로토 타입(prototype)'을 커스터마이징 할 수 있다. (추후 설명)  
그럼 래퍼 객체에 사용자가 정의한 프로토 타입 메서드들을 사용할 수 있게 된다.

JavaScript는 여기서 끝이 아니다.  
JavaScript의 원시형 데이터 타입은 해당 래퍼 객체의 모든 메소드들을 사용할 수 있다.  
때문에 사용자가 정의한 프로토 타입도 얼마든지 원시형 데이터 타입에서 사용이 가능하다.

```js
Number.prototype.haha = function() {
	console.log('Number haha');
}

var num = 12345;
console.log(typeof num);		// number
num.haha();						// Number haha
```

이러한 방식이 가능한 이유는 JavaScript에서 원시형 데이터 타입의 변수에서 특정 메소드를 호출하면  
순간적으로 임시 래퍼 객체에 매핑을 실시하고 해당 메소드를 호출한다.  
그리고 메소드 호출이 끝나면 생성된 임시 객체는 자동으로 가비지로 변환된다.  
이러한 특징 때문에 원시형 데이터 타입에서 모든 래퍼 객체의 메소드를 사용할 수 있는 것이다.

하지만 주의할 점은 이러한 래퍼 객체와 원시형 데이터 타입은 엄연히 서로 다른 유형이라는걸 기억해야한다.
```js
var a = new Boolean(true);
var b = true;

console.log( typeof a );		// object
console.log( typeof b );		// boolean
console.log( a === b );			// false
```  


## 내장 객체 (Built in object)
ECMAScript 명세에는 기본으로 내장되어있는 객체들이 존재한다.  
위에서 언급한 래퍼 객체도 내장 객체에 일부라고 생각하면 된다.  
뿐만아니라, 대표적인 내장 객체는 Array, Date 등이 있으며,  
ES6에서는 더 많은 내장 객체들이 추가 되었다.

---
|[prev](./03-variable.ko-KR.md)|[content](./00-contents.ko-KR.md)|next|
|:--:|:--:|:--:|