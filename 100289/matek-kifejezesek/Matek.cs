using System;
using System.Collections.Generic;
					
public class Program
{
	static SortedDictionary<int, int> sorbatettErtekek = new SortedDictionary<int, int>();
	public static void Main(string[] args)
	{
    Console.WriteLine("vmi meghalt a progconton");
		// megold();
	}
	
	public static void megold() {
		string line;
		while ((line = Console.ReadLine()) != null)
		{
			string[] sor = line.Split();
			// if(sor.Length != 3) {
			// 	break;
			// }
			int ertek = kiertekel(sor[0], sor[1], sor[2]);
			eltesz(ertek);
		}
		kiir();
	}
	// SortedDictionary
	
	public static int kiertekel(string operandus1, string operatorJel, string operandus2) {
		int a = Int32.Parse(operandus1);
		int b = Int32.Parse(operandus2);
		switch(operatorJel) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "/":
				return a / b;
			case "*":
				return a * b;
			default:
				return a % b;
		}
	}
	
	public static void eltesz(int ertek) {
		if(sorbatettErtekek.ContainsKey(ertek)) {
			sorbatettErtekek[ertek]++;
		} else {
			sorbatettErtekek.Add(ertek,1);
		}
	}
	
	public static void kiir() {
		foreach(var ertek in sorbatettErtekek) {
			//0: 2 db
			Console.WriteLine("{0}: {1} db", ertek.Key, ertek.Value);
		}
	}
}