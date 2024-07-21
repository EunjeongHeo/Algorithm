import java.util.ArrayList;

class Solution {
    public String solution(String new_id) {
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9\\-\\_\\.]","");
        
        // 3단계
        new_id = new_id.replaceAll("[\\.]{2,}",".");
        
        // 4단계
        new_id = new_id.replaceAll("^[\\.]|[\\.]$","");
        
        // 5단계
        if(new_id.equals("")){
            new_id = "a";
        }
        
        // 6단계
        if (new_id.length() >= 16){
            new_id = new_id.substring(0,15);
            if (new_id.substring(14,15).equals("."))
                new_id = new_id.substring(0,14);
        }
        
        // 7단계
        if (new_id.length() <= 2){
            while(new_id.length() < 3){
                new_id = new_id + new_id.substring(new_id.length()-1, new_id.length());
            }
        }
        
        return new_id;
    }
}