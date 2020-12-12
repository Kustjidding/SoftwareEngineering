package tongji.edu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.mapper.*;
import tongji.edu.donatesystem.service.AccountService;

import java.io.IOException;

@SpringBootTest
@MapperScan("tongji.edu.donatesystem.mapper")
class DonatesystemApplicationTests {
	@Autowired
	private AccountMapper amapper;
	@Autowired
	private DonateMapper  dmapper;
	@Autowired
	private InfoMapper imapper;
	@Autowired
	private ProjectMapper pmapper;
	@Autowired
	private ReportMapper rmapper;
	@Test
	void contextLoads() {
	}
	@Test
	void findUser(){

		QueryWrapper wrapper =new QueryWrapper();
		wrapper.eq("user_id","14534587210");
		amapper.selectOne(wrapper);

	}
	@Test
	void findLike(){
		QueryWrapper wrapper =new QueryWrapper();
		wrapper.like("username","文");
		amapper.selectList(wrapper).forEach(System.out::println);
	}
	@Test
	public  void testDemo() throws Exception{
		String str = WXPayUtil.generateNonceStr();
		System.out.println(str);
	}

}
