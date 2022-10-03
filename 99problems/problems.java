import java.util.Scanner;

public class problems {

    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
            int number = scnr.nextInt();
            if (number < 100000) {
                if (number < 100) {
                    if (number < 10) {
                        System.out.println("99");
                    } else {
                        System.out.println("99");
                    }
                } else {
                    if (number < 1000) {
                        int temp = number % 100;
                        if (temp < 49) {
                            System.out.println((number-temp-1));
                        } else {
                            temp -= 99;
                            temp = Math.abs(temp);
                            System.out.println(number+temp);
                        }
                    } else {
                        if (number < 10000) {
                            int temp = number % 100;
                            if (temp < 49) {
                                System.out.println((number-temp-1));
                            } else {
                                temp -= 99;
                                temp = Math.abs(temp);
                                System.out.println(number+temp);
                            }
                        } else {
                            int temp = number % 100;
                            if (temp < 49) {
                                System.out.println((number-temp-1));
                            } else {
                                temp -= 99;
                                temp = Math.abs(temp);
                                System.out.println(number+temp);
                            }
                        }
                    }
                }
            }
        }


    }
}