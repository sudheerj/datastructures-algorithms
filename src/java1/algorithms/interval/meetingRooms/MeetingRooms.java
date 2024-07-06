//TC: O(n logn)+ O(n) SC:O(1)

package java1.algorithms.interval.meetingRooms;
import java.util.*;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRooms {
    
    private static boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i=1; i< intervals.size(); i++) {
            int startTime = intervals.get(i).start;
            int prevEndTime = intervals.get(i-1).end;

            if(prevEndTime > startTime) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals1 = new ArrayList<Interval>();
        intervals1.add(new Interval(1, 3));
        intervals1.add(new Interval(3, 7));
        intervals1.add(new Interval(6, 8));
        intervals1.add(new Interval(8, 10));
        intervals1.add(new Interval(10, 12));

        List<Interval> intervals2 = new ArrayList<Interval>();
        intervals2.add(new Interval(1, 5));
        intervals2.add(new Interval(5, 7));
        intervals2.add(new Interval(8, 10));

        System.out.println(canAttendMeetings(intervals1));
        System.out.println(canAttendMeetings(intervals2));
    }
}
