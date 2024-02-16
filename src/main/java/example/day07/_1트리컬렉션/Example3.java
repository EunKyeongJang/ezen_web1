package example.day07._1트리컬렉션;

import org.jetbrains.annotations.NotNull;

import java.util.TreeSet;

public class Example3 {
    public static void main(String[] args) {
        //1. TreeMap 컬렉션 생성
            //- 필수 : 정렬기준 필요(Integer, string, Double 등 타입은 이미 정렬기준이 있음)
        TreeSet<Person> treeSet=new TreeSet<>();
        
        //2. 객체저장
        treeSet.add(new Person("홍길동", 29));
        treeSet.add(new Person("김자바", 25));
        treeSet.add(new Person("박지원", 31));
        System.out.println("treeSet = " + treeSet);
        System.out.println();
        
        String str="유재석";
        System.out.println(str.compareTo("유재석"));
        System.out.println(str.compareTo("강호동"));
        System.out.println(str.compareTo("홍길동"));
        
    }//m end
}//c end
