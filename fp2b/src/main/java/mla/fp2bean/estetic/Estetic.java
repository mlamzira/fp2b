package mla.fp2bean.estetic;

public class Estetic {
	private static boolean alreadyCalled = false;
	
	public static void  logFP2Bean() {
		if (!alreadyCalled) {
			print("                                                       ");
			print("  いいいいい  いいいいい      いいいいい   いいいいい   ");
			print(" いいいいい  いいいいいい    いいいい い� いいいいいい  ");
			print(" い�         い�       い�  い�      い�  い�       い� ");
			print(" い�         い�       い�   い     い�   い�       い� ");
			print(" いいいい    いいいいいい         い�     いいいいいい  ");
			print(" いいい�     いいいいい         い�       いいいいい�   ");
			print(" い�         い�              い�         い�       い� ");
			print(" い�         い�             いい   いい  い�       い� ");
			print(" い�         い�            いいいいい�   いいいいいい  ");
			print("  い          い             いいいい�     いいいいい1.0");
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
