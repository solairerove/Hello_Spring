package lych.helloworld.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable{

    private static final long serialVersionUID = 2827027321627375561L;
    private String username;

    private String password;
}
