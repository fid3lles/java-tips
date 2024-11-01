package com.github.fid3lles.javatips.controlleradvice.exception.handler;

import com.github.fid3lles.javatips.controlleradvice.controller.DefaultController;
import com.github.fid3lles.javatips.controlleradvice.dto.DefaultMessageDTO;
import com.github.fid3lles.javatips.controlleradvice.exception.MyCustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice(assignableTypes = { DefaultController.class })
public class DefaultControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementExceptionHandler() {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<DefaultMessageDTO> nullPointerExceptionHandler(ArithmeticException e) {

        DefaultMessageDTO responseObject = new DefaultMessageDTO(
                e.getMessage(),
                e.getClass().getName()
        );

        return ResponseEntity.accepted().body(responseObject);
    }

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<DefaultMessageDTO> myCustomExceptionHandler(MyCustomException e) {

        DefaultMessageDTO responseObject = new DefaultMessageDTO(
                "[DefaultControllerHandler] " + e.getMessage() + " <-- it's a lazy class =)",
                e.getClass().getName()
        );

        return ResponseEntity.accepted().body(responseObject);
    }

}
