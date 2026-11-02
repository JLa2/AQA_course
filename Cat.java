public class Cat extends Animal {
    public static int countCats = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        countCats++;
        this.satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.setFood(bowl.getFood() - amount);
            this.satiety = true;
            System.out.println(name + " покушал и сыт");
        } else {
            System.out.println(name + " остался голодным, еды в миске недостаточно");
        }
    }

    public boolean isSatiety() {
        return this.satiety;
    }
}
