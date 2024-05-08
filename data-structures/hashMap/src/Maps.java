import java.util.HashMap;

public class Maps {

    public static void main(String[] args) {

        HashMap<String, Integer> employeeIDs = new HashMap<>();
        employeeIDs.put("Alex", 12345);
        employeeIDs.put("John", 66783);
        employeeIDs.put("Bob", 88937);

        System.out.println(employeeIDs);

        System.out.println(employeeIDs.get("Alex"));

        System.out.println(employeeIDs.containsKey("Bob"));
        System.out.println(employeeIDs.containsKey("Simon"));

        System.out.println(employeeIDs.containsValue(12345));

        employeeIDs.put("Bob", 128376);

        System.out.println(employeeIDs);

        System.out.println(employeeIDs.replace("Bob", 999));
        System.out.println(employeeIDs);

        System.out.println(employeeIDs.replace("Mike", 999));
        System.out.println(employeeIDs);

        System.out.println(employeeIDs.putIfAbsent("Tony", 44444));
        System.out.println(employeeIDs);

        System.out.println(employeeIDs.remove("Tony"));
        System.out.println(employeeIDs);

    }
}