package corporateFlightBookings;

public class CorporateFlightBookings {
    private int[] corpFlightBookings(int[][] bookings, int n) {
        //Step1: build diff array
        int[] diff = new int[n+1];

        for(int[] booking: bookings) {
            int left = booking[0];
            int right = booking[1];
            int seats = booking[2];

            diff[left] += seats;
            if(right+1 <= n) {
                diff[right] -= seats;
            }
        }

        //Step2: build prefix sum
        int[] result = new int[n];
        int running = 0;

        for(int i=1; i<=n; i++) {
            running += diff[i];
            result[i-1] = running;
        }

        return result;
    }
}
