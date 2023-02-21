package SpringBoot_Demo_02.service;

import SpringBoot_Demo_02.entity.Hinge;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface HingeService {
    List<Hinge> FindHingeByName(String name);

    Boolean AddHinge(Hinge hinge);

    List<Hinge> FindHingeByModel(String model);

    String AddHingeImage(List<MultipartFile> files, Model model, HttpServletRequest request);

    Boolean DropHinge(String id);

    List<Hinge> FindHingeByHingeCupInstallation(String HingeCupInstallation);

    List<Hinge> FindHingeByInstallationMaterial(String InstallationMaterial);

    List<Hinge> FindHingeByShutDownSystem(String ShutDownSystem);

    List<Hinge> FindHingeByInstallationMethod(String InstallationMethod);

    List<Hinge> FindHingeBYDampingSystem(String DampingSystem);

    List<Hinge> FindHingeBYOpeningAngle(String OpeningAngle);

    List<Hinge> FindHingeBYLargeAngleHinge(String LargeAngleHinge);

    List<Hinge> FindHingeBYDoorPanelAdjustment(String DoorPanelAdjustment);

    List<Hinge> FindHingeBYHingeBase(String HingeBase);

    List<Hinge> FindHingeBYOptionalEquipment(String OptionalEquipment);

    Hinge FindHingeById(String id);
}
