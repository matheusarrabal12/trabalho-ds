package controller;

import models.Contato;
import data.ContatoRepository;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterAbortException;
import java.util.List;

public class ContatoController {
    private ContatoRepository repository;
    private ContatoTableView tableView;

    public ContatoController() {
        repository = new ContatoRepository();
        tableView = new ContatoTableView();
        inicializar();
    }

    private void inicializar() {
        atualizarTabela();

        JToolBar toolBar = new JToolBar();
        JButton adicionarButton = new JButton("Adicionar");
        JButton editarButton = new JButton("Editar");
        JButton deletarButton = new JButton("Deletar");
        toolBar.add(adicionarButton);
        toolBar.add(editarButton);
        toolBar.add(deletarButton);

        tableView.add(toolBar, java.awt.BorderLayout.NORTH);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarContato();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarContato();
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarContato();
            }
        });
    }

    private void atualizarTabela() {
        List<Contato> contatos = repository.obterTodosContatos();
        tableView.atualizarTabela(contatos);
    }

    private void adicionarContato() {
        ContatoForm form = new ContatoForm(tableView, "Adicionar Contato");
        form.setVisible(true);
        Contato novoContato = form.getContato();
        if (novoContato != null) {
            repository.adicionarContato(novoContato);
            atualizarTabela();
        }
    }
}
