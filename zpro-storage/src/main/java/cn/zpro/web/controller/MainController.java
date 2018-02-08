package cn.zpro.web.controller;

import cn.zpro.web.ext.MyViewResolver;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;


/**
 * @author zhanggl
 */
@Controller
@RequestMapping("main")
public class MainController {

    @Autowired
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @RequestMapping("test")
    public ModelAndView test(){
        poolTaskExecutor.execute(new TaskService());
        return new ModelAndView("test");
    }

    @RequestMapping(value = "info",method = RequestMethod.GET)
    public ModelAndView info(HttpServletRequest request){
        String realPath = request.getRealPath("/images/");
        File file = FileUtils.getFile(realPath);
        File[] listFiles = file.listFiles();
        request.setAttribute("files",listFiles);
        return new ModelAndView("info");
    }
    @RequestMapping(value = "uploadPage",method = RequestMethod.GET)
    public ModelAndView uploadPage(){
        return new ModelAndView("upload");
    }

    @RequestMapping(value="download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename)throws Exception {
        //下载文件路径
        String path = request.getRealPath("/images/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }


    //上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public ModelAndView upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {

        ModelAndView view = new ModelAndView();
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getRealPath("/images/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            view.setViewName("upload_success");
        } else {
            view.setViewName("upload_failure");
        }
        return view;
    }

    @RequestMapping(value="test2")
    public ModelAndView test2(ModelAndView mv, HttpServletRequest request,HttpServletResponse response){
        mv.setViewName("test2");
        WebApplicationContext webApp= RequestContextUtils.findWebApplicationContext(request, request.getSession().getServletContext());
        UrlBasedViewResolver viewResolver = webApp.getBean("viewResolver", UrlBasedViewResolver.class);
        View view = null;
        try {
            view = viewResolver.resolveViewName(mv.getViewName(), request.getLocale());
            MyViewResolver myViewResolver = new MyViewResolver(response);
            view.render(mv.getModel(),request,myViewResolver);
            System.out.println(myViewResolver.getStr());

        } catch (Exception e) {
            e.printStackTrace();
        }


        mv.addObject("data","data123");
        return mv;
    }
}
