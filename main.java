import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;


public class main extends JFrame implements ActionListener  {
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
    public static JLabel upper_error=new JLabel("Your password should have at least one uppercase charachter");
    public static JLabel lower_error=new JLabel("Your password should have at least one lowercase charachter");
    public static JLabel symbol_error=new JLabel("<html>Your password should have at least one of the following <br> symbol:~`!@#$%^&*()_-+={[}]|\\:;\"\'<,>.?/</html>");
    public static JLabel gen_pass=new JLabel();
    public static JButton generate=new JButton("Generate");
    public static JCheckBox cb1=new JCheckBox();
    public static JCheckBox cb2=new JCheckBox();
    public static JCheckBox cb3=new JCheckBox();
    public static boolean without_upper=false;
    public static boolean without_symbol=false; 
    public static boolean without_number=false; 

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
        visible.addActionListener(new main());
        panel.add(visible);

        hidden.setBounds(375, 75, 50, 25);
        hidden.addActionListener(new main());
        panel.add(hidden);
        hidden.setVisible(false);
        
        confirm.setText("Confirm");
        confirm.setBounds(90,125,100,25);
        confirm.addActionListener(new main());
        panel.add(confirm);
        
        error.setBounds(210,125,300,25);
        error.setVisible(false);
        panel.add(error);

        power.setBounds(227,125,300,25);
        power.setVisible(false);
        panel.add(power);

        panel.add(size_error);

        panel.add(number_error);

        panel.add(upper_error);

        panel.add(lower_error);

        panel.add(symbol_error);
        
        generate.setBounds(90,155,100,25);
        generate.addActionListener(new main());
        panel.add(generate);
        
        gen_pass.setBounds(210,155,200,25);
        panel.add(gen_pass);

        cb1.setBounds(90,181,150,25);
        cb1.setText("Without symbols");
        cb1.setOpaque(false);
        cb1.addActionListener(new main());
        panel.add(cb1);
        

        cb2.setBounds(90,207,150,25);
        cb2.setText("Without numbers");
        cb2.setOpaque(false);
        cb2.addActionListener(new main());
        panel.add(cb2);

        cb3.setBounds(90,233,150,25);
        cb3.setText("Without uppercases");
        cb3.setOpaque(false);
        cb3.addActionListener(new main());
        panel.add(cb3);

        ImageIcon img=new ImageIcon("image.jpg");
        JLabel background=new JLabel(img);
        background.setBounds(0,0,600,500);
        panel.add(background);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(cb1.isSelected()){
            without_symbol=true;
        }else{
            without_symbol=false;
        }
        if(cb2.isSelected()){
            without_number=true;
        }else{
            without_number=false;
        }
        if(cb3.isSelected()){
            without_upper=true;
        }else{
            without_upper=false;
        }

