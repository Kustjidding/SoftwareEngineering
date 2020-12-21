package tongji.edu.donatesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import tongji.edu.donatesystem.entity.Project;
import tongji.edu.donatesystem.mapper.DonateMapper;
import tongji.edu.donatesystem.mapper.ProjectMapper;
import tongji.edu.donatesystem.mapper.ReportMapper;
import tongji.edu.donatesystem.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tongji.edu.donatesystem.service.ReportService;

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
    @Autowired
    private ReportService reportService;

    @Override
    public List<Project> findAll() {
        return mapper.selectList(null);
    }

    @Override
    public void saveProject(Project project) {

        mapper.insert(project);
    }

    @Override
    public void deleteProject(int id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("p_id",id);
        mapper.delete(wrapper);
    }

    @Override
    public Project findOneProject(int id) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("p_id",id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public List<Project> findLike(String pname) {
        if(findOneProject(Integer.parseInt(pname)) != null){
            return Arrays.asList(findOneProject(Integer.parseInt(pname)));
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

    @Override
    public void recall(int id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("p_id",id);
        Project p = (Project)(mapper.selectOne(wrapper));
        if ( p == null){
            throw new RuntimeException("不存在该id对应的项目！");
        }
        p.setStatus("审核中");
        mapper.updateById(p);
        reportService.recallreport(p.getPId(),p.getPUser());
        //提交停止项目report

    }

    @Override
    public void donateProject(int id, String amount) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("p_id",id);
        Project p= mapper.selectOne(wrapper);
        p.setAmount(p.getAmount()+Float.parseFloat(amount));
        mapper.updateById(p);
    }
}
