package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping(path = "")
    public List<TaskDTO> index() {
        var tasks = taskRepository.findAll();
        return tasks.stream()
                .map(t -> taskMapper.map(t))
                .toList();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreateDTO taskCreateDTO) {
        var task = taskMapper.map(taskCreateDTO);
        var user = userRepository.findById(taskCreateDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("user with id " + taskCreateDTO.getAssigneeId() + " not found"));
        task.setAssignee(user);
        taskRepository.save(task);

        var taskDTO = taskMapper.map(task);
        return taskDTO;
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO show(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task with id " + id + " not found"));
        var taskDTO = taskMapper.map(task);
        return taskDTO;
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO update(@RequestBody TaskUpdateDTO taskUpdateDTO, @PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task with id " + id + " not found"));
        var user = userRepository.findById(taskUpdateDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("user with id " + taskUpdateDTO.getAssigneeId() + " not found"));

        taskMapper.update(taskUpdateDTO, task);
        task.setAssignee(user);

        taskRepository.save(task);
        var taskDTO = taskMapper.map(task);
        return taskDTO;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }


    // END
}
