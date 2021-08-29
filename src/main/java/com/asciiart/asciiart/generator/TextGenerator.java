package com.asciiart.asciiart.generator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextGenerator implements Generator<String> {

    private static final int MARGIN_X = 5;
    private static final int MARGIN_Y = 1;
    private static final String SPACE_CHAR = " ";
    private static final int RGB_VALUE = -16777216;

    @Override
    public String generate(String text, String character, int size, boolean outline) {
        var font = new Font("TimesRoman", Font.PLAIN, size); //min 12 size
        var metrics = getFontMetrics(font);

        var image = createBufferedImageWithCorrectSize(metrics, text);
        drawTextImage(image, font, metrics, text);

        return imgToText(image, outline, character);
    }

    private Graphics2D getGraphics2D(Graphics graphics, Font font) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setFont(font);

        return graphics2D;
    }

    public FontMetrics getFontMetrics(Font font) {
        Canvas c = new Canvas();
        return c.getFontMetrics(font);
    }

    public BufferedImage createBufferedImageWithCorrectSize(FontMetrics metrics, String text){
        var width = metrics.stringWidth(text) + MARGIN_X * 2;
        var height = metrics.getHeight() + MARGIN_Y * 2;

        return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void drawTextImage(BufferedImage image, Font font, FontMetrics metrics, String text){
        var graphics2D = getGraphics2D(image.getGraphics(), font);
        int yy = ((image.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        graphics2D.drawString(text, MARGIN_X, yy);
    }

    public String imgToText(BufferedImage image, boolean outline, String character){
        StringBuilder finalStr = new StringBuilder();
        for (int y = 0; y < image.getHeight(); y++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < image.getWidth(); x++) {
                if (outline)
                    stringBuilder.append(image.getRGB(x, y) == RGB_VALUE ? SPACE_CHAR : character);
                else
                    stringBuilder.append(image.getRGB(x, y) == RGB_VALUE ? character : SPACE_CHAR);
            }

            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }
            finalStr.append(stringBuilder).append("\r");
        }

        return finalStr.toString();
    }
}
