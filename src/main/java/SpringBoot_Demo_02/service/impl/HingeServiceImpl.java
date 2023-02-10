package SpringBoot_Demo_02.service.impl;


import SpringBoot_Demo_02.dao.HingeMapper;
import SpringBoot_Demo_02.entity.Hinge;
import SpringBoot_Demo_02.service.HingeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HingeServiceImpl implements HingeService {
    @Autowired
    private HingeMapper hingeMapper;

    @Override
    public Hinge FindHingeByName(String name)
    {
        try {
            Hinge hinge=hingeMapper.FindHingeByName(name);
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
            String s = String.valueOf(LocalDateTime.now());
            hinge.setId(s);
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
}
