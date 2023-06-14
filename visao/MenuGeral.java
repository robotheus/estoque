package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistencia.*;

public class MenuGeral extends JFrame {
    private JCheckBox setorBox;
    private JCheckBox userBox;
    private JCheckBox bemBox;
    private JCheckBox trocaBox;
    private JButton selecionarBotao;
    private JButton sairBotao;

    public MenuGeral(BancoDeDados banco) {
        setTitle("Stocker - Menu Geral");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setorBox = new JCheckBox("Setor");
        userBox = new JCheckBox("Usuario");
        bemBox = new JCheckBox("Bem");
        trocaBox = new JCheckBox("Troca");

        selecionarBotao = new JButton("Avancar");
        sairBotao = new JButton("Sair");

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JPanel boxesPainel = new JPanel();
        boxesPainel.add(setorBox);
        boxesPainel.add(userBox);
        boxesPainel.add(bemBox);
        boxesPainel.add(trocaBox);
        painel.add(boxesPainel, BorderLayout.CENTER);

        JPanel botoesPainel = new JPanel();
        botoesPainel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botoesPainel.add(selecionarBotao);
        botoesPainel.add(sairBotao);
        painel.add(botoesPainel, BorderLayout.SOUTH);
        
        getContentPane().add(painel);

        selecionarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (setorBox.isSelected()){
                    new VisaoSetor(painel);
                } else if (userBox.isSelected()){
                    new VisaoUsuario(painel);
                } else if (bemBox.isSelected()){
                    new VisaoBem(painel);
                } else if (trocaBox.isSelected()){
                    new VisaoTroca(painel);
                }
            }
        });

        sairBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ActionListener checkboxListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setorBox && setorBox.isSelected()) {
                    userBox.setSelected(false);
                    bemBox.setSelected(false);
                    trocaBox.setSelected(false);
                } else if (e.getSource() == userBox && userBox.isSelected()) {
                    setorBox.setSelected(false);
                    bemBox.setSelected(false);
                    trocaBox.setSelected(false);
                } else if (e.getSource() == bemBox && bemBox.isSelected()) {
                    setorBox.setSelected(false);
                    userBox.setSelected(false);
                    trocaBox.setSelected(false);
                } else if (e.getSource() == trocaBox && trocaBox.isSelected()) {
                    setorBox.setSelected(false);
                    userBox.setSelected(false);
                    bemBox.setSelected(false);
                }
            }
        };

        setorBox.addActionListener(checkboxListener);
        userBox.addActionListener(checkboxListener);
        bemBox.addActionListener(checkboxListener);
        trocaBox.addActionListener(checkboxListener);

        setVisible(true);
    }
}
