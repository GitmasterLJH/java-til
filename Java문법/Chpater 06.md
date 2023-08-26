## Chpater 06 객체지향 프로그래밍 I

### 1. 객체지향언어

---

#### 1.1 객체지향언어 특징

1. 코드의 재사용성이 높다.
2. 코드의 관리가 용이하다.
3. 신뢰성이 높은 프로그래밍을 가능하게 한다.

**3가지 키워드**

- 재사용성
- 유지보수
- 중복된 코드의 제거



### 2. 클래스와 객체

---

#### 2.1 클래스와 객체 정의와 용도

- 클래스(객체의 틀, 설계도)
  - 정의 : 객체를 정의해 놓은 것
  - 용도 : 객체를 생성하는데 사용

- 객체
  - 정의 : 실제로 존재하는 것. 사물 또는 개념
  - 용도 : 객체가 가지고 있는 기능과 속성에 따라 다름
  - 객체 종류
    - 유형의 객체 :  책상, 의자, 자동차, TV와 같은 사물
    - 무형의 객체 : 수학공식, 프로그램 에러와 같은 논리와 개념

**먼저 클래스를 작성한 다음, 클래스로부터 객체를 생성하여 사용**

| 클래스      | 객체   |
| ----------- | ------ |
| 제품 설계도 | 제품   |
| TV 설계도   | TV     |
| 붕어빵 기계 | 붕어빵 |

**Java API**

- JDK에서는 유용한 클래스(Java API)를 기본적으로 제공, 이 클래스들을 이용해서 원하는 기능의 프로그램을 쉽게 작성 가능



#### 2.2 객체와 인스턴스

- 인스턴스화 : 클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화라고 한다.
- 인스턴스 : 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라고 한다.

```
					 	   인스턴스화
				클래스  ----------------> 인스턴스(객체)
				
```

**예시**

- **'책상은 인스턴스다'** 라고 하기 보다는 **'책상은 객체다'**라는 쪽이 더 자연스럽다.
- **'책상은 책상 클래스의 객체이다.'** 라고 하기 보다는 **'책상은 책상 클래스의 인스턴스다.'** 라고 하는 것이 더 자연스럽다.



#### 2.3 객체의 구성요소 - 속성과 기능

- 객체 : 속성과 기능의 집합

- 객체가 가지고 있는 속성과 기능을 그 **객체의 멤버**라 한다.

  ```
  속성(property) 멤버변수(member variable), 특성(attribute), 필드(field), 상태(state)
  기능(function) 메서드(method), 함수(function), 행위(behavior)
  ```

TV예시

<img src="https://github.com/GitmasterLJH/java-til/assets/129172593/eeb3d6ca-e248-441b-b0d7-b4b73abde766" width="500px" height="200px">

#### 2.4 인스턴스의 생성과 사용

예제

```java
class Tv {
    // Tv의 속성(멤버변수)
    String color;       // 색상
    boolean power;      // 전원 상태(on/off)
    int channel;        // 채널

    // Tv의 기능(메서드)
    void power() { power = !power;} // Tv를 켜거나 끄는 기능을 하는 메서드
    void channelUp(){ ++channel;}   // Tv의 채널을 높이는 기능을 하는 메서드
    void channelDown(){ --channel;} // Tv의 채널을 낮추는 기능을 하는 메서드

}
class TvTest{
    public static void main(String[] args) {
        Tv t;            // Tv인스턴스를 참조하기 위한 변수 t를 선언
        t = new Tv();    // Tv인스턴스를 생성한 후, 생성된 Tv인스턴스의 주소를 t에 저장
        t.channel = 7;   // Tv인스턴스의 멤버변수 channel의 값을 7로 한다.
        t.channelDown(); // Tv인스턴스의 메서드 channelDown()을 호출한다.
        System.out.println("현재 채널은 "+ t.channel+"입니다.");
    }
}
```

**설명**

1. Tv t;
   - Tv클래스 타입의 참조변수 t를 선언한다. 메모리에 참조변수 t를 위한 공간이 마련된다. 아직 인스턴스가 생성되지 않았으므로 참조변수로 아무것도 할 수 없다.
