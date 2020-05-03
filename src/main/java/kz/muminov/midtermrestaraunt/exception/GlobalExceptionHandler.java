package kz.muminov.midtermrestaraunt.exception;

import kz.muminov.midtermrestaraunt.exception.response.ErrorResponse;
import kz.muminov.midtermrestaraunt.exception.types.MealNotFoundException;
import kz.muminov.midtermrestaraunt.exception.types.OrderNotFoundException;
import kz.muminov.midtermrestaraunt.exception.types.RoleNotFoundException;
import kz.muminov.midtermrestaraunt.exception.types.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException e){
        log.error("Exception:" +  e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MealNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMealNotFoundException(MealNotFoundException e){
        log.error("Exception: " + e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
        log.error("Exception: " + e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(RoleNotFoundException e){
        log.error("Exception: " + e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
