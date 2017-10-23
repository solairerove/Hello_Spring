package lych.helloworld.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenDto implements Serializable {
    private static final long serialVersionUID = 2452438548348510783L;

    private String token;
}
