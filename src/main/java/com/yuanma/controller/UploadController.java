/*
package com.yuanma.controller;

import com.baidu.myupload.entity.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

*/
/**
 * @ClassName UploadController
 * @Description:
 * @Author lihongwei
 * @Date 2020/3/15
 **//*

@Controller
@RequestMapping("/business")
public class UploadController {

    @RequestMapping("/upload")
    public String update(){
        return "upload";
    }

    @ResponseBody
    @RequestMapping("/uploadImg")
    public ResponseResult uploadPicture(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<String, Object>();
        File targetFile=null;
        String url="";//返回存储路径
        int code = 1;
        System.out.println(file);
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/imgs";//存储路径
            String path = "C:/Users/98049/IdeaProjects/study/myStudy/myupload/src/main/resources/imgs"; //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName= Instant.now().toEpochMilli() +"_"+new Random().nextInt(1000)+fileF;//新的文件名

            //先判断文件是否存在
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            //String fileAdd = sdf.format(new Date());
            //获取文件夹路径
            File file1 =new File(path+"/");
            //如果文件夹不存在则创建
            if(!file1 .exists()  && !file1 .isDirectory()){
                file1 .mkdirs();
            }
            //将图片存入文件夹
            targetFile = new File(file1, fileName);
            try {
                //将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                url=returnUrl+"/"+fileName;
                code=0;
                result.setCode(code);
                result.setMessage("图片上传成功");
                //假地址
                map.put("url", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584274461958&di=ac17f2185fa29bc23dfebdaa11e9b258&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F01%2F90%2F7b96b74a0a2b615089859de45551ecc0.jpg");
                result.setResult(map);
            } catch (Exception e) {
                e.printStackTrace();
                result.setMessage("系统异常，图片上传失败");
            }
        }
        return result;
    }

    @RequestMapping("/upload2")
    @ResponseBody
    public String upload2(@RequestParam(value="file",required=false) MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "hello";
    }
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
    }
}
*/
