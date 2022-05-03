
public class CoreJava1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[5];
		a[0] = 111;
		int arr[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			System.out.println(a[i]);
		}
		String[] name = { "happy", "how", "are", "you" };
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}

		for (String s : name)// for each
		{
			System.out.println(s);
		}
		CoreJava1 cj = new CoreJava1();
		cj.displa();
		int c = news();
		System.out.println(c);

	}

	public String displa() {
		System.out.println("hi");
		return "wow nice";
	}

	public static int news() {
		System.out.println("study");
		return 11;
	}

}
