package tongji.edu.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000116660783";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDynyezyQbOQVJFOBwvXiRo+U9Bgf0g0GYEL908Raka/83tkYAEPLgZ2b0ehBXTjTbGuedhOA66/mW+Q+r73GxjKb+3kQSbURVJquZCu/RvRASEhdYDTEPBg+jyi6Rd6m8GzghnswDDDY8IiuPFFBsAL9vYYSSyZgZ8GJ74uCUjJEdm48xtyMdnxQbNrvRtAg1dBGtpDp3T7VgZbVN90ETPGGpop+v8KZ9BJm/qeQr0NfZ7Kaxm3i3m7sS2j97xr7CUZ+LTZB/VnF3sKD+DD04JVwD/hwucNp0rFUUwWqbcV783oFWx4YVlty0HfzCjPOr/EfkeIKcL31c62cTw3on1AgMBAAECggEANwjnJp8JDiw/DziFHDGMrMswsTldQ95B5d09n/hlPZydB7Cji1KCqEp93bg0g0JbFIUC+UiP/tbKGXiqiusbIvtLY8ZfdyPTYlyD0stzzPFu3OjG/QSFshXL94i5hhwxhyehPHScTaJ7uYJX3FKNNWOlyNVwT49ZFTk4hk6vDeMxw84VPtWg6lcpKEsEvgsh+LxMVZOfuB3dM+SG0R6q0pyQqhs01GxrRnov6aVJ5pVEZFUPZIJHmUQweq2i7HX1dRPUqbNeemQdS2zhR3JUPcFZFcc57dQVJvrYu1cKkltUAvj5wTWJQa2oj4ikrHKNgrwvRdS7S1AabhgPiyqP2QKBgQD8m9LO/7ACbqBUb6OnnLCFiYRRwQXzX9KKnbI9K4z1Jlczg80F61KzU9wN59ooKloglsQvSBd9NCXNJB96KHUld7bxeABpbN+fC4T0PPmpQrYGtS03LpYZyY2yYlb+JZ357EGomIrFlxVLtpHh4GiFBKn60VUl5bFB19jirDuh9wKBgQD14QIGQ/6q3hJHim+Ba9sw5jtNmHecyPComefh+iMk7in2RWU7ar5V/WI+Zq9+iG9mAA/fho1yikk60gPgfxiwdnTqpikOccj6Qv+VdD4Djlv6VwUTVXL/75B21d7peSWZYH/mMvDUjd4UMwu/+/sKuMRUXiczllSO/pl2uN94cwKBgEn1hX89tVbA9QhDt3K3mac/YBJfpVJgV9Bl422tdpPAKf/XMwvsnkYK437exyzDWaf4/G+rd9Uck4TAcsbdWY8iwdlo/RXg3og+YyrvP1mjQpAsM5TYevIJ5Qa5bCb09I/b8E1gfCDl30JPrd6oSXHIr8vTxk5WNdPFUqbrLnp5AoGBALN5Cz5BkXltYZBgxyWD8dnOpAjuuphxv+CBftXe/JovUefWHZ9yOf6QVo7P61eEBTRB5VQ2Zbbuo6dQts2+V+oufQbuRFerzJSIJQEVeVKlLhQcQrMrEycn2Z40XGK1MDG1U4ZXNp0f9LNv0yrOph7cYUpn81tfZtd9lc0oAs5rAoGAWagf987NVGg2HIq5y9aVJV2sl7bHiGbSXkUzoNnzg7/uDdSgq+gCQDq+Nlzy2xras47JAngqERAVxRHR9OplXGY3TQwAlIjZKwjMx7rR1CKx7upt3ohF3LEM/cMUpCdOYxQnZzGdcgX0ggMK1DkEMXhyBbX6Xau5l/ThHrP+TyI=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。你自己的支付宝公钥，注意是支付宝公钥，不是应用公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn70eX2I63nBlB5MDpvZxLuW1TD6qelAZ6c1o1PYj9iDVQS1O/IRy5UjBOj2d2eXNwzL0shfU47/m8kspruPdQJE6czmTv0m7XwzpViOn6eWKW/C9shBk+FtNMZRI6VeFaUYXeXuK3C22yqOy7V5r64ebSLmC1OB6iuzeeUTyR/zgRJ/fSKrqeYwuogQshRlNBCi01cWuAq8vTZQT7tAgYuUptqWFiqIrocH8tfoOWAJE2N+aKD2p26R/JlqkrYlr9hcSSDXVvUZ6T92CZ/8d5I+YyyVRYzTW2rQEWE65o/4vwyqyRHzK2PZmQ+VnNPi5Nw0MANA3/AF5FzWMxl1kzQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}