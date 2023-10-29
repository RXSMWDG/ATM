import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        //主frame
        JFrame frame = new JFrame("州哥银行");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ArrayList<people> peoplelist = new ArrayList<>();
        peoplelist.add(new people("1", "1", 0));
        peoplelist.add(new people("2", "1", 0));
        peoplelist.add(new people("123", "123", 100));
        peoplelist.add(new people("111", "111", 200));


        new Login_UI(frame, peoplelist);
        //select_UI selectUi = new select_UI(frame);
    }
}


class Login_UI {

    JPanel panel = new JPanel();
    JLabel tittle = new JLabel("欢迎来到州哥银行");
    JLabel LabelUser = new JLabel("账户");
    JTextField TextfiledAccount = new JTextField(20);
    JLabel LabelPassword = new JLabel("密码");
    JPasswordField PasswordfieldPassword = new JPasswordField(20);
    JButton ButtonLogin = new JButton("登录");

    JButton AddAccount = new JButton("注册");

    Login_UI(JFrame frame, ArrayList<people> peoplelist) {


        Font FontTittle = new Font("黑体", Font.BOLD, 32);
        Font FontLogin = new Font("黑体", Font.PLAIN, 18);
        Font FontButton = new Font("黑体", Font.PLAIN, 14);


        frame.add(panel);
        panel.setLayout(null);


        tittle.setFont(FontTittle);
        tittle.setBounds(170, 30, 400, 100);
        panel.add(tittle);


        LabelUser.setFont(FontLogin);
        LabelUser.setBounds(140, 120, 50, 20);
        panel.add(LabelUser);


        TextfiledAccount.setBounds(200, 115, 200, 30);
        panel.add(TextfiledAccount);


        LabelPassword.setFont(FontLogin);
        LabelPassword.setBounds(140, 160, 50, 20);
        panel.add(LabelPassword);

        PasswordfieldPassword.setBounds(200, 155, 200, 30);
        panel.add(PasswordfieldPassword);

        ButtonLogin.setFont(FontButton);
        ButtonLogin.setBounds(180, 200, 80, 30);
        panel.add(ButtonLogin);

        AddAccount.setFont(FontButton);
        AddAccount.setBounds(300, 200, 80, 30);
        panel.add(AddAccount);

        ButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                String password;
                name = TextfiledAccount.getText();
                password = PasswordfieldPassword.getText();
                LoginCheck loginCheck = new LoginCheck(name, password);
                if (loginCheck.check(frame, peoplelist)) {
                    int peoplenumber = loginCheck.getpeoplenumber(peoplelist);
                    //关闭上个一panel
                    panel.setVisible(false);
                    new select_UI(frame, peoplelist, peoplenumber);
                } else {
                    System.out.println(name + password);
                }
            }
        });
        //注册按钮，调用people.addaccount
        AddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new AddAccunt_UI(frame, peoplelist);
            }
        });

        //设置可见
        frame.setVisible(true);


    }
}


class AddAccunt_UI {

    JPanel panel = new JPanel();
    JLabel tittle = new JLabel("欢迎来到州哥银行");
    JLabel jLabel1 = new JLabel("注册账户");
    JTextField textField1 = new JTextField(20);
    JLabel label2 = new JLabel("密码");
    JPasswordField passwordField = new JPasswordField(20);
    JButton button = new JButton("注册");
    JButton back = new JButton("返回");


    AddAccunt_UI(JFrame frame, ArrayList<people> peoplelist) {


        Font FontTittle = new Font("黑体", Font.BOLD, 32);
        Font FontLogin = new Font("黑体", Font.PLAIN, 18);
        Font FontButton = new Font("黑体", Font.PLAIN, 14);


        frame.add(panel);
        panel.setLayout(null);


        tittle.setFont(FontTittle);
        tittle.setBounds(170, 30, 400, 100);
        panel.add(tittle);


        jLabel1.setFont(FontLogin);
        jLabel1.setBounds(140, 120, 50, 20);
        panel.add(jLabel1);


        textField1.setBounds(200, 115, 200, 30);
        panel.add(textField1);


        label2.setFont(FontLogin);
        label2.setBounds(140, 160, 50, 20);
        panel.add(label2);

        passwordField.setBounds(200, 155, 200, 30);
        panel.add(passwordField);


        button.setFont(FontButton);
        button.setBounds(300, 200, 80, 30);
        panel.add(button);

        back.setFont(FontButton);
        back.setBounds(460, 260, 80, 50);
        panel.add(back);


        //注册按钮，调用people.addaccount
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new people().addaccount(frame, peoplelist, textField1.getText(), passwordField.getText());
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new Login_UI(frame, peoplelist);
            }
        });


        //设置可见
        frame.setVisible(true);


    }
}


