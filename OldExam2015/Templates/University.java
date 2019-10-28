import java.util.ArrayList;

//TODO
// Complete the assigment Need clarification

class BuildingTest {
    void demo() {
        Room[] corridor = new Room[3];
        Room hw = new Room("Hallway");
        Room r83 = new Room("Lecture room 1.083");
        Room r3 = new Room("Lecture room 1.003");
        corridor[0] = hw;
        corridor[1] = r83;
        corridor[2] = r3;

        //Building metaforum = new Building( "Metaforum", corridor );

        /*

        User pwop = new Professor( "Pollewop" );
        User fat = new Student( "Fatima", 798 );
        // Professor Pollewop enters the building
        metaforum.moveUser( pwop, hw, true );
        // Fatima enters the building
        metaforum.moveUser( fat, hw, true );
        // Fatima tries to enter room 1.003
        metaforum.moveUser( fat, r3, true );
        // let's see where everybody is in the building
        System.out.println( metaforum ); // will call metaforum.toString()
        // Professor Pollewop enters room 1.083
        metaforum.moveUser( pwop, r83, true );
        // Fatima enters room 1.083
        metaforum.moveUser( fat, r83, true );
        // again, let's have a look at Marauder's Map
        System.out.println( metaforum ); // will call metaforum.toString()

         */
    }

    public static void main(String[] a) {
        (new BuildingTest()).demo();
    }
}


interface User {
    public boolean isLecturer();
}

class Employee {
    private String name = "";

    public Employee(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this.toString());
        // remark: 'System.out.println( this );' would have the same effect
    }

    // the method below will be called by System.out.print when an Employee object is passed to it
    // the method is also called when the + operator is applied
    @Override
    public String toString() {
        return name + " (tu/e)";
    }

}

class Room {
    ArrayList<User> visitors;
    String name;

    public Room(String name) {
        this.name = name;
        visitors = new ArrayList<User>();
    }

    @Override
    public String toString() {
        String result;
        result = "Room: " + name + "\n";
        if (visitors.isEmpty()) {
            result += "Currently no visitors.\n";
        } else {
            result += "Current visitors: ";
            for (User u : visitors) {
                result += u.toString() + "  ";
            }
            result += "\n";
        }
        return result;
    }

    // assume user is not in room
    public void enter(User user) {
        visitors.add(user);
    }

    // assume user is in room
    public void leave(User user) {
        visitors.remove(user);
    }
}

