
package login.pkg001;

import View.Component.PanelCover ;
import View.Component.PanelLoginAndRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import net.miginfocom.swing.MigLayout ;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class Main extends javax.swing.JFrame {
    
    private MigLayout layout ;
    private PanelCover cover ;
    private PanelLoginAndRegister LoginAndRegister ;
    private boolean isLogin ;
    private final double addSize = 30 ;
    private final double coverSize = 40 ;
    private final double loginSize = 60 ;
    private final DecimalFormat df = new DecimalFormat("##0.###") ;
    
    
    public Main() {
        initComponents();
        init(); 
    }
    
    private void init(){
        layout = new MigLayout("fill , insets 0 ") ;
        cover = new PanelCover() ; 
        LoginAndRegister = new PanelLoginAndRegister() ;
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                    double fractionCover ;
                    double fractionLogin ;
                    double size = coverSize ;
                    if ( fraction <= 0.5f ) {
                        size += fraction * addSize ;
                    } else {
                        size += addSize - fraction * addSize ;
                    }
                    
                if ( isLogin ) {
                    fractionCover = 1f - fraction ;
                    fractionLogin = fraction ;
                    if (fraction >= 0.5f ) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100 );
                    }
                } else {
                    fractionCover = fraction ;
                    fractionLogin = 1f - fraction ;
                    if ( fraction <= 0.5f ) {
                        cover.registerLeft(fraction * 100 );
                    } else {
                        cover.loginLeft((1f-fraction) * 100 );
                    }
                }
                if ( fraction >= 0.5f ) {
                    LoginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover)) ;
                fractionLogin = Double.valueOf(df.format(fractionLogin)) ;
                layout.setComponentConstraints(cover, "width " +size+ "% , pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(LoginAndRegister, "width " +loginSize+ "% , pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
               isLogin = !isLogin ;
            }
            
        };
        Animator animator = new Animator(800, target) ;
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "% , pos 0al 0 n 100%") ;
        bg.add(LoginAndRegister, "width " +loginSize + "% , pos 1al 0 n 100%") ;
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !animator.isRunning() ) {
                    animator.start(); 
                }
            }
        } );
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
