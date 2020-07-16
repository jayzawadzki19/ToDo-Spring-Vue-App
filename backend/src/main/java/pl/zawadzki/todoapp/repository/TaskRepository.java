package pl.zawadzki.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zawadzki.todoapp.pojo.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
