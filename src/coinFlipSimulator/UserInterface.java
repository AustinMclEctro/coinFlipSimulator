package coinFlipSimulator;

import java.util.Scanner;

/**
 * Singleton class that handles user interface and game navigation.
 * @author Austin
 */
public class UserInterface {
	
	private UserInterface instance = null;
	
	
	private String line0 = "------------------";
	private String line1 = "--------  --------";
	private String line2 = "-------    -------";
	private String line3 = "------      ------";
	private String line4 = "-----        -----";
	private String line5 = "----          ----";
	private String line6 = "---            ---";
	private String line7 = "--              --";
	private String line8 = "-                -";
	
	private String[] menuLines = new String[] {line0, line1, line2, line3, line4, line5, line6, line7, line8};
	
	private boolean end = false;		//flag which is set when the program is to end
	
	
	
	/**
	 * Constructor method for user interface of game.
	 */
	protected UserInterface(){
		
		if(instance == null){
			System.out.println("\n======== Coin Flip Simulator 2017 ========");
			System.out.println("           by Austin Sullivan         \n");
			mainMenu();
		}
	}
	
	private void mainMenu(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("    Main Menu");
		animation();
		
	}
	


	/**
	 * Method which uses a new thread to create animated interfaces
	 */
	private synchronized void animation(){
		
		Thread anim = new Thread(){
			
			public void run(){
				
				int lineState = 0;
				boolean incr = true;		//when true, lineState is incremented at end of while loop
											//when false, lineState is decremented at end of while loop
				
				while(!end){
					
					System.out.print(menuLines[lineState]+"\r");
					
					
					//logic to control fluctuating menu line (which index of the lines to print)
					//----------------------------------------------------
					if(incr){
						lineState++;
						if(lineState == 8)
							incr = false;
					}
					else{
						lineState--;
						if(lineState == 0)
							incr = true;
					}
					
					try {
						this.sleep(100);
					} catch (InterruptedException e) {
						System.out.println("animation thread interrupted!");
						e.printStackTrace();
					}
					//----------------------------------------------------
					
					
				}
				
				
			}
		};
		anim.start();
	}

	//WHY DID I MAKE THIS?
	//There is a Thread.sleep() method already built into the Thread class. o_O
	/**
	 * @param millis
	 */
	private void rest(int millis){
		try{
			Thread.sleep(millis);
		} catch (InterruptedException e){
			System.out.println("Sleep was interrupted!");
			e.printStackTrace();
		}
	}
	
}