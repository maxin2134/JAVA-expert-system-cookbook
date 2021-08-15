package aplikacja_se;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GUI extends javax.swing.JFrame {
    
    int numerPrzepisuGit = 0;
    int numerPrzepisuNope = 0;

    boolean okienko = true;
    boolean czyOstatni = false;
    
    ArrayList<Przepis> listaPrzepisowGit = new ArrayList<>();
    ArrayList<Przepis> listaPrzepisowNope = new ArrayList<>();  
    ArrayList<Skladnik> bazaSkladnikow = new ArrayList<>();
    ArrayList<Przepis> bazaPrzepisow = new ArrayList<>();
    ArrayList<Skladnik> kopiaBazaSkladnikow = new ArrayList<>();
    ArrayList<String> skladnikiUzytkownik = new ArrayList<>();
    
    
    public GUI() {
        initComponents();
        pobierzBazyDanych();
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("background.png").getImage().getScaledInstance(tlo.getWidth(), tlo.getHeight(), Image.SCALE_SMOOTH));
        tlo.setIcon(imageIcon);
        
        for (int i = 0; i < bazaSkladnikow.size(); i++){
            kopiaBazaSkladnikow.add(bazaSkladnikow.get(i));
        }
        
        pokazSkladniki();
        nastepnyPrzepisGit.setVisible(false);
        poprzedniPrzepisGit.setVisible(false);
        nastepnyPrzepisNope.setVisible(false);
        poprzedniPrzepisNope.setVisible(false);
        
        tytul_pola.setVisible(false);
        pole.setVisible(false);
        pole_tekstowe.setVisible(false);
        
        tytul_pola2.setVisible(false);
        pole2.setVisible(false);
        pole_tekstowe2.setVisible(false);
        main_tytul.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tytul = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        przycisk1 = new javax.swing.JButton();
        btn_wyszukaj = new javax.swing.JButton();
        pole = new javax.swing.JScrollPane();
        pole_tekstowe = new javax.swing.JTextPane();
        tytul_pola = new javax.swing.JLabel();
        tytul_pola2 = new javax.swing.JLabel();
        pole2 = new javax.swing.JScrollPane();
        pole_tekstowe2 = new javax.swing.JTextPane();
        main_tytul = new javax.swing.JLabel();
        nastepnyPrzepisGit = new javax.swing.JButton();
        poprzedniPrzepisGit = new javax.swing.JButton();
        nastepnyPrzepisNope = new javax.swing.JButton();
        poprzedniPrzepisNope = new javax.swing.JButton();
        wyborSkladnika = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        obraz = new javax.swing.JLabel();
        przycisk2 = new javax.swing.JButton();
        tlo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikacja");
        setBackground(new java.awt.Color(255, 255, 153));
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1550, 950));
        setName("okno"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tytul.setBackground(new java.awt.Color(255, 255, 255));
        tytul.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tytul.setText("Książka Kucharska");
        tytul.setMaximumSize(new java.awt.Dimension(342, 45));
        tytul.setMinimumSize(new java.awt.Dimension(342, 45));
        tytul.setName(""); // NOI18N
        tytul.setOpaque(true);
        tytul.setPreferredSize(new java.awt.Dimension(342, 45));
        getContentPane().add(tytul, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        text.setBackground(new java.awt.Color(255, 255, 153));
        text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        text.setText("Podaj składniki, a następnie naciśnij przycisk Wyszukaj przepis!");
        text.setOpaque(true);
        getContentPane().add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        przycisk1.setBackground(new java.awt.Color(255, 255, 255));
        przycisk1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        przycisk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikacja_se/dodaj.png"))); // NOI18N
        przycisk1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        przycisk1.setMaximumSize(new java.awt.Dimension(160, 30));
        przycisk1.setMinimumSize(new java.awt.Dimension(160, 30));
        przycisk1.setPreferredSize(new java.awt.Dimension(160, 30));
        przycisk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przycisk1ActionPerformed(evt);
            }
        });
        getContentPane().add(przycisk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 250, 50));

        btn_wyszukaj.setBackground(new java.awt.Color(255, 255, 255));
        btn_wyszukaj.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_wyszukaj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikacja_se/wyszukaj.png"))); // NOI18N
        btn_wyszukaj.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_wyszukaj.setPreferredSize(new java.awt.Dimension(150, 40));
        btn_wyszukaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_wyszukajActionPerformed(evt);
            }
        });
        getContentPane().add(btn_wyszukaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 60));

        pole.setEnabled(false);

        pole_tekstowe.setEditable(false);
        pole_tekstowe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pole_tekstowe.setMaximumSize(new java.awt.Dimension(6, 550));
        pole_tekstowe.setMinimumSize(new java.awt.Dimension(6, 550));
        pole_tekstowe.setPreferredSize(new java.awt.Dimension(6, 550));
        pole.setViewportView(pole_tekstowe);

        getContentPane().add(pole, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 440, 590));

        tytul_pola.setBackground(new java.awt.Color(255, 255, 153));
        tytul_pola.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        tytul_pola.setOpaque(true);
        tytul_pola.setPreferredSize(new java.awt.Dimension(350, 22));
        getContentPane().add(tytul_pola, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 440, -1));

        tytul_pola2.setBackground(new java.awt.Color(255, 255, 153));
        tytul_pola2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        tytul_pola2.setOpaque(true);
        tytul_pola2.setPreferredSize(new java.awt.Dimension(350, 22));
        getContentPane().add(tytul_pola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 190, 440, -1));

        pole_tekstowe2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pole_tekstowe2.setMaximumSize(new java.awt.Dimension(6, 550));
        pole_tekstowe2.setMinimumSize(new java.awt.Dimension(6, 550));
        pole_tekstowe2.setPreferredSize(new java.awt.Dimension(6, 550));
        pole_tekstowe2.setRequestFocusEnabled(false);
        pole2.setViewportView(pole_tekstowe2);

        getContentPane().add(pole2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 230, 440, 590));

        main_tytul.setBackground(new java.awt.Color(255, 255, 153));
        main_tytul.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        main_tytul.setText("Jeżeli dodasz dodatkowe składniki, to możesz zrobić:");
        main_tytul.setOpaque(true);
        main_tytul.setPreferredSize(new java.awt.Dimension(350, 25));
        getContentPane().add(main_tytul, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 150, 420, -1));

        nastepnyPrzepisGit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikacja_se/nastepny.png"))); // NOI18N
        nastepnyPrzepisGit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nastepnyPrzepisGit.setMaximumSize(new java.awt.Dimension(81, 23));
        nastepnyPrzepisGit.setMinimumSize(new java.awt.Dimension(81, 23));
        nastepnyPrzepisGit.setPreferredSize(new java.awt.Dimension(81, 23));
        nastepnyPrzepisGit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nastepnyPrzepisGitActionPerformed(evt);
            }
        });
        getContentPane().add(nastepnyPrzepisGit, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 840, 150, 40));

        poprzedniPrzepisGit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikacja_se/poprzedni.png"))); // NOI18N
        poprzedniPrzepisGit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        poprzedniPrzepisGit.setMaximumSize(new java.awt.Dimension(81, 23));
        poprzedniPrzepisGit.setMinimumSize(new java.awt.Dimension(81, 23));
        poprzedniPrzepisGit.setPreferredSize(new java.awt.Dimension(81, 23));
        poprzedniPrzepisGit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poprzedniPrzepisGitActionPerformed(evt);
            }
        });
        getContentPane().add(poprzedniPrzepisGit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 840, 150, 40));

        nastepnyPrzepisNope.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikacja_se/nastepny.png"))); // NOI18N
        nastepnyPrzepisNope.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nastepnyPrzepisNope.setMaximumSize(new java.awt.Dimension(81, 23));
        nastepnyPrzepisNope.setMinimumSize(new java.awt.Dimension(81, 23));
        nastepnyPrzepisNope.setPreferredSize(new java.awt.Dimension(81, 23));
        nastepnyPrzepisNope.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nastepnyPrzepisNopeActionPerformed(evt);
            }
        });
        getContentPane().add(nastepnyPrzepisNope, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 840, 150, 40));

        poprzedniPrzepisNope.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikacja_se/poprzedni.png"))); // NOI18N
        poprzedniPrzepisNope.setMargin(new java.awt.Insets(0, 0, 0, 0));
        poprzedniPrzepisNope.setMaximumSize(new java.awt.Dimension(81, 23));
        poprzedniPrzepisNope.setMinimumSize(new java.awt.Dimension(81, 23));
        poprzedniPrzepisNope.setPreferredSize(new java.awt.Dimension(81, 23));
        poprzedniPrzepisNope.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poprzedniPrzepisNopeActionPerformed(evt);
            }
        });
        getContentPane().add(poprzedniPrzepisNope, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 840, 150, 40));

        wyborSkladnika.setBackground(new java.awt.Color(255, 255, 254));
        wyborSkladnika.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wyborSkladnika.setMaximumRowCount(6);
        wyborSkladnika.setOpaque(false);
        wyborSkladnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyborSkladnikaActionPerformed(evt);
            }
        });
        getContentPane().add(wyborSkladnika, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 240, 30));

        tabela.setBackground(new java.awt.Color(255, 255, 254));
        tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nazwa składniku"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setRowHeight(20);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 254, 327));
        getContentPane().add(obraz, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 190, 190));

        przycisk2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        przycisk2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikacja_se/usuń.png"))); // NOI18N
        przycisk2.setActionCommand("Usuń składnik");
        przycisk2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        przycisk2.setMaximumSize(new java.awt.Dimension(157, 30));
        przycisk2.setMinimumSize(new java.awt.Dimension(157, 30));
        przycisk2.setPreferredSize(new java.awt.Dimension(160, 30));
        przycisk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przycisk2ActionPerformed(evt);
            }
        });
        getContentPane().add(przycisk2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 250, 50));

        tlo.setMaximumSize(new java.awt.Dimension(1550, 842));
        tlo.setMinimumSize(new java.awt.Dimension(1550, 842));
        tlo.setPreferredSize(new java.awt.Dimension(1550, 842));
        getContentPane().add(tlo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 950));
        tlo.getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void przycisk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przycisk1ActionPerformed
       
        Object wybranySkladnik = wyborSkladnika.getSelectedItem();
        int kwak = wyborSkladnika.getSelectedIndex();
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        Object[] kolumna = new Object[1];
        kolumna[0] = wybranySkladnik.toString();
        model.addRow(kolumna);
        wyborSkladnika.removeAllItems();
        bazaSkladnikow.remove(kwak);
        pokazSkladniki();
        
    }//GEN-LAST:event_przycisk1ActionPerformed

    private void btn_wyszukajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_wyszukajActionPerformed
        ArrayList<Przepis> tmpListaRowne = new ArrayList<>();
        ArrayList<Przepis> tmpListaBrak = new ArrayList<>();
        ArrayList<Przepis> tmpListaNadmiar = new ArrayList<>();
        
            
            ukryjPrzepisy();
