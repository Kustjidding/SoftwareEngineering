package tongji.edu.donatesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Info;
import tongji.edu.donatesystem.entity.Project;
import tongji.edu.donatesystem.entity.Report;
import tongji.edu.donatesystem.mapper.AccountMapper;
import tongji.edu.donatesystem.mapper.DonateMapper;
import tongji.edu.donatesystem.mapper.ReportMapper;
import tongji.edu.donatesystem.service.AccountService;
import tongji.edu.donatesystem.service.InfoService;
import tongji.edu.donatesystem.service.ProjectService;
import tongji.edu.donatesystem.service.ReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {
    @Autowired
    private ReportMapper mapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private ProjectService projectService;
    @Override
    public List<Report> findAll() {
        return mapper.selectList(null);
    }

    @Override
    public void saveReport(Report report) {
        mapper.insert(report);
    }

    @Override
    public void deleteReport(String uid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("r_user",uid);
        mapper.delete(wrapper);
    }

    @Override
    public Report findReportByUser(String uid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("r_user",uid);
        return mapper.selectOne(wrapper);
    }

    @Override
    public Report findReportByProject(String pid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("r_project",pid);
        return mapper.selectOne(wrapper);
    }


    @Override
    public void updateReport(Report report) {
        mapper.update(report,null);
    }

    @Override
    public void recallreport(int pid,String uid) {
        Report r = new Report();
        r.setReason("申请停止项目筹款");
        r.setRProject(pid);
        r.setRUser(uid);
        r.setType(4); // 停止审核
        mapper.insert(r);

    }

    @Override
    public void addStartCommit(int pid,String uid) {
        Report r = new Report();
        r.setReason("申请项目发布");
        r.setRProject(pid);
        r.setRUser(uid);
        r.setType(0); // 提交审核
        mapper.insert(r);
    }

    @Override
    public void examine(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("report_id",id);
        Report r = (Report)(mapper.selectOne(wrapper));
        if ( r == null){
            throw new RuntimeException("不存在该id对应的审核请求！");
        }
        r.setIsPass(1);//审核通过
        if (r.getType()==1) //处理申请延期审核
        {
            Project p = new Project();
            p.setEndtime(r.getChangeTime());
            projectService.updateProject(p);
        }
        mapper.updateById(r);
    }

    @Override
    public List<Report> findByKind(int type) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type",type);
        wrapper.eq("isPass",0);
        return mapper.selectList(wrapper);
    }

    @Override
    public List<Map<String, Object>> findHelp(String pid) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("r_project",pid);
        wrapper.eq("type",3);
        List<Report> reportList = mapper.selectList(wrapper);
        for (Report r : reportList){
            Map<String, Object> map = new HashMap<String, Object>();
            Account user = accountService.findOneUser(r.getRUser());
            Info info = infoService.findOneInfo(user.getUserId());
            map.put("name", info.getRealname());//放入证明人的真实姓名
            map.put("path", info.getUserpath());//放入证明人的头像
            map.put("reason",r.getReason());//放入证明原因
            list.add(map);
        }
        return list;
    }
}
