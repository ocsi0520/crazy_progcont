import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;

class Kopapirollo {
  static TreeMap<String, ArrayList<String>> nyertesek = new TreeMap<String, ArrayList<String>>();
  public static void main(String[] args) {
    Kopapirollo.megold();
  }

  public static void megold() {
    Scanner scanner = new Scanner(System.in);
    while(scanner.hasNext()) {
      String[] sor = scanner.nextLine().split(";");
      String elsoJatekos = sor[0];
      String elsoJel = sor[1];
      String masodikJatekos = sor[2];
      String masodikJel = sor[3];
      String[] kiertekeles = Kopapirollo.kiertekel(elsoJatekos, elsoJel, masodikJatekos, masodikJel);
      if (kiertekeles != null) {
        beletesz(kiertekeles[0], kiertekeles[1]);
      }
    }
    scanner.close();
    kiirat();
  }

  public static String[] kiertekel(String elsoJatekos, String elsoJel, String masodikJatekos, String masodikJel) {
    if (elsoJel.equals(masodikJel)) {
      return null;
    }
    if (elsoJel.equals("ko")) {
      return masodikJel.equals("papir") ? new String[]{masodikJatekos, masodikJel} : new String[]{elsoJatekos, elsoJel};
    }
  
    if (elsoJel.equals("papir")) {
      return masodikJel.equals("ollo") ? new String[]{masodikJatekos, masodikJel} : new String[]{elsoJatekos, elsoJel};
    }

    // if ollo
    return masodikJel.equals("ko") ? new String[]{masodikJatekos, masodikJel} : new String[]{elsoJatekos, elsoJel};
  }

  public static void beletesz(String jatekos, String jel) {
    ArrayList<String> jatekosEddigiNyeresei = nyertesek.get(jatekos);
    if (jatekosEddigiNyeresei == null) {
      ArrayList<String> kezdetiLista = new ArrayList<String>();
      kezdetiLista.add(jel);
      nyertesek.put(jatekos, kezdetiLista); // ez itt bug-os
    } else {
      jatekosEddigiNyeresei.add(jel);
    }
  }

  public static void kiirat() {
    nyertesek.forEach((jatekos, jelek) -> {
      String kiirandoSzoveg = String.format("%s: %s", jatekos, String.join(", ", jelek));
      System.out.println(kiirandoSzoveg);
    });
  }

}