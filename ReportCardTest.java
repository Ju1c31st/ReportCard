

import static org.junit.Assert.*;

import org.junit.Test;

public class ReportCardTest {

	@Test
	public void testSetMarks() {
		double[] a = {45.6, 56.7, 67.8, 78.9};
		ReportCard rc = new ReportCard();
		rc.setMarks(a);
		
		/**
		 * marks should not be a shallow copy of a
		 */
		assertNotEquals(rc.getMarks(), a);
		
		assertEquals(rc.countUnits(), 4);
		for(int i=0; i < a.length; i++) {
			assertEquals(rc.getMark(i), a[i], 0.001);
		}
		double[] b = {-20, 25.6, 26.7, 27.8, 28.9, 120.5};
		rc.setMarks(b);
		assertEquals(rc.countUnits(), 6);
		assertEquals(0, rc.getMark(0), 0.001);
		assertEquals(100, rc.getMark(rc.countUnits() - 1), 0.001);
		for(int i=1; i < b.length - 1; i++) {
			assertEquals(rc.getMark(i), b[i], 0.001);
		}
	}

	@Test
	public void testReportCard() {
		double[] a = {-10, 150, 45.6, 56.7, 67.8, 78.9};
		ReportCard rc = new ReportCard(a);
		assertEquals(rc.countUnits(), 6);
		assertEquals(0, rc.getMark(0), 0.001);
		assertEquals(100, rc.getMark(1), 0.001);
		for(int i=2; i < a.length; i++) {
			assertEquals(rc.getMark(i), a[i], 0.001);
		}	
	}

	@Test
	public void testGetMark() {
		double[] a = {-10, 150, 45.6, 56.7, 67.8, 78.9};
		ReportCard rc = new ReportCard(a);
		assertEquals(0, rc.getMark(0), 0.001);
		assertEquals(100, rc.getMark(1), 0.001);
		assertEquals(45.6, rc.getMark(2), 0.001);
		assertEquals(78.9, rc.getMark(5), 0.001);
		assertEquals(-1, rc.getMark(-1), 0.001);
		assertEquals(-1, rc.getMark(6), 0.001);
	}

	@Test
	public void testGetMarks() {
		double[] a = {45.6, 56.7, 67.8, 78.9};
		ReportCard rc = new ReportCard(a);
		double[] b = rc.getMarks();
		for(int i=0; i < a.length; i++) {
			assertEquals(a[i], b[i], 0.001);
		}
	}

	@Test
	public void testAverage() {
		double[] a = {45.6, 56.7, 67.8, 78.9};
		ReportCard rc = new ReportCard(a);
		assertEquals(62.25, rc.average(), 0.001);
		double[] b = {1, 2, 3, 4};
		rc = new ReportCard(b);
		assertEquals(2.5, rc.average(), 0.001);
		
	}

	@Test
	public void testAllPasses() {
		double[] a = {55.6, 56.7, 67.8, 78.9};
		ReportCard rc = new ReportCard(a);
		assertTrue(rc.allPasses(50));
		double[] b = {5.6, 56.7, 67.8, 78.9};
		rc = new ReportCard(b);
		assertFalse(rc.allPasses(10));
		double[] c = {50.6, 56.7, 67.8, 8.9};
		rc = new ReportCard(c);
		assertFalse(rc.allPasses(10));
	}

	@Test
	public void testScale() {
		double[] a = {55.6, 56.7, 67.8, 78.9};
		ReportCard rc = new ReportCard(a);
		rc.scale(10);
		for(int i=0; i < a.length; i++) {
			assertEquals(a[i]*1.1, rc.getMark(i), 0.001);
		}
	}

	@Test
	public void testStdDev() {
		double[] a = {56.2, 67.5, 90.8};
		ReportCard rc = new ReportCard(a);
		assertEquals(14.405, rc.stdDev(), 0.001);
		double[] b = {6.2, 67.5, 99.8};
		rc = new ReportCard(b);
		assertEquals(38.818, rc.stdDev(), 0.001);
	}

	@Test
	public void testCompareTo() {
		double[] a = {0,2,3,4};
		double[] b = {1,2,3,4};
		double[] c = {1,2,3,4};
		ReportCard rc1 = new ReportCard(a);
		ReportCard rc2 = new ReportCard(b);
		ReportCard rc3 = new ReportCard(c);
		assertEquals(-1, rc1.compareTo(rc2));
		assertEquals(0, rc2.compareTo(rc3));
		assertEquals(1, rc2.compareTo(rc1));
	}

	@Test
	public void testGetGrades() {
		double[] a = {90, 70, 80, 20, 60};
		ReportCard rc = new ReportCard(a);
		String[] exp = {"High Distinction", "Credit", "Distinction", "Fail", "Pass"};
		String[] act = rc.getGrades();
		assertEquals(5, act.length);
		for(int i=0; i < act.length; i++) {
			assertEquals(exp[i], act[i]);
		}
	}
}
