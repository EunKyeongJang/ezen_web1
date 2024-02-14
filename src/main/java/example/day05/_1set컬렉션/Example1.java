package example.day05._1set컬렉션;

import java.util.HashSet;
import java.util.Set;

public class Example1 {
    public static void main(String[] args) {
        /*
        set 컬렉션
            - 저장순서/인덱스 유지되지 않는다. 
            - 중복 저장할 수 없다. null 하나만 가능하다.
        - set 인터페이스
            1. 구현클래스
                HashSet
            2. 사용방법/메소드
                .add
                .contains
        - 선언
            E : 컬렉션에 저장할 객체의 타입
            set<E> 컬렉션명 =new 구현클래스<>();            
         */
        //1. Set 컬렉션 선언
        Set<String> set=new HashSet<>();
        //2. Set 컬렉션에 객체 저장
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Java");    //중복 발생 : 중복객체이므로 저장되지 않음
        set.add("Spring");
        System.out.println("set = " + set);
        //3. set 컬렉션의 총 객체 수
        int size=set.size();
        System.out.println("size = " + size);
        
        //----------------------------------------------------------//
        Set<Member> set2=new HashSet<>();
        Member m1=new Member("홍길동", 30);
        Member m2=new Member("홍길동", 30);

        set2.add(m1);
        set2.add(m2);

        System.out.println("set2 = " + set2);
        System.out.println("set2.toString() = " + set2.toString());
        System.out.println("set2.hashCode() = " + set2.hashCode());
    }//m end
}//c end
