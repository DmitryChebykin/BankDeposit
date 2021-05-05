import java.util.Scanner;

public class BankDeposit {
    private static final int YEAR_MONTHS_QUANTITY = 12;
    private static Scanner scanner = new Scanner(System.in);
    private static double startDeposit;
    private static double depositPeriod;
    private static double annualInterestRate;

    public static void main(String[] args) {
        getDepositInfo();

        double effectiveRate = getEffectiveRate(annualInterestRate, depositPeriod);
        System.out.printf("При ежемесячной капитализации итоговая ставка равна %.2f%%%n", effectiveRate);

        double finishDeposit = startDeposit * (1 + effectiveRate / 100);
        System.out.printf("Размер вклада по окончанию срока составит %.2f%n", finishDeposit);

        double depositProfit = finishDeposit - startDeposit;
        System.out.printf("Прибыль составит %.2f%n", depositProfit);

        System.out.println("Изменения депозита по месяцам:");
        printDepositChanges();
    }

    private static double getEffectiveRate(double annualInterestRate, double depositPeriod) {
        double depositMultiplier = 1.0;
        double monthlyMultiplier = 1 + annualInterestRate / (YEAR_MONTHS_QUANTITY * 100);

        for (int i = 1; i <= depositPeriod; i++) {
            depositMultiplier *= monthlyMultiplier;
        }

        return (depositMultiplier - 1) * 100;
    }

    private static void getDepositInfo() {
        try {
            System.out.println("Введите первоначальную сумму вклада:");
            startDeposit = scanner.nextDouble();

            System.out.println("Введите годовую ставку, %");
            annualInterestRate = scanner.nextDouble();

            System.out.println("Введите количество полных месяцев размещения вклада");
            depositPeriod = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Некорректные данные, повторите ввод.");
            scanner.nextLine();

            getDepositInfo();
        }
    }

    private static void printDepositChanges() {
        double finishDeposit = startDeposit;
        double monthlyMultiplier = 1 + annualInterestRate / (YEAR_MONTHS_QUANTITY * 100);

        for (int i = 1; i <= depositPeriod; i++) {
            finishDeposit = finishDeposit * monthlyMultiplier;
            double depositProfit = finishDeposit - startDeposit;
            System.out.printf("После %d месяца размер депозита %.2f, прибыль %.2f%n", i, finishDeposit, depositProfit);
        }
    }
}