package dsa.arrays;

import java.util.Arrays;
import java.util.Objects;

public class ArraysClass {

//    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        String[] nameOfStu = {"Emma", "Goal", "Life"};
//        addToArray(nameOfStu, 1);
        update("New Goal", 1);
        delete("Goal");
    }

    public static void addToArray(String[] name, int size) {
        String [] names = new String[size];

        for (int i = 0; i < name.length; i++){
            try {
                names[i] = name[i];
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array either too big or too small");
            }
        }
        System.out.println(Arrays.toString(names));
    }
    
    public static void update(String newArray, int oldArrayIndex){
        String[] nameOfStu = {"Emma", "Goal", "Life"};
        System.out.println("Old array : " + Arrays.toString(nameOfStu));
        nameOfStu[oldArrayIndex] = newArray;
        
        String[] updatedArray = new String[nameOfStu.length];

        for (int i = 0; i < nameOfStu.length; i++) {
            updatedArray[i] = nameOfStu[i];
        }
        System.out.println("Updated array : " + Arrays.toString(updatedArray));
    }

    public static void delete(String newArray){
        String[] nameOfStu = {"Emma", "Goal", "Life"};
        System.out.println("Old array : " + Arrays.toString(nameOfStu));

        String[] updatedArray = new String[nameOfStu.length - 1];

        for (int i = 0; i < nameOfStu.length; i++) {
            if (Objects.equals(nameOfStu[i], newArray)){
                continue;
            }
        }
        for (int j = 0; j < nameOfStu.length; j++) {
            try {
                updatedArray[j] = nameOfStu[j];
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Removed and updated");
            }
        }
        System.out.println("Removed update " + Arrays.toString(updatedArray));
    }
}
