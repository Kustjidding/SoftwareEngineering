package tongji.edu.donatesystem.utils;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tongji.edu.donatesystem.utils.wxpaysdk.WXPayUtil;
import tongji.edu.donatesystem.utils.wxpaysdk.WXPayXmlUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class CommonUtils {
    /**
     * 生成uuid，即用来标识一笔订单
     * @return
     */
    public static String generateUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","").substring(0,32);
        return  uuid;
    }
    // /** + Enter 快捷键
    /**
     *MD5工具类
     * @param data
     * @return
     */
    public static String MD5(String data){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte [] array = md5.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(byte item : array){
                sb.append(Integer.toHexString((item&0xFF)|0x100).substring(1,3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilder documentBuilder = WXPayXmlUtil.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            WXPayUtil.getLogger().warn("Invalid XML, can not convert to map. Error message: {}. XML content: {}", ex.getMessage(), strXML);
            throw ex;
        }

    }

    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        org.w3c.dom.Document document = WXPayXmlUtil.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;
    }
    public static  String  createSign(SortedMap<String,String> params,String key){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String,String>> es = params.entrySet();
        Iterator<Map.Entry<String,String>> it = es.iterator();
        while(it.hasNext()){
            //生成stringA="appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA";
            Map.Entry<String,String> entry = (Map.Entry<String,String>)  it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if(null!=v&& !"".equals(v) && !"sign".equals(k)&& !"key".equals(k)){
                sb.append(k+"="+v+"&");
            }
        }
        sb.append("key=").append(key);
        String sign = CommonUtils.MD5(sb.toString()).toUpperCase();

        return sign;
    }

    /**
     * 校验签名
     * @param params
     * @param key
     * @return
     */
    public static boolean isCorrectSign(SortedMap<String,String> params,String key){
        String sign = createSign(params,key);
        String weixinPaySign =params.get("sign").toUpperCase();
        return weixinPaySign.equals(sign);
    }
}
