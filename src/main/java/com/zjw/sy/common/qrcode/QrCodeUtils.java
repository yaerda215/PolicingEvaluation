package com.zjw.sy.common.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * 生成简易二维码
 *
 * @author ZhengJiawei
 * @create 2019-02-19 20:33
 */
public class QrCodeUtils {

    /**
     * Description 生成二维码代码
     *
     * @param contents 二维码内容参数
     * @param width    生成二维码宽度
     * @param height   生成二维码高度
     * @return
     * @throws Exception
     * @author ZhengJiawei
     * @date 2019-02-19 20:45:16
     */
    public static String creatRrCode(String contents, int width, int height) {
        String binary = null;
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(
                    contents, BarcodeFormat.QR_CODE, width, height, hints);
            // 1、读取文件转换为字节数组
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedImage image = toBufferedImage(bitMatrix);
            //转换成png格式的IO流
            ImageIO.write(image, "png", out);
            byte[] bytes = out.toByteArray();

            // 2、将字节数组转为二进制
            BASE64Encoder encoder = new BASE64Encoder();
            binary = encoder.encodeBuffer(bytes).trim();
        } catch (WriterException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return binary;
    }

    /**
     * Description image流数据处理
     *
     * @param matrix
     * @return BufferedImage
     * @throws Exception
     * @author ZhengJiawei
     * @date 2019-02-19 20:46:37
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }

    public static void main(String[] args) {
        // 将信息转为二维码
        String binary = QrCodeUtils.creatRrCode("二维码信息", 300, 300);
    }

}
