import java.io.*;

public class BufferedStream {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));
            String line;
            while((line=in.readLine())!=null){
                out.println(line);
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
