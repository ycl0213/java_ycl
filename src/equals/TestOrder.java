package equals;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

public class TestOrder {
    public static void main(String[] args) {
        Order o1 = new Order(1001,"订单1");
        Order o2 = new Order(1001,"订单2");
        System.out.println(o1.equals(o2));
        System.out.println(o1);

        String str = "AA";
        String str1 = new String("BB");
        System.out.println(str); //AA
        System.out.println(str1.toString());//BB
    }
}
class Order{
    private int orderId;
    private String orderName;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                Objects.equals(orderName, order.orderName);
    }


    //自动重写的toString()方法
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }
//    public boolean equals(Object obj){
//        return this == obj;
//
//    }


}
