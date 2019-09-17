package com.sid.Controller;

import com.sid.Dao.TaskRepository;
import com.sid.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TestRestController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> ListTask(){
        return taskRepository.findAll();
    }
    @PostMapping("/tasks")
    public Task Save (@RequestBody Task task){
        return taskRepository.save(task);
    }


}
