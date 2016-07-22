package mla.fp2bean.estetic;

public class Estetic {
	private static boolean alreadyCalled = false;
	
	public static void  logFP2Bean() {
		if (!alreadyCalled) {
			print("                                                       ");
			print("  ¤¤¤¤¤¤¤¤¤¤  ¤¤¤¤¤¤¤¤¤¤      ¤¤¤¤¤¤¤¤¤¤   ¤¤¤¤¤¤¤¤¤¤   ");
			print(" ¤¤¤¤¤¤¤¤¤¤  ¤¤¤¤¤¤¤¤¤¤¤¤    ¤¤¤¤¤¤¤¤ ¤¤¤ ¤¤¤¤¤¤¤¤¤¤¤¤  ");
			print(" ¤¤¤         ¤¤¤       ¤¤¤  ¤¤¤      ¤¤¤  ¤¤¤       ¤¤¤ ");
			print(" ¤¤¤         ¤¤¤       ¤¤¤   ¤¤     ¤¤¤   ¤¤¤       ¤¤¤ ");
			print(" ¤¤¤¤¤¤¤¤    ¤¤¤¤¤¤¤¤¤¤¤¤         ¤¤¤     ¤¤¤¤¤¤¤¤¤¤¤¤  ");
			print(" ¤¤¤¤¤¤¤     ¤¤¤¤¤¤¤¤¤¤         ¤¤¤       ¤¤¤¤¤¤¤¤¤¤¤   ");
			print(" ¤¤¤         ¤¤¤              ¤¤¤         ¤¤¤       ¤¤¤ ");
			print(" ¤¤¤         ¤¤¤             ¤¤¤¤   ¤¤¤¤  ¤¤¤       ¤¤¤ ");
			print(" ¤¤¤         ¤¤¤            ¤¤¤¤¤¤¤¤¤¤¤   ¤¤¤¤¤¤¤¤¤¤¤¤  ");
			print("  ¤¤          ¤¤             ¤¤¤¤¤¤¤¤¤     ¤¤¤¤¤¤¤¤¤¤1.0");
			print("                                                       ");
			alreadyCalled=true;
		}
		System.out.println();
	}
	
	private static void print(String line){
//		for(char c : line.toCharArray()){
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				
//			}
//			System.out.print(c);
//		}
		System.out.println(line);
	}

}
