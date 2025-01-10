package entities;

public class PlanningItem {

    private String dayOfWeek;
    private String date;
    private String shift;
    private String UurRegeling;
    private String opvoeder;
    private String amountOfHours;

    // Getter for dayOfWeek
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    // Setter for dayOfWeek
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    // Getter for date
    public String getDate() {
        return date;
    }

    // Setter for date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter for shift
    public String getShift() {
        return shift;
    }

    // Setter for shift
    public void setShift(String shift) {
        this.shift = shift;
    }

    // Getter for UurRegeling
    public String getUurRegeling() {
        return UurRegeling;
    }

    // Setter for UurRegeling
    public void setUurRegeling(String UurRegeling) {
        this.UurRegeling = UurRegeling;
    }

    // Getter for opvoeder
    public String getOpvoeder() {
        return opvoeder;
    }

    // Setter for opvoeder
    public void setOpvoeder(String opvoeder) {
        this.opvoeder = opvoeder;
    }

    // Getter for amountOfHours
    public String getAmountOfHours() {
        return amountOfHours;
    }

    // Setter for amountOfHours
    public void setAmountOfHours(String amountOfHours) {
        this.amountOfHours = amountOfHours;
    }

    @Override
    public String toString() {
        return "PlanningItem{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", date='" + date + '\'' +
                ", shift='" + shift + '\'' +
                ", UurRegeling='" + UurRegeling + '\'' +
                ", opvoeder='" + opvoeder + '\'' +
                ", amountOfHours='" + amountOfHours + '\'' +
                '}';
    }
}
