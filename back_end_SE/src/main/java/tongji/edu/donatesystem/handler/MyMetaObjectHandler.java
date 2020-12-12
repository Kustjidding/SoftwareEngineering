package tongji.edu.donatesystem.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component //加注解，springBoot会自动纳入
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        this.setFieldValByName("time",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //this.setFieldValByName("time",new Date(),metaObject);
    }
}
