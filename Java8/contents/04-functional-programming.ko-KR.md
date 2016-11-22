# Functional Programming

## Functional Programming in Java
많은 사람들이 Java8에서의 가장 큰 변화는 바로 '함수형 프로그래밍의 지원' 이라고 말한다.  
관련해서는 [Java8 Preface](http://docs.oracle.com/javase/specs/jls/se8/html/jls-0-preface8.html)에서도 다음과 같이 소개되어있다.
> combine to offer a programming model that fuses the object-oriented and functional styles.  
> 객체 지향과 함수형 스타일을 융합하는 프로그래밍 모델을 제공합니다.

즉, 객체 지향 언어인 Java에서 함수형 프로그래밍의 기능 일부를 제공한다는 뜻이다.  
주의 할 점은 일부를 지원한다는 것이지, **함수형 프로그래밍의 전체를 지원한다는 뜻이 아니다**
  
그렇다면 기존 객체 지향 언어에 익숙한 자바 개발자에게  
함수형 프로그래밍이란 무엇이고, 자바에서 지원하는 함수형 프로그래밍의 기능이 무엇인지 간단하게 짚고 넘어가자.

## Functional Programming
함수형 프로그래밍의 특징은 크게 두 가지로 나뉠 수 있다.
* 함수는 1급 객체이여야 한다.
* 모든 값들은 immutable(불변) 해야 한다.