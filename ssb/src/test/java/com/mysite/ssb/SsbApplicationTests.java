package com.mysite.ssb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsbApplicationTests {
	
	
	@Autowired
	private QuestionRepository questionRepository;


	@Test
	void testJpa() {
//01
//		   Question q1 = new Question();
//		   
//	        q1.setSubject("sbb가 무엇인가요?");
//	        q1.setContent("sbb에 대해서 알고 싶습니다.");
//	        q1.setCreateDate(LocalDateTime.now());
//	        this.questionRepository.save(q1);  // 첫번째 질문 저장
//		   
//	        Question q2 = new Question();
//	        q2.setSubject("스프링부트 모델 질문입니다.");
//	        q2.setContent("id는 자동으로 생성되나요?");
//	        q2.setCreateDate(LocalDateTime.now());
//	        this.questionRepository.save(q2);  // 두번째 질문 저장

		
//02	
//	       List<Question> all = this.questionRepository.findAll();
//	        assertEquals(2, all.size());
//
//	        Question q = all.get(0);
//	        assertEquals("sbb가 무엇인가요?", q.getSubject());

//03
//        Optional<Question> oq = this.questionRepository.findById(1);
//        if(oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getSubject());
//        }
		

//04
//        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//        assertEquals(1, q.getId());

//05
//		  Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//	        assertEquals(1, q.getId());

//06
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        System.out.println("q.getSubject()="+q.getSubject());
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
		
//07 (수정)
//			Optional<Question> oq = this.questionRepository.findById(1);
//	        assertTrue(oq.isPresent());
//	        Question q = oq.get();
//	        q.setSubject("수정된 제목");
//	        this.questionRepository.save(q);

		
//08 (삭제)
//        assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
		
		

		
		
	}

}
