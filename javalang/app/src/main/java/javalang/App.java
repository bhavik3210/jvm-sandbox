package javalang;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println("-".repeat(50));
        System.out.println();
        System.out.println(new App().getGreeting());
    }
}
