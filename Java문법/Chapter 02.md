# Chapter 02 변수

### 1. 변수

#### 1.1 변수란?

- 단 하나의 값을 저장할 수 있는 메모리 공간

#### 1.2 변수 선언 및 초기화

```
int age = 25; //변수 age를 선언하고 25로 초기화 한다.
```

#####  초기화 : 처음으로 값을 저장하는 것

#### 1.3 변수의 명명규칙 

**식별자 : 프로그래밍에서 사용하는 모든 이름 **

###### -식별자 필수 규칙

```
1.대소문자가 구분되며 길이에 제한이 없다.
  true와 True는 서로 다름
2.예약어 사용x
  true는 사용불가 True는 가능
3.숫자로 시작x
4.특수문자는 '_', '$'만 사용가능
```

###### -권장 규칙

```
1.클래스 이름의 첫 글자는 항상 대문자
  -변수와 메서드의 이름의 첫 글자는 항상 소문자
2.여러 단어로 이루어진 이름은 단어의 첫글자를 대문자(케멀 스타일)
3.상수의 이름은 모두 대문자,여러 단어인 경우'_'로 구분
  ex) MAX_NUMBER
```

### 2. 변수의 타입

```
기본형(primitive type)
	-논리형(boolean), 문자형(char), 정수형(byte,short,int,long),실수형(float,double)
	계산을 위한 실제 값을 저장한다. 모두 8개

참조형(reference type)
	-객체의 주소를 저장한다. 8개의 기본형을 제외한 나머지 타입
```

참조변수 선언법

```
클래스이름 변수이름;
```

Date클래스 타입의 참조변수 today를 선

ex) Date today = new Date();     //Date 객체를 생성해서, 그 주소를 today에 저장

#### 2.1 기본형(primitive type)

|        | 1 byte  | 2 byte | 4 byte  | 8 byte     |
| ------ | ------- | ------ | ------- | ---------- |
| 논리형 | boolean |        |         |            |
| 문자형 |         | char   |         |            |
| 정수형 | byte    | short  | **int** | long       |
| 실수형 |         |        | float   | **double** |

4개의 정수형중에서 int형이 기본자료형이며, 실수형중에서는 double이 기본 자료형이다.

정수형의 가질 수 있는 값의 범위 **-2^(n-1) ~ 2^(n-1)-1**     n은 비트수

| 자료형 | 저장 가능한 값의 범위 | 정밀도     | bit  | byte |
| ------ | --------------------- | ---------- | ---- | ---- |
| float  | 1.4E-45 ~ 3.4E38      | **7자리**  | 32   | 4    |
| double | 4.9E-324 ~ 1.8E308    | **15자리** | 64   | 8    |

#### 2.2 상수와 리터럴(constant & literal)

**-상수 : 값을 한 번 저장하면 다른 값으로 변경 불가한 저장공간**

`final` 을 변수의 타입 앞에 붙여주면됨 

```
final int MAX_SPEED = 10;  //반드시 선언과 동시에 초기화해야 한다. 
```

**-리터럴 : 그 자체로 값을 의미하는 것**

```
final int MAX_VALUE = 100;
          ---------   --- 
             상수      리터럴
```

#### 리터럴의 타입과 접미사

- long타입의 리터럴 접미사 `L`또는 `l`을 붙임
- 접미사가 없으면 int타입의 리터럴
- byte와 short타입의 리터럴은 별도로 존재x, int타입의 리터럴 사용
- float타입의 리터럴 접미사`f`또는`F`를 붙임
- double타입의 리터럴 접미사`D`또는`d`를 붙임, 기본자료형이라 접미사 생략가능
- 8진수 0, 16진수 0x, 2진수0b 접두사 붙임

```
float pi =3.14;    //float타입변수에 double타입의 리터럴을 사용해서 컴파일 에러가 발생
			       //에러를 수정하기 위해서는 3.14f로 수정해야함
```

**리터럴에 소수점이나 E,e또는 f,F,d,D를 포함하고 있으면 실수형 리터럴로 간주**

| 자료형 | 실수형 리터럴 | 다른 형태의 표현 |
| ------ | ------------- | ---------------- |
| double | 10.           | 10.0             |
| double | .10           | 0.10             |
| float  | 10f           | 10.0f            |
| float  | 3.14e3f       | 3140.0f          |
| double | 1e1           | 10.0             |
| double | 1e-3          | 0.001z           |

**기호 p** : p는 2의 제곱을 의미하며, p의 왼쪽에는 16진수를 적고 오른쪽에는 지수를 10진수 정수로 적는다 ex) **0x1p1 = 16^0 * 1 * 2^1** 

#### 타입의 불일치

- 리터럴 값이 변수의 타입의 범위를 넘어서는 경우
- 리터럴의 타입이 변수의 타입보다 저장범위가 넓은 경우

```
다양한 예시

int i =0x123456789;  //에러 int타입의 범위를 넘는 값을 저장
float f = 3.14;		//에러 float타입보다 double타입의 범위가 넓다.

//byte와 short타입의 리터럴은 따로 존재하지 않고 int타입의 리터럴을 사용하는데.단 변수가 저장할 수 있는 범위에 속해야함.
byte b =65;
short s =0x1234;
```

- 문자 리터럴 : char ch = 'A';                char ch = ' '; 빈 문자 불가능
- 문자열 리터럴  : String name = "Apple";      String name = " "; 빈 문자열 가능

```java
class StringEx{
    public static void main(String[] args) {
        String name= "Ja" + "va";
        String str = name +8.0;
        System.out.println(name);
        System.out.println(str);
        System.out.println(7 + " ");
        System.out.println(" " + 7);
        System.out.println(7 + "");
        System.out.println("" + 7);
        System.out.println("" + "");
        System.out.println(7 + 7+ "");
        System.out.println("" + 7 + 7);
    }
}
```

실행결과

<img src="https://github.com/GitmasterLJH/java-til/assets/129172593/01a502bb-905e-413b-8173-19ba0ed2d3a5" width="300px" height="200px">



#### 2.3 printf()

| 지시자 | 설명                                        |
| ------ | ------------------------------------------- |
| %b     | boolean형식으로 출력                        |
| %d     | 10진(decimal)정수 형으로 출력               |
| %o     | 8진(octal)정수의 형식으로 출력              |
| %x,%X  | 16진(hexa-decimal)정수의 형식으로 출력      |
| %f     | 부동 소수점(floating-point)의 형식으로 출력 |
| %e,%E  | 지수(exponent) 표현식의 형식으로 출력       |
| %c     | 문자(character)로 출력                      |
| %s     | 문자열(string)로 출력                       |

