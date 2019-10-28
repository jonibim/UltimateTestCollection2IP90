import java.util.ArrayList;

    //TODO
// Complete the assigment Need clarification

    interface User {
        public boolean isLecturer();
    }

    class Employee {
        private String name = "";

        public Employee( String name ) {
            this.name = name;
        }

        public void print() {
            System.out.println( this.toString() );
            // remark: 'System.out.println( this );' would have the same effect
        }

        // the method below will be called by System.out.print when an Employee object is passed to it
        // the method is also called when the + operator is applied
        @Override
        public String toString(){
            return name + " (tu/e)";
        }

    }

    class Room {
        ArrayList<User> visitors;
        String name;

        public Room( String name ) {
            this.name = name;
            visitors = new ArrayList<User>();
        }

        @Override
        public String toString() {
            String result;
            result = "Room: "+name+"\n";
            if ( visitors.isEmpty() ) {
                result += "Currently no visitors.\n";
            } else {
                result += "Current visitors: ";
                for ( User u : visitors ) {
                    result += u.toString()+"  ";
                }
                result += "\n";
            }
            return result;
        }

        boolean hasLecturer() {
            boolean hasLect = false;
            for ( User u : visitors ) {
                hasLect |= u.isLecturer();
            }
            return hasLect;
        }

        // assume user is not in room
        public void enter( User user ) {
            visitors.add( user );
        }

        // assume user is in room
        public void leave( User user ) {
            visitors.remove( user );
        }
    }

