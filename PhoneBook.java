import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class PhoneBook {
   private HashMap<String, List<String>> phoneBook=new HashMap<>();
   public void add(String name, String number) {
    if(!phoneBook.containsKey(name)) {
        phoneBook.put(name, new ArrayList<>());
    }
    phoneBook.get(name).add(number);
   }
    public void get(String name) {
        if(phoneBook.containsKey(name)) {
            System.out.println("Телефоны "+name+": "+phoneBook.get(name));
        } else {
            System.out.println("В справочнике нет записи для фамилии: "+name);
        }
    }
}
