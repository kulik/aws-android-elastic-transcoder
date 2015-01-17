package aws.kulik.tac.com.aws;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kulik on 16.01.15.
 */
public class MyIS extends FileInputStream {
    public MyIS(File file) throws FileNotFoundException {
        super(file);
    }

    public MyIS(FileDescriptor fd) {
        super(fd);
    }

    public MyIS(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public void close() throws IOException {
    }

    public void myClose() throws IOException {
        super.close();
    }
}
