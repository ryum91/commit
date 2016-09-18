# 개요

## JavaScript 개요
JavaScript는 1995년 Netscape의 엔지니어 Brendan Eich에 의해 만들어졌으며,  
1996년 Netscape 2와 함께 처음 릴리즈 된 되게 작고 가벼운 프로그래밍 언어이다.  
원래 처음에는 'LiveScript'로 불려지기 했지만, Java 언어의 성공에 편승해보려고  
두 언어 사이의 공통점이 매우 적음에도 불구하고, 마케팅으로 인해 이름을 현재의 'JavaScript'로 변경하게 되었다.  

JavaScript의 시작은 웹 개발에 있어서 웹 페이지를 동적으로, 또한 프로그래밍적으로 제어하기 위해서 시작되었다.  
하지만 JavaScript가 등장하고 처음부터 웹 개발에 있어서 JavaScript가 필수적인 요소는 아니였다.  
초창기 JavaScript는 웹 개발에 단순 보조적인 기능을 수행하기 위한 용도로써 사용 할 뿐이였다.  

하지만 점점 세상에 많은 플랫폼들이 등장하면서 유일한 공통 부분인 **웹**의 중요성이 크게 증가하였다.  
그러자 웹에서 유일하게 사용할 수 있는 JavaScript에 대한 연구가 활발하게 이루어 지면서 그 비중이 크게 증가하였다.  
그 결과, 웹 개발에 있어서 JavaScript는 더이상 선택이 아닌 필수로 자리잡게 되었으며  
웹 개발 뿐만 아니라 서버 개발, 네이티브 어플리케이션 개발 등...  
JavaScript는 본격적으로 **크로스 플랫폼** 언어라고 불리면서 많은 개발에 활용되어 지고 있다.

<br>
## 웹에서의 JavaScript
JavaScript가 아무리 크로스 플랫폼 언어라고 해도 현재까지 가장 많이 사용되어지는 부분은 바로 웹이다.  
웹에서도 웹 브라우저 내에서 동작하는 부분이 가장 많이 차지하고 있는데  
웹 브라우저에서의 JavaScript는 'ECMAScript'와, 'DOM'이라 불리는 두 가지의 핵심 기술이 포함되어 사용된다.  
간단하게 말하자면 웹에서의 JavaScript는 'ECMAScript + DOM' 이라고 생각하면 된다.

<br>
## ECMAScript
ECMAScript는 [Ecma International](http://www.ecma-international.org)에서 표준을 정의하는 프로그래밍 문법으로  
JavaScript는 이러한 ECMAScript 명세에 서술된 모든 기능을 지원한다.  
하지만 ECMAScript 명세를 보면 일반적인 JavaScript를 사용하는 프로그래머는 이해하기 힘들 것이다.  
이러한 ECMAScript 명세는 ECMAScript를 이용한 직접적인 구현이나,  
어떠한 엔진(Firefox의 SpiderMondey, 또는 Chrome의 v8)에서 표준을 따르는 언어의 기능을 구현할 때 사용되는 것이다.
  
그렇다고 ECMAScript와 JavaScript가 아예 다른 언어는 아니다.  
서로 사용된 기술과 문법이 다를 뿐이지, 언어 그 자체는 같다.  
그렇기 때문에 JavaScript에서는 ECMAScript 명세에 서술된 모든 기능을 지원한다는 것이다.

그럼 또 하나의 의문점이 생길 수 있다.  
ECMAScript는 현재(2016년 6월)기준으로 7th Edition까지 등장하였다.  
그렇다면 가장 최신 버전인 ES7을 현재 JavaScript에서 사용할 수 있는 것일까?  
그 의문점에 대한 답변으로는 **해당 문법을 플랫폼에서 지원해 주어야 한다는 것**이다.

플랫폼 중에서 JavaScript가 가장 많이 쓰여지는 웹 브라우저를 보면  
과거 ES3가 등장할때 까지만 해도 모든 웹 브라우저에서는 해당 문법을 전부 다 지원을 했었다.  
하지만 ES5 이후로 Microsoft는 ES에 대한 지원을 신규 버전 브라우저에 대해서만 하기 시작했다.  
*(ES4는 기존과 너무 큰 차이점 때문에 표준으로 채택되지 못했다. 하지만 ES6와, ES7에 ES4의 일부 문법이 다시 포함되었다.)*  
그 경계선이 바로 Internet Explorer 8 버전이다.  
따라서 JavaScript로 웹 개발을 하는데 있어서 만약 IE8에서 동작하지 않는다면, 해당 문법은 ES5에 추가 된 문법일 확률이 높다.  
그렇다고 IE9 이후 버전이라고 해서 ES5의 모든 문법을 지원하지는 않는다. [[참조]](http://kangax.github.io/compat-table/es5/)  
추가로 ES6에 대한 지원으로는 Edge와 FireFox, Chrome, Safari 등.. 최신버전 브라우저 만이 일부 지원하고 있다.

여담으로, ECMAScript 버전 표현법에 대해 기존에는 ES3, ES5 이렇게 Edition 번호로 표현하였는데,  
ES6 이후로 발표된 ECMAScript에 대해서는 뒤에 발표한 년도를 붙여서 말하기도 한다.  
그래서 2015년에 발표한 ES6는 'ECMAScript2015' 라고도 하고,  
2016년 6월에 발표한 ES7를 'ECMAScript2016' 라고도 불린다. [[참조]](https://en.wikipedia.org/wiki/ECMAScript#ECMAScript_Harmony)

<br>
## DOM(Document Object Model)
DOM은 [W3C](https://ko.wikipedia.org/wiki/W3C)에 의해 표준이 관리되어지는 것으로  
HTML이나 XML 문서를 추상화하여 특정 언어에 관계없이 사용되어지는 Model을 말한다.  
JavaScript에서는 이런 DOM 중에서도 HTML DOM을 사용하며, document 같은 API로 DOM을 제어한다.

하지만 ECMAScript와 마찬가지로 DOM 역시 플랫폼(브라우저)의 지원 여부에 따라 동작한다.  
이러한 DOM이 브라우저마다 지원 여부가 다른 가장 큰 이유는 DOM에 대한 기능 명세가 불분명하기 때문이다.  
또한 FireFox나 Chrome 같은 각각의 브라우저에서 자신들만의 기능들을 커스터 마이징하면서 사용하는 문제도 포함되어있다.  

이런 브라우저 호환성과 불분명한 기능 명세를 해결하기 위한 가장 단순한 방법은  
여러 브라우저에서 호환이 되게 해주는 자바스크립트 라이브러리를 사용하는 것이다.  
이런 라이브러리들은 DOM을 추상화하여 여러 브라우저에서도 같은 기능을 쓸 수 있게 해주는게 특징이다.  
대표적으로 가장 많이 쓰이는 라이브러리로는 [jQuery](http://jquery.com/), [prototype](http://prototypejs.org/), [YUI](http://yuilibrary.com/)가 존재한다.

---
|[prev](./00-contents.ko-KR.md)|[content](./00-contents.ko-KR.md)|[next](./02-sentence.ko-KR.md)|
|:--:|:--:|:--:|