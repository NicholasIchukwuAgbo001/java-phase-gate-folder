package DiaryApp;
import java.util.ArrayList;
import java.util.Scanner;

public class DiaryMain {
    public static void main(String[] args) {
        Diaries diaries = new Diaries();
        Diary diary = null;
        Scanner userInputCollection = new Scanner(System.in);

        String username;
        String password;
        String title;
        String body;
        int id;

        while (true) {
            if (diary == null) {
                System.out.println("""
                    \n1. Add a new diary
                    2. Find a diary by username
                    3. Delete a diary
                    4. Exit...
                    """);

                int choice;
                while (true) {
                    try {
                        System.out.print("\nEnter your choice: ");
                        String input = userInputCollection.nextLine();
                        if (input.isEmpty()) {
                            System.out.print("choice can't be empty, Please enter a valid choice\n");
                            continue;
                        }
                        choice = Integer.parseInt(input);
                        break;
                    } catch (Exception e) {
                        System.out.print("Invalid input, Please enter a valid choice\n ");
                    }
                }

                if (choice == 1) {
                    while (true) {
                        try {
                            System.out.print("\nEnter username: ");
                            username = userInputCollection.nextLine();
                            validateUsername(username);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter password(Niko_4455): ");
                            password = userInputCollection.nextLine();
                            validatePassword(password);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    try {
                        diaries.add(username, password);
                        System.out.println("Diary added successfully!");
                    } catch (Exception e) {
                        System.out.println("Invalid username or password!");
                    }
                }
                else if (choice == 2) {
                        while (true) {
                            try {
                                System.out.print("\nEnter username: ");
                                username = userInputCollection.nextLine();
                                validateUsername(username);
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("\nEnter password(Niko_4455): ");
                                password = userInputCollection.nextLine();
                                validatePassword(password);
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        try {
                            diary = diaries.findByUsername(username, password);
                            System.out.println("Diary unlocked successfully!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                } else if (choice == 3) {
                    while (true) {
                        try {
                            System.out.print("\nEnter username: ");
                            username = userInputCollection.nextLine();
                            validateUsername(username);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter password(Niko_4455): ");
                            password = userInputCollection.nextLine();
                            validatePassword(password);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }

                    try {
                        diaries.delete(username,  password);
                        System.out.println("Diary delete successfully!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else if (choice == 4) {
                    System.out.print("Exiting Diary App...");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("""
                    \n1. Lock diary
                    2. Unlock diary
                    3. Create entry
                    4. Find entry
                    5. Delete entry
                    6. Update entry
                    7. Back
                    """);
                System.out.print("Enter your choice: ");
                int choice = userInputCollection.nextInt();
                userInputCollection.nextLine();

                if (choice == 1) {
                    diary.lockDiary();
                    System.out.println("Diary locked successfully!");
                    diary = null;
                } else if (choice == 2) {
                    while (true) {
                        try {
                            System.out.print("\nEnter password(Niko_4455): ");
                            password = userInputCollection.nextLine();
                            validatePassword(password);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }

                    try {
                        diary.unlockDiary(password);
                        System.out.println("Diary unlocked successfully!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (choice == 3) {
                    while (true) {
                        try {
                            System.out.print("\nEnter title: ");
                            title = userInputCollection.nextLine();
                            validateTitleAndBody(title);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("\nEnter body: ");
                            body = userInputCollection.nextLine();
                            validateTitleAndBody(body);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        diary.createEntry(title, body);
                        System.out.println("\nEntry created successfully!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (choice == 4) {
                    while (true) {
                        try {
                            System.out.print("\nEnter entry id: ");
                            String idStr = userInputCollection.nextLine();
                            if(idStr.isEmpty()){
                                System.out.println("Entry id can not be empty!: ");
                                continue;
                            }
                            id = Integer.parseInt(idStr);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        Entry entry = diary.findEntryById(id);
                        System.out.println("Entry found successfully!");
                        System.out.println("\nEntry title: " + entry.getTitle());
                        System.out.println("Entry body: " + entry.getBody());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (choice == 5) {
                    while (true) {
                        try {
                            System.out.print("\nEnter entry id: ");
                            String idStr = userInputCollection.nextLine();
                            if(idStr.isEmpty()){
                                System.out.println("Entry id can not be empty!: ");
                                continue;
                            }
                            id = Integer.parseInt(idStr);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        diary.deleteEntry(id);
                        System.out.println("Entry deleted successfully!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }else  if (choice == 6) {
                    while (true) {
                        try {
                            System.out.print("\nEnter entry id: ");
                            String idStr = userInputCollection.nextLine();
                            if(idStr.isEmpty()){
                                System.out.println("Entry id can not be empty!: ");
                                continue;
                            }
                            id = Integer.parseInt(idStr);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter title: ");
                            title = userInputCollection.nextLine();
                            validateTitleAndBody(title);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("\nEnter body: ");
                            body = userInputCollection.nextLine();
                            validateTitleAndBody(body);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }

                    try{
                        diary.updateEntry(id, title, body);
                        System.out.println("Entry updated successfully!");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                } else if (choice == 7) {
                    diary = null;
                }
            }
        }


    }

    private static void validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username is null or empty");
        }
        if(!username.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid username");
        }
    }

    private static void validateTitleAndBody(String name) {
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Invalid name, Name must contain only letters.");
        }
    }

    private static void validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is null or empty");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password should be at least 8 characters long");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password should contain at least one digit");
        }
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("Password should contain at least one special character");
        }
    }

}