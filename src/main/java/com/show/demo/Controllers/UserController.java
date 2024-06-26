package com.show.demo.Controllers;

import com.show.demo.DTOs.RequestDto.UserDto;
import com.show.demo.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /* now each class has separate instance that's why we're defining PRIVATE
    * and we want only single instance of this logger that's why used STATIC FINAL */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        try {
           String result=userService.addUser(userDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            logger.error("User not able to add {}",userDto.getName(), e); // use placeholder
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getOldestUser")
    public ResponseEntity<?> getOldestUser(){
        try {
            UserDto userDto=userService.getOldestUser();
            return new ResponseEntity<>(userDto,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/userGreaterThanAge/{age}")
    public ResponseEntity<List<UserDto>> userGreaterThanAge(@PathVariable Integer age){
        List<UserDto> userDtos=userService.userGreaterThanAge(age);
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }
}
