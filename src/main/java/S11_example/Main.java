package S11_example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayExample ar = new ArrayExample();

        while (true){
            System.out.println("0. 과일목록 | 1. 과일담기 | 2. 과일빼기 | 3. 장바구니확인 | 4. 계산하기");
            int Sel = Integer.parseInt(sc.next());

            if(Sel == 4){
                ar.Calculation();
                System.exit(0);
            }

            switch (Sel){
                case 0:
                    Fruits.getFruitsBox();
                    break;
                case 1:
                    ar.addFruit();
                    break;
                case 2:
                    ar.delFruit();
                    break;
                case 3:
                    ar.showFruitsbox();
                    break;
            }
        }
    }
}
