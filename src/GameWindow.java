import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameWindow extends JPanel {

    public JPanel map;
    private JPanel playerPanel;
    public JLabel lRounds = new JLabel();
    public JMenuBar menuBar = new JMenuBar();
    public JLabel lCollectedValue = new JLabel();
    public JLabel lLeakedValue = new JLabel();

    /**
     * Korábbi játék betöltésekor használandó konstruktor.
     */
    GameWindow() {
        initComponents();
    }

    /**
     * Új játék indításakor használandó konstruktor.
     *
     * @param plumberNames  szerelők nevei
     * @param saboteurNames szabotőrök nevei
     */
    GameWindow(ArrayList<String> plumberNames, ArrayList<String> saboteurNames) {
        Game.NewGame(plumberNames, saboteurNames);
        initComponents();
    }

    private void initComponents() {
        map = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                View.drawAll(g);
            }
        };
        map.setBackground(View.SECONDARY_COLOR);
        map.setForeground(View.PRIMARY_COLOR);

        playerPanel = new JPanel(new BorderLayout());
        playerPanel.setPreferredSize(new Dimension(300, 500));

        // TODO: az első játékos paneljének betöltése (Game.getActivePlayer().drawNameAndButtons())
        setPlayerPanel(new SaboteurPanel(null));

        JPanel infoPanel = new JPanel();
        JSeparator separator = new JSeparator();
        JLabel lCollected = new JLabel();
        JLabel lLeaked = new JLabel();

        menuBar.setPreferredSize(new Dimension(76, 25));
        JMenu mFile = new JMenu();
        JMenuItem miExitToMenu = new JMenuItem();
        JMenuItem miExitProgram = new JMenuItem();
        JMenu mGame = new JMenu();
        JMenuItem miSaveGame = new JMenuItem();
        JMenuItem miLoadGame = new JMenuItem();
        mFile.setText("Fájl");
        miExitToMenu.setText("Kilépés a főmenübe");
        miExitToMenu.addActionListener(this::miExitToMenuActionPerformed);
        mFile.add(miExitToMenu);
        miExitProgram.setText("Kilépés a programból");
        miExitProgram.addActionListener(this::miExitProgramActionPerformed);
        mFile.add(miExitProgram);
        menuBar.add(mFile);
        mGame.setText("Játék");
        miSaveGame.setText("Mentés");
        miSaveGame.addActionListener(this::miSaveGameActionPerformed);
        mGame.add(miSaveGame);
        miLoadGame.setText("Betöltés");
        miLoadGame.addActionListener(this::miLoadGameActionPerformed);
        mGame.add(miLoadGame);
        menuBar.add(mGame);

        setBackground(View.PRIMARY_COLOR);
        setForeground(View.SECONDARY_COLOR);
        setPreferredSize(new Dimension(1280, 720));

        infoPanel.setBackground(View.PRIMARY_COLOR);
        infoPanel.setForeground(View.SECONDARY_COLOR);
        infoPanel.setPreferredSize(new Dimension(300, 720));

        separator.setForeground(View.SECONDARY_COLOR);

        lRounds.setFont(new Font("Segoe UI", Font.BOLD, 20)); // NOI18N
        lRounds.setForeground(View.SECONDARY_COLOR);
        lRounds.setHorizontalAlignment(SwingConstants.CENTER);
        // TODO: kör lekérdezése (getRound())
        lRounds.setText("2. Kör");

        lCollected.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16)); // NOI18N
        lCollected.setForeground(View.SECONDARY_COLOR);
        lCollected.setHorizontalAlignment(SwingConstants.LEFT);
        lCollected.setText("Kifolyt vízmennyiség:");

        lCollectedValue.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16)); // NOI18N
        lCollectedValue.setForeground(View.SECONDARY_COLOR);
        lCollectedValue.setHorizontalAlignment(SwingConstants.RIGHT);
        // TODO: kifolyt vízmennyiség beállítása
        lCollectedValue.setText("25");

        lLeaked.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16)); // NOI18N
        lLeaked.setForeground(View.SECONDARY_COLOR);
        lLeaked.setHorizontalAlignment(SwingConstants.LEFT);
        lLeaked.setText("Összegyűjtött vízmennyiség:");

        lLeakedValue.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16)); // NOI18N
        lLeakedValue.setForeground(View.SECONDARY_COLOR);
        lLeakedValue.setHorizontalAlignment(SwingConstants.RIGHT);
        // TODO: összegyűjtött vízmennyiség beállítása
        lLeakedValue.setText("15");

        // Generated by NetBeans
        GroupLayout jPanel2Layout = new GroupLayout(infoPanel);
        infoPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lLeaked, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lCollectedValue, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lCollected, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lLeakedValue, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(separator, GroupLayout.Alignment.TRAILING)
                                        .addComponent(lRounds, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(playerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lRounds, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lLeaked, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lCollectedValue, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lCollected, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lLeakedValue, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );
        GroupLayout MapLayout = new GroupLayout(map);
        map.setLayout(MapLayout);
        MapLayout.setHorizontalGroup(
                MapLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 954, Short.MAX_VALUE)
        );
        MapLayout.setVerticalGroup(
                MapLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(map, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(map, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        // End of generated code
    }

    public void setPlayerPanel(JPanel panel) {
        playerPanel.removeAll();
        playerPanel.add(panel, BorderLayout.CENTER);
    }

    private void miExitToMenuActionPerformed(ActionEvent evt) {
        // TODO: automatikus mentés
        View.FRAME.setJMenuBar(null);
        View.setContentPane(View.MAIN_MENU_WINDOW);
    }

    private void miExitProgramActionPerformed(ActionEvent evt) {
        // TODO: automatikus mentés
        View.FRAME.dispose();
    }

    private void miSaveGameActionPerformed(ActionEvent evt) {
        // TODO: játék mentése
    }

    private void miLoadGameActionPerformed(ActionEvent evt) {
        // TODO: játék betöltése
    }
}
