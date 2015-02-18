package br.com.maltempi.learningspring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maltempi.learningspring.entity.Todo;
import br.com.maltempi.learningspring.repository.TodoRepository;

@Service
@Transactional
public class InitJustForTest {

    @Autowired
    TodoRepository todoRepo;

    @PostConstruct
    public void init() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Todo todo = new Todo();

        todo.setWhat("Study Spring Data");
        todo.setToWhen(sdf.parse("27/01/2015"));
        todo.setDone(sdf.parse("27/01/2015"));
        
        Todo todo2 = new Todo();
        todo2.setWhat("create a project with spring");
        todo2.setToWhen(sdf.parse("27/01/2015"));

        Todo todo3 = new Todo();
        todo3.setWhat("write a blog post about spring data");
        todo3.setToWhen(sdf.parse("28/01/2015"));

        List<Todo> todoList = new ArrayList<Todo>();
        todoList.add(todo);
        todoList.add(todo2);
        todoList.add(todo3);

        todoRepo.save(todoList);

        System.out.println("-------------------------");
        System.out.println("------My TODO List-------");
        System.out.println("-------------------------");

        for (Todo t : todoRepo.findAll()) {
            System.out.println(">> what >> " + t.getWhat());
            System.out.println(">> when >> " + t.getToWhen());
            System.out.println(">> done? >> "
                    + (t.getDone() == null ? "No" : "Yes"));
            System.out.println(">> when i done? >> " + t.getDone());
            System.out.println("-------------------------");
        }
        
        System.out.println("------------------------------------------------");
        System.out.println("------My TODO List released in 28/01/2015-------");
        System.out.println("------------------------------------------------");
        
        for (Todo t : todoRepo.findByDoneOrderByDoneAsc(sdf.parse("27/01/2015"))) {
            System.out.println(">> what >> " + t.getWhat());
            System.out.println(">> when >> " + t.getToWhen());
            System.out.println(">> done? >> "
                    + (t.getDone() == null ? "No" : "Yes"));
            System.out.println(">> when i done? >> " + t.getDone());
            System.out.println("-------------------------");
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("------My TODO List released in jan of 2015 -------");
        System.out.println("--------------------------------------------------");        
        for (Todo t : todoRepo.findByDoneBetween(sdf.parse("01/01/2015"), sdf.parse("30/01/2015"))) {
            System.out.println(">> what >> " + t.getWhat());
            System.out.println(">> when >> " + t.getToWhen());
            System.out.println(">> done? >> "
                    + (t.getDone() == null ? "No" : "Yes"));
            System.out.println(">> when i done? >> " + t.getDone());
            System.out.println("-------------------------");
        }         
    }
}
