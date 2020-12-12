package tongji.edu.donatesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Info;
import tongji.edu.donatesystem.mapper.DonateMapper;
import tongji.edu.donatesystem.mapper.InfoMapper;
import tongji.edu.donatesystem.service.InfoService;
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
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {
    @Autowired
    private InfoMapper mapper;

    @Override
    public List<Info> findAll() {
        return mapper.selectList(null);
    }

    @Override
    public void saveInfo(Info info) {
        mapper.insert(info);
    }

    @Override
    public void clearInfo(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("info_user",id);
        if(mapper.selectOne(wrapper)==null){
            throw new RuntimeException("找不到该用户！");
        }
        Info info = new Info();
        info.setInfoUser(id);
        mapper.update(info,wrapper);
    }

    @Override
    public Info findOneInfo(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("info_user",id);
        if(mapper.selectOne(wrapper) == null){
            throw new RuntimeException("该用户个人信息尚未建立！");
        }
        return mapper.selectOne(wrapper);
    }

    @Override
    public void updateInfo(Info info) {
        mapper.update(info,null);
    }

    @Override
    public void initInfo(String id) {
        Info info = new Info();
        info.setInfoUser(id);
        mapper.insert(info);
    }

    @Override
    public void deleteInfo(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("info_user",id);
        if(mapper.selectOne(wrapper)==null){
            throw new RuntimeException("找不到该用户！");
        }
        mapper.deleteById(id);
    }
}
