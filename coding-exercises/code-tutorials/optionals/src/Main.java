import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Cat> optionalCat = findCatByName("Leeroy");
        //if optional contains value RETURN, but if empty orElse will return a default
        Cat myCat = optionalCat.orElse(new Cat("UNKNOWN", 0));

    }

    private static Optional<Cat> findCatByName(String name) {

        Cat cat = new Cat(name, 3);
        return Optional.ofNullable(cat);
    }
}