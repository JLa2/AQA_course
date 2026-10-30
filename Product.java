public class Product {
    private String name;
    private String prodDate;
    private String manufacturer;
    private String origin;
    private int price;
    private boolean status;
    public Product(String name, String prodDate, String manufacturer, String origin, int price, boolean status) {
        this.name=name;
        this.prodDate=prodDate;
        this.manufacturer=manufacturer;
        this.origin=origin;
        this.price=price;
        this.status=status;
    }
    public void printInfo() {
System.out.println("Название: "+name);
System.out.println("Дата производства: "+prodDate);
System.out.println("Производитель: "+manufacturer);
System.out.println("Страна происхождения: "+origin);
System.out.println("Цена: "+price);
System.out.println("Состояние бронирования покупателем: "+status);
    }
}
