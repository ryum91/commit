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
마크 다운의 기본적인 글의 구분은 문단으로만 구분한다.
따라서 마크 다운으로 글을 작성할 때 엔터를 한 번만 치면 같은 문단이라 판단해 실제 반환되는 결과는 모두 같은 줄로 붙여서 출력된다.
이러한 문단을 구분하고자 할 땐 엔터를 두 번 입력하면 문단 구분이 이루어진다.

만약 같은 문단안에서 강제로 띄어쓰기를 하고자 할 땐 스페이스바를 두 번 입력하면 된다.

--

### 글씨 크기
글씨 크기는 `#` 기호를 이용해 사용하며, 문서의 제목을 표현할 때 주로 사용된다. 
추가로 일정 크기 이상은 자동으로 하단에 구분선까지 추가해준다.
이러한 글씨 크기는 최대 1 부터 최소 6 까지 표현될 수 있으며, 이는 HTML의 `<h1>` ~ `<h6>` 를 의미한다.

#### 예제
```
# This is a H1
## This is a H2
### This is a H3
#### This is a H4
##### This is a H5
###### This is a H6
```

#### 예제 결과
# This is a H1
## This is a H2
### This is a H3
#### This is a H4
##### This is a H5
###### This is a H6

--

### 글씨 강조
글씨에 굵게 표시를 하거나, 기울임 같은 글씨에 강조 표현을 사용할 수 있다.
그때 사용되는 기호는 두 가지가 존재한다. `*` 과, `_`
이 두가지 기호 중 **한 가지를 이용해 한 개를 앞뒤로 붙일 경우 기울임**, **두 개를 앞뒤로 붙일 경우 굵게**, **세 개를 앞뒤로 붙일 경우 기울임 + 굵게**가 표현된다.

추가로 `~` 기호 두 개를 이용해 취소선을 할 수 있으며, ｀ 기호를 이용해 글씨에 블록 강조를 할 수 있다.

#### 예제
```
*This is Single highlight*
__This is Double highlight__
***This is Triple highlight***
~~cancel line~~
`block style`
```

#### 예제 결과
*This is Single highlight*  
__This is Double highlight__  
***This is Triple highlight***  
~~cancel line~~  
`block style`

--

### 리스트
리스트는 문서의 특정 리스트를 표현할 때 사용한다.
리스트 종류에는 번호가 있는 리스트와, 번호가 없는 리스트 이렇게 두 가지가 존재한다.

번호가 있는 리스트는 숫자를 이용하고, 번호가 없는 리스트는 `-`, `+`, `*` 이렇게 세 가지 기호를 이용한다.
번호가 있는 리스트 경우, 숫자의 순서 상관없이 결과에는 순서대로 정렬돼서 출력되며, 번호가 없는 리스트 경우 세 가지 기호를 섞어서 사용해도 무관하다.
추가로 리스트 내에서 들여쓰기를 사용할 경우 기호 앞에 `Tab` 을 입력하면 된다.

#### 예제
```
1. First
2. Second
3. Third
5. Fourth

- Apple
	- Orange
		- Grape
		
+ Apple
	+ Orange
		+ Grape
		
* Apple
	* Orange
		* Grape
		
- Apple
	+ Orange
		* Grape
```

#### 예제 결과
1. First
2. Second
3. Third
5. Fourth

- Apple
	- Orange
		- Grape
		
+ Apple
	+ Orange
		+ Grape
		
* Apple
	* Orange
		* Grape
		
- Apple
	+ Orange
		* Grape

--

### 링크

* **바로 연결**  
본문에 있는 URL 주소나, Mail 주소를 바로 연결할 수 있다. 이때 사용하는 기호는 꺽쇠 괄호를 이용한다.
	* **예제**
	```
	<http://google.com/>
	<address@example.com>
	```

	* **예제 결과**  
	<http://google.com/>  
	<address@example.com>
	
