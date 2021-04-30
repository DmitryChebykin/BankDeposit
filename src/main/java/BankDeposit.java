import java.util.Scanner;

public class BankDeposit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первоначальную сумму вклада:");
        int depositAmount = scanner.nextInt();

        System.out.println("Введите годовую ставку, %");
        double depositRate = scanner.nextDouble();

        System.out.println("Введите количество полных месяцев размещения вклада");
        int depositPeriod = scanner.nextInt();

        int endDepositAmount = (int) Math.round(depositAmount * (1 + getEffectiveRate(depositRate, depositPeriod) / 100));
        System.out.printf("Размер вклада по окончанию срока составляет %d%n", endDepositAmount);

        int depositProfit = endDepositAmount - depositAmount;
        System.out.println("Прибыль составила " + depositProfit);
    }

    private static double getEffectiveRate(double depositRate, int depositPeriod) {
        double depositAmount = 1.0;
        for (int i = 1; i <= depositPeriod; i++) {
            depositAmount = depositAmount * (1 + depositRate/1200);
        }
        return (depositAmount - 1) * 100;
    }
}