import java.util.Set;
import java.util.HashMap;
public class HashMapFun {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Castle on the Hill", "When I was six years old, I broke my leg..");
        trackList.put("Shape of You", "'m in love with the shape of you..");
        trackList.put("Galway Girl", "She played the fiddle in an Irish band..");
        trackList.put("Perfetct", "I found a love for me..");
        // get the keys by using the keySet method
        String Song = trackList.get("Galway Girl");
        System.out.println(Song);
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key+" : "+trackList.get(key));
            // System.out.println(%n);
        }
    }
}
