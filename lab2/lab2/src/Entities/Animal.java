package Entities;

public abstract class Animal {
    protected String animalName;
    protected double danger;
    protected long daysWithoutFood;
    protected long lifeLength;

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public double getDanger() {
        return danger;
    }

    public void setDanger(double danger) {
        this.danger = danger;
    }

    public long getDaysWithoutFood() {
        return daysWithoutFood;
    }

    public void setDaysWithoutFood(long daysWithoutFood) {
        this.daysWithoutFood = daysWithoutFood;
    }

    public long getLifeLength() {
        return lifeLength;
    }

    public void setLifeLength(long lifeLength) {
        this.lifeLength = lifeLength;
    }

    @Override
    public String toString() {
        return "Entities.Animal{" +
                "animalName='" + animalName + '\'' +
                ", danger=" + danger +
                ", daysWithoutFood=" + daysWithoutFood +
                ", lifeLength=" + lifeLength +
                '}';
    }

    public Animal(String animalName, double danger, long daysWithoutFood, long lifeLength) {
        this.animalName = animalName;
        this.danger = danger;
        this.daysWithoutFood = daysWithoutFood;
        this.lifeLength = lifeLength;
    }
}