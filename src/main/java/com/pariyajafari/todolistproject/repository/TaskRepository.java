package com.pariyajafari.todolistproject.repository;

import com.pariyajafari.todolistproject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT t FROM Task t order by deadLine" , nativeQuery = true)
    List<Task> findAllSortedByDeadline();

    @Query(value = "SELECT t FROM Task t order by name" , nativeQuery = true)
    List<Task> findAllSortedByName();

}
