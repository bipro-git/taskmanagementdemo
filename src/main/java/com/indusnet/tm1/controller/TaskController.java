package com.indusnet.tm1.controller;

import com.indusnet.tm1.model.Tasks;
import com.indusnet.tm1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;


    @PostMapping("/create")
    public String CreateNewTask(@RequestBody Tasks task) {
        taskRepository.save(task);
        return "SUCCESSFUL";
    }

    @GetMapping("/gettasks")
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tskList = new ArrayList<>();
        taskRepository.findAll().forEach(tskList::add);
        return new ResponseEntity<List<Tasks>>(tskList, HttpStatus.OK);
    }

    @GetMapping("/{taskid}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable int taskid) {
        Optional<Tasks> tsk = taskRepository.findById(taskid);
        if (tsk.isPresent()) {
            return new ResponseEntity<Tasks>(tsk.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<Tasks>(tsk.get(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{taskid}")
    public String updateTaskById(@PathVariable int taskid, @RequestBody Tasks task) {
        Optional<Tasks> tsk = taskRepository.findById(taskid);
        if (tsk.isPresent()) {
            Tasks existtask = tsk.get();
            existtask.setPid(task.getPid());
            existtask.setTask_assignment(task.getTask_assignment());
            existtask.setTask_duedate(task.getTask_duedate());
            existtask.setTask_name(task.getTask_name());
            existtask.setTask_priority(task.getTask_priority());
            existtask.setTask_description(task.getTask_description());
            taskRepository.save(existtask);
            return "Task details against id " + taskid + " updated ";
        } else return "Task with " + taskid + " does not exist.";

    }


    @DeleteMapping("/{taskid}")
    public String deleteTaskByTaskId(@PathVariable int taskid){
        taskRepository.deleteById(taskid);
        return "Task deleted successfully.";
    }
}