2. t= new Tv()
   - 연산자 new에 의해 Tv클래스의 인스턴스가 메모리의 빈 공간에 생성된다. 멤버변수는 각 자료형에 해당하는 기본값으로 초기화 된다.
   - 참조형은 null, boolean은 false, int형은  0
   - 그다음 = 에 의해서 생성된 객체의 주소값이 참조변수 t에 저장된다. 이제 참조변수 t를 통해 Tv인스턴스에 접근할 수 있다.

```
인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야한다.
```



#### 2.5 객체 배열

- 배열안에 객체의 주소가 저장됨
- 같은 타입의 객체만 저장 가능

```java
Tv[] tvArr = new Tv[3];  // 길이가 3인 Tv타입의 참조변수 배열 생성

// 객체를 생성해서 배열의 각 요소에 저장
tvArr[0] = new Tv();
tvArr[1] = new Tv();
tvArr[2] = new Tv();

// 초기화 블럭 이용
Tv[] tvArr = { new Tv(), new Tv(), new Tv() };

// for문 이용
Tv[] tvArr = new Tv[100];

for(int i=0; i<tvArr.length;i++){
    tvArr[i] = new Tv();
}
```

#### 2.6 클래스의 또 다른 정의

**클래스**

- 객체지향이론 관점
  - 객체를 생성하기 위한 틀이며 속성과 기능으로 정의되어있다.
- 프로그래밍적인 관점
  - 서로 관련된 변수들을 정의하고 이들에 대한 작업을 수행하는 함수들을 함께 정의한 것

ex) String : C언어에서는 문자열을 문자의 배열로 다루지만 자바에서는 String이라는 클래스로 문자열을 다룬다.

 이유 : 문자열을 클래스로 정의한 이유는 문자열과 문자열을 다루는데 필요한 함수들을 함께 묶기 위해서 이렇게 하면 변수와 함수가 서로 유기적으로 연결되어 작업이 간단하고 명료해진다.



### 3. 변수와 메서드

---

#### 3.1 선언위치에 따른 변수의 종류

```java
class Variables
{
	int iv;		   // 인스턴스 변수
	static int cv  //  클래스 변수(static변수,공유변수)    
	
	void method()
	{
		int lv = 0;  // 지역변수       
	}
}
```

**1. 인스턴스변수**

- 클래스 영역에 선언된다.
- 클래스의 인스턴스를 생성할 때 만들어진다.
- 독립적인 저장공간을 가지므로 서로 다른 값을 가질 수 있다.
  - 인스턴스마다 고유한 상태를 유지해야하는 속성의 경우, 인스턴스변수로 선언

**2. 클래스 변수**

- 클래스 영역에 선언된다.
- 인스턴스변수 앞에 static을 붙이기만 하면 된다.
- 모든 인스턴스가 공통된 저장공간(변수)를 공유하게 된다.
  - 한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우, 클래스변수로 선언
- 인스턴스를 생성하지 않고도 언제라도 바로 사용 가능
- 클래스가 메모리에 로딩될 때 생성되어 프로그램이 종료될 때 까지 유지된다.
- public을 앞에 붙이면 같은 프로그램 내에서 어디서나 접근할 수 있는 전역변수의 성격을 가짐
- c1.width가 아니라 Card.width와 같이 인스턴스 변수로 오해하지 않기위해 **"클래스이름.클래스변수"**의 형태로 하는 것이 좋다. 

**3. 지역변수**

- 메서드 내에 선언되어 메서드 내에서만 사용 가능
- 메서드가 종료되면 소멸되어 사용 불가
- for,while의 블럭 내에 선언된 지역변수는, 선언된 블럭{} 내에서만 사용가능, 블럭을 벗어나면 사용불가 



|참고| 클래스 영역에 선언된 변수를 멤버변수라고 한다. 멤버변수 = 인스턴스 변수 + static 변수

#### 3.2 클래스변수와 인스턴스변수

게임 카드 예시

- 각 Card인스턴스는 자신만의 무늬,숫자를 유지하고 있어야 하므로 이들을 **인스턴스변수로 선언**

- 각 카드의 폭과 높이는 모든 인스턴스가 공통적으로 같은 값을 유지해야하므로 **클래스변수로  선언**
- 카드의 폭을 변경해야할 필요가 있는경우 한카드의 width값만 변경해도 모든 카드의 값이 변경됨

