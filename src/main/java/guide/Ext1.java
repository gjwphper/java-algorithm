package guide;

public class Ext1<T> {
    private T key;

    public Ext1(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }

}
