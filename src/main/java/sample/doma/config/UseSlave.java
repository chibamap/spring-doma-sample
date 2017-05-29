package sample.doma.config;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by chibana on 2017/05/29.
 */
@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Repository.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type= Autowired.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR_PARAMETER,
                type = Qualifier.class, elements = "\"slaveConfig\"")

})
public @interface UseSlave {
}
