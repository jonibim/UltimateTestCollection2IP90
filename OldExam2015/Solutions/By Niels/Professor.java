class Professor extends Employee implements User {
    public Professor(String name) {
        super(name);
    }
    
    public boolean isLecturer() {
        return true;
    }
    
    @Override
    public String toString(){ 
        return "Prof. " + super.toString();
    }
}