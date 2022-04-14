## 객체를 비교하거나 커스텀 비교 연산자가 필요할 경우
### Comparable과 Comparator 인터페이스
- Comparable와 Comparator는 둘 다 인터페이스로 정렬 기준을 구현하기 위해 사용된다.
  - Comparable 인터페이스는 compareTo()메서드를 override해서 구현한다.
  - Comparator 인터페이스는 compare() 메서드를 override해서 구현한다.
    - 일반적으로는 별도 클래스를 정의해서 구현하며, 따라서 동일 객체에 다양한 정렬 기준을 가진 클래스를 작성할 수 있다.
    - 동일한 데이터에 대해서 클래스에서 각각 정리해서 다양한 정렬 방법을 구현할 수 있다.

## Arrays.sort()와 Comparator 
- 다음 예와 같이 Arrays.sort() 메서드는 인자를 두개 받아서 두번째 인자에 Comparator 클래스를 넣어줄 수 있다.
  - Object 객체에 Comparable 인터페이스가 정의되어 있다하더라도, **Comparator 클래스의 정렬 기준으로 정렬**된다.
  - 이외에 JAVA8에서 lambda 등을 사용한 기법등 다양한 정렬 기법이 존재한다.