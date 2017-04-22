package edu.infsci2560.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.infsci2560.models.User;



	public interface UserRepository extends PagingAndSortingRepository<User, Long> {}

