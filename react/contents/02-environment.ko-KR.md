# 개발 환경

## Server Side
Spring Framework 로 구성하며 View 제어는 Spring MVC 로 이용한다.  
데이터 전달은 JSON 방식의 Restful API 로 전달하며  
예제에서는 별도 DB를 사용하지 않고 메모리로만 관리한다.

#### 버전 정보
- **Java** 1.8
- **Servlet** 3.0.1
- **Spring Framework** 4.3.10

## Front End
NPM을 이용하여 패키지 관리를 하며  
ES2015 + React 방식으로 개발을 한다.  
따라서 Webpack 과 Babel 을 이용하여 모듈화와 번들링을 진행한다.  
또한 Library injection 은 최소화하며 특히 jquery 는 사용하지 않는다.

#### 버전 정보
- **webpack** 3.5.5
- **react** 15.6.1

※ Front End 버전은 자주 변경될 수 있으며, Major Version 이 변경되지 않는 한 다른 버전도 무관하다.

---
|[prev](./01-intro.ko-KR.md)|[content](./00-contents.ko-KR.md)|next|
|:--:|:--:|:--:|
