package bgu.spl.a2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestVersionMonitor {
    protected VersionMonitor monitor;
    @Before
    public void setUp() throws Exception {
        monitor= new VersionMonitor();
        monitor.vers=0;

    }

    @After
    public void tearDown() throws Exception { monitor.vers=0; }

    @Test
    public void testGetVersion() {
        assertEquals(0, monitor.getVersion());
        monitor.inc();
        assertEquals(1, monitor.getVersion());
    }

    @Test
    public void testInc() {
        int ans=monitor.getVersion()+1;
        monitor.inc();
        assertEquals(ans,monitor.getVersion() );

    }

    @Test
    public void testAwait() {
        fail("Not yet implemented");
    }

}