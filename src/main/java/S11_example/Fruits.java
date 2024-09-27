package S11_example;

import java.util.HashMap;

public enum Fruits {
    Apple(1, "사과", 1000),
    Strawberry(2, "딸기", 1500),
    Grape(3, "포도", 3000),
    Lemon(4, "레몬", 6000);

    private final int num;
    private final int price;
    private final String name;


    private static HashMap<Integer, Fruits> FruitsBox = new HashMap<>();

    static{
        for(Fruits f : Fruits.values()){
            FruitsBox.put(f.num, f);
        }
    }
    Fruits(int num, String name, int price){
        this.num = num;
        this.name = name;
        this.price = price;
    }

    public static void getFruitsBox(){
        for(Fruits f : Fruits.values()){
            System.out.println(f.num+" | "+f.name+" | "+f.price);
        }
    }

    public static Fruits getFruit(int num){
        return FruitsBox.getOrDefault(num, null);
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }
}
