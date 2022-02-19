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
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
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
        --top;
        return temp;


    }
}
