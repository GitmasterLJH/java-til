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



### 2. String배열

----

#### 2.1 String 배열의 선언과 생성

```java
String[] name = new String[3];  // 3개의 문자열을 담을 수 있는 배열 생성
								// 각 요소의 값은 null로 초기화 된다
```

```
String[] name = new String[3];                 String[] name = new String[3];
name[0] = new String("Kim");	 생략 가능	  	name[0] = "Kim";
name[1] = new String("Park");	---------->    name[1] = "Park";
name[2] = new String("Yi");					   name[2] = "Yi";
```

****

**참조형 배열 : 배열에 실제 객체가 아닌 객체의 주소가 저장되어 있다.**

<img src="https://github.com/GitmasterLJH/java-til/assets/129172593/aacc695c-bd1c-4296-ad1c-0666255a6212" width="400px"  height="150px">

#### 2.2 char 배열과 String클래스

```
String클래스는 char배열에 기능(메서드)을 추가한 것이다.
```

**String클래스와  char배열 차이점**

- String객체(문자열)는 읽을 수만 있을 뿐 내용을 변경할 수 없다.

  ```java
  String str = "Java";
  str = str + "8";		  // "Java8"이라는 새로운 문자열이 str에 저장된다.
  System.out.println(str);  // "Java8"
  ```



**String클래스의 주요 메서드**

- charAt 메서드

  - 문자열에서 지정된 index에 있는 한 문자를 가저온다.

    ```java
    String str = "ABCDE";
    char ch = str.charAt(3);  // 문자열 str의 4번째 문자 'D'를 ch에 저장
    ```

- substring()

  - 문자열의 일부를 뽑아낼 수 있다.

    ```java
    String str = "012345";
    String tmp = str.substring(1,4)  // str에서 index범위 1~3의 문자들을 반환
    System.out.println(tmp);   		 // "123"이 출력된다.
    ```

- equals()

  - 문자열의 내용이 같은지 다른지 확인

    ```java
    String str = "abc";
    
    if(str.equals("abc")){   // str와 "abc"가 내용이 같은지 확인한다.
    ...
    }
    ```

  - 대소문자를 구분하지 않고 비교하려면 `equalsIgnoreCase()`를 사용



**char배열과 String클래스의 변환**

```java
char[] chArr = { 'A', 'B', 'C'};
String str = new String(chArr);   // char배열 -> String
char[] tmp = str.toCharArray();   // String -> char배열
```

#### 2.4 커맨드 라인을 통해 입력받기

- 커맨드 라인에 입력된 매개변수는 공백문자로 구분
- 숫자를 입력해도 문자열로 처리됨 
  - 문자열 "123"을 숫자로 바꾸려면 다음과 같이 한다`int num = Integer.parseInt("123");`
- 커맨드 라인에 입력된 매개변수가 없으면 JVM이 null 대신 크기가 0인 배열을 생성해서 args에 전달하도록 구현되어 있다.
  - null이면 배열 args를 사용하는 모든 코드에서 오류가 남

### 3. 다차원 배열

----

#### 3.1 2차원 배열의 초기화

```java
// 4행 3열 score 
int[][] score = {
                {100,100,100},
                {20,20,20},
                {30,30,30},
                {40,40,40}
        };
```

**for문을 이용하여 2차원 배열 초기화 **

```java
for (int i=0; i< score.length;i++){
	for(int j=0; j<score[i].length;j++){
		score[i][j]= 10;
	}
}
```

**향상된 for문 2차원 배열 값읽기**

```java
for(int[] tmp : score) {
            for (int i : tmp) {
                System.out.print(i+",");
            }
        }
```

#### 3.3 가변 배열

```java
// 행마다 다른 길이 배열 생성 가능
int [][] score = new int[3][];

score[0] = new int[4];    
score[1] = new int[3];    
score[2] = new int[2];
```

