package com.greenfarm.greenfarmsystem.controller;
import com.greenfarm.greenfarmsystem.model.UserEntity;
import com.greenfarm.greenfarmsystem.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserEntity>> getAll(){
		List<UserEntity> lista = userService.findAll();
		return new ResponseEntity<List<UserEntity>>(lista, HttpStatus.OK);
	}

}
