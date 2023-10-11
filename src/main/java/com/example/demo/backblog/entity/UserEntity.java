package com.example.demo.backblog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name="User") //엔터티 선언 및 이름 User라고 지정
@Table(name="User") // DB에 테이블명 User인 테이블과 매칭하겠다. 고로 DB의 User테이블을 사용하는 이름을 
public class UserEntity {
    @Id
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userPhoneNumber;
    private String userAddress;
    private String userProfile;
}
