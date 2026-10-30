public class MyPark {
    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "10:00-22:00", 500);
        ferrisWheel.printInfo();
    }

}