<img src="https://github.com/GitmasterLJH/java-til/assets/129172593/ade81d68-81df-40ad-940a-9da326d68cdb" width="500px" height="200px">

#### 3.3 메서드

```
반환타입 메서드이름 (타입 변수명, 타입변수명, ...)  ----> 선언부
{                                              	 | 
		// 메서드 호출시 수행될 코드			      |--->	  구현부		
}											     |   
```

```java
int add(int a, int b)       ----> 선언부
{												|
	int result = a + b;							|---> 구현부
	return result;								|
}												|	
    
    
int add(int x, int y) // OK
int add(int x, y)     // 에러. 매개변수 y의 타입이 없다.
```

**return문**

- return 반환값;에서 반환값은 **반환타입과 일치하거나 적어도 자동 형변환이 가능한 것**이어야한다.

**지역변수**

```java
int add(int x, int y){
	int result = x + y;
	return result;
}

int multiply(int x, int y){
	int result = x * y;
	return result;
}
// 위에 정의된 메서드 add, multiply에 각기 선언된 변수 x,y,result는 이름만 같을 뿐 서로 다른 변수이다. 
```

#### 3.5 메서드의 호출

**-같은 클래스 내의 메서드끼리는 참조변수를 사용하지 않고도 서로 호출이 가능**

**-static메서드는 같은 클래스 내의 인스턴스 메서드를 호출할 수 없다.**

```java
메서드이름(값1,값2....); // 메서드 호출하는 방법

print99danAll();	   // void print99danAll()을 호출
int result = add(3,5)  // int add(int x, int y)를 호출하고, 결과를 result에 저장
```

**인자(argument), 매개변수(parameter)**

- 메서드를 호출할때 괄호()안에 지정해준 값들을 인자 또는 인수라고 함
- 인자는 메서드가 호출되면서 매개변수에 대입되므로, 인자의 타입은 **매개변수의 타입과 일치하거나 자동 형변환**이 가능해야함.

#### 3.6 return문

```java
int max(int a, int b){
	if(a>b)
		return a;  // 조건식이 참일 때만 실행되기에 return문이 없다는 에러가 발생
}
// 이런 경우 다름과 같이 else블럭에 return문을 추가 해야함

int max(int a, int b){
	if(a>b)
		return a;
    else
        return b;
}
```

**매개변수의 유효성 검사**

- 호출하는 쪽에서 알아서 적절한 값을 넘겨주겠지 라는 생각을 절대로 가져서는 안된다

예제(0으로 나누는 것은 금지되어 있기에 계산 전에 y의 값이 0인지 확인)

```
float divide(int x, int y){
	//작업을 하기전에 나누는 수(y)가 0인지 확인한다.
	if(y==0){
		System.out.println("0으로 나눌 수 없습니다.");
		return 0; // 매개변수가 유효하지 않으므로 메서드를 종료한다.
	}
	return x/(float)y;
}
```

#### 3.7 JVM의 메모리 구조

1.메서드 영역(method area)

- 프로그램 실행 중 어떤 클래스가 사용되면, JVM은 해당 클래스의 클래스파일(*.class)을 읽어서 분석하여 클래스에 대한 정보(클래스 데이터)를 이곳에 저장한다. 이 때, 그 클래스의 클래스변수도 이 영역에 함께 생성된다.

2.힙(heap)

- 인스턴스가 생성되는 공간, 프로그램 실행 중에 생성되는 인스턴스는 모두 이곳에 생성된다.
- 즉, 인스턴스변수들이 생성되는 공간

3.호출스택(call stack 또는 execution stack)

- 메서드의 작업에 필요한 메모리 공간을 제공
- 메서드가 호출되면, 호출스택에 호출된 메서드를 위한 메모리가 할당되며, 이 메모리는 메서드가 작업을 수행하는 동안 지역변수들과 연산의 중간결과 등을 저장하는데 사용된다. 그리고 메서드가 작업을 마치면 할당되었던 메모리공간은 반환되어 지워진다.

#### 3.8 기본형 매개변수와 참조형 매개변수

