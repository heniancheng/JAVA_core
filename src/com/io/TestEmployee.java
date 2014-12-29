package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Herry Hacker", 5000, 1978, 12, 1);
		staff[1] = new Employee("Carl Cracker", 75000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 38000, 1990, 3, 15);

		try {
			PrintWriter out = new PrintWriter(new FileWriter(
					"./file/employee.dat"));
			writeData(staff, out);
			out.close();

			BufferedReader in = new BufferedReader(new FileReader(
					"./file/employee.dat"));
			Employee[] newStaff = readDatas(in);
			in.close();

			for (Employee e : newStaff) {
				System.out.println(e);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeData(Employee[] staff, PrintWriter out)
			throws IOException {
		// TODO Auto-generated method stub
		out.println(staff.length);
		for (Employee e : staff) {
			e.writeData(out);
		}
	}

	public static Employee[] readDatas(BufferedReader in)
			throws NumberFormatException, IOException {
		int n = Integer.parseInt(in.readLine());
		Employee[] newStaff = new Employee[n];
		for (int i = 0; i < n; i++) {
			newStaff[i] = new Employee();
			newStaff[i].readData(in);
		}
		return newStaff;
	}
}

class Employee {

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary
				+ ",hireDay=" + hireDay + "]";
	}

	private Date hireDay;
	private String name;
	private double salary;

	public Employee(String name, double salary, int year, int month, int day) {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.hireDay = calendar.getTime();
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public void writeData(PrintWriter out) throws IOException {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name + "|" + salary + "|" + calendar.get(Calendar.YEAR)
				+ "|" + (calendar.get(Calendar.MONTH) + 1) + "|"
				+ calendar.get(Calendar.DAY_OF_MONTH));
	}

	public void readData(BufferedReader in) throws IOException {
		String s;
		s = in.readLine();
		StringTokenizer t = new StringTokenizer(s, "|");
		name = t.nextToken();
		salary = Double.parseDouble(t.nextToken());
		int y = Integer.parseInt(t.nextToken());
		int m = Integer.parseInt(t.nextToken());
		int d = Integer.parseInt(t.nextToken());
		GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
		hireDay = calendar.getTime();

	}
}
