using System;
using System.Collections.Generic;

public class Program {
  static SortedDictionary<string, List<string>> nyertesek = new SortedDictionary<string, List<string>>();
  public static void Main()
	{
		megold();
	}

  public static void megold() {
    string Line;
    
    while( !String.IsNullOrEmpty( (Line = Console.ReadLine()) ) ) {
      string[] sor = Line.Split(';');
      string elsoJatekos = sor[0];
      string elsoJel = sor[1];
      string masodikJatekos = sor[2];
      string masodikJel = sor[3];
      string[] kiertekeles = kiertekel(elsoJatekos, elsoJel, masodikJatekos, masodikJel);
      if (kiertekeles != null) {
        beletesz(kiertekeles[0], kiertekeles[1]);
      }
    }
    kiirat();
  }

  public static string[] kiertekel(string elsoJatekos, string elsoJel, string masodikJatekos, string masodikJel) {
    if (elsoJel.Equals(masodikJel)) {
      return null;
    }
    if (elsoJel.Equals("ko")) {
      return masodikJel.Equals("papir") ? new string[]{masodikJatekos, masodikJel} : new string[]{elsoJatekos, elsoJel};
    }
  
    if (elsoJel.Equals("papir")) {
      return masodikJel.Equals("ollo") ? new string[]{masodikJatekos, masodikJel} : new string[]{elsoJatekos, elsoJel};
    }

    // if ollo
    return masodikJel.Equals("ko") ? new string[]{masodikJatekos, masodikJel} : new string[]{elsoJatekos, elsoJel};
  }

  public static void beletesz(string jatekos, string jel) {
    if(nyertesek.ContainsKey(jatekos)) {
      nyertesek[jatekos].Add(jel);
    } else {
      List<string> ujJatekosListaja = new List<string>();
      ujJatekosListaja.Add(jel);
      nyertesek.Add(jatekos, ujJatekosListaja);
    }
  }

  public static void kiirat() {
    foreach(var item in nyertesek) {
      string kiirandoSzoveg = string.Format("{0}: {1}", item.Key, string.Join(", ", item.Value));
      Console.WriteLine(kiirandoSzoveg);
    }
  }

}