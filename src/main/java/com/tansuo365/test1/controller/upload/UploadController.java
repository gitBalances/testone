//package com.tansuo365.test1.controller.upload;
//
//import com.alibaba.fastjson.JSONObject;
//import com.chinacarbonal.carboncms.bean.Picture;
//import com.chinacarbonal.carboncms.bean.Video;
//import com.chinacarbonal.carboncms.service.PictureService;
//import com.chinacarbonal.carboncms.service.VideoService;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.apache.ibatis.annotations.Param;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * 文件上传  controller
// */
//@PropertySource(value = "classpath:filepath.properties")
//@Controller
//@RequestMapping("/upload")
//public class UploadController {
//
//  @Value("${img.savepath}")
//  private String imgPath;
//  @Value("${video.savepath}")
//  private String videoPath;
//  @Value("${newsimg.savepath}")
//  private String newsPath;
//  @Resource
//  private VideoService videoService;
//  @Resource
//  private PictureService pictureService;
//
//  /**
//   * @param fileType   文件类型
//   * @param fileNum    文件编号
//   * @param uploadFile
//   * @return
//   */
//  @ApiOperation(value = "文件上传",httpMethod = "/upload/{fileType}/{fileNum}",response =JSONObject.class,notes = "whc")
//  @ApiImplicitParams(
//          {
//                  @ApiImplicitParam(name = "uploadFile",value = "文件名称",dataType = "String"),
//                  @ApiImplicitParam(name = "{fileType}",value = "文件类型",dataType = "String"),
//                  @ApiImplicitParam(name ="{fileNum}",value = "文件地址编号",dataType = "Integer")
//          })
//  @PostMapping("/{fileType}/{fileNum}")
//  @ResponseBody
//  @RequiresPermissions("typeIn")
//  public JSONObject uploadFiles(HttpServletRequest request, @PathVariable String fileType, @PathVariable Integer fileNum,
//                                @Param("uploadFile") MultipartFile uploadFile) {
//
//      //默认传入文件到tomcat中
//      String domainPath = request.getScheme() + "://www.chinacarbon-al.com:8080";
//      JSONObject jsonObject = new JSONObject();
//      /*检查文件是否上传*/
//    if (uploadFile.isEmpty()) {
//      System.out.println("uploadFile is Empty!!!");
//      jsonObject.put("success", false);
//      jsonObject.put("msg", "上传失败，请选择文件");
//      return jsonObject;
//    }
//
//      String filePath = "";
//      String uploadPath = "";
//      SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
//      String dateStr = sf.format(new Date());
//      String fileName = dateStr + "-" + uploadFile.getOriginalFilename();
//
//    //System.out.println("fileName:" + fileName);
//      try {
//    /*用来区分文件类型  分别放在不同的位置*/
//        //头部文件
//    if (fileType.equals("img")) {
//      //存储到图片区
//      filePath = imgPath + fileNum + "/";
//      uploadPath = "/upload/images/topimg/" + fileNum + "/";
//      Picture picture=pictureService.getPictureById(fileNum);
//      String allPath = domainPath + uploadPath + fileName;
//      picture.setPt_url(allPath);
//      pictureService.updatePictureAll(picture);
//    } else if (fileType.equals("video")) {
//      //存储到视频区
//      filePath = videoPath;
//      uploadPath = "/upload/video/";
//      Video video=new Video();
//      video.setV_name(fileName);
//      String allPath = domainPath + uploadPath + fileName;
//      video.setV_url(allPath);
//      video.setModel_id(fileNum);
//      videoService.addVideo(video);
//    } else if (fileType.equals("spic")) {
//      //存到缩略图位置
//      filePath = newsPath;
//      uploadPath ="/upload/images/newsimg/";
//    }else if (fileType.equals("newspic")) {
//      //存到缩略图位置
//      filePath = newsPath;
//      uploadPath ="/upload/images/newsimg/";
//    }
//
//      File dest = new File(filePath + fileName);
//      uploadFile.transferTo(dest);
//      jsonObject.put("success", true);
//      jsonObject.put("errno", 0);
//      List<String> path = new ArrayList<>();
//      path.add(domainPath + uploadPath + fileName);
//     /* 返回路径*/
//      jsonObject.put("data", path);
//      jsonObject.put("modelId", fileNum);
//    } catch (IOException e) {
//      e.printStackTrace();
//      jsonObject.put("success", false);
//      jsonObject.put("errno", 1);
//    }
//      return jsonObject;
//  }
//
//
////  private Integer serviceSelect(Picture picture,Video video){
////
////  }
//
//
//}
