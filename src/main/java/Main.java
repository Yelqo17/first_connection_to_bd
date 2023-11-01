package main.java;

public class Main {
    public static void main(String[] args) {
        MyConnect myConnect = new MyConnect();
        String select = """
                select *
                from audit_department
                """;
        myConnect.executeSelect(select);
    }
}
