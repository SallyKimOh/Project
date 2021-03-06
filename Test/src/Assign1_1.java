import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sae il Kim
 * @course CST8110
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 9. 19.
 *
 * @Modify_User
 * @Modify_date 2016. 9. 19.
 */
public class Assign1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DecimalFormat form = new DecimalFormat("#.##");

		
		try {
		
			Scanner info = new Scanner(System.in);
			int dolM = 0;	//dollars
			int cM=0;		//cents
			
			int tM = 0;		//Toonies
			int lM = 0;		//Loonies
			int qM = 0;		//Quarters
			int dM = 0;		//Dimes
			int nM = 0;		//Nickels
			
			
			System.out.println("Change is good");
//			System.out.print("How many dollars? ");
	
//			String sDolM = info.nextLine();
//
//			
//			//=================== Exception start ===================================//
//			
//			while (true) {
//
//				try {
//					dolM = Integer.parseInt(sDolM);
//					if (dolM < 0 ) {
//						System.out.println("- is not dollars. You have to put in the dollars.");
//						System.out.print("How many dollars? ");
//						sDolM = info.nextLine();
//					} else {
//						break;
//					}
//					
//				} catch (Exception e1) {
//					System.out.println("This is not dollars. You have to put in the dollars.");
//					System.out.print("How many dollars? ");
//					sDolM = info.nextLine();
//					
//				}
//
//			}
//
//			System.out.print("How many cents? ");
//
//			String sTcM = info.nextLine();
//			
//			
//			while (true) {
//
//				try {
//					System.out.println("1");
//					cM = Integer.parseInt(sTcM);
//					System.out.println("11");
//					if (cM < 0 ) {
//						System.out.println("111");
//						System.out.println("- is not cents. You have to put in the cents.");
//						System.out.print("How many cents? ");
//						sTcM = info.nextLine();
//					} else {
//						System.out.println("11111");
//						break;
//					}
//					
//				} catch (Exception e1) {
//					System.out.println("111111");
//					System.out.println("This is not cents. You have to put in the cents.");
//					System.out.print("How many cents? ");
//					sTcM = info.nextLine();
//					
//				}
//
//			}
			
			//=================== Exception end ===================================//

			
			
			//=================== Exception start ===================================//

			while (true) {

				try {
					System.out.print("How many dollars? ");
					dolM = info.nextInt();
					System.out.print("How many cents? ");
					cM = info.nextInt();
					if ((dolM < 0 ) || (cM < 0 )) {
						System.out.println("This is not real Money. Can you put in the Money again?");
					} else {
						break;
					}
					
				} catch (Exception e1) {
					System.out.println("This is not real Money.  You have to put in the number for Money.");
					info.close();
				}

			}
			
			//=================== Exception end ===================================//
			
			
			
			//=================== Real Calculate start ===================================//

			int total = ((dolM*100)+cM) ;

			double d = total/100;
			
			double c = Double.parseDouble(form.format(total%100*0.01));
			
			double reMoney = d+c;
			
			dolM += (cM+2)/100;
			cM = (cM+2) % 100;
			
			tM = dolM / 2;  
			lM = dolM % 2;
			qM = cM / 25;
			dM = cM % 25 / 10;
			nM = cM % 25 % 10 /5;


			if (total%100 > 9) {
				System.out.println("\n$"+ total/100+"."+form.format(total%100) +" requires:"); 
			} else {
				System.out.println("\n$"+ reMoney +" requires:"); 
			}
			
//			System.out.println("\n$"+ dolM + "."+(cM-2) +" requires:"); 
			
			System.out.println(tM + " Toonies"); 
			System.out.println(lM + " Loonies"); 
			System.out.println(qM + " Quarters");
			System.out.println(dM + " Dimes");
			System.out.println(nM + " Nickels");
			
			
			//=================== Real Calculate end ===================================//
			
			
		
		} catch (Exception e) {
			System.out.println("It happens the critical problem.");
			
		
		}
	}

}
