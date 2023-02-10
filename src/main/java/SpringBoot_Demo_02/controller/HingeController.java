package SpringBoot_Demo_02.controller;

import SpringBoot_Demo_02.entity.Hinge;
import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import SpringBoot_Demo_02.exception.MSG;
import SpringBoot_Demo_02.exception.MyException;
import SpringBoot_Demo_02.service.HingeService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "铰链接口")
@RequestMapping("/json")
public class HingeController {
    @Resource
    private HingeService hingeService;

    @GetMapping("/FindByHingeByName")
    public JsonResult FindByHingeByName(@RequestParam("name") String name)
    {
        Hinge hinge=hingeService.FindHingeByName(name);
        if (hinge==null)
        {
            MyException.display(MSG.SYSTEM_NULL_POINTER);
            return JsonResultData.error();
        }
        else
        {
            MyException.display(MSG.SUCCESS,hinge);
            return JsonResultData.success(hinge);
        }
    }

    @PostMapping("/AddHinge")
    public JsonResult AddHinge(@RequestBody Hinge hinge)//不用上传id
    {
        if (hinge==null)
        {
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        else
        {
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

}
