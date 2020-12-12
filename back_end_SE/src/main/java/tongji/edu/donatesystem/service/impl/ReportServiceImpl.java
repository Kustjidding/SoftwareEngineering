package tongji.edu.donatesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import tongji.edu.donatesystem.entity.Report;
import tongji.edu.donatesystem.mapper.DonateMapper;
import tongji.edu.donatesystem.mapper.ReportMapper;
import tongji.edu.donatesystem.service.ReportService;
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
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {
    @Autowired
    private ReportMapper mapper;

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
}
