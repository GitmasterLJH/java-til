# Chapter 01 

### 1. 자바

#### 1.1 자바의 특징

1. **운영체제에 독립적이다**. 
2. **객체지향언어이다. **상속,캡슐화,다형성이 잘 적용됨
3. **비교적 배우기 쉽다.**
4. **자동 메모리 관리** garbage collector가 자동적으로 메모리를 관리해주기 떄문에 프로그래머는 메모리를 따로 관리 하지 않아도 됨 -> 프로그래머가 보다 프로그래밍에 집중할 수 있도록 도와준다.
5. **네트워크와 분산처리를 지원한다. **Java API를 통해 비교적 짧은 시간에 네트워크 관련 프로그램을 쉽게 개발 할 수 있도록 지원
6. **멀티쓰레드를 지원한다.** 시스템과는 관계없이 구현가능하며 관련된 라이브러리(Java API)가 제공되므로 구현이 쉽다. 자바 인터프리터가 여러 쓰레드에 대한 스케줄링을 담당
7. **동적 로딩(Dynamic Loading)을 지원한다.** 실행 시에 모든 클래스가 로딩되지 않고 필요한시점에 클래스를 로딩하여 사용함. 또 일부 클래스가 변경되어도 전체 애플리케이션을 다시 컴파일하지 않아도 되며, 비교적 적은 작업만으로 변경사항을 처리 가능

#### 1.2 JVM(Java Virtual Machine) - 자바를 실행하기 위한 가상 컴퓨터

- 자바로 작성된 애플리케이션은 모두 JVM에서만실행됨

| Java 애플리케이션 | Java 애플리케이션 | 일반 애플리케이션 |
| ----------------- | ----------------- | ----------------- |
| Windows용 JVM     | Linux용 JVM       | x                 |
| OS(Windows)       | Os(Linux)         | OS(Windows)       |
| 컴퓨터(하드웨어)  | 컴퓨터(하드웨어)  | 컴퓨터(하드웨어)  |

- 일반 애플리케이션의 코드는 OS만 거치고 하드웨어로 전달되지만 Java는 JVM을 한 번더 거치고 하드웨어에맞게 완전히 컴파일된 상태가 아니고 실행 시에 해석(interpret)되기 떄문에 속도가 느리다. 이러한 단점을 해결하기 위해 바이트 코드를 하드웨어의 기계어로 바로 변환해주는 JIT컴파일러와 향상된 최적화 기술을 적용 

- 일반 애플리케이션은 OS와 바로 맞붙어 있기에 OS에 종속적 -> 다른 OS에서 실행시키기 위해서는 애플리케이션을 그OS에 맞게 변경해야함

- Java 애플리케이션은 JVM하고만 상호작용을 하기에 OS와 하드웨어에 독립적이고 JVM은 OS에 종속적 -> 다른 OS에서도 프로그램의 변경없이 실행 가능, JVM은 해당 OS에서 실행가능한 JVM이 필요함

  > Write once, run anywhere. (한 번 작성하면 어디서든 실행된다.) 



*위의 내용을 쉽게 이해하기 위해 예를 들면 C언어로 작성된 program.c가 있다고 하면 이것을 윈도우 컴파일러를 사용해서 컴파일 하면 program.exe가 만들어진다. 윈도우 컴파일러로 컴파일되었기에 윈도우에서만 실행가능한 파일이다. 따라서 리눅스, 맥OS등 다른 운영체제에서는 실행할 수 없다. 하지만 java언어로 작성된 program.java를 컴파일 하면 program.class파일이 생성된다. 이렇게 생성된 바이트코드(.class)는 각자의 플랫폼에 설치되어 있는 자바 가상 머신(JVM)이 운영체제에 맞는 실행 파일로 바꿔준다. 즉 하나의 바이트 코드로 JVM이 설치되어 있는 모든 플랫폼에서 동작 가능하다.*

### 2. 자바개발환경 구축하기

#### 2.1 자바 개발도구(JDK)설치

JDK를 설치하면 JVM과 Java API외에 자바를 개발하는데 필요한 프로그램들이 설치됨

JDK-자바개발도구(Java Development Kit) = JRE-자바실행환경(Java Runtime Environment) + 개발에 필요한 실행파일(javac.exe등)

JRE = JVM + 클래스라이브러리(Java API)

<img src="https://github.com/GitmasterLJH/java-til/assets/129172593/bebbea43-0b73-4f6f-8791-48bf9fcfa183" width="400px" height="200">

JDK의 bin디렉토리에 있는 주요 실행파일

- javac.exe  자바 컴파일러, 자바소스코드를 바이트코드로 컴파일한다.
- java.exe 자바 인터프리터, 컴파일러가 생성한 바이트코드를 해석하고 실행한다.
- javap.exe 역어셈블러, 컴파일된 클래스파일을 원래의 소스코드로 변환한다. .class-> .java
- javadoc.exe 자동문서생성기, 소스파일에 있는 주석을 이용하여 Java API문서와 같은 형식의 문서를 자동으로 생성한다.
- jar.exe 압축프로그램, 클래스파일과 프로그램의 실행에 관련된 파일을 하나의 jar파일로 압축하거나 해제한다.

