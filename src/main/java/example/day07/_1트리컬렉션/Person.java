package example.day07._1트리컬렉션;

import org.jetbrains.annotations.NotNull;

public class Person implements Comparable<Person>{
    //implements : 구현하다 (인터페이스의 추상메소드)
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }//m end

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //**Integer 정렬**
    @Override
    public int compareTo(@NotNull Person o) {
        //String 비교 시 CompareTo 구문 사용
        //** 같으면 0, 적으면 -1, 크면 1
        if(this.age < o.age){
            return -1;
        }
        else if(this.age == o.age){
            return 0;
        }
        else{
            return 1;
        }
    }//override end

    //**String 정렬**
   /* @Override
    public int compareTo(@NotNull Person o) {
        return this.name.compareTo(o.name);
    }//override end*/
}//c end
