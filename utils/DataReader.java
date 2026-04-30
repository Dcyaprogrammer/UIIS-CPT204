package utils;

import java.io.IOException;

public interface DataReader<T> {
    T read(String filePath) throws IOException;
}
