package home;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main
{
    public static void main( String[] args )
    {
        Person person1 = new Person("David", "Backhem", 50);
        Person person2 = new Person("Mark", "Gausovich");
        Person person3 = new Person("Sam");
        Person person4 = new Person("Sam");

        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        System.out.println(finderName(person4.firstName, people));
        fullCorrect(people);
        toHachCode(people);

        String jsonFileName = "people.json";
        saveToJsonFile(people, jsonFileName);
        System.out.println("Данные сохранены в файл " + jsonFileName);

        // Десериализация из JSON файла
        Person[] deserializedPeople = loadFromJsonFile(jsonFileName);
        System.out.println("\nДесериализованный массив из файла:");
        Arrays.stream(deserializedPeople)
                .forEach(person -> System.out.println(person.firstName + " " + person.lastName + " " + person.age));

    }
    //Провека одиковых имен org.apache.commons.lang3.StringUtils
    public static String finderName(String name, ArrayList<Person> base){
        System.out.println("Провека одиковых имен");
        String aim = " В базе нет";
        for (Person p: base){
            if(StringUtils.equals(name, p.firstName)){
                System.out.println(name + " В базе есть человек с таким именем " );
                aim = name;
            }
        }
        return aim;
    }
    // Проверка заполнения
    public static void fullCorrect(ArrayList<Person> people){
        int count = 1;
        // Проверка заполнения данных с использованием org.apache.commons.lang3.StringUtils
        System.out.println();
        System.out.println("Проверка заполнения данных");
        for (Person person: people){
            System.out.println("Имя добавлено? " + count + " Персона " + StringUtils.isEmpty(person.firstName));
            System.out.println("Фамилия добавлена? " + count + " Персона "+ StringUtils.isEmpty(person.lastName));
        }

    }
    // Person в хэшкод
    public static void  toHachCode(ArrayList<Person> people){
        System.out.println();
        System.out.println("Хэш коды всех Person");
        for (Person person: people){
            int hach = person.hashCode();
            System.out.println(hach);
        }
        {
        }
    }
    public static void saveToJsonFile(ArrayList<Person> people, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(people, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Десериализация из JSON файла
    public static Person[] loadFromJsonFile(String fileName) {
        Gson gson = new Gson();
        Person[] deserializedPeople = new Person[0];
        try (FileReader reader = new FileReader(fileName)) {
            deserializedPeople = gson.fromJson(reader, Person[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deserializedPeople;
    }
}
