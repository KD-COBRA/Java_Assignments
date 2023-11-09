import java.util.Scanner;

public class TASK_2_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        StringBuffer stringBuffer = new StringBuffer(inputString);

        // append()
        stringBuffer.append(" This is an appended text");
        System.out.println("String after append(): " + stringBuffer.toString());

        // insert()
        stringBuffer.insert(10, "inserted ");
        System.out.println("String after insert(): " + stringBuffer.toString());

        // replace()
        stringBuffer.replace(15, 20, "replaced ");
        System.out.println("String after replace(): " + stringBuffer.toString());

        // delete()
        stringBuffer.delete(25, 30);
        System.out.println("String after delete(): " + stringBuffer.toString());

        // charAt()
        char firstChar = stringBuffer.charAt(0);
        System.out.println("First character: " + firstChar);

        // setCharAt()
        stringBuffer.setCharAt(0, 'S');
        System.out.println("String after setCharAt(): " + stringBuffer.toString());

        // length()
        int stringLength = stringBuffer.length();
        System.out.println("Length of the string: " + stringLength);

        // capacity()
        int stringCapacity = stringBuffer.capacity();
        System.out.println("Current capacity of the string buffer: " + stringCapacity);

        // ensureCapacity()
        stringBuffer.ensureCapacity(100);
        System.out.println("String buffer capacity after ensureCapacity(): " + stringBuffer.capacity());

        // toString()
        String stringFromStringBuffer = stringBuffer.toString();
        System.out.println("String representation of the string buffer: " + stringFromStringBuffer);

        // substring(int start)
        String substringFromStart = stringBuffer.substring(5);
        System.out.println("Substring from index 5: " + substringFromStart);

        // substring(int start, int end)
        String substringFromStartToEnd = stringBuffer.substring(10, 20);
        System.out.println("Substring from index 10 to 19: " + substringFromStartToEnd);
    }
}
