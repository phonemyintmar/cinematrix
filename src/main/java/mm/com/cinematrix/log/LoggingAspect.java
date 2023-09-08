package mm.com.cinematrix.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Around("@annotation(loggable) || @within(loggable)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
        if ("DETAILS".equals(loggable.mode())) {
            return logWithDetails(joinPoint);
        } else {
            return logOnlyUrl(joinPoint);
        }
    }

    private Object logWithDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();

        long total = System.nanoTime() - start;
        logRequestInfo(joinPoint);
        logResponseInfo(result);

        logTotalTimeInfo(total);

        return result;
    }

    private Object logOnlyUrl(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();

        stopWatch.stop();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("Request URL: {}", request.getRequestURI());
        logTotalTimeInfo(stopWatch.getTotalTimeMillis());

        return result;
    }


    private void logRequestInfo(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("Request Info:");
        log.info("Endpoint: {}", request.getRequestURI());
        log.info("Headers: {}", getHeaders(request));
    }

    private void logResponseInfo(Object result) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();

        log.info("Response Info:");
        log.info("Response: {}", result);
        log.info("Response Headers: {}", getHeaders(response));
    }

    private void logTotalTimeInfo(long totalTimeMillis) {
        log.info("Total Time: " + totalTimeMillis + " ms");
    }

    // this will not show spring default added headers, but ae tr ka ya pr tl
    private String getHeaders(HttpServletRequest request) {
        StringBuilder headers = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.append(headerName).append(": ").append(headerValue).append("; ");
        }
        return headers.toString();
    }

    private String getHeaders(HttpServletResponse response) {
        StringBuilder headers = new StringBuilder();
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            String headerValue = response.getHeader(headerName);
            headers.append(headerName).append(": ").append(headerValue).append("; ");
        }
        return headers.toString();
    }
}