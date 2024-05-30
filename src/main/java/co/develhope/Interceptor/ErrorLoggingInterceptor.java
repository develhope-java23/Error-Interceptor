package co.develhope.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ErrorLoggingInterceptor implements HandlerInterceptor {

    @Autowired
    private ErrorService service;
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(response.getStatus()==HttpServletResponse.SC_BAD_REQUEST){
            Error error = new Error();
            error.setStatusCode(response.getStatus());
            error.setDescription(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            service.createError(error);
        }
    }
}
