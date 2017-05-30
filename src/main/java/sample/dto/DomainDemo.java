package sample.dto;

import lombok.Value;
import sample.doma.domain.GroupId;

import javax.validation.constraints.NotNull;

/**
 * Created by chibana on 2017/05/30.
 */
@Value
public class DomainDemo {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private GroupId groupId;
}
