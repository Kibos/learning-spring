package br.com.maltempi.learningspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.maltempi.learningspring.entity.Todo;
import br.com.maltempi.learningspring.repository.TodoRepository;

@RestController
@RequestMapping(value = "todo")
public class TodoController {

    @Autowired
    TodoRepository todoRepo;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Iterable<Todo> listagemTarefas() {
        return todoRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.CREATED)
    public void incluir(@RequestBody Todo todo) {

        todoRepo.save(todo);
    }

}
