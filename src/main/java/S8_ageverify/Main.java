package S8_ageverify;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int age = 0;
        while (true){
            System.out.println("나이를 입력하세요 : ");
            try (Scanner sc = new Scanner(System.in)) {
                age = sc.nextInt();
                CheckAge(age);
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("오류: 유효한 숫자를 입력하세요.");
            } finally {
                System.out.println("프로그램이 종료되었습니다.");
            }
            break;
        }
    }

    public static void CheckAge(int age) throws InvalidAgeException{
        if(!(age >= 0 && age <= 120)){
            throw new InvalidAgeException("오류 : 나이는 0에서 120 사이여야 합니다.");
        }
        System.out.println("입력한 나이는 유효합니다. : "+age);
    }
}
