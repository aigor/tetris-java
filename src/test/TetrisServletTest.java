import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TetrisServletTest {

    private final TetrisServlet servlet = new TetrisServlet();

    @Test
    public void should_accept_missing_input() {
        assertEquals("rotate=3, left=2, right=1, drop", servlet.answer(new Solution(1, 2, 3)));
    }

}
