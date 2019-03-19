package com.zjw.sy.common.qrcode;


import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.zjw.sy.common.Constants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Description 二维码工具类
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:46:37
 */
public class QRCodeUtil {

    private static final String CHARSET = "utf-8";

    /**
     * 二维码尺寸
     */
    private static final int QR_CODE_SIZE = 300;

    /**
     * LOGO宽度
     */
    private static final int WIDTH = 80;

    /**
     * LOGO高度
     */
    private static final int HEIGHT = 80;

    /**
     * Description 生成二维码(内嵌LOGO)
     *
     * @param content      内容
     * @param imgPath      LOGO地址
     * @param destPath     存放目录
     * @param fileName     默认图像名称带类型（如：123.JPG）如参数为空，则采用默认方式
     * @param needCompress 是否压缩LOGO
     * @throws Exception Exception
     * @author ZhengJiawei
     * @date 2019-03-19 09:47:24
     */
    public static void encode(String content, String imgPath, String destPath,
                              String fileName, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
        mkdirs(destPath);
        if (fileName == null || "".equals(fileName)) {
            fileName = new Random().nextInt(99999999) + Constants.IMAGE_JPG;
        }
        ImageIO.write(image, Constants.IMAGE_JPG, new File(destPath + "/" + fileName));
    }

    /**
     * Description 生成二维码(内嵌LOGO，默认不压缩)
     *
     * @param content  内容
     * @param imgPath  LOGO地址
     * @param destPath 存储地址
     * @throws Exception Exception
     * @author ZhengJiawei
     * @date 2019-03-19 09:48:05
     */
    public static void encode(String content, String imgPath, String destPath, String fileName)
            throws Exception {
        QRCodeUtil.encode(content, imgPath, destPath, fileName, false);
    }

    /**
     * Description 生成二维码(无LOGO)
     *
     * @param content      内容
     * @param destPath     存储地址
     * @param needCompress 是否压缩LOGO
     * @throws Exception Exception
     * @author ZhengJiawei
     * @date 2019-03-19 09:48:43
     */
    public static void encode(String content, String destPath, String fileName,
                              boolean needCompress) throws Exception {
        QRCodeUtil.encode(content, null, destPath, fileName, needCompress);
    }

    /**
     * Description 生成二维码（无LOGO，默认不压缩）
     *
     * @param content  内容
     * @param destPath 存储地址
     * @author ZhengJiawei
     * @date 2019-03-19 09:49:37
     */
    public static void encode(String content, String destPath, String fileName) throws Exception {
        QRCodeUtil.encode(content, null, destPath, fileName, false);
    }

    private static BufferedImage createImage(String content, String imgPath,
                                             boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QR_CODE_SIZE, QR_CODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        QRCodeUtil.insertImage(image, imgPath, needCompress);
        return image;
    }

    /**
     * Description 插入LOGO
     *
     * @param source       二维码图片
     * @param imgPath      LOGO图片地址
     * @param needCompress 是否压缩
     * @author ZhengJiawei
     * @date 2019-03-19 09:49:58
     */
    private static void insertImage(BufferedImage source, String imgPath,
                                    boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println("" + imgPath + "   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QR_CODE_SIZE - width) / 2;
        int y = (QR_CODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * Description 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
     *
     * @param destPath 存放目录
     * @return
     * @throws Exception
     * @author ZhengJiawei
     * @date 2019-03-19 09:50:20
     */
    public static void mkdirs(String destPath) {
        File file = new File(destPath);
        //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * Description 生成二维码(内嵌LOGO)
     *
     * @param content      内容
     * @param imgPath      LOGO地址
     * @param output       输出流
     * @param needCompress 是否压缩LOGO
     * @author ZhengJiawei
     * @date 2019-03-19 09:55:50
     */
    public static void encode(String content, String imgPath,
                              OutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
        ImageIO.write(image, Constants.IMAGE_JPG, output);
    }

    /**
     * Description 生成二维码
     *
     * @param content 内容
     * @param output  输出流
     * @author ZhengJiawei
     * @date 2019-03-19 09:56:16
     */
    public static void encode(String content, OutputStream output)
            throws Exception {
        QRCodeUtil.encode(content, null, output, false);
    }

    /**
     * Description 解析二维码
     *
     * @param file 二维码图片
     * @author ZhengJiawei
     * @date 2019-03-19 09:56:37
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
                image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    /**
     * Description 解析二维码
     *
     * @param path 二维码图片地址
     * @author ZhengJiawei
     * @date 2019-03-19 09:56:59
     */
    public static String decode(String path) throws Exception {
        return QRCodeUtil.decode(new File(path));
    }

    public static void main(String[] args) throws Exception {
        String text = "http://www.sclead.com";
        QRCodeUtil.encode(text, "d:/logo.png", "d:/", true);
    }
}
