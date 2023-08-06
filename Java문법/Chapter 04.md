## Chapter 04

### 1. 조건문

---

#### 1.1 switch 문

```
switch문의 제약조건
	1. switch문의 조건식 결과는 정수 또는 문자열이어야 한다.
	2. case문의 값은 정수 상수만 가능하며, 중복되지 않아야 한다.
```

예시 코드

```java
public static void main(String[] agrs){
    int num, result;
    final int ONE = 1;
    ...
    switch(result){
        case '1':   //OK. 문자 리터럴(정수 상수 49와 동일)
        case ONE:   //OK. 정수 상수
        case "YES": //OK. 문자열 리터럴
        case num:   //에러. 변수 불가
        case 1.0:   //에러. 실수 불가
    }
}
```

#### 난수 생성

- 0.0 <= Math.random() < 1.0
  - 0.0과 1.0사이의 범위에 속하는 하나의 double값을 반환
- (int)(Math.random() *3)+1
  - 1과 3사이의 정수 중 하나를 얻을 수 있다.

#### charAt()

```java
String regNo = scanner.nextLine();
char gender = regNo.charAt(7);  //입력받은 번호의 8번째 문자를  gender에 저장
```

#### 속도 향상을 위한 경우

```java
/* if문을 이용한다면 최대 4번의 조건식을 계산해야하지만 switch문은 조건식을 1번만 계산하면 되므로 빠르다.
그러나 코드가 복잡해저서 좋지 않은 코드가 됨
*/
switch(score){
            case 100: case 99: case 98: case 97: case 96:
            case 95:  case 94: case 93: case 92: case 91: case 90:
                grade = 'A';
                break;
            case 89: case 88: case 87: case 86: case 85:
            case 84: case 83: case 82: case 81: case 80:
                grade = 'B';
                break;
            case 79: case 78: case 77: case 76: case 75:
            case 74: case 73: case 72: case 71: case 70:
                grade= 'C';
                break;
            default:
                grade ='F';
            }
```



### 2. 반복문

---

#### 2.1 for문

