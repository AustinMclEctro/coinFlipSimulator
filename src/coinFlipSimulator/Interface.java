package coinFlipSimulator;

import java.util.Scanner;

/**
 * Singleton class that handles user interface and game navigation.
 * @author Austin
 */
public class Interface {
	private Interface instance = null;
	private String line1 = "------------------";
	private String line2 = "--------  --------";
	private String line3 = "-------    -------";
	private String line4 = "------      ------";
	private String line5 = "-----        -----";
	private String line6 = "----          ----";
	private String line7 = "---            ---";
	private String line8 = "--              --";
	private String line9 = "-                -";
	
	
	/**
	 * Constructor method for user interface of game.
	 */
	protected Interface(){
		if(instance == null){
			System.out.println("======== Coin Simulator 2017 ========");
			System.out.println("         by Austin Sullivan         \n");
			mainMenu();
		}
	}
	
	private void mainMenu(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Main Menu");
		//animation();
		
	}
	


	/**
	 * Method which uses a new thread to create animated interfaces
	 */
	/*
	private void animation(){
		Thread anim = new Thread(){
			
			public void run(){
				int lineState = 1;
				String theLine = null;
				boolean incr = true;		//when true, lineState is incremented at end of while loop
											//when false, lineState is decremented at end of while loop
				
				while(!this.isInterrupted()){
					theLine = "line" + lineState;
					System.out.println(theLine);
					
					if(incr){
						lineState++;
						if(lineState == 10)
							incr = false;
					}
					else{
						lineState--;
						if(lineState == 0)
							incr = true;
					}
					
					try {
						this.wait(400);
					} catch (InterruptedException e) {
						System.out.println("animation thread interrupted!");
						e.printStackTrace();
					}
				}
			}
		};
		anim.start();
	}
	*/
	
	/**
	 * @param millis
	 */
	private void sleep(long millis){
		try{
			Thread.sleep(millis);
		} catch (InterruptedException e){
			System.out.println("Sleep was interrupted!");
			e.printStackTrace();
		}
	}
	
}