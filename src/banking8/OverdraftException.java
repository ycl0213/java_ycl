package banking8;

/**
 * 创建OverdraftException异常类
 */
public class OverdraftException extends Exception{
    static final long serialVersionUID = -338751693124229948L;
    private double deficit;//表示所取的钱与余额的差额

    public double getDeficit() {
        return deficit;
    }
    public OverdraftException(double deficit, String msg){
        super(msg);
        this.deficit = deficit;
    }
}
