package Controller;

import Model.Buku.*;
import View.Buku.View;

import java.awt.event.*;
import java.util.List;

public class Controller {
    View view;
    DAO dao;
    List<ModelBuku> data;

    public Controller(View view) {
        this.view = view;
        dao = new DAO();
        data = dao.getAll();
        view.setTable(data);

        view.getBtnTambah().addActionListener(e -> {
            dao.insert(view.getForm());
            refresh();
        });

        view.getBtnUpdate().addActionListener(e -> {
            int selected = view.getTabel().getSelectedRow();
            if (selected != -1) {
                ModelBuku buku = view.getForm();
                buku.setId(data.get(selected).getId());
                dao.update(buku);
                refresh();
            }
        });

        view.getBtnDelete().addActionListener(e -> {
            int selected = view.getTabel().getSelectedRow();
            if (selected != -1) {
                dao.delete(data.get(selected).getId());
                refresh();
            }
        });

        view.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.getTabel().getSelectedRow();
                if (row != -1) {
                    view.setForm(data.get(row));
                }
            }
        });
    }

    void refresh() {
        data = dao.getAll();
        view.setTable(data);
        view.resetForm();
    }
}
