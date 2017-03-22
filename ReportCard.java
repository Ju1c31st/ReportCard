

public class ReportCard {
	private double[] marks;

	/**
	 * 
	 * @param val
	 * @param low
	 * @param high
	 * @return low if val < low, 
	 * high if val > high, 
	 * val if val is between low and high
	 */
	private double constrain(double val, int low, int high) {
		  if(val < low) {
		      return low;
		   }
		   if(val > high) {
		      return high;
		   }
		   return val;//to be completed
	}

	/**
	 * DEEP copy m into marks with each item constrained between 0 and 100.
	 * use method {@link this#constrain(double, int, int)}.
	 * For example, if m = {-15.2, 67.4, 126.8}, marks should become
	 * {0, 67.4, 100}, AND mark should be a DEEP copy of m.
	 * @param m (assume m is not null)
	 */
	public void setMarks(double[] m) {
		marks = new double[m.length];
		for(int i=0; i<m.length; i++){
			marks[i] = m[i];
			marks[i] = this.constrain(marks[i], 0 , 100);
		}

		//to be completed
	}

	/**
	 * set the marks using the setter.
	 * @param m (assume m is not null)
	 */
	public ReportCard(double[] m) {
		setMarks(m);
		//to be completed
	}

	/**
	 * marks should become an empty array (of size 0)
	 */
	public ReportCard() {
		marks = new double[0];
		//to be completed
	}

	/**
	 * DO NOT MODIFY
	 * @param index
	 * @return mark at given index. if the index is out of range 
	 * (less than 0 or more than or equal to marks.length), return -1.
	 */
	public double getMark(int index) {
		if(index < 0 || index >= marks.length) {
			return -1;
		}
		return marks[index];
	}

	/**
	 * DO NOT MODIFY
	 * @return a deep copy of array marks
	 */
	public double[] getMarks() {
		double[] result = new double[marks.length];
		for(int i=0; i < marks.length; i++) {
			result[i] = marks[i];
		}
		return result;
	}

	/**
	 * 
	 * @return the average of all marks
	 */
	public double average() {
		double sum = 0;
		for(int i=0; i<marks.length; i++){
			sum += marks[i];
		}
		return sum/marks.length; //completed
	}

	public boolean allPasses(double passMark) {
		boolean passer = false; //assuming no one passed
		for(int i=0; i<marks.length; i++){
			if(marks[i] >= passMark){
				passer = true;
			}
		}
		return passer; //to be completed
	}

	/**
	 * update each mark so it increases by given percentage. For example,
	 * if marks = {60.0, 90.0} before the method is called, it should
	 * become {72.0, 100.0} after the method is called with parameter 20.
	 * Note: 90.0 increased by 20% is 108, but marks should be constrained between
	 * 0 and 100. So, 100.
	 * @param percentage
	 */
	public void scale(double percentage) {
		double boost = percentage/100; //puts the percentage in decimal form for manipulation
		double scaleBy; //this is how much % of the number we are scaling up 
		for(int i=0; i<marks.length; i++){
			 scaleBy = marks[i]*boost; //so we add this % amount to get the increase we want
			 marks[i] += scaleBy;
		}
		//completed
	}

	/**
	 * 
	 * @return standard deviation as calculated by the formula:
	 * https://thekubicle.com/assets/lesson_images/stdev.gif
	 * 
	 * For example, if marks = {56.2, 67.5, 90.8},
	 * average = 71.5
	 * 
	 * square of (56.2 - 71.5) = 234.09
	 * square of (67.5 - 71.5) = 16.0
	 * square of (90.8 - 71.5) = 372.49
	 * 
	 * 234.09 + 16.0 + 372.49 = 622.58
	 * 
	 * 622.58/N = 622.58.3 = 207.53
	 * 
	 * square root of 207.53 = 14.4
	 */
	public double stdDev() {
		
		return 0; //to be completed
	}

	/**
	 * 
	 * @param other
	 * @return 1 if the average mark of calling object is more than average of parameter object
	 * -1 if the average mark of calling object is less than average of parameter object
	 * 0 if the average mark of calling object and the average of parameter object are the same
	 */
	public int compareTo(ReportCard other) {
		if(this.average() > other.average()){
			return 1;
		}
		if(this.average() < other.average()){
			return -1;
		}
		return 0; // completed
	}

	/**
	 * Assume the following grading criteria:
	 * [, 50[ (less than 50): "Fail"
	 * [50, 65[ (more than or equal to 50 and less than 65): "Pass"
	 * [65, 75[ (more than or equal to 65 and less than 75): "Credit"
	 * [75, 85[ (more than or equal to 75 and less than 85): "Distinction"
	 * [85, ] (more than or equal to 85): "High Distinction"
	 * @return an String array of grades corresponding to the marks.
	 * For example, if marks = {67.2, 45.3, 89.4}, the array returned should be
	 * {"Credit", "Fail", "High Distinction"}
	 */
	public String[] getGrades() {
		return new String[10];//to be completed
	}

	/**
	 * 
	 * @return number of units student is enrolled in
	 */
	public int countUnits() {
		
		return 0; //to be completed
	}
}
