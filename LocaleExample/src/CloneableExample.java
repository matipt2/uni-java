public class CloneableExample implements Cloneable{
    private String data;
    public CloneableExample(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneableExample cl1 = new CloneableExample("some data");
        cl1.setData("loremipsum");
        CloneableExample cl2 = (CloneableExample) cl1.clone();

        System.out.println(cl1.getData());
        System.out.println(cl2.getData());
    }
}
