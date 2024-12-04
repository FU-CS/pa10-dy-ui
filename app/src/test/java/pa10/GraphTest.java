package pa10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    @Test void appHasAGreeting() {
        Graph g = new GraphImp(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        assertEquals("0 1 2", g.topologicalSort());
        assertEquals("0 1 2", g.kahn());
    }
    
    @Test void test2() {//dfs without tail-recursion might not work
        Graph g = new GraphImp(3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        assertEquals("0 1 2", g.topologicalSort());
        assertEquals("0 1 2", g.kahn());
    }
    
    @Test void test3() {//multiple options
        Graph g = new GraphImp(3);
        g.addEdge(0, 1);
        assertEquals("2 0 1", g.topologicalSort()); 
        assertEquals("2 0 1", g.topologicalSort());
    }
}




