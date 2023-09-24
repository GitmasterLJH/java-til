## Chapter 09 java.lang패키지와 유용한 클래스

### 1. java.lang패키지

자바프로그래밍에 가장 기본이 되는 클래스들을 포함하고 있다.(import문 없이 사용 가능하는 뜻)

---

### 1.1 Object클래스

- 모든 클래스의 최고 조상이다.
- 오직 11개의 메서드만 가지고 있다.

| Object클래스의 메서드                                        | 설 명                                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| protected Object clone()                                     | 객체 자신의 복사본을 반환한다.                               |
| public boolean equals(Object obj)                            | 객체 자신과 객체 obj가 같은 객체인지 알려준다(같으면 true)   |
| protected void finalize()                                    | 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출된다. 이 때 수행되어야하는 코드가 있을 때 오버라이딩한다.(거의 사용x) |
| public Class getclass()                                      | 객체 자신의 클래스를 담고 있는 Class인스턴스를 반환한다      |
| public int hashcode()                                        | 객체 자신의 해시코드를 반환한다.                             |
| public String toString                                       | 객체 자신의 정보를 문자열로 반환한다.                        |
| public void notify                                           | 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.      |
| public void notifyAll()                                      | 객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.        |
| public void wait()<br />public void wait(long timeout)<br />public void wait(longtimeout, int nanos) | 다른 쓰레드가 notify()나 notifyAll()을 홏출할 때까지 현제 쓰레드를 무한히 또는 지정된 시간(timeout,nanos)동안 기다리게 한다.(timeout은 1/1000 초, nanos는 1/10^9 초) |

**equals(Object obj)**

- 매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려준다.

  ```java
  public boolean equals(Object obj){
  	return(this==obj);
  }
  ```

  this는 자기자신의 주소, obj는 매개변수로 주어진 객체의 주소이다. 이 메서드는 두 객체의 주소값을 비교해서 그 결과를 반환하니 항상 false가 나올것이다.(모든 객체의 주소는 다르니까)

  > 객체를 생성할 때, 메모리의 비어있는 공간을 찾아 생성하므로 서로 다른 두 개의 객체가 같은 주소를 갖는 일은 없다.

```java
class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if(v1.equals(v2))
            System.out.println("v1가 v2는 같습니다.");
        else
            System.out.println("v1가 v2는 다릅니다.");

        v2 = v1;
        if(v1.equals(v2))
            System.out.println("v1가 v2는 같습니다.");
        else
            System.out.println("v1가 v2는 다릅니다.");
    }
}
class Value{
    int value;
    Value(int value){
        this.value= value;
    }
}
```

위 예제를 통해 Object클래스로부터 상속받은 equals메서드는 두 참조변수에 저장된 값(주소값)이 같은지를 판단하는 기능밖에 할 수 없다는 것을 알 수 있다.

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/56c97c12-b737-4223-9700-998653292242" width="600px" height="200">

​	Value인스턴스가 가지고 있는 value값을 비교하도록 하기 위해서 오버라이딩하여 주소가 아닌 객체에 저장된 내용을 비교하도록 변경하면 된다.

```java
public boolean equals(Object obj){
        if(obj !=null && obj instanceof Person){
            return id == ((Person)obj).id;  
            // obj는 Object타입이므로 id값을 참조하기 위해서 Person타입으로 형변환 해야함
        }
        else{   // Person타입이 아니면 비교할 필요x
            return false;
        }
    }
```

> String,Date,File,wrapper클래스(Integer,Double등)의 equals메서드도 주소값이 아닌 내용을 비교하도록 오버라이딩 되어있다.

**hashCode()**

