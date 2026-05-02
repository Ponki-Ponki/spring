public class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Mastif", "big", 4, 16.5f );

        Dog dog2 = new Dog("lapdog", "small", 3, 2.5f );
        dog1.getInfo();

        int calories;
        String result;
        calories = dog1.eat(40,50,30);
        result = dog1.checkCalories(calories);

        System.out.println(result);

        calories = dog2.eat(6,6,8);
        result = dog2.checkCalories(calories);

        System.out.println(result);
    }

}
class Dog{
    String breed;
    String size;
    int age;
    float weight = 5;
    Dog(String breed, String size, int age, float weight){
        this.age=age;
        this.breed =breed;
        this.size=size;
        this.weight=weight;
    }

    String checkCalories(int calories){
        float normalCal = ((float) 535 /10)*weight;
        if(calories - normalCal > 30) return "overate";
        else if(Math.abs(calories -normalCal) <= 30) return "good";
        else return "bad";
    }
    int eat(int carbohydrates, int proteins, int fats){
        return (carbohydrates*4) + (proteins*4) + (fats*9);

    }
    void getInfo(){
        System.out.println("breed:" + breed + ", size:" + size + ", age:" + age);
    }
}