* **링크 연결**  
링크 주소를 특정 텍스트에 연결할 수 있다. 이때 사용하는 문법은 대괄호([]) 안에 링크를 걸 텍스트를 입력하고, 그 뒤에 소괄호를 이용해 링크 대상 URL을 입력한다.
또한 링크 URL 입력 후 맨 뒤에 큰 따옴표를 이용하여 링크의 Title 을 지정할 수 있다.
	* **예제**
	```
	[구글](http://google.com "Go Google")
	```
	
	* **예제 결과**  
	[구글](http://google.com "Go Google")
	
* **참조 링크**  
참조 링크는 링크의 대상을 미리 지정해 놓고, 해당 링크를 불러와서 쓰는것을 의미한다.
링크의 대상을 지정할 땐 대괄호와, 콜론을 이용한다.
[GoogleLink]: http://google.com "Go Goole - Reference Link"
	* **예제**
	```
	[GoogleLink]: http://google.com "Go Goole - Reference Link"
	
	구글 : [Google][GoogleLink]
	```
	
	* **예제 결과**  
	구글 : [Google][GoogleLink]
	
	  
--

### 인용문
인용문을 사용할 때는 `>` 기호를 이용하여 사용한다.
추가로 인용문 안에서는 다른 마크 다운 문법을 사용할 수도 있다.

#### 예제
```
> This is a block quote  
> ### This is a block quote in header
>> This is a Double block quote
```

#### 예제 결과
> This is a block quote  
> ### This is a block quote in header
>> This is a Double block quote

--

### 코드 블록
코드를 표현할 때 블록으로 강조해서 표현할 수 있다. 이때 사용되는 기호는 `Tab` 과, `｀` 3개를 이용한다.
`Tab` 은 시작을 `Tab` 문자로 시작하면 코드 블록이 시작되고, `Tab` 이 종료되면 코드 블록도 종료된다.
`｀` 는 3개 쓰면 코드 블록이 시작되고, 다시 한 번 세개를 쓰면 코드 블록이 종료된다.

추가로 GitHub 의 Markdown 에서는 코드 블록에 프로그래밍 언어 별로 하이라이트 표시를 사용할 수 있다.
그때는 `｀` 3개 이후 특정 프로그래밍 언어 이름을 선언 후
코드 블록을 시작하면 된다.

(여기서 등장하는 `｀` 는 ESC키 밑에 존재하는 Back Quote 를 의미하며, 설명에서는 비슷한 특수 문자를 사용하였다.)

#### 예제
```
	Code block1 start
	Code block1 end
	
｀｀｀
Code block2 start
Code block2 end
｀｀｀

｀｀｀javascript
var test = function() {
	console.log('test!');
}
｀｀｀
```

#### 예제 결과
	Code block1 start
	Code block1 end
	
```
Code block2 start
Code block2 end
```

```javascript
var test = function() {
	console.log('test!');
}
```	
	
--

### 수평선
수평선은 문서 내에서 특정 구분선을 지을 때 사용한다.
이때 사용되는 기호는 `*`, `-`, `_` 중 하나를 세개 이상 나열하면 된다.
그 중에 `-` 기호는 두 개만 입력해도 수평선이 반환되는데 조금 얇은 구분선이 반환된다.

#### 예제
```
***

-----

_________________
```

#### 예제 결과
***

-----

_________________

--

### 이미지
이미지를 출력하는 것도 손쉽게 가능하다.
이미지 출력시 링크와 문법이 비슷하나, 맨 앞에 느낌표가 붙는다.
또한 이미지가 찾을 수 없거나, 로딩 시간에 보여주는 대체 텍스트도 설정이 가능하다.

그러나 마크다운 문법으로 이미지 출력시 사이즈 조절이 안되기 때문에 사이즈 조절이 필요한 경우
HTML 태그를 이용해야한다.

#### 예제
```
![대체 텍스트1](images/chrome.png "Chrome icon")
![대체 텍스트2](images/chrome1.png "Chrome icon")
```

#### 예제 결과
![대체 텍스트1](images/chrome.png "Chrome icon")  
![대체 텍스트2](images/chrome1.png "Chrome icon")

## Reference
* [kalkin7 - Markdown](http://blog.kalkin7.com/2014/02/10/lets-write-using-markdown/)
* [Kim ji heon - GitHub Gist](https://gist.github.com/ihoneymon/652be052a0727ad59601)