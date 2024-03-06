import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        String str;
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            int num = 1;
            int count = 1;
            while( num % n != 0 ){
                count++;
                num = ( num * 10 + 1 ) % n;
                num %= n;
            }
            answer.append(count).append('\n');
        }
        System.out.print(answer);

    }
}