#### 2.2 Java API문서

- 클래스 라이브러리의 모든 클래스에 대한 설명이 자세하게 나와 있다.



### 3.자바로 프로그램 작성하기

#### 3.1 Hello.java

화면에 Hello, world. 출력과정

~~~
               javac.exe                     java.exe
Hello.java작성 ----------> Hello.class 생성  ----------> "Hello,world." 출력
                 컴파일                         실행
~~~

내부적인 진행순서

```
1.프로그램의 실행에 필요한 클래스(*.class파일)를 로드한다.
2.클래스파일을 검사한다.(파일형식,악성코드 체크)
3.지정된 클래스(Hello)에서 main(String[] args)를 호출한다.
```

<img src="https://github.com/GitmasterLJH/java-til/assets/129172593/06ba13c4-d760-4893-ab94-eb0650da6262" width="400px" height="200">

```java
class 클래스이름{
    public static void main(Stringp[] args) //main 메서드의 선언부 : 프로그램을 실행할 때 java.exe에 의해 호출될 수있도록 미리 약속된 부분
    {
        //실행될 문장적기
    }
}
```

- java 애플리케이션에는 main메서드를 포함한 클래스가 반드시 하나 있어야 한다.
- main메서드의 호출로 시작해서 main메서드의 첫 문장부터 마지막 문장까지 수행을 마치면 종료됨

#### 3.2 소스파일 이름

**올바른 작성 예**

| Hello2.java                                           | Hello2.java or Hello3.java                                   |
| ----------------------------------------------------- | ------------------------------------------------------------ |
| public class Hello2 {}<br>            class Hello3 {} | class Hello3 {}<br>class Hello2 {}<br> //클래스파일(.class)은 클래스마다 하나씩 만들어지므로<br>컴파일 하면 Hello2.class와 Hello3.class 두개의 클래스파일이 생성됨 |

**잘못된 작성 예**

| Hello2.java                                                  | Hello3.java                                                  | hello2.java                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| public class Hello2 {}<br>public class Hello3 {}             | public class Hello3 {}<br>            class Hello3 {}        | public class Hello2 {}<br>            class Hello3 {}        |
| 하나의 소스파일에 둘 이상의 public class가 존재하면 안된다. 각클래스를 별도의 소스파일에 나눠서 저장하던가 아니면 둘 중의 한 클래스에 public을 붙이지 않아야 한다. | 소스파일의 이름이 public class의 이름과 일치하지 않기에 Hello2.java로 변경해야함 | 대소문자 까지 일치해야하므로 소스파일의 이름에서 h를 H로 바꿔야 한다. |

#### 3.3 자주 발생하는 에러와 해결방법

1. **cannot find symbol 또는 cannot resolve symbol** 

   선언되지 않은 변수나 메서드를 사용하거나 이름을 잘못 사용한 경우

2. **';'expected**

   ;이 없다는 뜻

3. **Exception in thread "main" java.lang.NoSuchMethodError: main**

   main메서드가 클래스에 정의되어 있지 않거나 main메서드의 선언부에 오타가 있는 경우

4. **Exception in thread "main" java.lang.NoClassDefFoundError: Hello**

   Hello라는 클래스를 찾을 수 없다는 뜻, 클래스 Hello의 철자를 확인하고 이상이 없으면 클래스파일이 생성되었는지 확인

   클래스파일도 존재하는데 오류가 발생한다면 클래스패스의 설정이 바르게 되어있는지 확인

5. **ilegal start of expression**

   앞부분이 문법에 맞지 않는다는 뜻으로 괄호를 열고 닫지 않거나 수식이나 if문,for문등에 문법적 오류 또는 

   public ,static과 같은 키워드를 잘못 사용한 경우에도 발생

6. **class, interface or enum expected**

   class or inteface or enum이 없다는 뜻이지만 보통 괄호 개수가 일치하지 않는 경우에 발생

   <b>에러 발생 해결 방법</b>

   ```
   1.해당 부분의 코드를 살펴본다.
     이상이 없으면 해당 코드의 주위도 함께 살표본다.
   2.그래도 이상이 없으면 에러 메시지는 잊어버리고 기본적인 부분을 재확인한다.
   3.의심이 가는 부분을 주석처리하거나 따로 뗴어내서 테스트 한다.
   ```

#### 3.4 주석(comment)

- 범위 주석 : /*   */
- 한 줄 주석 //

**큰따옴표(")안에 주석이 있을 때는 주석이 아닌 문자열로 인식됨**

- *ex) System.out.println("Hello, /* 주석이 아니에요 */ world.");**

