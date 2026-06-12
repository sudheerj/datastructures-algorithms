package java1.algorithms.greedy.reorganizeString;

import java.util.PriorityQueue;

public class ReorganizeString {
   //Greedy + MaxHeap. Always pick top 2 frequent elements, place them and repeat. TC: O(n log n) SC: O(n)
   private String reorganizeString(String s) {
        
        int[] freqCount = new int[26];
        for(char ch: s.toCharArray()) {
            freqCount[ch-'a']++;
        }

        //Max heap with frequency count
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1]-a[1]);

        for(int i=0; i<26; i++) {
            if(freqCount[i] > 0) {
                pq.offer(new int[]{i, freqCount[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 1) {
            int[] a =  pq.poll();
            int[] b = pq.poll();

            sb.append(a[0] + 'a').append(b[0] + 'a');

            if(--a[0] > 0) pq.offer(new int[]{a[0], a[1]});
            if(--b[0] > 0) pq.offer(new int[]{b[0], b[1]});
        }

        if(!pq.isEmpty()) {
            int[] last = pq.poll();
            if(last[1] > 1) return "";
            sb.append(last[0]+'a'); 
        }
        return sb.toString();
   } 
}
