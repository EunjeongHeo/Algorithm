import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String str;
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            int base = 1; //1, 11, .. 
            int count = 1; //자릿수 카운트  
            while(base % n != 0){
                count++;
                base = (base * 10 + 1) % n;
            }
            answer.append(count).append('\n');
        }
        System.out.println(answer);
    }
}
