package Library;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<String, LibraryItem> catalog;
    private Map<String, Member> members;
    private Set<String> borrowedIds;
    public Library() {
        this.catalog = new HashMap<>();
        this.members = new HashMap<>();
        this.borrowedIds = new HashSet<>();
    }
    public void addItem(LibraryItem item){
        catalog.put(item.getId(),item);
    }
    public void addMember(Member member) {
        members.put(member.getMemberId(),member);
    }
    public void borrowItem(String memberId, String itemId) throws LibraryException {
        Member member = members.get(memberId);
        if (member == null) {
            throw new LibraryException("Member " + memberId + " not found");
        }
        LibraryItem item = catalog.get(itemId);
        if (item == null) {
            throw new LibraryException("Item " + itemId + " not found");
        }
        if (item.isBorrowed()) {
            throw new LibraryException("Item " + itemId + " is already out");
        }
        if (!member.canBorrowMore()) {
            throw new LibraryException("Member " + memberId + " has reached their borrowing limit");
        }
        item.markBorrowed();
        member.addBorrowedItem(item);
        borrowedIds.add(itemId);
        System.out.println("Borrowed " + itemId + " to " + memberId );
    }
        public void returnItem(String memberId, String itemId) throws LibraryException{
            Member member = members.get(memberId);
            if (member == null) {
                throw new LibraryException("Member " + memberId + " not found");
            }
            LibraryItem item = catalog.get(itemId);
            if (item == null) {
                throw new LibraryException("Item " + itemId + " not found");
            }
            if (!member.getBorrowedItems().contains(item)) {
                throw new LibraryException("Member " + memberId + " does not hold item " + itemId);
            }
            item.markReturned();
            member.removeBorrowedItem(item);
            borrowedIds.remove(itemId);
            System.out.println("Returned " + itemId + " from " + memberId + ".");
        }
        public void listCatalog(){
            for (LibraryItem item : catalog.values()) {
                item.displayInfo();
            }
        }
        public void printReport() {
            Map<String, Integer> countByItemType = new HashMap<>();
            for (LibraryItem item : catalog.values()) {
                String type = item.getType();
                countByItemType.put(type, countByItemType.getOrDefault(type, 0) + 1);
            }
            System.out.println("---------- REPORT ----------");
            System.out.println("Total items : " + catalog.size());
            System.out.println("Currently out : " + borrowedIds.size());
            System.out.println("Borrowed ids : " + borrowedIds);
            System.out.println("Items by type : " + countByItemType);
            System.out.println("Total created : " + LibraryItem.getTotalItemsCreated());
            System.out.println("----------------------------");
        }
        public void titleSearchWith(String title) {
            boolean found = false;
            for (LibraryItem item : catalog.values()) {
                if (item.getTitle().equalsIgnoreCase(title)) {
                    item.displayInfo();
                    found = true;
                }
            }
                if (!found) {
                   System.out.println("No items found for:" + title);
                }
        }
        public void availableItems() {
            boolean found =false;
            for (LibraryItem item : catalog.values()) {
                if (!item.isBorrowed()) {
                    item.displayInfo();
                    found = true;
                }
            }
            if (!found) {
                   System.out.println("No available items.");
            }
        }
}
