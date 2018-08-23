# my-java-practice-project

### 1. Shipping
> 각 운송 수단에 대한 계획된 운송에 필요한 연료 관련 보고서를 report 하는 프로그램, 클라이언트 역할을 하는 ShippingMain과 FuelNeedsReport 클래스, 서버 역할을 하는 도메인인 Company 클래스, Vehicle 추상 클래스(서비스), Vehicle을 상속하는 Truck과 RiverBarge 클래스. 주석 처리 완료
- polymorphism, template method design pattern

### 2. SimpleCollectionSample
> 자바 Collection(List, Set)과 Map 계열 자료구조 사용 샘플 프로젝트. 주석 처리 완료

### 3. BasicRemoteMethodInvocationSample
> 톰캣을 사용한 간단한 RMI 샘플 프로젝트. Class.forName() 메소드, newInstance() 메소드 등의 사용

### 4. ThredSample
> Thread의 동기화 및 락 메카니즘 등 여러가지 스레드 관련 사용 샘플 프로젝트. 주석 처리 완료

### 5. ImmutableStringTest
> Immutable 객체 String test

### 6. ObjIdentityAndEquality
> Object equality와 identity 관계. hash 기반 collection에서 해당 개념 중요!

### 7. MyAlgorithmSolve
> 알고리즘 연습 프로젝트

### 8. CommonUtilForProblemSolve
> 문제해결을 위한 일반적 도구
#### 1) 정규식 관련 샘플 코드
- case : replaceAll 메소드
#### 2) 자바 sorting 관련 pratice
- sorting 관련 자바 API
- sorting 알고리즘

### 9. JavaInheritanceTest
> 인터페이스 상속, 구현시 생길 수 있는 여러가지 경우 test

### 10. RemoveCommentInQueryTest
> 2가지 방법의 쿼리 주석 제거 속도 test
- 정규식 사용
- indexOf 메소드 character 제어

### 11. StringBuilderVsBufferTest
> String 관련 연산 및 클래스 속도 비교 test
- String concat(+)
- StringBuilder
- StringBuffer

### 12. ClassForNameJDBCTest
> Class 클래스의 forName 메소드 등 test. JDBC 드라이버 로딩 테스트
- java.sql 패키지 JDBC SPI 제공
  - Connection 인터페이스
  - DriverManager 클래스
- Vendor가 구현해야 하는 부분
  - Driver 클래스
  - Connection 구현체

### 13. AES256Test
> AES256 알고리즘 암복호화 test
- AES256 지원 JCE 라이브러리 포함 (기본 Java는 AES128까지 지원)