```
기본형 매개변수	:	변수의 값을 읽기만 할 수 있다.(read only)
참조형 매개변수	:	변수의 값을 읽고 변경할 수 있다.(read & write)   값이 저장된 곳의 주소를 알 수 있기 때문에
```

#### 3.9 참조형 반환타입

```java
public class ReferenceReturnEx {
    public static void main(String[] args) {	
        Data d = new Data();		// 객체 생성
        d.x = 10;					// d의 인스턴스 변수 x 에 10저장

        Data d2 = copy(d);				// tmp의 주소값을 참조변수 d2에 저장
        System.out.println("d.x ="+d.x);
        System.out.println("d2.x="+d2.x);

    }

    static Data copy(Data d){
        Data tmp = new Data();		// 새로운 객체 생성
        tmp.x = d.x; 				// d.x에 저장된 값을 tmp.x에 복사
        return tmp;					// tmp의 주소값을 반환 
    }
}
```

#### 3.10 재귀호출(recurive call)

-장점 : 코드가 간결해진다.

-단점 : 매개변수 복사와 종료 후 복귀할 주소저장 등이 추가로 필요하기 때문에 수행시간이 오래 걸린다.

- 재귀호출은 대부분 반복문으로 작성가능 

```
// 재귀호출 팩토리얼
int factorial(int n){
	if(n==1) return 1;
	
	return n * factorial(n-1);
}

// 반복 팩토리얼
int facotrial(int n){
	int result = 1;
	while(n!=0)
		result *= n--;
	return result;
}
```

- 무한호출의 경우

  ```java
  // main 메서드의 무한 호출
  
  public class MainTest {
      public static void main(String[] args) {
          main(null);
      }
  }
  /* main메서드가 종료되지 않고 호출스택에 계속해서 쌓이게 되어 결국 호출스택의 메모리 한계에 넘게 되고
   StackOverflowError가 발생하여 프로그램은 비정상적으로 종료됨
   */
  ```

#### 3.11 클래스 메서드(static메서드)와 인스턴스 메서드

**인스턴스 메서드**

- 인스턴스 변수와 관련된 작업을 하는, 즉 메서드의 작업을 수행하는데 인스턴스 변수를 필요로 하는 메서드이다,
- 인스턴스를 생성해야만 호출가능

**클래스 메서드(static)**

-  인스턴스와 관계없는(인스턴스 변수나 인스턴스 메서드를 사용하지 않는)메서드

### 규칙

1. 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static을 붙인다.



2. 클래스변수(static변수)는 인스턴스를 생성하지 않아도 사용할 수 있다.
   -  static이 붙은 변수(클래스변수)는 클래스가 메모리에 올라갈 때 이미 자동적으로 생성되기 떄문에



3. 클래스 메서드(static메서드)는 인스턴스 변수를 사용할 수 없다.

   - 클래스 메서드는 인스턴스 변수 사용을 금한다.
     - 인스턴스 생성 없이 호출가능하므로 클래스 메서드가 호출되었을 때 인스턴스가 존재하지 않을 수도 있다.  

   - 인스턴스 변수,메서드에서는 static이 붙은 멤버들을 사용가능
     - 인스턴스 변수가 존재한다는 것은 static변수가 이미 메모리에 존재한다는 것을 의미하기 때문에



4. 작성한 메서드 중에서 인스턴스 변수나, 인스턴스 메서드를 사용하지 않는 메서드에 static을 붙이는 것을 고려한다.
   - 인스턴스 변수를 필요로 하지 않는다면 static을 붙이자
     - 메서드 호출시간이 짧아지므로 성능이 향상됨
     - static을 안 붙인 메서드는 실행 시 호출되어야할 메서드를 찾는 과정이 추가적으로 필요하기 떄문에 시간이 더 걸린다.

예제

