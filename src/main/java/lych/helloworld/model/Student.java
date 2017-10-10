package lych.helloworld.model;

import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "students")
@Data
public class Student implements Persistable<Integer>{

    @Id
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    public boolean isNew() {
        return Objects.nonNull(Id);
    }
}
