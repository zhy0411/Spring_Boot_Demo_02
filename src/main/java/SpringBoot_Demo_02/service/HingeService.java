package SpringBoot_Demo_02.service;

import SpringBoot_Demo_02.entity.Hinge;
import org.springframework.stereotype.Service;

@Service
public interface HingeService {
    Hinge FindHingeByName(String name);

    Boolean AddHinge(Hinge hinge);
}
