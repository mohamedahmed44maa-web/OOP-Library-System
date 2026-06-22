package Library;

 public abstract class LibraryItem {
    private String id;
    private String title;
    private boolean borrowed;
    private static int totalItemsCreated=0;
    private static int nextNumber=0;
    public LibraryItem(String title) {
        if (title == null|| title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        totalItemsCreated++;
        nextNumber++;
        this.title=title;
        this.id="ITEM-"+nextNumber;
        this.borrowed=false;
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
         return title;
    }
    public boolean isBorrowed(){
        return borrowed;
    }
     public static int getTotalItemsCreated() {
        return totalItemsCreated;
    }
     public void setTitle(String title){
        if (title == null|| title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title=title;
    }
     public void markBorrowed() {
        this.borrowed = true;
    }
     public void markReturned() {
        this.borrowed = false;
    }
     public void displayInfo() {
         System.out.println(getId() + " | " + getTitle()
                 + " | " + getType()
                 + " | loan: " + getLoanPeriodDays() + " days"
                 + " | " + (isBorrowed() ? "OUT" : "available"));
     }
     public abstract int getLoanPeriodDays();
     public abstract String getType();
 }
