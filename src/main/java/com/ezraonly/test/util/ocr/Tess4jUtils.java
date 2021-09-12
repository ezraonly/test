package com.ezraonly.test.util.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

/**
 * 功能描述: tesseract for java， ocr（Optical Character Recognition，光学字符识别）
 * 〈ocr识别〉
 * @Author:lwy
 * @Date: 2021/9/12 21:00
 */
public class Tess4jUtils {
    /**
     * 从图片中提取文字,默认设置英文字库,使用classpath目录下的训练库
     * @param path
     * @return
     */
    public static String readChar(String path){
        // JNA Interface Mapping
        ITesseract instance = new Tesseract();
        // JNA Direct Mapping
        // ITesseract instance = new Tesseract1();
        File imageFile = new File(path);
        //In case you don't have your own tessdata, let it also be extracted for you
        //这样就能使用classpath目录下的训练库了
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        //Set the tessdata path
        instance.setDatapath(tessDataFolder.getAbsolutePath());
        //英文库识别数字比较准确
        instance.setLanguage("chi_sim");
        return getOCRText(instance, imageFile);
    }

    /**
     * 从图片中提取文字
     * @param path 图片路径
     * @param dataPath 训练库路径
     * @param language 语言字库
     * @return
     */
    public static String readChar(String path, String dataPath, String language){
        File imageFile = new File(path);
        ITesseract instance = new Tesseract();
        instance.setDatapath(dataPath);
        //英文库识别数字比较准确
        instance.setLanguage(language);
        return getOCRText(instance, imageFile);
    }

    /**
     * 识别图片文件中的文字
     * @param instance
     * @param imageFile
     * @return
     */
    private static String getOCRText(ITesseract instance, File imageFile){
        String result = null;
        try {
            result = instance.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        /*String path = "src/main/resources/image/text.png";
        System.out.println(readChar(path));*/

        String ch = "src/main/resources/image/test-ocr.png";
        System.out.println(readChar(ch, "D:\\ocr\\tessdata-master", "chi_sim"));


//        ITesseract instance = new Tesseract();
//        instance.setDatapath("D:\\ocr\\tessdata-master"); //1、选择相对目录，tessdata目录和src目录平级 2、也可选择绝对目录
//        instance.setLanguage("chi_sim");//选择字库文件（文件名）
//        try {
//            File imageFile = new File("d:\\test-ocr.png");
//            String result = instance.doOCR(imageFile);//开始识别
//            System.out.println(result);//打印图片内容
//        } catch (Exception e) {
//            System.out.println(e.toString());//打印图片内容
//        }

    }
}
