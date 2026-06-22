# 📚 OOP Library Lending System

A menu-driven console application built in Java that manages a library catalog, registers members, and handles borrowing and returning of items.

---

## 📋 Description

This project is a **Library Lending System** that demonstrates core Object-Oriented Programming concepts in Java. The system allows librarians to manage different types of library items (Books, Magazines, DVDs), register members, and handle the borrowing and returning process — all through a simple console menu.

---

## 🧠 OOP Concepts Demonstrated

| Concept | Where Used |
|---|---|
| **Abstraction** | `LibraryItem` is an abstract class with abstract methods |
| **Inheritance** | `Book`, `Magazine`, `DVD` extend `LibraryItem` |
| **Polymorphism** | `displayInfo()` behaves differently for each item type |
| **Encapsulation** | All fields are private with getters/setters |
| **Method Overriding** | `getLoanPeriodDays()` and `getType()` overridden in each subclass |
| **Static Members** | `totalItemsCreated` and `nextNumber` in `LibraryItem` |
| **Collections** | `List`, `Map`, `Set` used in `Member` and `Library` |
| **Custom Exceptions** | `LibraryException` handles all library rule violations |

---

## 📁 Project Structure

```
OOP-Library-System/
│
├── LibraryException.java   # Custom exception for library rule violations
├── LibraryItem.java        # Abstract base class for all library items
├── Book.java               # Subclass: loan period 21 days
├── Magazine.java           # Subclass: loan period 7 days
├── DVD.java                # Subclass: loan period 3 days
├── Member.java             # Represents a library member
├── Library.java            # Core engine: manages catalog, members, borrowing
└── Main.java               # Menu-driven entry point
```

---

## ✨ Features

### Core Features
- ➕ Add items to the catalog (Book, Magazine, DVD)
- 👤 Register new members
- 📤 Borrow an item
- 📥 Return an item
- 📋 List all catalog items
- 📊 View full report

### Bonus Features
- 🔍 Search item by title
- ✅ Show available items only
- 📈 Statistics by item type in the report

---

## 🚦 Library Rules Enforced

- An item that is already borrowed **cannot be borrowed again**
- A member **cannot exceed their borrowing limit**
- A member **cannot return an item they never borrowed**
- Borrowing or returning a **non-existent ID** throws an error
- All rules are handled with `LibraryException` — the program **never crashes**

---

## 🖥️ How to Run

### Requirements
- Java JDK 8 or higher

### Steps

1. Clone the repository:
```bash
git clone https://github.com/mohamedahmed44maa.web/OOP-Library-System.git
```

2. Navigate to the project folder:
```bash
cd OOP-Library-System
```

3. Compile all files:
```bash
javac *.java
```

4. Run the program:
```bash
java Main
```

---

## 📺 Menu Options

```
===== Library Lending System =====
1. Add Item
2. Add Member
3. Borrow Item
4. Return Item
5. List Catalog
6. Report
7. Search Item by Title
8. Show Available Items
9. Exit
```

---

## 📊 Sample Output

```
===== Library Lending System =====
Enter choice: 5

ITEM-1 | Clean Code | Book | loan: 21 days | available
ITEM-2 | National Geographic | Magazine | loan: 7 days | available
ITEM-3 | Inception | DVD | loan: 3 days | available

Enter choice: 3
Member id: M1
Item id: ITEM-1
Borrowed ITEM-1 to M1.

Enter choice: 6
---------- REPORT ----------
Total items    : 3
Currently out  : 1
Borrowed ids   : [ITEM-1]
Items by type : {DVD=1, Book=1, Magazine=1}
Total created  : 3
Total members  : 2
```

---

## 🔑 Key Design Decisions

- **No `instanceof` chains** — `listCatalog()` and `borrowItem()` work through the `LibraryItem` base type only. Polymorphism handles the differences automatically.
- **Auto-generated IDs** — Items get IDs like `ITEM-1`, `ITEM-2` automatically. Users never need to type an ID when adding items.
- **Single exception type** — `LibraryException` covers all rule violations, keeping error handling clean and consistent.

---

## 👨‍💻 Author

**Mohamed Ahmed Abd Elwahab Zayed**
