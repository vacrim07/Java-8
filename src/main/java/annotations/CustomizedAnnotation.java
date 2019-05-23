package annotations;

public @interface CustomizedAnnotation  {

    String name();
    boolean enabled() default true;
}
