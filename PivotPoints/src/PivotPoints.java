/** <p> This program is designed to calculate the main areas of support and resistance from the previous period.</p>

 <p> This program is not yet finished. Some of the main things to be added are Camarilla  and Fibonacci levels</p>
  
 <p>PivotPoints-SOLUTION is free software: you can redistribute it and/or
 modify it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or (at your
 option) any later version.</p>
 	
 <p>This program is distributed in the hope that it will be useful, but
 WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 details.</p>
 
 <p>You should have received a copy of the GNU General Public License along
 with this program. If not, see http://www.gnu.org/licenses/.</p>
 
 <p>Copyright Kiril Anastasov L1087591@live.tees.ac.uk   November-2014 </p>
 */

public class PivotPoints 
{
	

	public static double previousHigh = 2048.4;
	public static double previousLow = 2025.6;
	public static double previousClose = 2042.9;
	public static double pivotPoint;
	public static double resistance1;
	public static double support1; 
	public static double resistance2;
	public static double support2; 
	public static double resistance3;
	public static double support3; 
	
	
	/**PivotPoints is the default constructor.
	 * 
	 */
	public PivotPoints()
	{
		super();
	}
	
	public static void main(String[] args) 
	{
	
		 
		System.out.println("Pivot Point: " + getPivotPoint());
		System.out.println("R1: " + getR1());
		System.out.println("R2: " + getR2());
		System.out.println("R3: " + getR3());
		System.out.println("S1: " + getS1());
		System.out.println("S2: " + getS2());
		System.out.println("S3: " + getS3());
		
	
	}
	
	
	/**getPivotPoint is responsible to return the pivot point.
	 * 
	 * @return pivotPoint
	 */
	public static double getPivotPoint()
	{
		pivotPoint = (previousHigh + previousLow + previousClose) / 3;
		return pivotPoint;
	}
	

	/**getR1 is responsible to return the first Resistance.
	 * 
	 * @return resistance1
	 */
	public static double getR1()
	{
		resistance1 = (2 * pivotPoint) - previousLow;
		return resistance1;
	}
	
	/**getR2 is responsible to return the second Resistance.
	 * 
	 * @return resistance2
	 */
	public static double getR2()
	{
		return pivotPoint + (previousHigh - previousLow);
	}
	
	/**getR3 is responsible to return the third Resistance.
	 * 
	 * @return resistance3
	 */
	public static double getR3()
	{
		resistance3 = resistance1 +  previousHigh - previousLow;
		return resistance3;
	}
	
	/**getS1 is responsible to return the first Resistance.
	 * 
	 * @return support1
	 */
	public static double getS1()
	{
		 support1 = (2 * pivotPoint) - previousHigh;
		 return support1;
	}
	
	/**getS2 is responsible to return the second Resistance.
	 * 
	 * @return support2
	 */
	public static double getS2()
	{
		  support2 =  pivotPoint -  (resistance1  - support1);
		 return support2;
	}
	
	/**getS3 is responsible to return the third Resistance.
	 * 
	 * @return support3
	 */
	public static double getS3()
	{
		 support3 = support1 - (previousHigh - previousLow);
		 return support3;
	}
	
	
	/**setPreviousHigh is responsible for the change of the previous high.
	 * 
	 * @return previousHigh
	 */
	public static void setPreviousHigh(double previousHigh)
	{
		PivotPoints.previousHigh = previousHigh;
	}

	/**setPreviousLow is responsible for the change of the previous low.
	 * 
	 * @return previousLow
	 */
	public static void setPreviousLow(double previousLow)
	{
		PivotPoints.previousLow = previousLow;
	}

	/**setPreviousClose is responsible for the change of the previous close.
	 * 
	 * @return previousClose
	 */
	public static void setPreviousClose(double previousClose) 
	{
		PivotPoints.previousClose = previousClose;
	}

	
	/**setPivotPoint is responsible for the change the pivot point.
	 * 
	 * @return pivotPoint
	 */
	public static void setPivotPoint(double pivotPoint) 
	{
		PivotPoints.pivotPoint = pivotPoint;
	}

	/**setPivotPoint is responsible for the change the first resistance..
	 * 
	 * @return resistance1
	 */
	public static void setResistance1(double resistance1) 
	{
		PivotPoints.resistance1 = resistance1;
	}

	/**setPivotPoint is responsible for the change the first support..
	 * 
	 * @return support1
	 */
	public static void setSupport1(double support1)
	{
		PivotPoints.support1 = support1;
	}

	/**setResistance2 is responsible for the change the second resistance..
	 * 
	 * @return resistance2
	 */
	public static void setResistance2(double resistance2) 
	{
		PivotPoints.resistance2 = resistance2;
	}

	/**setSupport2 is responsible for the change the second support..
	 * 
	 * @return support2
	 */
	public static void setSupport2(double support2)
	{
		PivotPoints.support2 = support2;
	}

	/**setResistance3 is responsible for the change the third resistance..
	 * 
	 * @return resistance3
	 */
	public static void setResistance3(double resistance3)
	{
		PivotPoints.resistance3 = resistance3;
	}

	/**setSupport3 is responsible for the change the third support..
	 * 
	 * @return support3
	 */
	public static void setSupport3(double support3) 
	{
		PivotPoints.support3 = support3;
	}
	
	@Override
	public String toString() {
		return "PivotPoints [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}






//Dax for 17.11.2014
//	Pivot Points: 9235.0   
//	R1: 9287.0
//	R2: 9341.0
//	R3: 9393.0
//	S1: 9181.0
//	S2: 9129.0
//	S3: 9075.0
