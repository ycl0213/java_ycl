public class TestArray {
    public static void main(String[] args) {
        int array1[];
        int array2[];
        array1 = new int[]{2,3,5,7,11,13,17,19};
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }
        array2 = array1;
        System.out.println("\n");
        for(int i = 0; i < array2.length; i++){
            if(i % 2 == 0){
                array2[i] = i;
            }
            System.out.print(array1[i] + " ");
        }
    }
}

