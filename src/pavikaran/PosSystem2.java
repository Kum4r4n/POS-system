package pavikaran;

import java.util.Scanner;

public class PosSystem2 {
	static Scanner scan = new Scanner(System.in);

	public String[] welcome() {
		
		//welcome status of company

		String[] upn;
		upn = new String[2];
		System.out.println("---------------Welcome abc shop pos system-------------");
		System.out.println("\nEnter your username : "); //user name of account
		String una = scan.next();
		System.out.println("\nEnter your password : "); //password of account
		String pas = scan.next();

		upn[0] = una;
		upn[1] = pas;
		return upn;

	}

	//login status
	public void login(String adminun, String adminpw, String uu, String pp, String[] user, String[] pass, int un,
			String[] items, int[] qty, int[] uprice, int itn, String[] salelist, int[] saleitems, int[] salecollection,
			int summ, int billtotal, int balance, int credit) {

		boolean statys = false;
		
		//username and password are correct

		if (adminun.equals(uu) && adminpw.equals(pp)) {
			// admin page
			mainmenu(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
					salecollection, summ, billtotal, balance, credit);
			statys = true;
		} else if (statys == false) {

			for (int i = 0; i < un; i++) {
				// System.out.println("..............");
				if (uu.equals(user[i]) && pp.equals(pass[i])) {
					// user page
					// ps.usermenu();
					mainmenu(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
							salecollection, summ, billtotal, balance, credit);
				}
			}
		} else {
			
			//username and password are incorrect
			System.out.println("your password or username incorrect");
			welcome();
		}

	}
	
	//company main menu

