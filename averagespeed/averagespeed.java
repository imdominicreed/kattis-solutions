import java.util.*;
import java.math.*;


class averagespeed {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigDecimal currTime = BigDecimal.ZERO;
		BigDecimal currSpeed = BigDecimal.ZERO;
		BigDecimal currDistance = BigDecimal.ZERO;
		while(scanner.hasNext()) {
			String[] line = scanner.nextLine().split(" ");
			long nextTime = 0;
			String[] split = line[0].split(":");
			nextTime += Integer.parseInt(split[0]) * 60 * 60;
			nextTime += Integer.parseInt(split[1]) * 60;
			nextTime += Integer.parseInt(split[2]);
			BigDecimal diff = BigDecimal.valueOf(nextTime).subtract(currTime);
			currDistance = currDistance.add(diff.multiply(currSpeed));
			if(line.length == 1) {
				System.out.println(line[0] + " " +String.format("%.2f",currDistance.doubleValue()) + " km");
			} else 
				currSpeed = new BigDecimal(line[1]).divide(BigDecimal.valueOf(3600), 50, RoundingMode.HALF_UP);
				currTime = new BigDecimal(nextTime);
			

		}
	}
}
