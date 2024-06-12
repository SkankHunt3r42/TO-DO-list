package main.code.source.excHandler;

import main.code.source.excHandler.exception.TaskNotFoundExc;
import main.code.source.excHandler.exception_response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> response(TaskNotFoundExc exc){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage(exc.getMessage());
        exceptionResponse.setDate(new Date());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }
}
