package com.bring_up.bringup.company.Service;

import com.bring_up.bringup.company.Entity.VendorValidation;
import com.bring_up.bringup.company.Properties.VendorProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@ComponentScan(basePackages={"config"})
public class VerificationService {
    private final RestTemplate restTemplate;
    private final String verificationApiUrl;
    private final VendorProperties vendorProperties;

    public VerificationService(RestTemplate restTemplate, @Value("${verification.api.url}") String verificationApiUrl, VendorProperties vendorProperties) {
        this.restTemplate = restTemplate;
        this.verificationApiUrl = verificationApiUrl;
        this.vendorProperties = vendorProperties;
    }

    public String VendorValidation()  {

        VendorValidation vendorValidation = VendorValidation.builder()
                .b_no("사업자번호")
                .start_dt("개업일자")
                .p_nm("대표자명")
                .p_nm2("")
                .b_nm("업체명")
                .corp_no("법인번호")
                .b_sector("")
                .b_type("")
                .build();

        String requestBody = "{\n" +
                "  \"businesses\": [\n" +
                "    {\n" +
                "      \"b_no\": \"" + vendorValidation.getB_no() + "\",\n" +
                "      \"start_dt\": \"" + vendorValidation.getStart_dt() + "\",\n" +
                "      \"p_nm\": \"" + vendorValidation.getP_nm() + "\",\n" +
                "      \"p_nm2\": \"" + vendorValidation.getP_nm2() + "\",\n" +
                "      \"b_nm\": \"" + vendorValidation.getB_nm() + "\",\n" +
                "      \"corp_no\": \"" + vendorValidation.getCorp_no() + "\",\n" +
                "      \"b_sector\": \"" + vendorValidation.getB_sector() + "\",\n" +
                "      \"b_type\": \"" + vendorValidation.getB_type() + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                vendorProperties.getValidURL() + vendorProperties.getServiceKey(),
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        return responseEntity.getBody();
    }

    public boolean verifyCompanyInfo(String openDate, int license, String masterName) {

        // 요청 본문 생성
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("openDate", openDate);
        requestBody.put("license", license);
        requestBody.put("masterName", masterName);

        // API 호출
        Boolean response = restTemplate.postForObject(verificationApiUrl, requestBody, Boolean.class);

        return Boolean.TRUE.equals(response);
    }
}
