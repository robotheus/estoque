package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisaoTroca extends JFrame {
    private JCheckBox cadastrarBox;
    private JCheckBox alterarBox;
    private JCheckBox finalizarBox;
    private JCheckBox visualizarBox;
    private JButton selecionarBotao;
    private JButton voltarBotao;
    
    public VisaoTroca(JPanel painelAnterior) {
        setTitle("Stocker - Menu Troca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        cadastrarBox = new JCheckBox("Realizar troca");
        alterarBox = new JCheckBox("Alterar troca");
        finalizarBox = new JCheckBox("Finalizar troca");
        visualizarBox = new JCheckBox("Visualizar troca");

        selecionarBotao = new JButton("Avancar");
        voltarBotao = new JButton("Voltar");

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JPanel boxesPainel = new JPanel();
        boxesPainel.add(cadastrarBox);
        boxesPainel.add(alterarBox);
        boxesPainel.add(finalizarBox);
        boxesPainel.add(visualizarBox);
        painel.add(boxesPainel, BorderLayout.CENTER);

        JPanel botoesPainel = new JPanel();
        botoesPainel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botoesPainel.add(selecionarBotao);
        botoesPainel.add(voltarBotao);
        painel.add(botoesPainel, BorderLayout.SOUTH);
        
        getContentPane().add(painel);

        selecionarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        voltarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                painelAnterior.setVisible(true);
            }
        });

        ActionListener checkboxListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cadastrarBox && cadastrarBox.isSelected()) {
                    alterarBox.setSelected(false);
                    finalizarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == alterarBox && alterarBox.isSelected()) {
                    cadastrarBox.setSelected(false);
                    finalizarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == finalizarBox && finalizarBox.isSelected()) {
                    cadastrarBox.setSelected(false);
                    alterarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == visualizarBox && visualizarBox.isSelected()) {
                    cadastrarBox.setSelected(false);
                    alterarBox.setSelected(false);
                    finalizarBox.setSelected(false);
                }
            }
        };

        cadastrarBox.addActionListener(checkboxListener);
        alterarBox.addActionListener(checkboxListener);
        finalizarBox.addActionListener(checkboxListener);
        visualizarBox.addActionListener(checkboxListener);

        setVisible(true);
    }
}
