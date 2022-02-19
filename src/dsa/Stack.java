package dsa;

public class Stack {

    private int stackSize;

    public int[] stacks;

    private int TOP;

    public Stack(int stackSize){
        this.stackSize = stackSize;
        stacks = new int[stackSize];
        TOP = -1;
    }


    public void push(int element){
        if (isFull()){
            System.out.println("Stack is full");
            System.exit(1);
        }else {
            stacks[++TOP] = element;
        }
    }

    public int pop(){
        if (!isEmpty()){
        return stacks[TOP--];
        }else {
            return -1;
        }
    }


    private boolean isFull(){
       return stackSize == TOP - 1;
    }


    private boolean isEmpty(){
        return TOP ==  -1;
    }

    public void printStack(){
        for (int stack : stacks) {
            System.out.println(stack);
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();

        System.out.println();
        System.out.println("After Popping");
        stack.printStack();

        System.out.println("Length after pop " + stack.stacks.length);
    }

}
