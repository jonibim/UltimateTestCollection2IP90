import java.util.ArrayList;
//TODO
// INCOMPLETE NEEDS CLARIFICATIONS

public class AnimalFarm {
    class Animal{
        int food;
        char gender;
        int yBirth;

        public Animal(int food, char gender, int yBirth) {
            this.food = food;
            this.gender = gender;
            this.yBirth = yBirth;
        }

        public Animal() {
        }

        public int getFood() {
            return food;
        }

        public void setFood(int food) {
            this.food = food;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public int getyBirth() {
            return yBirth;
        }

        public void setyBirth(int yBirth) {
            this.yBirth = yBirth;
        }

        @Override
        public String toString() {
            return "Avg. food: "+ food + " kg\n " +
                    "Gender: "+ gender + "\n" +
                    "Birth Year: "+yBirth + "\n";
        }
    }

    class Managers{
        int maxFood;
        int currentLevel;

        public Managers(int maxFood, int currentLevel) {
            this.maxFood = maxFood;
            this.currentLevel = currentLevel;
        }

        public int getMaxFood() {
            return maxFood;
        }

        public void setMaxFood(int maxFood) {
            this.maxFood = maxFood;
        }

        public int getCurrentLevel() {
            return currentLevel;
        }

        public void setCurrentLevel(int currentLevel) {
            this.currentLevel = currentLevel;
        }
    }

    class Stable{
        Managers managers;
        ArrayList<Animal> stash;
        void addAnimals(Animal animal){
            stash.add(animal);
        }

        void removeAnimal(Animal animal){
            stash.remove(animal);
        }





    }
}
