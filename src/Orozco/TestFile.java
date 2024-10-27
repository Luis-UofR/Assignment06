package Orozco;
public class TestFile {

    public TestFile() {
        // Constructor
    }

    public void sampleMethod(int x) {
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                System.out.println("Loop: " + i);
            }
        } else if (x == 0) {
            System.out.println("Zero value");
        } else {
            System.out.println("Negative value");
        }
    }

    private String getGreeting(String name) {
        try {
            return "Hello, " + name;
        } catch (Exception e) {
            return "Error!";
        } finally {
            System.out.println("Greeting method executed");
        }
    }

    protected void switchExample(int day) {
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Other day");
                break;
        }
    }
}
