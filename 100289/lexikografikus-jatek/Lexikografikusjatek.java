import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lexikografikusjatek {
  public static void main(String[] args) throws FileNotFoundException {
    megold(args[0]);
  }

  static void megold(String filename) throws FileNotFoundException {
    HashSet<String> egyediJatekosok = new HashSet<String>();
    File beolvasandoFajl = new File(filename);
    Scanner scanner = new Scanner(beolvasandoFajl);
    while(scanner.hasNext()) {
      String[] sor = scanner.nextLine().split(";");
      String nyertJatekos = kiertekel(sor[0], sor[1], sor[2], sor[3], sor[4]);
      egyediJatekosok.add(nyertJatekos);
    }
    scanner.close();
    System.out.println(egyediJatekosok.size());
  }

  static String kiertekel(String jatekos1,String szo1,String jatekos2,String szo2,String jel) {
    if(jel.equals("+")) {
      if(szo1.compareTo(szo2) < 0) { // ha előrébb van minusz, ha utána +
        return jatekos2;
      }
      return jatekos1;
    }

    // - esetén
    if(szo1.compareTo(szo2) < 0) { // ha előrébb van minusz, ha utána +
      return jatekos1;
    }
    return jatekos2;
  }
}