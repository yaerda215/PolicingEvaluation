package com.zjw.sy.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.zjw.sy.common.utils.DateUtilOther;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

/**
 * Description 文件上传Controller
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:32:54
 */
@Controller
public class FileUploadController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    private static String STR_ONE = "1";
    private static String STR_POINT = ".";

    /**
     * Description 上传测试
     *
     * @param model model
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 09:33:10
     */
    @RequestMapping("/com/file")
    public String file(Model model) {
        return "test/fileUpload";
    }

    /**
     * Description 异步上传处理
     *
     * @param file 文件
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 09:33:35
     */
    @RequestMapping(value = "/file/upload", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String uploadFileHandler(HttpServletRequest request,
                                    @RequestParam("file") MultipartFile file) {

        String type = request.getParameter("type");
        String typeStr = "goods";
        if (STR_ONE.equals(type)) {
            typeStr = "company";
        }

        //上传文件目录定义
        String path = "/upload/" + typeStr + "/image/" + DateUtilOther.getNowDay() + "/";

        if (file.getSize() > 0) {
            //获取绝对路径
            String uploadPath = request.getSession().getServletContext().getRealPath(path);

            //修改文件名称
            String fileName = file.getOriginalFilename();
            if (fileName.contains(STR_POINT)) {
                int indexdot = fileName.indexOf(STR_POINT);
                String suffix = fileName.substring(indexdot);
                fileName = System.currentTimeMillis() + String.valueOf((int) ((Math.random() * 9 + 1) * 100000)) + suffix;
            }

            try {
                //创建目标文件
                File targetFile = new File(uploadPath, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }

                file.transferTo(targetFile);
                //FileUtils.copyInputStreamToFile(file.getInputStream(), f);
                return JSON.toJSONString(path + fileName);
            } catch (Exception e) {

            }
        }
        return null;
    }

    /**
     * Description 重新定义ueditor
     *
     * @author ZhengJiawei
     * @date 2019-03-19 09:34:18
     */
//    @RequestMapping(value="/file/config")
//    public void config(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("application/json");
//        String rootPath = request.getSession().getServletContext().getRealPath("/");
// 
//        try {
//            String exec = new ActionEnter(request, rootPath).exec();
//            PrintWriter writer = response.getWriter();
//            writer.write(exec);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}