package com.bring_up.bringup.company.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendorValidation {
    private String b_no; // 사업자 번호
    private String start_dt; // 개업일자
    private String p_nm; // 대표자명
    private String p_nm2; // 대표자명2
    private String b_nm; // 업체명
    private String corp_no; // 법인번호
    private String b_sector; // 업종
    private String b_type; // 업태
}