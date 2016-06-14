package huawei;


import java.util.Scanner;

public class Test1 {
	/**
     * 验证ip是否合法
     * 
     * @param text
     *            ip地址
     * @return 验证信息
     * 
     */
    public static String ipCheck(String text) {
        if (text != null && !text.isEmpty()) {
            // 定义正则表达式
            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
            // 判断ip地址是否与正则表达式匹配
            if (text.matches(regex)) {
                // 返回判断信息
                return "YES";
            } else {
                // 返回判断信息
                return "NO";
            }
        }
        return "NO";
        /*// 返回判断信息
        return "请输入要验证的IP地址！";*/
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(ipCheck(sc.nextLine()));

	}

}

