public class ReportCardClient {

	public static void main(String[] args) {
		ReportCard rc;

		/*
		 * create an array marks for 13 double values
		 * assign values, using a loop, such that,
		 * first value is -10
		 * second value is 0
		 * third value is 10
		 * fourth value is 20
		 * ...
		 */
		 
		 
		double[] marks = new double[13];
		double sum = 0;
		marks[0] = -10;
		for(int i=0; i<marks.length; i++){ 
			marks[i] += sum;
			sum += 10;
		}

		/*
		 * Create a ReportCard object rc by passing array marks
		 */	
		
		rc = new ReportCard(marks);
		/*
		 * Get the list of grades from rc and store in array grades
		 */
		String[] myMarks = rc.getGrades();
		for(int i=0; i<myMarks.length; i++){
			System.out.println( marks[i] +" ("+ myMarks[i] + ")");
		}
		
		
		/*
		 * for each unit, display the mark and grade obtained
		 * in the format
		 * mark (grade)
		 * 
		 * 
		 * 
		 *  desired OUTPUT: 
	 	0.0 (Fail)
		0.0 (Fail)
		10.0 (Fail)
		20.0 (Fail)
		30.0 (Fail)
		40.0 (Fail)
		50.0 (Pass)
		60.0 (Pass)
		70.0 (Credit)
		80.0 (Distinction)
		90.0 (High Distinction)
		100.0 (High Distinction)
		100.0 (High Distinction)
		
		current output: 
		-10.0 (Fail)
		10.0 (Fail)
		20.0 (Fail)
		30.0 (Fail)
		40.0 (Fail)
		50.0 (Pass)
		60.0 (Pass)
		70.0 (Credit)
		80.0 (Distinction)
		90.0 (High Distinction)
		100.0 (High Distinction)
		110.0 (High Distinction)
		120.0 (High Distinction)
		 */

	}
}