- 이 메서드는 해싱기법에 사용되는 해쉬함수를 구현한것이다.
- 해싱은 데이터관리기법 중의 하나로 다량의 데이터를 저장하고 검색하는데 유용하다.
- 찾고자하는 값을입력하면, 그 값이 저장된 위치를알려주는 해쉬코드(hashcode)를 반환한다.
- hashCode메서드는 <u>객체의 주소값으로 해시코드를 만들어 반환</u>하기 때문에 32bit JVM에서는 서로 다른  두 객체는 같은 해시코드를 가질 수 없다.(64bit JVm에서는 8byte주소값으로 해시코드(4byte)를 만들기 때문에 중복될 수 있다.  
- equals를 오버라이딩한다면 hashCode메서드도 오버라이딩해야 한다. 
  - 같은 객체라면 해시코드도 같아야 되서

```java
class HashCodeEx1 {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        // Sytstem.identityHashCode(Object x)는
        // Object클래스의 hashCode처럼 객체의 주소값으로 해시코드를 생성하기에 모든 객체는 항상 다른 해시코드값을 가짐
        // 따라서 str1과 str2가 해시코드는 같지만 서로 다른 객체라는 것을 알 수 있다.
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
    }
}
```

**toString()**

- 인스턴스에 대한 정보를 문자열로 제공한다

- Object클래스에 정의된 toString()

  ```java
  // 클래스이름 + 16진수의 해시코드를 얻게 된다.
  public String toString(){
  	return getClass().getName() +"@"+Integer.toHexString(hashCode());
  }
  ```

- String클래스 toString()은 String인스턴스가 갖고 있는 문자열을 반환하도록 오버라이딩되어 있다.
- Date클래스의 경우, Date인스턴스가 갖고 있는 날짜와 시간을 문자열로 변환하여 반환하도록 오버라이딩되어 있다.

```java
class Card{
    String kind;
    int number;

    Card(){
        this("SPADE",1);
    }
    Card(String kind, int number){
        this.kind = kind;
        this.number = number;
    }
}
class CardToString{
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();
        
        // Object클래스의 toString()이 호출
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
/* 결과
Card@10f87f48
Card@b4c966a
*/
```

위 코드는 toString을 오버라이딩 하지 않아 클래스이름 + 16진수의 해시코드를 얻게 되었다.

다음과 같이 오버라이딩 하면 원하는 정보를 얻을 수 있다.

```java
class Card2{
    String kind;
    int number;

    Card2(){
        this("SPADE",1);
    }
    Card2(String kind, int number){
        this.kind = kind;
        this.number = number;
    }
    // Object클래스에서 toString()의 접근 제어자가 public 이므로 오버라이딩하는 Card2클래스에서도 public
    public String toString(){
        return "kind : "+ kind +", number : "+number;
    }
}
class CardToString2{
    public static void main(String[] args) {
        Card2 c1 = new Card2();
        Card2 c2 = new Card2("Heart",10);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
```

**clone()**

- 자신을 복제하여 새로운 인스턴스를 생성
- Object클래스에 정의된 clone()은 단순히 인스턴스변수의 값만 복사하기 때문에 참타입의 인스턴스 변수가 있는 클래스는 완전한 인스턴스 복제가 이루어지지 않는다.
  - 배열에서 복제된 인스턴스도 같은 배열의 주소를 갖기 때문에 복제된 인스턴스의 작업이 원래의 인스턴스에 영향을 미치게 된다. 따라서 clone()메서드를 오버라이딩해서 새로운 배열을 생성하고 배열의 내용을 복사하도록 해야한다.

```java

class Point implements Cloneable{	// 1. Cloneable인터페이스를 구현
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "x="+x+", y="+y;
    }
    public Object clone(){		// 2. 접근제어자를 public으로 변경
        Object obj =null;		
        try{
            obj=super.clone();  	// 3. try-catch내에서 조상클래스의 clone()을 호출
        }catch(CloneNotSupportedException e){}  // Cloneable인터페이스를 구현하지 않으면 예외발생 이라는 뜻
        return obj;
    }
}

class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3,5);
        Point copy = (Point)original.clone();   // 복제(clone)해서 새로운 객체를 생성
        System.out.println(original);
        System.out.println(copy);

    }
}

```

clone()을 사용하려면 복제할 클래스가 Cloneable인터페이스를 구현해야하고, clone()을 오버라아딩하면서 접근 제어자를 `protected`에서 `public`으로 변경해야 상속관계가 없는 다른 클래스에서 clone()을 호출 할 수 있다.

인스턴스의 <u>데이터를 보호하기 위해서</u> Cloneable인터페이스를 구현한 클래스의 인스턴스만 clone()을 통한 복제가 가능하다. Cloneable<u>인터페이스가 구현되어 있다는 것은 클래스 작성자가 복제를 허용한다는 의미이다</u>.

Object클래스 clone()

```java
public class Object{
	...
    /* native는 자바가 아닌 언어(보통 C나 C++)로 구현한 후 자바에서 사용하려고 할 때 이용하는 키워드이다. 
       자바로 구현하기 까다로운 것을 다른 언어로 구현해서, 자바에서 사용하기 위한 방법이다.
    */
	protected native Object clone() throws CloneNotSupprotedException;
}
```

**공변 반환타입**

- 오버라이딩할 때 <u>조상 메서드의 반환타입을 자손 클래스의 타입으로 변경</u>을 허용하는 것이다.(JDK1.5부터 가능)

- 공변 반환타입을 사용하면 조상의 타입이 아닌, 실제로 반환되는 자손 객체의 타입으로 변환할 수 있어서 <u>번거러운 형변환이 줄어든다</u>는 장점이 있다.

  공변 반환타입 사용 전 코드

  ```java
  public Object clone(){		
          Object obj =null;		
          try{
              obj=super.clone();  	
          }catch(CloneNotSupportedException e){}  
          return obj;
      }
  ```

  ```java
  Point copy = (Point)original.clone();
  ```


  공변 반환타입 사용 후 코드

  ```java
  public Point clone(){ 		// 선언부 반환타입을 Object에서 Point로 변경
  	Object obj = null;
  	try{
  		obj = super.clone();
  	}catch(CloneNotSupportedException e){}
  	return (Point)obj;		// 2. Point타입으로 형변환 한다.
  }
  ```

  ```java
  Point copy = original.clone();
  ```

**배열의 경우**

```java
import java.util.*;
class CloneEx2 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int [] arrClone = arr.clone();  // 배열 arr을 복제
        arrClone[0]=6;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrClone));
    }
}
/* 결과
[1, 2, 3, 4, 5]
[6, 2, 3, 4, 5]
*/	
```

배열도 객체이기 때문에 Object클래스를 상속받으며, Cloneable인터페이스와 Serializable인터페이스가 구현되어 있다. 또 배열에서는  public으로 오버라이딩하여서 직접 호출이 가능하고, 원본과 같은 타입으로 반환하므로(공변 반환타입) 형변환이 필요 없다.

```java
// 두개의 코드는 같은 결과를 가짐

// 코드 1
  int [] arr = {1,2,3,4,5};
  int [] arrClone = arr.clone();
        
// 코드 2
    int [] arr = {1,2,3,4,5};
    int [] arrClone = new int[arr.length];
    System.arraycopy(arr,0,arrClone,0,arr.length);
```

> clone()으로 복제가 가능한 클래스인지 확인하려면 Java API에서 Cloneable을 구현했는지 확인하면 된다!!

**얕은 복사, 깊은 복사**

얕은 복사(shallow copy) : 객체에 저장된 값을 그대로 복제, 객체가 참조하고 있는 객체까지 복제하지 않는다.  기본형인 경우는 문제x, 객체를 복제하는 경우 원본을 변경하면 복사본도 영향을 받는다.

```java
class Circle implements Cloneable{
	Point p;	// 원점(참조변수)
	double r;	// 반지름
	
	Circle(Point p, double r){
		this.p = p;
		this.r = r;
	}
	public Circle clone(){ 		
		Object obj = null;
		try{
			obj = super.clone();
		}catch(CloneNotSupportedException e){}
		
		return (Circle)obj;	
	}
}
class shallowCopy{
	public static void main(String [] args){
		Circle c1 = new Circle(new Point(1,1),2.0);
		Circle c2 = c1.clone();
	}
}
```

결과 그림

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/9c88b8d9-8dfd-4895-b8f2-5a13ace64d01" width="500px" height="200">

깊은 복사(deep copy) : 원본과 복사본이 서로 다른 객체를 참조하기 때문에 원본의 변경이 복사본에 영향을 미치지 않는다.

```java
package ShallowDeep;

class Circle implements Cloneable{
    Point p;
    double r;

    Circle(Point p, double r){
        this.p = p;
        this.r = r;
    }
    public Circle shallowCopy(){    // 얕은 복사
        Object obj=null;
        try{
            obj = super.clone();
        }catch(CloneNotSupportedException e){}
        return (Circle)obj;
    }
    public Circle DeepCopy(){
        Object obj =null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException e){}

        Circle c = (Circle)obj;
        c.p = new Point(this.p.x,this.p.y);
        return c;
    }

    public String toString() {
        return "[p="+p+", r="+r+"]";
    }
}
class Point{
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+x+", "+y+")";
    }
}

public class ShallowDeepCopy{
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(1,1),2.0);
        Circle c2 = c1.shallowCopy();
        Circle c3 = c1.DeepCopy();

        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
        System.out.println("c3="+c3);

        c1.p.x = 9;
        c2.p.x = 9;
        System.out.println("= c1의 변경 후 = ");
        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
        System.out.println("c3="+c3);
    }
}
/* 결과
c1=[p=(1, 1), r=2.0]
c2=[p=(1, 1), r=2.0]
c3=[p=(1, 1), r=2.0]
= c1의 변경 후 = 
c1=[p=(9, 1), r=2.0]
c2=[p=(9, 1), r=2.0]
c3=[p=(1, 1), r=2.0]
*/	
```

이 3줄 코드에 의해 원본이 참조하고 있는 객체까지 복사했다

```java
Circle c = (Circle)obj;
c.p = new Point(this.p.x,this.p.y);
return c;
```

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/2e011c63-21f4-4c6b-a711-d50f4445dedf" width="500px" height="200">

**getClass()**

- 자신이 속한 클래스의 Class객체를 반환하는 메서드

  ```java
  public final class Class implements ...{	// Class 클래스
  		...
  }
  ```

- Class객체는 클래스의 모든 정보를 담고 있으며, 클래스 당 1개만 존재

- 클래스 파일이 클래스 로더(ClassLoader)에 의해서 메모리에 올라갈 때, 자동으로 생성된다.

- 클래스 로더는 실행 시에 필요한 클래스를 동적으로 메모리에 로드하는 역할을 한다.

  - 클래스로더는 파일 형태로 저장되어 있는 클래스를 읽어서 Class클래스에 정의된 형식을 변환함

    (먼저 기존에 생성된 클래스 객체가 메모리에 존재하는지 확인하고, 있으면 객체의 참조를 반환, 없으면 클래스 패스(classpath)에 지정된 경로를 따라서 클래스 파일을 찾는다. 만약 못찾으면 ClassNotFoundException이 발생하고, 찾으면 해당 클래스 파일을 읽어서 Class객체로 반환)

    - 즉 클래스 파일을 읽어서 사용하기 편한 형태로 저장해 놓은 것이 클래스 객체이다.

   <img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/f132274c-447f-4d8b-96f5-5e10869c148e" width="600px" height="200">

**Class객체를 얻는 방법**

해당 Class객체에 대한 참조를 얻는 여러가지 방법

```java
Class cObj = new Card().getclass();	// 생성된 객체로 부터 얻는 방법
Class cObj = Card.class;			// 클래스 리터럴(*.class)로 부터 얻는방법
Class cObj = Class.forName("Card");	// 클래스 이름으로 부터 얻는 방법
// forName()은 데이터베이스 드라이버를 메모리에 올릴때 주로 사용
```

Class객체를 이용하면 클래스에 대한 모든 정보를 얻을 수 있기에 Class 객체를 통해서 객체를 생성하고 메서드를 호출하는 등 동적인 코드를 작성할 수 있다.

```java
Card c = new Card();				// new연산자를 이용해서 객체 생성
Card c = Card.class.newInstance();	// Class객체를 이용해서 객체 생성
```

> 동적으로 객체를 생성하고 메서드를 호출하는 방법을 알고 싶다면, 'reflection API'로 검색하면된다.

```java
package ClassEx;

final class Card {
    String kind;
    int num;
    Card(){
        this("SPADE",1);
    }
    Card(String kind, int num){
        this.kind = kind;
        this.num = num;
    }
    public String toString(){
        return kind + ":"+num;
    }
}
class ClassEx1{
    public static void main(String[] args) throws Exception{
        Card c = new Card("HEART",3);   // new연산자로 객체 생성
        Card c2 = Card.class.newInstance();       // Class객체를 통해서 객체 생성

        Class cObj = c.getClass();

        System.out.println(c);
        System.out.println(c2);
        System.out.println(cObj.getName());
        System.out.println(cObj.toGenericString());
        System.out.println(cObj.toString());
    }
}
/* 결과
HEART:3
SPADE:1
ClassEx.Card
final class ClassEx.Card
class ClassEx.Card
*/
```

### 1.2 String 클래스

문자열을 위한 변경 불가능한(immutable)클래스이다.

String 클래스에서 문자열을 저장하기 위해서 문자형 배열 참조변수(char[]) value를 인스턴스 변수로 정의해놓고 있다. 인스턴스 생성시 생성자의 매개변수로 입력받는 문자열은 이 value에 char[]로 저장되는 것이다.

```java
public final class String implements java.io.Serializable, Comparable{
	private char[] value;
}
```

한번 생성된 String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있고, 변경 불가능

`+`연산자를 이용해 문자열을 결합하는 경우

```java
String a = "a";
String b = "b";
	   a = a+b;			
```

인스턴스내의 문자열이 바뀌는 것이 아니라 새로운 문자열("ab")이 담긴 String인스턴스가 생성되는 것이다.

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/77e3c229-6461-4cf3-83b3-26d490ed136a" width="600px" height="200">

> +을 사용해서 문자열을 결합하는 것은 매 연산 시마다 새로운 문자열을 가진 String인스턴스가 생성되어 메모리공간을 차지하게 되므로 가능한 결합횟수를 줄이는 것이 좋다. 문자열간의 결합이나 추출 등 문자열을 다루는 작업이 많이 필요한 경우면 StringBuffer클래스를 사용하는 것이 좋다.

**문자열 만드는법**

```java
String str1 = "abc";	// 문자열 리터럴 "abc"의 주소가 str1에 저장됨
String str2 = "abc";	// 문자열 리터럴 "abc"의 주소가 Str2에 저장됨

String str3 = new String("abc");		// 새로운 String인스턴스를 생성
String str4 = new String("abc");		// 새로운 String인스턴스를 생성
```

- String클래스의 생성자 이용 한경우

  new연산자에 의해서 메모리할당이 이루어지기 때문에 항상 새로운 String인스턴스가 생성된다.

​		<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/af403bd9-3164-4754-a82a-e57f81f3aaaf" width="500px" height="160">

- 문자열 리터럴의 경우

  이미 존재하는 것을 재사용 하는 것이다.

  <img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/89cc74b4-25bb-49b5-a22c-6414a6166221" width="500px" height="160">

eqauls()를 사용했을때는 두 문자열의 내용("abc")를 비교하기 떄문에 모두 true

참고 예

```java
class StringEx1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println("String str1 = \"abc\";");
        System.out.println("String str2 = \"abc\";");

        System.out.println("str1 == str2 ? " +(str1==str2));
        System.out.println("str1.equals(str2) ? " + str1.equals(str2));
        System.out.println();

        String str3 = new String("\"abc\"");
        String str4 = new String("\"abc\"");
        System.out.println("String str3 = new String(\"abc\");");
        System.out.println("String str4 = new String(\"abc\");");

        System.out.println("str3 == str4 ? "+(str3==str4));
        System.out.println("str3.equals(str4) ? " + str3.equals(str4));
    }
}
/* 결과
String str1 = "abc";
String str2 = "abc";
str1 == str2 ? true
str1.equals(str2) ? true

String str3 = new String("abc");
String str4 = new String("abc");
str3 == str4 ? false
str3.equals(str4) ? true
*/
```

**문자열 리터럴**

- 자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장된다

- 같은 내용의 문자열 리터럴은 한번만 저장된다.(문자열 리터럴도 String인스턴스이고, 한번 생성하면 내용을 변경할 수 없으니 하나의 인스턴스를 공유하면 되기 때문에)

- 클래스 파일에는 소스파일에 포함된 모든 리터럴의 목록 이있다. 해당 클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때, 이 리터럴의 목록에 있는 리터럴들이 JVM내에 있는 `상수 저장소(constant pool)`에 저장된다. 이 과정에서  문자열리터럴의 String인스턴스가 생성되는 것이다. 즉 이곳에 AAA와 같은 문자열 리터럴이 자동적으로 생성되어 저장되는 것이다.

  ```java
  class StringEx2{
  	public static void main(String [] args){
  		String s1 = "AAA";
  		String s2 = "AAA";
  		String s3 = "AAA";
  		String s4 = "BBB";
  	}
  }
  ```

  실행하면 AAA를 담고있는 String인스턴스가 하나 생성된 후, 참조변수 s1,s2,s3는 모두 이 String인스턴스를 참조하게 된다.

**빈 문자열(empty string)**

빈 문자열의 내부적 배열

```java
char[] chArr = new char[0];	// 길이가 0인 char배열	
int [] iArr  = {};		// 길이가 0인 int 배열
```

> 참고 
>
> C언어에서는 문자열의 끝네 널 문자가 항상 붙지만, 자바에서는 널 문자를 사용하지 않고 문자열의 길이정보를 따로 저장한다.

String은 참조형 타입의 기본값인 null 보다는 빈 문자열, char형은 기본값인 '\u0000'대신 공백으로 초기화 하는 것이 보통이다.

```java
String s = null
// \u0000은 유니코드의 첫번째 문자로써 아무런 문자도 지정되지 않은 빈 문자이다.
char c = '\u0000'
// 위 코드 대신에
String s ="";	// 빈 문자열로 초기화
char c = ' ';	// 공백으로 초기화
```

```java
class StringEx3 {
    public static void main(String[] args) {
        char[] cArr = new char[0];  // char[] cArr = {};와 같다.
        String s = new String(cArr);    // String s = new String(""); 와같다.

        System.out.println("cArr.length ="+cArr.length);
        System.out.println("@@@"+s+"@@@");
    }
}
/*결과
cArr.length =0
@@@@@@
*/
```

#### String클래스의 생성자와 메서드

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/64fcf81c-a55c-4ad9-a85b-d965e8b0cce1" width="800px" height="800">

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/bceac6b6-1749-4770-a15d-732b08eb289e" width="800px" height="800">

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/6bc236ff-ac4c-4ab5-8fe9-f4a92b212786" width="800px" height="800">

#### join()과 java.util.StringJoiner(JDK 1.8 부터 추가)

join

- 여러 문자열 사이에 구분자를 넣어서 결합한다.(split()과 반대 작업)

```java
String animals = "dog,cat,bear";
String[] arr = animals.split(",");	// 문자열을 ','를 구분자로 나눠서 배열에 저장
// String.join("-", "dog","cat","bear");
String str = String.join("-",arr);	// 배열의 문자열을 '-'로 구분해서 결합

System.out.println(str);		// dog-cat-bear
```

java.util.StringJoiner클래스

```java
							//    구분자 , 처음에오는 문자,끝에오는 문자
StringJoiner sj = new StringJoiner(","   ,   "["   ,   "]");
String[] strArr = {"aaa","bbb","ccc"};

for(String s : strArr)
    sj.add(s.toUpperCase());

System.out.println(sj.toString());	// [AAA, BBB, CCC]
```

예제

```java
import java.util.StringJoiner;
class StringEx4 {
    public static void main(String[] args) {
        String animals = "dog,cat,bear";
        String [] arr = animals.split(",");

        System.out.println(String.join("-",arr));
        StringJoiner sj = new StringJoiner("/","[","]");
        for(String s : arr)
            sj.add(s);
        System.out.println(sj.toString());
    }
}
/* 결과
dog-cat-bear
[dog/cat/bear]
*/	
```

**유니코드의 보충문자**

유니코드는 원래 2byte(16bit) 문자체계인데, 이걸로도 모자라서 20bit로 확장하게 되었다.  그래서 확장된 문자를 다루기 위해서는 하나의 문자를 char타입으로 다루지 못하고, int타입으로 다룰 수 밖에 없다.

결론 

- 매개변수의 타입이 `int ch`인 것들은 보충문자를 지원한다.

- 매개변수의 타입이 `char ch`인 것들은 보충문자를 지원하지 않는다.

> 확장에 의해 새로 추가된 문자들을 `보충 문자(supplementary characters)`라고 한다.

**문자 인코딩 변환**

`getBytes(String charsetName)`

- 문자열의 문자 인코딩을 다른 인코딩으로 변경할 수 있다.

  자바가 UTF-16을 사용하지만, 문자열 리터럴에 포함되는 문자들은 os의 인코딩을 사용한다.

  한글 windows의 경우 문자 인코딩으로 CP949를 사용하며, UTF-8로 변경하려면 다음과 같이 하면된다.

  ```java
  byte[] utf8_str = "가".getBytes("UTF-8");		// 문자열을 UTF-8로 변환
  String str = new String(utf8_str, "UTF-8");		 // byte배열을 문자열로 변환
  ```

  > 서로 다른 문자 인코딩을 사용하는 컴퓨터 간에 데이터를 주고받을때는 적절한 문자 인코딩이 필요하다.

  ```java
  import java.io.UnsupportedEncodingException;
  import java.util.StringJoiner;
  
  class StringEx5 {
      public static void main(String[] args) {
          String str = "가";
          byte[] bArr= {};
          byte[] bArr2 = {};
          try {
              bArr = str.getBytes("UTF-8");	// 문자열 "가"를 UTF-8로 변환 bArr에 16진수 0xEAB080이 저장됨
              bArr2 = str.getBytes("CP949");	// 문자열 "가"를 CP949로 변환 bArr에 16진수 0xB0A1이 저장됨
          }
          catch(UnsupportedEncodingException e){
              e.printStackTrace();
          }
          System.out.println("UTF-8:"+ joinByteArr(bArr));
          System.out.println("CP949:"+ joinByteArr(bArr2));
          try {
              // byte배열을 문자열로 변환
              System.out.println("UTF-8:" + new String(bArr, "UTF-8"));
              System.out.println("CP949:" + new String(bArr2, "CP949"));
          }catch(UnsupportedEncodingException e){
              e.printStackTrace();
          }
  
      }
      static String joinByteArr(byte[] bArr){
          StringJoiner sj = new StringJoiner(":","[","]");
  
          for(byte b : bArr)
              sj.add(String.format("%02X",b));
          return sj.toString();
      }
  }
  /*결과
  UTF-8:[EA:B0:80]
  CP949:[B0:A1]
  UTF-8:가
  CP949:가
  */
  ```

**String.format()**

- 형식화된 문자열을 만들어내는 간단한 방법이다. printf()와 사용법이 완전이 똑같음

```java
String str = String.format("%d 더하기 %d는 %d입니다.",3,5,3+5);
System.out.println(str);	// 3 더하기 5는 8입니다.
```

**기본형 값을 String으로 변환**

```java
int i = 100;						// 100을 "100"으로 변환하는 방법
String str1 = i +"";				// 1. 빈 문자열을 더한다.(가독성이 높음)
String str2 = String.valueOf(i);	// 2. valueOf() 사용(성능이 좋지만 가독성이 떨어짐)
```

valueOf종류

```java
String.valueOf(boolean b)
String.valueOf(char c)
String.valueOf(int i)
String.valueOf(long l)
String.valueOf(float f)
String.valueOf(double d)
```

**String을 기본형 값으로 변환**

```java
int i  = Integer.parseInt("100");	// 1. parseInt() 사용
int i2 = Integer.valueOf("100");   // 2. valueOf() 사용
							       // 반환타입이 Integer이지만 오토박싱에 의해 int로 자동변환됨
```

메서드의 이름을 통일하기 위해 valueOf()가 추가되었다.

```java
// valueOf(String s)는 메서드 내부에서 그저 parseInt(String s)를 호출할 뿐이므로, 반환 타입만 다르지 같은 메서드이다.
public static Integer valueOf(String s) throws NumberForamtException{
	return Integer.valueOf(parseInt(s,10));	// 10은 10진수를 의미
}
```

다양한 문자열->기본형 변환 방법

```java
Boolean.parseBoolean(String s)
Byte.parseByte(String s)
Short.parseShort(String s)
Integer.parseInt(String s)
Long.parseLong(String s)
Float.parseFloat(String s)
Double.parseDouble(String s)
```

예제

```java
class StringEx6{
    public static void main(String[] args) {
        int iVal = 100;
        String strVal = String.valueOf(iVal);   // 300을 "300"으로 변환
        
        double dVal = 200.0;
        String strVal2 = dVal + "";  // 빈 문자열을 이용해 "200.0"으로 변환
									// 부호 +라는 의미
        double sum = Integer.parseInt("+"+strVal)+ Double.parseDouble(strVal2);
        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);

        System.out.println(String.join("",strVal,"+",strVal2,"=")+sum);
        System.out.println(strVal +"+"+strVal2+"="+sum2);
    }
}
/* 결과
100+200.0=300.0
100+200.0=300.0
*/
```

주의사항

- parseInt()나 parseFloat()같은 메서드는 문자열에 공백 또는 문자가 포함되어 있는 경우 변환 시 예외(NumberFormat Exception)가 발생할 수 있으므로 주의해야함. 그래서 trim()을 습관적으로 같이 사용하기도 함

  ```java
  int val = Integer.parseInt(" 123 ".trim());	// 문자열 양 끝의 공백을 제거후 반환
  ```

- 부호를 의미하는 '+'나 소수점을 의미하는 '.'와 float형 값을 뜻하는 f와 같은 자료형 접미사는 허용된다. 단 자료형에 알맞는 변환을 하는 경우에만 허용( ex) 1.0f를 Float.parseFloat(String s)에 사용해야 문제가 없다)

  > +가 포함된 문자열이 parseInt()로 변환가능하게 된것은 JDK1.7부터

  참고!!

