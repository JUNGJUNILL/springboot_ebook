package com.mysite.ssb;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/*
엔티티와 Setter
일반적으로 엔티티에는 Setter 메서드를 구현하지 않고 사용하기를 권한다. 
왜냐하면 엔티티는 데이터베이스와 바로 연결되어 있으므로 데이터를 자유롭게 변경할 수 있는 Setter 메서드를 허용하는 것이 안전하지 않다고 판단하기 때문이다.
그렇다면 Setter 메서드 없이 어떻게 엔티티에 값을 저장할 수 있을까?
엔티티를 생성할 경우에는 롬복의 @Builder 어노테이션을 통한 빌드패턴을 사용하고, 데이터를 변경해야 할 경우에는 그에 해당되는 메서드를 엔티티에 추가하여 데이터를 변경하면 된다.
다만, 이 책은 복잡도를 낮추고 원활한 설명을 위해 엔티티에 Setter 메서드를 추가하여 진행하려 한다.
 */

@Getter
@Setter
@Entity
public class Question {

	
	/*
	@Id
	고유 번호 id 속성에 적용한 @Id 애너테이션은 id 속성을 기본 키로 지정한다. 
	기본 키로 지정하면 이제 id 속성의 값은 데이터베이스에 저장할 때 동일한 값으로 저장할 수 없다. 
	고유 번호를 기본 키로 한 이유는 고유 번호는 엔티티에서 각 데이터를 구분하는 유효한 값으로 중복되면 안 되기 때문이다.  
	
	@GeneratedValue
	@GeneratedValue 애너테이션을 적용하면 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장된다. 
	strategy는 고유번호를 생성하는 옵션으로 GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용한다.
	
	strategy 옵션을 생략할 경우에 @GeneratedValue 애너테이션이 지정된 컬럼들이 모두 동일한 시퀀스로 번호를 생성하기 때문에 
	일정한 순서의 고유번호를 가질수 없게 된다. 
	이러한 이유로 보통 GenerationType.IDENTITY를 많이 사용한다.
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	
	 /*
	 @Column
	 엔티티의 속성은 테이블의 컬럼명과 일치하는데 컬럼의 세부 설정을 위해 @Column 애너테이션을 사용한다. 
	 length는 컬럼의 길이를 설정할때 사용하고 columnDefinition은 컬럼의 속성을 정의할 때 사용한다. 
	 columnDefinition = "TEXT"은 "내용"처럼 글자 수를 제한할 수 없는 경우에 사용한다.
	 
	 엔티티의 속성은 @Column 애너테이션을 사용하지 않더라도 테이블 컬럼으로 인식한다. 
	 테이블 컬럼으로 인식하고 싶지 않은 경우에만 @Transient 애너테이션을 사용한다.
	 */
	@Column(length = 200)
	private String subject; 
	
	@Column(columnDefinition = "TEXT")
	private String content; 
	
	
	/*
	 위의 Question 엔티티에서 작성일시에 해당하는 createDate 속성의 실제 테이블의 컬럼명은 create_date가 된다. 
	 즉 createDate처럼 대소문자 형태의 카멜케이스(Camel Case) 이름은 create_date 처럼 
	 모두 소문자로 변경되고 언더바(_)로 단어가 구분되어 실제 테이블 컬럼명이 된다.
	 */
	private LocalDateTime createDate; 
		
	/*
	 질문 하나에는 여러개의 답변이 작성될 수 있다. 
	 이때 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해서 @OneToMany의 속성으로 cascade = CascadeType.REMOVE를 사용했다.
	 */
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList; 
	

	
	
}
