import java.util.Scanner;

public class BankDeposit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первоначальную сумму вклада:");
        double depositAmount = scanner.nextDouble();

        System.out.println("Введите годовую ставку, %");
        double depositRate = scanner.nextDouble();

        System.out.println("Введите количество полных месяцев размещения вклада");
        int depositPeriod = scanner.nextInt();

        double endDepositAmount = depositAmount * (100 + getEffectiveRate(depositRate, depositPeriod));
        System.out.println("Размер вклада по окончанию срока составляет " + endDepositAmount);

        double depositProfit = endDepositAmount - depositAmount;
        System.out.println("Прибыль составила " + depositProfit);
    }

    private static double getEffectiveRate(double depositRate, int depositPeriod) {
        double depositAmount = 1.0;
        for (int i = 1; i <= depositPeriod; i++) {
            depositAmount = depositPeriod * (1 + depositRate / depositPeriod);
        }
        return (depositAmount - 1) * 100;
    }
}