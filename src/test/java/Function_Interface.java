import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Function_Interface{
    @Test
    @DisplayName("함수")
    public void Function(){
        MyFunction f = (int a, int b) -> a > b ? a : b;

        System.out.println("Res : "+f.max(1, 2));
    }
}

@FunctionalInterface
interface MyFunction{
    public abstract int max (int a, int b);
}
