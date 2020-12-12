package tongji.edu.donatesystem.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import tongji.edu.common.lang.Result;
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Info;
import tongji.edu.donatesystem.service.AccountService;
import tongji.edu.donatesystem.service.InfoService;
import tongji.edu.donatesystem.utils.VerifyCodeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/account")
@CrossOrigin // 允许跨域
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private InfoService infoService;
    @Value("F:\\IdeaProjects\\back_end_SE\\src\\main\\resources\\static\\photos")
    private String realPath; //头像保存地址
    @GetMapping("/test")
    public String test(){
        return "Hello Springboot";
    }//测试springboot是否正常


    // 生成验证码图片
    @GetMapping("getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        // 使用工具类生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        // 将验证码放入servletContext作用域
        request.getServletContext().setAttribute("code",code);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(120,30,byteArrayOutputStream,code);
        String s="data:image/png;base64,"+ Base64Utils.encodeToString((byteArrayOutputStream.toByteArray()));
        return s;
    }
    //用来处理用户注册的方法
    @PostMapping("register")
    // @RequestBody 用来将json与对象进行转换
    public Map<String,Object> register(@RequestBody Account user,String code,HttpServletRequest request){
        log.info("用户信息:[{}]",user.toString());
        log.info("用户输入的验证码信息:[{}]",code);
        // 1.调用业务方法
        try {
            String key = (String) request.getServletContext().getAttribute("code");
            if(key.equalsIgnoreCase(code)){
                accountService.register(user);
                infoService.initInfo(user.getUserId());
//                map.put("state",true);
//                map.put("msg","提示：注册成功!");
                 return  Result.succ("提示：注册成功！");

            }else{
                throw new RuntimeException("验证码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
//            map.put("state",false);
//            map.put("msg","提示："+e.getMessage());
            return Result.fail("提示"+e.getMessage());
        }
    }
    @PostMapping("login")
    public Map<String,Object> login(@RequestBody Account user){
        log.info("当前登录用户的信息: [{}]",user.toString());
        try {
            Account userDB =accountService.login(user);
//            map.put("state",true);
//            map.put("msg","登录成功！");
//            map.put("user",userDB);
            return Result.succ("登录成功！",userDB);
        }catch (Exception e){
            e.printStackTrace();
//            map.put("state",false);
//            map.put("msg",e.getMessage());
            return Result.fail(e.getMessage());
        }
    }


    @GetMapping("findAll")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @PostMapping("delete")
    // 删除用户和关联的个人信息
    public Map<String,Object> delete(String id){
        log.info("删除用户的id:[{}]",id);
        try {
            Account user = accountService.findOneUser(id);
            Info info = infoService.findOneInfo(id);
            if(info.getUserpath()!=null){
                File file = new File(realPath,info.getUserpath());
                if(file.exists()) file.delete();// 删除人物的时候把保存的头像也删除
            }
            infoService.deleteInfo(id);
            accountService.deleteUser(id);

//            map.put("state",true);
//            map.put("msg","删除用户信息成功");
            return Result.succ("删除用户成功！");
        } catch (Exception e) {
            e.printStackTrace();
//            map.put("state",false);
//            map.put("msg","删除用户信息失败");
            return Result.fail("提示:"+e.getMessage());
        }
    }
}

