package cn.zpro.web.service;

import cn.zpro.web.controller.MyProgress;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author dell
 */
public class CommonsMultipartResolverExt extends CommonsMultipartResolver {
    @Override
    protected FileUpload newFileUpload(FileItemFactory fileItemFactory) {
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        upload.setProgressListener(new MyProgress());
        return upload;
    }
}
