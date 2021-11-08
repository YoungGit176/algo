import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。*/
public class ZuiChangZiChuan {
    public int lengthOfLongestSubstring(String s) {
        int index=0;
        int length=0;
        Map<Character,Integer> map = new HashMap<>();
        if (s.length()==0 || s.length()==1){
            return s.length();
        }
        for (int i = 0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) > index){
                    if (length<i-index){
                        length = i-index;
                    }
                    index = map.get(s.charAt(i))+1;
                }
                else if (map.get(s.charAt(i))==index){
                    if (i-index>length) {
                        length=i-index;
                    }
                    index++;
                }
            }
            map.put(s.charAt(i),i);
        }
        if(s.length()-index>length) {
            length=s.length()-index;
        }
        return length;

    }
}

class demoString{
    public static void main(String[] args) {
        ZuiChangZiChuan zuiChangZiChuan = new ZuiChangZiChuan();
        System.out.println(zuiChangZiChuan.lengthOfLongestSubstring("au"));
    }
}

