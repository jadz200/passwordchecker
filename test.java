import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class test extends JFrame implements ActionListener  {
    public static JFrame frame =new JFrame();
    public static JPanel panel=new JPanel();
    public static JPasswordField passwordText=new JPasswordField();
    public static Icon open=new ImageIcon("visible.png");
    public static JButton visible=new JButton(open);
    public static Icon closed=new ImageIcon("hidden.png");
    public static JButton hidden=new JButton(closed);
    public static JButton confirm=new JButton();
    public static JLabel error=new JLabel("There is no password");
    public static JLabel power=new JLabel();
    public static JLabel size_error=new JLabel("Your password should have at least 8 charachters");
    public static JLabel number_error=new JLabel("Your password should have at least one number");
    public static JLabel upper_error=new JLabel("Your password should have at least one uppercase charchter");
    public static JLabel lower_error=new JLabel("Your password should have at least one lowercase charchter");
    public static JLabel symbol_error=new JLabel("<html>Your password should have at least one of the following symbol:<br>~`! @#$%^&*()_-+={[}]|\\:;\"\'<,>.?/</html>");

    public static void main(String[] args) {
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel title=new JLabel("Password Checker");
        title.setBounds(275, 20, 150, 10);
        panel.add(title);

        JLabel pass=new JLabel("Password");
        pass.setBounds(100,75,80,25);
        panel.add(pass);

        passwordText.setBounds(200, 75, 165, 25);
        passwordText.setEchoChar('*');
        panel.add(passwordText);
        
        visible.setBounds(375, 75, 50, 25);
        visible.addActionListener(new test());
        panel.add(visible);

        hidden.setBounds(375, 75, 50, 25);
        hidden.addActionListener(new test());
        panel.add(hidden);
        hidden.setVisible(false);
        
        confirm.setText("Confirm");
        confirm.setBounds(100,125,100,25);
        confirm.addActionListener(new test());
        panel.add(confirm);
        
        error.setBounds(210,125,300,25);
        error.setVisible(false);
        panel.add(error);

        power.setBounds(210,125,300,25);
        power.setVisible(false);
        panel.add(power);

        panel.add(size_error);

        panel.add(number_error);

        panel.add(upper_error);

        panel.add(lower_error);

        panel.add(symbol_error);

        ImageIcon img=new ImageIcon("image.jpg");
        JLabel background=new JLabel(img);
        background.setBounds(0,0,600,500);
        panel.add(background);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==visible){
            passwordText.setEchoChar((char)0);
            visible.setVisible(false);
            hidden.setVisible(true);

        }else if(e.getSource()==hidden){
            passwordText.setEchoChar('*');
            visible.setVisible(true);
            hidden.setVisible(false);

        }else if(e.getSource()==confirm){
            char[] password=passwordText.getPassword();
            passCheck(password);
        }
    }
    
    public static void passCheck(char[] arr){
        error.setVisible(false);
        power.setVisible(false);
        size_error.setVisible(false);
        number_error.setVisible(false);
        upper_error.setVisible(false);
        lower_error.setVisible(false);
        symbol_error.setVisible(false);

        ArrayList<String> errors=new ArrayList<String>();
        errors.add("size");
        errors.add("lowercase");
        errors.add("uppercase");
        errors.add("number");
        errors.add("symbol");
        
        int n=150;

        
        if(arr.length>=8){
            errors.remove("size");
        }
        
        if(arr.length==0){
            error.setText("There is no password");
            error.setVisible(true);
            return;
        }
        
        for(int i=0;i<arr.length;i++){

            if(arr[i]==' '){
                error.setText("You cannot have spaces in your password");
                error.setVisible(true);
                return;
            }

            if(arr[i]>='A'&& arr[i]<='Z'){
                if(errors.indexOf("uppercase")!=-1){
                    errors.remove(errors.indexOf("uppercase"));
                }
            }

            if(arr[i]>='0'&&arr[i]<='9'){
                if(errors.indexOf("number")!=-1){
                    errors.remove(errors.indexOf("number"));
                }
            }

            if(arr[i]>='a'&&arr[i]<='z'){
                if(errors.indexOf("lowercase")!=-1){
                    errors.remove(errors.indexOf("lowercase"));
                }
            }
            
            if(arr[i]=='!'||arr[i]=='`'||arr[i]=='~'||arr[i]=='@'||arr[i]=='#'||arr[i]=='$'||arr[i]=='%'||arr[i]=='^'||arr[i]=='&'||arr[i]=='*'||arr[i]=='('||arr[i]==')'||arr[i]=='-'||arr[i]=='_'||arr[i]=='+'||arr[i]=='='||arr[i]=='{'||arr[i]=='}'||arr[i]=='['||arr[i]==']'||arr[i]=='|'||arr[i]=='\\'||arr[i]==':'||arr[i]==';'||arr[i]=='\"'||arr[i]=='\''||arr[i]=='<'||arr[i]=='>'||arr[i]==','||arr[i]=='.'||arr[i]=='?'||arr[i]=='/'){
                if(errors.indexOf("symbol")!=-1){
                    errors.remove(errors.indexOf("symbol"));
                }
            }
        }
                
        if(errors.isEmpty()){
            power.setText("Your password is Strong.");
            power.setVisible(true);
            return;
        }else if (errors.size()>=3){
            power.setText("Your password is weak.");
            power.setVisible(true);
        }else{
            power.setText("Your password is moderate.");
            power.setVisible(true);
        }

        for(int i=0;i<errors.size();i++){
            if(errors.get(i).equals("size")){
                size_error.setBounds(210,n,400,25);
                size_error.setVisible(true);
                n+=25;

            } else if(errors.get(i).equals("number")){
                number_error.setBounds(210,n,400,25);
                number_error.setVisible(true);
                n+=25;

            }else if(errors.get(i).equals("uppercase")){
                upper_error.setBounds(210,n,400,25);
                upper_error.setVisible(true);
                n+=25;

            }else if(errors.get(i).equals("lowercase")){
                lower_error.setBounds(210,n,400,25);
                lower_error.setVisible(true);
                n+=25;

            }else if(errors.get(i).equals("symbol")){
                symbol_error.setBounds(210,n,400,50);
                symbol_error.setVisible(true);
                n+=25;

            }
        }
    }
}
