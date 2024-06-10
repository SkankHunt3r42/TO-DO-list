package main.code.source.rest;
import jakarta.persistence.EntityManager;
import main.code.source.entity.TasksEntity;
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
            throw new RuntimeException("No such task for today");
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
            return "Task was successful deleted";
        } else {
            throw new RuntimeException("Task with id: " + Id + " are not exists");
        }

    }
}