- Integer클래스의 static int parseInt(String s, int radix)를 사용하면 16진수 값으로 표현된 문자열도 변환할 수 있다. 대소문자 구별 없이 a,b,c,d,e,f도 사용 가능

  ```java
  int result = Integer.parseInt("a",16);
  // reuslt에 10이 저장됨(16진수 a는 10진수로 10을 뜻한다.);
  
  // 만약 이처럼 숫자가 아닌 것을(a)를 숫자로 변환하려하면 NumberFormatException이 발생한다.
  System.out.println(Integer.parseInt("a"));
  ```

**substring메서드**

`substring(int start, int end)`

```java
public class StringEx7 {
    public static void main(String[] args) {
        String fullName = "Hello.java";
        // fullName에서 '.'의 위치를 찾는다.
        int index = fullName.indexOf(".");

        // fullName의 첫번째 글자부터 '.'이 있는 곳까지 문자열을 추출한다.
        String fileName = fullName.substring(0,index);

        // '.'의 다음 문자부터 시작해서 문자열의 끝까지 추출한다.
        // fullName.substring(index+1,fullName.length()); 의 결과와 같다.
        String ext = fullName.substring(index+1);
        System.out.println(fullName + "의 확장자를 제외한 이름은 "+fileName);
        System.out.println(fullName+"의 확장자는 "+ext);
    }
}
/* 결과
Hello.java의 확장자를 제외한 이름은 Hello
Hello.java의 확장자는 java
*/
```

