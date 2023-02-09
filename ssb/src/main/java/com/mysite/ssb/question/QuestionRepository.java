package com.mysite.ssb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
엔티티만으로는 데이터베이스에 데이터를 저장하거나 조회 할 수 없다. 
데이터 처리를 위해서는 실제 데이터베이스와 연동하는 JPA 리포지터리가 필요하다.

리포지터리란?
리포지터리는 엔티티에 의해 생성된 데이터베이스 테이블에 접근하는 메서드들(예: findAll, save 등)을 사용하기 위한 인터페이스이다. 
데이터 처리를 위해서는 테이블에 어떤 값을 넣거나 값을 조회하는 등의 CRUD(Create, Read, Update, Delete)가 필요하다.
이 때 이러한 CRUD를 어떻게 처리할지 정의하는 계층이 바로 리포지터리이다.
*/


/*
QuestionRepository는 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속했다. JpaRepository를 상속할 때는 
제네릭스 타입으로 <Question, Integer> 처럼 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입(Integer)을 지정해야 한다. 
이것은 JpaRepository를 생성하기 위한 규칙이다.
*/
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>{
	
	/*
	 "인터페이스에 findBySubject 라는 메서드를 선언만 하고 구현은 하지 않았는데 도대체 어떻게 실행이 되는 거지?"
	  이러한 마법은 JpaRepository를 상속한 QuestionRepository 객체가 생성될때 벌어진다. 
	  (DI에 의해 스프링이 자동으로 QuestionRepository 객체를 생성한다. 이 때 프록시 패턴이 사용된다고 한다.) 
	  리포지터리 객체의 메서드가 실행될때 JPA가 해당 메서드명을 분석하여 쿼리를 만들고 실행한다.
	즉, 여러분은 findBy + 엔티티의 속성명(예:findBySubject)과 같은 리포지터리 메서드를 작성하면 해당 속성의 값으로 데이터를 조회할수 있다.
	 */
	Question findBySubject(String subject); 
	
	//이번에는 제목과 내용을 함께 조회해 보자. 두 개의 속성을 And 조건으로 조회할때는 리포지터리에 다음과 같은 메서드를 추가해야 한다.
    Question findBySubjectAndContent(String subject, String content);
    
    //이번에는 제목에 특정 문자열이 포함되어 있는 데이터를 조회해 보자. Question 리포지터리를 다음과 같이 수정하자.
    List<Question> findBySubjectLike(String subject); 

}
