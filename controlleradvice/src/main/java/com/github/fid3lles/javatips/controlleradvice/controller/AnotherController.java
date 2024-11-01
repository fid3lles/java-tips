package com.github.fid3lles.javatips.controlleradvice.controller;

import com.github.fid3lles.javatips.controlleradvice.exception.MyCustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/another-controller")
public class AnotherController {

    @GetMapping("/custom-error")
    public ResponseEntity<?> myCustomException() {
        throw new MyCustomException("I don't feel like working today");
    }

}
