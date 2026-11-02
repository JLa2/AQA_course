public class Bowl {
    private int food;

    public Bowl(int initialFood) {
        this.food = initialFood;
    }

    public void addFood(int amount) {
        this.food += amount;
        System.out.println("В миску добавили " + amount + " еды. Теперь там " + this.food);
    }

    public int getFood() {
        return this.food;
    }

    public void setFood(int food) {
        this.food = food;
    }

}
