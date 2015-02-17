package br.com.maltempi.learningspring.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.maltempi.learningspring.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
