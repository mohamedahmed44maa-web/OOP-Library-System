package Library;
public class Book extends LibraryItem{
    String author;
    int pages;
    public Book(String title,String author,int pages){
        super(title);
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than 0.");
        }
        this.author = author;
        this.pages = pages;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.author = author;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than 0.");
        }
        this.pages = pages;
    }
    @Override
    public int getLoanPeriodDays() {
        return 21;
    }
    @Override
    public String getType(){
        return"Book";
    }
}
