package Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyCalender {
    static MyCalender myCalender = new MyCalender();

    public void starter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("���� �޷� ��� : 1 , ���� �޷� ��� : 2");
        String input = scanner.next();
        switch (input) {
            case "1" :
                buildCurrentCalendar();
                break;
            case "2" :
                int year = getYear();
                int month = getMonth();
                buildPastCalendar(year, month);
                break;
            default:
                System.out.println("�߸��� ��ɾ��Դϴ�. �ٽ� �Է��ϼ���");
                starter();
                break;
        }
    }

    public int getYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n ����� ���ϴ� ������ ���ڷ� �Է��ϼ���.");
        int yearInput = scanner.nextInt();
        if (yearInput <= 0) {
            System.out.println("! ������ ����� �Է��� �ּ���.");
            yearInput = scanner.nextInt();
        }
        return yearInput;
    }

    public int getMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n ����� ���ϴ� ���� ���ڷ� �Է��ϼ���.");
        int monthInput = scanner.nextInt();
        if (monthInput <= 0 || monthInput > 12) {
            System.out.println("���� 1�̻� 12������ ����� �Է��� �ּ���.");
            monthInput = scanner.nextInt();
        }
        return monthInput;
    }

    public int[] getCurrent() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int[] currentYearMonth = {currentYear, currentMonth};
        return currentYearMonth;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        else
            return false;
    }

    public int calMonth1stDayWeek(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        Date currentTime = new Date();
        String YMD = year + "-" + month + "-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(currentTime);
        System.out.println("<���� ��¥�� " + today + "�Դϴ�>");
        try {
            calendar.setTime(formatter.parse(YMD));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        // 1(��) 2(��) 3(ȭ) 4(��) 5(��) 6(��) 7(��)
        return dayNum;
    }

    public void buildCurrentCalendar() {
        //(�⺻�����δ� ���糯¥�� �޷��� ���)
        // 1. ��, �� ����
        int year = myCalender.getCurrent()[0];
        int month = myCalender.getCurrent()[1];
        // 2. �� ������ �ִ��� ���� (2���̸� ���� test, �����̸� �ִ��Ϲ迭=dayDataLeapYear)
        int dayMax = 0;
        int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapTest = isLeapYear(year);
        if (month == 2 && leapTest == true) { //2���̰� ����
            dayMax = dayDataLeapYear[month - 1];
        }
        if (month == 2 && leapTest == false) { //2�������� ����X
            dayMax = dayData[month - 1];
        }
        if (month != 2) { // 2�� �ƴ�
            dayMax = dayData[month - 1];
        }
        // 3. ���� 1���� ���� ���
        int dayWeek1 = calMonth1stDayWeek(year, month); // ���� ���� 1���� ����
        // 4. �޷� ���·� ��� - printCalendar
        printCalendar(year, month, dayMax, dayWeek1);
    }

    public void buildPastCalendar(int year, int month){
        // (��, ���� �Է¹����� �� ��, ���� �޷��� ���.)
        // 1. ��, �� ���� = �Ķ���ͷ� �޾ƿ�
        // 2. �� ������ �ִ��� ���� (2���̸� ���� test, �����̸� �ִ��Ϲ迭=dayDataLeapYear)
        int dayMax = 0;
        int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapTest = isLeapYear(year);
        if (month == 2 && leapTest == true) { //2���̰� ����
            dayMax = dayDataLeapYear[month - 1];
        }
        if (month == 2 && leapTest == false) { //2�������� ����X
            dayMax = dayData[month - 1];
        }
        if (month != 2) { // 2�� �ƴ�
            dayMax = dayData[month - 1];
        }
        // 3. ���� 1���� ���� ���
        int dayWeek1 = calMonth1stDayWeek(year, month); // ���� ���� 1���� ����
        // 4. �޷� ���·� ��� - printCalendar
        printCalendar(year, month, dayMax, dayWeek1);
    }

    public void printCalendar(int year, int month, int dayMax, int dayWeek1) {
        // ���� 1���� ���Ϻ���(dayWeek1) 1~�ִ��� ���.
        System.out.println("========== " + year + "�� " + month + "�� ==========");
        System.out.println("  ��  ��  ȭ  ��  ��  ��  ��  ");
        for (int j = 1; j < dayWeek1; j++) {
        	System.out.print("    "); //
        }
        for (int i = 1; i <= dayMax; i++) {
            if (i < 10) {// �� �ڸ� ���̸� �տ� ���� �� �� �� �߰�
                System.out.print("  " + i + " ");
            }
            if (i >= 10) {
                System.out.print(" " + i + " ");
            }
            // �ٹٲ�
            if ((dayWeek1 - 1 + i ) % 7 == 0) { // ���� = (dayWeek1 - 1) + i �� ������ �� ��.
                System.out.println();//�ٹٲ�
            }
        }
    }
}