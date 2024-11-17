package com.pariyajafari.todolistproject.repository;

import com.pariyajafari.todolistproject.model.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t")
    List<Task> findAllTask(Sort sort);

    @Query(value = "SELECT * FROM Task t WHERE t.name like %?s" , nativeQuery = true)
    Optional<Task> findTaskByName();

}