//            lacznaSuma = 0;
            numerPrzepisuGit = 0;
            numerPrzepisuNope = 0;
            tmpListaRowne.clear();
            tmpListaBrak.clear();
            tmpListaNadmiar.clear();
            listaPrzepisowGit.clear();
            listaPrzepisowNope.clear();
            skladnikiUzytkownik.clear();
            okienko = true;


            for (int j = 0; j < tabela.getRowCount(); j++){
                Object wskaznik = tabela.getValueAt(j, 0);
                String nazwaSkladnika = wskaznik.toString();
                skladnikiUzytkownik.add(nazwaSkladnika);
            }
            
            
            Przepis tmpPrzepis;        
            
            for ( int i = 0 ; i < bazaPrzepisow.size(); i++){
            tmpPrzepis = bazaPrzepisow.get(i);
                if (tabela.getRowCount() == tmpPrzepis.get_suma()){
                tmpListaRowne.add(tmpPrzepis);
                }
                else if (tmpPrzepis.get_suma() < tabela.getRowCount()) {
                tmpListaBrak.add(tmpPrzepis);
                }
                else if (tmpPrzepis.get_suma() > tabela.getRowCount()){
                tmpListaNadmiar.add(tmpPrzepis);
                }
            }
            przeszukajListeRowna(tmpListaRowne);
            przeszukajListeNad(tmpListaNadmiar);
            przeszukajListeBrak(tmpListaBrak);
                        
            if (listaPrzepisowGit.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nie znaleziono żadnego przepisu! Dodaj więcej składników.", "Informacja", JOptionPane.ERROR_MESSAGE);
            }else{
                wstawDobryPrzepis(listaPrzepisowGit.get(0));
                okienko = false;
            }
            
            if (listaPrzepisowNope.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nie znaleziono żadnego przepisu, do którego niewiele Tobie brakuje! Zmień składniki lub dodaj więcej składników.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }else{
                wstawOpcjonalnyPrzepis(listaPrzepisowNope.get(0));
            }
    }//GEN-LAST:event_btn_wyszukajActionPerformed

    private void nastepnyPrzepisGitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nastepnyPrzepisGitActionPerformed
        Przepis tmpPrzepis;
        if (numerPrzepisuGit < listaPrzepisowGit.size() - 1){
            numerPrzepisuGit++;
            tmpPrzepis = listaPrzepisowGit.get(numerPrzepisuGit);
            wstawDobryPrzepis(tmpPrzepis);
        }else{
            JOptionPane.showMessageDialog(null, "To już ostatni dostępny przepis!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_nastepnyPrzepisGitActionPerformed

    private void poprzedniPrzepisGitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poprzedniPrzepisGitActionPerformed
        Przepis tmpPrzepis;
        if (numerPrzepisuGit > 0){
            numerPrzepisuGit--;
            tmpPrzepis = listaPrzepisowGit.get(numerPrzepisuGit);
            wstawDobryPrzepis(tmpPrzepis);
        }else{
            JOptionPane.showMessageDialog(null, "Znajdujesz się na początku listy dostępnych przepisów!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_poprzedniPrzepisGitActionPerformed

    private void nastepnyPrzepisNopeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nastepnyPrzepisNopeActionPerformed
        Przepis tmpPrzepis;
        if (numerPrzepisuNope < listaPrzepisowNope.size() - 1){
            numerPrzepisuNope++;
            tmpPrzepis = listaPrzepisowNope.get(numerPrzepisuNope);
            wstawOpcjonalnyPrzepis(tmpPrzepis);
        }else{
            JOptionPane.showMessageDialog(null, "To już ostatni dostępny przepis!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        }                   
    }//GEN-LAST:event_nastepnyPrzepisNopeActionPerformed

    private void poprzedniPrzepisNopeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poprzedniPrzepisNopeActionPerformed
    Przepis tmpPrzepis;
    if (numerPrzepisuNope > 0){
        numerPrzepisuNope--;
        tmpPrzepis = listaPrzepisowNope.get(numerPrzepisuNope);
        wstawOpcjonalnyPrzepis(tmpPrzepis);
    }else{
        JOptionPane.showMessageDialog(null, "Znajdujesz się na początku listy dostępnych przepisów!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_poprzedniPrzepisNopeActionPerformed

    private void przycisk2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przycisk2ActionPerformed

        int wybor = tabela.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        Object buu = model.getValueAt(wybor, 0);
        String string = buu.toString();
        for (int i = 0; i < kopiaBazaSkladnikow.size(); i++){
            Skladnik tmp = kopiaBazaSkladnikow.get(i);
                if (tmp.getNazwa().equals(string)){ 
                    bazaSkladnikow.add(tmp);
                    break;
                }
        }
        
        model.removeRow(wybor);
        wyborSkladnika.removeAllItems();
        pokazSkladniki();
    }//GEN-LAST:event_przycisk2ActionPerformed

    private void wyborSkladnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyborSkladnikaActionPerformed
        String path = "";
        int liczba = wyborSkladnika.getSelectedIndex();
        String nazwa = wyborSkladnika.getItemAt(liczba);
        path = "obrazy\\" + nazwa + ".png";
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(path).getImage());
        obraz.setIcon(imageIcon);
        obraz.setHorizontalAlignment(JLabel.CENTER);
        obraz.setVerticalAlignment(JLabel.CENTER);
    }//GEN-LAST:event_wyborSkladnikaActionPerformed

    int znajdzPrzepis(Przepis przepis){
        String[] tmpTablicaSkladnikow;
        String tmpNazwa = "";

        int stan = 0;
        int licznik = 0;

        tmpTablicaSkladnikow = przepis.getTabNazwySkaldnikow();

        for (int i = 0; i < przepis.get_suma(); i++){
            tmpNazwa = tmpTablicaSkladnikow[i];
            for (int j = 0; j < skladnikiUzytkownik.size(); j++){
                if((tmpNazwa.equals(skladnikiUzytkownik.get(j))) && (!tmpNazwa.equals("pusty"))){
                    licznik++;
                }
            }         
        }

        if (licznik == przepis.get_suma()){
            stan = 1;
        }else if (licznik == przepis.get_suma()-2 || licznik == przepis.get_suma()-1 || licznik == przepis.get_suma()-3){
            stan = 2;
        }else{
            stan = 3;
        }

        return stan;
    }


    void przeszukajListeRowna(ArrayList<Przepis> rowna){
        Przepis tmpPrzepis;
        int numer = 1;
        int wynik = 0;
            for (int i = 0; i < rowna.size(); i++){
            tmpPrzepis = rowna.get(i);
            wynik = znajdzPrzepis(tmpPrzepis);
            if (numer == wynik){
                listaPrzepisowGit.add(tmpPrzepis);
            }else if (numer+1 == wynik) {
                listaPrzepisowNope.add(tmpPrzepis);
            }else{}
        }
    }

    void przeszukajListeNad(ArrayList<Przepis> nadmiar){
        Przepis tmpPrzepis;
        int numer = 1;
        int wynik = 0;
            for (int i = 0; i < nadmiar.size(); i++){
            tmpPrzepis = nadmiar.get(i);
            wynik = znajdzPrzepis(tmpPrzepis);
            if (numer == wynik){
                listaPrzepisowGit.add(tmpPrzepis);
            }else if (numer+1 == wynik) {
                listaPrzepisowNope.add(tmpPrzepis);
            }else{}
        }
    }

    void przeszukajListeBrak (ArrayList<Przepis> brakujace){
        Przepis tmpPrzepis;
        int numer = 1;
        int wynik = 0;
            for (int i = 0; i < brakujace.size(); i++){
            tmpPrzepis = brakujace.get(i);
            wynik = znajdzPrzepis(tmpPrzepis);
            if (numer == wynik){
                listaPrzepisowGit.add(tmpPrzepis);
            }else if (numer+1 == wynik) {
                listaPrzepisowNope.add(tmpPrzepis);
            }else{}
        }
    }

    void wstawDobryPrzepis(Przepis przepis){
        tytul_pola.setVisible(true);
        pole.setVisible(true);
        pole_tekstowe.setVisible(true); 
        tytul_pola.setText(przepis.get_nazwa_przepisu());
        pole_tekstowe.setText(przepis.get_opis_przepisu());
        nastepnyPrzepisGit.setVisible(true);
        poprzedniPrzepisGit.setVisible(true);
        if (okienko)JOptionPane.showMessageDialog(null, "Znaleziono przepis!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
    }

    void wstawOpcjonalnyPrzepis(Przepis przepis){
        main_tytul.setVisible(true);
        tytul_pola2.setVisible(true);
        pole2.setVisible(true);
        pole_tekstowe2.setVisible(true);
        tytul_pola2.setText(przepis.get_nazwa_przepisu());
        pole_tekstowe2.setText(przepis.get_opis_przepisu());
        nastepnyPrzepisNope.setVisible(true);
        poprzedniPrzepisNope.setVisible(true);
    }

    void pobierzBazyDanych(){
        Connection c = null;

            try {
                c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Adrian\\Desktop\\ksiazka_kucharska.db");

                 Statement st = c.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM Przepisy;");
                 Przepis przepis;
                 while(rs.next()){
                    przepis = new Przepis(rs.getInt("id_przepisu"), rs.getString("nazwa_przepisu"), rs.getString("skladnik1"), rs.getString("skladnik2"), rs.getString("skladnik3"),
                            rs.getString("skladnik4"), rs.getString("skladnik5"), rs.getString("skladnik6"), rs.getString("skladnik7"), rs.getString("skladnik8"),
                            rs.getString("skladnik9"), rs.getString("opis_przepisu"), rs.getInt("suma"));
                    bazaPrzepisow.add(przepis);
                 }

                 rs = st.executeQuery("SELECT * FROM Skladniki;");
                 Skladnik skladnik;
                 while(rs.next()){
                     skladnik = new Skladnik(rs.getInt("id"), rs.getString("nazwa"), rs.getString("sciezka"));
                     bazaSkladnikow.add(skladnik);
                 }
                 
                 c.close();
                } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Problem");
                }
    }

    void ukryjPrzepisy(){
        tytul_pola.setVisible(false);
        pole.setVisible(false);
        pole_tekstowe.setVisible(false); 
        nastepnyPrzepisGit.setVisible(false);
        poprzedniPrzepisGit.setVisible(false);
        main_tytul.setVisible(false);
        tytul_pola2.setVisible(false);
        pole2.setVisible(false);
        pole_tekstowe2.setVisible(false);
        nastepnyPrzepisNope.setVisible(false);
        poprzedniPrzepisNope.setVisible(false);
    }

    void pokazSkladniki(){
        DefaultComboBoxModel model = (DefaultComboBoxModel)wyborSkladnika.getModel();
        Object kolumna = new Object();
        for(int i = 0; i < bazaSkladnikow.size(); i++){
            kolumna = bazaSkladnikow.get(i).getNazwa();
            model.addElement(kolumna);
        }
        
        if(bazaSkladnikow.isEmpty()){
            czyOstatni = true;
            przycisk1.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Koniec listy składników!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            czyOstatni = false;
            przycisk1.setEnabled(true);
        }
        
        wyborSkladnika.setSelectedIndex(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_wyszukaj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel main_tytul;
    private javax.swing.JButton nastepnyPrzepisGit;
    private javax.swing.JButton nastepnyPrzepisNope;
    private javax.swing.JLabel obraz;
    private javax.swing.JScrollPane pole;
    private javax.swing.JScrollPane pole2;
    private javax.swing.JTextPane pole_tekstowe;
    private javax.swing.JTextPane pole_tekstowe2;
    private javax.swing.JButton poprzedniPrzepisGit;
    private javax.swing.JButton poprzedniPrzepisNope;
    private javax.swing.JButton przycisk1;
    private javax.swing.JButton przycisk2;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel text;
    private javax.swing.JLabel tlo;
    private javax.swing.JLabel tytul;
    private javax.swing.JLabel tytul_pola;
    private javax.swing.JLabel tytul_pola2;
    private javax.swing.JComboBox<String> wyborSkladnika;
    // End of variables declaration//GEN-END:variables
}

//    boolean czyJestGitCyfra = true;
//  try{
//             if("".equals(ilosc1.getText()))
//                 tabLiczbaUzytkownik[0] = 0;
//             else
//                tabLiczbaUzytkownik[0] = Integer.parseInt(ilosc1.getText());
//             
//             if("".equals(ilosc2.getText()))
//                 tabLiczbaUzytkownik[1] = 0;
//             else
//                tabLiczbaUzytkownik[1] = Integer.parseInt(ilosc2.getText());
//             
//             if("".equals(ilosc3.getText()))
//                 tabLiczbaUzytkownik[2] = 0;
//             else
//                tabLiczbaUzytkownik[2] = Integer.parseInt(ilosc3.getText());
//             
//             if("".equals(ilosc4.getText()))
//                 tabLiczbaUzytkownik[3] = 0;
//             else
//                tabLiczbaUzytkownik[3] = Integer.parseInt(ilosc4.getText());
//             
//             if("".equals(ilosc5.getText()))
//                 tabLiczbaUzytkownik[4] = 0;
//             else
//                tabLiczbaUzytkownik[4] = Integer.parseInt(ilosc5.getText());
//             
//             if("".equals(ilosc6.getText()))
//                 tabLiczbaUzytkownik[5] = 0;
//             else
//                tabLiczbaUzytkownik[5] = Integer.parseInt(ilosc6.getText());
//             
//             if("".equals(ilosc7.getText()))
//                 tabLiczbaUzytkownik[6] = 0;
//             else
//                tabLiczbaUzytkownik[6] = Integer.parseInt(ilosc7.getText());
//             
//             if("".equals(ilosc8.getText()))
//                 tabLiczbaUzytkownik[7] = 0;
//             else
//                tabLiczbaUzytkownik[7] = Integer.parseInt(ilosc8.getText());
//             
//             if("".equals(ilosc9.getText()))
//                 tabLiczbaUzytkownik[8] = 0;
//             else
//                tabLiczbaUzytkownik[8] = Integer.parseInt(ilosc9.getText());
//             
//             if("".equals(ilosc10.getText()))
//                 tabLiczbaUzytkownik[9] = 0;
//             else
//                tabLiczbaUzytkownik[9] = Integer.parseInt(ilosc10.getText());
//             czyJestGitCyfra = true;
//        } catch(NumberFormatException nfe){
//            JOptionPane.showMessageDialog(null, "Podana wartość ilości nie jest liczbą. Popraw dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
//            czyJestGitCyfra = false;
//            
//        }


//    boolean czyJestGitNapis = true;
// try{
//             if("".equals(skladnik1.getText()))
//                 tabSkladnikiUzytkownik[0] = "pusty";
//             else{
//                 String tmp;
//                 tmp = tabSkladnikiUzytkownik[0] = skladnik1.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             if("".equals(skladnik2.getText()))
//                 tabSkladnikiUzytkownik[1] = "pusty";
//             else
//             {
//                 String tmp;
//                 tmp = tabSkladnikiUzytkownik[1] = skladnik2.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik3.getText().toLowerCase()))
//                 tabSkladnikiUzytkownik[2] = "pusty";
//             else
//                 {
//                 String tmp;
//                 tmp = tabSkladnikiUzytkownik[2] = skladnik3.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik4.getText()))
//                 tabSkladnikiUzytkownik[3] = "pusty";
//             else
//                 {
//                 String tmp;     
//                 tmp = tabSkladnikiUzytkownik[3] = skladnik4.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik5.getText()))
//                 tabSkladnikiUzytkownik[4] = "pusty";
//             else
//                 {
//                 String tmp;    
//                 tmp = tabSkladnikiUzytkownik[4] = skladnik5.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik6.getText()))
//                 tabSkladnikiUzytkownik[5] = "pusty";
//             else
//                {
//                 String tmp;   
//                 tmp = tabSkladnikiUzytkownik[5] = skladnik6.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik7.getText()))
//                 tabSkladnikiUzytkownik[6] = "pusty";
//             else
//                 {
//                 String tmp;    
//                 tmp = tabSkladnikiUzytkownik[6] = skladnik7.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik8.getText()))
//                 tabSkladnikiUzytkownik[7] = "pusty";
//             else
//                 {
//                 String tmp;    
//                 tmp = tabSkladnikiUzytkownik[7] = skladnik8.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik9.getText()))
//                 tabSkladnikiUzytkownik[8] = "pusty";
//             else
//                 {
//                 String tmp;    
//                 tmp = tabSkladnikiUzytkownik[8] = skladnik9.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//             }
//             
//             if("".equals(skladnik10.getText()))
//                 tabSkladnikiUzytkownik[9] = "pusty";
//             else
//                 {
//                 String tmp;    
//                 tmp = tabSkladnikiUzytkownik[9] = skladnik10.getText().toLowerCase();
//                 if (znajdzLiczbeString(tmp)){
//                     throw new Exception("");
//                 }else{
//                 lacznaSuma++;}
//                 
//             }
//            czyJestGitNapis = true;
//            }catch(Exception e){
//                 JOptionPane.showMessageDialog(null, "W którymś ze składników znajduje się cyfra/liczba!", "Błąd", JOptionPane.OK_OPTION);
//                 czyJestGitNapis = false;
//             }