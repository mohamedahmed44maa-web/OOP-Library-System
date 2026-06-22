package Library;
import java.util.ArrayList;
import java.util.List;
public class Member {
    private String memberId;
    private String name;
    private int maxAllowed;
    private List<LibraryItem> borrowedItems;
    public Member(String memberId,String name,int maxAllowed){
        if (memberId == null || memberId.isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (maxAllowed <= 0) {
            throw new IllegalArgumentException("Max allowed must be a positive number.");
        }
        this.memberId = memberId;
        this.name = name;
        this.maxAllowed = maxAllowed;
        this.borrowedItems = new ArrayList<>();
    }
    public String getMemberId() {
        return memberId;
    }
    public String getName() {
        return name;
    }
    public int getMaxAllowed() {
        return maxAllowed;
    }
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }
    public void setMaxAllowed(int maxAllowed) {
        if (maxAllowed <= 0) {
            throw new IllegalArgumentException("Max allowed must be a positive number.");
        }
        this.maxAllowed = maxAllowed;
    }
    public int getBorrowedCount() {
        return borrowedItems.size();
    }
    public boolean canBorrowMore() {
        return borrowedItems.size() < maxAllowed;
    }
    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }
    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
}
