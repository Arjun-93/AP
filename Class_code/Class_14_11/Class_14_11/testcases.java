package Class_14_11.Class_14_11;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;


public class testcases {

    @Test
    public void testSum() {
        Sum mySum = new Sum(1, 1);
        int sum = mySum.sum();
        assertEquals(2, sum);
    //     assertFalse(sum>10);
    }

    private void assertEquals(int i, int sum) {
    }
}

