package com.mysite.ssb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.ssb.answer.Answer;
import com.mysite.ssb.answer.AnswerForm;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import lombok.RequiredArgsConstructor;

//롬복 라이브러리가 제공하는 @RequiredArgsConstructor 기능을 사용하면 final이 붙은
//필드를 모아서 생성자를 자동으로 만들어준다.
@RequiredArgsConstructor 
@RequestMapping("/question")
@Controller
public class QuestionController {

	
	private final QuestionService questionService;
	
	@GetMapping("/list")
	public String list(Model model , @RequestParam(value="page" , defaultValue = "0") int page) {
		Page<Question> paging = this.questionService.getList(page); 
//		List<Question> questionList = this.questionService.getList(); 
//		model.addAttribute("questionList", questionList); 
		  model.addAttribute("paging", paging);
		return "question_list"; 
	}	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id); 
		model.addAttribute("question",question); 
		return "question_detail"; 
	}
	
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		//GetMapping으로 매핑한 questionCreate 메서드에 매개변수로 QuestionForm 객체를 추가했다. 
		//이렇게 하면 이제 GET 방식에서도 question_form 템플릿에 QuestionForm 객체가 전달될 것이다.
		
		return "question_form";
	}
	
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		//questionCreate 메서드의 매개변수를 subject, content 대신 QuestionForm 객체로 변경했다. 
		//subject, content 항목을 지닌 폼이 전송되면 QuestionForm의 subject, content 속성이 자동으로 바인딩 된다. 
		//이것은 스프링 프레임워크의 바인딩 기능이다.
		
		//그리고 QuestionForm 매개변수 앞에 @Valid 애너테이션을 적용했다. 
		//@Valid 애너테이션을 적용하면 QuestionForm의 @NotEmpty, @Size 등으로 설정한 검증 기능이 동작한다. 
		//그리고 이어지는 BindingResult 매개변수는 @Valid 애너테이션으로 인해 검증이 수행된 결과를 의미하는 객체이다.
		
		if(bindingResult.hasErrors()){
			return  "question_form"; 
		}
		
		this.questionService.create(questionForm.getSubject(),questionForm.getContent()); 		
		return  "redirect:/question/list";
		
	}
}
