package com.zachlop.checkom.checkpol.controller;

import com.zachlop.checkom.checkpol.persistance.entity.Customer;
import com.zachlop.checkom.checkpol.persistance.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class PramController {
    private static final Logger logger = LoggerFactory.getLogger(PramController.class);
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/check")
    public String checkStatus() {
        logger.info("🟢 SUCCESS: Someone just visited the /hello endpoint!");
        return "Application is up";
    }


    @GetMapping("/add")
    public String addTask(@RequestParam String desc) {
        Customer task = new Customer();
        task.setDescription(desc);

        taskRepository.save(task);

        logger.info("💾 Saved to Database: " + desc);
        return "Task saved to Postgres: " + desc;
    }

    @GetMapping("/tasks")
    public List<Customer> getTasks() {
        return taskRepository.findAll();
    }
//    @GetMapping("/tasks/{id}")
//    public List<Customer> getTasksById() {
//        return taskRepository.findAll();
//    }
}
