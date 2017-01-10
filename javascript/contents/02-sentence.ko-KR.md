# 기본 구문

## 기본
* JavaScript 파일은 js 확장자로 이루어져있다.
* 기본적으로 대소문자를 구분한다.
* 모든 문장은 세미콜론(;) 으로 구분한다.
 * JavaScript 특성상 문장 끝에 세미콜론(;)을 붙이지 않아도 대부분 오류가 나지는 않지만 좋은 습관은 아니며 특정 구문에선 오류가 나는 경우도 존재한다.

<br>
## 주석
JavaScript의 주석은 Java나, C++ 등 다른 여러 프로그래밍 언어와 동일하다.
```js
// 한줄 주석

/*
 여러줄 주석
 여러줄 주석
 */
```

<br>
## HTML에서 불러오기
JavaScript를 웹 브라우저에서 실행하려면 HTML에서 js 파일을 불러와야한다.  
불러오는 방법은 HTML 태그중 &lt;script&gt; 태그를 사용한다.
```html
<script type="text/javascript" src="javascript.js"></script>
```

HTML5 이후부터는 type 속성을 굳이 작성하지 않아도 기본적으로 JavaScript라고 인식한다.  
그렇기 때문에 src 태그만 작성해도 무관하다.
```html
<script src="javascript.js"></script>
```

HTML에서 JavaScript 파일을 불러오는것 뿐만아니라, 바로 작성하는것도 가능하다.
```html
<script>
	// JavaScript Sentence
</script>
```

HTML은 JavaScript 파일 로딩을 기본적으로 선언한 순서대로 실시한다.  
따라서 상위 스크립트 파일 로딩이 끝난 뒤, 하위 스크립트 파일을 로딩한다.  
하지만 HTML5 부터는 script 태그에 'async' 속성을 추가하면 비동기로 한번에 여러개의 스크립트를 로딩한다.
```html
<script src="javascript1.js" async></script>
<script src="javascript2.js" async></script>
```

---
|[prev](./01-intro.ko-KR.md)|[content](./00-contents.ko-KR.md)|[next](./03-variable.ko-KR.md)|
|:--:|:--:|:--:|