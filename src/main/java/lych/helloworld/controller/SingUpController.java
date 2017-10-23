package lych.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lych.helloworld.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SingUpController {

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserDto dto)
    {


        return ResponseEntity.ok().body("ff");
    }
}
