package pl.zawadzki.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zawadzki.todoapp.pojo.Task;
import pl.zawadzki.todoapp.repository.TaskRepository;

import java.util.Optional;

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

    @GetMapping("byId/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> taskOp = taskRepository.findById(id);
        if(taskOp.isPresent()){
            return new ResponseEntity<>(taskOp.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public Task saveTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
