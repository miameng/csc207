package e1;

public class TestGaussInteger {

	public static void main(String[] args) {
		System.out.println(new GaussInteger(1, 2));
		System.out.println(new GaussInteger(1, -2));
		System.out.println(new GaussInteger(-1, 0));
		System.out.println(new GaussInteger(0, -2));
		System.out.println(new GaussInteger(-1, 2).add(new GaussInteger(1, -2)));
		System.out.println(new GaussInteger(1, 2).equals(new GaussInteger(1, -2)));
		System.out.println(new GaussInteger(1, 2).getReal());
		System.out.println(new GaussInteger(1, 2).getImag());
		GaussInteger a = new GaussInteger(1, 2);
		a.setReal(10);
		a.setImag(20);
		System.out.println(a);
		System.out.println(a.moduleSquared());
		System.out.println(a.isInvertible());
		System.out.println(new GaussInteger(1, 2).equals("fda"));
	}

}
