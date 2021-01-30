import java.io.*;
import java.text.SimpleDateFormat;

public class FileUtil {


    /**
     * 将文件写入到指定目录
     * @param content
     *
     */
    public static void write(String content) {
        String fileName = new SimpleDateFormat("终端设备信息yyyy年MM月dd日HH时mm分ss秒'.txt'").format(System.currentTimeMillis());
        String dirname="src/通过审核的终端设备信息";
        writeContentToLocalFile(dirname,fileName,content,"UTF-8");
    }


    /**
     *
     * @param dirname  目录名
     * @param localfilename 文件名
     * @param content 文件内容
     * @param charset 编码
     */
    public static void writeContentToLocalFile(String dirname,String localfilename,String content,String charset) {
        String path = dirname;
        File f=new File(dirname);
        if (!f.exists())
        {
            f.mkdirs();
        }
        String localFilename = dirname+File.separator+localfilename;
        File file = new File(localFilename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file), charset)));
            out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
        }
    }
}