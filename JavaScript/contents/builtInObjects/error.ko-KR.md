# Error
Error 객체는 프로그램이 실행 중에 발생되는 에러나, 오류에 사용되는 내장 객체이다.

## 문법
```js
new Error([message]);
```
### (String) message
message는 에러에 대한 설명으로 아무런 값을 전달하지 않으면  
Empty String ("")으로 초기화된다.

## 설명
JavaScript 수행 중에 에러나 오류가 발생되면 내부적으로 Error 객체를 생성하여 throw 한다.

## 속성
### (String) name
에러에 대한 이름이다. 기본적으로 'Error' 자체가 name으로 초기화된다.

### (String) message
객체 생성자의 매개 변수로 전달받은 message가 초기화된다.

## 메소드
Error 객체 자신은 메소드가 존재하지 않는다.  
단, 프로토타입 체인을 통하여 메소드 상속 및 메소드 추가는 가능하다.

## 하위 객체
ECMAScript에는 기본적으로 Error 객체를 상속하고 있는 하위 객체들이 존재한다.  
표준으로 제공되는 하위 객체는 총 여섯 가지 Error 객체가 존재한다.  
또한 여섯 가지를 제외하고, 얼마든지 Error 객체를 상속받아 하위 객체를 만들어 사용할 수 있다.

### EvalError
전역 함수인 eval()에 의하여 발생되는 에러

### RangeError
숫자 변수나 파라미터가 유효한 범위를 벗어났을 때 발생되는 에러

### ReferenceError
잘못된 참조를 했을 때 발생되는 에러

### SyntaxError
문법이 잘못되어 발생되는 에러

### TypeError
변수나 파라미터가 적절한 타입이 아닐때 발생되는 에러

### URIError
encodeURI()나, decodeURI() 함수에 부적절한 파라미터가 전달됐을 때 발생되는 에러