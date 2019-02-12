using System;
using System.IO;
using System.Collections.Generic;
public class Stringmuveletek {
  public static void Main(string[] args) {
    megold(args[0]);
  }

  static void megold(string filename) {
    HashSet<string> egyediSzavak = new HashSet<string>();
    StreamReader beolvasandoFajl = new StreamReader(filename);
    string Line;
    while(!string.IsNullOrEmpty((Line = beolvasandoFajl.ReadLine()))) {
      string[] sor = Line.Split(' ');
      string s1 = sor[0];
      string op = sor[1];
      string s2 = sor[2];
      egyediSzavak.Add(osszefuz(s1,op,s2));
    }
    beolvasandoFajl.Close();
    Console.WriteLine(egyediSzavak.Count);
  }

  static string osszefuz(string s1, string op, string s2) {
    if(op.Equals("=>")) {
      return s1 + s2;
    }
    return s2 + s1;
  }
}