```java
public class MyMathTest2 {
    public static void main(String[] args) {
        // 클래스메서드의 호출. 인스턴스 생성없이 호출가능
        System.out.println(MyMath2.add(200L,100L));
        System.out.println(MyMath2.substract(200L,100L));
        System.out.println(MyMath2.multiply(200L,100L));
        System.out.println(MyMath2.divide(200.0,100.0));
        
        MyMath2 mm = new MyMath2();     // 인스턴스를 생성
        
        mm.a = 200L;
        mm.b = 100L;
        // 인스턴스메서드는 객체생성 후에만 호출이 가능하다
        System.out.println(mm.add());
        System.out.println(mm.substract());
        System.out.println(mm.multiply());
        System.out.println(mm.divide());
    }
}

class MyMath2{
    long a,b;  // 인스턴스 변수 a, b
    // 인스턴스변수 a,b만을 이용해서 작업하므로 매개변수가 필요없다.
    long add(){return a +b;}
    long substract(){return a-b;}
    long multiply(){return a*b;}
    double divide(){return a/b;}

    // 인스턴스변수와 관계없이 매개변수로만으로 작업이 가능하다.
    static long add(long a, long b){return a +b;}
    static long substract(long a, long b){return a-b;}
    static long multiply(long a , long b){return a*b;}
    static double divide(double a, double b){return a/b;}
}
```

#### 3.12 클래스 멤버와 인승턴스 멤버간의 참조와 호출

```
같은 클래스에 속한 멤버들 간에는 인스턴스를 생성하지 않고도 서로 참조 또는 호출이 가능하다.
단, 클래스멤버가 인스턴스 멤버를 참조 또는 호출하고자 하는 경우에는 인스턴스를 생성해야한다.
```

예제

```java
public class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
    // static int cv2 = iv2;  // 에러. 클래변수는 인스턴스 변수를 사용할 수 없음.
    static int cv2 = new MemberCall().iv2;

    static void staticMethod1(){
        System.out.println(cv);
       // System.out.println(iv); 에러. 클래스메서드 인스턴스 변수 사용불가
        MemberCall c = new MemberCall();
        System.out.println(c.iv);       // 객체를 생성한 후에야 인스턴스변수 참조가능
    }
    void instatnceMethod1(){
        System.out.println(cv);
        System.out.println(iv);     // 인스턴스 메서드는 인스턴스 변수 바로 사용 가능
    }
    static void staticMethod2(){
        staticMethod1();
        // insatnceMethod1();  에러. 클래스메서드에서는 인스턴스메서드를 호출할 수 없음.
        MemberCall c = new MemberCall();
        c.instatnceMethod1();  // 인스턴스를 생성한 후에야 호출할 수 있음.
    }
    void instanceMethod2(){     // 인스턴스 메서드에서는 모두 인스턴스 생성없이 바로 호출 가능
        staticMethod1();
        instatnceMethod1();
    } 
}
```

알아두면 좋은 정보

```java
// 다음의 두줄을 아래 한 줄로 표현 가능
MemberCall c = new MemberCall();
int result = c.instanceMethod1();

int result = new MemberCall().instanceMethod1();

// 대신 참조변수를 선언하지 않았기 때문에 생성된 MemberCall인스턴스는 더 이상 사용할 수 없다.
```

### 4. 오버로딩(overloading)

---

#### 4.1 오버로딩이란?

- 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것

- 조건

  - **메서드 이름이 같아야 한다.**
  2. **매개변수의 개수 또는 타입이 달라야 한다.**

  - 반환 타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다.

1.매개변수의 이름만 다른 경우

```java
// 매개변수의 이름만 다를뿐 타입이 같기 떄문에 오버로딩 성립x

int add(int a, int b){return a+b;}
int add(int x, int y){return x+y;}

// 수학에서 f(x)=x+1 과 f(a) = a+1이 같은 표현인 것과 같다.
```

2.리턴타입만 다른 경우

```java
// 이것도 역시 매개변수의 타입과 개수가 일치하기 때문에 
// add(3,3)을 호출하였을때 어떤 메서드가 호출된 것인지 결정할 수 없기 떄문에 오버로딩 x

int add(int a, int b){return a+b;}
long add(int a, int b){return (long)(a+b);}
```

3.순서가 다른 경우

```java
// 호출 시 매개변수의 값에 의해 호출될 메서드가 구분될 수 있으므로 오버로딩 O

long add(int a, long b){return a+b;}     // add(3,3L) 호출 시
long add(long a, int b){return a+b;}	 // add(3L,3) 호출 시

// 만약 add(3,3)과 같이 호출 한다면 두 메서드중 어느 메서드가 호출된 것인지 알 수 없기 떄문에 컴파일 에러
```

