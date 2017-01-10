# 함수

## 함수 정의
함수를 정의하는 방법에는 두 가지 방법이 존재한다.  

## 함수 선언법
함수 선언법이란 `function` 키워드를 사용해서 직접 함수를 선언하는 것을 말한다.  
그리고 함수의 이름과 괄호를 이용하여 선언하는 매개 변수 목록 그리고 함수 내용으로 구성된다.
```js
function square(number) {
	return number * number;
}
```

## 함수 표현법
함수 표현법이란 기존 변수 키워드에게 함수를 표현하는 것을 말한다.  
따라서 함수명을 `var` 나, `let` 같은 변수 키워드를 이용하여 나타내며,  
나머지는 함수 선언법과 비슷하다.
```js
var square = function(number) {
	return number * number;
}
``` 

---
|[prev](././07-operator.ko-KR.md)|[content](./00-contents.ko-KR.md)|next|
|:--:|:--:|:--:|
