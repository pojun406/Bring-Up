package com.bring_up.bringup.company.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@ComponentScan(basePackages={"config"})
public class VerificationService {
    @Value("${vendor.validURL}")
    private String url;

    @Value("{vendor.serviceKey}")
    private String key;

    // WebClient 인스턴스 생성
    private WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public boolean verifyCompanyInfo(String openDate, int license, String masterName) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url + "/validate")
                .queryParam("serviceKey", key)
                .build(true).toUri(); // encoded:true -> 이중 인코딩 방지

        requestBody.put("openDate", openDate);
        requestBody.put("license", license);
        requestBody.put("masterName", masterName);


        return Boolean.TRUE.equals(response);
    }
}
