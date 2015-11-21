package nitka.employment.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


 
import nitka.employment.sequence.SeqRepeat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SeqRepeatTest {
    private SeqRepeat sq;
    private List<Integer> dest;
    
    public SeqRepeatTest() {
    }

    @Before
    public void setUp() throws Exception {
        sq = new SeqRepeat();
        sq.setSource(new ArrayList<Integer>(Arrays.asList(3, 3, 3, 2, 2, 0, 1)));
        dest = new ArrayList<Integer>(Arrays.asList(2, 2, 0, 1));
    }

    /**
     * @see nitka.employment.sequence.SeqRepeat#ClearRepeats()
     */
    @Test
    public void testClearRepeats() {
        sq.ClearRepeats();
        assertThat(sq.getDest(), is(dest)); // but it can fail with different parameters
    }
}
