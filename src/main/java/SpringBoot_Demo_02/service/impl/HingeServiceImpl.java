package SpringBoot_Demo_02.service.impl;


import SpringBoot_Demo_02.dao.HingeMapper;
import SpringBoot_Demo_02.entity.Hinge;
import SpringBoot_Demo_02.service.HingeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class HingeServiceImpl implements HingeService {
    @Autowired
    private HingeMapper hingeMapper;

    @Override
    public List<Hinge> FindHingeByName(String name)
    {
        try {
            List<Hinge> hinge=hingeMapper.FindHingeByName(name);
            if (hinge==null)
            {
                return null;
            }
            else
            {
                return hinge;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Boolean AddHinge(Hinge hinge) {
        try {
            if (hingeMapper.AddHinge(hinge))
            {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public List<Hinge> FindHingeByModel(String model) {
        try {
            List<Hinge> hingeList=hingeMapper.FindHingeByModel(model);
            if (hingeList==null)
            {
                return null;
            }
            else {
                return hingeList;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public String AddHingeImage(List<MultipartFile> files, Model model, HttpServletRequest request) {
        for (MultipartFile file:files) {
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = "D://temp-rainy//"; // 上传后的路径
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
            String filename = "/temp-rainy/" + fileName;
            model.addAttribute("filename", filename);
            //没写完
        }
        return null;
    }

    @Override
    public Boolean DropHinge(String id) {
        try{
            Boolean b = hingeMapper.DropHinge(id);
            if (b)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public List<Hinge> FindHingeByHingeCupInstallation(String HingeCupInstallation) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeByHingeCupInstallation(HingeCupInstallation);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeByInstallationMaterial(String InstallationMaterial) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeByInstallationMaterial(InstallationMaterial);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeByShutDownSystem(String ShutDownSystem) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeByShutDownSystem(ShutDownSystem);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeByInstallationMethod(String InstallationMethod) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeByInstallationMethod(InstallationMethod);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeBYDampingSystem(String DampingSystem) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeBYDampingSystem(DampingSystem);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeBYOpeningAngle(String OpeningAngle) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeBYOpeningAngle(OpeningAngle);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeBYLargeAngleHinge(String LargeAngleHinge) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeBYLargeAngleHinge(LargeAngleHinge);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeBYDoorPanelAdjustment(String DoorPanelAdjustment) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeBYDoorPanelAdjustment(DoorPanelAdjustment);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeBYHingeBase(String HingeBase) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeBYHingeBase(HingeBase);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Hinge> FindHingeBYOptionalEquipment(String OptionalEquipment) {
        try {
            List<Hinge> hinges = hingeMapper.FindHingeBYOptionalEquipment(OptionalEquipment);
            if (hinges==null)
            {
                return null;
            }
            else
            {
                return hinges;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Hinge FindHingeById(String id) {
        try {
           Hinge hinge = hingeMapper.FindHingeById(id);
            if (hinge==null)
            {
                return null;
            }
            else
            {
                return hinge;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
