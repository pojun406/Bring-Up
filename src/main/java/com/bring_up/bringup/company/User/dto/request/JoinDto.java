package com.bring_up.bringup.company.User.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinDto {
    /*
    private String userid;
    private String username;
    private String password;
    private String email;
     */

    private String opendate; // 개업일자
    private String licence; // 사업자 등록 번호
    private String CEO; // CEO 이름
    // ㅡㅡㅡㅡㅡㅡㅡ1차 회원가입시 필요함ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    private String id; // entity에서 이메일
    private String password;

    private String company_name; // 회사명
    private String managername; // 담당자명
    private String phonenum; // 담당자 번호
    private String address; // 회사 주소
    private String category; // 업종
    private String content; // 사업내용
    private String welfare; // 복지
    private String history; // 연혁
    private String scale; // 회사 규모(중소/중견/대/공)
    private String vision; // 회사 비전
    private String logo; // 회사 로고
    private int companysize; // 직원 수
    private String cv_key; // 이력서 열람 키 갯수
}
