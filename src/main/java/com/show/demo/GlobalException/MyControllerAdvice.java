package com.show.demo.GlobalException;

import com.show.demo.Exceptions.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* GLOBAL EXCEPTION HANDLING

so instead of defining try catch blocks in each API we can define the exceptions like this
by creating global exceptions with the help of @ControllerAdvice annotation.

*/

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> emptyInput(EmptyInputException exception){
        String msg = "Input fields are empty";
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }
}
