using System;
using System.Collections.Generic;
using System.IO;

public class Lexikografikusjatek {
  public static void main(String[] args) {
    megold(args[0]);
  }

  static void megold(String filename) {
    HashSet<String> egyediJatekosok = new HashSet<String>();
    StreamReader beolvasandoFajl = new StreamReader(filename);
    String Line;
    while(!string.IsNullOrEmpty((Line = beolvasandoFajl.ReadLine()))) {
      String[] sor = Line.Split(';');
      String nyertJatekos = kiertekel(sor[0], sor[1], sor[2], sor[3], sor[4]);
      egyediJatekosok.Add(nyertJatekos);
    }
    beolvasandoFajl.Close();
    Console.WriteLine(egyediJatekosok.Count);
  }

  static String kiertekel(String jatekos1,String szo1,String jatekos2,String szo2,String jel) {
    if(jel.Equals("+")) {
      if(szo1.CompareTo(szo2) < 0) { // ha előrébb van minusz, ha utána +
        return jatekos2;
      }
      return jatekos1;
    }

    // - esetén
    if(szo1.CompareTo(szo2) < 0) { // ha előrébb van minusz, ha utána +
      return jatekos1;
    }
    return jatekos2;
  }
}