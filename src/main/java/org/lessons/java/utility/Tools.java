package org.lessons.java.utility;
public abstract class Tools {

	public static int contaCaratteri(String s, char c) {
		// TODO Auto-generated method stub
		int quante = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.compare(c, s.charAt(i)) == 0) {
				quante++;
			}
		}
		return quante;
	}

	
	
	public static void caricamento(String s) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int volte = s.length();
		if ((volte % 2) == 0) {
			// pari
			for (int i = 0; i < (volte / 2) - 1; i++) {
				System.out.print(" -");
				Thread.sleep(50);
			}
		} else // dispari
		{
			for (int i = 0; i < (volte + 1) / 2; i++) {
				System.out.print("- ");
				Thread.sleep(50);
			}
		}
	}
	
	
	
}
