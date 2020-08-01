import java.io.*;
import java.util.*;
public class shuffle {
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		
		// read in the number of cows
		int n = Integer.parseInt(br.readLine());
		
		// if a cow was in position i after shuffling, then moveTo[i] will
		// be the location that they were in before the shuffle
		int[] moveTo = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			// destination is the location a cow would be after a shuffle
			// if they were originally in position i
			int destination = Integer.parseInt(st.nextToken());;
			moveTo[destination] = i;
		}
		
		// allocate an array to store the observed locations of all cows
		// read in the observations
		int[] finalLocs = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			finalLocs[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
		
		// allocate an array to store the original locations of all cows
		int[] originalLocations = new int[n+1];
		for(int finalPosition = 1; finalPosition <= n; finalPosition++) {
			int currentLocation = finalPosition;
			// reverse three shuffles
			for(int iter = 1; iter <= 3; iter++) {
				currentLocation = moveTo[currentLocation];
			}
			// store the original location of the cow that ended up in finalPosition
			originalLocations[currentLocation] = finalLocs[finalPosition];
		}
		
		// print the answer
		for(int i = 1; i <= n; i++) {
			pw.println(originalLocations[i]);
		}
		pw.close();
	}
}