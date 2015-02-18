package br.com.maltempi.learningspring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.maltempi.learningspring.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

    public List<Todo> findByDoneOrderByDoneAsc(Date done);
    
    public List<Todo> findByDoneBetween(Date dateFrom, Date dateTo);
}
