package example.day05._1set컬렉션;

public class Member {
    public String name;
    public int age;

    public Member(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override   //재정의
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //hashCode, equals => 메소드의 주인은 Object
        //
    //toString => 메소드의 주인은 Object
        //- 객체의 (JVM) 주소를 반환
        // 오버라이딩 : 주소 반환 대신 필드(정보)로 반환
}//c end
