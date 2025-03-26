import java.util.Scanner;

class Time {
    int hr, min,sec,msec;
    public Time(String temp,boolean AdvToggle) {
        String[] parts = temp.split(",");
        this.hr = Integer.parseInt(parts[0]);
        this.min = Integer.parseInt(parts[1]);
        if (AdvToggle) {
            this.sec=Integer.parseInt(parts[2]);
            this.msec=Integer.parseInt(parts[3]);
        }
    }
}

class TimeOps{

    static void sum(int hr1, int min1, int hr2, int min2) {
        int finalhr = 0, finalmin = 0, days = 0;
        finalmin = min1 + min2;
        if (finalmin >= 60) {
            finalmin -= 60;
            finalhr++;
        }
        finalhr += hr1 + hr2;
        if (finalhr >= 24) {
            days++;
            finalhr -= 24;
        }

        if (days != 0) {
            System.out.printf("Sum = %d:%d + %d Days\n", finalhr, finalmin, days);
        } else {
            System.out.printf("Sum = %d:%d\n", finalhr, finalmin);
        }
    }

    static void diff(int hr1, int min1, int hr2, int min2) {
        int finalhr = hr1 - hr2;
        int finalmin = min1 - min2;
        int days=0;

        if (finalmin <= -60) {
            finalmin += 60;
            finalhr--;
        }
        if (finalhr <= -24) {
            finalhr += 24;
            days--;
        }
        if (days != 0) {
            System.out.printf("Difference = %d:%d %d Days\n", finalhr, finalmin, days);
        } else {
            System.out.printf("Difference = %d:%d\n", finalhr, finalmin);
        }
    }
}

class Advanced extends Time{
    public Advanced(String temp){
        super(temp,true);
    }

    public void Display(){
        System.out.printf("Advanced Time = %d:%d:%d:%d\n", this.hr, this.min, this.sec, this.msec);
    }
}

public class TimeTest extends TimeOps{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Time 1 = ");
        String temp = sc.nextLine();
        Time t1 = new Time(temp,false);

        System.out.print("Time 2 = ");
        temp = sc.nextLine();
        Time t2 = new Time(temp,false);

        System.out.print("Advanced Time = ");
        temp = sc.nextLine();
        Advanced a1 = new Advanced(temp);

        System.out.println();

        a1.Display();
        sum(t1.hr, t1.min, t2.hr, t2.min);
        diff(t1.hr, t1.min, t2.hr, t2.min);
        sc.close();
    }
}