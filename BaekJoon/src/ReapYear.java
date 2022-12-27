import java.time.LocalDate;

public class ReapYear {
    static int[] day = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue() - 1;
        
        int days = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? day[month] : day[month] - 1;
        System.out.println(days + " days for " + year + "-" + (month + 1));
    }

}
