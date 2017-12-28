/**
 * Created by ZEYTIN YILMAZ on 7.12.2017.
 */
public class test {
    private static test ourInstance = new test();

    public static test getInstance() {
        return ourInstance;
    }

    private test() {
    }
}
