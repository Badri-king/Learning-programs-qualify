import java.util.HashMap;
public class FinancialForecast {
    public static double futureValueRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
       
        return futureValueRecursive(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

   
    private static HashMap<Integer, Double> memo = new HashMap<>();

    public static double futureValueMemoized(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double value = futureValueMemoized(initialValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, value);
        return value;
    }

    public static void main(String[] args) {
        double initialValue = 10000;       
        double growthRate = 0.08;          
        int years = 10;                    
        double recursiveValue = futureValueRecursive(initialValue, growthRate, years);
        System.out.printf(" Recursive Future Value after %d years: ₹%.2f\n", years, recursiveValue);

        double memoizedValue = futureValueMemoized(initialValue, growthRate, years);
        System.out.printf(" Optimized (Memoized) Future Value after %d years: ₹%.2f\n", years, memoizedValue);
    }
}
