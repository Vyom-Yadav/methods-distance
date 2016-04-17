package org.pirat9600q.graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MethodDefinitionTest extends MethodCallDependenciesCheckTestSupport {

    @Test
    public void testGetterSetterRecognition() throws Exception {
        final Dependencies dc = withDefaultConfig("InputMethodDefinition1.java");
        for(final int index : new int[]{0, 1, 2, 3, 4}) {
            final MethodDefinition method = dc.getMethodByIndex(index);
            assertTrue(method.isGetter());
            assertFalse(method.isSetter());
        }
        for(final int index : new int[]{7}) {
            final MethodDefinition method = dc.getMethodByIndex(index);
            assertFalse(method.isGetter());
            assertTrue(method.isSetter());
        }
        for(final int index : new int[]{5, 6, 8, 9, 10, 11}) {
            final MethodDefinition method = dc.getMethodByIndex(index);
            assertFalse(method.isGetter());
            assertFalse(method.isSetter());
        }
    }
}