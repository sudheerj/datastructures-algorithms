package java1.algorithms.interval.meetingRooms3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingRooms3 {
    //Using two min heaps(freeRooms, busyRooms) TC: O(n log n) SC: O(n)
    private int mostBooked(int n, int[][] meetings) {
        //Sort by start times;
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            freeRooms.offer(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return Long.compare(a[1], b[1]);

            return Long.compare(a[0], b[0]);
        });

        int[] count = new int[n];

        for(int[] meeting: meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            //release all finished meeting rooms
            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int)busyRooms.poll()[1]);
            }

            int room;
            if(!freeRooms.isEmpty()) {
                room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
            } else {
                long[] earliest = busyRooms.poll();
                room = (int) earliest[1];
                long newEnd = earliest[0] + duration;
                busyRooms.offer(new long[]{newEnd, room});
            }
            count[room]++;
        }

        int roomWithMaxMeetings = 0;
        for(int room=1; room<n; room++) {
            if(count[room] > count[roomWithMaxMeetings]) {
                roomWithMaxMeetings = room;
            }
        }

        return roomWithMaxMeetings;
    }
}
