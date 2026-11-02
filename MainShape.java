public class MainShape {
    public static void main(String[]args) {
        Circle circle=new Circle(5.0, "Красный", "Черный" );
        Rectangle rectangle=new Rectangle(3.0, 6.0, "Синий", "Белый");
        Triangle triangle=new Triangle(3.0, 4.0, 5.0, "Зелёный", "Жёлтый");
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
    
}
