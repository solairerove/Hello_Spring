package lych.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lych.helloworld.dto.TokenDto;
import lych.helloworld.dto.UserDto;
import lych.helloworld.security.service.DefaultTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final DefaultTokenService tokenService;

    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody final UserDto userDto) throws Exception {
        final String token = tokenService.getToken(userDto.getUsername(), userDto.getPassword());
        if (token != null) {
            final TokenDto response = new TokenDto();
            response.setToken(token);
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No att");
        }
    }
}
