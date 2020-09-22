package 作业;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class NumConvertUtils {
    public static final int HUNDRED_MILLION = 100000000;
    public static final String ZERO_CN = "零";
    public static final String UNIT_CN_END= "圆整";
    public static String[] UNIT_CN_L = {"","拾","佰","仟"};
    public static String[] UNIT_CN_H = {"","亿","兆"};
    public static char[] NUM_CN = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};

    /**
     * 银行数字转换为中文大写数字；
     * 默认金额不能为负；
     * 可以处理24位10进制数字（0～ 99999999999999999999999999）
     * @param num 输入阿拉伯小写数字
     * @return 输出中文大写数字
     */
    public String numToChineseNum (String num) {
        String result = ZERO_CN;
        if(StringUtils.isBlank(num)) {
            result = ZERO_CN + UNIT_CN_END;
            return result;
        }

        num = num.trim();
        int len = num.length();
        int index = 0;
        int previousNum = 0;

        while(len>0 && index<3) {
            String last8Nums = num.substring(Math.max(0, len-8), len);

            try {
                int tempNum = Integer.parseInt(last8Nums);
                String tempCnNum = ZERO_CN;
                if(tempNum != 0) {
                    tempCnNum = this.lessHundredMillionToCnNum(tempNum) + UNIT_CN_H[index];
                } else {
                    num = num.substring(0,Math.max(0,len-8));
                    len = num.length();
                    index++;
                    previousNum = tempNum;
                    continue;
                }

                if(result.equals(ZERO_CN)) {
                    result = tempCnNum;
                } else if(previousNum < HUNDRED_MILLION/10){
                    result = tempCnNum + ZERO_CN + result;
                } else {
                    result = tempCnNum + result;
                }
                previousNum = tempNum;
            } catch (NumberFormatException e) {
                System.out.println("输入中包含非数字字符，无法转换！"); // 项目中使用日志
                return null;
            } catch (Exception e) {
                System.out.println("金额不能为负,无法转换！"); // 项目中使用日志
                return null;
            }
            num = num.substring(0,Math.max(0,len-8));
            len = num.length();
            index++;

        }

        if(len > 0) {
            System.out.println("金额超出可转换上界！请确认输入金额是否正常！");
            return null;
        }

        result = result + UNIT_CN_END;
        return result;
    }



    /**
     * 处理 long 类型范围内的正整数
     * @param num
     * @return
     */
    public String numToChineseNum(long num) throws Exception {
        if(num < 0) {
            throw new Exception("numToChineseNum : The number cannot be smaller than 0.");
        }

        String result = "零";
        if(num == 0) {
            return result;
        }

        int index = 0;
        long lastTempNum = 0;
        while (num > 0) {
            long a = num % HUNDRED_MILLION;
            int tempNum = (int) a;
            num = num/HUNDRED_MILLION;

            String tempCnNum = "零";
            if(tempNum != 0) {
                tempCnNum = this.lessHundredMillionToCnNum(tempNum) + UNIT_CN_H[index];
            } else {
                lastTempNum = tempNum;
                index++;
                continue;
            }

            if(result.equals("零")) {
                result = tempCnNum;
            } else if(lastTempNum < HUNDRED_MILLION/10){
                result = tempCnNum + "零" + result;
            } else {
                result = tempCnNum + result;
            }

            lastTempNum = tempNum;
            index++;
        }

        return result;
    }

    /**
     *  num<=100000000
     * @param num
     * @return
     */
    private String lessHundredMillionToCnNum (int num) throws Exception {
        if(num >= 100000000) {
            throw new Exception("lessHundredMillionToCnNum: The number cannot be greater than one hundred million(100000000).");
        }

        if(num < 0) {
            throw new Exception("lessHundredMillionToCnNum: The number cannot be smaller than 0.");
        }

        String result = "零";
        if(num == 0) {
            return result;
        }

        if(num < 10000) {
            return this.less10000numToCnNum(num);
        }

        int l_num = num%10000;
        int h_num = num/10000;

        String l_cnNum = l_num==0 ? "" : less10000numToCnNum(l_num);
        String h_cnNum = this.less10000numToCnNum(h_num) + "万";

        if(l_num>0 && l_num<1000) {
            l_cnNum = "零" + l_cnNum;
        }

        result = h_cnNum + l_cnNum;

        return result;
    }

    /**
     * @param num : 0~9999
     * @return : 中文大写数字
     */
    private String less10000numToCnNum (int num) throws Exception {
        if(num >= 10000) {
            throw new Exception("less10000numToCnNum: The number cannot be greater than 10000.");
        }

        if(num < 0) {
            throw new Exception("less10000numToCnNum: The number cannot be smaller than 0.");
        }

        String result = "";
        if(num == 0) {
            return "零";
        }

        int i = 0;
        boolean flag = false;

        while (num != 0) {
            int temp = num%10;

            if(temp != 0){
                result = NUM_CN[temp] + UNIT_CN_L[i] + result;
                flag = true;
            } else if(flag){
                result =  NUM_CN[temp] + result;
                flag = false;
            }

            i++;
            num = num/10;
        }

        return result;
    }

    @Test
    public void testNumToChineseNum() {
        String number_1 = "999999999999999999999999";
        String number_2 = "100000000000000000000000";
        String number_3 = "1000000000000000";
        String number_4 = "100000000";
        String number_5 = "1001000000000010";

        Assert.assertTrue("999999999999999999999999转换结果与预期不符合", "玖仟玖佰玖拾玖万玖仟玖佰玖拾玖兆玖仟玖佰玖拾玖万玖仟玖佰玖拾玖亿玖仟玖佰玖拾玖万玖仟玖佰玖拾玖圆整".equals(numToChineseNum(number_1)));
        Assert.assertTrue("100000000000000000000000与预期不符合", "壹仟万兆圆整".equals(numToChineseNum(number_2)));
        Assert.assertTrue("1000000000000000与预期不符合", "壹仟万亿圆整".equals(numToChineseNum(number_3)));
        Assert.assertTrue("100000000与预期不符合", "壹亿圆整".equals(numToChineseNum(number_4)));
        Assert.assertTrue("1001000000000010与预期不符合", "壹仟零壹万亿零壹拾圆整".equals(numToChineseNum(number_5)));
    }
}
