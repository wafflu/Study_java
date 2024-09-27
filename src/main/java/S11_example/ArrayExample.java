package S11_example;

import java.util.*;

public class ArrayExample {
    private static ArrayList<Fruits> box = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addFruit() {
        if(box.size() == 10){
            System.out.println("이미 장바구니가 가득 찼습니다.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1. 사과 | 2. 딸기 | 3. 포도 | 4. 레몬 | 5. 과일박스 확인 | 6. 그만담기\n");
        sb.append("과일상자에 담을 과일을 선택해주세요. (최대 10개)");

        while (box.size() < 10){
            System.out.println(sb.toString());
            int sel = Integer.parseInt(sc.next());
            Fruits fruit = Fruits.getFruit(sel);

            if(sel == 5){
                showFruitsbox();
            } else if(sel == 6){
                break;
            } else {
                if(fruit != null) {
                    System.out.println(fruit.getName()+"를 담았습니다.");
                    box.add(fruit);
                } else {
                    System.out.println("없는 과일입니다. 다시 선택해주세요.");
                }
            }
        }
    }

    public void delFruit(){
        if(box.isEmpty()){
            System.out.println("장바구니에 담긴 과일이 없습니다.");
            return;
        }
        while (true){
            System.out.println("장바구니에서 제거하실 과일을 선택해주세요. (0번 메뉴이동)");
            showFruitsbox();
            int sel = Integer.parseInt(sc.next());
            if(sel == 0){
                break;
            }
            box.remove(sel-1);
        }
    }

    public void showFruitsbox(){
        Iterator<Fruits> it = box.iterator();
        System.out.println("-----과일박스-----");
        int num = 0;
        while(it.hasNext()){
            System.out.println((num+1) +" : "+ it.next().getName()+" ");
            num++;
        }
    }

    public void Calculation(){
        HashMap<Fruits, Integer> cart = new HashMap<>();
        for (Fruits fruit : box) {
            cart.put(fruit, cart.getOrDefault(fruit, 0) + 1);
        }

        System.out.println("과일 개수:");
        int sum = 0;
        for (Fruits fruit : cart.keySet()) {
            int cnt = cart.get(fruit);
            int price = fruit.getPrice()*cnt;
            System.out.println(fruit.getName() + " x " + cnt + " = "+price);
            sum += price;
        }
        System.out.println("합계 : "+sum);
    }
}
