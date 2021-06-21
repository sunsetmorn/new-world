package go.to.generictest.interfacetest;

import java.util.Random;

public class NumberGenerator implements Generator<Integer> {
    @Override
    public Integer next() {
        return new Random().nextInt();
    }
}
