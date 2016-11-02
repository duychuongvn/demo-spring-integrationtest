package com.github.duychuongvn;

import com.github.duychuongvn.dto.UserDto;
import com.github.duychuongvn.exception.UserNotFoundException;
import com.github.duychuongvn.user.dao.entity.User;
import com.github.duychuongvn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {

        try {
            User user = userService.findById(id);
            UserDto userDto = new UserDto();
            userDto.setUsername(user.getUsername());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setId(user.getId());
            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("User Not Found", HttpStatus.BAD_REQUEST);
        }

    }
}