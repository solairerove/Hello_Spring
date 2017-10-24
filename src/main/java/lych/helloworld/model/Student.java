package lych.helloworld.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students")
@Data
public class Student implements Persistable<Integer> {

    private static final long serialVersionUID = -1865211746167974108L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer Id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Override
    public boolean isNew() {
        return Objects.nonNull(Id);
    }
}
