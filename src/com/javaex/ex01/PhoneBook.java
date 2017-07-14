package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class PhoneBook {

	private String name;
	private String hp;
	private String company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void showInfo(int num) {
		System.out.println(num + ". " + name + " " + hp + " " + company);
	}
}
