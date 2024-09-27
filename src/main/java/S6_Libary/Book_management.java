package S6_Libary;

import java.util.Scanner;

public class Book_management {
    public static void main(String[] args) {
        Management m = new Management();
        Scanner sc = new Scanner(System.in);
        int bn = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("원하시는 기능을 선택해주세요.\n");
        sb.append("1. 책등록 | 2. 책목록 | 3. 책수정 | 4. 책삭제 | 5. 시스템종료");

        while (true){
            System.out.println(sb.toString());
            String sel = sc.nextLine();

            switch (sel){
                case "1":
                    m.add(m.createBook());
                    break;
                case "2":
                    m.getBooks();
                    break;
                case "3":
                    System.out.println("수정하고자 하는 책의 번호를 입력해주세요.");
                    bn = Integer.valueOf(sc.nextLine());
                    m.modify(bn-1);
                    break;
                case "4":
                    System.out.println("삭제하고자 하는 책의 번호를 입력해주세요.");
                    bn = Integer.valueOf(sc.nextLine());
                    m.remove(bn-1);
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("이상한거 선택하지말고");
                    break;
            }
        }


    }
}