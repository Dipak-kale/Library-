import java.util.Scanner;

public class LIBRARY {
    Scanner in = new Scanner(System.in);
    String user_name = null;
    String email_id = null;
    int library_num;
    boolean book_credit = true;

    String book_name = null;
    String author_name = null;
    int book_code;
    boolean available = true;

    void show_member() {
        System.out
                .println("\nUser Name: " + user_name + "\nEmail id: " + email_id + "\nLibrary number : " + library_num);
    }

    void show_book() {
        if (available) {
            System.out
                    .println("\nBook Name: " + book_name + "\nAuthor name: " + author_name + "\nBook code : "
                            + book_code);
        }
    }

    void new_member() {
        System.out.println("\nEnter the user name: ");
        user_name = in.nextLine();
        System.out.println("Enter the email id: ");
        email_id = in.nextLine();
        System.out.println("Enter the Library number: ");
        library_num = in.nextInt();

    }

    void new_book() {
        System.out.println("\nEnter the book name: ");
        book_name = in.nextLine();
        System.out.println("Enter the Author name: ");
        author_name = in.nextLine();
        System.out.println("Enter the Book code: ");
        book_code = in.nextInt();
    }

    public static void main(String[] args) {
        int member_counter = 0, book_counter = 0;
        Scanner in = new Scanner(System.in);
        int ch;
        LIBRARY[] members = new LIBRARY[100];
        for (int i = 0; i < 100; i++) {
            members[i] = new LIBRARY();
        } 
        System.out.print("\t\t*____W E L C O M E  T O  L I B R A R Y____*");
        do {
            System.out.print(
                    "\nEnter your choise :\n1)Add new member.\n2)Add new book.\n3)Issue/Return book.\n4)Show available book.\n5)Show members\n6)Exit.\nChoise :-");
            ch = in.nextInt();
            switch (ch) {
                case 1:
                    members[member_counter].new_member();
                    member_counter++;

                    break;
                case 2:
                    members[book_counter].new_book();
                    book_counter++;

                    break;
                case 3:
                    int choise = 1, lib_num, book_co;
                    System.out.print("1)Issue book\t2)Submit book\n:-");
                    choise = in.nextInt();
                    switch (choise) {
                        case 1:
                            System.out.print("Enter the library number: ");
                            lib_num = in.nextInt();
                            for (int i = 0; i < member_counter; i++) {
                                if (members[i].library_num == lib_num) {
                                    if (members[i].book_credit) {
                                        System.out.print("Enter the book code to issue: ");
                                        book_co = in.nextInt();
                                        for (int a = 0; a < book_counter; a++) {
                                            if (members[a].book_code == book_co) {
                                                if (members[a].available) {
                                                    System.out.print("\n    " +
                                                            members[a].book_name + " issued to "
                                                            + members[i].user_name);
                                                    members[a].available = false;
                                                    members[i].book_credit = false;
                                                } else {
                                                    System.out.println(
                                                            "Book has been already borrowed by another reader.\nPlease try later.");
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("Please return the old book first,to issue new book.");
                                    }
                                } else {
                                    System.out.println("Incorrect library number.PLEASE TRY AGAIN.");
                                }
                            }
                            break;

                        case 2:
                            int num, code;
                            System.out.println("Enter the library number: ");
                            num = in.nextInt();
                            for (int i = 0; i < member_counter; i++) {
                                if (num == members[i].library_num) {
                                    if (!members[i].book_credit) {
                                        System.out.print("Enter the book number: ");
                                        code = in.nextInt();
                                        for (int a = 0; a < book_counter; a++) {
                                            if (code == members[a].book_code) {
                                                if (!members[a].available) {
                                                    System.out.println(members[a].book_name + " returned by "
                                                            + members[i].user_name);
                                                    members[a].available = true;
                                                    members[i].book_credit = true;

                                                } else {
                                                    System.out.println(
                                                            " Book is available,plz check book code. correctly.");
                                                }

                                            } else {
                                                System.out.println("Incorrect book code.");
                                            }
                                        }
                                    } else {
                                        System.out.println(
                                                "Your book credit are available,plz check library number. correctly.");
                                    }
                                } else {
                                    System.out.println("Incorrect library number.");
                                }
                            }
                    }

                    break;
                case 4:
                    for (int i = 0; i < book_counter; i++) {
                        members[i].show_book();
                    }
                    break;
                case 5:
                    for (int i = 0; i < member_counter; i++) {
                        members[i].show_member();
                    }
                    break;
            }
        } while (ch != 6);

        System.out.println(
                "\n\n\tThanks for using, 73 PRODUCTIONS PRODUCT :- LIBRARY MANAGMENT SYSTEM.");

        in.close();
    }
}