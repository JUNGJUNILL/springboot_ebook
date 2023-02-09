package com.mysite.ssb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

//롬복 라이브러리가 제공하는 @RequiredArgsConstructor 기능을 사용하면 final이 붙은
//필드를 모아서 생성자를 자동으로 만들어준다.
@RequiredArgsConstructor 
@RequestMapping("/question")
@Controller
public class QuestionController {

	
	private final QuestionService questionService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList(); 
		model.addAttribute("questionList", questionList); 
		return "question_list"; 
	}	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id); 
		model.addAttribute("question",question); 
		return "question_detail"; 
	}
	
	@GetMapping("/create")
	public String questionCreate(@RequestParam String subject, @RequestParam String content) {
		
		
		return "redirect:/question/list";
	}
}
