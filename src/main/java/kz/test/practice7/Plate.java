package kz.test.practice7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void decreaseFood(int n) {
        checkOnEnoughFood(n);
        food -= n;
    }

    private void checkOnEnoughFood(int n) {
        if (food - n < 0) {
            throw new RuntimeException("Слишком мало еды в тарелке: " + food + "\nТребуется: " + n);
        }
    }

    public void fillPlate(int n) {
        food += n;
    }

    //region getters/setters
    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
    //endregion
}
