package annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationsApp {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Languages {
        Language[] value() default {};
    }

    @Repeatable(value = Languages.class)
    public @interface Language{
        String value();
        String additionalData() default "annotations example";
    }

    // JDK 1.7
    //@Languages({@Language("Java"), @Language("Python")})
    // JDK 1.8
    @Language("Java") @Language("Python")
    public interface ProgrammingLanguages{
    }

    public static void main(String[] args) {
        Language[] languageArray = ProgrammingLanguages.class.getAnnotationsByType(Language.class);
        System.out.println("There are " + languageArray.length + " annotations on Languages annotation");

        Languages lenguagesNames = ProgrammingLanguages.class.getAnnotation(Languages.class);
        for (Language element : lenguagesNames.value()) {
            System.out.println(element.value());
        }
    }
}
