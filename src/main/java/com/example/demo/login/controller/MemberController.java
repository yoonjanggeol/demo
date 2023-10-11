package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.login.dto.MemberDTO;
import com.example.demo.login.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
   //생성자 주입
   private final MemberService memberService;
   
   
   //회원가입 페이지 출력 요청
   @GetMapping("/member/save")
   public String saveForm() {
      return "/Login/save";
   }
   
   @PostMapping("/member/save")
   public String save(@ModelAttribute MemberDTO memberDTO) {
      System.out.println("메서드확인 MemberController.save");
//      System.out.println("memID확인용 =" + memId); 확인완료
      System.out.println("회원가입정보확인" + memberDTO);
      memberService.save(memberDTO);
      return "Login/login";
   }
   
   @GetMapping("/member/login")
   public String loginForm() {
      return "Login/login";
   }
   
   @PostMapping("/member/login")
   public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
      MemberDTO loginResult = memberService.login(memberDTO);
      if(loginResult!=null) {
         // login 성공
         
         session.setAttribute("loginid", loginResult.getMemId());
         System.out.println("loginid "+loginResult.getMemId());
         return "Login/main";
      }else {
         // login 실패
         System.out.println("로그인실패");
         return "Login/login";
      }
   }
      @GetMapping("/mypage")
       public String mypageform(HttpSession session, Model model) {
           // 세션에서 로그인된 사용자의 이름 가져오기
           String username = (String) session.getAttribute("loginid");
           
           // 모델에 사용자 이름 추가
           model.addAttribute("loginid", username);
           
           // mypage 템플릿으로 이동
           return "Login/mypage";
       }
      
      @GetMapping("/member/logout")
      public String logout(HttpSession session) {
    	  session.invalidate();
    	  return "Login/index";
      }
}