// file for the exam 2ip90
// should not be changed

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


