package edu.infsci2560.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infsci2560.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	Post findFirstByOrderByPostedOnDesc();
	
	List<Post> findAllByOrderByPostedOnDesc();

	Post findBySlug(String slug);

	List<Post> findAllByAuthorIdOrderByPostedOnDesc(Long id);

}
