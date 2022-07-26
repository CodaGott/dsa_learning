package dsa.string;

public class StringClass {

    public static void main(String[] args) {
//        String a = "Ebuka";
//        String b = "Ebuka";
//
//        StringBuilder builder = new StringBuilder();
//
//        String check = new String("Ebuka");
//        String check2 = new String("Ebuka");
//
//
//        System.out.println(check == check2);
//
//        System.out.println(check.equals(check2));
//
//        builder.append(a);
//
//        builder.reverse();
//        System.out.println(builder);
//        builder.replace(2, 3, "z");
//        System.out.println(builder);

        System.out.println(isPalindrome(null));
    }

    static boolean isPalindrome(String str){
        if (str == null || str.length() == 0){
            return true;
        }

        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }


}
