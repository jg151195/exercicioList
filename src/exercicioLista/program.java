package exercicioLista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();

		System.out.printf("How many employees will be registred ? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.printf("ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.printf("NAME: ");
			String name = sc.nextLine();
			System.out.printf("SALARY: ");
			double salary = sc.nextDouble();
			sc.nextLine();
			Employee empregado = new Employee(id, name, salary);
			employees.add(empregado);
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int valor = sc.nextInt();
		Integer pos = findId(employees,valor);
		if (pos == null) {
			System.out.print("This id does not exist !");
		}
		else {
			System.out.printf("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employees.get(pos).increase(percentage);
		}

		for (Employee x : employees) {
			System.out.println(x.toString());
		}

		sc.close();
	}

	public static Integer findId(List<Employee> list, int id) {
		for (int i = 0; i<list.size(); i++) {
			if(list.get(i).getId()==id) {
				return i;
			}
		}
		return null;
	}
}

