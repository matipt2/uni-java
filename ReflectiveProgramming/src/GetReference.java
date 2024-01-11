public class GetReference {
    public GetReference(){

    }
    public static void main(String[] args) {
        Class<?> getMyClassReference = GetReference.class;
        System.out.println(getMyClassReference);

        GetReference getReference = new GetReference();
        Class<?> getMyClassReference2 = getReference.getClass();
        System.out.println(getMyClassReference2);




    }
}
