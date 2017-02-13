# Markdown

## 소개
[Markdown(마크다운)](https://ko.wikipedia.org/wiki/%EB%A7%88%ED%81%AC%EB%8B%A4%EC%9A%B4) 이란 일반 텍스트 기반 문서를 편집하는 문법으로,
2004년 [존 그루버](https://en.wikipedia.org/wiki/John_Gruber)에 의해 만들어진 마크업 언어이다.

특징으로는 기존 HTML의 복잡한 문법 대신에 간단한 문서작성, 이미지 삽입 같은 글쓰기에 특화된 것들만 모아서 **배우기 쉽고, 보다 간결하게 작성할 수 있다는 점**이 있으며,
별도의 도구 없이 누구나 쉽게 작성할 수 있다.

그러나 HTML 처럼 다양한 리소스를 표현하기에는 역부족이 있으므로 딱 글을 쓰는 용도로만 사용해야 한다. 비록 마크다운에서 HTML 태그 일부를 지원하여 사용할 수 있다지만
글 쓰는 용도 이상을 넘어가게 되면 마크다운의 의미가 없어지는 것과 같다.

## 문법

### 문단 구분
마크 다운의 기본적인 글의 반환은 문단으로 구분한다.
따라서 마크 다운으로 글을 작성할 때 엔터를 한 번만 치면 같은 문단이라 판단해 실제 반환되는 결과는 모두 같은 줄로 붙여서 출력된다.
이러한 문단을 구분하고자 할 땐 엔터를 두 번 입력하면 문단 구분이 이루어진다.

만약 같은 문단안에서 강제로 띄어쓰기를 하고자 할 땐 스페이스바를 두 번 입력하면 된다.

### 글씨 크기
글씨 크기는 `#` 기호를 이용하여 문서의 제목을 표현할 때 주로 사용되며, 일정 크기 이상은 자동으로 하단에 구분선까지 추가해준다.
글씨 표현은 최대 1 부터 최소 6 까지 표현될 수 있으며, 이는 `<h1>` ~ `<h6>` 를 의미한다.

**작성**
```
# This is a H1
## This is a H2
### This is a H3
#### This is a H4
##### This is a H5
###### This is a H6
```

**결과**
# This is a H1
## This is a H2
### This is a H3
#### This is a H4
##### This is a H5
###### This is a H6

### 인용문
인용문을 사용할 때는 `>` 기호를 이용하여 사용한다.
인용문 안에서는 다른 마크 다운 문법을 사용할 수도 있다.

**작성**
```
> This is a block quote  
> ### This is a block quote in header
>> This is a Double block quote
```

**결과**
> This is a block quote  
> ### This is a block quote in header
>> This is a Double block quote

## Reference
* [kalkim7 - Markdown](http://blog.kalkin7.com/2014/02/10/lets-write-using-markdown/)
* [Kim ji heon - GitHub Gist](https://gist.github.com/ihoneymon/652be052a0727ad59601)