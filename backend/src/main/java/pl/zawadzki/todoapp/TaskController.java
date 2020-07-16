package pl.zawadzki.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zawadzki.todoapp.pojo.Task;
import pl.zawadzki.todoapp.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        taskRepository.save(new Task("Default","Default task"));
    }

    @GetMapping("/all")
    public Iterable<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @PostMapping("/add")
    public Task saveTask(@RequestBody Task task){
        return taskRepository.save(task);
    }
}
