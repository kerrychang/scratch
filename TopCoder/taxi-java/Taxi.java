public class Taxi {

	public double maxDis(int maxX, int maxY, int taxiDis) {
		if (taxiDis > maxX + maxY) {
			return -1.0;
		}
		
		if (taxiDis <= maxX || taxiDis <= maxY) {
			return taxiDis;
		}
		
		double longer = Math.max(maxX, maxY);
		double shorter = taxiDis - longer;
		double result = Math.sqrt(Math.pow(longer, 2) + Math.pow(shorter, 2));
		
		return result;
	}

}
