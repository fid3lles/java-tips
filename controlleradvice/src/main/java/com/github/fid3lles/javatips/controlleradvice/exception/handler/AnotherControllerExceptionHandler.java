package com.github.fid3lles.javatips.controlleradvice.exception.handler;

import com.github.fid3lles.javatips.controlleradvice.controller.AnotherController;
import com.github.fid3lles.javatips.controlleradvice.dto.DefaultMessageDTO;
import com.github.fid3lles.javatips.controlleradvice.exception.MyCustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = { AnotherController.class })
public class AnotherControllerExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<DefaultMessageDTO> myCustomExceptionHandler(MyCustomException e) {

        DefaultMessageDTO responseObject = new DefaultMessageDTO(
                "[AnotherControllerHandler] " + e.getMessage() + " <-- it's a lazy class =)",
                e.getClass().getName()
        );

        return ResponseEntity.accepted().body(responseObject);
    }

}
