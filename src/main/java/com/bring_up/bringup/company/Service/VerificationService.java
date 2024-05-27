package com.bring_up.bringup.company.Service;

import com.bring_up.bringup.company.dto.ValidationRequestDto;
import com.bring_up.bringup.company.dto.ValidationResponseDto;
import com.bring_up.bringup.company.dto.ValidationRequestInfo;
import com.bring_up.bringup.company.exception.MemberException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static com.bring_up.bringup.company.domain.enums.MemberErrorCode.BUSINESS_VALIDATE_ERROR;

@Service
@ComponentScan(basePackages={"config"})
public class VerificationService {
    @Value("${vendor.validURL}")
    private String url;

    @Value("${vendor.serviceKey}")
    private String key;

    // WebClient 인스턴스 생성
    private WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public boolean verifyCompanyInfo(ValidationRequestDto requestDto) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url + "/validate")
                .queryParam("serviceKey", key)
                .build(true).toUri(); // encoded:true -> 이중 인코딩 방지

        ValidationRequestInfo requestInfo = ValidationRequestInfo.from(requestDto);

        ValidationResponseDto response = getWebClient().post()
                .uri(uri)
                .bodyValue(Map.of("businesses", List.of(requestInfo)))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    throw new MemberException(BUSINESS_VALIDATE_ERROR);
                })
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                    throw new MemberException(BUSINESS_VALIDATE_ERROR);
                })
                .bodyToMono(ValidationResponseDto.class)
                .block(); // 동기적

        System.out.println("Request Body: " + response);

        if (response != null && response.data() != null && !response.data().isEmpty()) {
            return response.data().get(0).valid().equals("01");
        } else {
            // 알 수 없는 요인에 의해 실패한 요청
            throw new MemberException(BUSINESS_VALIDATE_ERROR);
        }
    }
}
