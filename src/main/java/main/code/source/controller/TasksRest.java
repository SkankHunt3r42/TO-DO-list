package main.code.source.controller;
import jakarta.annotation.PostConstruct;
import main.code.source.entity.TasksEntity;
import main.code.source.excHandler.exception.TaskNotFoundExc;
import main.code.source.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksRest {
    @Autowired
    private TasksService service;

    @GetMapping("/list")
    public List<TasksEntity> showListOfTasks(){
        return service.findAll();
    }
    @GetMapping("/list/{id}")
    public TasksEntity showTasks(@PathVariable int id){
        TasksEntity tasksEntity = service.findById(id);

        if(tasksEntity == null){
            throw new TaskNotFoundExc("No such task for today with id: " + id );
        }

        return tasksEntity ;
    }
    @GetMapping("/list/priority/{priority}")
    public List<TasksEntity> showAllTasksByPriority(@PathVariable String priority){
        List<TasksEntity> listOfTasks = service.findByPriority(priority);

        return listOfTasks;
    }
    @PostMapping("/list")
    public TasksEntity addTask(@RequestBody TasksEntity task){
        task.setId(0);

        TasksEntity taskToSave = service.save(task);

        return taskToSave;
    }
    @PutMapping("/list")
    public TasksEntity updateTask(@RequestBody TasksEntity task){

        TasksEntity taskToUpdate = service.save(task);

        return taskToUpdate;
    }
    @DeleteMapping("/list/{Id}")
    public String deleteTask(@PathVariable int Id){

        TasksEntity tasksEntity = service.findById(Id);

        if(tasksEntity != null){
            service.deleteTask(Id);
            return "Task with id: " + Id + " was successful deleted";
        } else {
            throw new TaskNotFoundExc("Task with id: " + Id + " are not exists");
        }

    }
}
