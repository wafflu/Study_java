package S6_Libary;

import java.util.Scanner;

public class Management {
    Book[] books = new Book[10];
    int size = 0;
    Scanner sc = new Scanner(System.in);

    public Book createBook(){
        String booktype = getInput("등록하실 책 타입을 선택해주세요\n 1. 일반서적 2. 전자북 3. 오디오북", sc);
        String bookname = getInput("책 이름을 입력해주세요:", sc);
        String author = getInput("책 저자를 입력해주세요:", sc);

        if(booktype.equals("3")){
            String playTime = getInput("재생시간을 적어주세요\nex) 1시간 12분", sc);
            return new AudioBook(bookname, author, playTime);
        } else if(booktype.equals("2")){
            String fileformat = getInput("파일형식을 정해주세요\n1. PDF 2. Doc", sc);
            return new Ebook(bookname, author, fileformat);
        } else {
            return new Book(bookname, author);
        }
    }

    // 사용자 입력을 처리하는 함수
    private static String getInput(String prompt, Scanner sc) {
        String input = "";
        do {
            System.out.println(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("입력은 빈칸일 수 없습니다. 다시 입력해주세요.");
            }
        } while (input.isEmpty());
        return input;
    }

    public void add(Book book){
        if (size == books.length) {
            System.out.println("책장이 꽉 찼습니다.");
            return;
//            resizeArray();
        }
        books[size++] = book;
        System.out.println("등록완료");
    }

    public void remove(int bookno){
        if (bookno < 0 || bookno >= size) {
            System.out.println("없는 책 번호입니다.");
            return;
        }
        for(int i = 0; i<size - 1; i++){
            books[i] = books[i+1];
        }
        books[--size] = null;
        System.out.println("삭제완료");
    }

    public void modify(int bookno){
        if (bookno < 0 || bookno >= size) {
            System.out.println("없는 책 번호입니다.");
            return;
        }
        Book book = books[bookno];
        StringBuilder sb = new StringBuilder();
        sb.append("변경하고자 하는 기능을 선택해주세요.");
        sb.append("1. 제목 수정 | 2. 저자 수정 | 3. 대여 및 반납 ");
        if(book instanceof Ebook){
            sb.append("| 4. 파일형식 변경");
        } else if(book instanceof AudioBook){
            sb.append("| 4. 재생시간 변경");
        }
        sb.append("| 0. 저장");
        while (true){
            System.out.println(sb.toString());
            int sel = Integer.valueOf(sc.nextLine());
            switch (sel){
                case 1:
                    System.out.println("현재 제목 : "+book.getBookName()+"\n 수정하실 제목을 입력해주세요.");
                    String bookname = sc.nextLine();
                    if(bookname.trim().length() == 0){
                        System.out.println("빈칸은 등록이 안됩니다.");
                    } else {
                        book.setBookName(bookname);
                        System.out.println("수정이 완료되었습니다.");
                    }
                    break;
                case 2:
                    System.out.println("현재 저자 : "+book.getAuthor()+"\n 수정하실 저자명을 입력해주세요.");
                    String author = sc.nextLine();
                    if(author.trim().length() == 0){
                        System.out.println("빈칸은 등록이 안됩니다.");
                    } else {
                        book.setAuthor(author);
                        System.out.println("수정이 완료되었습니다.");
                    }
                    break;
                case 3:
                    book.setLend(!book.isLend());
                    System.out.println(book.isLend() ? "대여중으로 변환" : "반납이 완료되었습니다.");
                    break;
                case 4:
                    if(book instanceof Ebook){
                        String fileformat = getInput("파일형식을 정해주세요\n1. PDF 2. Doc", sc);
                        ((Ebook) book).setFormat(fileformat);
                    } else {
                        String playTime = getInput("재생시간을 적어주세요\nex) 1시간 12분", sc);
                        ((AudioBook)book).setPlayTime(playTime);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("없는 기능");
                    break;
            }
        }
    }

    public void getBooks(){
        System.out.println("============= 책목록 ============");
        if(size == 0){
            System.out.println("등록된 책이 없습니다.");
        } else {
            for (int i = 0; i<books.length; i++) {
                if (books[i] != null) {
                    System.out.println("책번호 : "+(i+1)+" | "+books[i]);
                }
            }
        }
        System.out.println("===============================");
    }
}
