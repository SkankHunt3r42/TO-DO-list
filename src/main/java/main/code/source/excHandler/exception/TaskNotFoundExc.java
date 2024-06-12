package main.code.source.excHandler.exception;

public class TaskNotFoundExc extends RuntimeException{
    public TaskNotFoundExc(String message) {
        super(message);
    }
}
