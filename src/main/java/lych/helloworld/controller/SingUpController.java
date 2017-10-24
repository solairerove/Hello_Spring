package lych.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lych.helloworld.converter.UserDtoConverter;
import lych.helloworld.dto.UserDto;
import lych.helloworld.service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SingUpController {

    private final DefaultUserService defaultUserService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody final UserDto dto) {

        UserDtoConverter userDtoConverter = new UserDtoConverter();

        return ResponseEntity.ok().body(defaultUserService.addUser(userDtoConverter.convert(dto)));
    }
}
