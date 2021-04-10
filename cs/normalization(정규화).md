# [SQL] 정규화



#### 정규화란?

- 데이터 중복을 제거하여 정해진 규칙에 의거해 규격화 하는 작업
- 실무에서는 3단계까지를 많이 수행
- 정규화를 거친 테이블을 각각의 테이블이 하나의 기능만 수행하게 되어, 향후 업무가 증가하거나 변화해도 최소한의 수정만으로 처리가능

##### 예제

![image-20210410140645369](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FVeopz%2Fbtqu0vcdsqr%2F61CRg6BUG5ksp69Dh5JEAk%2Fimg.png)



#### 1차 정규화

- **같은 성격과 내용의 컬럼이 연속적으로 나타나는 컬럼**이 존재할 때, 해당 칼럼을 제거하고 기본테이블의 PK를 추가해 새로운 테이블을 생성하고, 기존의 테이블과 **1:N 관계를 형성**하는 것이다.

![image-20210410140658986](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbZR0F5%2FbtquZyHwHnd%2FqYurQCMyEx9tTcrs728YS1%2Fimg.png)



#### 2차 정규화

- PK가 여러 키로 구성된 **복합키(Composite Primary Key)**로 구성된 경우, 복합키 전체에 의존 하지 않고 복합키의 일부분에만 종속되는 속성들이 존재할 경우 (즉, **부분적 함수 종속 관계**) 이를 분리하는 것이다.

![image-20210410141157934](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F2xnh4%2Fbtqu04rL5pC%2FGoBBXYqpKIwP7ZorgkgKe0%2Fimg.png)



#### 3차 정규화

- 실제로 기본키가 아닌 다른 일반 컬럼에 의존하는 컬럼들이 있을 수 있다. 이를 이전적 함수 종속 관계 라고 한다. 제 3 정규화는 PK에 의존하지 않고 일반컬럼에 의존하는 컬럼들을 분리

  ![image-20210410141322693](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FAylnc%2Fbtqu0VhbpSm%2FQdFyVkdjfKpO5UHmUGQHyK%2Fimg.png)



###### ref

[[SQL] 1,2,3차 정규화](https://dog-foot-story.tistory.com/61)