public class Main {

    public static void main(String[] args) {
        String path_in = new String(args[0]);
        String path_out = new String(args[1]);
        String cryptType = new String(args[2]);
        String alg = new String(args[3]);
        ROTXX rotxx = new ROTXX();
        Polibiusz polibiusz = new Polibiusz();


        if(cryptType=="crypt"){
            if(alg.equals("rot")){
                Cryptographer.cryptfile(path_in,path_out,rotxx);
            }
            else{
                Cryptographer.cryptfile(path_in,path_out,polibiusz);
            }
        }
        else{
            if(alg=="rot"){
                Cryptographer.decryptfile(path_in,path_out,rotxx);
            }
            else{
                Cryptographer.decryptfile(path_in,path_out,polibiusz);
            }
        }


    }
}



