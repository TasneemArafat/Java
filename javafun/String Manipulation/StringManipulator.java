public class StringManipulator{
    public String trimAndConcat(String first, String second){
        String result = first.trim() + second.trim();
        return result;
    }

    public Integer getIndexOrNull(String word, char c){
        Integer index;
        index = word.indexOf(c);
        if(index < 0){
            return null;
        }
        return index;
    }

    public Integer getIndexOrNull(String sent, String word){
        Integer index;
        index = sent.indexOf(word);
        if(index < 0){
            return null;
        }
        return index;
    }

    public String concatSubstring(String first , int start, int end, String second){
        String result;
        result = (first.substring(start,end)).concat(second);
        return result;
    }
}