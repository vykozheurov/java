
import java.util.Date;

public class prct3 {
    public static void main(String[] args) {

        // test Circle
        Circle circle = new Circle(7);
        System.out.println(circle.toString() + ", circle area: " + String.format("%.3f", circle.get_area()));
        circle.set_radius(32.10);
        System.out.println(circle.toString() + ", circle area: " + String.format("%.3f", circle.get_area()));

        // test Human
        Human human = new Human("Ivan", 18);
        human.set_age(22);//re set age
        human.display_info();

        // test Human head
        Human.Head human_head = human.new Head();
        human_head.think();
        human_head.sleep(false);
        human_head.sleep(true);

        // test Human hand
        Human.Hand human_hand = human.new Hand();
        human_hand.move();
        human_hand.drop_item();
        human_hand.hold_item("cup");
        human_hand.drop_item();

        // test Human leg
        Human.Leg human_leg = human.new Leg();
        human_leg.move();

        // Book class test
        Book book = new Book("ShortStories", "GreyG", new Date());
        System.out.println(book);
        book.set_name("1999");
        book.set_writing_date(new Date(1));
        System.out.println(book);
    }
}

class Circle {
    double radius;
    double diameter;
    // Init
    Circle(double radius) {
        this.radius = radius;
        this.diameter = this.radius * 2;
        System.out.println("Added Circle object (created)");
    }
    // Radius getter
    double get_radius() {
        return this.radius;
    }
    // Radius setter
    void set_radius(double radius) {
        this.radius = radius;
        this.diameter = this.radius * 2;
        System.out.println("Added Radius " + this.radius + " (set)");
    }
    // Area getter
    double get_area() {
        return Math.PI * this.radius * this.radius;
    }
    public String toString() {
        return "Circle radius: " + get_radius() + ", diameter: " + this.diameter;
    }
}

class Human {
    private String name;
    private int age;

    Human(String name, int age) {
        this.name = name;
        this.age =  age;
        System.out.println("Added Human object (created)");
    }

    void display_info() {
        System.out.println("Human name: " + this.name + ", age: " + this.age);
    }

    // Name getter
    String get_name() {
        return this.name;
    }

    // Name setter
    void set_name(String name) {
        this.name = name;
    }

    // Age getter
    int get_age() {
        return this.age;
    }

    // Age setter
    void set_age(int age) {
        if (0 < age && age < 100) {
            this.age = age;
        }
    }

    public String toString() {
        return this.name;
    }

    class Head {
        private boolean is_sleeping = false;

        // Head think method
        void think() {
            System.out.println(name + " is thinking");
        }

        // Head sleep method
        void sleep(boolean is_sleeping) {
            this.is_sleeping = is_sleeping;
            if (this.is_sleeping) System.out.println(name + " now sleeping");
            else System.out.println(name + " now not sleeping");
        }
    }

    class Leg {

        // Leg moving method
        void move() {
            System.out.println(name + "'s leg is moving");
        }
    }

    class Hand {
        private String item_in_hand;

        // Hand moving method
        void move() {
            System.out.println(name + "'s hand is moving");
        }

        // Hand holding item method
        void hold_item(String item) {
            this.item_in_hand = item;
            System.out.println(name + " holds " + this.item_in_hand);
        }

        // Hand dropping item method
        void drop_item() {
            if (item_in_hand != null) {
                System.out.println(name + " dropped " + this.item_in_hand);
                this.item_in_hand = null;
            }
            else{
                System.out.println(name + " had nothing to drop");
            }
        }
    }
}

class Book {
    private String name;
    private String author;
    private Date book_writing_date = new Date();
    Book(String name, String author, Date book_writing_date) {
        this.name = name;
        this.author = author;
        this.book_writing_date = book_writing_date;
        System.out.println("Added Book object (created)");
    }

    // Book name getter
    String get_name() {
        return this.name;
    }

    // Book name setter
    void set_name(String name) {
        this.name = name;
    }

    // Book author getter
    String get_author() {
        return this.author;
    }

    // Book author setter
    void set_author(String author) {
        this.author = author;
    }

    // Book writing date getter
    Date get_writing_date() {
        return this.book_writing_date;
    }

    // Book writing date setter
    void set_writing_date(Date book_writing_date) {
        this.book_writing_date.setTime(book_writing_date.getTime());
    }

    public String toString() {
        return "Book name: " + get_name() + ", author: " + get_author() + ", writing date: " + get_writing_date();
    }
}

