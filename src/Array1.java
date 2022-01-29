class Pritimive {
    //boolean t[] = new boolean[3];
    boolean t[] = new boolean[]{true, true, true};

}
public class Array1{
    public static void main(String[] args) {
        Pritimive p = new Pritimive();
        for(int i = 0; i < p.t.length; i++){
            System.out.println(p.t[i]);  // 初始为false
        }
    }
}

