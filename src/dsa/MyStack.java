package dsa;

public class MyStack {

    static int top = -1;
    static int [] stackCollection = new int[5];


    public static void main(String[] args) {
        pushElementToStack(2);
        pushElementToStack(4);
        pushElementToStack(3);
        pushElementToStack(5);
        pushElementToStack(6);
        System.out.println("Number removed from stack: " + removeFromStack());
        printStack();
    }

    public static void pushElementToStack(int element){

        if (top == stackCollection.length - 1){
            System.out.println("Stack is full");
        }
        top++;
        stackCollection[top] = element;
    }

    public static void printStack(){
        for (int j : stackCollection) {
            System.out.println("Stack collection items" + j);
        }
    }

    public static int removeFromStack(){

        if (top == -1){
            System.out.println("Stack is empty");
            return -1;
        }

        int temp = stackCollection[top];
        top --;
        return temp;
    }
}
