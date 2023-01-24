package com.SystemFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SystemFinal.entity.User;
import com.SystemFinal.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;	
	@RequestMapping(value = "findall",method=RequestMethod.GET, produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers ="Accept=Application/json")
	public ResponseEntity<Iterable<User>> findAll(){
	try {
		return new ResponseEntity<Iterable<User>>(userService.findAll(),HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Iterable<User>>(HttpStatus.BAD_REQUEST);
	}
}
	@RequestMapping(value = "find/{id}",method=RequestMethod.GET, produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers ="Accept=Application/json")
	public ResponseEntity<User> find(@PathVariable("id") int id){
			try {
				return new ResponseEntity<User>(userService.find(id),HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
	}	
	
	@RequestMapping(value = "create",method=RequestMethod.POST, produces= {MimeTypeUtils.APPLICATION_JSON_VALUE},consumes= {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers ="Accept=Application/json")
	public ResponseEntity<Void> create(@RequestBody User user){
			try {
				userService.create(user);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
	}
	@RequestMapping(value = "update",method=RequestMethod.PUT, produces= {MimeTypeUtils.APPLICATION_JSON_VALUE},consumes= {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers ="Accept=Application/json")
	public ResponseEntity<Void> update(@RequestBody User user){
			try {
				userService.update(user);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
	}	
	@RequestMapping(value = "delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int  id){
			try {
				userService.delete(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
	}
}
