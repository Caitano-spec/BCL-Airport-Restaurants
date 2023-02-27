package cs1810_Restaurants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class restaurantGUI extends JFrame { /**
	 * 
	 */
	// creating the class which extends JFrame, showing that it is derived from the JFrame Class through inheritance,
	private static final long serialVersionUID = 1L;// the type went through structral changes since first created so a serialVersionUID is created by the compiler. (Auto-created by Eclipse) 

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					restaurantGUI frame = new restaurantGUI();//creates a frame 
					frame.setVisible(true);//makes the frame visible 

				} catch (Exception e) {
					e.printStackTrace();
				}


			}

		});
	}




	private JPanel contentPane;
	public static  JTextField passengerName;// the public keyword allows me to access this variable in any class.
	public static  JTextField ticketNo; // The static keyword means that any method in my class can access these variables without needing me to make new objects for them in each method.
	private JTextField engstockCounter;// the private keyword allows these variables to be accessible only in this class
	private JTextField eggRoll_StockCount; // The data type JTextfield is used for the Textboxes in windowsbuilder. 
	private JTextField omelete_StockCount;
	private JTextField pancakes_StockCount;
	private JTextField fish_StockCount;
	private JTextField curry_StockCount;
	private JTextField wagyu_StockCount;
	private JTextField Steak_StockCount;
	private JTextField seafood_StockCount;
	private JTextField mrgpizza_StockCount;
	private JTextField oxtail_StockCount;
	private JTextField chicken_StockCount;
	


	passenger x = new passenger(); // creates an object of the passenger class and then the reference variable x can be used to call it in any method. 


	public static void StockAfterPurchase(JTextField product, JSpinner quantity )
	{

		int StockBeforePurchase = Integer.parseInt(product.getText());; // gets the remaining stock value before a purchase is made by the user and stores it in the StockBeforePurchase variable.
		int numberofitems = (int) quantity.getValue();// gets the integer value of the number selected by the user in the Jspinner and stores it in the numberofitems variable
		
		if (StockBeforePurchase == 0 && numberofitems != 0 ) {// if the remaining stock is 0 then it displays out of stock message.
			JOptionPane.showMessageDialog(null, "Out of Stock ", "Stock Alert",//displays teh stok
					JOptionPane.INFORMATION_MESSAGE);
		}

		else {
			
			

			int StockUpdate = StockBeforePurchase - numberofitems; // calculates the remaining stock value by subtracting the stockbeforepurchase with numberofitems variable and stores the value in the StockUpdate variable.


			
			if(numberofitems > 100) {// if the user tries to buy more than 100 of an item then an error message is displayed.
				JOptionPane.showMessageDialog(null, "You cannot purchase more than 100 of a single menu item.",
						"Error", JOptionPane.ERROR_MESSAGE); 
			}

			if(numberofitems > StockBeforePurchase ) { // if the user tries to buy more than the remaining stock then a message saying the stock will be reloaded in 3 mins appears. 
				JOptionPane.showMessageDialog(null, "This should take 3 mins after which you will be able to make your purchase ",
						"Stock Reloading", JOptionPane.INFORMATION_MESSAGE); 
				timer(product);// calls the timer method passing the JTextfield product. 


			} 
			else {
				if(StockUpdate == 0 && numberofitems > 0 ){ // if the remaining stock after purchase goes to 0 then the timer starts and it restocks after 3 minutes(180000 milliseconds) 
					timer(product);// calls the timer method passing the JTextfield product. 
					product.setText(String.valueOf(StockUpdate));// displays the remaining stock 0 after purchase so if there were 100 remaining stock and the user buys 100 it will display 0. 
					JOptionPane.showMessageDialog(null, "This should take 3 mins after which you will be able to make your purchase", "Stock Reloading",//displays teh stok
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					product.setText(String.valueOf(StockUpdate)); //displays the remaining stock after purchase which was stored in the stockupdate variable and gets the string value of it.
				}


			}	  
		}
	}
	




	public static void  timer(JTextField product ) {//takes in the JTextField as its parameter so it knows which Textbox needs to be restocks. 
		Timer myTimer = new Timer(); 
		TimerTask myTask = new TimerTask()
		{

			public void run() 
			{
				product.setText("100");//updates the item that needs to be restocked. 
				JOptionPane.showMessageDialog(null, " Stock has been reloaded. You can now make your purchase",
						"Stock Alert", JOptionPane.INFORMATION_MESSAGE); 

			}

		};

		myTimer.schedule(myTask, 180000);// after 3 minutes it executes the run method i.e restocking the product.



	}


	/**
	 * Create the frame.
	 */
	public restaurantGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));// creates a border layout for much organised UI, the footer and header were flex layout which means I could add the components anywhere                             
		JPanel headerPanel = new JPanel();//the left, right and center used the absolute layout.
		JPanel footerPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		headerPanel.setLayout(null);
		footerPanel.setLayout(null);

		contentPane.add(headerPanel, BorderLayout.NORTH);//the content pane holds the objects 
		contentPane.add(footerPanel, BorderLayout.SOUTH);
		contentPane.add(leftPanel, BorderLayout.WEST);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		contentPane.add(rightPanel, BorderLayout.EAST);

		//Colours of the Panels 
		headerPanel.setBackground(new Color(0, 0, 0));
		footerPanel.setBackground(Color.BLACK); //this sets the background colour of each of the panels on the UI.
		leftPanel.setBackground(Color.LIGHT_GRAY);
		centerPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setBackground(Color.LIGHT_GRAY);

		//sizes 
		headerPanel.setPreferredSize(new Dimension(800,200));

		JLabel lbl_Logo = new JLabel("New label");
		lbl_Logo.setBackground(new Color(0, 0, 0));
		lbl_Logo.setForeground(new Color(0, 0, 0));
		lbl_Logo.setIcon(new ImageIcon("images\\BCL_Logo3.png"));//gets the logo from the image folder. 
		lbl_Logo.setBounds(0, 0, 336, 150);//sets the size of the logo.
		headerPanel.add(lbl_Logo);

		passengerName = new JTextField();
		passengerName.setBounds(805, 16, 219, 26);
		headerPanel.add(passengerName);
		passengerName.setColumns(10);


		ticketNo = new JTextField();
		ticketNo.setColumns(10);
		ticketNo.setBounds(805, 47, 219, 26);
		headerPanel.add(ticketNo);

		JLabel lbl_PassengerName = new JLabel("Passengers Full Name");// Label used to display text.
		lbl_PassengerName.setForeground(new Color(30, 144, 255));
		lbl_PassengerName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_PassengerName.setBounds(593, 18, 216, 20);
		headerPanel.add(lbl_PassengerName);

		JLabel lbl_TicketNo = new JLabel("Ticket Number");// the ticket number label
		lbl_TicketNo.setForeground(new Color(30, 144, 255));
		lbl_TicketNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_TicketNo.setBounds(645, 49, 148, 20);
		headerPanel.add(lbl_TicketNo);

		JLabel lbl_Title = new JLabel("Welcome to BCL Airport Restaurant");//The title text of the UI
		lbl_Title.setForeground(new Color(30, 144, 255));
		lbl_Title.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_Title.setBounds(362, 85, 614, 51);
		headerPanel.add(lbl_Title);

		JSpinner eng_spinner = new JSpinner();
		eng_spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		eng_spinner.setBounds(326, 5, 59, 28);
		eng_spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leftPanel.add(eng_spinner);

		JSpinner spinner_Eggroll = new JSpinner();
		spinner_Eggroll.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Eggroll.setBounds(326, 99, 59, 28);
		spinner_Eggroll.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leftPanel.add(spinner_Eggroll);

		JSpinner spinner_Omelete = new JSpinner();
		spinner_Omelete.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Omelete.setBounds(326, 193, 59, 28);
		spinner_Omelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leftPanel.add(spinner_Omelete);

		JSpinner spinner_Pancakes = new JSpinner();
		spinner_Pancakes.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Pancakes.setBounds(326, 287, 59, 28);
		spinner_Pancakes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leftPanel.add(spinner_Pancakes);

		JSpinner spinner_Fish = new JSpinner();
		spinner_Fish.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Fish.setBounds(290, 7, 57, 28);
		spinner_Fish.setFont(new Font("Tahoma", Font.PLAIN, 18));
		centerPanel.add(spinner_Fish);

		JSpinner spinner_Curry = new JSpinner();
		spinner_Curry.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Curry.setBounds(300, 97, 55, 28);
		spinner_Curry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		centerPanel.add(spinner_Curry);

		JSpinner spinner_Wagyu = new JSpinner();
		spinner_Wagyu.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Wagyu.setBounds(300, 191, 55, 28);
		spinner_Wagyu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		centerPanel.add(spinner_Wagyu);

		JSpinner spinner_Steak = new JSpinner();
		spinner_Steak.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Steak.setBounds(298, 286, 57, 28);
		spinner_Steak.setFont(new Font("Tahoma", Font.PLAIN, 18));
		centerPanel.add(spinner_Steak);

		JSpinner spinner_Seafood = new JSpinner();
		spinner_Seafood.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Seafood.setBounds(318, 0, 56, 28);
		spinner_Seafood.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rightPanel.add(spinner_Seafood);

		JSpinner spinner_Mrgpizza = new JSpinner();
		spinner_Mrgpizza.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Mrgpizza.setBounds(280, 97, 56, 28);
		spinner_Mrgpizza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rightPanel.add(spinner_Mrgpizza);

		JSpinner spinner_Oxtail = new JSpinner();
		spinner_Oxtail.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Oxtail.setBounds(220, 193, 56, 28);
		spinner_Oxtail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rightPanel.add(spinner_Oxtail);


		JSpinner spinner_Roastchicken = new JSpinner();
		spinner_Roastchicken.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_Roastchicken.setBounds(259, 293, 54, 28);
		spinner_Roastchicken.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rightPanel.add(spinner_Roastchicken);



		JButton btn_BuyButton = new JButton("BUY");
		btn_BuyButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (passenger.validatePassengerDetails() == true ){//once the button is pressed it checks the user has entered the correct passenger name and ticket number if it has then its true and it will execute the below 
					StockAfterPurchase(engstockCounter, eng_spinner); //calls the stockafterpurchase method for each item to update each one of them so the user can make multiple purchases at once.
					StockAfterPurchase(eggRoll_StockCount,spinner_Eggroll);
					StockAfterPurchase(omelete_StockCount,spinner_Omelete);
					StockAfterPurchase(pancakes_StockCount,spinner_Pancakes);
					StockAfterPurchase(fish_StockCount,spinner_Fish);
					StockAfterPurchase(curry_StockCount,spinner_Curry);
					StockAfterPurchase(wagyu_StockCount,spinner_Wagyu);
					StockAfterPurchase(Steak_StockCount,spinner_Steak);
					StockAfterPurchase(seafood_StockCount,spinner_Seafood);
					StockAfterPurchase(mrgpizza_StockCount,spinner_Mrgpizza);
					StockAfterPurchase(oxtail_StockCount,spinner_Oxtail);
					StockAfterPurchase(chicken_StockCount,spinner_Roastchicken);
				
					//once the buy button is pressed and the user details are correct then it will display a confirmation message.
					final ImageIcon icon = new ImageIcon("images/success.png");
					Image image2 = icon.getImage().getScaledInstance(20,20,0);
					JOptionPane.showMessageDialog(null, "Thank you for your purchase", "Order Successful", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image2));; 


				}
				else {
					JOptionPane.showMessageDialog(null, "Passenger Details do not match ", "Error", JOptionPane.ERROR_MESSAGE);
					//if the buy the button is pressed and the user details are incorrect an error message will be shown and the user will not be able to make a purchase.
				}



			}
		});

		btn_BuyButton.setBounds(1027, 16, 114, 57);
		headerPanel.add(btn_BuyButton);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(0, 140, 1300, 60);
		headerPanel.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbl_Breakfast = new JLabel("Breakfast");
		lbl_Breakfast.setForeground(new Color(0, 0, 128));
		lbl_Breakfast.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Breakfast.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lbl_Breakfast);

		JLabel lbl_Lunch = new JLabel("Lunch");
		lbl_Lunch.setForeground(new Color(0, 0, 128));
		lbl_Lunch.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Lunch.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lbl_Lunch);

		JLabel lbl_Dinner = new JLabel("Dinner");
		lbl_Dinner.setForeground(new Color(0, 0, 128));
		lbl_Dinner.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Dinner.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lbl_Dinner);


		footerPanel.setPreferredSize(new Dimension(800,35));




		JLabel lblNewLabel_3 = new JLabel("*Contact the BCL restaurant for information regarding allergens. ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(230, 230, 250));
		lblNewLabel_3.setBounds(31, 0, 1106, 34);
		footerPanel.add(lblNewLabel_3);
		leftPanel.setPreferredSize(new Dimension(400,550));
		leftPanel.setLayout(null);

		JLabel lbl_EnglishBreakfast = new JLabel("Full English Breakfast £5.99");
		lbl_EnglishBreakfast.setBounds(51, 8, 260, 22);
		lbl_EnglishBreakfast.setForeground(new Color(0, 0, 139));
		lbl_EnglishBreakfast.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_EnglishBreakfast.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lbl_EnglishBreakfast);



		JLabel lbl_EngBrkfstInfo = new JLabel("2 fried eggs, 2 hash browns, 1 sausage,mushrooms ");
		lbl_EngBrkfstInfo.setBounds(15, 37, 400, 20);
		lbl_EngBrkfstInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		leftPanel.add(lbl_EngBrkfstInfo);

		JLabel lbl_RemainingStock1 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock1.setBounds(95, 65, 153, 20);
		lbl_RemainingStock1.setFont(new Font("Tahoma", Font.BOLD, 16));
		leftPanel.add(lbl_RemainingStock1);

		JLabel lbl_EggRoll = new JLabel("    Egg & Bacon Bap Roll £4.49");
		lbl_EggRoll.setBounds(46, 102, 266, 22);
		lbl_EggRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_EggRoll.setForeground(new Color(0, 0, 139));
		lbl_EggRoll.setFont(new Font("Tahoma", Font.BOLD, 18));
		leftPanel.add(lbl_EggRoll);



		JLabel lbl_BapInfo = new JLabel("Egg,smoked bacon with slice of cheese & tomato in bun");
		lbl_BapInfo.setBounds(0, 132, 396, 20);
		lbl_BapInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		leftPanel.add(lbl_BapInfo);

		JLabel lbl_RemainingStock2 = new JLabel("Remaining Stock :            ");
		lbl_RemainingStock2.setBounds(94, 157, 208, 20);
		lbl_RemainingStock2.setFont(new Font("Tahoma", Font.BOLD, 16));
		leftPanel.add(lbl_RemainingStock2);

		JLabel lbl_Omelete = new JLabel("Spanish Omelete £3.50");
		lbl_Omelete.setBounds(81, 196, 207, 22);
		lbl_Omelete.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Omelete.setForeground(new Color(0, 0, 139));
		lbl_Omelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		leftPanel.add(lbl_Omelete);


		JLabel lbl_OmeleteInfo = new JLabel("beaten eggs with peas, mushrooms, cheese, potatoes");
		lbl_OmeleteInfo.setBounds(15, 226, 378, 20);
		lbl_OmeleteInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		leftPanel.add(lbl_OmeleteInfo);

		JLabel lbl_RemainingStock3 = new JLabel("Remaining Stock :            ");
		lbl_RemainingStock3.setBounds(97, 251, 208, 20);
		lbl_RemainingStock3.setFont(new Font("Tahoma", Font.BOLD, 16));
		leftPanel.add(lbl_RemainingStock3);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(306, 239, 0, 0);
		leftPanel.add(lblNewLabel_8);

		JLabel lbl_StrawberryPancakes = new JLabel("Strawberry Pancakes £5.99");
		lbl_StrawberryPancakes.setBounds(60, 290, 248, 22);
		lbl_StrawberryPancakes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_StrawberryPancakes.setForeground(new Color(0, 0, 139));
		lbl_StrawberryPancakes.setFont(new Font("Tahoma", Font.BOLD, 18));
		leftPanel.add(lbl_StrawberryPancakes);


		JLabel lbl_PancakesInfo = new JLabel("Fluffy pancakes with fresh  strawberry and syrup");
		lbl_PancakesInfo.setBounds(31, 320, 343, 20);
		lbl_PancakesInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		leftPanel.add(lbl_PancakesInfo);

		JLabel lbl_RemainingStock4 = new JLabel("Remaining Stock :            ");
		lbl_RemainingStock4.setBounds(99, 345, 208, 20);
		lbl_RemainingStock4.setFont(new Font("Tahoma", Font.BOLD, 16));
		leftPanel.add(lbl_RemainingStock4);

		JLabel lbl_dealdescription = new JLabel("*All breakfast items come with a hot drink");
		lbl_dealdescription.setBounds(31, 380, 348, 20);
		lbl_dealdescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_dealdescription.setForeground(new Color(0, 0, 128));
		leftPanel.add(lbl_dealdescription);

		engstockCounter = new JTextField();
		engstockCounter.setForeground(Color.RED);
		engstockCounter.setBackground(Color.LIGHT_GRAY);
		engstockCounter.setText("100");
		engstockCounter.setEditable(false);
		engstockCounter.setBounds(248, 62, 78, 26);
		leftPanel.add(engstockCounter);
		engstockCounter.setColumns(10);

		eggRoll_StockCount = new JTextField();
		eggRoll_StockCount.setText("100");
		eggRoll_StockCount.setForeground(Color.RED);
		eggRoll_StockCount.setEditable(false);
		eggRoll_StockCount.setColumns(10);
		eggRoll_StockCount.setBackground(Color.LIGHT_GRAY);
		eggRoll_StockCount.setBounds(248, 154, 78, 26);
		leftPanel.add(eggRoll_StockCount);

		omelete_StockCount = new JTextField();
		omelete_StockCount.setText("100");
		omelete_StockCount.setForeground(Color.RED);
		omelete_StockCount.setEditable(false);
		omelete_StockCount.setColumns(10);
		omelete_StockCount.setBackground(Color.LIGHT_GRAY);
		omelete_StockCount.setBounds(248, 248, 78, 26);
		leftPanel.add(omelete_StockCount);

		pancakes_StockCount = new JTextField();
		pancakes_StockCount.setText("100");
		pancakes_StockCount.setForeground(Color.RED);
		pancakes_StockCount.setEditable(false);
		pancakes_StockCount.setColumns(10);
		pancakes_StockCount.setBackground(Color.LIGHT_GRAY);
		pancakes_StockCount.setBounds(248, 342, 78, 26);
		leftPanel.add(pancakes_StockCount);
		centerPanel.setPreferredSize(new Dimension(400,550));
		centerPanel.setLayout(null);

		JLabel lbl_FishChips = new JLabel("Fish & Chips £11.99");
		lbl_FishChips.setBounds(98, 11, 175, 22);
		lbl_FishChips.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_FishChips.setForeground(new Color(0, 0, 139));
		lbl_FishChips.setFont(new Font("Tahoma", Font.BOLD, 18));
		centerPanel.add(lbl_FishChips);


		;


		JLabel lbl_FishInfo = new JLabel("choice of cod fillets, haddock and salad ");
		lbl_FishInfo.setBounds(60, 39, 281, 20);
		lbl_FishInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		centerPanel.add(lbl_FishInfo);

		JLabel lbl_CurryClubMeal = new JLabel("Curry Club Meal £10.50");
		lbl_CurryClubMeal.setBounds(82, 101, 209, 22);
		lbl_CurryClubMeal.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CurryClubMeal.setForeground(new Color(0, 0, 139));
		lbl_CurryClubMeal.setFont(new Font("Tahoma", Font.BOLD, 18));
		centerPanel.add(lbl_CurryClubMeal);



		JLabel lbl_CurryInfo = new JLabel("choice of curry with rice, pickle ");
		lbl_CurryInfo.setBounds(60, 130, 258, 20);
		lbl_CurryInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		centerPanel.add(lbl_CurryInfo);

		JLabel lbl_WagyuBeefBurger = new JLabel("Wagyu Beef Burger £9.99");
		lbl_WagyuBeefBurger.setBounds(57, 194, 242, 22);
		lbl_WagyuBeefBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_WagyuBeefBurger.setForeground(new Color(0, 0, 139));
		lbl_WagyuBeefBurger.setFont(new Font("Tahoma", Font.BOLD, 18));
		centerPanel.add(lbl_WagyuBeefBurger);



		JLabel lbl_WagyuInfo = new JLabel("8 oz grilled wagyu beef with tomatoe");
		lbl_WagyuInfo.setBounds(64, 226, 271, 20);
		lbl_WagyuInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		centerPanel.add(lbl_WagyuInfo);

		JLabel lbl_SteakAndChis = new JLabel("Sirloin Steak & Chips £12.99");
		lbl_SteakAndChis.setBounds(28, 289, 273, 22);
		lbl_SteakAndChis.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SteakAndChis.setForeground(new Color(0, 0, 139));
		lbl_SteakAndChis.setFont(new Font("Tahoma", Font.BOLD, 18));
		centerPanel.add(lbl_SteakAndChis);

		JLabel lbl_SteakInfo = new JLabel("choice of Medium Rare, Medium Well & Well done");
		lbl_SteakInfo.setBounds(9, 319, 353, 20);
		lbl_SteakInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		centerPanel.add(lbl_SteakInfo);



		JLabel lbl_dealdescription1 = new JLabel("* All Lunch items come with a choice of drink");
		lbl_dealdescription1.setBounds(4, 381, 367, 20);
		lbl_dealdescription1.setForeground(new Color(0, 0, 128));
		lbl_dealdescription1.setFont(new Font("Tahoma", Font.BOLD, 16));
		centerPanel.add(lbl_dealdescription1);

		JLabel lblNewLabel_7_1_1_1_1_3 = new JLabel("                                                              ");
		lblNewLabel_7_1_1_1_1_3.setBounds(26, 287, 310, 20);
		centerPanel.add(lblNewLabel_7_1_1_1_1_3);

		JLabel lblNewLabel_5_1_3_1_1 = new JLabel("");
		lblNewLabel_5_1_3_1_1.setBounds(341, 297, 0, 0);
		lblNewLabel_5_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		centerPanel.add(lblNewLabel_5_1_3_1_1);

		JLabel lbl_RemainingStock5 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock5.setBounds(100, 64, 153, 20);
		centerPanel.add(lbl_RemainingStock5);

		JLabel lbl_RemainingStock6 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock6.setBounds(100, 154, 153, 20);
		centerPanel.add(lbl_RemainingStock6);

		JLabel lbl_RemainingStock7 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock7.setBounds(100, 249, 153, 20);
		centerPanel.add(lbl_RemainingStock7);

		JLabel lbl_RemainingStock8 = new JLabel("Remaining Stock :            ");
		lbl_RemainingStock8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock8.setBounds(100, 343, 208, 20);
		centerPanel.add(lbl_RemainingStock8);

		fish_StockCount = new JTextField();
		fish_StockCount.setText("100");
		fish_StockCount.setForeground(Color.RED);
		fish_StockCount.setEditable(false);
		fish_StockCount.setColumns(10);
		fish_StockCount.setBackground(Color.LIGHT_GRAY);
		fish_StockCount.setBounds(254, 63, 78, 26);
		centerPanel.add(fish_StockCount);

		curry_StockCount = new JTextField();
		curry_StockCount.setText("100");
		curry_StockCount.setForeground(Color.RED);
		curry_StockCount.setEditable(false);
		curry_StockCount.setColumns(10);
		curry_StockCount.setBackground(Color.LIGHT_GRAY);
		curry_StockCount.setBounds(258, 151, 78, 26);
		centerPanel.add(curry_StockCount);

		wagyu_StockCount = new JTextField();
		wagyu_StockCount.setText("100");
		wagyu_StockCount.setForeground(Color.RED);
		wagyu_StockCount.setEditable(false);
		wagyu_StockCount.setColumns(10);
		wagyu_StockCount.setBackground(Color.LIGHT_GRAY);
		wagyu_StockCount.setBounds(254, 245, 78, 26);
		centerPanel.add(wagyu_StockCount);

		Steak_StockCount = new JTextField();
		Steak_StockCount.setText("100");
		Steak_StockCount.setForeground(Color.RED);
		Steak_StockCount.setEditable(false);
		Steak_StockCount.setColumns(10);
		Steak_StockCount.setBackground(Color.LIGHT_GRAY);
		Steak_StockCount.setBounds(259, 340, 78, 26);
		centerPanel.add(Steak_StockCount);
		rightPanel.setPreferredSize(new Dimension(400, 550));
		rightPanel.setLayout(null);

		JLabel lbl_BoiledSeafoodPlatter = new JLabel("Boiled Seafood Platter £38.50");
		lbl_BoiledSeafoodPlatter.setBounds(48, 3, 265, 22);
		lbl_BoiledSeafoodPlatter.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BoiledSeafoodPlatter.setForeground(new Color(0, 0, 139));
		lbl_BoiledSeafoodPlatter.setFont(new Font("Tahoma", Font.BOLD, 18));
		rightPanel.add(lbl_BoiledSeafoodPlatter);


		JLabel lblSeafoodInfo = new JLabel("Half Lobster, Crab Clusssters, Large Mussels");
		lblSeafoodInfo.setBounds(10, 31, 311, 20);
		lblSeafoodInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rightPanel.add(lblSeafoodInfo);

		JLabel lbl_MarghiritaPizza = new JLabel("Margherita Pizza £10.40");
		lbl_MarghiritaPizza.setBounds(48, 100, 217, 22);
		lbl_MarghiritaPizza.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MarghiritaPizza.setForeground(new Color(0, 0, 139));
		lbl_MarghiritaPizza.setFont(new Font("Tahoma", Font.BOLD, 18));
		rightPanel.add(lbl_MarghiritaPizza);


		JLabel lbl_MrgPizzaInfo = new JLabel("12 inch pizza with marinara sauce and buffalo cheese");
		lbl_MrgPizzaInfo.setBounds(6, 138, 376, 20);
		lbl_MrgPizzaInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rightPanel.add(lbl_MrgPizzaInfo);

		JLabel lbl_ChickenRoast = new JLabel("Oxtail Meal  £9.20");
		lbl_ChickenRoast.setBounds(48, 196, 161, 22);
		lbl_ChickenRoast.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ChickenRoast.setForeground(new Color(0, 0, 139));
		lbl_ChickenRoast.setFont(new Font("Tahoma", Font.BOLD, 18));
		rightPanel.add(lbl_ChickenRoast);


		JLabel lbl_OxtailInfo = new JLabel("Oxtail with fried plantains and  choice of rice and peas,");
		lbl_OxtailInfo.setBounds(6, 226, 388, 20);
		lbl_OxtailInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rightPanel.add(lbl_OxtailInfo);

		JLabel lbl_ChichenRoast = new JLabel("Roast Chichen £12.49");
		lbl_ChichenRoast.setBounds(48, 296, 196, 22);
		lbl_ChichenRoast.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ChichenRoast.setForeground(new Color(0, 0, 139));
		lbl_ChichenRoast.setFont(new Font("Tahoma", Font.BOLD, 18));
		rightPanel.add(lbl_ChichenRoast);


		JLabel lbl_ChickenInfo = new JLabel("chicken with stuffing, potatoes and veggies,");
		lbl_ChickenInfo.setBounds(15, 327, 309, 20);
		lbl_ChickenInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rightPanel.add(lbl_ChickenInfo);

		JLabel lbl_dealdescription2 = new JLabel("*All meals come with sparkling water");
		lbl_dealdescription2.setBounds(29, 386, 307, 20);
		lbl_dealdescription2.setForeground(new Color(0, 0, 128));
		lbl_dealdescription2.setFont(new Font("Tahoma", Font.BOLD, 16));
		rightPanel.add(lbl_dealdescription2);

		JLabel lbl_RemainingStock9 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock9.setBounds(66, 58, 153, 20);
		rightPanel.add(lbl_RemainingStock9);

		seafood_StockCount = new JTextField();
		seafood_StockCount.setText("100");
		seafood_StockCount.setForeground(Color.RED);
		seafood_StockCount.setEditable(false);
		seafood_StockCount.setColumns(10);
		seafood_StockCount.setBackground(Color.LIGHT_GRAY);
		seafood_StockCount.setBounds(221, 55, 78, 26);
		rightPanel.add(seafood_StockCount);

		JLabel lbl_RemainingStock10 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock10.setBounds(66, 169, 153, 20);
		rightPanel.add(lbl_RemainingStock10);

		mrgpizza_StockCount = new JTextField();
		mrgpizza_StockCount.setText("100");
		mrgpizza_StockCount.setForeground(Color.RED);
		mrgpizza_StockCount.setEditable(false);
		mrgpizza_StockCount.setColumns(10);
		mrgpizza_StockCount.setBackground(Color.LIGHT_GRAY);
		mrgpizza_StockCount.setBounds(220, 168, 78, 26);
		rightPanel.add(mrgpizza_StockCount);

		JLabel lbl_RemainingStock11 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock11.setBounds(67, 255, 153, 20);
		rightPanel.add(lbl_RemainingStock11);

		oxtail_StockCount = new JTextField();
		oxtail_StockCount.setText("100");
		oxtail_StockCount.setForeground(Color.RED);
		oxtail_StockCount.setEditable(false);
		oxtail_StockCount.setColumns(10);
		oxtail_StockCount.setBackground(Color.LIGHT_GRAY);
		oxtail_StockCount.setBounds(221, 254, 78, 26);
		rightPanel.add(oxtail_StockCount);

		JLabel lbl_RemainingStock12 = new JLabel("Remaining Stock : ");
		lbl_RemainingStock12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_RemainingStock12.setBounds(66, 350, 153, 20);
		rightPanel.add(lbl_RemainingStock12);

		chicken_StockCount = new JTextField();
		chicken_StockCount.setText("100");
		chicken_StockCount.setForeground(Color.RED);
		chicken_StockCount.setEditable(false);
		chicken_StockCount.setColumns(10);
		chicken_StockCount.setBackground(Color.LIGHT_GRAY);
		chicken_StockCount.setBounds(220, 349, 78, 26);
		rightPanel.add(chicken_StockCount);



	}
}
