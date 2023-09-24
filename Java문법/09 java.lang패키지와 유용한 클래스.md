## Chapter 09 java.lang패키지와 유용한 클래스

### 1. java.lang패키지

자바프로그래밍에 가장 기본이 되는 클래스들을 포함하고 있다.(import문 없이 사용 가능하는 뜻)

---

#### 1.1 Object클래스

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

#### 1.2 String 클래스

