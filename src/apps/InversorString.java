package apps;

import java.util.Scanner;

public class InversorString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma string para inverter: ");
        String original = scanner.nextLine();

        String invertida = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            invertida += original.charAt(i);
        }

        // Exibir o resultado
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }

}
