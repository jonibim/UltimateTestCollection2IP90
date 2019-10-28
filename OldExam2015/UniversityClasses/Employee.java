
class Professor extends Employee implements User {

    Professor(String name) {
        super(name);
    }

    @Override
    public boolean isLecturer() {
        return true;
    }

    @Override
    public String toString() {
        return "Prof. " + super.toString();
    }
}
