package com.github.fid3lles.javatips.controlleradvice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/default-controller")
public class DefaultController {

    @GetMapping("/no-elements")
    public ResponseEntity<?> nullPointerException(){
        throw new NoSuchElementException("No elements found at database");
    }

    @GetMapping("/wrong-calculation")
    public ResponseEntity<?> arithmeticException(){
        throw new ArithmeticException("No elements found at database");
    }

}
