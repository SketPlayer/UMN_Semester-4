public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void addHours(int hoursToAdd) {
        this.hour += hoursToAdd;
    }

    public void addMinute(int minutesToAdd) {
        this.minute += minutesToAdd;
    }

    public void addSeconds(int secondsToAdd) {
        this.second += secondsToAdd;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void addTime(int hoursToAdd, int minutesToAdd, int secondsToAdd) {
        this.hour += hoursToAdd;
        this.minute += minutesToAdd;
        this.second += secondsToAdd;
    }
}
