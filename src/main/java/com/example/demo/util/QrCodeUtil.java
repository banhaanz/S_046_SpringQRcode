package com.example.demo.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import com.example.demo.constant.Constants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.EnumMap;
import java.util.Map;

@Component
public class QrCodeUtil{

    private Map<String, String> urlMap = new HashMap<>();
    private final String folderName = "qrcodePics";

    public static void main(String[] args) {
        QrCodeUtil test = new QrCodeUtil();
        test.genIosQRCode();
        test.genAndroidQRCode();
    }

    public void genIosQRCode() {
        urlMap = Constants.getIosMap();

        urlMap.forEach((k, v) -> {
            File outputfile = this.createFileWithDirectory(folderName, k + ".jpg");
            try {
                ImageIO.write(toQrCode(v), "jpg", outputfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void genAndroidQRCode() {
        urlMap = Constants.getAndroidMap();

        urlMap.forEach((k, v) -> {
            File outputfile = this.createFileWithDirectory(folderName, k + ".jpg");
            try {
                ImageIO.write(toQrCode(v), "jpg", outputfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private File createFileWithDirectory(String directory, String filename) {
        File dir = new File(directory);
        if (!dir.exists()) dir.mkdirs();
        return new File(directory + "/" + filename);
    }

    private static final Logger LOG = Logger.getLogger(QrCodeUtil.class.getName());
    private static final String BASE64_PREFIX = "data:image/png;base64,";
    private static final int DEFAULT_QR_CODE_WIDTH = 200;
    private static final int DEFAULT_QR_CODE_HEIGHT = 200;
    private static final int QR_CODE_WHITESPACE_MARGIN = 2;
    private static final String DEFAULT_IMAGE_FORMAT = "png";
    private static final String UTF_8_CHARSET = "UTF-8";
    public static BufferedImage toQrCode(final String input,
                                         final int width,
                                         final int height) {
        final QRCodeWriter barcodeWriter = new QRCodeWriter();
        try {
            final Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, UTF_8_CHARSET);
            hints.put(EncodeHintType.MARGIN, QR_CODE_WHITESPACE_MARGIN);
            final BitMatrix bitMatrix = barcodeWriter.encode(input, BarcodeFormat.QR_CODE, width, height, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (Exception e) {
            LOG.severe("Could not generate a QR code.");
            throw new RuntimeException(e);
        }
    }

    public static String toBase64QrCode(final String input,
                                        final int width,
                                        final int height) {
        try {
            final BufferedImage bufferedImage = toQrCode(input, width, height);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, DEFAULT_IMAGE_FORMAT, outputStream);
            return BASE64_PREFIX + new String(Base64.getEncoder().encode(outputStream.toByteArray()));
        } catch (Exception e) {
            LOG.severe("Could not generate a QR code.");
            throw new RuntimeException(e);
        }
    }
    public static String toBase64QrCode(final String input) {
        return toBase64QrCode(input, DEFAULT_QR_CODE_WIDTH, DEFAULT_QR_CODE_HEIGHT);
    }
    public static BufferedImage toQrCode(final String input) {
        return toQrCode(input, DEFAULT_QR_CODE_WIDTH, DEFAULT_QR_CODE_HEIGHT);
    }
}
