package main.code.source.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.code.source.dao.TasksEntRepo;
import main.code.source.entity.TasksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksServiceImp implements TasksService {

    private final TasksEntRepo TaskDao;
    private final EntityManager  TaskManager;

    @Autowired
    public TasksServiceImp(TasksEntRepo dao, EntityManager Manager) {
        this.TaskDao = dao;
        this.TaskManager = Manager;
    }

    @Override
    public List<TasksEntity> findAll() {
        List<TasksEntity> list = TaskDao.findAll();
        return list;
    }

    @Override
    public TasksEntity findById(int Id) {
        Optional<TasksEntity> result = TaskDao.findById(Id);

        TasksEntity tasks = null;

        if (result.isPresent()) {
            tasks = result.get();
        }
        return tasks;
    }

    @Override
    public List<TasksEntity> findByPriority(String InputPriority) {
        TypedQuery<TasksEntity> typedQuery = TaskManager.createQuery("FROM TasksEntity  WHERE priority = :InputPriority", TasksEntity.class);
        typedQuery.setParameter("InputPriority", InputPriority);
        return typedQuery.getResultList();
    }

    @Override
    public TasksEntity save(TasksEntity tasksEntity) {
        TasksEntity entity = TaskDao.save(tasksEntity);


        return entity;
    }
    @Override
    public void deleteTask(int Id) {
        TaskDao.deleteById(Id);
    }
}
