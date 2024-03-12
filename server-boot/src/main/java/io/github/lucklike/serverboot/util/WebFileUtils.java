package io.github.lucklike.serverboot.util;

import org.springframework.util.FileCopyUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class WebFileUtils extends FileCopyUtils {

    public static void download(HttpServletResponse response, File in) throws IOException {
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(in.getName(), "UTF-8"));
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        copy(copyToByteArray(in), out);
    }

    public static void download(HttpServletResponse response, InputStream in, String fileName) throws IOException {
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        copy(in, out);
    }

    public static void download(HttpServletResponse response, byte[] in, String fileName) throws IOException {
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        copy(in, out);
    }


    public static void preview(HttpServletResponse response, File in) throws IOException {
        byte[] buffer = copyToByteArray(in);
        ServletOutputStream outputStream = response.getOutputStream();
        copy(buffer, outputStream);
    }

    public static void preview(HttpServletResponse response, InputStream in) throws IOException {
        byte[] buffer = copyToByteArray(in);
        ServletOutputStream outputStream = response.getOutputStream();
        copy(buffer, outputStream);
    }

    public static void preview(HttpServletResponse response, byte[] in) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        copy(in, outputStream);
    }

}
