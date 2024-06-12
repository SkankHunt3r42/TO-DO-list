package main.code.source.excHandler.exception_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private int statusCode;
    private String message;
    private Date date;
}
