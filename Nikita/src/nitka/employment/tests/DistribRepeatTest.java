package nitka.employment.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nitka.employment.sequence.DistribRepeat;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DistribRepeatTest {
    private DistribRepeat dr;
    private List<Integer> dest;
    
    public DistribRepeatTest() {
    }

    @Before
    public void setUp() throws Exception {
        dr = new DistribRepeat();
        dr.setSource(new ArrayList<Integer>(Arrays.asList(3, 3, 3, 2, 2, 0, 1)));
        dest = new ArrayList<Integer>(Arrays.asList(2, 2, 0, 1));
    }  
    
    @Test
    public void testClearRepeats() {
        dr.ClearRepeats();
        assertThat(dr.getDest(), is(dest)); // but it can fail with different parameters
        
    }
}
