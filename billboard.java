import java.io.*;
import java.util.*;
public class billboard {
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		// read in the locations of the first billboard
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		// read in the locations of the second billboard
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		
		// read in the locations of the truck
		st = new StringTokenizer(br.readLine());
		int x5 = Integer.parseInt(st.nextToken());
		int y5 = Integer.parseInt(st.nextToken());
		int x6 = Integer.parseInt(st.nextToken());
		int y6 = Integer.parseInt(st.nextToken());
		
		// the visible area is the sum of the visible area of the first billboard and the second billboard
		int combinedArea = visibleArea(x1, y1, x2, y2, x5, y5, x6, y6) + visibleArea(x3, y3, x4, y4, x5, y5, x6, y6);
		
		// print the answer
		pw.println(combinedArea);
		pw.close();
	}
	
	/**
	 * Given the lower-left and upper-right corners of a rectangle, return the area of the rectangle
	 * @param x1 x-coordinate of lower-left corner
	 * @param y1 y-coordinate of lower-left corner
	 * @param x2 x-coordinate of upper-right corner
	 * @param y2 y-coordinate of upper-right corner
	 * @return area of the rectangle
	 */
	public static int areaOfRectangle(int x1, int y1, int x2, int y2) {
		return (x2-x1)*(y2-y1);
	}
	
	/**
	 * Given the corners of two rectangles, return the area inside the first rectangle
	 * but outside the second
	 * @param x1 x-coordinate of lower-left corner of first rectangle
	 * @param y1 y-coordinate of lower-left corner of first rectangle
	 * @param x2 x-coordinate of upper-right corner of first rectangle
	 * @param y2 y-coordinate of upper-right corner of first rectangle
	 * @param x3 x-coordinate of lower-left corner of second rectangle
	 * @param y3 y-coordinate of upper-right corner of second rectangle
	 * @param x4 x-coordinate of lower-left corner of second rectangle
	 * @param y4 y-coordinate of upper-right corner of second rectangle
	 * @return
	 */
	public static int visibleArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		// start by computing the area that would be visible if there were no second rectangle
		int visibleArea = areaOfRectangle(x1, y1, x2, y2);
		
		// compute the boundaries of the intersection
		int leftmostBlockedX = Math.max(x1, x3);
		int rightmostBlockedX = Math.min(x2, x4);
		int bottommostBlockedY = Math.max(y1, y3);
		int topmostBlockedY = Math.min(y2, y4);
		// if the second rectangle does exist, subtract out the area that it blocks
		if(leftmostBlockedX < rightmostBlockedX && bottommostBlockedY < topmostBlockedY) {
			visibleArea -= areaOfRectangle(leftmostBlockedX, bottommostBlockedY, rightmostBlockedX, topmostBlockedY);
		}
		
		return visibleArea;
	}
	
}