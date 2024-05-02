
package View.Component;

import com.raven.swing.MyPasswordField;
import com.raven.swing.MyTextField;
import java.awt.*;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.* ;
import net.miginfocom.swing.MigLayout;


public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
        
    public PanelLoginAndRegister() {
        initComponents();
        initRegister(); 
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }
    
    private void initRegister(){
        register.setLayout( new MigLayout( "wrap" , "push[center]push" , "push[]25[]10[]10[]push" ) );
        JLabel label = new JLabel("Create Account") ;
        label.setFont(new Font( "sansserif" , 1 , 30 ) );
        label.setForeground(new Color(7, 164, 121));
        register.add(label) ;
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/View/icon/user.png"))) ;
        txtUser.setHint("Name");
        register.add(txtUser , "w 60%") ;
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/View/icon/mail.png"))) ;
        txtEmail.setHint("Email");
        register.add(txtEmail , "w 60%") ;
        
        MyPasswordField txtPass = new MyPasswordField() ;
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/View/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass , "w 60%") ;
        
        JButton cmdRegister = new JButton() ;
        cmdRegister.setBackground(new Color(7, 164, 121));
        cmdRegister.setForeground(new Color(250, 250, 250));
        cmdRegister.setText("SIGN UP");
        register.add(cmdRegister, "w 40%, h 40");
        
//        Button cmd = new Button();
//        cmd.setBackground(new Color(7, 164, 121));
//        cmd.setForeground(new Color(250, 250, 250));
//        cmd.setName("SIGN UP");
//        register.add(cmd, "w 40%, h 40");
    }
    
    private void initLogin(){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/View/icon/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/View/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        
        JButton cmdLogin = new JButton();
        cmdLogin.setBackground(new Color(7, 164, 121));
        cmdLogin.setForeground(new Color(250, 250, 250));
        cmdLogin.setName("SIGN IN");
        login.add(cmdLogin, "w 40%, h 40");
        
//        Button cmd = new Button();
//        cmd.setBackground(new Color(7, 164, 121));
//        cmd.setForeground(new Color(250, 250, 250));
//        cmd.setName("SIGN IN");
//        login.add(cmd, "w 40%, h 40");
    }
    
     public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setName(""); // NOI18N

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
