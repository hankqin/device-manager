package com.yykj.system.handlerequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.yykj.base.util.LogUtil;
import com.yykj.base.util.ReadXmlFileUtil;

/**
 * 处理2015002交易 
 * 设备注册
 * @author QinShuJin
 * 2015年7月10日 下午2:32:07
 */
@SuppressWarnings("all")
public class Handler2015002 extends Handler {
	private Logger log = LogUtil.getInstance().getLogger(Handler2015002.class);

	@Override
	public String handleRequest(Map<String,String> title,String deviceRequestXml) {
		String ChannelDate = title.get("ChannelDate");	//业务请求时间
		String trancode  =title.get("TranCode");		//业务代码
		String responseXml = null;
		if ("2015002".equals(trancode)) {
			responseXml=ReadXmlFileUtil.getXml("2015002_response.xml","com/yykj/system/handlerequest/bankxml/");
		} else {
			responseXml = getSuccessor().handleRequest(title,deviceRequestXml);
		}
		return responseXml;
	}
}
