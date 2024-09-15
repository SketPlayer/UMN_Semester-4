public class DateTime {
    private Date date;
    private Time time;

    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this.date = new Date(year, month, day);
        this.time = new Time(hour, minute, second);
    }

    public DateTime(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public void setDate(int year, int month, int day) {
        this.date.setYear(year);
        this.date.setMonth(month);
        this.date.setDay(day);
    }

    public void setTime(int hour, int minute, int second) {
        this.time.setHour(hour);
        this.time.setMinute(minute);
        this.time.setSecond(second);
    }

    public String toString() {
        return String.format("%s %s", date.toString(), time.toString());
    }
}
