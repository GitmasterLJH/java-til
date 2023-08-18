## Chapter 05

### 1. 배열(array)

---

#### 1.1 배열이란?

- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것

#### 1.2 배열의 선언과 생성

```java
타입 [] 변수이름;   // 배열의 선언(배열을 다루기 위한 참조변수 선언)
변수이름 = new 타입[길이];   // 배열의 생성(실제 저장공간을 생성)
```

ex)

​	`int [] score;`   int타입을 다루기 위한 참조 변수 score선언

​	`score = new int[5];` int타입의 값 5개를 저장할 수 있는 배열

**배열의 길이**

- 한번 선언되고 나면 길이를 변경할 수 없다.

- int범위의 양의 정수이어야 한다(0도 포함)
- `배열이름.length`  :  배열의 길이를 알수있음



#### 1.3 배열의 초기화

```java
int [] score = new int[]{50, 60, 70, 80, 90}; // 배열의 생성과 초기화
int [] score = {50, 60, 70, 80, 90};  // new int[] 생략가능

int [] score;
score = new int[]{50,60,70,80,90};  // OK
score = {50, 60, 70, 80, 90};     // 에러 new int[]를 생략할 수 없음
```



**배열의 출력**

- `Arrays.toString(배열)` : '[첫번째 요소, 두번쨰 요소...]'와 같은 형식의 문자열로 만들어서 반환

  - 사용하기 위해서 `import java.util.*; `사용

- char 배열은 예외적으로 println메서드로 출력하면 각 요소가 구분자 없이 그대로 출력됨

  ```java
  char[] chArr = {'a', 'b', 'c', 'd'};;
  System.out.println(chArr);  // abcd가 출력됨
  ```

#### 1.4 배열의 복사

기존배열에서 더 큰 저장공간이 필요할때  새로 만들고 내용을 복사함

- for문을 이용하는 방법

  ```java
  int [] arr = new int[5];
  
  int [] tmp = new int[arr.length*2];
  
  for(int i=0;i<arr.length;i++)
  	tmp[i]=arr[i];
  
  arr = tmp;  // 참조변수 arr이 새로운 배열을 가리키게 한다.
  ```

- System.arraycopy()를 이용하는 방법
  - `System.arraycopy(num, 0, newNum, 0, num.length);` 
        -  num[0] 에서 newNum[0]으로 num.length개의 데이터를 복사

