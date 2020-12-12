package tongji.edu.donatesystem.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
@TableName(value = "donate")
public class Donate implements Serializable {

    private static final long serialVersionUID=1L;

      private String dUser;

    private Integer dProject;

    private String amount;

    private String out_trade_no;//商户订单号

    private String trade_no;//支付宝交易号

    @TableField(value = "time",fill = FieldFill.INSERT) // 绑定属性
    private LocalDateTime time;
    private Integer play;//是否支付成功  0未支付成功 1即为支付成功


}
