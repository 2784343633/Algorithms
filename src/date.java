import edu.princeton.cs.algs4.StdOut;

public class date {
    public static final int[] days = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private final int year;
    private final int month;
    private final int day;

    public date(int year, int month, int day){
        if(!isValid(year, month, day)) throw new IllegalArgumentException("Invalid arguments!");
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public date(String s){
        String[] fields = s.split("/");
        int year = Integer.parseInt(fields[0]);
        int month = Integer.parseInt(fields[1]);
        int day = Integer.parseInt(fields[2]);
        if(!isValid(year, month, day)) throw new IllegalArgumentException("Invalid arguments!");
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isValid(int year, int month, int day){
        if(month>12 || month<1)
            return false;
        if(day < 1 || days[month] < day)
            return false;
        if(month == 2 && day == 29 && !isLeapYear(year))
            return false;
        return true;
    }

    public boolean isLeapYear(int year){
        if(year % 400 == 0){
            return true;
        }else if(year % 100 == 0){
            return false;
        }
        return year % 4 == 0;
    }

    public String toString(){
        return this.year + "/" + this.month + "/" + this.day;
    }
    public static void main(String[] args){
        date d1 = new date(2022, 1, 19);
        date d2 = new date("2022/2/28");
        StdOut.printf(d1.toString() + "\n");
        StdOut.printf(d2.toString());

    }
}
