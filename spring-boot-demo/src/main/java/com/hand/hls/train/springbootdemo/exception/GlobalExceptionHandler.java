package com.hand.hls.train.springbootdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.stream.Collectors;

/**
 * <p>
 * description
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2019/12/05 13:48
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        log.error("method argument not valid: {}", exception.getMessage());
        String errorMessage = "field error";

        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult.hasErrors()) {
            errorMessage = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining(" | "));
        }

        return errorMessage;
    }


}
