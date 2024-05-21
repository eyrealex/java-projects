public class Main {
    public static void main(String[] args) {

        //option 1
        String str = "Hello World";
        System.out.println("Normal: " + str);

        System.out.print("Reversed: ");
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = str.charAt(i);
            System.out.print(s);
        }

        //option 2
        String str2 = "Ireland";
        char[] chars = str2.toCharArray();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Normal: " + str2);
        System.out.print("Reversed: ");
        for (int i = str2.length() - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}