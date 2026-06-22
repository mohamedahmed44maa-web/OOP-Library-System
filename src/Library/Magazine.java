package Library;

public class Magazine extends LibraryItem{
    int issueNumber;
    public Magazine(String title,int issueNumber){
        super(title);
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("issueNumber must be greater than 0.");
        }
        this.issueNumber = issueNumber;
    }
    public int getissueNumber() {
        return issueNumber;
    }
    public void setIssueNumber(int issueNumber) {
        if (issueNumber<=0) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.issueNumber = issueNumber;
    }
    @Override
    public int getLoanPeriodDays() {
        return 7;
    }
    @Override
    public String getType(){
        return "Magazine";
    }
}
