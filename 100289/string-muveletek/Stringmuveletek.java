import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Stringmuveletek {
  public static void main(String[] args) throws FileNotFoundException {
    megold(args[0]);
  }

  static void megold(String filename) throws FileNotFoundException {
    HashSet<String> egyediSzavak = new HashSet<String>();
    File beolvasandoFajl = new File(filename);
    Scanner scanner = new Scanner(beolvasandoFajl);
    while(scanner.hasNext()) {
      String[] sor = scanner.nextLine().split(" "); // itt lehet, nem szóköz alapján kéne megcsinálni
      String s1 = sor[0];
      String operator = sor[1];
      String s2 = sor[2];
      egyediSzavak.add(osszefuz(s1,operator,s2));
    }
    scanner.close();
    System.out.println(egyediSzavak.size());
  }

  static String osszefuz(String s1, String operator, String s2) {
    if(operator.equals("=>")) {
      return s1.concat(s2);
    }
    return s2.concat(s1);
  }
}