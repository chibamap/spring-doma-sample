package sample.doma.entity;

import lombok.Data;
import org.seasar.doma.*;
import sample.doma.domain.GroupId;
import sample.validator.Fkey;

import javax.validation.constraints.NotNull;

/**
 * Created by chibana on 2017/05/29.
 */
@Entity
@Table(name = "person")
@Data
public class SafePerson {
    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    /**  */
    @NotNull
    @Column(name = "first_name")
    String firstName;

    /**  */
    @NotNull
    @Column(name = "last_name")
    String lastName;

    /**  */
    @Fkey(table = "groups")
    @Column(name = "group_id")
    GroupId groupId;
}
