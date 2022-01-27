import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main
{
    public static void main(String []anmol) throws FileNotFoundException
    {
        Linked_list l1=new Linked_list();
        int x,element,mod;
        Scanner s1=new Scanner(System.in);
        while(true)
        {
            System.out.println("press 1 for insertion at the head");
            System.out.println("press 2 for insertion at the tail");
            System.out.println("press 3 for insertion after the Node");
            System.out.println("press 4 for insertion before the Node");
            System.out.println("press 5 for deletion at the head");
            System.out.println("press 6 for deletion at the tail");
            System.out.println("press 7 for deletion of node of your own choice");
            System.out.println("press 8 for search before the Node");
            System.out.println("press 9 for traverse");
            System.out.println("press 10 for reverse the list");
            System.out.println("press 11 for sorting the list");
            System.out.println("press 12 for exit");
            x=s1.nextInt();
            switch(x)
            {
                case 1:
                    System.out.println("enter the element");
                    element=s1.nextInt();
                    l1.insertionAtHead(element);
                    break;
                case 2:
                    System.out.println("enter the element");
                    element=s1.nextInt();
                    l1.insertionAtTail(element);
                    break;
                case 3:
                    if(l1.isnull())
                    {
                        System.out.println("the list is not having any elements");
                    }
                    else
                    {
                        System.out.println("enter the element");
                        element = s1.nextInt();
                        System.out.println("enter the element after which you want to insert");
                        mod = s1.nextInt();
                        l1.insertionAfterNode(element, mod);
                    }
                    break;
                case 4:
                    if(l1.isnull())
                    {
                        System.out.println("the list is not having any elements");
                    }
                    else
                    {
                        System.out.println("enter the element");
                        element=s1.nextInt();
                        System.out.println("enter the element before which you want to insert");
                        mod=s1.nextInt();
                        l1.insertionBeforeNode(element,mod);
                    }
                    break;
                case 5:
                    if(l1.isnull())
                    {
                        System.out.println("the list is not having any elements");
                    }
                    else
                    {
                        element = l1.deleteAtHead();
                        System.out.println(element + " is deleted from the list");
                    }
                    break;
                case 6:
                    if(l1.isnull())
                    {
                        System.out.println("the list is not having any elements");
                    }
                    else
                    {
                        element = l1.deleteAtTail();
                        System.out.println(element + " is deleted from the list");
                    }
                    break;
                case 7:
                    if(l1.isnull())
                    {
                        System.out.println("the list is not having any elements");
                    }
                    else
                    {
                        System.out.println("enter the element to delete");
                        mod= s1.nextInt();
                        if(l1.search(mod))
                        {
                            element = l1.deleteNode(mod);
                            System.out.println(element + " is deleted from the list");
                        }
                        else
                        {
                            System.out.println("element not found");
                        }
                    }
                    break;
                case 8:
                    System.out.println("enter the number to search");
                    element= s1.nextInt();
                    if(l1.search(element))
                    {
                        System.out.println("the element is found");
                    }
                    else
                    {
                        System.out.println("No such element exist");
                    }
                    break;
                case 9:
                    l1.traverse();
                    break;
                case 10:
                    l1.reverse();
                    l1.traverseRevert();
                    break;
                case 11:
                    l1.sort();
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
