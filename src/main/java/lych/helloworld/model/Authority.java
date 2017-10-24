package lych.helloworld.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
@Entity
@Data
public class Authority implements GrantedAuthority{

    private static final long serialVersionUID = 6017089805246601319L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment1")
    @GenericGenerator(name = "increment1", strategy = "increment")
    private Integer id;

    private String role;

    @Column(name = "user_id")
    private Integer userId;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
