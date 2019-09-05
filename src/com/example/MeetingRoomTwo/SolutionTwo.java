package com.example.MeetingRoomTwo;
import java.util.*;
public class SolutionTwo {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startPoint = 0;
        int endPoint = 0;
        int result = 0;

        while (startPoint < intervals.length) {
            if (start[startPoint] >= end[endPoint]) {
                endPoint++;
            }
            else {
                result++;
            }
            startPoint++;
        }
        return result;
    }
}

