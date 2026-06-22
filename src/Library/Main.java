package Library;

import java.util.Scanner;

public class Main {
    static void main() {
        Library library=new Library();
        Scanner scanner=new Scanner(System.in);
        int choice=0;
        while (!(choice ==9)) {
            System.out.println("\n===== Library Lending System =====");
            System.out.println("1. Add Item");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. List Catalog");
            System.out.println("6. Report");
            System.out.println("7. Search Item by Title");
            System.out.println("8. Show Available Items Only");
            System.out.println("9. Exit");
            System.out.print("Enter choice:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1:
                        System.out.println("Item type: 1.Book--2.Magazine--3.DVD");
                        System.out.print("Enter type:");
                        int type = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter Title:");
                        String title = scanner.nextLine();
                        if (type == 1) {
                            System.out.print("Enter author:");
                            String author = scanner.nextLine();
                            System.out.print("Enter pages:");
                            int pages = Integer.parseInt(scanner.nextLine());
                            library.addItem(new Book(title, author, pages));
                        } else if (type == 2) {
                            System.out.print("Enter issue number:");
                            int issueNumber = Integer.parseInt(scanner.nextLine());
                            library.addItem(new Magazine(title, issueNumber));
                        } else if (type == 3) {
                            System.out.print("Enter runtime minutes:");
                            int runtime = Integer.parseInt(scanner.nextLine());
                            library.addItem(new DVD(title, runtime));
                        } else {
                            System.out.println("Invalid item type.");
                        }
                        System.out.println("Item added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter Member ID:");
                        String memberId = scanner.nextLine();
                        System.out.print("Enter Member Name:");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter max allowed items:");
                        int maxAllowed = Integer.parseInt(scanner.nextLine());
                        library.addMember(new Member(memberId, memberName, maxAllowed));
                        System.out.println("Member added successfully.");
                        break;
                    case 3:
                        System.out.print("Member ID:");
                        String borrowMemberId = scanner.nextLine();
                        System.out.print("Item ID:");
                        String borrowItemId = scanner.nextLine();
                        try {
                            library.borrowItem(borrowMemberId,borrowItemId);
                        } catch (LibraryException e) {
                            System.out.println("Could not borrow,"+e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Member ID:");
                        String returnMemberId = scanner.nextLine();
                        System.out.print("Item ID:");
                        String returnItemId = scanner.nextLine();
                        try {
                            library.returnItem(returnMemberId,returnItemId);
                        } catch (LibraryException e) {
                            System.out.println("Could not return,"+e.getMessage());
                        }
                        break;
                    case 5:
                        library.listCatalog();
                        break;
                    case 6:
                        library.printReport();
                        break;
                    case 7:
                        System.out.print("Enter title to search with:");
                        String titleSearch = scanner.nextLine();
                        library.titleSearchWith(titleSearch);
                        break;
                    case 8:
                        library.availableItems();
                        break;
                    case 9:
                        System.out.println("Thank You For Using Library Lending System.");
                        break;
                    default:
                        System.out.println("Invalid choice,Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input,Please enter a number.");
            }
        }
    }
}
