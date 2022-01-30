package step2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupPhoto {
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		int n1 = 2;
		int n2 = 2;
		String[] data1 = {"N~F=0", "R~T>2"};
		String[] data2 = {"M~C<2", "C~M>1"};
		System.out.println(s.solution(n1, data1));
		System.out.println(s.solution(n2, data2));
	}
}


class Solution4 {
    static String[] frinds = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int cnt = 0;
    static String[] val;
    static boolean[] flag = new boolean[8];

    public static void validation(Map<String, Integer> arr){
        //"N~F=0", "R~T>2"
        Boolean[] f = new Boolean[val.length];
        for(int i = 0; i < val.length ; i++){
            String s = val[i];
            String oprand1 = s.substring(0,1) ;
            String oprand2 = s.substring(2,3) ;
            String op = s.substring(3,4) ;
            int v = Integer.parseInt(s.substring(4))+1 ;

            if(op.equals("=") && Math.abs(arr.get(oprand1) - arr.get(oprand2)) == v){
                f[i] = true;
            }else if(op.equals("<") && Math.abs(arr.get(oprand1) - arr.get(oprand2)) < v){
                f[i] = true;
            }else if (op.equals(">") && Math.abs(arr.get(oprand1) - arr.get(oprand2)) > v){
                f[i] = true;
            }else{
                f[i] = false;
            }


        }
        if(!Arrays.asList(f).contains(false))
            cnt++;
    }

    public void dfs(boolean[] flag, Map<String, Integer> arr, int level){
        if(level == 8){
            // System.out.println(arr.toString());
            validation(arr);
            return;
        }


        for(int i = 0 ; i < 8; i++){
            if(!flag[i]){
                flag[i] = true;
                arr.put(frinds[i], level);

                dfs(flag, arr, level+1);

                flag[i] = false;
            }
        }
    }



    public int solution(int n, String[] data) {
        Map<String, Integer> arr = new HashMap<>();
        Arrays.fill(flag, false);

        val = data;
        cnt = 0;

        dfs(flag, arr, 0);
        return cnt;
    }
}