public class MainPhoneBook {
    public static void main(String[]args) {
        PhoneBook book=new PhoneBook();
        book.add("Rick Sanchez", "111-22-33");
        book.add("Peter Griffin", "444-55-66");
        book.add("Rick Sanchez", "999-88-77");
        book.add("Rick Sanchez", "000-00-00");
        System.out.println("Телефоны добавлены");
    book.get("Rick Sanchez");
    book.get("Peter Griffin");
    book.get("Morty Smith");
}
}