package ro.ionut.bilica.hs.testingex;

import java.io.File;
import java.io.FileFilter;

public class AndFileFilter implements FileFilter {

    private final FileFilter filterA;
    private final FileFilter filterB;

    public AndFileFilter(FileFilter filterA, FileFilter filterB) {
        this.filterA = filterA;
        this.filterB = filterB;
    }

    @Override
    public boolean accept(File pathname) {
        return filterA.accept(pathname) && filterB.accept(pathname);
    }
}