> end - start = substring에 의해 추출될 글자의 수

### 1.3 StringBuffer클래스와 StringBuilder클래스

**StringBuffer클래스**

- 인스턴스를 생성할 때 지정된 문자열을 변경할 수 있다.(String클래스는 바꾸지 못함)
- 내부적으로 문자열 편집을 위한 버퍼(buffer)를 가지고 있으며, StringBuffer인스턴스를 생성할 때 그 크기를 지정할 수 있다.

```java
// 문자열을 저장하기 위한 char형 배열의 참조변수를 인스턴스변수로 선언해 놓음
// 인스턴스가 생성될 때 char형 배열이 생성되며 이 때 생성된 char형 배열을 인스턴스변수 value가 참조하게 된다.
public final calss StringBuffer implements java.io.Serializable{
	private char[] value;
	...
}
```

**StringBuffer의 생성자**

```java
public StringBuffer(int length){
	value = new char[legnth];
	shared = false;
}
// 버퍼의 크기를 지정하지 않으면 버퍼의 크기는 16이 된다.
public StringBuffer(){
	this(16);
}
// 지정한 문자열의 길이보다 16이 더 크게 버퍼를 생성한다.
public StringBuffer(String str){
	this(str.length()+16);
}
```

> 버퍼의 길이를 충분히 잡아주는게 좋다. 버퍼의 크기가 작업하려는 문자열의 길이보다 작을 때는 내부적으로 버퍼의 크기를 증가시키는 작업이 수행되어야하기 때문에 작업효율이 떨어짐

