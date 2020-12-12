//package tongji.edu;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//public class Main {
//    public static void main(String[] args) {
//        //1.创建Generator对象
//        AutoGenerator autoGenerator = new AutoGenerator();
//        //2.数据源
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        dataSourceConfig.setDbType(DbType.MYSQL);
//        //dataSourceConfig.setUrl("jdbc:mysql://106.53.197.216:3306/test?useUnicode=true&&characterEncoding=UTF-8");
//        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/donatesystem?serverTimezone=Asia/Shanghai");
//        dataSourceConfig.setUsername("root");
//        dataSourceConfig.setPassword("20010204ZYL");
//        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
//        autoGenerator.setDataSource(dataSourceConfig);
//        //3.全局配置
//        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
//        globalConfig.setOpen(false);
//        globalConfig.setAuthor("kunshen");
//        globalConfig.setServiceName("%sService");
//        autoGenerator.setGlobalConfig(globalConfig);
//        //包信息
//        PackageConfig packageConfig = new PackageConfig();
//        packageConfig.setParent("tongji.edu");
//        packageConfig.setModuleName("donatesystem");//生成位置包
//        packageConfig.setController("controller");
//        packageConfig.setService("service");
//        packageConfig.setServiceImpl("service.impl");
//        packageConfig.setMapper("mapper");
//        packageConfig.setEntity("entity");
//        autoGenerator.setPackageInfo(packageConfig);
//        //配置策略
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setEntityLombokModel(true);//自动添加Lombok注解
////        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
////        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        //_转驼峰命名法
//        autoGenerator.setStrategy(strategyConfig);
//        autoGenerator.execute();
//
//
//
//
//
//
//
//    }
//}
