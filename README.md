# test
测试相关

# 一、ocr识别
## JAVA使用Tess4J进行ocr识别
    Tess4J是对Tesseract OCR API.的Java JNA 封装。使java能够通过调用Tess4J的API来使用Tesseract OCR。支持的格式：TIFF,JPEG,GIF,PNG,BMP,JPEG,and PDF
    Tesseract 的github地址：https://github.com/tesseract-ocr/tesseract
    Tess4J的github地址：https://github.com/nguyenq/tess4j

**Tess4J API 提供的功能：**

    1、直接识别支持的文件
    2、识别图片流
    3、识别图片的某块区域
    4、将识别结果保存为 TEXT/ HOCR/ PDF/ UNLV/ BOX
    5、通过设置取词的等级，提取识别出来的文字
    6、获得每一个识别区域的具体坐标范围
    7、调整倾斜的图片
    8、裁剪图片
    9、调整图片分辨率
    10、从粘贴板获得图像
    11、克隆一个图像（目的：创建一份一模一样的图片，与原图在操作修改上，不相 互影响）
    12、图片转换为二进制、黑白图像、灰度图像
    13、反转图片颜色

#### java集成

##### 1.maven添加依赖

    <!-- https://mvnrepository.com/artifact/net.sourceforge.tess4j/tess4j -->
    <dependency>
        <groupId>net.sourceforge.tess4j</groupId>
        <artifactId>tess4j</artifactId>
        <version>3.2.1</version>
    </dependency>

##### 2.工具类编辑

    src/main/java/com/ezraonly/test/util/ocr/Tess4jUtils.java

-----------------------------
