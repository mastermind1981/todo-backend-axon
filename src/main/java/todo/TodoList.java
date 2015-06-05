package todo;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Service;
import todo.todoitem.ToDoItem;
import todo.todoitem.ToDoItemCreatedEvent;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoList {
    private List<ToDoItem> todos;

    public TodoList() {
        todos = new ArrayList<ToDoItem>();
    }

    public List<ToDoItem> all() {
        return todos;
    }

    @EventHandler
    public void addItem(ToDoItemCreatedEvent event) {
        todos.add(new ToDoItem(event.getTodoId(), event.getDescription()));
    }
}