배열의 길이는 변경될 수 없으므로 새로운 길이의 배열을 생성한 후에 이전 배열의 값을 복사해야 한다.

```java
// StringBuffer 클래스의 일부
...
// 새로운 길이(newCapacity)의 배열을 생성한다. newCapacity는 정수값이다.
char newValue[] = new char[newCapacity];

// 배열 value의 내용을 배열 newValue로 복사한다.
System.arraycopy(value,0,newValue,0,count);	// count는 문자열의 길이
value = newValue;  // 새로 생성된 배열의 주소를 참조변수 value에 저장
```

**StringBuffer의 변경**

```java
StringBuffer sb = new StringBuffer("abc");
sb.append("123");	// sb의 내용 뒤에 "123"을 추가한다.
```

<u>append()는 반환타입이 StringBuffer로 자신의 주소를 반환한다.</u> 

그래서 아래의 코드는 sb에 새로운 문자열이 추가되고 sb자신의 주소를 반환하여 sb2에는 sb의 주소인 0x100이 저장된다.

```java
StringBuffer sb2 = sb.append("ZZ");	// sb의 내용뒤에 "ZZ"를 추가한다.
System.out.println(sb);		// abc123ZZ
System.out.println(sb2);	// abc123ZZ
```

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/3648f225-596d-4b13-bc09-eb6395765fe5" width="600px" height="200">

