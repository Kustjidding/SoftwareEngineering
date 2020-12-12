package tongji.edu.donatesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import tongji.edu.donatesystem.entity.Donate;
import tongji.edu.donatesystem.mapper.AccountMapper;
import tongji.edu.donatesystem.mapper.DonateMapper;
import tongji.edu.donatesystem.service.DonateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@Service
@MapperScan("tongji.edu.donatesystem.mapper")
public class DonateServiceImpl extends ServiceImpl<DonateMapper, Donate> implements DonateService {
    @Autowired
    private DonateMapper mapper;

    @Override
    public List<Donate> findAll() {
        return mapper.selectList(null);
    }

    @Override
    public void saveDonate(Donate donate) {
        mapper.insert(donate);
    }

    @Override
    public void deleteDonate(String id) {
        mapper.deleteById(id);
    }

    @Override
    public List<Donate> findDonatebyUid(String uid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("d_user",uid);
        return mapper.selectList(wrapper);
    }

    @Override
    public List<Donate> findDonatebyPid(String pid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("d_project",pid);
        return mapper.selectList(wrapper);
    }

    @Override
    public void updateDonate(Donate donate) {
       mapper.update(donate,null);
    }
}