#### 4.2 오버로딩의 장점

메서드도 변수처럼 단지 이름만으로 구별된다면, 한 클래스내의 모든 메서드들은 이름이 달라저야한다

--> 그렇다면 10가지의 println메서드들은 각기 다른 이름을 가져야 한다.

 예를 들면, 아래와 같은 방식으로 변경 되어야 할것이다.

```java
void println()
void printlnBoolean(boolean x)
void printlnChar(char x)
void printlnDouble(double x)
void printlnString(String x)
```

근본적으로 같은 기능을 하는 메서드들이지만 서로 다른 이름을 가져야 하기 때문에 작성자는 이름 짓기 어렵고 사용자는 이름을 일일이 구분해서 기억해야하기 때문에 서로 부담이됨

하지만 오버로딩을 통해 여러 메서드들이 println이라는 하나의 이름으로 정의되어 이름을 기억하기 쉽고 짧게 할 수 있어 오류의 가능성을 많이 줄일 수 있다.

```
결론

1. 메서드의 이름만 보고도 이 메서드들은 이름이 같으니, 같은 기능을 하겠구나 라고 쉽게 예측 가능
2. 메서드의 이름을 절약할 수 있다.
```

#### 4.5 가변인자(varargs)와 오버로딩

**가변인자(variable arguments)**

- 매개변수 개수를 동적으로 지정하는 기능
- `타입... 변수명`과 같은 형식으로 선언
  - 예시 : public PrintStream printf(String format, Object... args){ ... }
- 가변인자는 항상 마지막 매개변수이어야 한다.
- 가변인자가 선언된 메서드를 호출할 때마다 배열이 새로 생성된다.
  - 이러한 비효율이 숨어있으므로 꼭 필요한 경우에만 가변인자 사용

#### 가변인자 사용예시

-여러 문자열을 하나로 결합하여 반환하는 concatenate메서드를 작성한다면, 아래와 같이 매개변수의 개수를 다르게 해서 여러개의 메서드를 작성해야할 것이다.

```java
String concatenate(String s1, String s2){...}
String concatenate(String s1, String s2, String s3){...}
String concatenate(String s1, String s2, String s3, String s4){...}

// 이럴때, 가변인자를 사용하면 메서드 하나로 간단히 대체 가능
String concatenate(String ... str) 
    
    
// 메서드 호출시
System.out.println(concatenate());	// 인자가 없음
System.out.println(concatenate("a"));	// 인자가 하나
System.out.println(concatenate("a","b"));  // 인자가 둘
System.out.println(concatenate(new String[]{"A","B"}));   // 배열도 가능
```

#### 매개변수의 타입을 배열로 한경우

반드시 인자를 지정해야되서 인자를 생략 불가,그래서  null이나 길이가 0인 배열을 인자로 지정해줘야함

```
String concatenate(String[] str){...}

String result = concatenate(new String[0]);	// 인자로 배열을 지정
String result = concatenate(null);	// 인자로 null을 지정
String result = concatenate();		// 에러 인자가 필요함.
```

#### 가변인자를 사용한 메서드 오버로딩 에러

가변인자를 선언한 메서드를 오버로딩하면, 메서드를 호출했을 때 이와 같이 구별되지 못하는 경우가 발생하기 쉽기 떄문에 주의해야한다. 가능한 가변인자를 사용한 메서드는 오버로딩하지 않는 것이 좋다.

```java
static String concatenate(String delim, String ... args){
        String result = "";

        for(String str :args){
            result += str + delim;
        }
        return result;
    }
    
    
static String concatenate(String ... args){
        return concatenate("",args);		//  concatenate 메서드 호출
}

/* 컴파일 에러 VarArgsEx.java:5: error: reference to concatenate is ambiguous
concatenate("",args)메서드 호출시 static String concatenate(String delim, String ... args),
,static String concatenate(String ... args) 둘중 어떤 메서드 인지 구별되지 않음
```

### 5. 생성자(Constructor)

----

#### 5.1 생성자란?

- 인스턴스가 생성될 떄 호출되는 '인스턴스 초기화 메서드'이다.
- 변수 초기화 작업에 주로 사용되며, 인스턴스 생성 시에 실행되어야 할 작업을 위해서도 사용된다.

