package ro.ionut.bilica.hs.testingex;

import java.io.File;
import java.io.FileFilter;
import java.util.Objects;

public class ExtensionFileFilter implements FileFilter {

    private final String ext;

    public ExtensionFileFilter(String ext) {
        this.ext = ext.toLowerCase();
    }

    public boolean accept(File f) {
        if (f == null) {
            throw new IllegalArgumentException("File can't be null.");
        }
        return f.getName().toLowerCase().endsWith("." + ext);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtensionFileFilter that = (ExtensionFileFilter) o;
        return Objects.equals(ext, that.ext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ext);
    }
}