        if(e.getSource()==visible){
            passwordText.setEchoChar((char)0);
            visible.setVisible(false);
            hidden.setVisible(true);

        }else if(e.getSource()==hidden){
            passwordText.setEchoChar('*');
            visible.setVisible(true);
            hidden.setVisible(false);

        }else if(e.getSource()==confirm){
            reset();
            char[] password=passwordText.getPassword();
            passCheck(password);
        }else if(e.getSource()==generate){
            reset();
            generate_pass();
        }
    }
    public static void reset(){
        error.setVisible(false);
        power.setVisible(false);
        size_error.setVisible(false);
        number_error.setVisible(false);
        upper_error.setVisible(false);
        lower_error.setVisible(false);
        symbol_error.setVisible(false);
        gen_pass.setVisible(false);

    }
    public static void generate_pass(){
        String pass="";
        String lowercase="qwertyuiopasdfghjklzxcvbnm";
        String uppercase="QWERTYUIOPASDFGHJKLZXCVBNM";
        String symbol="~`!@#$%^&*()_-+={[}]|\\:;\"\'<,>.?/";
        String number="1234567890";
        int length=8+(int)(Math.random()*((12-8)+1));
        if(without_number==true&&without_symbol==true&&without_upper==true){
            for(int i=0;i<length;i++){
                pass+=lowercase.charAt(0+(int)(Math.random()*((lowercase.length()-0))));
            }
        }else if(without_number==true&&without_symbol==true){
            pass+=uppercase.charAt((int)(Math.random()*uppercase.length()));
            pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
            for(int i=0;i<length-2;i++){
                int rand=(int)(Math.random()*2);
                if(rand==0){
                    pass+=uppercase.charAt((int)(Math.random()*uppercase.length()));
                }else if (rand==1){
                    pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
                }
            }
        }else if(without_number==true&&without_upper==true){
            pass+=symbol.charAt((int)(Math.random()*symbol.length()));
            pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
            for(int i=0;i<length-2;i++){
                int rand=(int)(Math.random()*2);
                if(rand==0){
                    pass+=symbol.charAt((int)(Math.random()*symbol.length()));
                }else if (rand==1){
                    pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
                }
            }
        }else if(without_upper==true&&without_symbol==true){
            pass+=number.charAt((int)(Math.random()*number.length()));
            pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
            for(int i=0;i<length-2;i++){
                int rand=(int)(Math.random()*2);
                if(rand==0){
                    pass+=number.charAt((int)(Math.random()*number.length()));
                }else if (rand==1){
                    pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
                }
            }
        }else if(without_number==true){
            pass+=uppercase.charAt((int)(Math.random()*uppercase.length()));
            pass+=symbol.charAt((int)(Math.random()*symbol.length()));
            pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
            for(int i=0;i<length-3;i++){
                int rand=(int)(Math.random()*3);
                if(rand==0){
                    pass+=uppercase.charAt((int)(Math.random()*uppercase.length()));
                }else if(rand==1){
                    pass+=symbol.charAt((int)(Math.random()*symbol.length()));
                }else if (rand==2){
                    pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
                }
            }
        }else if(without_upper==true){
            pass+=number.charAt((int)(Math.random()*number.length()));
            pass+=symbol.charAt((int)(Math.random()*symbol.length()));
            pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
            for(int i=0;i<length-3;i++){
                int rand=(int)(Math.random()*3);
                if(rand==0){
                    pass+=symbol.charAt((int)(Math.random()*symbol.length()));
                }else if(rand==1){
                    pass+=number.charAt((int)(Math.random()*number.length()));
                }else if (rand==2){
                    pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
                }
            }
        }else if(without_symbol==true){
            pass+=number.charAt((int)(Math.random()*number.length()));
            pass+=uppercase.charAt((int)(Math.random()*uppercase.length())); 
            pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
            for(int i=0;i<length-3;i++){
                int rand=(int)(Math.random()*3);
                if(rand==0){
                    pass+=uppercase.charAt((int)(Math.random()*uppercase.length()));
                }else if(rand==1){
                    pass+=number.charAt((int)(Math.random()*number.length()));
                }else if (rand==2){
                    pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
                }
            }
        }else{
            pass+=uppercase.charAt((int)(Math.random()*uppercase.length()));
            pass+=number.charAt((int)(Math.random()*number.length())); 
            pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
            pass+=symbol.charAt((int)(Math.random()*symbol.length()));
            for(int i=0;i<=length-4;i++){
                int rand=(int)(Math.random()*4);
                if(rand==0){
                    pass+=uppercase.charAt((int)(Math.random()*uppercase.length()));
                }else if(rand==1){
                    pass+=symbol.charAt((int)(Math.random()*symbol.length()));
                }else if(rand==2){
                    pass+=number.charAt((int)(Math.random()*number.length()));
                }else if (rand==3){
                    pass+=lowercase.charAt((int)(Math.random()*lowercase.length()));
                }
            }
        }
        gen_pass.setText(pass);
        gen_pass.setVisible(true);

    }
    public static void passCheck(char[] arr){
        ArrayList<String> errors=new ArrayList<String>();
        errors.add("size");
        errors.add("lowercase");
        errors.add("uppercase");
        errors.add("number");
        errors.add("symbol");

        
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
        int n=150;
        for(int i=0;i<errors.size();i++){
            if(errors.get(i).equals("size")){
                size_error.setBounds(227,n,400,25);
                size_error.setVisible(true);
                n+=25;

            } else if(errors.get(i).equals("number")){
                number_error.setBounds(227,n,400,25);
                number_error.setVisible(true);
                n+=25;

            }else if(errors.get(i).equals("uppercase")){
                upper_error.setBounds(227,n,400,25);
                upper_error.setVisible(true);
                n+=25;

            }else if(errors.get(i).equals("lowercase")){
                lower_error.setBounds(227,n,400,25);
                lower_error.setVisible(true);
                n+=25;

            }else if(errors.get(i).equals("symbol")){
                symbol_error.setBounds(227,n,400,50);
                symbol_error.setVisible(true);
                n+=25;

            }
        }
    }
}
