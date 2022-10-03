import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PeerStream {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class Song {
        int start;
        int buffer;
        int bandwith;
        Song(int s, int b, int bb) {
            start = s;
            buffer = b;
            bandwith = bb;
        }
    }
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        Song[] songs = new Song[n];
        for(int i = 0; i < n; i++) {
            songs[i] = new Song(scanner.nextInt()+c, scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(songs, (o1,o2) -> Integer.compare(o1.buffer, o2.buffer));
        int l = -c, r = songs[songs.length-1].buffer-songs[songs.length-1].start;
        while(l < r){
            int m = (l + r + 1)/2;
            if(solve(songs,m)){
                l = m;
            } else {
                r = m - 1;
            }
        }
        System.out.println(l);
    }

    public static boolean solve(Song[] songs, long bufferAmount) {
        int bandwithPt = 0;
        long buffer = songs[0].buffer;
        PriorityQueue<Long> ends = new PriorityQueue<>();
        long bandwith = 0;
        for(Song s : songs) {
            while(buffer != s.buffer) {
                if(ends.isEmpty()) {
                    buffer = s.buffer;
                    break;
                }
                long end = Math.min(ends.peek(), s.buffer);
                long overflow = 0;
                while(buffer != end) {
                    if(bandwith == 0 || buffer >= songs[bandwithPt].buffer) {
                        if(bandwithPt + 1 == songs.length) return false;
                        bandwith = songs[++bandwithPt].bandwith;
                        continue;
                    }
                    long diff = Math.min(end,songs[bandwithPt].buffer) - buffer;
                    if((diff * ends.size() - overflow) < bandwith) {
                        buffer =  Math.min(end,songs[bandwithPt].buffer);
                        bandwith -= (diff * ends.size() - overflow);
                    } else {
                        buffer +=  (bandwith+overflow)/ends.size();
                        overflow = (bandwith+overflow) % ends.size();
                        bandwith = 0;
                    }
                }
                while(!ends.isEmpty() && ends.peek() <= buffer) ends.poll();
           }
           if(s.start + bufferAmount > s.buffer) ends.add(s.start + bufferAmount);
        }
        return ends.size()==0;
    }
}