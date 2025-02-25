import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];//
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][1]]++;
            if (!map.containsKey(prerequisites[i][0])) {
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int count=0;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                q.add(i);
                count++;
            }

        }
        if(count==numCourses) return true;
        if(q.isEmpty()) return false;

        while(!q.isEmpty()){
            int course = q.poll();
            List <Integer> children = map.get(course);
            if(children != null){
                for(Integer child : children){
                    degrees[child]--;
                    if(degrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }

        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] != 0) return false;
        }

        return true;
    }
}
/**
 {[2,0],[5,4],[3,2],[3,1],[1,0],[4,1],[5,3]}

 degree array  - 0,1,1,2,1,3
         index - 0,1,2,3,4,5

 adj list: dependant-independent no
           independent-dependent yes for this senario
 */
