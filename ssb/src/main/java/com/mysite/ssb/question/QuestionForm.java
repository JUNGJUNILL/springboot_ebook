package com.mysite.ssb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
/*
@Size						문자 길이를 제한한다.
@NotNull					Null을 허용하지 않는다.
@NotEmpty				Null 또는 빈 문자열("")을 허용하지 않는다.
@Past						과거 날짜만 가능
@Future					미래 날짜만 가능
@FutureOrPresent	미래 또는 오늘날짜만 가능
@Max	`					최대값
@Min	`					최소값
@Pattern					정규식으로 검증
 */
@Getter
@Setter
public class QuestionForm {
	
	@NotEmpty(message = "제목은 필수항목입니다.")
	@Size(max=200) //byte
	private String subject; 
	
	@NotEmpty(message = "내용은 필수항목 입니다.")
	private String content; 
	
	

}
