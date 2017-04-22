package edu.infsci2560.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.infsci2560.models.User;
import edu.infsci2560.repositories.UserRepository;

@RestController
@RequestMapping("/accounts")
public class UserService {

   @Autowired
   private UserRepository repository;

   @RequestMapping(method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<Iterable<User>> list() {
       HttpHeaders headers = new HttpHeaders();
       return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<User> list(@PathVariable("id") Long id) {
       HttpHeaders headers = new HttpHeaders();
       return new ResponseEntity<>(repository.findOne(id), headers, HttpStatus.OK);
   }
}