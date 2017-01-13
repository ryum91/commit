# <img src="../../image/es6.png" height="25" title="ECMAScript6"> 비구조 할당 (Destructuring Assignment)

기존에 객체 또는 배열같은 정형화 된 변수를  
다른 변수에 대입하거나, 초기화 하는 구문은 항상 아래 예제처럼 사용해왔다.  

```js
// 기존의 배열 선언
var arr = [1, 2, 3, 4, 5];
// 배열의 값을 다른 변수에 대입
var arrTmp = arr[0];

// 기존의 객체 선언
var obj = {a:10, b:20, c:30}
// 객체의 값을 다른 변수에 대입
var objTmp = obj.a;
```

이러한 방식을 비정형화 된 별개의 변수를 이용하는 걸 **비구조 할당** 이라 말한다.  
여기서는 그러한 비정형화 된 변수를 '**익명 객체**', '**익명 배열**' 이라고 설명한다.

## 배열의 비구조 대입 - 익명 배열 (Anonymous Array)
배열의 값을 다른 변수에 대입하는 방법을 **익명 배열** 이라는 새로운 문법을 이용하여 할 수 있다.

익명 배열이란 배열의 실체없이 배열을 만드는 것을 말하며,  
변수의 선언과 동시에 익명 배열을 만들 수도 있고,  
이미 선언된 변수를 익명 배열로 만들 수도 있다.

```js
var a, b, c;		// 변수 선언
[a, b, c];			// 익명 배열 생성

var [_a, _b, _c];	// 변수 선언과 동시에 익명 배열 생성
```

익명 배열의 특징은 별도의 배열 Reference가 존재하지 않는다는 것이다.  
그렇기 때문에 배열 내의 요소들은 실제 원형 요소들을 직접 참조하게 된다.  
따라서 익명 배열을 생성할 때는 변수 선언과 동시에 생성하거나,  
실제 Reference 상에 존재하는 값만 요소에 넣어서 생성할 수 있다.  
좀 더 자세한 내용은 밑에서 계속해서 설명하겠다.

### 익명 배열 사용 방법
먼저 익명 배열은 별도의 Reference가 존재하지 않아서  
배열 내의 요소들은 실제 원형 요소들을 참조한다고 하였다.  

이를 이용하면 익명 배열의 요소를 변경하면 실제 원형 데이터가 변경된다는 뜻이 된다.  
```js
var arr = [1, 2, 3];

var [one, two, three] = arr;		// 변수 선언 & 익명 배열 생성과 동시에 다른 배열로 초기화
console.log(one, two, three);		// 1, 2, 3

var _one, _two, _three;	
[_one, _two, _three] = arr;			// 익명 배열을 생성해 다른 배열로 값 할당
console.log(_one, _two, _three);	// 1, 2, 3
```

익명 배열에 다른 대상 배열로 덮어씌우게 되면 익명 배열의 순서대로 대입이 된다.  
따라서 대상 배열 중간 값을 건너뛰고 싶을때는 익명 배열 중간에서도 건너뛰면 된다.
```js
var arr = [1, 2, 3];
var [one, ,three] = arr;
```

또한 익명 배열을 이용하여 변수의 값을 서로 바꾸는 것도 손쉽게 가능하다.
```js
var one = 2;
var two = 1;
[one, two] = [two, one];
```

## 객체의 비구조 대입 - 익명 객체 (Anonymous Object)
배열의 비구조 대입과 마찬가지로, 객체의 특정 프로퍼티를 다른 변수에 대입하는 방법을  
비구조 방식으로 **익명 객체** 라는 새로운 문법을 이용하여 할 수 있다.

익명 객체란 객체의 선언 없이 객체를 만드는 것을 말하며,  
익명 배열과 동일하게 변수의 선언과 동시에 익명 객체를 만들 수도 있고,  
이미 선언된 변수를 익명 객체로 만들 수도 있다.  

```js
var a, b, c;		// 변수 선언
({a, b, c});		// 익명 객체 생성

var {_a, _b, _c};	// 변수 선언과 동시에 익명 객체 생성
```
익명 배열과 약간 다른 점은 이미 선언된 변수를 익명 객체로 만들때  
단순히 `{a, b, c}` 이렇게 사용하면 블록 단위로 간주되기 때문에 익명 객체의 리터럴이 될 수 없다.  
따라서 앞뒤에 괄호를 넣어서 `({a, b, c})` 이렇게 선언해야 한다.

### 익명 객체 사용 방법
익명 객체는 익명 배열과 마찬가지로 별도의 Reference가 존재하지 않고,  
익명 객체 생성에 쓰인 원형 변수를 직접 참조하게 된다.  

이를 이용하여 다른 객체를 이용하여 익명 객체 생성에 쓰인 변수를 초기화 하거나, 값을 할당할 수 있다.
```js
var obj = {a:1, b:2, c:3};
var {a, b, c} = obj;

console.log(a, b, c);	// 1, 2, 3
```

여기서 중요한 점은 익명 객체를 생성할 때 사용한 구문의 속 뜻은  
[데이터구조 - object](../04-datastructure.ko-KR.md#object) 에서 언급한 간소화된 프로퍼티 선언이라는 것이다.  
따라서 위에서 작성한 예시는 다음과 같은 문장이라고 생각하면 된다.
```js
var obj = {a:1, b:2, c:3};
var {a:a, b:b, c:c} = obj;

console.log(a, b, c);	// 1, 2, 3
```

익명 객체의 프로퍼티명이 대상 객체를 통해 변수에 들어가는 값이 되는 것이고,  
익명 객체의 프로퍼티값은 실제 선언된 변수명이 되는 것이다.

이를 이해하면 꼭 대상 객체의 프로퍼티명으로 된 변수만 생성할 수 있는 것이 아니라는 것을 알 수 있다. 
```js
var obj = {a:1, b:2, c:3};
var {a:one, b:two, c:three} = obj;

console.log(one, two, three);	// 1, 2, 3
```

추가로 익명 객체 선언 시 값을 초기화하는 구문을 넣을 수도 있다.  
이 구문의 의미는 **익명 객체를 통해 생성된 변수의 초기값** 이라는 의미를 가지고 있다.
```js
var obj = {a:1, b:2};
var {a=10,		b=20,		c=30}		= obj;
var {a:_a=10,	b:_b=20,	c:_c=30}	= obj;

console.log(a, b, c);		// 1, 2, 30
console.log(_a, _b, _c);	// 1, 2, 30
```

익명 객체를 이용하면 함수 매개 변수의 기본 값을 좀 더 간결하게 작성할 수 있다.
```js
function example( {size = 'big', cords = {x:0, y:0}, radius = 25} = {} ) {
	console.log(size, cords.x, cords.y, radius);
}

example({
	cords: {x:10, y:20},
	radius: 30
});
// big, 10, 20, 30
```

마지막으로 [데이터구조 - object](../04-datastructure.ko-KR.md#object) 에서 언급한 동적 프로퍼티명을 이용해서도  
익명 객체를 사용할 수도 있다.
```js
var key = function() {
	return 'z';
}

var { [key()] : foo } = { z: 'bar' };

console.log(foo);	// bar
```

이러한 비구조 할당 문법은 기존 JavaScript와는 너무 이질적인 부분이 많이 있어서 혼란이 올 수 있다.  
하지만 ES6에서 공식 릴리즈에 포함이 되었기 때문에 알아두면 좀 더 간결한 코드를 작성할 수 있을 것이다.  
또한 코드의 흐름이 빠른 오픈 소스 프로젝트에 참여하고 싶은 개발자들은 꼭 알아두는게 좋을 것이다.