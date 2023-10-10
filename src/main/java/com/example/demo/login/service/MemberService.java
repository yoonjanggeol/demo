package com.example.demo.login.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.login.dto.MemberDTO;
import com.example.demo.login.entity.MemberEntity;
import com.example.demo.login.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

   private final MemberRepository memberRepository;
   
   public void save(MemberDTO memberDTO) {
      // 1. dto => entity 변환
      // 2. repository의 save 메서드 호출
      MemberEntity memberEntity= MemberEntity.toMemberEntity(memberDTO);
      memberRepository.save(memberEntity);
      
      // repository의 save 매서드 호출(조건.entity객체를 넘겨줘야함)
   }

   public MemberDTO login(MemberDTO memberDTO) {
      //1.회원 ID DB 조회
      //2.DB에서 조회한 비밀번호와 사용자 입력 비밀번호 일치 판단
      Optional<MemberEntity> bymem_Id=memberRepository.findByMembid(memberDTO.getMemId());
      if(bymem_Id.isPresent()) {
         // 조회 결과 o
         MemberEntity memberEntity =bymem_Id.get();
         if(memberEntity.getMem_Pw().equals(memberDTO.getMemPw())) {
            //비밀번호 일치 
            // entity => dto 변환 후 리턴
            MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
            return dto;
         }else {
            //비밀번호 불일치
            return null;
         }
      }else {
         //조회 결과 x
         return null;
      }
   }
}