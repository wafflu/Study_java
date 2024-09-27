package S6_Libary;

class Book{
    private String BookName;
    private String Author;
    private boolean Lend = false;

    public Book(String bookName, String author){
        this.BookName = bookName;
        this.Author = author;
    }
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public boolean isLend() {
        return Lend;
    }

    public void setLend(boolean lend) {
        Lend = lend;
    }

    @Override
    public String toString(){
        return "제목 : "+BookName+" | 저자 : "+Author+" | 대여여부 : "+(Lend ? "대여중" : "대여가능");
    }
}

class Ebook extends Book{
    private String format;

    public Ebook(String bookName, String author, String format){
        super(bookName, author);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString(){
        return super.toString()+" | [Ebook] | 타입 : "+(format.equals("1") ? "PDF" : "Doc");
    }
}

class AudioBook extends Book{
    private String playTime;

    public AudioBook(String bookName, String author, String playTime){
        super(bookName, author);
        this.playTime = playTime;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString(){
        return super.toString()+" | [AudioBook] | 재생시간 : "+playTime;
    }
}
