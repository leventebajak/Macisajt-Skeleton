import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class MainMenuWindow extends JPanel {

    public MainMenuWindow() {
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        JLabel lTitle = new JLabel();
        JLabel lTeam = new JLabel();
        JButton bContinueGame = new JButton();
        JButton bNewGame = new JButton();
        JButton bLoadGame = new JButton();
        JButton bExitGame = new JButton();

        panel.setBackground(View.PRIMARY_COLOR);
        panel.setForeground(View.SECONDARY_COLOR);

        lTitle.setFont(new Font("Segoe UI", Font.BOLD, 60)); // NOI18N
        lTitle.setForeground(View.SECONDARY_COLOR);
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lTitle.setText("SIVATAGI VÍZHÁLÓZAT");

        lTeam.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 18)); // NOI18N
        lTeam.setForeground(View.SECONDARY_COLOR);
        lTeam.setHorizontalAlignment(SwingConstants.CENTER);
        lTeam.setText("macisajt csapat");

        bContinueGame.setBackground(View.SECONDARY_COLOR);
        bContinueGame.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 36)); // NOI18N
        bContinueGame.setForeground(View.PRIMARY_COLOR);
        bContinueGame.setText("JÁTÉK FOLYTATÁSA");
        bContinueGame.addActionListener(this::bContinueGameActionPerformed);

        bNewGame.setBackground(View.SECONDARY_COLOR);
        bNewGame.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 36)); // NOI18N
        bNewGame.setForeground(View.PRIMARY_COLOR);
        bNewGame.setText("ÚJ JÁTÉK INDÍTÁSA");
        bNewGame.addActionListener(this::bNewGameActionPerformed);

        bLoadGame.setBackground(View.SECONDARY_COLOR);
        bLoadGame.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 36)); // NOI18N
        bLoadGame.setForeground(View.PRIMARY_COLOR);
        bLoadGame.setText("KORÁBBI JÁTÉK BETÖLTÉSE");
        bLoadGame.addActionListener(this::bLoadGameActionPerformed);

        bExitGame.setBackground(View.SECONDARY_COLOR);
        bExitGame.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 36)); // NOI18N
        bExitGame.setForeground(View.PRIMARY_COLOR);
        bExitGame.setText("KILÉPÉS A PROGRAMBÓL");
        bExitGame.addActionListener(this::bExitGameActionPerformed);

        // Generated by NetBeans
        GroupLayout jPanel2Layout = new GroupLayout(panel);
        panel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lTitle, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lTeam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(bExitGame, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                        .addComponent(bLoadGame, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                        .addComponent(bContinueGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bNewGame, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(lTitle)
                                .addGap(91, 91, 91)
                                .addComponent(bContinueGame, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bNewGame, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bLoadGame, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bExitGame, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(lTeam, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        // End of generated code
    }

    private void bContinueGameActionPerformed(ActionEvent evt) {
        // TODO: automatikus mentés betöltése
    }

    private void bNewGameActionPerformed(ActionEvent evt) {
        View.setContentPane(new NewGameWindow());
    }

    private void bLoadGameActionPerformed(ActionEvent evt) {
        // TODO: korábbi játék betöltése gomb
    }

    private void bExitGameActionPerformed(ActionEvent evt) {
        View.FRAME.dispose();
    }
}
