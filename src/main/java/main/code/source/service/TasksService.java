package main.code.source.service;

import main.code.source.entity.TasksEntity;

import java.util.List;
import java.util.Optional;

public interface TasksService {
    List<TasksEntity> findAll();
    TasksEntity findById(int Id);
    List<TasksEntity> findByPriority(String priority);
    TasksEntity save(TasksEntity tasksEntity);
    void deleteTask(int Id);
}
