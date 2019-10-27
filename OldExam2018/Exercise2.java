public class Exercise2 {

    static void create() {
        Garden aap;
        Garden noot;
        Garden[] street;
        aap = new Garden();
        noot = aap;
        street = new Garden[10];
        System.out.println(aap.getClass().getName());
        System.out.println(noot.toString());
        System.out.println(street.toString());
    }

    static class Garden {
        int length;
        int width;

        int getArea() {
            return length * width;
        }
    }

    public static void main(String[] args) {
        create();

    }
}

/* What is the number of objects (instances) of class
*  created by the following method?
* 12 objects are created by the method create()
* we first create app
* then we create noot by duplicating aap to noot
* and then we create an array Garden with 10 elements inside
*
 */