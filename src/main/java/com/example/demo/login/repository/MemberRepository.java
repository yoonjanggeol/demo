package com.example.demo.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.login.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
   // 아이디로 회원 정보 조회 (select * from member where mem_id=?)
   Optional<MemberEntity> findByMembid(String memId);
   //널방지//
}