	public void mainmenu(String adminun, String adminpw, String uu, String pp, String[] user, String[] pass, int un,
			String[] items, int[] qty, int[] uprice, int itn, String[] salelist, int[] saleitems, int[] salecollection,
			int summ, int billtotal, int balance, int credit) {
		if (uu.equals("admin")) {
			
			//list of menu
			System.out.println("\n1-Make a sale\n2-Add items\n3-Show Daily summary\n4-Add or Remove user\n00-Logout");
			int inp = scan.nextInt();
			if (inp == 1) {
				makeSale(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (inp == 2) {
				addItems(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (inp == 3) {
				Summary(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (inp == 4) {
				addRemoveUser(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (inp == 00) {
				// logout
				welcome();
			}

		} else {
			System.out.println("\n1-Make a sale\n2-Add items\n3-Show Daily summary\n00-Logout");
			int inp = scan.nextInt();
			if (inp == 0) {

			} else if (inp == 1) {
				makeSale(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (inp == 2) {
				addItems(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (inp == 3) {
				Summary(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (inp == 00) {
				// logout
				welcome(); // logout this run program in begin
			}

		}

	}
	
	//sale option

	public void makeSale(String adminun, String adminpw, String uu, String pp, String[] user, String[] pass, int un,
			String[] items, int[] qty, int[] uprice, int itn, String[] salelist, int[] saleitems, int[] salecollection,
			int summ, int billtotal, int balance, int credit) {

		int n = 1;
		String[] templist;
		templist = new String[n];
		int[] tempqty;
		tempqty = new int[n];
		int[] tempcol;
		tempcol = new int[n];

		System.out.println(" no    items list     qty       price");
		for (int i = 0; i < itn; i++) {
			System.out.println((i + 1) + "     " + items[i] + "         " + qty[i] + "          " + uprice[i]);
		}
		System.out.println("000-close the sale.");
		System.out.println("0-main menu");
		System.out.println("00-logout");
		for (int j = 0; j < 10; j++) {

			System.out.println("select the number to sale item / select options : "); //option
			int it = scan.nextInt();

			if (it == 0) {
				mainmenu(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
						salecollection, summ, billtotal, balance, credit);
			} else if (it == 00) {
				welcome();
			} else if (it == 000) {
				System.out.println("total amount is : billtotal");
			}
			System.out.println("enter the number to qty : ");
			int qtyy = scan.nextInt();

			System.out.println((j + 1) + "    " + qtyy + "    " + it);
			// billtotal=billtotal+(qty*uprice);
		}

		System.out.println("Total : " + billtotal); //total amount 
	}

	
	//add items for billing
	public void addItems(String adminun, String adminpw, String uu, String pp, String[] user, String[] pass, int un,
			String[] items, int[] qty, int[] uprice, int itn, String[] salelist, int[] saleitems, int[] salecollection,
			int summ, int billtotal, int balance, int credit) {
		System.out.println(" no    items list     qty       price");
		for (int i = 0; i < itn; i++) {
			System.out.println((i + 1) + "     " + items[i] + "         " + qty[i] + "          " + uprice[i]);
		}

	}
	
	//summary view for current user

	public void Summary(String adminun, String adminpw, String uu, String pp, String[] user, String[] pass, int un,
			String[] items, int[] qty, int[] uprice, int itn, String[] salelist, int[] saleitems, int[] salecollection,
			int summ, int billtotal, int balance, int credit) {
		int totcol = 0;
		System.out.println("item name        quantity           amount");
		for (int i = 0; i < summ; i++) {
			System.out.println(salelist[i] + "        " + saleitems[i] + "         " + salecollection[i]);
			totcol = totcol + (salecollection[i] * saleitems[i]);

		}
		System.out.println("total collection is : " + totcol);
	}

	
	//add or remove user
	public void addRemoveUser(String adminun, String adminpw, String uu, String pp, String[] user, String[] pass,
			int un, String[] items, int[] qty, int[] uprice, int itn, String[] salelist, int[] saleitems,
			int[] salecollection, int summ, int billtotal, int balance, int credit) {
		for (int i = 0; i < un; i++) {
			System.out.println(user[i] + "        " + pass[i]);
		}
		System.out.println("1-adduser\n2-remove user\n0-main menu\n 00-logout");
		int i2 = scan.nextInt();
		if (i2 == 1) {
			un++;
			System.out.println("enter user name of new use :  "); //type new username
			String i3 = scan.next();
			System.out.println("enter password of new use :  "); //type new password
			String i4 = scan.next();
			user[un - 1] = i3;
			pass[un - 1] = i4;

			addRemoveUser(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
					salecollection, summ, billtotal, balance, credit);
		} else if (i2 == 2) {

			un--;
			addRemoveUser(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems,
					salecollection, summ, billtotal, balance, credit);
		}
	}

	// --------------------------------------------------------------------------------
	//main method for all
	public static void main(String[] args) {

		PosSystem2 ps = new PosSystem2();
		int billtotal = 0, balance = 15000, credit = 0;

		String adminun = "admin";
		String adminpw = "1111";

		int un = 2;

		// --------user array
		String[] user;
		String[] pass;
		user = new String[un];// initialize array
		pass = new String[un];

		// array data
		user[0] = "ca1";
		pass[0] = "1234";
		user[1] = "ca2";
		pass[1] = "1234";

		// --------summary array
		int summ = 2;
		String[] salelist;
		int[] saleitems;
		int[] salecollection;
		salelist = new String[summ];
		saleitems = new int[summ];
		salecollection = new int[summ];

		// -------items array
		int itn = 3;
		String[] items;
		int[] qty;
		int[] uprice;

		items = new String[itn];
		qty = new int[itn];
		uprice = new int[itn];

		items[0] = "book";
		qty[0] = 10;
		uprice[0] = 25;

		items[1] = "pen";
		qty[1] = 110;
		uprice[1] = 205;

		items[2] = "pencil";
		qty[2] = 110;
		uprice[2] = 205;
		// -----------------------------------------

		String[] upn;
		upn = new String[2];
		String uu, pp;

		upn = ps.welcome();
		uu = upn[0];
		pp = upn[1];

		ps.login(adminun, adminpw, uu, pp, user, pass, un, items, qty, uprice, itn, salelist, saleitems, salecollection,
				summ, billtotal, balance, credit);

	}

}
