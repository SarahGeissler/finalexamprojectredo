package pkgEmpty;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void testPMT() {
		double r1 = 0.07;
		int n1 = 40;
		double p = 1454485.55;
		double f = 0;
		boolean t = false;
		double r2 = 0.02;
		int n2 = 20;
		double y1 = 10000;
		double y2 = 2642;
		double ExpectedPayment = 554.13;
		
		Retirement rtm = new Retirement();
		rtm.setiYearsToWork(n1);
		rtm.setdAnnualReturnWorking(r1);
		rtm.setiYearsRetired(n2);
		rtm.setdAnnualReturnRetired(r2);
		rtm.setdRequiredIncome(y1);
		rtm.setdMonthlySSI(y2);
		
		double PMT = rtm.AmountToSave();
		
		System.out.println(PMT);
		assertEquals(ExpectedPayment, PMT, 0.01);
	}
	
	@Test
	public void testPV() {
		double r = 0.02;
		int n = 20;
		double y1 = 10000;
		double y2 = 2642;
		double f = 0;
		boolean t = false;
		double ExpectedAmount = -1454485.55;
		
		Retirement rtm = new Retirement();
		rtm.setiYearsRetired(n);
		rtm.setdAnnualReturnRetired(r);
		rtm.setdRequiredIncome(y1);
		rtm.setdMonthlySSI(y2);
		
		
		double PV = rtm.TotalAmountSaved();
		
		assertEquals(ExpectedAmount, PV, 0.01); 
	}

}
