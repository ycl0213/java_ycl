package innercalss;

public class TestProduct {
    public static void main(String[] args) {
        TestProduct t = new TestProduct();
        //方法1：创建一个实现Product接口的类的对象，并将此对象传入方法中
        t.show(new NoteBook());

        //方法2：创建一个实现Product接口的匿名类的对象
        Product p = new Product() {
            @Override
            public void getName() {
                System.out.println("iPhone 12");
            }

            @Override
            public void getPrice() {
                System.out.println("$1000");
            }
        };

        //方法3：创建一个实现Product接口的匿名类的匿名对象
        t.show(new Product() {
            @Override
            public void getName() {
                System.out.println("HP笔记本");
            }

            @Override
            public void getPrice() {
                System.out.println("$800");
            }
        });
        System.out.println();
        t.getProduct().getName();
        t.getProduct().getPrice();
    }
    public void show(Product p){
        p.getName();
        p.getPrice();
    }

    //局部内部类
    public Product getProduct(){
        //方法1：有名的局部内部类
//        class MyCamera implements Product{
//
//            @Override
//            public void getName() {
//                System.out.println("HuaWei笔记本");
//            }
//
//            @Override
//            public void getPrice() {
//                System.out.println("12000");
//            }
//        }
//        return new MyCamera();

        //方法2：匿名的局部内部类
        return new Product() {
            @Override
            public void getName() {
                System.out.println("数码相机");
            }

            @Override
            public void getPrice() {
                System.out.println("4000");
            }
        };
    }
}



interface Product{
    void getName();
    void getPrice();
}

class NoteBook implements Product{

    @Override
    public void getName() {
        System.out.println("Dell笔记本");
    }

    @Override
    public void getPrice() {
        System.out.println("5000");
    }
}