```
생성자의 조건

1. 생성자의 이름은 클래스의 이름과 같아야 한다.
2. 생성자는 리턴 값이 없다.
```

```Java
클래스 이름(타입변수명, 타입변수명, ...){
	// 인스턴스 생성 시 수행될 코드,
	// 주로 인스턴스 변수의 초기화 코드를 적는다.
}

class Card{
	Card(){			// 매개변수가 없는 생성자
		...
	}
	
	Card(String k, int num){		// 매개변수가 있는 생성자
		...
	}
}
```

Card클래스의 인스턴스 생성 코드예시

```
Card c = new Card();

1. 연산자 new에 의해서 메모리(heap)에 Card클래스의 인스턴스가 생성된다.
2. 생성자 Card()가 호출되어 수행된다.
3. 연산자 new의 결과로, 생성된 Card인스턴스의 주소가 반환되어 참조변수 c에 저장된다.

연산자 new가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것이 아니다.
생성자는 단순히 인스턴스변수들의 초기화에 사용되는 조금 특별한 메서드이다.
생성자가 갖는 몇 가지 특징만 제외하면 메서드와 다르지 않다.
```

#### 5.2 기본 생성자(default constructor)

- 모든 클래스에는 반드시 하나 이상의 생성자가 정의되어 있어야 한다.

- 컴파일 할 때, 소스파일(*.java)의 **클래스에 생성자가 하나도 정의되지 않은 경우** 컴파일러는 자동적으로 기본 생성자를 추가하여 컴파일 한다.

- 클래스의 접근 제어자가 public이면 기본 생성자도  public 클래스이름() { }

  ```java
  // 기본 생성자 : 매개변수x, 내용x
  
  클래스 이름() { }
  Card() { }
  ```

#### 5.3 생성자에서 다른 생성자 호출하기 - this(), this

생성자 간에 서로 호출  가능하기 위한 조건

```
- 생성자의 이름으로 클래스이름 대신 this를 사용한다
- 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.
```

예시

```java
Car(String color){
	door = 5;					// 첫 번째줄
	Car(color, "auto",4);		// 에러1. 생성자의 두 번째 줄에서 다른 생성자 호출
}								// 에러2. this(color, "auto",4);로 해야함
```

#### 5.4 this

```java
// 매개변수와 인스턴스변수 이름이 구별되는 경우
Car(String c, String g, int d){
        color = c;
        gearType = g;
        door = d;

// 매개변수와 인스턴스변수 이름이 구별 안되는 경우  	----> 인스턴스변수 앞에 this를 사용하면 된다.
Car(String color, String gearType, int door){
        this.color = color;		// this.color는 인스턴스변수, color는 생성자의 매개변수로 정의된 지역변수
        this.gearType = gearType;
        this.door = door;
```

- this를 사용할 수 있는 것은 인스턴스 멤버 뿐이다.

  ```
  this 인스턴스 자신을 가리키는 참조변수, 인스턴스의 주소가 저장되어 있다.
  	모든 인스턴스메서드에 지역변수로 숨겨진 채로 존재한다.
  	
  this(),this(매개변수) 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.
  ```



#### 5.5 생성자를 이용한 인스턴스의 복사

```java
// 인스턴스의 복사를 위한 생성자
Car(Car c){
        color = c.color;
        gearType = c.gearType;
        door = c.door;
}

// 위의 코드를 더 좋게 바꾸는 법
Car(Car c){
    // Car(String color, String gearType, int door)
    this(c.color,c.gearType,c.door);
}
```

```
인스턴스를 생성할 때는 다음의 2가지 사항을 결정해야한다.
	1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
	2. 생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?
```

### 6. 변수의 초기화

---

#### 6.1 변수의 초기화

- 멤버 변수(클래스변수, 인스턴스변수)
  - 자동적으로 변수의 자료형에 맞는 기본값으로 초기화가 이루어짐, 따라서 초기화하지 않고 사용 가능

- 지역변수 
  - 사용하기 전에 반드시 초기화 해야한다.
  
    ```java
    class InitTest{
    	int x;			// 인스턴스 변수
    	int y = x;		// 인스턴스 변수 x 초기화 하지 않고 사용
    	
    	void method1(){
    		int i;		// 지역변수
    		int j = i;	// 에러, 지역변수 i 초기화 하지않고 사용
    	}
    }
    ```

