package dsa.arrays;

public class Arrays {

    public static void main(String[] args) {
        int [] myArray = new int[4];
        myArray[0] = 120;
        myArray[1] = 204;
        myArray[2] = 202;
        myArray[3] = 206;

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == 202){
                myArray[i] = 30;
            }
            System.out.println(myArray[i]);
        }
    }
}