반환하는 주소가 자기 주소이니 같은 StringBuffer인스턴스를 가리키고 있다. 그래서 하나의 StringBuffer인스턴스에 대해 아래와 같이 연속적으로 append()를 호출하는 것이 가능

> 만약 append()의 반환타입이 void이면 불가능 했을 것이다.

```java
StringBuffer sb = new StringBuffer("abc");
// sb.append("123")이 곧 sb이니(반환타입이 StringBuffer,자신의 주소) sb.append("ZZ")와 같은 의미가 된다.
sb.append("123").append("ZZ");
```

**StringBuffer의 비교**

StringBuffer클래스는 `equals메서드`를 오버라이딩하지 않았다. 따라서 equals메서드를 사용해도 등가비교연산자(==)로 비교환 것과 같은 결과를 얻는다.

```java
StringBuffer sb = new StringBuffer("abc");
StringBuffer sb2 = new StringBuffer("abc");

System.out.println(sb==sb2);     	// false
System.out.println(sb.equals(sb2))  // false
```

`toString()`은 StringBuffer인스턴스에 담고있는 문자열을 String으로 반환하도록 오버라이딩 되어 있기 때문에

StringBuffer인스턴스에 toString()을 호출해서 String인스턴스를 얻은 다음, 여기에 equals메서드를 사용해서 비교해야한다.

