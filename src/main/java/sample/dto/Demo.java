package sample.dto;

import lombok.Value;
import sample.validator.Fkey;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by chibana on 2017/05/26.
 */
@Value
public class Demo {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Fkey(table = "groups")
    private Integer groupId;
}
