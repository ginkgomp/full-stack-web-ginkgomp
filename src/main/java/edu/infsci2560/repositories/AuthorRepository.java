package edu.infsci2560.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.infsci2560.models.Author;



public interface AuthorRepository extends CrudRepository<Author, Long> {

	List<Author> findAllByOrderByLastNameAscFirstNameAsc();

}
