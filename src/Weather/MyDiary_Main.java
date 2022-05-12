package Weather;

import java.io.IOException;
import java.util.Scanner;

public class MyDiary_Main {

	  public static void main(String[] args) throws IOException{
		  boolean run = true;
		  Scanner sc = new Scanner(System.in);
		  System.out.println("이름을 입력하세요: ");
		  String name = sc.next();
		  System.out.println(name+"님의 날씨java가 켜졌습니다!");
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
				System.out.println("날씨정보를 보여드리겠습니다.");
				System.out.println("어떤 정보를 원하십니까?");
				System.out.println("기능을 선택해주세요!");
				System.out.println("-------------------------------------------");
				System.out.println("1. 오늘의 날씨 | 2. 미세먼지 | 3. 종료하기");
				System.out.println("-------------------------------------------");
				int submenu_num = sc.nextInt();
				
				if(submenu_num == 1) {
					ApiExplorer2.ApiExplorer2();
				}
				else if(submenu_num == 3) {
					break;
				}
				break;
			case 3:
				System.out.println("어플을 종료하겠습니다.");
				return;
			default:
                System.out.println("메뉴중에 골라서 다시 입력해주세요");
                break;
			}
		  }
		  
		  
	        
	    }

}
