public class Main {


    public static void main(String[] args) {

        Cat cat1 = new Cat("Alex");
        cat1.setFavFood("Fish");
        cat1.setAge(5);

        Cat cat2 = new Cat("Jake");
        cat2.setFavFood("Chicken");
        cat2.getFavFood();
        System.out.println(cat2.getAge());

        Cat[] cats = new Cat[2];

        cats[0] = cat1;
        cats[1] = cat2;
    }
}