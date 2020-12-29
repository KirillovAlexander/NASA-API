package ru.netology.saving.picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SavingPictureImpl implements SavingPictureService {

    @Override
    public void savePicture(String imagePath, String dirPath, String fileName) {
        try {
            URL url = new URL(imagePath);
            BufferedImage img = ImageIO.read(url);
            File file = new File(fileName);
            ImageIO.write(img, "jpg", file);
            System.out.println("Picture '" + fileName + "' saved." );
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
