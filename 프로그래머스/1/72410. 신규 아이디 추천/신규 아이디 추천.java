import java.util.ArrayList;

class Solution {
    public String solution(String new_id) {


        String old_id = new_id;

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");

        // 3단계
        new_id = new_id.replaceAll("\\.{2,}",".");

        // 4단계
        new_id = new_id.replaceAll("(^\\.|\\.$)","");

        // 5단계
        if (new_id.equals("")){
            new_id = "a";
        }

        // 6단계
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }

        // 7단계
        if(new_id.length() <= 2) {
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while (new_idBuilder.length() < 3) {
                new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
            }
            new_id = new_idBuilder.toString();
        }

        return new_id;
    }
}