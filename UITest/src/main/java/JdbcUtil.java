import java.sql.*;

public class JdbcUtil {
    // 初始化

    public static String init() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        String result=null;
        // 不同的数据库有不同的驱动  10.165.177.80  223.252.220.35:18211
        // //223.252.220.37:1046   10.165.177.80:9573
        String driverName = "oracle.jdbc.driver.OracleDriver";
        // String url = "jdbc:oracle:thin:@223.252.220.37:1046:epay35";
        // String url = "jdbc:oracle:thin:@10.165.177.80:9573:epay35";
        // String url = "jdbc:oracle:thin:@epaydb.inter.163.com:9573/epaytest";
        String url = "jdbc:oracle:thin:@127.0.0.1:9573/epaytest";
        //  String url = "jdbc:oracle:thin:@127.0.0.1:9573/yyn";
        //  String url = "jdbc:oracle:thin:@127.0.0.1:9573";
        //  String url = "jdbc:oracle:thin:@223.252.220.35:18211:epay35";
        String user = "EPAY_QA_APP";
        String password = "fZnFKNhs";//'EPAY_QA_APP',' fZnFKNhs','epaydb.inter.163.com:9573/epaytest'

        try {
            // 加载驱动
            Class.forName(driverName);
            // 设置 配置数据
            // 1.url(数据看服务器的ip地址 数据库服务端口号 数据库实例)
            // 2.user
            // 3.password
           // DriverManager.setLoginTimeout(90);
            conn = DriverManager.getConnection(url, user, password);
            // 开始连接数据库
            System.out.println("数据库连接成功..");

            statement = conn.createStatement();
            //3.准备Sql
          //  String src="epaydailytest@163.com";
           String sql = "select authcode from tb_sms_authcode where operation_id='yd.04d724a95c6440238@163.com'and update_time=(select max(update_time)from tb_sms_authcode where operation_id='yd.04d724a95c6440238@163.com')";
           // String sql = "select authcode from tb_sms_authcode where operation_id"+"'"+src+"'"+"and update_time=(select max(update_time)from tb_sms_authcode where operation_id="+"'"+src+"'";

            //4.执行查询，得到ResultSet
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("authcode");
                System.out.println("***************NAME="+name);
                result=name;
            }

         }catch (Exception e) {
                e.printStackTrace();
            }
            return result;
    }

    }


