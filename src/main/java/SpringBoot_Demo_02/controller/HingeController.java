package SpringBoot_Demo_02.controller;

import SpringBoot_Demo_02.entity.Hinge;
import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import SpringBoot_Demo_02.entity.Slide;
import SpringBoot_Demo_02.exception.MSG;
import SpringBoot_Demo_02.exception.MyException;
import SpringBoot_Demo_02.service.HingeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Api(value = "铰链接口")
@RequestMapping("/json")
public class HingeController {
    @Resource
    private HingeService hingeService;

//    @GetMapping("/FindByHingeByName")
//    public JsonResult FindByHingeByName(@RequestParam("name") String name)
//    {
//        List<Hinge> hinge=hingeService.FindHingeByName(name);
//        if (hinge==null)
//        {
//            MyException.display(MSG.SYSTEM_NULL_POINTER);
//            return JsonResultData.error();
//        }
//        else
//        {
//            MyException.display(MSG.SUCCESS,hinge);
//            return JsonResultData.success(hinge);
//        }
//    }



    @PostMapping("/AddHinge")
    @ApiOperation(value="录入铰链",notes = "不用上传id以及url")
    public JsonResult AddHinge(@RequestBody Hinge hinge)
    {
        if (hinge==null)
        {
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        else
        {
            String s = String.valueOf(LocalDateTime.now());
            hinge.setId(s);
            File file=new File("/opt/dome/Spring_Boot_Demo_02/img/"+hinge.getId());
            if(!file.exists()){
                file.mkdirs();
            }
            hinge.setUrl(file.toString());
            if (hingeService.AddHinge(hinge))
            {
                MyException.display(MSG.SUCCESS);
                return JsonResultData.success(MSG.SUCCESS);
            }
            else {
                 MyException.display(MSG.SYSTEM_PARSE);
                 return JsonResultData.error(MSG.SYSTEM_PARSE);
            }
        }
    }

    @RequestMapping("/AddImage")
    public Boolean addArticle(MultipartFile file,String url)
    {
        if(file.isEmpty()) {
            return false;
        }
        //获取后缀
        String suffixName = ImageUtil.getImagePath(file);
        //获取新的文件名
        String newFileName = ImageUtil.getNewFileName(suffixName);
        //保存图片
        File file1 = new File(ImageUtil.getNewImagePath1(url,newFileName));
        boolean state = ImageUtil.saveImage(file, file1);
        if(state) {
            return true;
        }else {
            return false;
        }
    }



//    @GetMapping("/FindHingeByModel/{model}")
//    public JsonResult FindHingeByModel(@PathVariable String model)
//    {
//
//        if (model.isEmpty())
//        {
//            MyException.display(MSG.PARAMS_ERROR);
//            return JsonResultData.error(MSG.PARAMS_ERROR);
//        }
//        else
//        {
//            List<Hinge> hingeList=hingeService.FindHingeByModel(model);
//            if (hingeList==null)
//            {
//                MyException.display(MSG.SYSTEM_NULL_POINTER);
//                return JsonResultData.error(MSG.SYSTEM_NULL_POINTER);
//            }
//            else
//            {
//                MyException.display(MSG.SUCCESS,hingeList);
//                return JsonResultData.success("成功",hingeList);
//            }
//        }
//    }


    @GetMapping("/DropHinge/{id}")
    public JsonResult DropHinge(@PathVariable String id)
    {
        if (id.isEmpty())
        {
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        else
        {
            Boolean b = hingeService.DropHinge(id);
            Hinge hinge = hingeService.FindHingeById(id);
            if (b && (hinge!=null))
            {
                File file=new File(hinge.getUrl());
                System.out.println(hinge.getUrl());
                deleteAllFiles(file);
                MyException.display(MSG.SUCCESS,id);
                return JsonResultData.success(String.valueOf(MSG.SUCCESS),id);
            }
            else
            {
                MyException.display(MSG.ERROR,id);
                return JsonResultData.error(MSG.ERROR,id);
            }
        }
    }
    public static void deleteAllFiles(File file){
        //通过file对象获取File数组
        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            //测试此抽象路径名表示的文件是否是一个标准文件。
            if (f.isFile()){
                //是文件就删除
                f.delete();
            }else{
                //是一个文件夹，递归删除里面的文件
                deleteAllFiles(f);
                //最后删除文件夹
                f.delete();
            }
        }
        //循环结束后只剩最后一个空文件夹，删除
        file.delete();
    }

    @GetMapping("/FindHinge/{s}")
    @ApiOperation(value = "模糊查询")
    public JsonResult FindHinge(@PathVariable("s") String s)
    {
        if (s.isEmpty())
        {
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        else
        {
            List<Hinge> hingeList = null;
            if ((hingeList=hingeService.FindHingeByModel(s))==null)
            {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            }
            else if ((hingeList=hingeService.FindHingeBYHingeBase(s))==null)
            {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeByName(s))==null)
            {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeByHingeCupInstallation(s))==null)
            {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeBYLargeAngleHinge(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);

            } else if ((hingeList=hingeService.FindHingeBYDampingSystem(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeBYDoorPanelAdjustment(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeByInstallationMaterial(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeByInstallationMethod(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeBYOpeningAngle(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeBYOptionalEquipment(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            } else if ((hingeList=hingeService.FindHingeByShutDownSystem(s))==null) {
                MyException.display(MSG.ERROR,s);
                return JsonResultData.error(MSG.ERROR,s);
            }
            else
            {
                MyException.display(MSG.SUCCESS,hingeList);
                return JsonResultData.success(String.valueOf(MSG.SUCCESS),hingeList);
            }
        }
    }

    @RequestMapping(value = "/updateHinge",method = RequestMethod.POST)
    public JsonResult UpdateSlide(Hinge hinge){
        if(hinge==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        if(hingeService.UpdateHinge(hinge)){
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
    }

}
