package kz.test.practice7;

public class Cat {

    private String name;
    private int appetite;
    private boolean hungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        hungry = true;
        System.out.println("Кот по имени : " + name + " с аппетитом: " + appetite + " создан.");
    }

    public void eat(Plate p) {
        try {
            if (p.getFood() >= appetite) {
                p.decreaseFood(appetite);
                hungry = false;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void getHungryStatus() {
        final String hungryStatus = isHungry() ? "Кот " + name + " до сих пор голоден" : "Кот " + name + " сытый";
        System.out.println(hungryStatus);
    }

    //region getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    //endregion
}
