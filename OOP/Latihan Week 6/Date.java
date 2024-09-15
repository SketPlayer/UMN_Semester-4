public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void addYears(int yearsToAdd) {
        this.year += yearsToAdd;
    }

    public void addMonths(int monthsToAdd) {
        this.month += monthsToAdd;
    }

    public void addDays(int daysToAdd) {
        this.day += daysToAdd;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDate(int daysToAdd, int monthsToAdd, int yearsToAdd) {
        this.year += yearsToAdd;
        this.month += monthsToAdd;
        this.day += daysToAdd;
    }
}
