public class LessonThree {
    public static void main(String[]args) {
        Product[]productsArr=new Product[5];
        productsArr[0]=new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArr[1]=new Product("IPhone 16 Pro", "15.09.2024", "Apple inc.", "USA", 6200, false);
        productsArr[2]=new Product("Xiaomi 14", "10.11.2023", "Xiaomi Corporation", "China", 3500, true);
        productsArr[3]=new Product("MacBook Air M3", "05.03.2024", "Apple inc.", "Vietnam", 7800, false);
        productsArr[4]=new Product("Sony PlayStation 5", "20.10.2023", "Sony Interactive", "Japan", 4200, true);
        productsArr[0].printInfo();
        productsArr[1].printInfo();
        productsArr[2].printInfo();
        productsArr[3].printInfo();
        productsArr[4].printInfo();
    }
    
}
