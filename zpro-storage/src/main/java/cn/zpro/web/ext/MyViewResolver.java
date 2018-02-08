package cn.zpro.web.ext;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 自定义视图解析
 */
public class MyViewResolver extends HttpServletResponseWrapper {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);

    public MyViewResolver(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void setCharacterEncoding(String charset) {
        super.setCharacterEncoding("utf-8");
    }

    public String getStr() {

        return new String(byteArrayOutputStream.toByteArray());

    }


    @Override
    public PrintWriter getWriter() throws IOException {
        return printWriter;
    }
}
