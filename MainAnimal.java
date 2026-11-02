public class MainAnimal {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(30);
        Dog dog1 = new Dog("Штрудель");
        dog1.run(400);
        dog1.run(600);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Рик Санчез");
        cats[1] = new Cat("Карамелька");
        cats[2] = new Cat("Морти");
        cats[0].eat(bowl, 5);
        cats[1].eat(bowl, 10);
        cats[2].eat(bowl, 20);
        System.out.println("СТАТУС КОТОВ");
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + cats[i].name + " сыт? " + cats[i].isSatiety());
        }
        bowl.addFood(10);
        System.out.println("СТАТИСТИКА");
        System.out.println("Всего животных: " + Animal.countAnimals);
        System.out.println("Всего собак: " + Dog.countDogs);
        System.out.println("Всего котов: " + Cat.countCats);
    }
}
