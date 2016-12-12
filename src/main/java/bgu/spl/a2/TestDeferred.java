package bgu.spl.a2;
import java.util.LinkedList;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDeferred {

    protected Deferred <Integer> def;

    @Before
    public void setUp() throws Exception {
        this.def=createDeferred();
        def.isFinished=false;
        def.value=0;
    }

    protected Deferred<Integer> createDeferred(){ return new Deferred <Integer>(); }

    @Test
    public void testGet() {
        Integer ans= 2;
        def.resolve(ans);
        assertEquals(ans, def.get());
    }

    @Test
    public void testGetException(){
        boolean thrown=false;
        try{
            Integer ans= 2;
            def.resolve(ans);
            fail("Exception expected!!!");
        }
        catch (Exception e){
            thrown=true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testIsResolved() {
        assertFalse(def.isResolved());
        Integer ans= 2;
        def.resolve(ans);
        assertTrue(def.isResolved());
    }

    @Test
    public void testResolve() {
        Integer ans= 4;
        // Runnable test= ()->  ;
        // def.whenResolved(test); this is to test if the resolve does all the callbacks- should we do it?
        def.resolve(ans);
        assertTrue(def.isResolved());
        assertEquals(ans, def.get());

    }

    @Test
    public void testWhenResolved() {
        int firstSize= def.listRun.size();
        Runnable test= ()-> { } ;
        def.whenResolved(test);
        assertEquals(firstSize + 1, def.listRun.size());
    }

}