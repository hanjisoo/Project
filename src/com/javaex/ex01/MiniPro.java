package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniPro {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		List<PhoneBook> book = new ArrayList<PhoneBook>();

		Reader ir = new FileReader("phoneDB.txt");
		BufferedReader br = new BufferedReader(ir);

		System.out.println("*********************************");
		System.out.println("*	전화번호 관리 프로그램	*");
		System.out.println("*********************************");

		String str;
		while (true) { // menunum누르기 전에 깔려있어야 편함. 이렇게 하면 다른번호 누를때 저 정보가 있음.
			str = br.readLine();
			if (str == null) {
				break;
			}
			String[] data = str.split(",");
			PhoneBook book1 = new PhoneBook();
			book1.setName(data[0]);
			book1.setHp(data[1]);
			book1.setCompany(data[2]);
			book.add(book1);
		}
		boolean run = true;
		while (run) {
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("---------------------------------");
			System.out.print(">메뉴번호:");

			int menunum = sc.nextInt();
			sc.nextLine(); // 출력할 때 줄맞춤 잘 안돼서 써줌.
			switch (menunum) {

			case 1:
				System.out.println("<1.리스트>");
				/*
				 * while (true) { //여기에 쓰면 다른번호 누를때 항상 1번 해줘야돼니깐 번거로워 str = br.readLine(); if
				 * (str == null) { break; } String[] data = str.split(","); PhoneBook book1 =
				 * new PhoneBook();
				 * 
				 * book1.setName(data[0]); book1.setHp(data[1]); book1.setCompany(data[2]);
				 * book.add(book1); }
				 */
				for (int i = 0; i < book.size(); i++) {
					book.get(i).showInfo(i + 1);
				}
				break;

			case 2:
				System.out.println("<2.등록>");
				PhoneBook book1 = new PhoneBook();
				System.out.print(">이름:");
				String name = sc.nextLine();
				System.out.print(">휴대전화:");
				String hp = sc.nextLine();
				System.out.print(">집전화");
				String company = sc.nextLine();
				book1.setName(name);
				book1.setHp(hp);
				book1.setCompany(company);
				book.add(book1);

				Writer os = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(os);

				// 문자열로만들어줘.
				for (int i = 0; i < book.size(); i++) {

					bw.write(book.get(i).getName() + "," + book.get(i).getHp() + "," + book.get(i).getCompany());
					bw.newLine();
				}

				/*
				 * bw.write("정우성,011-0000-23451,02-6552-2341\r\n" +
				 * "유재석,010-5555-5555,02-7552-9994\r\n" + "이효리,011-9999-7777,02-9002-9888\r\n" +
				 * "이정재,010-5555-6643,02-3452-3423\r\n"+name+","+hp+","+company+"\r\n");
				 */
				bw.flush();
				System.out.println("\n" + "[등록되었습니다.]");
				break;

			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호:");
				int personNum = sc.nextInt();
				book.remove(personNum - 1); // list방번호.

				Writer os1 = new FileWriter("phoneDB.txt");
				BufferedWriter bw1 = new BufferedWriter(os1);

				for (int i = 0; i < book.size(); i++) {
					bw1.write(book.get(i).getName() + "," + book.get(i).getHp() + "," + book.get(i).getCompany());
					bw1.newLine();
				}
				bw1.flush(); // 강제비움. 이거 안써줬더니 txt에 아무것도 안써져있음.

				System.out.println("\n" + "삭제되었습니다.");
				break;

			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름:");
				String name1 = sc.nextLine();
				for (int i = 0; i < book.size(); i++) {

					if (book.get(i).getName().contains(name1)) {
						book.get(i).showInfo(i + 1);
					}
				}
				break;

			case 5:
				System.out.println("<5.종료>");
				System.out.println("*********************************");
				System.out.println("*	           감사합니다  	        *");
				System.out.println("*********************************");
				run = false;
				break;

			default:
				System.out.println("다시입력해주세요");
				break;
			}

		}
		br.close();
		sc.close();
	}

}
