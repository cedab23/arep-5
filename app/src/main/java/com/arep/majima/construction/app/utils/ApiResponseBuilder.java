package com.arep.majima.construction.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.arep.majima.construction.app.model.dto.BaseApiResponse;

@Component
public class ApiResponseBuilder {
    public <T> ResponseEntity<BaseApiResponse<T>>  success(T data, String message) {
        return ResponseEntity.ok().body(new BaseApiResponse<T>(message, data));
    }

    public <T> ResponseEntity<BaseApiResponse<T>> created(T data, String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseApiResponse<T>(message, data));
    }

    public <T> ResponseEntity<BaseApiResponse<T>> accepted(T data, String message) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BaseApiResponse<T>(message, data));
    }

    public <T> ResponseEntity<BaseApiResponse<T>> badRequest(T data, String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseApiResponse<T>(message, data));
    }

    public <T> ResponseEntity<BaseApiResponse<T>> notFound(T data, String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseApiResponse<T>(message, data));
    }

    public <T> ResponseEntity<BaseApiResponse<T>> internalServerError(T data, String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseApiResponse<T>(message, data));
    }

    public <T> ResponseEntity<BaseApiResponse<T>> forbidden(T data, String message) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new BaseApiResponse<T>(message, data));
    }
}