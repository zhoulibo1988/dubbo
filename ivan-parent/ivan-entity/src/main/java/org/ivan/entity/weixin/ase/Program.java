package org.ivan.entity.weixin.ase;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

public class Program {

	public static void main(String[] args) throws Exception {

		//
		// 第三方回复公众平台
		//

		// 需要加密的明文
		String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
		String token = "pamtest";
		String timestamp = "1409304348";
		String nonce = "xxxxxx";
		String appId = "wxb11529c136998cb6";
		String replyMsg = "<xml>    <AppId><![CDATA[wxab704684bc31ff32]]></AppId>    <Encrypt><![CDATA[wHhyjhpVb2fspDfN9k9F7ZH1k2JtcLFi03XiQG9jILZRK6lNKWHkrnSkTjfHEiWIrwrIytdVNlZl4ff7KJ78Msih+dlRNuKiDU3ZS5NUb3Ux8itH1ccl//Ou+VAHTU3fsKAfXx26SPd7UPvbJGL6a2cqDWPJc5H0lbNV+C3AgCkvw6VCuN4A7xO52MDzXpWnlYY8SjKJ8wUtAYenIHgq9RheZmt1CfsKkQz063MUk2FiV10bbyFAPc4WI6l6Zg63u2Jm4JO9X/PC/g04OksTtGzJLfjy7X58BbrMvcFzgoAkE1qoX19P8HoQb26xUM2sMn/lbpbbfqIWwJROacksRldJLwvhnveB5VTjZ3Kh3EsHzGv5v79bfC0Cdcuy5e+HZVL3+L6mUE48u/kFUFRc0t6vnEF9fHuubeMZ20pWpuEX1k0cqmPKMwxTV7MATxt2CsiUyf/IP79O88i+c8HtPQ==]]></Encrypt></xml>";

		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		String mingwen = pc.encryptMsg(replyMsg, timestamp, nonce);
		System.out.println("加密后: " + mingwen);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(mingwen);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
		NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

		String encrypt = nodelist1.item(0).getTextContent();
		String msgSignature = nodelist2.item(0).getTextContent();

		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
		String fromXML = String.format(format, encrypt);

		//
		// 公众平台发送消息给第三方，第三方处理
		//

		// 第三方收到公众号平台发送的消息
		String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		System.out.println("解密后明文: " + result2);
		
		//pc.verifyUrl(null, null, null, null);
	}
}
