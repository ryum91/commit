# 함수 내의 arguments 객체

함수 내에서는 특별한 객체인 **arguments** 라는 객체를 사용할 수 있다.  

```js
function func() {
	arguments;
}
```

## 매개 변수 전달 받기
arguments 객체를 이용해서 매개 변수를 전달 받을 수 있다.  
이는 실제 함수 선언부에 선언된 매개 변수 뿐만 아니라, 추가로 전달된 매개 변수까지 받을 수 있다.

이때 arguments 객체의 length 프로퍼티를 이용해 매개 변수의 개수를 알 수 있으며,  
arguments 객체를 배열처럼 사용하면 실제 전달 받은 매개 변수의 값을 알 수 있다.

```js
function func(a, b) {
	var length = arguments.length;
	console.log('length : ' + length);
	
	for( var i = 0; i < length; i ++ ) {
		console.log('arguments[' + i + '] : ' + arguments[i]);
	}
}

func('a');				// length : 1
						// arguments[0] : a
						
func('a', 'b');			// length : 2
						// arguments[0] : a
						// arguments[1] : b

func('a', 'b', 'c');	// length : 3
						// arguments[0] : a
						// arguments[1] : b
						// arguments[2] : c
```

## 현재 함수 재귀 호출
arguments 객체를 이용하면 현재 함수를 재귀 호출할 수 도 있다.  
이때 사용하는 프로퍼티는 `callee` 라는 프로퍼티를 이용해 사용할 수 있다.

```js
function factorial(n) {
	if( typeof n !== 'number' || n < 1 ) {
		throw 'Bad Argument';
		
	} else if( n === 1 ) {
		return 1;
		
	} else {
		return n * arguments.callee(n-1);
	}
}
```

여기서 `callee` 의 의미는 `factorial` 함수를 그대로 호출하는 것과 동일하다고 생각하면 된다.