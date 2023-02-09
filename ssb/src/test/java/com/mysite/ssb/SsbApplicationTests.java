package com.mysite.ssb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyByte;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.ssb.answer.Answer;
import com.mysite.ssb.answer.AnswerRepository;
import com.mysite.ssb.question.Question;
import com.mysite.ssb.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class SsbApplicationTests {
	
	
	@Autowired
	private QuestionRepository questionRepository;
	
    @Autowired
    private AnswerRepository answerRepository;


	@Test
	//@Transactional
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
//	        q.setSubject("	sbb에 대해서 알고 싶습니다._수정");
//	        this.questionRepository.save(q);

		
//08 (삭제)
//        assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
		
//09 (답변 입력)		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		 assertTrue(oq.isPresent());
//		 Question q = oq.get();
//		 
//		  Answer a = new Answer();
//		  a.setContent("헬로우 월드라큘라면사랑랑랑랑");
//		  a.setQuestion(q);
//		  a.setCreateDate(LocalDateTime.now());
//		  this.answerRepository.save(a); 

		
//10 (답변 삭제)
//		 Optional<Answer> oa = this.answerRepository.findById(2);
//		 assertTrue(oa.isPresent());
//		 Answer a = oa.get(); 
//		 this.answerRepository.delete(a);
//         assertEquals(1, this.answerRepository.count());
		
		
//11 (답변 조회)
//		Optional<Answer> oa = this.answerRepository.findById(1); 
//		 assertTrue(oa.isPresent());
//		 Answer a =oa.get(); 
//		 assertEquals(1,a.getQuestion().getId());
//		 System.out.println("count="+a.getContent());
//		 System.out.println("a.getQuestion().getContent()="+a.getQuestion().getContent());
		

		
//12 (질문으로 답변찾기) 
//org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role 에러 발생
//왜냐하면 Question 리포지터리가 findById를 호출하여 Question 객체를 조회하고 나면 DB세션이 끊어지기 때문이다. 
//그 이후에 실행되는 q.getAnswerList() 메서드는 세션이 종료되어 오류가 발생한다. 
//답변 데이터 리스트는 q 객체를 조회할때 가져오지 않고 q.getAnswerList() 메서드를 호출하는 시점에 가져오기 때문이다.
		
//이렇게 필요한 시점에 데이터를 가져오는 방식을 Lazy 방식이라고 한다. 
//이와 반대로 q 객체를 조회할때 답변 리스트를 모두 가져오는 방식은 Eager 방식이라고 한다. 
//@OneToMany, @ManyToOne 애너테이션의 옵션으로 fetch=FetchType.LAZY 또는 
//fetch=FetchType.EAGER 처럼 가져오는 방식을 설정할 수 있는데 이 책에서는 따로 지정하지 않고 
//항상 디폴트 값을 사용할 것이다.(default는 lazy로 추청된다)	
		
//사실 이 문제는 테스트 코드에서만 발생한다. 
//실제 서버에서 JPA 프로그램들을 실행할 때는 DB 세션이 종료되지 않기 때문에 위와 같은 오류가 발생하지 않는다.
//테스트 코드를 수행할 때 위와 같은 오류를 방지할 수 있는 가장 간단한 방법은 
//다음처럼 @Transactional 애너테이션을 사용하는 것이다. @Transactional 애너테이션을 사용하면 메서드가 종료될 때까지 DB 세션이 유지된다.
		Optional<Question> oq =this.questionRepository.findById(1); 
		assertTrue(oq.isPresent());
		Question q =oq.get(); 
		
		List<Answer> answerList = q.getAnswerList(); 
		
		for(int i=0; i<answerList.size(); i++) {
			System.out.println(answerList.get(i).getId()+" : "+answerList.get(i).getContent());
		}
	
		
		
		
		
	}

}
