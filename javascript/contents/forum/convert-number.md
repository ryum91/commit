# 숫자가 아닌 데이터 타입을 숫자로 변환하기

## 변환 방법
JavaScript에서 숫자가 아닌 데이터 타입을 숫자형으로 변환하는 방법은 총 여섯 가지가 존재한다.

1. Number 객체의 생성자를 이용하는 방법
2. 전역 함수인 parseInt를 이용하는 방법
3. 단항 산술 연산자를 이용하는 방법
4. 이항 산술 연산자를 이용하는 방법
5. 단항 비트 단위 연산자를 이용하는 방법
6. 이항 비트 단위 연산자를 이용하는 방법

### Number 객체의 생성자를 이용하는 방법
숫자 데이터를 표현하는 객체인 Number의 생성자를 이용하여 숫자 변환을 할 수 있다.
```js
var str = "10";
var num = Number(str);
console.log(num);	// 10
```

### 전역 함수인 parseInt를 이용하는 방법
전역 함수인 parseInt를 이용하여 숫자 변환을 할 수 있다.
```js
var str = "10";
var num = parseInt(str);
console.log(num);	// 10
```

### 단항 산술 연산자를 이용하는 방법
단항 산술 연산자인 + 를 이용하여 숫자 변환을 할 수 있다.
```js
var str = "10";
var num = +str;
console.log(num);	// 10
```

### 이항 산술 연산자를 이용하는 방법
이항 산술 연산자인 * 와, - 를 이용하여 숫자 변환을 할 수 있다.
```js
var str = "10";
var num = str * 1;
console.log(num);	// 10

var num2 = str - 0;
console.log(num2);	// 10
```

### 단항 비트 단위 연산자를 이용하는 방법
단항 비트 단위 연산자인 ~ 를 이용하여 숫자 변환을 할 수 있다.
```js
var str = "10";
var num = ~~num;
console.log(num);	// 10
```

### 이항 비트 단위 연산자를 이용하는 방법
이항 비트 단위 연산자인 >> 를 이용하여 숫자 변환을 할 수 있다.
```js
var str = "10";
var num = str >> 0;
console.log(num);	// 10
```

## 차이점 - 대상
위에 언급된 예제는 변환 대상이 모두 문자로 표현된 숫자였다.  
하지만 만약 변환 대상이 객체나 다른 문자열이면 어떻게 되는지 비교해보자

### 객체
```js
var obj = {};

Number(obj);		// NaN
parseInt(obj);		// NaN
+obj;				// NaN
obj * 1;			// NaN
~~obj;				// 0
obj >> 0;			// 0
```

### 배열
```js
var arr = [];

Number(arr);		// 0
parseInt(arr);		// NaN
+arr;				// 0
arr * 1;			// 0
~~arr;				// 0
arr >> 0;			// 0
```

### Boolean
```js
var bool = true / false;

Number(bool);		// 1 / 0
parseInt(bool);		// NaN / NaN
+bool;				// 1 / 0
bool * 1;			// 1 / 0
~~bool;				// 1 / 0
bool >> 0;			// 1 / 0
```

### 일반 문자열
```js
var str = "ABCD";

Number(str);		// NaN
parseInt(str);		// NaN
+str;				// NaN
str * 1;			// NaN
~~str;				// 0
str >> 0;			// 0
```

### 숫자로 시작하는 문자열
```js
var str = "123ABC";

Number(str);		// NaN
parseInt(str);		// 123
+str;				// NaN
str * 1;			// NaN
~~str;				// 0
str >> 0;			// 0
```

위 예제를 보면 `parseInt` 같은 경우에는 정확한 숫자형만 비교하는 것을 알 수 있다.  
그러나 숫자로 시작하는 문자열 같은 경우엔 `parseInt`만 숫자형으로 변환되었다.  
따라서 단위를 표현하는 곳에서 숫자 값만 분리시키고 싶을 땐 `parseInt`를 사용하면 된다.  
또한 10진수가 아닌, 2진수, 8진수, 16진수로 표현된 문자열 같은 경우에도 진법에 따른 리터럴이 아니면 `parseInt` 로만 변환이 가능하다.

## 차이점 - 속도
오픈 소스 프로젝트인 [JavaScript Performance](http://jsperf.com/) 에 보면 이와 같은 [숫자형 변환에 대한 테스트 케이스](http://jsperf.com/number-vs-parseint-vs-plus/3)가 올라와 있다.  
물론 JavaScript 엔진에 따라 약간 차이는 있지만 여러 브라우저에서 테스트 한 결과 비슷하게 나왔다.

먼저 제일 빠른것은 아무대로 비트 단위 연산자를 이용한 것이 제일 빠른 것으로 나왔다.  
그 다음으로는 산술 연산자를 이용한 것이 빨랐으며,  
Number 객체와 parseInt 함수를 사용하는 것이 제일 느리게 나왔다.

물론 제일 느린것과, 제일 빠른것의 차이는 크지 않았다.  
하지만 대용량의 데이터와 속도가 중요시 하는 경우와  
기타 여러가지 경우에 따라 숫자형 변환이 필요한 경우 적절한 방법을 선택하는 것이 좋을 것 같다.