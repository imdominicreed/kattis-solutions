import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.*;

public class PizzaHawaii {
    public static void main(String[] args) {
        TreeMap<String, Pizza> pizzas = new TreeMap<>();
        TreeMap<String, Food> foods = new TreeMap<>();
        ArrayList<String> eFoods = new ArrayList<>();
        ArrayList<String> fFoods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();

        for (int a = 0; a < numTest; a++) {
            int numPizza = scanner.nextInt();
            foods.clear();
            pizzas.clear();
            for (int i = 0; i < numPizza; i++) {
                String pizza = scanner.next();
                pizzas.putIfAbsent(pizza, new Pizza());
                eFoods.clear();
                fFoods.clear();
                int toppings = scanner.nextInt();


                for (int j = 0; j < toppings; j++) {
                    String word = scanner.next();
                    if (!foods.containsKey(word)) {
                        foods.putIfAbsent(word, new Food(word));
                    }
                    pizzas.get(pizza).addFrenchFood(word);
                }
                toppings = scanner.nextInt();
                for (int j = 0; j < toppings; j++) {
                    String words = scanner.next();
                    pizzas.get(pizza).addEnglishFood(words);
                }
                for (String foodName : pizzas.get(pizza).getFrenchFood()) {
                    foods.get(foodName).addFoods(pizzas.get(pizza).getEnglishFood());
                }

            }
            for (Pizza pizza : pizzas.values()) {
                for (String food : foods.keySet()) {
                    if (!pizza.getFrenchFood().contains(food)) {
                        foods.get(food).removeAll(pizza.getEnglishFood());
                    }
                }

            }
            for (String food : foods.keySet()) {
                foods.get(food).print();
            }
        }
        }
    }
class Pizza{
    ArrayList<String> englishFood;
    ArrayList<String> frenchFood;
    Pizza(){
        englishFood = new ArrayList<>();
        frenchFood = new ArrayList<>();
    }
    public void addEnglishFood(String name) {
        englishFood.add(name);
    }
    public void addFrenchFood(String name) {
        frenchFood.add(name);

    }
    public  ArrayList<String> getEnglishFood() {
        return this.englishFood;
    }
    public ArrayList<String> getFrenchFood() {
        return this.frenchFood;
    }
}
class Food{
    String foodName;
    ArrayList<String> foodList;
    boolean isFirstList;
    Food(String name){
        isFirstList = true;
        foodList = new ArrayList<>();
        this.foodName = name;
    }
    public void removeAll(ArrayList<String> foods) {
        foodList.removeAll(foods);
    }
    public void print() {
        Collections.sort(foodList);
        for (String food: foodList) {
            System.out.println("(" + foodName + ", "  +  food + ")");
        }

    }

    public void addFoods(ArrayList<String> names) {
        if (isFirstList) {
            foodList.addAll(names);
            isFirstList = false;
            return;
        }
        ArrayList<String>  toRemove = new ArrayList<>();
        for (String name : foodList ) {
            if(!names.contains(name)){
                toRemove.add(name);
            }
        }
        foodList.removeAll(toRemove);
    }
}

