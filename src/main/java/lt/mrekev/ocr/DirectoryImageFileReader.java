package lt.mrekev.ocr;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryImageFileReader {

    public List<String> listImageFiles(String directory) throws IOException {
        try (Stream<Path> paths = Files.list(Paths.get(directory))){

            List<String> imageFileNameList = paths.filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(this::isImageFile)
                    .collect(Collectors.toList());
            return imageFileNameList;
        }
    }

    private boolean isImageFile(String fileName){
        if (fileName == null){
            return false;
        }
        return FilenameUtils.getExtension(fileName).toUpperCase().matches("JPG|JPEG|PNG|BMP|TIFF|GIF");
    }

}
