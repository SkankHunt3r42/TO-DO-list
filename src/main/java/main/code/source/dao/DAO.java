package main.code.source.dao;

import main.code.source.entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAO extends JpaRepository<TasksEntity,Integer> {
}
