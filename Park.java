public class Park {
    class Attraction {
        private String info;
        private String time;
        private int price;

        public Attraction(String info, String time, int price) {
            this.info = info;
            this.time = time;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Информация: " + info);
            System.out.println("Время работы: " + time);
            System.out.println("Стоимость: " + price);
        }
    }
}