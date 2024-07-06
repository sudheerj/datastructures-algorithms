package java1.algorithms.interval.meetingRooms2;
import java.util.*;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class meetingRooms2 {
    //Two pointer TC: O(n logn) + O(n) ~= O(n), SC: O(n)
    private static int minMeetingRooms1(List<Interval> intervals) {
        int length = intervals.size();
        int[] startTimes = new int[length];
        int[] endTimes = new int[length];
        int minMeetingRooms = 0, count = 0;

        for(int i=0; i<intervals.size(); i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startIndex = 0, endIndex = 0;

        while(startIndex < intervals.size()) {
            if(startTimes[startIndex] < endTimes[endIndex]) {
                count++;
                startIndex++;
            } else {
                count--;
                endIndex++;
            }
            minMeetingRooms = Math.max(minMeetingRooms, count);
        }
        return minMeetingRooms;
    }

    //Priority Queue + sorting:- TC: O(n logn + n) SC: O(n)
    private static int minMeetingRooms2(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>((a, b) -> a.end-b.end);
        priorityQueue.add(intervals.get(0));

        for(int i=1; i< intervals.size(); i++) {
            int endTime = priorityQueue.peek().end;
            int startTime = intervals.get(i).start;
            if(endTime <= startTime) {
                priorityQueue.poll();
            }
            priorityQueue.add(intervals.get(i));
        }

        return priorityQueue.size();
    }

    public static void main(String[] args) {
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(2, 7));
        intervals1.add(new Interval(3, 5));
        intervals1.add(new Interval(3, 9));
        intervals1.add(new Interval(5, 12));
        intervals1.add(new Interval(8, 15));
        intervals1.add(new Interval(9, 14));

        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 5));

        System.out.println(minMeetingRooms1(intervals1));
        System.out.println(minMeetingRooms2(intervals2));
    }
}
