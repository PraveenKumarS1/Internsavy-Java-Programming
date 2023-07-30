import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Predefined exchange rates (as of the last update).
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.72);
        // Add more currencies and their exchange rates here if needed.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Currency Converter Application");
        System.out.println("Available currencies: USD, EUR, GBP");

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (e.g., USD): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        double result = convertCurrency(amount, sourceCurrency, targetCurrency);
        if (result != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s.%n", amount, sourceCurrency, result, targetCurrency);
        } else {
            System.out.println("Invalid currencies. Please enter valid currencies from the available options.");
        }

        scanner.close();
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        Double sourceRate = exchangeRates.get(sourceCurrency);
        Double targetRate = exchangeRates.get(targetCurrency);

        if (sourceRate != null && targetRate != null) {
            return amount * (targetRate / sourceRate);
        } else {
            return -1;
        }
    }
}
