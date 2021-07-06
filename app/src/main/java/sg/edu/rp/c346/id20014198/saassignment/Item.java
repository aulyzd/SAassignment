package sg.edu.rp.c346.id20014198.saassignment;

public class Item implements Comparable<Item>{
    private String Exp;
    private int Year;
    private int Month;
    private int Day;
    private String Desc;

    public Item() {
    }

    public Item(String exp, int year, int month, int day, String desc) {
        Exp = exp;
        Year = year;
        Month = month;
        Day = day;
        Desc = desc;
    }

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    @Override
    public String toString() {
        return Exp + " " + (Year + "-" + Month + "-" + Day) + " " +  Desc;
    }

    @Override
    public int compareTo(Item item) {
        return this.Desc.compareTo(item.Desc);
    }


}

