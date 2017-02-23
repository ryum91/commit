# scp

**scp** 는 **Secure Copy**의 약자로 서버간에 파일을 송수신 할때 사용하는 unix 계열의 utility 이다.

## 다른 서버로 보내기
```
scp [SourceFile] [User]@[Host]:[TargetDirectory]|[TargetFile]
```

### SourceFile
다른 서버로 보낼 파일

### User
대상 서버 계정

### Host
대상 서버 호스트

### TargetDirectory | TargetFile
대상 서버에 저장될 디렉토리나 대상 서버에 저장될 파일명

TargetDirectory 생략시 User의 홈 디렉토리에 저장되며,  
TargetFile 생략시 SourceFile과 동일한 파일명으로 저장된다.  
둘 다 입력도 가능하며, 둘 다 생략시에는 User의 홈 디렉토리에 SourceFile과 동일한 파일명으로 저장

## 다른 서버에서 가져오기
```
# 기본 포트
scp [User]@[Host]:[SourceFile] [TargetDirectory]|[TargetFile]

# 다른 포트
scp -P [Port] [User]@[Host]:[SourceFile] [TargetDirectory]|[TargetFile]

# 디렉토리 복사
scp -r [User]@[Host]:[SourceDirectory] [TargetDirectory]
```

### Port
대상 서버 포트

### User
대상 서버 계정

### Host
대상 서버 호스트

### SourceDirectory, SourceFile
대상 서버에서 가져올 디렉토리나 파일

### TargetDirectory | TargetFile
현재 서버에 저장될 디렉토리나, 파일명

TargetDirectory 생략시 현재 디렉토리에 저장되며,  
TargetFile 생략시 SourceFile과 동일한 파일명으로 저장된다.  
둘 다 입력도 가능하지만, 둘 중 하나는 무조건 필수로 입력해야한다.  
또한 디렉토리 명령어에 존재하는 `r` 은 무조건 소문자여야 한다.