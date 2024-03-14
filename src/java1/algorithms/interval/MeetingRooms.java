package java1.algorithms.interval;
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
        int prevEndTime = intervals.get(0).end;

        for(int i=1; i< intervals.size(); i++) {
            int startTime = intervals.get(i).start;
            int endTime = intervals.get(i).end;

            if(prevEndTime > startTime) {
                return false;
            }
            prevEndTime = endTime;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(6, 8));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(10, 12));
        System.out.println(canAttendMeetings(intervals));
    }
}