#### -멤버 변수의 초기화 방법

```
1. 명시적 초기화(explicit initialization)
2. 생성자(constructor)
3. 초기화 블럭(initialization block)
```

#### 6.2 명시적 초기화(explicit initialization)

- 변수를 선언과 동시에 초기화 하는것

  ```java
  class Car{
  	int door = 4;		// 기본형(primitive type) 변수의 초기화
  	Engine e = new Engine();	// 참조형(reference type) 변수의 초기화
  }
  ```

#### 6.3 초기화 블럭(initialization block)

```java
class InitBlock{
	static{ /* 클래스 초기화 블럭입니다. /*}
	
	{ /* 인스턴스 초기화 블럭입니다.*/}
}
```

```
클래스 초기화 블럭 : 클래스 변수의 복잡한 초기화에 사용된다.
	- 클래스가 메모리에 처음 로딩될 때 한번만 수행된다.
인스턴스 초기화 블럭 : 인스턴스변수의 복잡한 초기화에 사용된다.
	- 인스턴스를 생성할 때 마다 수행된다.
	- 생성자 보다 인스턴스 초기화 블럭이 먼저 수행된다.
	- 인스턴스 변수의 초기화는 주로 생성자를 사용하고, 인스턴스 초기화 블럭은 모든 생성자에서 공통으로 수행돼야 하는 코드를 넣		는데 사용
```

ex)

```java
Car(){
	count++;
	serialNo = count;
	color = "White";
	gearType = "Auto";
}
Car(String color, String gearType){
	count++;
	serialNo = count;
	this.color = color;
	this.gearType = gearType;
}

// 위의 코드의 생성자에서 중복된 코드를 인스턴스 초기화 블럭에 넣어준다.
{
	count++;
	serialNo = count;
}
Car(){
	color = "White";
	gearType = "Auto";
}
Car(String color, String gearType){
	this.color = color;
	this.gearType = gearType;
}
// 재사용성을 높이고 중복을 제거한다.(객체지향프로그래밍이 추구하는 궁극적인 목표)
```

#### 6.4 멤버변수의 초기화 시기와 순서

```
클래스변수의 초기화 시점 : 클래스가 처음 로딩될 때 단 한번 초기화
	[참고] 클래스의 로딩 시기는 JVM의 종류에 따라 다름, 클래스가 필요할 때 바로 메모리에 로딩하도록 설계가 되어있는 것도 있고		  실행효율을 높이기 위해서 사용될 클래스들을 프로그램이 시작될 때 미리 로딩하도록 되어있는 것도 있다.
	
인스턴스변수의 초기화 시점 : 인스턴스가 생성될 때마다 각 인스턴스별로 초기화가 이루어진다.

클래스변수의 초기화순서 : 기본값 -> 명시적초기화 -> 클래스 초기화 블럭
인스턴스변수의 초기화순서 : 기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자
```

ex)

```java
class InitTest{
	static int cv = 1;	// 명시적 초기화
	int iv = 1;			// 명시적 초기화
	
	static{			cv = 2 		}		// 클래스 초기화 블럭
	{			iv = 2  		}		// 인스턴스 초기화 블럭
	InitTest(){							// 생성자
		iv = 3;
	}	
}
/* 순서
1. cv가 메모리(method area)에 생성되고, cv에는 int형이 기본값인 0이 cv에 저장된다.
2. 그 다음에는 명시적 초기화(int cv = 1)에 의해서 cv에 1이 저장된다.
3. 마지막으로 클래스 초기화 블럭(cv = 2)이 수행되어 cv에는 2가 저장된다.
4. InitTest클래스의 인스턴스가 생성되면서 iv가 메모리(heap)에 존재하게 된다. 
   iv 역시 int형 변수이므로 기본값 0이 저장된다.
5. 명시적 초기화에 의해서 iv에 1이 저장
6. 인스턴스 초기화 블럭이 수행되어 iv에 2가 저장된다.
7. 마지막으로 생성자가 수행되서 iv에 3이 저장된다.
*/
```

