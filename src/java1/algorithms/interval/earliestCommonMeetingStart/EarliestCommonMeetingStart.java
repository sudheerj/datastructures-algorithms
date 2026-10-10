package java1.algorithms.interval.earliestCommonMeetingStart;

import java.util.Arrays;

public class EarliestCommonMeetingStart {
    private static final int MINUTES_PER_DAY = 24 * 60;

    // Each busy row is {person, event, startTime, endTime}; intervals are [start, end).
    public static String earliestCommonMeetingStart(String[][] busy, int duration) {
        if(busy.length == 0) {
            return duration <= MINUTES_PER_DAY ? "00:00" :"-1";
        }


        int n = busy.length;
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = toMinutes(busy[i][2]);
            intervals[i][1] = toMinutes(busy[i][3]);
        }

        // Sorting lets candidate advance through the union of all busy intervals.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int candidate = intervals[0][0];

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // The gap before this interval is large enough for the meeting.
            if(start - candidate >= duration) {
                return toTime(candidate);
            }

            candidate = Math.max(candidate, end+1);
        }

        // Check the remaining time until midnight.
        if (MINUTES_PER_DAY - candidate >= duration) {
            return toTime(candidate);
        }

        return "-1";
    }

    public static int toMinutes(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }

    public static String toTime(int time) {
        int hours = time / 60;
        int minutes = time % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    public static void main(String[] args) {
        String[][][] busyTests = {
                {
                        { "Alice", "work", "00:00", "09:00" },
                        { "Bob", "work", "10:00", "11:00" }
                },
                {
                        { "Alice", "work", "00:00", "09:30" },
                        { "Bob", "work", "09:00", "10:00" }
                },
                {
                        { "Alice", "work", "00:00", "08:00" },
                        { "Bob", "work", "08:30", "12:00" }
                },
                { { "Alice", "work", "00:00", "23:30" } },
                {},
                { { "Alice", "work", "00:00", "23:00" } }
        };
        int[] durations = { 60, 30, 30, 60, 60, 60 };
        String[] expected = { "09:00", "10:00", "08:00", "-1", "00:00", "23:00" };
        String[] labels = {
                "gap before later busy intervals",
                "overlapping busy intervals",
                "meeting fits exactly in a gap",
                "no slot long enough",
                "no busy intervals",
                "meeting fits up to midnight"
        };

        for (int i = 0; i < busyTests.length; i++) {
            String actual = earliestCommonMeetingStart(busyTests[i], durations[i]);
            System.out.println("[" + (actual.equals(expected[i]) ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + actual + " (expected " + expected[i] + ")");
        }
    }
}