class select_UI {
    JPanel panel = new JPanel();
    JButton button1 = new JButton("存款");
    JButton button2 = new JButton("取款");
    JButton button3 = new JButton("转账");
    JButton button4 = new JButton("余额");
    JButton back = new JButton("返回");

    select_UI(JFrame frame, ArrayList<people> peoplelist, int peoplenumber) {
        Font FontButton = new Font("黑体", Font.PLAIN, 14);

        frame.add(panel);
        panel.setLayout(null);

        button1.setFont(FontButton);
        button1.setBounds(20, 20, 80, 50);
        panel.add(button1);

        button2.setFont(FontButton);
        button2.setBounds(20, 100, 80, 50);
        panel.add(button2);

        button3.setFont(FontButton);
        button3.setBounds(20, 180, 80, 50);
        panel.add(button3);

        button4.setFont(FontButton);
        button4.setBounds(20, 260, 80, 50);
        panel.add(button4);

        back.setFont(FontButton);
        back.setBounds(460, 260, 80, 50);
        panel.add(back);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new SaveMoney_UI(frame, peoplelist, peoplenumber);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new WithDrawal_UI(frame, peoplelist, peoplenumber);
            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new TurnMoney_UI(frame, peoplelist, peoplenumber);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new Raming_UI(frame, peoplelist, peoplenumber);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new Login_UI(frame, peoplelist);
            }
        });

    }
}


class SaveMoney_UI {
    JPanel panel = new JPanel();
    JLabel turntoname = new JLabel("存款金额");
    JTextField textField1 = new JTextField();
    JButton button = new JButton("确认");
    JButton back = new JButton("返回");

    SaveMoney_UI(JFrame frame, ArrayList<people> peoplelist, int peoplenumber) {
        Font FontLogin = new Font("黑体", Font.PLAIN, 18);
        Font FontButton = new Font("黑体", Font.PLAIN, 14);


        frame.add(panel);
        panel.setLayout(null);

        turntoname.setFont(FontLogin);
        turntoname.setBounds(140, 120, 80, 20);
        panel.add(turntoname);

        textField1.setBounds(230, 115, 200, 30);
        panel.add(textField1);

        button.setFont(FontButton);
        button.setBounds(260, 170, 80, 30);
        panel.add(button);

        back.setFont(FontButton);
        back.setBounds(460, 260, 80, 50);
        panel.add(back);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new people().deposit(frame, peoplelist, peoplenumber, Double.parseDouble(textField1.getText()));
                    textField1.setText("");

                } catch (Exception NumberFormatException) {
                    textField1.setText("");
                    new floatwindow(frame, "存款失败");
                }

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new select_UI(frame, peoplelist, peoplenumber);
            }
        });

    }
}


class WithDrawal_UI {
    JPanel panel = new JPanel();
    JLabel turntoname = new JLabel("取款金额");
    JTextField textField1 = new JTextField();
    JButton button = new JButton("确认");
    JButton back = new JButton("返回");

    WithDrawal_UI(JFrame frame, ArrayList<people> peoplelist, int peoplenumber) {
        Font FontLogin = new Font("黑体", Font.PLAIN, 18);
        Font FontButton = new Font("黑体", Font.PLAIN, 14);


        frame.add(panel);
        panel.setLayout(null);

        turntoname.setFont(FontLogin);
        turntoname.setBounds(140, 120, 80, 20);
        panel.add(turntoname);

        textField1.setBounds(230, 115, 200, 30);
        panel.add(textField1);

        button.setFont(FontButton);
        button.setBounds(260, 170, 80, 30);
        panel.add(button);

        back.setFont(FontButton);
        back.setBounds(460, 260, 80, 50);
        panel.add(back);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new people().withdrawal(frame, peoplelist, peoplenumber, Double.parseDouble(textField1.getText()));
                    textField1.setText("");
                } catch (Exception NumberFormatException) {
                    textField1.setText("");
                    new floatwindow(frame, "取款失败");
                }

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new select_UI(frame, peoplelist, peoplenumber);
            }
        });

    }
}


class TurnMoney_UI {
    JPanel panel = new JPanel();
    JLabel turntoname = new JLabel("转账账户");
    JTextField textField1 = new JTextField();
    JLabel turntomoney = new JLabel("转账金额");
    JTextField textField2 = new JTextField();
    JButton button = new JButton("确认");
    JButton back = new JButton("返回");

