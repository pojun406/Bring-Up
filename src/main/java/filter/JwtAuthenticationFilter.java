package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
    private String parseBearerToken(HttpServletRequest request){

        String authorization = request.getHeader("Authorization");

        boolean hasAuthorization = StringUtils.hasText(authorization); // hasText가 null / 공백 / whitespace가 있으면 false반환 그렇지 않으면 true 반환

        if(!hasAuthorization) return null;

        boolean isBearer = authorization.startsWith("Bearer "); //startsWith: 시작하는문자 확인 return boolean
        if(!isBearer) return null;

        String token = authorization.substring(7);
        return token;
    }
}
