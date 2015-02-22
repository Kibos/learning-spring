package br.com.maltempi.learningspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.maltempi.learningspring.entity.Todo;
import br.com.maltempi.learningspring.repository.TodoRepository;

@RestController // Configuramos esta anotação para o spring saber que ele é um rest controller
@RequestMapping(value = "todo") // Tudo que bater em /rest/todo vai vir para cá
public class TodoController {

    @Autowired
    TodoRepository todoRepo;

    /**
     * Tudo que bater em /rest/todo/ com o método GET cairá neste método.
     * @produces application/json
     * @return listagem de todos - será serializado em json pelo spring (utilizando o jackson)
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<List<Todo>> listagemTarefas() {
        List<Todo> todos = todoRepo.findAll();

        if (!todos.isEmpty()) {
            return new ResponseEntity<>(todos, HttpStatus.ACCEPTED); // 200
        } else {
            return new ResponseEntity<>(todos, HttpStatus.NO_CONTENT); // 204
        }
    }

    /**
     * Tudo que bater com o método POST, cairá neste método.
     * @param todo - na realidade é um JSON, mas o spring nos dá um objeto. =)
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED) // Como estamos tratando nenhuma exceção aqui, ele por padrão já retorna um status CREATED.
    public void incluir(@RequestBody Todo todo) {
        todoRepo.save(todo);
    }

    /**
     * Tudo que bater com o método PUT, cairá neste método
     * @param todo
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK) // Como estamos tratando nenhuma exceção aqui, ele por padrão já retorna um status OK.
    public void atualizar(@RequestBody Todo todo) {
        todoRepo.save(todo);
    }

    /**
     * Tudo que bater com o método DELETE, utilizando uma url: /delete/{$id_todo}, cairá neste método
     * @param id - é o id que será deletado. Ele é passado na url
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK) // Como estamos tratando nenhuma exceção aqui, ele por padrão já retorna um status OK.
    public void delete(@PathVariable int id) {
        todoRepo.delete(id);
    }
}