    TurnMoney_UI(JFrame frame, ArrayList<people> peoplelist, int peoplenumber) {
        Font FontLogin = new Font("黑体", Font.PLAIN, 18);
        Font FontButton = new Font("黑体", Font.PLAIN, 14);


        frame.add(panel);
        panel.setLayout(null);

        turntoname.setFont(FontLogin);
        turntoname.setBounds(140, 120, 80, 20);
        panel.add(turntoname);

        textField1.setBounds(230, 115, 200, 30);
        panel.add(textField1);

        turntomoney.setFont(FontLogin);
        turntomoney.setBounds(140, 160, 80, 20);
        panel.add(turntomoney);

        textField2.setBounds(230, 155, 200, 30);
        panel.add(textField2);

        button.setFont(FontButton);
        button.setBounds(260, 200, 80, 30);
        panel.add(button);

        back.setFont(FontButton);
        back.setBounds(460, 260, 80, 50);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new select_UI(frame, peoplelist, peoplenumber);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new people().transfers(frame, peoplelist, peoplenumber, textField1.getText(), Double.parseDouble(textField2.getText()));
                } catch (Exception NumberFormatException) {
                    new floatwindow(frame, "转账失败");
                }
            }
        });
    }

}


class Raming_UI {
    JPanel panel = new JPanel();
    JLabel turntoname = new JLabel("账户");
    JTextField textField1 = new JTextField();
    JLabel turntomoney = new JLabel("余额");
    JTextField textField2 = new JTextField();
    JButton back = new JButton("返回");

    Raming_UI(JFrame frame, ArrayList<people> peoplelist, int peoplenumber) {
        Font FontLogin = new Font("黑体", Font.PLAIN, 18);
        Font FontButton = new Font("黑体", Font.PLAIN, 14);


        frame.add(panel);
        panel.setLayout(null);


        textField1.setText(peoplelist.get(peoplenumber).name);
        textField2.setText(String.valueOf(peoplelist.get(peoplenumber).money));

        turntoname.setFont(FontLogin);
        turntoname.setBounds(140, 120, 80, 20);
        panel.add(turntoname);

        textField1.setBounds(230, 115, 200, 30);
        panel.add(textField1);

        turntomoney.setFont(FontLogin);
        turntomoney.setBounds(140, 160, 80, 20);
        panel.add(turntomoney);

        textField2.setBounds(230, 155, 200, 30);
        panel.add(textField2);

        back.setFont(FontButton);
        back.setBounds(460, 260, 80, 50);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new select_UI(frame, peoplelist, peoplenumber);
            }
        });

    }

}


class LoginCheck {
    String name;
    String password;

    LoginCheck(String name, String password) {
        this.name = name;
        this.password = password;
    }

    boolean check(JFrame frame, ArrayList<people> peoplelist) {
        for (people people : peoplelist) {
            if (people.name.equals(name))
                if (people.password.equals(password))
                    return true;
        }
        new floatwindow(frame, "未找到账户或密码不正确");
        return false;
    }

    int getpeoplenumber(ArrayList<people> peoplelist) {
        for (int i = 0; i < peoplelist.size(); i++) {
            if (peoplelist.get(i).name.equals(name))
                return i;
        }
        return -1;
    }

}


class people {
    String name;
    String password;
    double money;

    people() {

    }

    people(String name, String password, double money) {
        this.name = name;
        this.password = password;
        this.money = money;
    }

    void addaccount(JFrame frame, ArrayList<people> peoplelist, String name, String password) {
        for (people people : peoplelist) {
            if (people.name.equals(name)) {
                new floatwindow(frame, "账户已被占用");
                return;
            }
        }
        peoplelist.add(new people(name, password, 0));
        new floatwindow(frame, "账户创建成功");

    }

    void deposit(JFrame frame, ArrayList<people> peoplelist, int peoplenumber, double money) {
        peoplelist.get(peoplenumber).money += money;
        new floatwindow(frame, "存款成功");
    }

    void withdrawal(JFrame frame, ArrayList<people> peoplelist, int peoplenumber, double money) {
        if (peoplelist.get(peoplenumber).money < money) {
            new floatwindow(frame, "余额不足");
        } else {
            peoplelist.get(peoplenumber).money -= money;
            new floatwindow(frame, "取款成功");
        }
    }

    void transfers(JFrame frame, ArrayList<people> peoplelist, int peoplenumber, String othername, double money) {
        for (people people : peoplelist) {
            if (people.name.equals(othername)) {
                if (peoplelist.get(peoplenumber).money < money) {
                    new floatwindow(frame, "余额不足");
                    return;
                } else {
                    peoplelist.get(peoplenumber).money -= money;
                    people.money += money;
                    new floatwindow(frame, "转账完成");
                    return;
                }
            }
        }
        new floatwindow(frame, "未找到账户");

    }

}


//弹窗类，用于提示操作结果
class floatwindow {

    floatwindow(JFrame frame, String massage) {
        JOptionPane.showMessageDialog(frame, massage);
    }
}