package co.presciencerx.selenium;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrescienceRX pre = new PrescienceRX();
		
		pre.invokeBrowser();
		pre.login();
		pre.goToCustomersThroughAdmin();
		pre.getCustomers();
		pre.close();
	}

}
