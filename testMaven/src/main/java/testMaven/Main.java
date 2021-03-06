package testMaven;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Saisir le nom de votre ville");
		String name = sc.nextLine();
		
		Double latitude = new Double(0);		
		boolean latIsNum = false;
			while(!latIsNum) {
			try {
			System.out.println("Saisir la latitude de votre ville");
			latitude  = Double.valueOf(sc.nextLine());
			latIsNum = true;
			}catch(NumberFormatException e) {
				System.out.println("Veuillez saisir des valeurs numériques bordel !");
			}
		}
			
		Double longitude = new Double(0);
		boolean longIsNum = false;
		while(!longIsNum) {
			try {	
				System.out.println("Saisir la longitude de votre ville");
				longitude  = Double.valueOf(sc.nextLine());
				longIsNum = true;
			} catch(NumberFormatException e) {
				System.out.println("Veuillez saisir des valeurs numériques bordel !");
			}
		}
		
		City city = new City(name,latitude,longitude);
		city.save();
		ArrayList<City> cities = City.listCities();
		
		for(int i = 0 ; i < cities.size() ; i++) {
			System.out.println(
					cities.get(i).getId() + " "+ 
					cities.get(i).getName() + " "+
					cities.get(i).getLatitude() + " "+
					cities.get(i).getLongitude() 
					);
		}
	}
	
	

}
