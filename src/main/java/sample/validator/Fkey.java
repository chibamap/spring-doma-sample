package sample.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by chibana on 2017/05/26.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {Fkey.FkeyValidator.class})
public @interface Fkey {
    String table();
    String message() default "illegal f-key";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class FkeyValidator implements ConstraintValidator<Fkey, Object> {

        @Autowired
        JdbcTemplate jdbcTemplate;

        String tableName;

        @Override
        public void initialize(Fkey fkey) {
            tableName = fkey.table();
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            String query = String.format("select count(*) from %s where id = ?", tableName);
            int count = jdbcTemplate.queryForObject(query,
                    new Object[]{ value }, Integer.class);
            return 0 < count;
        }
    }
}

