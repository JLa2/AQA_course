public class Dog extends Animal {
    public static int countDogs = 0;

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум 500 м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Максимум 10 м.");
        }
    }
}
