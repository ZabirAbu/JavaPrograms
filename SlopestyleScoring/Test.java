public class Test {

	public static void main(String[] args) {
		float[] arrayOfData = {8.09f, 7.9f, 6.45f,6.45f, 8.54f, 9.43f, 8.98f};
		SingleRunResult test = new SingleRunResult(1, arrayOfData);
		System.out.println(test.getResult());
		
		float[] arrayOfData2 = {9.09f, 7.9f, 6.45f,6.45f, 3.56f, 9.43f, 8.98f};
		SingleRunResult test2 = new SingleRunResult(2, arrayOfData2);
		
		Skier sk = new Skier("James", test, test2);
		System.out.println(sk.getResult());

		
		
		
		
	}

}
