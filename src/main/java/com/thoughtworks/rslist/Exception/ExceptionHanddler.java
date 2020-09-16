package com.thoughtworks.rslist.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHanddler {

    @ExceptionHandler({IndexOutOfBoundsException.class, MyException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<CommonError> handleIndexOutOfBoundsException(Exception ex) {
        if (ex instanceof IndexOutOfBoundsException) {
            CommonError commonError = new CommonError();
            commonError.setError("invalid request param");
            return ResponseEntity.status(400).body(commonError);
        }
//        if (ex instanceof MyException){
//            CommonError commonError = new CommonError();
//            commonError.setError("invalid index");
//            return ResponseEntity.status(400).body(commonError);
//        }
        if (ex instanceof MethodArgumentNotValidException){
            CommonError commonError = new CommonError();
            commonError.setError("invalid param");
            return ResponseEntity.status(400).body(commonError);
        }
        CommonError commonError = new CommonError();
        commonError.setError("invalid index");
        return ResponseEntity.status(400).body(commonError);
    }

}

