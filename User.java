import java.util.Scanner;

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void menu(Library library, Scanner scanner);
}
