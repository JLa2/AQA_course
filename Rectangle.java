public class Rectangle implements Shape {
    double a;
    double b;
    String fillColor;
    String borderColor;
    public Rectangle(double a, double b, String fillColor, String borderColor) {
        this.a=a;
        this.b=b;
        this.fillColor=fillColor;
        this.borderColor=borderColor;
    }
@Override 
public double getPerimeter() {
    return (2*(a+b));
}
@Override 
public double getArea() {
    return a*b;
}
@Override 
public String getFillColor() {
    return fillColor;
}
@Override 
public String getBorderColor() {
    return borderColor;
}
    
}
