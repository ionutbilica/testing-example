package ro.ionut.bilica.hs.testingex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileFilter;

public class AndFileFilterTest {

    private static final File FILE = new File("myFile.xml");
    private FileFilter acceptFilter;
    private FileFilter rejectFilter;

    @Before
    public void setup() {
        acceptFilter = Mockito.mock(FileFilter.class);
        Mockito.when(acceptFilter.accept(Mockito.any(File.class))).thenThrow(new IllegalArgumentException());
        Mockito.when(acceptFilter.accept(Mockito.eq(FILE))).thenReturn(true);
        rejectFilter = Mockito.mock(FileFilter.class);
        Mockito.when(rejectFilter.accept(Mockito.any(File.class))).thenThrow(new IllegalArgumentException());
        Mockito.when(rejectFilter.accept(Mockito.eq(FILE))).thenReturn(false);
    }

    @Test
    public void testAccept() {
        AndFileFilter andFilter = new AndFileFilter(acceptFilter, acceptFilter);
        Assert.assertTrue(andFilter.accept(FILE));
    }

    @Test
    public void testReject() {
        AndFileFilter andFilter = new AndFileFilter(rejectFilter, acceptFilter);
        Assert.assertFalse(andFilter.accept(FILE));
        andFilter = new AndFileFilter(acceptFilter, rejectFilter);
        Assert.assertFalse(andFilter.accept(FILE));
        andFilter = new AndFileFilter(rejectFilter, rejectFilter);
        Assert.assertFalse(andFilter.accept(FILE));
    }
}
