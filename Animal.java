public class Animal {
    protected String name;
    public static int countAnimals = 0;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м. ");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м. ");
    }

}
