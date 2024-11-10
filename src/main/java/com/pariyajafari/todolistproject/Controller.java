package com.pariyajafari.todolistproject;

import com.pariyajafari.todolistproject.Model.Task;
import com.pariyajafari.todolistproject.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/task/updatestatus/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody Task updatedTask){
        Task task = taskService.updateTaskStatusById(id, updatedTask.getStatus());
        return ResponseEntity.ok(task);
    }

    @PostMapping("/addtask")
    public ResponseEntity<Task> createTask(@RequestBody Task newTask){
        Task savedTask = taskService.addTask(newTask);
        return ResponseEntity.ok(savedTask);
    }
}
