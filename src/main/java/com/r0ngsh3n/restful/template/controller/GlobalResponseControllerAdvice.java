package com.r0ngsh3n.restful.template.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r0ngsh3n.restful.template.model.ObjectResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.r0ngsh3n.restful.template.controller"})
public class GlobalResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    /**
     * @param returnType
     * @param aClass
     * @return
     *
     * This method is used to check if the @RestController already return ObjectResponse, then no need to
     * wrap another layer, just return as is
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return !returnType.getGenericParameterType().equals(ObjectResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        /**
         * SPECIAL HANDLING for String: need use ObjectMapper to wrap and then output
         * to String
         */
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ObjectResponse<>(data));
            } catch (JsonProcessingException e) {
                throw new RuntimeException("some error message");
            }
        }
        return new ObjectResponse<>(data);
    }
}
