# 연산자

## 대입 연산자
대입 연산자는 오른쪽 피연산자의 값을 왼쪽 피연산자에 대입한다.  
또한 대입 연산자와 동시에 연산을 하는 복합 대입 연산자도 존재한다.

|이름|복합 대입 연산자|뜻|
|:--|:--|:--|
|대입 연산|x = y|x = y|
|덧셈 대입|x += y|x = x + y|
|뺄셈 대입|x -= y|x = x - y|
|곱셈 대입|x *= y|x = x * y|
|나눗셈 대입|x /= y|x = x / y|
|나머지 연산 대입|x %= y|x = x % y|
|왼쪽 이동 연산 대입|x <<= y|x = x << y|
|오른쪽 이동 연산 대입|x >>= y|x = x >> y|
|부호 없는 오른쪽 이동 연산 대입|x >>>= y|x = x >>> y|
|비트 단위 논리곱 연산 대입|x &= y|x = x & y|
|비트 단위 베타적 논리합 연산 대입|x ^= y|x = x ^ y|
|비트 단위 논리합 연산 대입|x \|= y|x = x \| y|

## <img src="../image/es6.png" height="20" title="ECMAScript6"> 비구조 대입
비구조 대입이라는 것은 ES6에 추가된 문법으로  
객체나, 배열의 정형화된 값을 다른 변수에 대입하는걸  
비구조화된 배열과, 객체를 이용해 수행하는 것을 뜻한다.
```js
var arr = [1, 2, 3];

// 기존의 방식으로 배열을 변수에 대입
var one = arr[0];
var two = arr[1];
var three = arr[2];

// 비구조 대입을 이용하여 배열을 변수에 대입
var [one, two, three] = arr;
``` 
자세한 사항은 [여기서](./expressions/destructuring-assignment.ko-KR.md) 설명하겠다.

---
|[prev](./06-loop.ko-KR.md)|[content](./00-contents.ko-KR.md)|[next](./08-function.ko-KR.md)|
|:--:|:--:|:--:|
