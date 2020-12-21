package tongji.edu.donatesystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import tongji.edu.common.lang.Result;
import tongji.edu.donatesystem.service.ReportService;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
    @Autowired
    ReportService reportService;
    @PostMapping("examine")
    public Map<String , Object> examine (String id){
        try {
            reportService.examine(id);
            return Result.succ("已审核通过该请求");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("审核失败,"+e.getMessage());
        }
    }
    @PostMapping("findByKind")
    public Map<String , Object> findByKind(int type){
        return Result.succ("查询审核请求成功",reportService.findByKind(type));
    }
}

