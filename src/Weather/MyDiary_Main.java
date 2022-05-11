package Test1;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class MyDiary_Main {

	  public static void main(String[] args) throws IOException, ParseException {
		  boolean run = true;
		  Scanner sc = new Scanner(System.in);
		  System.out.println("이름을 입력하세요: ");
		  String name = sc.next();
		  System.out.println(name+"님의 다이어리가 생성되었습니다!");
		  while(run) {
			System.out.println("기능을 선택해주세요!");
			System.out.println("-------------------------------------------");
			System.out.println("1. 달력보기 | 2. 날씨보기 | 3. 종료하기");
			System.out.println("-------------------------------------------");
			int menu_num = sc.nextInt();
			
			switch(menu_num) {
			case 1:
				MyCalender myCalender = new MyCalender();
				myCalender.starter();
				System.out.println();
				break;
			case 2:
				
				break;
			case 3:
				System.out.println("다이어리를 종료하겠습니다.");
				return;
			default:
                System.out.println("메뉴중에 골라서 다시 입력해주세요");
                break;
			}
		  }
		  
		  
	        
	    }

}
