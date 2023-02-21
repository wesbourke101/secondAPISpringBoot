package com.in28minutes.springboot.myFirstWebApp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("Wes");
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    //GET, POST
    @RequestMapping(value="add-todo", method=RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        Todo todo = new Todo(0, username, "",LocalDate.now(), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method=RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, Todo todo) {
        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(),
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todos"; // do not use the jsp here when you redirect use the url.
    }

}
