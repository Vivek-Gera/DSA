package dsa.apps;

import dsa.structures.list.CircularLinkedList;
import java.util.Scanner;

public class CircularLinkedListApp {
    public static void main(String[] args) {

        CircularLinkedList List = new CircularLinkedList();
        Scanner s = new Scanner(System.in);

        System.out.print(
                """
                         1.Operations Menu
                         2.Insert Data At Last
                         3.Insert Data At Given Position
                         4.Delete Particular Data
                         5.Delete Data At Given Position
                         6.Check The Data Exist In List
                         7.Search The Data In List
                         8.Print The List
                         9.Exit
                        """);

        while (true) {

            System.out.println("Enter any value to see the options");
            int ch = s.nextInt();
            switch (ch) {

                case 1:
                    System.out.print(
                            """
                                     1.Operations Menu
                                     2.Insert Data At Last
                                     3.Insert Data At Given Position
                                     4.Delete Particular Data
                                     5.Delete Data At Given Position
                                     6.Check The Data Exist In List
                                     7.Search The Data In List
                                     8.Print The List
                                     9.Exit
                                    """);
                    break;

                case 2:
                    int data;
                    System.out.println("Enter A Value To Store In The List \n");
                    data = s.nextInt();
                    List.append(data);
                    System.out.println("Value is added into the list \n");
                    break;

                case 3:
                    int position;
                    System.out.println("Enter A Position To Store In The List \n");
                    position = s.nextInt();
                    System.out.println("Enter A Value To Store In The List \n");
                    data = s.nextInt();
                    try {
                        List.insert(position, data);
                        System.out.println("Value is added into the list At given position \n");
                    } catch (Exception e) {
                        System.out.println(e + "\n");
                    }
                    break;

                case 4:
                    System.out.println("Enter A Value To be deleted In The List \n");
                    data = s.nextInt();
                    List.delete(data);
                    System.out.println("Value is deleted from the list \n");
                    break;

                case 5:
                    System.out.println("Enter A Position To delete In The List \n");
                    position = s.nextInt();
                    try {
                        List.deleteAt(position);
                        System.out.println("Value is deleted from the list At given position \n");
                    } catch (Exception e) {
                        System.out.println(e + "\n");
                    }
                    break;

                case 6:
                    System.out.println("Enter A Value To be checked In The List \n");
                    data = s.nextInt();
                    if (List.contains(data)) {
                        System.out.println("Value " + data + " is in the list \n");
                    } else {
                        System.out.println("Value " + data + " is not in the list \n");
                    }
                    break;

                case 7:
                    System.out.println("Enter A Value To be searched In The List \n");
                    data = s.nextInt();
                    if (List.search(data) != -1) {
                        System.out.println("Value " + data + " is at" + List.search(data) + " position in the list \n");
                    } else {
                        System.out.println("Value " + data + " is not in the list \n");
                    }
                    break;

                case 8:
                    List.print();
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("Choose The Correct Options");
            }
        }
    }
}
