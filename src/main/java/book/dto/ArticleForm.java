package book.dto;

import lombok.*;

//입력 폼 전용 dto
    //관례적으로 모든 필드는 직접접근 권장하지 않는다. private, 안정성보장, 캡슐화 특징, getter, setter, 생성자
    //필드는 private, 생성자 : 빈, 풀, , 메소드 : toString(), setter,getter
    //간단한 생성자와 toString(), setter, getter 메소드는 롬복이 가능
    //@어노테이션 : 컴파일 시 해당 클래스 / 함수 / 필드에 (미리) 정보 주입
@AllArgsConstructor //컴파일 시 모든 필드 생성자를 만들어주는 어노테이션 [롬복]
@NoArgsConstructor  //컴파일 시 기본 생성자를 자동으로 만들어준다.
@ToString           //컴파일 시 toString()을 자동으로 만들어준다. [롬복]
@Getter@Setter      //컴파일 시 getter/setter 메소드를 자동으로 만들어준다.
public class ArticleForm {
    //1. 필드
    private Long id;
    private String title;   //입력받은 제목 필드
    private String content; //입력받은 내용 필드
    //2. 생성자

    //3. 메소드
        //toString() : 객체 내 필드값 호출 함수

        //getter/setter
}
