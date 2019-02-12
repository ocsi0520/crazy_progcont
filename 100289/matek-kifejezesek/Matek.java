import java.util.Scanner;
import java.util.TreeMap;

public class Matek {
  static TreeMap<Integer,Integer> vegeredmeny = new TreeMap<Integer, Integer>();
  public static void main(String[] args) {
    Matek.megold();
  }

  public static void megold() {
    Scanner scanIn = new Scanner(System.in);
    while(scanIn.hasNext()) {
      Integer elsoOperandus = scanIn.nextInt();
      String operator = scanIn.next();
      Integer masodikOperandus = scanIn.nextInt();
      
      Integer eredmeny = kiertekel(elsoOperandus, operator, masodikOperandus);
      beletesz(eredmeny);
    }
    scanIn.close();
    Matek.kiirat();
  }

  public static void kiirat() {
    Matek.vegeredmeny.forEach((szam, darabszam) -> {
      String kiirandoSzoveg = String.format("%d: %d db", szam, darabszam);
      System.out.println(kiirandoSzoveg);
    });
  }

  public static void beletesz(Integer eredmeny) {
    Integer eredmenyhezTartozoDarabszam = Matek.vegeredmeny.getOrDefault(eredmeny, 0);
    Matek.vegeredmeny.put(eredmeny, eredmenyhezTartozoDarabszam + 1);
  }

  public static Integer kiertekel(Integer elsoOperandus, String operator, Integer masodikOperandus) {
    switch(operator) {
      case "+":
        return elsoOperandus + masodikOperandus;
      case "-":
        return elsoOperandus - masodikOperandus;
      case "*":
        return elsoOperandus * masodikOperandus;
      case "%":
        return elsoOperandus % masodikOperandus;
      default: // /
        return elsoOperandus / masodikOperandus;
    }
  }
}