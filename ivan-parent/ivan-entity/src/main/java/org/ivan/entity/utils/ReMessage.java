package org.ivan.entity.utils;
import java.util.HashMap;
import java.util.Map;

public class ReMessage {
	/**
     * 用于客户端解析的json对象
     *
     * @param paraEunm 枚举对象 eg:ParameterEunm.SUCCESSFUL_CODE
     * @param paraData 返回的具体数据 可对象为空
     * @return 封装好的返回对象
     */
    public static Map<String, Object> resultBack(ParameterEunm paraEunm, Object paraData) {
        Map<String, Object> re = new HashMap<>();
        re.put(ParameterEunm.RESULT_DATA_STATUS_KEY.getBackParameter().toString(), paraEunm.getBackParameter());
        if (null != paraData) {
            re.put(ParameterEunm.RESULT_DATA_CONTENT_KEY.getBackParameter().toString(), paraData);
        }
        re.put(ParameterEunm.RESULT_DATA_MESSAGE_KEY.getBackParameter().toString(), paraEunm.getParameterName());
        return re;
    }
}
