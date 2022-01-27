package com.practice;

public class Linked_list
{
    private Node head;
    private Node rehead;
    private int []revert;
    private int top;
    public Linked_list()
    {
        head=null;
        rehead=null;
        revert=new int[100];
        top=0;
    }
    void insertionAtHead(int x)
    {
        if (head == null)
        {
            head = new Node(x);
            head.setLeftPointer(head);
        }
        else
        {
            Node n1 = new Node(x);
            n1.setRightPointer(head);
            head.setLeftPointer(n1);
            head = n1;
            n1.setLeftPointer(head);
        }
    }
    public void insertionAtTail(int x)
    {
            Node temp=head;
            try
            {
                while(temp.getRightPointer(temp) != null)
                {
                    temp=temp.getRightPointer(temp);
                }
                Node n1=new Node(x);
                temp.setRightPointer(n1);
                n1.setLeftPointer(temp);
            }
            catch(NullPointerException E)
            {
                head = new Node(x);
                head.setLeftPointer(head);
            }
    }
    public void insertionAfterNode(int x,int mod)
    {
        if(search(mod))
        {
            Node temp=head;
            while(temp.getRightPointer(temp) != null)
            {
                if(temp.getData(temp) == mod)
                {
                    break;
                }
                temp=temp.getRightPointer(temp);
            }
            Node n1=new Node(x);
            n1.setLeftPointer(temp);
            n1.setRightPointer(temp.getRightPointer(temp));
            temp.setRightPointer(n1);
        }
        else
        {
            System.out.println("the element not found");
        }
    }
    public void insertionBeforeNode(int x,int mod)
    {
        try
        {
            if (search(mod)) {
                Node temp = head;
                while (temp.getRightPointer(temp).getRightPointer(temp.getRightPointer(temp)) != null) {
                    if (temp.getRightPointer(temp).getData(temp.getRightPointer(temp)) == mod) {
                        break;
                    }
                    temp = temp.getRightPointer(temp);
                }
                Node n1 = new Node(x);
                n1.setLeftPointer(temp);
                n1.setRightPointer(temp.getRightPointer(temp));
                temp.getRightPointer(temp).setLeftPointer(n1);
                temp.setRightPointer(n1);
            } else {
                System.out.println("the element not found");
            }
        }
        catch(NullPointerException E)
        {
            if (search(mod)) {
                Node n1 = new Node(x);
                n1.setRightPointer(head);
                head.setLeftPointer(n1);
                head = n1;
                n1.setLeftPointer(head);
            }
            else
            {
                System.out.println("the element not found");
            }
        }
    }
    public int deleteAtHead()
    {
        int x;
        try
        {
            x= head.getData(head);
            head.getRightPointer(head).setLeftPointer(head);
            head = head.getRightPointer(head);
        }
        catch (NullPointerException E)
        {
            x= head.getData(head);
            head = null;
        }
        return x;
    }
    public boolean search(int x)
    {
        Node temp=head;
        while(temp != null)
        {
            if(temp.getData(temp) == x)
            {
                break;
            }
            temp= head.getRightPointer(temp);
        }
        if(temp==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Node NodeAt(int x)
    {
        Node temp=head;
        while(temp != null)
        {
            if(temp.getData(temp) == x)
            {
                break;
            }
            temp= head.getRightPointer(temp);
        }
        return temp;
    }
    public int deleteAtTail()
    {
        int x;
        Node temp=head;
        try {
            while (temp.getRightPointer(temp.getRightPointer(temp)) != null) {
                temp = temp.getRightPointer(temp);
            }
            x = temp.getData(temp.getRightPointer(temp));
            temp.setRightPointer(null);
        }
        catch (NullPointerException E)
        {
            temp=head;
                while(temp.getRightPointer(temp) != null)
                {
                    temp=temp.getRightPointer(temp);
                }
                x=temp.getData(temp);
                head = null;
        }
        return x;
    }

    public boolean isnull()
    {
        if(head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int deleteNode(int mod)
    {
        int x=-1;
        try
        {
            Node temp=head,temp2;
            while(temp.getRightPointer(temp) != null)
            {
                if(temp.getData(temp.getRightPointer(temp)) == mod)
                {
                    break;
                }
                temp=temp.getRightPointer(temp);
            }
            x=temp.getData(temp.getRightPointer(temp));
            temp2 = temp.getRightPointer(temp);
            temp2.getRightPointer(temp2).setLeftPointer(temp);
            temp.setRightPointer(temp2.getRightPointer(temp2));
            return x;
        }
        catch (NullPointerException E) {
            if (head.getData(head) == mod) {
                try {
                    x = head.getData(head);
                    head.getRightPointer(head).setLeftPointer(head);
                    head = head.getRightPointer(head);
                    return x;
                } catch (NullPointerException E1) {
                    x = head.getData(head);
                    head = null;
                    return x;
                }
            }
            Node temp = head,temp2=head;
            while (temp != null) {
                if (temp.getData(temp) == mod) {
                    if (temp.getRightPointer(temp) == null) {
                        x = temp.getData(temp);
                        while(temp2.getRightPointer(temp2) != temp)
                        {
                            temp2=temp2.getRightPointer(temp2);
                        }
                        temp2.setRightPointer(null);
                        return x;
                    }
                    break;
                }
                temp = temp.getRightPointer(temp);
            }
        }
        return x;
    }
    public void reverse()
    {
        top=0;
        rehead=null;
        Node temp=head,n1;
        while(temp != null)
        {
            revert[top]=temp.getData(temp);
            top++;
            temp = temp.getRightPointer(temp);
        }
        for(int i=0;i<top;i++)
        {
            if (rehead == null)
            {
                rehead = new Node(revert[i]);
                rehead.setLeftPointer(head);
            }
            else
            {
                n1 = new Node(revert[i]);
                n1.setRightPointer(rehead);
                rehead.setLeftPointer(n1);
                rehead = n1;
                n1.setLeftPointer(rehead);
            }
        }
    }
    public void traverse()
    {
        Node temp=head;
        while(temp != null)
        {
            System.out.print(temp.getData(temp) + " ");
            temp=temp.getRightPointer(temp);
        }
        System.out.println("");
    }
    public void traverseRevert()
    {
        Node temp=rehead;
        while(temp != null)
        {
            System.out.print(temp.getData(temp) + " ");
            temp=temp.getRightPointer(temp);
        }
        System.out.println("");
    }
    public void sort()
    {
        Node temp=head,n1;
        top=0;
        while(temp != null)
        {
            revert[top]= temp.getData(temp);
            top++;
            temp = temp.getRightPointer(temp);
        }
        for(int i=0; i<=top-1; i++)
        {
            for(int j=0; j<= top-2-i ; j++)
            {
                if(revert[j] >= revert[j+1])
                {
                    int tem= revert[j];
                    revert[j]=revert[j+1];
                    revert[j+1]=tem;
                }
            }
        }
        head=null;
            for(int i=top-1;i>=0;i--)
            {
                if (head == null)
                {
                    head = new Node(revert[i]);
                    head.setLeftPointer(head);
                }
                else
                {
                    n1 = new Node(revert[i]);
                    n1.setRightPointer(head);
                    head.setLeftPointer(n1);
                    head = n1;
                    n1.setLeftPointer(head);
                }
            }
            traverse();
            System.out.println("");
        }
}

class Node
{
    private int data;
    private Node left;
    private Node right;
    public Node(int x)
    {
        left=null;
        right=null;
        data=x;
    }
    public void setLeftPointer(Node temp)
    {
        left=temp;
    }
    public void setRightPointer(Node temp)
    {
        right=temp;
    }
    public int getData(Node temp)
    {
        return temp.data;
    }
    public Node getLeftPointer(Node temp)
    {
        return temp.left;
    }
    public Node getRightPointer(Node temp)
    {
        return temp.right;
    }
}