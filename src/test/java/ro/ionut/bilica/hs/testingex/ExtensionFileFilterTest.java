package ro.ionut.bilica.hs.testingex;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ExtensionFileFilterTest {

    @Test
    public void testFiltering() {
        ExtensionFileFilter xmlFilter = new ExtensionFileFilter("xml");
        Assert.assertTrue(xmlFilter.accept(new File("myFile.xml")));
        Assert.assertFalse(xmlFilter.accept(new File("anotherFile.pdf")));
        Assert.assertFalse(xmlFilter.accept(new File("myxml")));
        Assert.assertTrue(xmlFilter.accept(new File("my.file.xml")));
        Assert.assertFalse(xmlFilter.accept(new File("myFile.xml.bkp")));
        Assert.assertTrue(xmlFilter.accept(new File("myFile.XML")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionOnNullFile() {
        ExtensionFileFilter xmlFilter = new ExtensionFileFilter("xml");
        xmlFilter.accept(null);
    }
}
