package tongji.edu.donatesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import tongji.edu.donatesystem.entity.Project;
import tongji.edu.donatesystem.mapper.DonateMapper;
import tongji.edu.donatesystem.mapper.ProjectMapper;
import tongji.edu.donatesystem.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Autowired
    private ProjectMapper mapper;

    @Override
    public List<Project> findAll() {
        return mapper.selectList(null);
    }

    @Override
    public void saveProject(Project project) {
        mapper.insert(project);
    }

    @Override
    public void deleteProject(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("p_id",id);
        mapper.delete(wrapper);
    }

    @Override
    public Project findOneProject(String id) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("p_id",id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public List<Project> findLike(String pname) {
        if(findOneProject(pname) != null){
            return Arrays.asList(findOneProject(pname));
            //如果搜索框输入的是id可直接根据id查询
        }else{
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("p_name",pname);
        return mapper.selectList(wrapper);}
        //可根据搜索框进行模糊查询项目
    }

    @Override
    public void updateProject(Project project) {
        mapper.update(project,null);
    }
}
