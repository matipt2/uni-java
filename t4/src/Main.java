public class Main {

    public static void main(String[] args) {
        String path_to_file_in = "/Users/mateuszptasik/Desktop/poli-input.txt";
        String path_to_file_out = "/Users/mateuszptasik/Desktop/text.txt";
        Polibiusz poli = new Polibiusz();
        ROT11 rot11 = new ROT11();
        Cryptographer.cryptfile(path_to_file_in, path_to_file_out, poli);
    }
}