package methodReference;

@FunctionalInterface
public interface IPerson {

    Person create(Integer id, String name);
}
