import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStream {
    public static void main(String[] args) throws IOException{
        FileReader in = null;
        FileWriter out = null;

        try{
            in = new FileReader("input.txt");
            out = new FileWriter("output.txt");
            int line;
            while((line = in.read())!=-1){
                out.write(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(in!=null){
                in.close();
            }
            if(out!=null){
                out.close();
            }
        }

    }
}
