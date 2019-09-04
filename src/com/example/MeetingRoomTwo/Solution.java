package com.example.MeetingRoomTwo;
import java.util.*;
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 1;
        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            else {
                result++;
            }
            pq.offer(intervals[i][1]);
        }
        return result;

    }
}