```java
String s = sb.toString();
String s2 = sb2.toString();

System.out.println(s.equals(s2));	// true
```

**StringBuffer클래스의 생성자와 메서드**

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/d183b15d-0636-4313-a1db-88cbd2b20b5a" width="800px" height="800">

<img src="https://github.com/Jinhyung01/Java_TIL/assets/129172593/354d6d0e-645a-4a41-b8d7-27d256549770" width="800px" height="800">

예제

```java
public class StringBufferEx2 {
    public static void main(String[] args) {
        // "01"의 문자열 길이인 2 + 16 = 18, 즉 버퍼의 크기는 18이된다.
        StringBuffer sb = new StringBuffer("01");
        StringBuffer sb2 = sb.append(23);
        sb.append('4').append(56);

        StringBuffer sb3 = sb.append(78);
        sb3.append(9.0);
        System.out.println(sb.capacity());
        System.out.println("sb =" + sb);
        System.out.println("sb2 =" + sb2);
        System.out.println("sb3 =" + sb3);

        System.out.println("sb =" + sb.deleteCharAt(10));
        System.out.println("sb =" + sb.delete(3, 6));
        System.out.println("sb =" + sb.insert(3, "abc"));
        System.out.println("sb =" + sb.replace(6, sb.length(), "END"));

        System.out.println("capacity=" + sb.capacity());
        System.out.println("length=" + sb.length());
    }
}
/* 결과
sb =0123456789.0
sb2 =0123456789.0
sb3 =0123456789.0
sb =01234567890
sb =01267890
sb =012abc67890
sb =012abcEND
capacity=18
length=9
*/
```

**StringBuilder**

StringBuffer는 멀티쓰레드에 안전(thread safe)하도록 동기화 되어있다. 동기화가 StringBuffer의 성능을 떨어뜨림. 멀티쓰레드로 작성된 프로그램이 아닌 경우, StringBuffer의 동기화는 불필요하게 성능만 떨어뜨린다. 그래서 StringBuffer에서 쓰레드의 동기화만 뺀 `StringBuilder`가 새로 추가 됨

StringBuilder는 StringBuffer와 완전히 똑같은 기능으로 작성되어 있다. 그래서 StringBuffer타입의 참조변수를 선언한 부분과 StringBuffer의 생성자만 바꾸면 된다.

```java
// StringBuffer
StringBuffer sb;
sb = new StringBuffer();
sb.append("abc");

// StringBuilder
StringBuilder sb;
sb = new StringBuilder();
sb.append("abc");
```

> StringBuffer도 충분히 성능이 좋기 때문에 성능향상이 반드시 필요한 경우를 제외하고는 StringBuilder로 굳이 바꿀 필요 없다.
