class Student implements User {
    String name;
    int id;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public boolean isLecturer() {
        return false;
    }
}