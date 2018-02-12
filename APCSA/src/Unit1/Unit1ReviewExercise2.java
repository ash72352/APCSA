package Unit1;

public class Unit1ReviewExercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String helloWorld = "Hello World!";
		String helleWerld = helloWorld.replace('o','e');
		String holl = helleWerld.substring(0,4);
		holl = holl.replace('e', 'o');
		String holleWerld = holl + helleWerld.substring(4);
		System.out.println(helloWorld + " turns into " + holleWerld + ".");
		
	}

}
