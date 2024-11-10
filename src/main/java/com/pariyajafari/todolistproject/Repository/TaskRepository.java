package com.pariyajafari.todolistproject.Repository;

import com.pariyajafari.todolistproject.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
