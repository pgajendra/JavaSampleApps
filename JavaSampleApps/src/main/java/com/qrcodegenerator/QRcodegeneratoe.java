package com.qrcodegenerator;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRcodegeneratoe {
    public static void main(String[] args) {
        String text = "gajendra pala ";
        int width = 350;
        int height = 350;
        String format = "png";
        String fileName = "qrcode.png";
        try {
            // create the QR code writer
            QRCodeWriter writer = new QRCodeWriter();
            // set the encoding hints
            HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            // encode the text as a BitMatrix
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            // create a BufferedImage from the BitMatrix
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            // save the image to a file
            File qrFile = new File(fileName);
            System.out.println(qrFile.getAbsoluteFile());
            ImageIO.write(image, format, qrFile);
            System.out.println("QR code has been generated.");
        } catch (Exception e) {
            System.err.println("Failed to generate QR code: " + e.getMessage());
        }
    }
}

