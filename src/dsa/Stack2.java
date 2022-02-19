package dsa;

public class Stack2 {

    int[] stackCollection;
    int top;
    int len;

    public static void main(String[] args) {
        Stack2 stack = new Stack2(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.printCollection();
        System.out.println();
//        stack.pop();
//        int pooped = stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();

        int search = stack.search(1);

        System.out.println("Search "+search);

        int peeked = stack.peek();

        System.out.println(peeked);
    }

    public void printCollection(){
        for (int c : stackCollection ){
            System.out.println(c);
        }
    }

    public Stack2(int len){
        stackCollection = new int[len];
        this.len = len;
        top = -1;
    }


    public void push(int element){
       if (top == stackCollection.length - 1){
           System.out.println("Collection is FULL!!!");
       }
       top ++;
       stackCollection[top] = element;
    }

    public int pop(){
        if (top == -1){
            System.out.println("Collection is empty");
            return -1;
        }
        int temp = stackCollection[top];
        top--;
        return temp;


    }

    public int peek(){
        return stackCollection[top];
    }

    public int search(int element){
        int found = 0;
        for (int j : stackCollection) {
            if (element == j) {
                return element;
            } else
                System.out.println("Not Found");
        }
        return -1;
    }
}
