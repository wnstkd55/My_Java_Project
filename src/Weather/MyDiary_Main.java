package Weather;

import java.io.IOException;
import java.util.Scanner;

public class MyDiary_Main {

	  public static void main(String[] args) throws IOException{
		  boolean run = true;
		  Scanner sc = new Scanner(System.in);
		  System.out.println("�̸��� �Է��ϼ���: ");
		  String name = sc.next();
		  System.out.println(name+"���� ����java�� �������ϴ�!");
		  while(run) {
			System.out.println("����� �������ּ���!");
			System.out.println("-------------------------------------------");
			System.out.println("1. �޷º��� | 2. �������� | 3. �����ϱ�");
			System.out.println("-------------------------------------------");
			int menu_num = sc.nextInt();
			
			switch(menu_num) {
			case 1:
				MyCalender myCalender = new MyCalender();
				myCalender.starter();
				System.out.println();
				break;
			case 2:
				System.out.println("���������� �����帮�ڽ��ϴ�.");
				System.out.println("� ������ ���Ͻʴϱ�?");
				System.out.println("����� �������ּ���!");
				System.out.println("-------------------------------------------");
				System.out.println("1. ������ ���� | 2. �̼����� | 3. �����ϱ�");
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
				System.out.println("������ �����ϰڽ��ϴ�.");
				return;
			default:
                System.out.println("�޴��߿� ��� �ٽ� �Է����ּ���");
                break;
			}
		  }
		  
		  
	        
	    }

}
